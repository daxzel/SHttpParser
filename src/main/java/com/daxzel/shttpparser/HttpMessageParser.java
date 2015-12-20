package com.daxzel.shttpparser;

import com.daxzel.shttpparser.message.HttpMessage;

import java.io.IOException;

/**
 * Abstract message parser intended to build HTTP messages from an arbitrary data source.
 *
 * @param <T>
 *            {@link HttpMessage} or a subclass
 *
 * @since 4.0
 */
public interface HttpMessageParser<T extends HttpMessage> {

    /**
     * Generates an instance of {@link HttpMessage} from the underlying data
     * source.
     *
     * @return HTTP message
     * @throws IOException in case of an I/O error
     * @throws HttpException in case of HTTP protocol violation
     */
    T parse()
            throws IOException, HttpException;

}
