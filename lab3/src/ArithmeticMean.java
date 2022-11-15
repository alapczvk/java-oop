import java.lang.Integer;
import java.lang.Math;
//get instance zwaraca nam defaulowy jeden cosiek bo w klasach abstrakcyjnych nie da sie stworzyc konstruktora, zwraca nam referencje do czegos
public class ArithmeticMean {
    public static void main(String args[]) {
        if (args.length==0){
            System.out.println("brak argumentów programu"); //args to stirngi trzeb
            return;
        }
        int suma=0;

         String inty="";
        for(String i:args){ //i przechodzi po kazdym argumencie args odwołuje się jako i jak for( i=0; i<10; i++)
           // int inty=inty+i+" ";
            inty=inty+i+" "; //dodajemy stringi
            int w=Integer.parseInt(i);
            suma=suma+w;


        }
    }

}
