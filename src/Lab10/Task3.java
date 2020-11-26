package Lab10;

import java.io.*;
import java.nio.file.Paths;

public class Task3 {
    public static PrintWriter writer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file = new File("logs");
        if (!file.exists())
            file.mkdir();

        Task1.setLogFile();
        System.out.println("Введите путь старой папки");
        String from = reader.readLine();
        System.out.println("Введите путь новой папки");
        String to = reader.readLine();

        copy(from, to);
        Task1.setLogFile();
        Task1.log("Copy " + from + " в " + to);
        Task1.writer.flush();
        Task1.writer.close();
    }

    public static void copy(String from, String to){
        File file = new File(from);
        if (file.isDirectory()) {
            new File(to).mkdir();
            File[] files = file.listFiles();
            for (File item : files) {
                copy(item.getPath(), Paths.get(to, item.getName()).toString());
            }
        } else if (file.isFile()) {
            copyFile(file, new File(to));
        }
    }

    public static void copyFile(File oldFile, File newFile){
        InputStream input;
        OutputStream output;
        try {
            input = new FileInputStream(oldFile);
            output = new FileOutputStream(newFile);
            byte[] fileBuffer = new byte[1024];
            int size;
            while ((size = input.read(fileBuffer)) > 0)
                output.write(fileBuffer, 0, size);
            input.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
