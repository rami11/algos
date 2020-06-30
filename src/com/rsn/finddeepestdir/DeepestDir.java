package com.rsn.finddeepestdir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DeepestDir {
    public static void main(String[] args) throws IOException {
//        int max = findDeepestDir(new File("/Users/rsn/Downloads/basedir"));
//        System.out.println(max);

        int max = Files.walk(Path.of("/Users/rsn/Downloads/basedir")).mapToInt(Path::getNameCount).max().orElseThrow();
        Files.walk(Path.of("/Users/rsn/Downloads/basedir")).forEach(path -> {
            if (path.getNameCount() == 14) {
                System.out.println(path);
            }
        });
    }

//    public static int findDeepestDir(File dir) {
//        int max = 0;
//        for (File file : dir.listFiles()) {
//            if (file.isFile()) {
//                System.out.println(file);
//                int nameCount = Path.of(file.getPath()).getNameCount();
//                if (nameCount > max) {
//                    max = nameCount;
//                }
//            } else {
//                max = findDeepestDir(file);
//            }
//        }
//        return max;
//    }
}
