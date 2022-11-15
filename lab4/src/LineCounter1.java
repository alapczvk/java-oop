import java.io.*;
import java.nio.file.Paths;
import java.lang.String;
import java.lang.Integer;
import javax.swing.JOptionPane;

public class LineCounter1 {
    public static <e> void main(String[] args) throws IOException{

        String filename =JOptionPane.showInputDialog("podaj"); //joptionpane
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();

        System.out.println("Liczba wierszy w pliku " + filename + " wynosi: " + lines);
    }

}


