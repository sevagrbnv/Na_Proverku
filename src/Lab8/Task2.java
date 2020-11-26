package Lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

// добавлена проверка на наличие текста после точки

public class Task2 {
    private static TreeSet<String> emails = new TreeSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (;;){
            String comand = reader.readLine();
            if (comand.contains("LIST") && comand.indexOf("LIST") == 0){
                doListEmails();
            }
            else if (comand.contains("ADD ") && comand.indexOf("ADD ") == 0) {
                doAddEmail(comand);
            }
            else if (comand.equals("EXIT")) System.exit(0);
            else System.out.println("Неверная команда");
        }
    }

    public static void doListEmails(){
        System.out.println(emails);
    }

    public static void doAddEmail(String comand){
        comand = comand.replace("ADD ", "");
        if (comand.contains("@") && comand.contains(".") && !comand.endsWith(".")
                && ((comand.charAt(0) >= 'A' && comand.charAt(0) <= 'Z' )
                || (comand.charAt(0) >= 'a' && comand.charAt(0) <= 'z'))){
            emails.add(comand);
        }
        else System.out.println("Некорректный e-mail");
    }
}
