package com.daxzel.shttpparser.message;

import com.daxzel.shttpparser.util.ProtocolVersion;

import java.io.Serializable;

/**
 * Basic implementation of {@link StatusLine}
 *
 * @since 4.0
 *
 * Immutable
 */
public class BasicStatusLine implements StatusLine, Cloneable, Serializable {

    private static final long serialVersionUID = -2443303766890459269L;

    // ----------------------------------------------------- Instance Variables

    /** The protocol version. */
    private final ProtocolVersion protoVersion;

    /** The status code. */
    private final int statusCode;

    /** The reason phrase. */
    private final String reasonPhrase;

    // ----------------------------------------------------------- Constructors
    /**
     * Creates a new status line with the given version, status, and reason.
     *
     * @param version           the protocol version of the response
     * @param statusCode        the status code of the response
     * @param reasonPhrase      the reason phrase to the status code, or
     *                          {@code null}
     */
    public BasicStatusLine(final ProtocolVersion version, final int statusCode,
                           final String reasonPhrase) {
        super();
        this.protoVersion = version;
        this.statusCode = statusCode;
        this.reasonPhrase = reasonPhrase;
    }

    // --------------------------------------------------------- Public Methods

    public int getStatusCode() {
        return this.statusCode;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.protoVersion;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    @Override
    public String toString() {
        // no need for non-default formatting in toString()
        return BasicLineFormatter.INSTANCE.formatStatusLine(null, this).toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
