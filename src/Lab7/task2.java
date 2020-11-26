package Lab7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import  java.io.IOException;

public class task2{
    public static void main(String[] args) throws  IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++)
            arr[i] = str.charAt(i);
        int spaces = 0;
        String firstName = "";
        String lastName = "";
        String fatherName = "";

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == ' ') spaces++;

        if (spaces == 0 || spaces > 2) {
            System.out.println("Введенная строка не является ФИО");
            System.exit(0);
        }
        else{
            int count = 0;
            for (int i = 0; i < arr.length; i++){
                if (arr[i] != ' '){
                    lastName += arr[i];
                }
                else {
                    count = i + 1;
                    break;
                }
            }
            for (int i = count; i < arr.length; i++){
                if (arr[i] != ' '){
                    firstName += arr[i];
                }
                else {
                    count = i + 1;
                    break;
                }
            }
            for (int i = count; i < arr.length; i++){
                if (arr[i] != ' '){
                    fatherName += arr[i];
                }
            }
        }

        System.out.println("Фамилия: " + lastName);
        System.out.println("Имя: " + firstName);
        System.out.println("Отчество: " + fatherName);
    }
}
