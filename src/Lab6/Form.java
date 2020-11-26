package Lab6;

import javax.swing.*;
import java.util.Random;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class Form {

    private JPanel panel1;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;

    private JButton[] button;

    private int step;

    void compStep(){
        Random random = new Random();
        int a = random.nextInt(9);
        if (Lab6.arr[a] == 0) {
            button[a].setText("0");
            button[a].setEnabled(false);
            Lab6.arr[a] = 2;
            if (Lab6.win()) {
                System.out.println("Победил Нолик");
                System.exit(0);
            }
        }
        else compStep();
    }

    public Form() {
        button = new JButton[9];
        button[0] = button0;
        button[1] = button1;
        button[2] = button2;
        button[3] = button3;
        button[4] = button4;
        button[5] = button5;
        button[6] = button6;
        button[7] = button7;
        button[8] = button8;

        step = 0;
        button0.addActionListener(e -> {
            if (!Lab6.comp) {
                Lab6.arr[0] = step % 2 + 1;
                if (Lab6.arr[0] == 1)
                    button0.setText("X");
                else button0.setText("0");
                button0.setEnabled(false);
                if (Lab6.win()) {
                    if (Lab6.arr[0] == 1) System.out.println("Победил Крестик");
                    else System.out.println("Победил Нолик");
                    System.exit(0);
                }
            }
            else {
                Lab6.arr[0] = 1;
                button0.setText("X");
                button0.setEnabled(false);

                if (Lab6.win()) {
                    if (Lab6.arr[0] == 1) {
                        System.out.println("Победил Крестик");
                        System.exit(0);
                    }
                }
                step++;
                compStep();
            }
            step++;
        });

        button1.addActionListener(e -> {
            if (!Lab6.comp) {
                Lab6.arr[1] = step % 2 + 1;
                if (Lab6.arr[1] == 1)
                    button1.setText("X");
                else button1.setText("0");
                button1.setEnabled(false);
                if (Lab6.win()) {
                    if (Lab6.arr[1] == 1) System.out.println("Победил Крестик");
                    else System.out.println("Победил Нолик");
                    System.exit(0);
                }
            }
            else {
                Lab6.arr[1] = 1;
                button1.setText("X");
                button1.setEnabled(false);

                if (Lab6.win()) {
                    if (Lab6.arr[1] == 1) {
                        System.out.println("Победил Крестик");
                        System.exit(0);
                    }
                }
                step++;
                compStep();
            }
            step++;
        });

        button2.addActionListener(e -> {
            if (!Lab6.comp) {
                Lab6.arr[2] = step % 2 + 1;
                if (Lab6.arr[2] == 1)
                    button2.setText("X");
                else button2.setText("0");
                button2.setEnabled(false);
                if (Lab6.win()) {
                    if (Lab6.arr[2] == 1) System.out.println("Победил Крестик");
                    else System.out.println("Победил Нолик");
                    System.exit(0);
                }
            }
            else {
                Lab6.arr[2] = 1;
                button2.setText("X");
                button2.setEnabled(false);

                if (Lab6.win()) {
                    if (Lab6.arr[2] == 1) {
                        System.out.println("Победил Крестик");
                        System.exit(0);
                    }
                }
                step++;
                compStep();
            }
            step++;
        });

        button3.addActionListener(e -> {
            if (!Lab6.comp){
                Lab6.arr[3] = step % 2 + 1;
                if (Lab6.arr[3] == 1)
                    button3.setText("X");
                else button3.setText("0");
                button3.setEnabled(false);
                if (Lab6.win()) {
                    if (Lab6.arr[3] == 1) System.out.println("Победил Крестик");
                    else System.out.println("Победил Нолик");
                    System.exit(0);
                }
            }
            else {
                Lab6.arr[3] = 1;
                button3.setText("X");
                button3.setEnabled(false);

                if (Lab6.win()) {
                    if (Lab6.arr[0] == 1) {
                        System.out.println("Победил Крестик");
                        System.exit(0);
                    }
                }
                step++;
                compStep();
            }
            step++;
        });

        button4.addActionListener(e -> {
            if (!Lab6.comp) {
                Lab6.arr[4] = step % 2 + 1;
                if (Lab6.arr[4] == 1)
                    button4.setText("X");
                else button4.setText("0");
                button4.setEnabled(false);
                if (Lab6.win()) {
                    if (Lab6.arr[4] == 1) System.out.println("Победил Крестик");
                    else System.out.println("Победил Нолик");
                    System.exit(0);
                }
            }
            else {
                Lab6.arr[4] = 1;
                button4.setText("X");
                button4.setEnabled(false);

                if (Lab6.win()) {
                    if (Lab6.arr[4] == 1) {
                        System.out.println("Победил Крестик");
                        System.exit(0);
                    }
                }
                step++;
                compStep();
            }
            step++;
        });

        button5.addActionListener(e -> {
            if (!Lab6.comp) {
                Lab6.arr[5] = step % 2 + 1;
                if (Lab6.arr[5] == 1)
                    button5.setText("X");
                else button5.setText("0");
                button5.setEnabled(false);
                if (Lab6.win()) {
                    if (Lab6.arr[5] == 1) System.out.println("Победил Крестик");
                    else System.out.println("Победил Нолик");
                    System.exit(0);
                }
            }
            else {
                Lab6.arr[5] = 1;
                button5.setText("X");
                button5.setEnabled(false);

                if (Lab6.win()) {
                    if (Lab6.arr[5] == 1) {
                        System.out.println("Победил Крестик");
                        System.exit(0);
                    }
                }
                step++;
                compStep();
            }
            step++;
        });

        button6.addActionListener(e -> {
            if (!Lab6.comp) {
                Lab6.arr[6] = step % 2 + 1;
                if (Lab6.arr[6] == 1)
                    button6.setText("X");
                else button6.setText("0");
                button6.setEnabled(false);
                if (Lab6.win()) {
                    if (Lab6.arr[6] == 1) System.out.println("Победил Крестик");
                    else System.out.println("Победил Нолик");
                    System.exit(0);
                }
            }
            else {
                Lab6.arr[6] = 1;
                button6.setText("X");
                button6.setEnabled(false);

                if (Lab6.win()) {
                    if (Lab6.arr[6] == 1) {
                        System.out.println("Победил Крестик");
                        System.exit(0);
                    }
                }
                step++;
                compStep();
            }
            step++;
        });

        button7.addActionListener(e -> {
            if (!Lab6.comp) {
                Lab6.arr[7] = step % 2 + 1;
                if (Lab6.arr[7] == 1)
                    button7.setText("X");
                else button7.setText("0");
                button7.setEnabled(false);
                if (Lab6.win()) {
                    if (Lab6.arr[7] == 1) System.out.println("Победил Крестик");
                    else System.out.println("Победил Нолик");
                    System.exit(0);
                }
            }
            else {
                Lab6.arr[7] = 1;
                button7.setText("X");
                button7.setEnabled(false);

                if (Lab6.win()) {
                    if (Lab6.arr[7] == 1) {
                        System.out.println("Победил Крестик");
                        System.exit(0);
                    }
                }
                step++;
                compStep();
            }
            step++;
        });

        button8.addActionListener(e -> {
            if (!Lab6.comp) {
                Lab6.arr[8] = step % 2 + 1;
                if (Lab6.arr[8] == 1)
                    button8.setText("X");
                else button8.setText("0");
                button8.setEnabled(false);
                if (Lab6.win()) {
                    if (Lab6.arr[8] == 1) System.out.println("Победил Крестик");
                    else System.out.println("Победил Нолик");
                    System.exit(0);
                }
            }
            else {
                Lab6.arr[8] = 1;
                button8.setText("X");
                button8.setEnabled(false);

                if (Lab6.win()) {
                    if (Lab6.arr[8] == 1) {
                        System.out.println("Победил Крестик");
                        System.exit(0);
                    }
                }
                step++;
                compStep();
            }
            step++;
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
