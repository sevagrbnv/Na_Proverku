package Lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;


//Добалена проверка номера при вводе имени
//реализовано так, что один человек может иметь несколько номеров
public class Task3 {
    private static TreeMap<String, String> phoneBook = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (;;){
            String str = reader.readLine();

            if (str.equals("LIST")){
                for (String key : phoneBook.keySet()){
                    System.out.println(phoneBook.get(key) + ": " + key);
                }
            }

            else if (phoneBook.containsKey(str))
                System.out.println(phoneBook.get(str) + ": " + str);

            else if (phoneBook.containsValue(str)){
                for (String key : phoneBook.keySet()){
                    if (phoneBook.get(key).equals(str))
                        System.out.println(phoneBook.get(key) + ": " + key);
                }
            }
            else if (isNumber(str)){
                System.out.println("Введите имя");
                String name = reader.readLine();
                phoneBook.put(str, name);
            }
            else {
                System.out.println("Введите номер");
                String num = reader.readLine();
                if (isNumber(num))
                    phoneBook.put(num, str);
                else System.out.println("Неверный номер");
            }
        }
    }

    static boolean isNumber(String number){
        number = number.replace("+", "");
        number = number.replace(" ", "");
        number = number.replace("(", "");
        number = number.replace(")", "");
        number = number.replace("-", "");

        if (number.length() == 11 || number.length() == 10){
            try {
                if (Double.parseDouble(number) != 0){
                    return true;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
