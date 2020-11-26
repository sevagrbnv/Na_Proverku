package Lab5;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class Lab5 {
    private JFrame frame;

    private JTextField input1;
    private JTextField input2;
    private JTextField output;//Калькулятов(Лаба 10)

    private JPanel buttons;
    private Component[] buttonsOfSymbols;
    private Symbols symbol = Symbols.NONE;

    private DocumentListener docListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            if (input1.getText().length() == 1)
                input1.setText("0");
            calculate();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (input1.getText().length() == 1)
                input1.setText("0");
            calculate();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            if (input1.getText().length() == 1)
                input1.setText("0");
            calculate();
        }
    };

    public static void main(String[] args) {
        Lab5 l5 = new Lab5();
        l5.setFrame();
    }

    public void setFrame() {
        frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500, 200);
        frame.setSize(235, 300);
        JPanel mainLayout = setMainLayout();
        frame.setResizable(false);
        frame.getContentPane().add(mainLayout);
        frame.pack();
        frame.setVisible(true);
    }

    public Lab5() {
        input1 = new JTextField();
        input1.setHorizontalAlignment(JTextField.CENTER);
        input1.setMaximumSize(new Dimension(50,50));
        input1.setPreferredSize(new Dimension(50, 50));
        input1.setText("0");
        input1.getDocument().addDocumentListener(docListener);

        input2 = new JTextField();
        input2.setHorizontalAlignment(JTextField.CENTER);
        input2.setMaximumSize(new Dimension(50,50));
        input2.setPreferredSize(new Dimension(50, 50));
        input2.setText("0");
        input2.getDocument().addDocumentListener(docListener);

        output = new JTextField();
        output.setHorizontalAlignment(JTextField.CENTER);
        output.setEnabled(false);
        output.setMaximumSize(new Dimension(50,50));
        output.setPreferredSize(new Dimension(50,50));
        output.setText("0");

        buttons = new JPanel(new FlowLayout());
        setButtons();
        buttonsOfSymbols = buttons.getComponents();
    }

    private JPanel setMainLayout() {
        JPanel textFields = new JPanel(new GridLayout(4,1));
        textFields.add(input1);
        textFields.add(buttons);
        textFields.add(input2);
        textFields.add(output);
        JPanel mainLayout = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainLayout.add(textFields);
        return mainLayout;
    }

    private void setButtons() {
        JButton sum = new JButton("+");
        sum.setSize(50, 50);
        sum.addActionListener((event)->{
            setEnabled(Symbols.SUM);
        });

        JButton min = new JButton("-");
        min.setSize(50, 50);
        min.addActionListener((event)->{
            setEnabled(Symbols.MIN);
        });

        JButton mult = new JButton("*");
        mult.setSize(50, 50);
        mult.addActionListener((event)->{
            setEnabled(Symbols.MULT);
        });

        JButton div = new JButton("/");
        div.setSize(50, 50);
        div.addActionListener((event)->{
            setEnabled(Symbols.DIV);
        });

        buttons.add(sum);
        buttons.add(min);
        buttons.add(mult);
        buttons.add(div);
    }

    private void calculate() {
        double in1 = Double.parseDouble(input1.getText());
        double in2 = Double.parseDouble(input2.getText());

        switch (this.symbol) {
            case SUM: {
                output.setText(String.valueOf(in1 + in2));
                break;
            }
            case MIN: {
                output.setText(String.valueOf(in1 - in2));
                break;
            }
            case MULT: {
                output.setText(String.valueOf(in1 * in2));
                break;
            }
            case DIV: {
                output.setText(String.valueOf(in1 / in2));
                break;
            }
            case NONE: {
                break;
            }
        }
    }

    private void setEnabled(Symbols symbol) {
        switch (this.symbol) {
            case SUM: {
                JButton button = (JButton) buttonsOfSymbols[0];
                button.setSelected(false);
                break;
            }
            case MIN :{
                JButton button = (JButton) buttonsOfSymbols[1];
                button.setSelected(false);
                break;
            }
            case MULT:{
                JButton button = (JButton) buttonsOfSymbols[2];
                button.setSelected(false);
                break;
            }
            case DIV: {
                JButton button = (JButton) buttonsOfSymbols[3];
                button.setSelected(false);
                break;
            }
        }

        switch (symbol) {
            case SUM: {
                JButton button = (JButton) buttonsOfSymbols[0];
                button.setSelected(true);
                break;
            }
            case MIN :{
                JButton button = (JButton) buttonsOfSymbols[1];
                button.setSelected(true);
                break;
            }
            case MULT:{
                JButton button = (JButton) buttonsOfSymbols[2];
                button.setSelected(true);
                break;
            }
            case DIV: {
                JButton button = (JButton) buttonsOfSymbols[3];
                button.setSelected(true);
                break;
            }
        }
        this.symbol = symbol;
        calculate();
    }
}

enum Symbols {
    NONE,
    SUM,
    MIN,
    MULT,
    DIV
}