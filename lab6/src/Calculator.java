import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Calculator {
    public static void createAndShowGUI() {

        JFrame jf = new JFrame("Calculator");

        jf.setVisible(true);

        JPanel jp = new JPanel();

        jf.getContentPane().add(jp);
        Dimension expectedDimension = new Dimension(200, 210);
        jf.pack();
        jf.setResizable(false); //zapobiegniecie zmienianu
        jf.setLocationRelativeTo(null); //ustawienie kalkulatora na srodek
        jp.setPreferredSize(expectedDimension);
        jp.setMaximumSize(expectedDimension);
        jp.setMinimumSize(expectedDimension);
        jf.setMinimumSize(jf.getMinimumSize());
        jf.setMaximumSize(jf.getMaximumSize());

        JTextField output = new JTextField(4);

        output.setHorizontalAlignment(JTextField.RIGHT);
        output.setMaximumSize(new Dimension(180, 40));
        output.setFont(new Font("Arial", Font.BOLD, 17));
        output.setDisabledTextColor(new Color(195, 90, 236));
        output.setMargin(new Insets(0, 0, 0, 10));
        output.setText("0");
        output.setEditable(false);
        output.setBorder(new LineBorder(Color.magenta,2));
        Border border=output.getBorder();
        ((LineBorder)output.getBorder()).getLineColor();

        JPanel r1 = new JPanel();
        JPanel r2 = new JPanel();
        JPanel r3 = new JPanel();
        JPanel r4 = new JPanel();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, beq,bpl,bmi,bmu,bdi,bclear;
        beq=new JButton("=");
        r4.add(beq);
        bpl=new JButton("+");
        r1.add(bpl);
        bmi=new JButton("-");
        r2.add(bmi);
        bmu=new JButton("*");
        r3.add(bmu);
        bdi=new JButton("/");
        r4.add(bdi);
        bclear=new JButton("C");
        r4.add(bclear);
        b0=new JButton("0");
        r4.add(b0);
        b1=new JButton("1");
        r1.add(b1);
        b2=new JButton("2");
        r1.add(b2);
        b3=new JButton("3");
        r1.add(b3);
        b4=new JButton("4");
        r2.add(b4);
        b5=new JButton("5");
        r2.add(b5);
        b6=new JButton("6");
        r2.add(b6);
        b7=new JButton("7");
        r3.add(b7);
        b8=new JButton("8");
        r3.add(b8);
        b9=new JButton("9");
        jp.add(output);
        r3.add(b9);
        jp.add(r1);
        jp.add(r2);
        jp.add(r3);
        jp.add(r4);
        jp.setBackground(Color.magenta);

    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
}}