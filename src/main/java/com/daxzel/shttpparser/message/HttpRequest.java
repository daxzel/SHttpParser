package com.daxzel.shttpparser.message;

/**
 * A request message from a client to a server includes, within the
 * first line of that message, the method to be applied to the resource,
 * the identifier of the resource, and the protocol version in use.
 * <pre>
 *      Request       = Request-Line
 *                      *(( general-header
 *                       | request-header
 *                       | entity-header ) CRLF)
 *                      CRLF
 *                      [ message-body ]
 * </pre>
 *
 * @since 4.0
 */
public interface HttpRequest extends HttpMessage {

    /**
     * Returns the request line of this request.
     * @return the request line.
     */
    RequestLine getRequestLine();

}