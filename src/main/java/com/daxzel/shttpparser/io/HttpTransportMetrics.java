package com.daxzel.shttpparser.io;

/**
 * The point of access to the statistics of {@link SessionInputBuffer} or
 * {@link SessionOutputBuffer}.
 *
 * @since 4.0
 */
public interface HttpTransportMetrics {

    /**
     * Returns the number of bytes transferred.
     */
    long getBytesTransferred();

    /**
     * Resets the counts
     */
    void reset();

}
