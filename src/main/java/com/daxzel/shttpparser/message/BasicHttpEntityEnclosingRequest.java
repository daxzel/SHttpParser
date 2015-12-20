package com.daxzel.shttpparser.message;

import com.daxzel.shttpparser.util.ProtocolVersion;

/**
 * Basic implementation of {@link HttpEntityEnclosingRequest}.
 *
 * @since 4.0
 *
 * NotThreadSafe
 */
public class BasicHttpEntityEnclosingRequest
        extends BasicHttpRequest implements HttpEntityEnclosingRequest {

    private HttpEntity entity;

    public BasicHttpEntityEnclosingRequest(final String method, final String uri) {
        super(method, uri);
    }

    public BasicHttpEntityEnclosingRequest(final String method, final String uri,
                                           final ProtocolVersion ver) {
        super(method, uri, ver);
    }

    public BasicHttpEntityEnclosingRequest(final RequestLine requestline) {
        super(requestline);
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public void setEntity(final HttpEntity entity) {
        this.entity = entity;
    }

    public boolean expectContinue() {
        final Header expect = getFirstHeader(HTTP.EXPECT_DIRECTIVE);
        return expect != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(expect.getValue());
    }

}
