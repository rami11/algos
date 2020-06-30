package com.rsn.maxnumoffiles;

import java.io.File;

/**
 * Finds a directory with the maximum number of files.
 */
public class MaxFiles {
    public static void main(String[] args) {
        File file = findDirWithMaxNumOfFiles(new File("/Users/rsn/Downloads/basedir"));
        System.out.println(file);
    }

    public static File findDirWithMaxNumOfFiles(File dir) {
        if (!dir.isDirectory()) {
            return null;
        }
        File resultDir = null;
        int max = 0;
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                int n = files.length;
                if (n > max) {
                    max = n;
                    resultDir = file;
                }
            }
        }
        System.out.println(max);
        return resultDir;
    }
}
