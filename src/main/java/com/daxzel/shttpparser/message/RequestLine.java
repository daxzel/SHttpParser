package com.daxzel.shttpparser.message;

import com.daxzel.shttpparser.ProtocolVersion;

/**
 * The Request-Line begins with a method token, followed by the
 * Request-URI and the protocol version, and ending with CRLF. The
 * elements are separated by SP characters. No CR or LF is allowed
 * except in the final CRLF sequence.
 * <pre>
 *      Request-Line   = Method SP Request-URI SP HTTP-Version CRLF
 * </pre>
 *
 * @since 4.0
 */
public interface RequestLine {

    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();

}