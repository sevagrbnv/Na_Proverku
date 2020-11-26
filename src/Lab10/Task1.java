package Lab10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task1 {
    public static PrintWriter writer;

    public static void main(String[] args) {
        File file = new File("logs");
        file.mkdir();
        setLogFile();

        try{
            for (int i = 0; i <= 20; i++)
                log("Вывод цифры в цикле" + i);
            writer.flush();
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //как я понял, логировать - это печатать в какой момент времени что происходит
    public static void log(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss:SS");
        String str = dateFormat.format(new Date()) + " " + message + " ";

        try {
            writer.println(str);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setLogFile(){
        try{
            writer = new PrintWriter(new FileOutputStream(new File("logs/log.txt"),true));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
