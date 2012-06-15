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

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.apache.wink.common.internal.providers.entity.xml.JAXBXmlProvider;

import com.terremark.impl.TerremarkConstants;

/**
 * Custom JAXB XML provider to deal with Terremark specific content type.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
@Provider
@Produces({TerremarkConstants.TERREMARK_MEDIA_TYPE_WILDCARD})
@Consumes({TerremarkConstants.TERREMARK_MEDIA_TYPE_WILDCARD})
public final class TerremarkJAXBXmlProvider extends JAXBXmlProvider {
    /**
     * Terremark content type uses special "application/vnd.tmrk..." format to indicate the type of response object.
     * This does not work well with the built in JAXB XML provider. So override this method and make sure that content
     * can be read.
     *
     * @see org.apache.wink.common.internal.providers.entity.xml.JAXBXmlProvider#isReadable(java.lang.Class,
     * java.lang.reflect.Type, java.lang.annotation.Annotation[], javax.ws.rs.core.MediaType)
     */
    @Override
    public boolean isReadable(final Class<?> type, final Type genericType, final Annotation[] annotations,
                    final MediaType mediaType) {
        return super.isReadable(type, genericType, annotations, mediaType)
                        || mediaType.getSubtype().startsWith(TerremarkConstants.TERREMARK_SUB_TYPE_PREFIX);
    }
}