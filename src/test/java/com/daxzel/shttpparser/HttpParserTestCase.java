package com.daxzel.shttpparser;

import com.daxzel.shttpparser.message.*;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Tsarevskiy
 */
public class HttpParserTestCase {

    @Test
    public void main() throws IOException, HttpException {
        String testHttpRequest = "POST /moscow/ HTTP/1.1\n" +
                "Host: www.chin-news.com:8000\n" +
                "Content-Length: 130\n" +
                "x-hub-signature: c1581f33c90deccac4ec125051b14c97ff7989c9\n" +
                "content-type: application/json\n" +
                "accept-encoding: gzip, deflate\n" +
                "user-agent: Python-httplib2/0.8 (gzip)\n" +
                " \n" +
                "[{\"changed_aspect\": \"media\", \"object\": \"tag\", \"object_id\": \"moscow\"," +
                " \"time\": 1450899676, \"subscription_id\": 21359349, \"data\": {}}]";

        SessionInputBufferImpl sessionInputBuffer = new SessionInputBufferImpl(new HttpTransportMetricsImpl(), 2048);
        sessionInputBuffer.bind(new ByteArrayInputStream(testHttpRequest.getBytes(Consts.ASCII)));
        HttpMessageParser requestParser = new DefaultHttpRequestParser(sessionInputBuffer);
        HttpMessage message = requestParser.parse();
        String result = IOUtils.toString(((BasicHttpEntityEnclosingRequest)message).getEntity().getContent());
        Assert.assertEquals(result,"[{\"changed_aspect\": \"media\", \"object\": \"tag\", \"object_id\": \"moscow\", \"time\": 1450899676, \"subscription_id\": 21359349, \"data\": {}}]");
        System.out.println(result);
    }
}
