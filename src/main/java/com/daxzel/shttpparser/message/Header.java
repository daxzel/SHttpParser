package com.daxzel.shttpparser.message;

/**
 * Represents an HTTP header field.
 *
 * <p>The HTTP header fields follow the same generic format as
 * that given in Section 3.1 of RFC 822. Each header field consists
 * of a name followed by a colon (":") and the field value. Field names
 * are case-insensitive. The field value MAY be preceded by any amount
 * of LWS, though a single SP is preferred.
 *
 *<pre>
 *     message-header = field-name ":" [ field-value ]
 *     field-name     = token
 *     field-value    = *( field-content | LWS )
 *     field-content  = &lt;the OCTETs making up the field-value
 *                      and consisting of either *TEXT or combinations
 *                      of token, separators, and quoted-string&gt;
 *</pre>
 *
 * @since 4.0
 */
public interface Header {

    /**
     * Get the name of the Header.
     *
     * @return the name of the Header,  never {@code null}
     */
    String getName();

    /**
     * Get the value of the Header.
     *
     * @return the value of the Header,  may be {@code null}
     */
    String getValue();

    /**
     * Parses the value.
     *
     * @return an array of {@link HeaderElement} entries, may be empty, but is never {@code null}
     * @throws ParseException in case of a parsing error
     */
    HeaderElement[] getElements() throws ParseException;

}