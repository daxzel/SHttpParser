package com.daxzel.shttpparser.message;

import java.nio.charset.CharacterCodingException;

/**
 * Signals a message constraint violation.
 *
 * @since 4.3
 */
public class MessageConstraintException extends CharacterCodingException {

    private static final long serialVersionUID = 6077207720446368695L;

    private final String message;
    /**
     * Creates a TruncatedChunkException with the specified detail message.
     *
     * @param message The exception detail message
     */
    public MessageConstraintException(final String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
