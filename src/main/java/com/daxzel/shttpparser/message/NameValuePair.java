package com.daxzel.shttpparser.message;

/**
 * A name / value pair parameter used as an element of HTTP messages.
 * <pre>
 * parameter               = attribute "=" value
 * attribute               = token
 * value                   = token | quoted-string
 * </pre>
 *
 *
 * @since 4.0
 */
public interface NameValuePair {

    String getName();

    String getValue();

}
