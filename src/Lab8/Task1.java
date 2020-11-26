package Lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


//EDITтеперь нормально работает,когда в списке 1 элемент
//ADD добаляет элемент с пустым индексом в конец массива
public class Task1 {
    private static ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (;;){
            String comand = reader.readLine();

            if (comand.contains("LIST") && comand.indexOf("LIST") == 0){
                doLIST();
            }

            else if (comand.contains("ADD ") && comand.indexOf("ADD ") == 0){
                doADD(comand);
            }

            else if (comand.contains("EDIT ") && comand.indexOf("EDIT ") == 0){
                doEDIT(comand);
            }

            else if (comand.contains("DELETE ") && comand.indexOf("DELETE ") == 0){
                doDELETE(comand);
            }

            else if (comand.equals("EXIT")) System.exit(0);

            else System.out.println("Команда введена неверно, попробуйте снова");
        }
    }

    public static void doLIST(){
        for (int i = 0; i < todoList.size(); i++)
            System.out.println(i + 1 + ": " + todoList.get(i));
    }

    public static void doADD(String comand){
        comand = comand.replace("ADD ", "");

        try {
            int i = 0;
            String number = "";
            while (comand.charAt(i) != ' ' && i < comand.length() - 1){
                number += comand.charAt(i);
                i++;
            }

            if (Integer.parseInt(number) < todoList.size() && Integer.parseInt(number) > -1){
                comand = comand.replace(number + " ", "");
                todoList.add(Integer.parseInt(number) - 1, comand);
            }
            else if(Integer.parseInt(number) > todoList.size()){
                comand = comand.replace(number + " ", "");
                todoList.add(comand);
            }
            else System.out.println("В списке не так много дел");
        } catch (NumberFormatException nfe) {
            todoList.add(comand);
        }
    }

    public static void doEDIT(String comand){
        comand = comand.replace("EDIT ", "");

        int i = 0;
        String number = "";
        while (comand.charAt(i) != ' ' && i < comand.length() - 1) {
            number += comand.charAt(i);
            i++;
        }

        try{
            if (Integer.parseInt(number) <= todoList.size() && Integer.parseInt(number) > -1){
                comand = comand.replace(number + " ", "");
                todoList.add((Integer.parseInt(number)) - 1, comand);
                todoList.remove(Integer.parseInt(number));

            }
            else System.out.println("Такого элемента не существует");
        } catch (NumberFormatException nfe){
            System.out.println("Укажите номер");
        }
    }

    public static void doDELETE(String comand){
        comand = comand.replace("DELETE ", "");

        int i = 0;
        String number = "";
        while (i < comand.length()) {
            number += comand.charAt(i);
            i++;
        }

        if (Integer.parseInt(number) <= todoList.size() && Integer.parseInt(number) > -1){
            todoList.remove(Integer.parseInt(number) - 1);
        }
        else System.out.println("Такого элемента не существует");
    }
}
