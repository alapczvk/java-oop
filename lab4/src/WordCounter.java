import java.io.*;
import java.nio.file.Paths;
import java.lang.String;
import java.lang.Integer;

public class WordCounter {
    public static <e> void main(String[] args) throws IOException{
        if( args.length==0){
            System.out.println("brak argumentów programu");
            System.exit(1);
        }
       // String filename = args[0]; //pierwszy argument, pierwszy indeks
        String filename = getFilename(args);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        String line="";// '' pojedyncze- char
        int lines = 0;
        int wordscount=0;
        int chars=0;

        while ((line=reader.readLine()) != null){// line wpisuje to co reader wypluje i dopoki jest rozne od null
            lines++;
            String words[]=line.split(" "); //do tablicy slowa wpisuja si pojedyncze wurazy
            wordscount=wordscount+words.length;//przypisuje dlugosc tablicy zeby sie nie nadpisywalo
            //przelatuje po wszystkich elementach tej tablicy words
            chars=chars+line.length(); //cala dlugosc linii razem ze spacjami

        }// lines++;
        reader.close();
        String zwrot=getargs(args); //przekazujemy wynik z funkcji
        boolean C=zwrot.contains("c");
        boolean L=zwrot.contains("l");
        boolean W=zwrot.contains("w");
        if(L){
            System.out.println("wiersze "+lines);
        }
        if(C){
            System.out.println("znaki "+chars);
        }
        if(W){
            System.out.println("wyrazy "+wordscount);
        }
        if(!C && !W && !L){
            System.out.println("Liczba wierszy " + lines);
            System.out.println("liczba słów "+wordscount);
            System.out.println("Liczba znakow "+ chars);
        }

    }
    private static String getargs(String[] args){
        String wynik="";
        for (String arg:args){
            if(arg.startsWith("-")){
                for(int i=1;i<arg.length();i++){ //nie 0 bo tam pauza
                    wynik=wynik+arg.charAt(i); //dziala tak jak z tablica

                }
            }
        }
    return wynik;
    }
    private static String getFilename(String[] args) { //zwracanie pierwszego argumenty niezacyznajace sie od pauzy
        for (String arg : args) {
            if (!arg.startsWith("-")) {
                return arg;
            }
        }
        return null;
    }

}
//parse argumenty