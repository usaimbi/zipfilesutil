package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HttpUtilTest {

    @Test
    public void shouldSaveResponseBody() throws IOException {
        HttpResponse response = Mockito.mock(HttpResponse.class);
        HttpEntity entity = Mockito.mock(HttpEntity.class);
        String expected = "this is the expected output from the http response content";
        when(response.getEntity()).thenReturn(entity);
        when(entity.getContent()).thenReturn(new ByteArrayInputStream(expected.getBytes(Charset.defaultCharset())));

        HttpUtil testSubject = new HttpUtil();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        testSubject.write( response , outputStream );
        String result = outputStream.toString();

        verify(response).getEntity();
        verify(entity).getContent();
        assertThat( "result string does not match the expected content", result.equals(expected), is(true) );
    }
}
