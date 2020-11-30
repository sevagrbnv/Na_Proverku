package Lab13;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task1 {
    public static void main(String[] args) throws IOException {
        String srcFolder = "Images";
        String dstFolder = "dst";

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();

        long start = System.currentTimeMillis();

        try {
            if (!Files.exists(Paths.get(dstFolder)))
                Files.createDirectories(Paths.get(dstFolder));

            int sizeOfNewArrays = files.length / Runtime.getRuntime().availableProcessors();

            for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++){
                File[] fileArray = new File[sizeOfNewArrays];
                System.arraycopy(files, i * sizeOfNewArrays, fileArray, 0, sizeOfNewArrays);

                Thread resize = new ImageResize(fileArray, dstFolder, start);
                resize.start();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
