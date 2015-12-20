package com.daxzel.shttpparser.message;

import com.daxzel.shttpparser.util.ProtocolVersion;

import java.io.Serializable;

/**
 * Represents an HTTP version. HTTP uses a "major.minor" numbering
 * scheme to indicate versions of the protocol.
 * <p>
 * The version of an HTTP message is indicated by an HTTP-Version field
 * in the first line of the message.
 * </p>
 * <pre>
 *     HTTP-Version   = "HTTP" "/" 1*DIGIT "." 1*DIGIT
 * </pre>
 *
 * @since 4.0
 * Immutable
 */
public final class HttpVersion extends ProtocolVersion
        implements Serializable {

    private static final long serialVersionUID = -5856653513894415344L;

    /** The protocol name. */
    public static final String HTTP = "HTTP";

    /** HTTP protocol version 0.9 */
    public static final HttpVersion HTTP_0_9 = new HttpVersion(0, 9);

    /** HTTP protocol version 1.0 */
    public static final HttpVersion HTTP_1_0 = new HttpVersion(1, 0);

    /** HTTP protocol version 1.1 */
    public static final HttpVersion HTTP_1_1 = new HttpVersion(1, 1);


    /**
     * Create an HTTP protocol version designator.
     *
     * @param major   the major version number of the HTTP protocol
     * @param minor   the minor version number of the HTTP protocol
     *
     * @throws IllegalArgumentException if either major or minor version number is negative
     */
    public HttpVersion(final int major, final int minor) {
        super(HTTP, major, minor);
    }


    /**
     * Obtains a specific HTTP version.
     *
     * @param major     the major version
     * @param minor     the minor version
     *
     * @return  an instance of {@link HttpVersion} with the argument version
     */
    @Override
    public ProtocolVersion forVersion(final int major, final int minor) {

        if ((major == this.major) && (minor == this.minor)) {
            return this;
        }

        if (major == 1) {
            if (minor == 0) {
                return HTTP_1_0;
            }
            if (minor == 1) {
                return HTTP_1_1;
            }
        }
        if ((major == 0) && (minor == 9)) {
            return HTTP_0_9;
        }

        // argument checking is done in the constructor
        return new HttpVersion(major, minor);
    }

}