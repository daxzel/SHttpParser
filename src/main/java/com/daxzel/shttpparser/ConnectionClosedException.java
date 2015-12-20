package com.daxzel.shttpparser;

import java.io.IOException;

/**
 * Signals that the connection has been closed unexpectedly.
 *
 * @since 4.0
 */
public class ConnectionClosedException extends IOException {

    private static final long serialVersionUID = 617550366255636674L;

    /**
     * Creates a new ConnectionClosedException with the specified detail message.
     *
     * @param message The exception detail message
     */
    public ConnectionClosedException(final String message) {
        super(message);
    }

}
