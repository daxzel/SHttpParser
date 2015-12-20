package com.daxzel.shttpparser;

import com.daxzel.shttpparser.message.HttpRequest;
import com.daxzel.shttpparser.message.RequestLine;

/**
 * A factory for {@link HttpRequest HttpRequest} objects.
 *
 * @since 4.0
 */
public interface HttpRequestFactory {

    HttpRequest newHttpRequest(RequestLine requestline) throws MethodNotSupportedException;

    HttpRequest newHttpRequest(String method, String uri) throws MethodNotSupportedException;

}
