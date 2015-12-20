package com.daxzel.shttpparser.message;

import com.daxzel.shttpparser.util.CharArrayBuffer;
import com.daxzel.shttpparser.util.ProtocolVersion;

/**
 * Interface for parsing lines in the HEAD section of an HTTP message.
 * There are individual methods for parsing a request line, a
 * status line, or a header line.
 * The lines to parse are passed in memory, the parser does not depend
 * on any specific IO mechanism.
 * Instances of this interface are expected to be stateless and thread-safe.
 *
 * @since 4.0
 */
public interface LineParser {

    /**
     * Parses the textual representation of a protocol version.
     * This is needed for parsing request lines (last element)
     * as well as status lines (first element).
     *
     * @param buffer    a buffer holding the protocol version to parse
     * @param cursor    the parser cursor containing the current position and
     *                  the bounds within the buffer for the parsing operation
     *
     * @return  the parsed protocol version
     *
     * @throws ParseException        in case of a parse error
     */
    ProtocolVersion parseProtocolVersion(
            CharArrayBuffer buffer,
            ParserCursor cursor) throws ParseException;

    /**
     * Checks whether there likely is a protocol version in a line.
     * This method implements a <i>heuristic</i> to check for a
     * likely protocol version specification. It does <i>not</i>
     * guarantee that {@link #parseProtocolVersion} would not
     * detect a parse error.
     * This can be used to detect garbage lines before a request
     * or status line.
     *
     * @param buffer    a buffer holding the line to inspect
     * @param cursor    the cursor at which to check for a protocol version, or
     *                  negative for "end of line". Whether the check tolerates
     *                  whitespace before or after the protocol version is
     *                  implementation dependent.
     *
     * @return  {@code true} if there is a protocol version at the
     *          argument index (possibly ignoring whitespace),
     *          {@code false} otherwise
     */
    boolean hasProtocolVersion(
            CharArrayBuffer buffer,
            ParserCursor cursor);

    /**
     * Parses a request line.
     *
     * @param buffer    a buffer holding the line to parse
     * @param cursor    the parser cursor containing the current position and
     *                  the bounds within the buffer for the parsing operation
     *
     * @return  the parsed request line
     *
     * @throws ParseException        in case of a parse error
     */
    RequestLine parseRequestLine(
            CharArrayBuffer buffer,
            ParserCursor cursor) throws ParseException;

    /**
     * Parses a status line.
     *
     * @param buffer    a buffer holding the line to parse
     * @param cursor    the parser cursor containing the current position and
     *                  the bounds within the buffer for the parsing operation
     *
     * @return  the parsed status line
     *
     * @throws ParseException        in case of a parse error
     */
    StatusLine parseStatusLine(
            CharArrayBuffer buffer,
            ParserCursor cursor) throws ParseException;

    /**
     * Creates a header from a line.
     * The full header line is expected here. Header continuation lines
     * must be joined by the caller before invoking this method.
     *
     * @param buffer    a buffer holding the full header line.
     *                  This buffer MUST NOT be re-used afterwards, since
     *                  the returned object may reference the contents later.
     *
     * @return  the header in the argument buffer.
     *          The returned object MAY be a wrapper for the argument buffer.
     *          The argument buffer MUST NOT be re-used or changed afterwards.
     *
     * @throws ParseException        in case of a parse error
     */
    Header parseHeader(CharArrayBuffer buffer)
            throws ParseException;

}
