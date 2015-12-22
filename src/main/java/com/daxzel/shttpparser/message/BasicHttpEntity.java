package com.daxzel.shttpparser.message;

import com.daxzel.shttpparser.io.EmptyInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A generic streamed, non-repeatable entity that obtains its content
 * from an {@link InputStream}.
 *
 * NotThreadSafe
 * @since 4.0
 */
public class BasicHttpEntity extends AbstractHttpEntity {

    private InputStream content;
    private long length;

    /**
     * Creates a new basic entity.
     * The content is initially missing, the content length
     * is set to a negative number.
     */
    public BasicHttpEntity() {
        super();
        this.length = -1;
    }

    public long getContentLength() {
        return this.length;
    }

    /**
     * Obtains the content, once only.
     *
     * @return  the content, if this is the first call to this method
     *          since {@link #setContent setContent} has been called
     *
     * @throws IllegalStateException
     *          if the content has not been provided
     */
    public InputStream getContent() throws IllegalStateException {
        return this.content;
    }

    /**
     * Tells that this entity is not repeatable.
     *
     * @return {@code false}
     */
    public boolean isRepeatable() {
        return false;
    }

    /**
     * Specifies the length of the content.
     *
     * @param len       the number of bytes in the content, or
     *                  a negative number to indicate an unknown length
     */
    public void setContentLength(final long len) {
        this.length = len;
    }

    /**
     * Specifies the content.
     *
     * @param instream          the stream to return with the next call to
     *                          {@link #getContent getContent}
     */
    public void setContent(final InputStream instream) {
        this.content = instream;
    }

    public void writeTo(final OutputStream outstream) throws IOException {
        final InputStream instream = getContent();
        try {
            int l;
            final byte[] tmp = new byte[OUTPUT_BUFFER_SIZE];
            while ((l = instream.read(tmp)) != -1) {
                outstream.write(tmp, 0, l);
            }
        } finally {
            instream.close();
        }
    }

    public boolean isStreaming() {
        return this.content != null && this.content != EmptyInputStream.INSTANCE;
    }

}
