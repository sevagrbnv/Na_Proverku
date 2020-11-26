package Lab10;

import java.io.*;
import java.text.DecimalFormat;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file = new File("logs");
        if (!file.exists())
            file.mkdir();

        System.out.println("Введите путь к папке");
        String path = reader.readLine();
        String folderSize = readableForm(getFolderSize(path));

        Task1.setLogFile();
        System.out.println("Размер папки: " + folderSize);
        Task1.log("Размер папки " + path + " " + folderSize);

        Task1.writer.flush();
        Task1.writer.close();
    }

    public static long getFolderSize(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            long totalSize = 0;
            for (File downFile : files) {
                totalSize += getFolderSize(downFile.getPath());
            }
            return totalSize;
        } else if (file.isFile()) {
            return file.length();
        }
        return 0;
    }

    public static String readableForm(long size) {
        if (size <= 0) return "0";
        final String[] sizers = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size
                / Math.pow(1024, digitGroups)) + " " + sizers[digitGroups];
    }
}

