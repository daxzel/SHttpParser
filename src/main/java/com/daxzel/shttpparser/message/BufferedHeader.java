package com.daxzel.shttpparser.message;


import com.daxzel.shttpparser.util.CharArrayBuffer;

import java.io.Serializable;

/**
 * This class represents a raw HTTP header whose content is parsed 'on demand'
 * only when the header value needs to be consumed.
 *
 * @since 4.0
 *
 * NotThreadSafe
 */
public class BufferedHeader implements FormattedHeader, Cloneable, Serializable {

    private static final long serialVersionUID = -2768352615787625448L;

    /**
     * Header name.
     */
    private final String name;

    /**
     * The buffer containing the entire header line.
     */
    private final CharArrayBuffer buffer;

    /**
     * The beginning of the header value in the buffer
     */
    private final int valuePos;


    /**
     * Creates a new header from a buffer.
     * The name of the header will be parsed immediately,
     * the value only if it is accessed.
     *
     * @param buffer    the buffer containing the header to represent
     *
     * @throws ParseException   in case of a parse error
     */
    public BufferedHeader(final CharArrayBuffer buffer)
            throws ParseException {

        super();
        final int colon = buffer.indexOf(':');
        if (colon == -1) {
            throw new ParseException
                    ("Invalid header: " + buffer.toString());
        }
        final String s = buffer.substringTrimmed(0, colon);
        if (s.length() == 0) {
            throw new ParseException
                    ("Invalid header: " + buffer.toString());
        }
        this.buffer = buffer;
        this.name = s;
        this.valuePos = colon + 1;
    }


    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.buffer.substringTrimmed(this.valuePos, this.buffer.length());
    }

    public HeaderElement[] getElements() throws ParseException {
        final ParserCursor cursor = new ParserCursor(0, this.buffer.length());
        cursor.updatePos(this.valuePos);
        return BasicHeaderValueParser.INSTANCE.parseElements(this.buffer, cursor);
    }

    public int getValuePos() {
        return this.valuePos;
    }

    public CharArrayBuffer getBuffer() {
        return this.buffer;
    }

    @Override
    public String toString() {
        return this.buffer.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // buffer is considered immutable
        // no need to make a copy of it
        return super.clone();
    }

}
