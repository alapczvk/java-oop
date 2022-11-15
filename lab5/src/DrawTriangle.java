import java.io.IOException;
import java.util.Scanner;

public class DrawTriangle {
    public static <e> void main(String[] args) throws IOException {
        System.out.println("podaj wysokosc piramidy");
        Scanner scanner = new Scanner(System.in);//tworze obiekt scanner i potem wczytuje
        int linecount = scanner.nextInt();
        if (linecount < 2) {
            System.out.println("blad matematyczny");
            System.exit(1);
        }
        DrawThisShape(linecount);

    }
    public static void DrawThisShape(int linecount){

        for(int i=1;i<=linecount;i++){
            for(int j=1;j<=linecount-i;j++){
                System.out.print(" ");//pionowa linia z hasztagow na srrodku
            }
            for (int k=1;k<=2*i-1;k++){
                System.out.print("#");
            }
            System.out.println("\n");
            }


    }
}
