package com.daxzel.shttpparser;

import com.daxzel.shttpparser.io.SessionInputBuffer;
import com.daxzel.shttpparser.message.*;
import com.daxzel.shttpparser.util.CharArrayBuffer;

import java.io.IOException;

/**
 * HTTP request parser that obtain its input from an instance
 * of {@link SessionInputBuffer}.
 *
 * @since 4.2
 *
 * NotThreadSafe
 */
@SuppressWarnings("deprecation")
public class DefaultHttpRequestParser extends AbstractMessageParser<HttpRequest> {

    private final HttpRequestFactory requestFactory;
    private final CharArrayBuffer lineBuf;

    /**
     * Creates an instance of this class.
     *
     * @param buffer the session input buffer.
     * @param lineParser the line parser.
     * @param requestFactory the factory to use to create
     *    {@link HttpRequest}s.
     * @param params HTTP parameters.
     *
     * @deprecated (4.3) use
     *   {@link DefaultHttpRequestParser#DefaultHttpRequestParser(SessionInputBuffer, LineParser,
     *     HttpRequestFactory, MessageConstraints)}
     */
    @Deprecated
    public DefaultHttpRequestParser(
            final SessionInputBuffer buffer,
            final LineParser lineParser,
            final HttpRequestFactory requestFactory,
            final HttpParams params) {
        super(buffer, lineParser, params);
        this.requestFactory = requestFactory;
        this.lineBuf = new CharArrayBuffer(128);
    }

    /**
     * Creates new instance of DefaultHttpRequestParser.
     *
     * @param buffer the session input buffer.
     * @param lineParser the line parser. If {@code null}
     *   {@link org.apache.http.message.BasicLineParser#INSTANCE} will be used.
     * @param requestFactory the response factory. If {@code null}
     *   {@link DefaultHttpRequestFactory#INSTANCE} will be used.
     * @param constraints the message constraints. If {@code null}
     *   {@link MessageConstraints#DEFAULT} will be used.
     *
     * @since 4.3
     */
    public DefaultHttpRequestParser(
            final SessionInputBuffer buffer,
            final LineParser lineParser,
            final HttpRequestFactory requestFactory,
            final MessageConstraints constraints) {
        super(buffer, lineParser, constraints);
        this.requestFactory = requestFactory != null ? requestFactory :
                DefaultHttpRequestFactory.INSTANCE;
        this.lineBuf = new CharArrayBuffer(128);
    }

    /**
     * @since 4.3
     */
    public DefaultHttpRequestParser(
            final SessionInputBuffer buffer,
            final MessageConstraints constraints) {
        this(buffer, null, null, constraints);
    }

    /**
     * @since 4.3
     */
    public DefaultHttpRequestParser(final SessionInputBuffer buffer) {
        this(buffer, null, null, MessageConstraints.DEFAULT);
    }

    @Override
    protected HttpRequest parseHead(
            final SessionInputBuffer sessionBuffer)
            throws IOException, HttpException, ParseException {

        this.lineBuf.clear();
        final int i = sessionBuffer.readLine(this.lineBuf);
        if (i == -1) {
            throw new ConnectionClosedException("Client closed connection");
        }
        final ParserCursor cursor = new ParserCursor(0, this.lineBuf.length());
        final RequestLine requestline = this.lineParser.parseRequestLine(this.lineBuf, cursor);
        return this.requestFactory.newHttpRequest(requestline);
    }

}
