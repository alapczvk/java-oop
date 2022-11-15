
import java.io.*;
import java.nio.file.Paths;
import java.lang.String;
import java.lang.Integer;

public class LineCounter {
    public static <e> void main(String[] args) throws IOException{
        if( args.length==0){
            System.out.println("brak argumentów programu");
            System.exit(1);
        }
        String filename = args[0]; //pierwszy argument, pierwszy indeks
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


