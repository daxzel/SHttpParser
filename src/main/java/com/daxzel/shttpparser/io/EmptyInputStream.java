package com.daxzel.shttpparser.io;

import java.io.InputStream;

/**
 * @since 4.4
 */
public final class EmptyInputStream extends InputStream {

    public static final EmptyInputStream INSTANCE = new EmptyInputStream();

    private EmptyInputStream() {
    }

    @Override
    public int available() {
        return 0;
    }

    @Override
    public void close() {
    }

    @Override
    public void mark(final int readLimit) {
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public int read() {
        return -1;
    }

    @Override
    public int read(final byte[] buf) {
        return -1;
    }

    @Override
    public int read(final byte[] buf, final int off, final int len) {
        return -1;
    }

    @Override
    public void reset() {
    }

    @Override
    public long skip(final long n) {
        return 0L;
    }
}

