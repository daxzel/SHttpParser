package com.daxzel.shttpparser;

/**
 * Signals that an HTTP protocol violation has occurred.
 * For example a malformed status line or headers, a missing message body, etc.
 *
 *
 * @since 4.0
 */
public class ProtocolException extends HttpException {

    private static final long serialVersionUID = -2143571074341228994L;

    /**
     * Creates a new ProtocolException with a {@code null} detail message.
     */
    public ProtocolException() {
        super();
    }

    /**
     * Creates a new ProtocolException with the specified detail message.
     *
     * @param message The exception detail message
     */
    public ProtocolException(final String message) {
        super(message);
    }

    /**
     * Creates a new ProtocolException with the specified detail message and cause.
     *
     * @param message the exception detail message
     * @param cause the {@code Throwable} that caused this exception, or {@code null}
     * if the cause is unavailable, unknown, or not a {@code Throwable}
     */
    public ProtocolException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
