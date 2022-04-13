package org.example;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipFile;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ZipFilesUtilTest {

    @Test
    public void shouldReadNumberOfFiles() throws IOException, URISyntaxException {
        Path resourceDirectory = Paths.get("src","test","resource", "Archive.zip");
        ZipFile file = new ZipFile(resourceDirectory.toString());
        ZipFilesUtil testSubject = new ZipFilesUtil();
        int numberOfFiles = testSubject.numberOfFiles(file);
        assertThat(numberOfFiles, equalTo(4) );
    }
}
