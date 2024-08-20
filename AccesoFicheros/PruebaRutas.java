package AccesoFicheros;

import java.io.File;

public class PruebaRutas {
    public static void main(String[] args) {
        File archivo = new File("AccesoFicheros");
        System.out.println(archivo.getAbsolutePath());
        System.out.println(archivo.exists());
        
    }
}
