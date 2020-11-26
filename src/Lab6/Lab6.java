package Lab6;

import javax.swing.*;

/*
Лаба 10 (Калькулятор) находится в Lab5, это крестики-нолики, они проверены
*/

public class Lab6 {
    JFrame frame;
    public static int[] arr;
    static boolean comp;
    public static void main(String[] args) {

        Object[] possibilities = {"1 игрок", "2 игрока"};
        String dev=(String)JOptionPane.showInputDialog(null,"Выберите количество игроков",
                "Старт",JOptionPane.PLAIN_MESSAGE,null,possibilities,null);
        if (dev.equals("1 игрок")) comp = true;
        else comp = false;

        Lab6 l6 = new Lab6();
        l6.run();

        arr = new int[9];
        for (int i = 0; i < 9; i++)
            arr[i] = 0;
    }



    public void run(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,450);
        frame.setResizable(false);


        frame.add(new Form().getPanel1());
        frame.setVisible(true);

    }

    public static boolean win(){
        for (int i = 0; i < 7; i+=3)
            if (arr[i] != 0 && arr[i] == arr[i + 1] && arr[i] == arr[i + 2])
                return true;

        for (int i = 0; i < 3; i++)
            if (arr[i] != 0 && arr[i] == arr[i + 3] && arr[i] == arr[i + 6])
                return true;

        if (arr[0] != 0 && arr[4] == arr[0] && arr[0] == arr[8])
            return true;

        if (arr[2] != 0 && arr[4] == arr[2] && arr[2] == arr[6])
            return true;

        int a = 0;
        for (int i = 0; i < 9; i++){

            if (arr[i] != 0) a++;
            if (a == 9) {
                System.out.println("Ничья");
                System.exit(0);
            }
        }

        return false;
    }

}
