/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

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
