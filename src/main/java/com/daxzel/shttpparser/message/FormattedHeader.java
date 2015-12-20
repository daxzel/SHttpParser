package com.daxzel.shttpparser.message;

import com.daxzel.shttpparser.util.CharArrayBuffer;

/**
 * An HTTP header which is already formatted.
 * For example when headers are received, the original formatting
 * can be preserved. This allows for the header to be sent without
 * another formatting step.
 *
 * @since 4.0
 */
public interface FormattedHeader extends Header {

    /**
     * Obtains the buffer with the formatted header.
     * The returned buffer MUST NOT be modified.
     *
     * @return  the formatted header, in a buffer that must not be modified
     */
    CharArrayBuffer getBuffer();

    /**
     * Obtains the start of the header value in the {@link #getBuffer buffer}.
     * By accessing the value in the buffer, creation of a temporary string
     * can be avoided.
     *
     * @return  index of the first character of the header value
     *          in the buffer returned by {@link #getBuffer getBuffer}.
     */
    int getValuePos();

}