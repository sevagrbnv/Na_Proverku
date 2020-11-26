package Lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        number = number.replace("+", "");
        number = number.replace("-","");
        number = number.replace("(", "");
        number = number.replace(")", "");
        number = number.replace(" ", "");
        System.out.println(number);

        if (number.length() != 11 && number.length() != 10){
            System.out.println("Неверный формат номера");
            System.exit(0);
        }

        if (number.length() == 11 && number.charAt(0) != '7' && number.charAt(0) != '8'){
            System.out.println("Неверный формат номера");
            System.exit(0);
        }

        if (number.length() == 10)
            number = "7" + number;

        System.out.println("+7 (" + number.charAt(1) + number.charAt(2) + number.charAt(3) + ") " +
                number.charAt(4) + number.charAt(5) + number.charAt(6) + "-" +
                number.charAt(7) + number.charAt(8) + "-" +
                number.charAt(9) + number.charAt(10));
    }
}