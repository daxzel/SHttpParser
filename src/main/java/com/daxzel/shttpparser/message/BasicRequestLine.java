package com.daxzel.shttpparser.message;

import com.daxzel.shttpparser.util.ProtocolVersion;

import java.io.Serializable;

/**
 * Basic implementation of {@link RequestLine}.
 *
 * @since 4.0
 *
 * Immutable
 */
public class BasicRequestLine implements RequestLine, Cloneable, Serializable {

    private static final long serialVersionUID = 2810581718468737193L;

    private final ProtocolVersion protoversion;
    private final String method;
    private final String uri;

    public BasicRequestLine(final String method,
                            final String uri,
                            final ProtocolVersion version) {
        super();
        this.method = method;
        this.uri = uri;
        this.protoversion = version;
    }

    public String getMethod() {
        return this.method;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.protoversion;
    }

    public String getUri() {
        return this.uri;
    }

    @Override
    public String toString() {
        // no need for non-default formatting in toString()
        return BasicLineFormatter.INSTANCE.formatRequestLine(null, this).toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
