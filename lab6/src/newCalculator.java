import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class newCalculator {
    public static void createAndShowGUI() {
        JFrame jf = new JFrame("Calculator");
        jf.setVisible(true);
        jf.setPreferredSize(new Dimension(390, 300));
        jf.setResizable(false); //
        jf.setLocationRelativeTo(null);
        JPanel jp = new JPanel();
        jf.getContentPane().add(jp);
        jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS)); //ladnie uporzadkowane
        JTextField output = new JTextField(4);
        output.setMargin(new Insets(0,0,0, 10));
        output.setText("0");
        output.setHorizontalAlignment(JTextField.RIGHT);
        output.setMaximumSize(new Dimension(390, 40));
        output.setFont(new Font("Arial", Font.BOLD, 17));
        output.setEditable(false);
        jf.getContentPane().add(jp);
        jf.pack();
        jp.setLayout(new GridLayout(5, 0, 5, 15));
        jp.setBorder(new EmptyBorder(10, 10, 10,10));

        JPanel r1 = new JPanel();
        JPanel r2 = new JPanel();
        JPanel r3 = new JPanel();
        JPanel r4 = new JPanel();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, beq,bpl,bmi,bmu,bdi,bclear;

        beq=new JButton("=");
        //beq.setBackground(Color.gray);
        beq.addActionListener(new MyActionListener());
        //r4.add(beq);
        bpl=new JButton("+");
        //bpl.setBackground(Color.gray);
        bpl.addActionListener(new MyActionListener());
        //r1.add(bpl);
        bmi=new JButton("-");
        //bmi.setBackground(Color.gray);
        bmi.addActionListener(new MyActionListener());
        //r2.add(bmi);
        bmu=new JButton("*");
        //bmu.setBackground(Color.gray);
        bmu.addActionListener(new MyActionListener());
        //r3.add(bmu);
        bdi=new JButton("/");
        //bdi.setBackground(Color.gray);
        bdi.addActionListener(new MyActionListener());
        //r4.add(bdi);
        bclear=new JButton("C");
        //bclear.setBackground(Color.gray);
        bclear.addActionListener(new MyActionListener());
        //r4.add(bclear);
        b0=new JButton("0");
        //b0.setBackground(Color.gray);
        b0.addActionListener(new MyActionListener());
        //r4.add(b0);
        b1=new JButton("1");
        //b1.setBackground(Color.gray);
        b1.addActionListener(new MyActionListener());
        //r1.add(b1);
        b2=new JButton("2");
        //b2.setBackground(Color.gray);
        b2.addActionListener(new MyActionListener());
        //r1.add(b2);
        b3=new JButton("3");
        //b3.setBackground(Color.gray);
        b3.addActionListener(new MyActionListener());
        //r1.add(b3);
        b4=new JButton("4");
        //b4.setBackground(Color.gray);
        b4.addActionListener(new MyActionListener());
        //r2.add(b4);
        b5=new JButton("5");
        //b5.setBackground(Color.gray);
        b5.addActionListener(new MyActionListener());
        //r2.add(b5);
        b6=new JButton("6");
        //b6.setBackground(Color.gray);
        b6.addActionListener(new MyActionListener());
        //r2.add(b6);
        b7=new JButton("7");
        //b7.setBackground(Color.gray);
        b7.addActionListener(new MyActionListener());
        //r3.add(b7);
        b8=new JButton("8");
        //b8.setBackground(Color.gray);
        b8.addActionListener(new MyActionListener());
        r3.add(b8);
        b9=new JButton("9");
        b9.addActionListener(new MyActionListener());
        // b9.setBackground(Color.gray);
        // r3.add(b9);
        for (JButton b : Arrays.asList(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, beq,bpl,bmi,bmu,bdi,bclear)){
            Dimension dimension=new Dimension(75,31);
            b.setPreferredSize(dimension);
            r4.add(beq);
            r1.add(bpl);
            r2.add(bmi);
            r3.add(bmu);
            r4.add(bdi);
            r4.add(bclear);
            r4.add(b0);
            r1.add(b1);
            r1.add(b2);
            r1.add(b3);
            r2.add(b4);
            r2.add(b5);
            r2.add(b6);
            r3.add(b7);
            r3.add(b8);
            r3.add(b9);


        }

        jp.add(output);
        jp.add(r1);
        jp.add(r2);
        jp.add(r3);
        jp.add(r4);

    }
    public void Actions(){

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
    }}
class MyActionListener implements java.awt.event.ActionListener {

    public void actionPerformed(ActionEvent e) {
        System.out.println("Button = "+e.getActionCommand());
    }

}