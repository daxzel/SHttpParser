package com.daxzel.shttpparser.message;


import com.daxzel.shttpparser.util.ProtocolVersion;

/**
 * The first line of a Response message is the Status-Line, consisting
 * of the protocol version followed by a numeric status code and its
 * associated textual phrase, with each element separated by SP
 * characters. No CR or LF is allowed except in the final CRLF sequence.
 * <pre>
 *     Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
 * </pre>
 *
 * @see HttpStatus
 * @version $Id: StatusLine.java 937295 2010-04-23 13:44:00Z olegk $
 *
 * @since 4.0
 */
public interface StatusLine {

    ProtocolVersion getProtocolVersion();

    int getStatusCode();

    String getReasonPhrase();

}
