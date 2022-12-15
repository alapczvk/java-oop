import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private static JTextField output;
    private static int temp, num1, num2;
    private static String sign;
    private static String lastBtnPressed = "action";
    private static boolean dividingByZero = false;
    private static boolean solved = true;

    public static void createAndShowGUI() {

        // tworzymy action listener
        ActionListener myActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pressedBtnLabel = e.getActionCommand();

                System.out.println("Button = " + pressedBtnLabel);

                switch (pressedBtnLabel) {
                    case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> numberBtnPressed(pressedBtnLabel); // funkcje anonimowe, szyszy switch nie trzeba breakow
                    case "+", "-", "*", "/" -> signBtnPressed(pressedBtnLabel);
                    case "=" -> equalsBtnPressed();
                    case "C" -> clean();
                }
            }
        };

        JFrame jf = new JFrame("Calculator");
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setSize(420, 350);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp = new JPanel();

        // generowanie przycisków funkcyjnych
        JButton equalsBtn, addBtn, subtractBtn, multiBtn, divisionBtn, clearBtn;
        equalsBtn   = new JButton("=");
        addBtn      = new JButton("+");
        subtractBtn = new JButton("-");
        multiBtn    = new JButton("*");
        divisionBtn = new JButton("/");
        clearBtn    = new JButton("C");

        // dodawanie action listenerow do kazdego przycisku
        equalsBtn.addActionListener(myActionListener);
        addBtn.addActionListener(myActionListener);
        subtractBtn.addActionListener(myActionListener);
        multiBtn.addActionListener(myActionListener);
        divisionBtn.addActionListener(myActionListener);
        clearBtn.addActionListener(myActionListener);

        // generowanie przycisków z cyframi
        JButton[] numBtns = new JButton[10]; // lista z przyciskami numerycznymi
        for(int i = 0; i < numBtns.length; i++) {
            numBtns[i] = new JButton(String.valueOf(i)); // etykieta przycisku
            numBtns[i].addActionListener(myActionListener);
        }
        jp.setBounds(5,50,390,300);
        jp.setLayout(new GridLayout(5,4,5,5));
        jp.add(addBtn);
        jp.add(numBtns[1]);
        jp.add(numBtns[2]);
        jp.add(numBtns[3]);
        jp.add(subtractBtn);
        jp.add(numBtns[4]);
        jp.add(numBtns[5]);
        jp.add(numBtns[6]);
        jp.add(multiBtn);
        jp.add(numBtns[7]);
        jp.add(numBtns[8]);
        jp.add(numBtns[9]);
        jp.add(equalsBtn);
        jp.add(divisionBtn);
        jp.add(clearBtn);
        clearBtn.setBackground(Color.pink);
        jp.add(numBtns[0]);

        // ustawienia text field
        output = new JTextField();
        output.setBounds(5, 5, 380, 30);
        output.setFont(new Font("Arial", Font.BOLD,16));
        output.setHorizontalAlignment(JTextField.RIGHT);
        output.setEditable(false);
        output.setBackground(Color.pink);
        output.setText("0");
        output.setMargin(new Insets(0, 0, 0, 10));
        jf.add(output);
        jf.add(jp);
        jf.setVisible(true);
    }
    //////////algorytm
    public static void numberBtnPressed(String pressed) {
        if (dividingByZero) {
            clean();
        }

        if (lastBtnPressed.equals("action") || output.getText().startsWith("0")) {
            output.setText("");
        }

        if (lastBtnPressed.equals("equal")) {
            output.setText("");
            sign = null;
        }

        // dodajemy wcisniety numer do pola tekstowego
        output.setText(output.getText().concat(pressed));

        // ustawiamy ostatni wcisniety przycisk na numerek
        lastBtnPressed = "number";
    }

    private static void signBtnPressed(String pressedBtn) {
        if (dividingByZero) {
            return;
        }

        if (lastBtnPressed.equals("action")) {
            sign = pressedBtn;
            solved = false;
            return;
        }

        if (!solved) {
            equalsBtnPressed();
            solved = true;
        }

        num2 = Integer.parseInt(output.getText());
        sign = pressedBtn;
        solved = false;
        lastBtnPressed = "action";
    }

    private static void equalsBtnPressed() {
        if (dividingByZero) {
            return;
        }

        if (sign == null) {
            solved = true;
            lastBtnPressed = "action";

            // jesli pole tekstowe jest puste
            if (!output.getText().isEmpty()) {
                // ustawiamy numer2 na wartosc z pola testowego
                num2 = Integer.parseInt(output.getText());
            }

            return;
        }

        if (lastBtnPressed.equals("equal")) {
            num2 = temp;
        } else {
            temp = num2;
            num1= Integer.parseInt(output.getText());
        }

        switch (sign) {
            case "+" -> temp = num1 + num2;
            case "-" -> temp = num2 - num1;
            case "*" -> temp = num1 * num2;
            case "/" -> {
                if (num1 == 0) {
                    clean();
                    output.setBackground(Color.RED);
                    output.setText("syntax error");
                    dividingByZero = true;
                    return;
                }
                temp = num2 / num1;
            }
        }
        output.setText(String.valueOf(temp));
        lastBtnPressed = "equal";
        solved = true;
    }

    public static void clean() { //powrot do ustawien domyslnych kalkulatora
        output.setBackground(Color.pink); // resetowanie koloru
        output.setText("0");
        num1 = 0;
        num2 = 0;

        sign = null;
        lastBtnPressed = "action";
        dividingByZero = false;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Calculator::createAndShowGUI);
    }
}
