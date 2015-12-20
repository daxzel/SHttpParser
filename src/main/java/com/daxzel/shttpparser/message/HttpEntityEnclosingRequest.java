package com.daxzel.shttpparser.message;

/**
 * A request with an entity.
 *
 * @since 4.0
 */
public interface HttpEntityEnclosingRequest extends HttpRequest {

    /**
     * Tells if this request should use the expect-continue handshake.
     * The expect continue handshake gives the server a chance to decide
     * whether to accept the entity enclosing request before the possibly
     * lengthy entity is sent across the wire.
     * @return true if the expect continue handshake should be used, false if
     * not.
     */
    boolean expectContinue();

    /**
     * Associates the entity with this request.
     *
     * @param entity the entity to send.
     */
    void setEntity(HttpEntity entity);

    /**
     * Returns the entity associated with this request.
     *
     * @return entity
     */
    HttpEntity getEntity();

}
