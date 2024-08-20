package AccesoFicheros;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {
    public static void main(String[] args) {
        Escribiendo accedeEs = new Escribiendo();
        accedeEs.escribir();
    }
}

class Escribiendo{
    public void escribir(){
        String frase = "Esto es una prueba de escritura 2";

        try{
            FileWriter escritura = new FileWriter("D:/AMD/Desktop/Curso Java/PildorasInformaticas/GitPildorasInformaticas/AccesoFicheros/TextoNuevo.txt");

            for(int i = 0; i < frase.length(); i++){
                escritura.write(frase.charAt(i));
            }

            escritura.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}