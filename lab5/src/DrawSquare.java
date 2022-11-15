import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.math.*;

public class DrawSquare {

    public static <e> void main(String[] args) throws IOException {
        System.out.println("podaj dlugosc boku");
        Scanner scanner = new Scanner(System.in);//tworze obiekt scanner i potem wczytuje
        int bok = scanner.nextInt();
        if (bok <= 0) {
            System.out.println("blad matematyczny");
            System.exit(1);
        }
        drawShape(bok);

    }

    public static void drawShape(int bok) {
        /*for(int i=1; i<=bok;i++){
            for(int j=1; j<=bok;j++) {
                System.out.print(" # ");
            }
            System.out.println("\n");
        }*/
        String spacja=" ";//wypelnienie w srodku
        spacja = " ".repeat(bok-2);
        System.out.println(spacja);
        for(int i=1;i<=bok;i++){
            System.out.print("#");
        }
        System.out.print("\n");
        for(int j=2;j<=bok;j++){
           // System.out.println("# "+(j-2)+"#");
            System.out.println("#"+spacja+"#"); //lewy bok

        }
        /*for(int k=1;k<=bok-2;k++) {
            System.out.print(spacja + "x");
        }*/
        for(int i=1;i<=bok;i++){
            System.out.print("#");
    }
    }
}