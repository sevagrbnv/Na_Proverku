package Lab7;

public class task1 {
    public static void main(String[] args) {
        String str = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        char[] arr = new char[str.length()];
        String vasyaMoney = "";
        String mashaMoney = "";

        for (int i = 0; i < str.length(); i++)
            arr[i] = str.charAt(i);

        for (int i = 0; i < str.length(); i++) {
            if (arr[i] == 'В' && arr[i + 1] == 'а' && arr[i + 2] == 'с' && arr[i + 3] == 'я') {
                i += 15;
                while (arr[i] != ' '){
                    vasyaMoney += arr[i];
                    i++;
                }
                break;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (arr[i] == 'М' && arr[i + 1] == 'а' && arr[i + 2] == 'ш' && arr[i + 3] == 'а') {
                i += 7;
                while (arr[i] != ' '){
                    mashaMoney += arr[i];
                    i++;
                }
                break;
            }
        }

        System.out.println("Сумма: " + (Integer.parseInt(vasyaMoney) + Integer.parseInt(mashaMoney)));
    }
}