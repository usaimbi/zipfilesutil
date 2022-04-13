package org.example;

import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipFilesUtil {

    public int numberOfFiles(final ZipFile zipFile) {
        final Enumeration<? extends ZipEntry> entries = zipFile.entries();
        int numRegularFiles = 0;
        while (entries.hasMoreElements()) {
            if (! entries.nextElement().isDirectory()) {
                ++numRegularFiles;
            }
        }
        return numRegularFiles;
    }
}
