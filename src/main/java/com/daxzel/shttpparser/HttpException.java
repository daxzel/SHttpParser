package com.daxzel.shttpparser;

/**
 * Signals that an HTTP exception has occurred.
 *
 * @since 4.0
 */
public class HttpException extends Exception {

    private static final long serialVersionUID = -5437299376222011036L;

    /**
     * Creates a new HttpException with a {@code null} detail message.
     */
    public HttpException() {
        super();
    }

    /**
     * Creates a new HttpException with the specified detail message.
     *
     * @param message the exception detail message
     */
    public HttpException(final String message) {
        super(message);
    }

    /**
     * Creates a new HttpException with the specified detail message and cause.
     *
     * @param message the exception detail message
     * @param cause the {@code Throwable} that caused this exception, or {@code null}
     * if the cause is unavailable, unknown, or not a {@code Throwable}
     */
    public HttpException(final String message, final Throwable cause) {
        super(message);
        initCause(cause);
    }

}
