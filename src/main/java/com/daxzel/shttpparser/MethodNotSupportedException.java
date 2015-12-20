package com.daxzel.shttpparser;

/**
 * Signals that an HTTP method is not supported.
 *
 * @since 4.0
 */
public class MethodNotSupportedException extends HttpException {

    private static final long serialVersionUID = 3365359036840171201L;

    /**
     * Creates a new MethodNotSupportedException with the specified detail message.
     *
     * @param message The exception detail message
     */
    public MethodNotSupportedException(final String message) {
        super(message);
    }

    /**
     * Creates a new MethodNotSupportedException with the specified detail message and cause.
     *
     * @param message the exception detail message
     * @param cause the {@code Throwable} that caused this exception, or {@code null}
     * if the cause is unavailable, unknown, or not a {@code Throwable}
     */
    public MethodNotSupportedException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
