import javax.naming.NoPermissionException;
import java.io.*;
import java.io.IOException;
import static java.nio.file.Files.copy;
import java.net.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.Paths;
import java.lang.ClassNotFoundException;
import java.io.File;

public class FileAndURLCopy {
    public static <e> void main(String[] args) throws IOException {
        if (args.length == 0 || args.length == 1) {
            System.out.println("brak argumentów programu");
            System.exit(1);
        }
        File zrodlo = new File(args[0]);
        File koniec = new File(args[1]);
        if (args[0].endsWith(".txt")) {

            try {//kopiowanie pliku
                InputStream in = new BufferedInputStream(new FileInputStream(zrodlo));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(koniec));
                {
                    byte[] buffer = new byte[1024];
                    int lengthRead;
                    while ((lengthRead = in.read(buffer)) > 0) {
                        out.write(buffer, 0, lengthRead);
                        out.flush();
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
            if (zrodlo.isDirectory()) {
                System.out.println("to jest katalog");
                System.exit(1);
            }
            if (!zrodlo.exists()) {
                System.out.println("nie istnieje taki plik");
                System.exit(1);
            }
            if (!zrodlo.canRead()) {
                System.out.println("nie masz uprawnien do pliku");
            }
            if (koniec.exists() && !koniec.canWrite()) {
                System.out.println("nie mozna nadpisac");
            }

        }
        if(args[0].startsWith("http")){
            try{
                URL url=new URL(args[0]); //tworzenie obiektu url z podanego argumentu
                URLConnection connection= url.openConnection(); //polaczenie z url
                InputStream stream= connection.getInputStream();//potrzebujemy zapisac do pliku wiec mamy strumien wejscia
                CopyUrl(url,koniec);
            }catch(UnknownHostException e){
                System.out.println("nieprawidlowy adres: "+args[0]);
                System.exit(1);
            }catch(AccessDeniedException e ){
                System.out.println("odmowa dostepu");
                System.exit(1);
            }catch (NoRouteToHostException e){
                System.out.println("nie mozna polaczyc sie z wybranym adresem");
                System.exit(1);
            }
            catch(IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
            //copying url to file
            //CopyUrl(url,koniec);

        }
    }
    public static void CopyUrl(URL url,File koniec) throws IOException {
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(koniec);
        byte[] buffer = new byte[4096];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.close();
        is.close();
    }
}
