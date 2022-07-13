package com.cookbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipTest {

    @Test
    public void testZipMultipleEntries() throws Exception {

        Path path = Files.createTempFile("ZipTest", ".zip");
        ZipOutputStream out = new ZipOutputStream(Files.newOutputStream(path));
        out.putNextEntry(new ZipEntry("file1.txt"));
        String string1 = "this is file 1";
        ByteArrayInputStream data1 = new ByteArrayInputStream(string1.getBytes());
        data1.transferTo((OutputStream) out);

        out.putNextEntry(new ZipEntry("file2.txt"));
        String string2 = "file2";
        ByteArrayInputStream data2 = new ByteArrayInputStream(string2.getBytes());
        data2.transferTo((OutputStream) out);
        out.close();

        // read 2 files out from the temp zip file
        ZipFile zipFile = new ZipFile(path.toString());
        ZipEntry entry = zipFile.getEntry("file1.txt");
        InputStream inStream = zipFile.getInputStream(entry);
        String outString1 = new String(inStream.readAllBytes());
        Assert.assertTrue(outString1.equals(string1));

        ZipEntry entry2 = zipFile.getEntry("file2.txt");
        InputStream instream2 = zipFile.getInputStream(entry2);
        String outString2 = new String(instream2.readAllBytes());
        Assert.assertTrue(outString2.equals(string2));
    }
    
}



