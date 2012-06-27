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
package com.terremark.exception;

import org.apache.wink.client.ClientWebException;

import com.terremark.api.TerremarkError;

/**
 * Base class for all Terremark exceptions.
 *
 * @author <a href="mailto:spasam@terremark.com">Seshu Pasam</a>
 */
public class TerremarkException extends Exception {
    /** Serial version UID */
    private static final long serialVersionUID = -3122867335967175560L;
    /** Terremark error with error code and message */
    private final TerremarkError error;

    /**
     * Constructor that take Terremark error and Apache Wink exception.
     *
     * @param error Terremark error with error code and message.
     * @param cause Root cause.
     */
    public TerremarkException(final TerremarkError error, final ClientWebException cause) {
        super(getErrorText(error, cause), cause);
        this.error = error;
    }

    /**
     * Constructor for creating generic exception.
     *
     * @param message Error message.
     */
    public TerremarkException(final String message) {
        super(message);
        this.error = null;
    }

    /**
     * Constructor that takes error message and root cause.
     *
     * @param message Error message.
     * @param cause Root cause.
     */
    public TerremarkException(final String message, final Throwable cause) {
        super(message, cause);
        this.error = null;
    }

    /**
     * Constructor that takes root cause.
     *
     * @param cause Root cause.
     */
    public TerremarkException(final Throwable cause) {
        super(cause);
        this.error = null;
    }

    /**
     * Returns the major error code returned by Terremark. Or {@code -1} is returned, if Terremark error is not available.
     *
     * @return Major error code or {@code -1}.
     */
    public final int getMajorErrorCode() {
        if (error == null) {
            return -1;
        }

        return error.getMajorErrorCode();
    }

    /**
     * Returns the minor error code returned by Terremark. Or {@code null} is returned, if Terremark error is not available.
     *
     * @return Minor error code or {@code null}.
     */
    public final String getMinorErrorCode() {
        if (error == null) {
            return null;
        }

        return error.getMinorErrorCode();
    }

    /**
     * Returns the error message returned by Terremark. Or {@code null} is returned, if Terremark error is not available.
     *
     * @return Error message or {@code null}.
     */
    public final String getErrorMessage() {
        if (error == null) {
            return null;
        }

        return error.getMessage();
    }

    /**
     * Helper method to create a readable text for a Terremark error.
     *
     * @param error Terremark error.
     * @param cause Root cause exception.
     * @return Readable text composed of major/minor error codes and error message.
     */
    private static String getErrorText(final TerremarkError error, final Throwable cause) {
        if (error == null) {
            if (cause != null) {
                return cause.toString();
            }

            return null;
        }

        return error.getMinorErrorCode() + " (" + error.getMajorErrorCode() + "): " + error.getMessage();
    }
}