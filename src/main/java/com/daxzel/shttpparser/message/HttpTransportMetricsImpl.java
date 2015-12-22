package com.daxzel.shttpparser.message;

import com.daxzel.shttpparser.io.HttpTransportMetrics;

/**
 * Default implementation of {@link HttpTransportMetrics}.
 *
 * @since 4.0
 *
 * NotThreadSafe
 */
public class HttpTransportMetricsImpl implements HttpTransportMetrics {

    private long bytesTransferred = 0;

    public HttpTransportMetricsImpl() {
        super();
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void setBytesTransferred(final long count) {
        this.bytesTransferred = count;
    }

    public void incrementBytesTransferred(final long count) {
        this.bytesTransferred += count;
    }

    public void reset() {
        this.bytesTransferred = 0;
    }

}
