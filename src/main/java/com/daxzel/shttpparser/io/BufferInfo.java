package com.daxzel.shttpparser.io;


/**
 * Basic buffer properties.
 *
 * @since 4.1
 */
public interface BufferInfo {

    /**
     * Return length data stored in the buffer
     *
     * @return data length
     */
    int length();

    /**
     * Returns total capacity of the buffer
     *
     * @return total capacity
     */
    int capacity();

    /**
     * Returns available space in the buffer.
     *
     * @return available space.
     */
    int available();

}