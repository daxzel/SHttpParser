package com.daxzel.shttpparser.message;

import com.daxzel.shttpparser.HttpException;

public interface ContentLengthStrategy {

    public static final int IDENTITY         = -1;
    public static final int CHUNKED          = -2;

    /**
     * Returns length of the given message in bytes. The returned value
     * must be a non-negative number, {@link #IDENTITY} if the end of the
     * message will be delimited by the end of connection, or {@link #CHUNKED}
     * if the message is chunk coded
     *
     * @param message HTTP message
     * @return content length, {@link #IDENTITY}, or {@link #CHUNKED}
     *
     * @throws HttpException in case of HTTP protocol violation
     */
    long determineLength(HttpMessage message) throws HttpException;

}
