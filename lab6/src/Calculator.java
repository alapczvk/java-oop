import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator {
    public static void createAndShowGUI() {
        JFrame jf = new JFrame("Calculator");
        jf.setVisible(true);

        JPanel jp = new JPanel();
        jf.getContentPane().add(jp);

        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
}}