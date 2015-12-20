package com.daxzel.shttpparser;

import com.daxzel.shttpparser.message.BasicHttpEntityEnclosingRequest;
import com.daxzel.shttpparser.message.BasicHttpRequest;
import com.daxzel.shttpparser.message.HttpRequest;
import com.daxzel.shttpparser.message.RequestLine;

/**
 * Default factory for creating {@link HttpRequest} objects.
 *
 * @since 4.0
 *
 * Immutable
 */
public class DefaultHttpRequestFactory implements HttpRequestFactory {

    public static final DefaultHttpRequestFactory INSTANCE = new DefaultHttpRequestFactory();

    private static final String[] RFC2616_COMMON_METHODS = {
            "GET"
    };

    private static final String[] RFC2616_ENTITY_ENC_METHODS = {
            "POST",
            "PUT"
    };

    private static final String[] RFC2616_SPECIAL_METHODS = {
            "HEAD",
            "OPTIONS",
            "DELETE",
            "TRACE",
            "CONNECT"
    };


    public DefaultHttpRequestFactory() {
        super();
    }

    private static boolean isOneOf(final String[] methods, final String method) {
        for (final String method2 : methods) {
            if (method2.equalsIgnoreCase(method)) {
                return true;
            }
        }
        return false;
    }

    public HttpRequest newHttpRequest(final RequestLine requestline)
            throws MethodNotSupportedException {
        final String method = requestline.getMethod();
        if (isOneOf(RFC2616_COMMON_METHODS, method)) {
            return new BasicHttpRequest(requestline);
        } else if (isOneOf(RFC2616_ENTITY_ENC_METHODS, method)) {
            return new BasicHttpEntityEnclosingRequest(requestline);
        } else if (isOneOf(RFC2616_SPECIAL_METHODS, method)) {
            return new BasicHttpRequest(requestline);
        } else {
            throw new MethodNotSupportedException(method +  " method not supported");
        }
    }

    public HttpRequest newHttpRequest(final String method, final String uri)
            throws MethodNotSupportedException {
        if (isOneOf(RFC2616_COMMON_METHODS, method)) {
            return new BasicHttpRequest(method, uri);
        } else if (isOneOf(RFC2616_ENTITY_ENC_METHODS, method)) {
            return new BasicHttpEntityEnclosingRequest(method, uri);
        } else if (isOneOf(RFC2616_SPECIAL_METHODS, method)) {
            return new BasicHttpRequest(method, uri);
        } else {
            throw new MethodNotSupportedException(method
                    + " method not supported");
        }
    }

}
