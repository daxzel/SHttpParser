package com.daxzel.shttpparser.message;

import com.daxzel.shttpparser.ProtocolVersion;

/**
 * Created by Tsarevskiy
 */
public class HttpEntityEnclosingRequest
        extends BasicHttpRequest {

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

    @Override
    public HttpEntity getEntity() {
        return this.entity;
    }

    @Override
    public void setEntity(final HttpEntity entity) {
        this.entity = entity;
    }

    @Override
    public boolean expectContinue() {
        final Header expect = getFirstHeader(HTTP.EXPECT_DIRECTIVE);
        return expect != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(expect.getValue());
    }

}

