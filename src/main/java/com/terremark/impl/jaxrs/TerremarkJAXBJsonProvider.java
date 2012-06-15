/**
 * Copyright 2012 Terremark Worldwide Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.terremark.impl.jaxrs;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.jaxrs.Annotations;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.map.util.StdDateFormat;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import com.terremark.api.SupportedVersions;
import com.terremark.api.VersionInfo;
import com.terremark.impl.TerremarkConstants;

/**
 * Custom JAXB JSON provider to deal with Terremark specific content type and custom deserialization.
 * <p/>
 * NOTE: This is currently work-in-progress. JSON content-type does not currently work.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
@Provider
@Produces({TerremarkConstants.TERREMARK_MEDIA_TYPE_WILDCARD})
@Consumes({TerremarkConstants.TERREMARK_MEDIA_TYPE_WILDCARD})
public final class TerremarkJAXBJsonProvider extends JacksonJsonProvider {
    /** Deserializer version */
    private static final Version DESERIALIZERS_VERSION = new Version(1, 0, 0, null);

    /**
     * Default constructor. Registers the deserializer modules.
     */
    public TerremarkJAXBJsonProvider() {
        super(createObjectMapper(), new Annotations[] {Annotations.JAXB});
    }

    /**
     * Terremark content type uses special "application/vnd.tmrk..." format to indicate the type of response object.
     * This does not work well with the Jackson JSON provider. So override this method and make sure that content can be
     * read.
     *
     * @see org.codehaus.jackson.jaxrs.JacksonJsonProvider#isReadable(java.lang.Class, java.lang.reflect.Type,
     * java.lang.annotation.Annotation[], javax.ws.rs.core.MediaType)
     */
    @Override
    public boolean isReadable(final Class<?> type, final Type genericType, final Annotation[] annotations,
                    final MediaType mediaType) {
        return super.isReadable(type, genericType, annotations, mediaType)
                        || mediaType.getSubtype().startsWith(TerremarkConstants.TERREMARK_SUB_TYPE_PREFIX);
    }

    /**
     * Configures the mapper and adds the custom deserialization modules.
     *
     * @return Object mapper.
     */
    private static ObjectMapper createObjectMapper() {
        final ObjectMapper mapper = new ObjectMapper();

        final SimpleModule svModule = new SimpleModule("SupportedVersionsDeserializer", DESERIALIZERS_VERSION);
        svModule.addDeserializer(SupportedVersions.class, new SupportedVersionsDeserializer());
        mapper.registerModule(svModule);

        final SimpleModule dateModule = new SimpleModule("XMLGregorianCalendarDeserializer", DESERIALIZERS_VERSION);
        dateModule.addDeserializer(XMLGregorianCalendar.class, new XMLGregorianCalendarDeserializer());
        mapper.registerModule(dateModule);

        mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        mapper.setDateFormat(StdDateFormat.getBlueprintISO8601Format());
        mapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector());

        return mapper;
    }

    /**
     * Custom JSON deserializer for {@code SupportedVersions}.
     *
     * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
     */
    static class SupportedVersionsDeserializer extends JsonDeserializer<SupportedVersions> {
        /**
         * (non-Javadoc)
         *
         * @see org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson.JsonParser,
         * org.codehaus.jackson.map.DeserializationContext)
         */
        @Override
        public SupportedVersions deserialize(final JsonParser jp, final DeserializationContext ctxt)
                        throws IOException, JsonProcessingException {
            final List<VersionInfo> versions = ctxt.getParser().readValueAs(new TypeReference<List<VersionInfo>>() {
                // There is nothing to implement. This anonymous class is used just to pass the Java Generic
                // information to the reader. In this case, the generic information is List<VersionInfo>
            });

            final SupportedVersions sv = new SupportedVersions();
            sv.getVersionInfos().addAll(versions);

            return sv;
        }
    }

    /**
     * Custom JSON deserializer for {@code XMLGregorianCalendar}.
     *
     * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
     */
    static class XMLGregorianCalendarDeserializer extends JsonDeserializer<XMLGregorianCalendar> {
        /** JSON date prefix */
        private static final String JSON_DATE_PREFIX = "/Date(";
        /** Date prefix length */
        private static final int JSON_DATE_PREFIX_LENGTH = JSON_DATE_PREFIX.length();
        /** JSON date suffix */
        private static final String JSON_DATE_SUFFIX = ")/";
        /** Date suffix length */
        private static final int JSON_DATE_SUFFIX_LENGTH = JSON_DATE_SUFFIX.length();
        /** Cached data type factory for creating gregorian calendar */
        private static final DatatypeFactory DATA_TYPE_FACTORY;

        static {
            try {
                DATA_TYPE_FACTORY = DatatypeFactory.newInstance();
            } catch (final DatatypeConfigurationException ex) {
                throw new IllegalArgumentException(ex);
            }
        }

        /**
         * (non-Javadoc)
         *
         * @see org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson.JsonParser,
         * org.codehaus.jackson.map.DeserializationContext)
         */
        @Override
        public XMLGregorianCalendar deserialize(final JsonParser jp, final DeserializationContext ctxt)
                        throws IOException, JsonProcessingException {
            if (jp.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = jp.getText().trim();

                if (text.startsWith(JSON_DATE_PREFIX) && text.endsWith(JSON_DATE_SUFFIX)) {
                    text = text.substring(JSON_DATE_PREFIX_LENGTH, text.length() - JSON_DATE_SUFFIX_LENGTH);

                    final GregorianCalendar gc = new GregorianCalendar();
                    gc.setTimeInMillis(Long.parseLong(text));

                    return DATA_TYPE_FACTORY.newXMLGregorianCalendar(gc);
                }
            }

            throw ctxt.mappingException(XMLGregorianCalendar.class, jp.getCurrentToken());
        }
    }
}