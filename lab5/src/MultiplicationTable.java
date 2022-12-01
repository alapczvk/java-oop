import java.io.*;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class MultiplicationTable {
    enum properties {
        wartosc_minimum,
        wartosc_maximum,
        powtorzen_maximum,
        powtorzen_minimum,
        procent
    }
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        File file = null;
        try {
            file = new File("plik.ustawien");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        if (!file.exists()) {
            properties.put("wartosc_minimum", "1");
            properties.put("wartosc_maximum", "10");
            properties.put("powtorzen_minimum", "10");
            properties.put("powtorzen_maximum", "25");
            properties.put("procent", "70");
            // FileOutputStream out = new FileOutputStream("plik.ustawien"); //zapis do pliku
            properties.store(new FileWriter("plik.ustawien"), "Plik ustawien");
        }

        FileReader plik = new FileReader(file);
        properties.load(plik); //wczytywanie pliku
        //Random:
        int max_powt=0;
        int min_powt=0;
        int wartosc_min=0;
        int wartosc_max=0;
        float procent=0;
        try {
             max_powt = Integer.parseInt(properties.getProperty("powtorzen_maximum"));
             min_powt = Integer.parseInt(properties.getProperty("powtorzen_minimum"));
             wartosc_min = Integer.parseInt(properties.getProperty("wartosc_minimum"));
             wartosc_max = Integer.parseInt(properties.getProperty("wartosc_maximum"));
             procent = Float.parseFloat(properties.getProperty("procent"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        double questioncount = 1;
        double rightanswers = 1;
        double percentofgoodanswers = 0;
        int questionnumber=1;

       // Random generator = new Random();
        //trzeba by to wscisnac w jakiegos while
        while (true) {
           // int a1 = randomInt(wartosc_min,wartosc_max); //inicjalizacja czynnikow-randomowe inty z zakresu 1-10
           // int b1 = randomInt(wartosc_min,wartosc_max);
            Random gener=new Random();
            int a1= gener.nextInt(wartosc_min,wartosc_max);
            int b1=gener.nextInt(wartosc_min,wartosc_max);
            System.out.println(questionnumber+".podaj prawidłowy wynik dzialania " + a1 + "*" + b1);
            questionnumber=questionnumber+1;
            Scanner scanner = new Scanner(System.in);
            int result =0;
            try{
                result=scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println("mozna tylko liczby");
                System.exit(1);
            }

            if (questioncount >= min_powt) {// && questioncount<=max_powt){
                if(percentofgoodanswers>procent){
                    System.out.println("Gratulacje na "+questioncount+" pytań na "+percentofgoodanswers+"% odpowiedz byla prawidlowa");
                    break;
                }
                else if (questioncount > max_powt) {
                    System.out.println("Gra zakonczona, mniej niz 70% odp dobrych:"+percentofgoodanswers);
                    break;

            }

        }
        if (result == a1 * b1) {
            rightanswers = rightanswers + 1;

        }
            questioncount=questioncount+1;
            percentofgoodanswers=100*((rightanswers)/(questioncount));
        }
    }
    //problemem jest to ze raz wywolana funkcja generator nextint te same wyniki daje caly czas
    /*public static int randomInt(int a,int b){
        Random generator = new Random();
        return generator.nextInt((b - a)+1) + a;
    }*/
}