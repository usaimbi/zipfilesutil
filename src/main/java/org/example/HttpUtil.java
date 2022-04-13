package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import java.io.*;

public class HttpUtil {

    public void write(final HttpResponse response, OutputStream outputStream) throws IOException {
        HttpEntity entity = response.getEntity();
        InputStream is = entity.getContent();
        int inByte;
        while ((inByte = is.read()) != -1) {
            outputStream.write(inByte);
        }
        is.close();
    }
}
