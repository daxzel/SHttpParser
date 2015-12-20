package com.daxzel.shttpparser.message;

/**
 * Signals a parse error. Parse errors that do not occur during
 * protocol execution may be handled differently.
 * This is an unchecked exception, since there are cases where
 * the data to be parsed has been generated and is therefore
 * known to be parseable.
 *
 * @since 4.0
 */
public class ParseException extends RuntimeException {

    private static final long serialVersionUID = -7288819855864183578L;

    /**
     * Creates a {@link ParseException} without details.
     */
    public ParseException() {
        super();
    }

    /**
     * Creates a {@link ParseException} with a detail message.
     *
     * @param message the exception detail message, or {@code null}
     */
    public ParseException(final String message) {
        super(message);
    }

}

