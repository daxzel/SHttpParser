package com.daxzel.shttpparser.message;


import com.daxzel.shttpparser.io.BufferInfo;
import com.daxzel.shttpparser.io.SessionInputBuffer;

import java.io.IOException;
import java.io.InputStream;

/**
 * Input stream that reads data without any transformation. The end of the
 * content entity is demarcated by closing the underlying connection
 * (EOF condition). Entities transferred using this input stream can be of
 * unlimited length.
 * <p>
 * Note that this class NEVER closes the underlying stream, even when close
 * gets called.  Instead, it will read until the end of the stream (until
 * {@code -1} is returned).
 *
 * @since 4.0
 * NotThreadSafe
 */
public class IdentityInputStream extends InputStream {

    private final SessionInputBuffer in;

    private boolean closed = false;

    /**
     * Wraps session input stream and reads input until the the end of stream.
     *
     * @param in The session input buffer
     */
    public IdentityInputStream(final SessionInputBuffer in) {
        super();
        this.in = in;
    }

    @Override
    public int available() throws IOException {
        if (this.in instanceof BufferInfo) {
            return ((BufferInfo) this.in).length();
        } else {
            return 0;
        }
    }

    @Override
    public void close() throws IOException {
        this.closed = true;
    }

    @Override
    public int read() throws IOException {
        if (this.closed) {
            return -1;
        } else {
            return this.in.read();
        }
    }

    @Override
    public int read(final byte[] b, final int off, final int len) throws IOException {
        if (this.closed) {
            return -1;
        } else {
            return this.in.read(b, off, len);
        }
    }

}
