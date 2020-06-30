package com.rsn.maxnumoffiles;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class MaxFilesTest {

    @Test
    public void findDirWithMaxNumOfFilesTest() {
        File dir = new File("test");
        Assert.assertEquals(new File("test/dir1"), MaxFiles.findDirWithMaxNumOfFiles(dir));
    }
}