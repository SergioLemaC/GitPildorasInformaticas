package AccesoFicheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {
    public static void main(String[] args) {
        File ruta = new File("D:" + File.separator + "AMD" + File.separator + "Desktop" + File.separator + "Curso Java" + File.separator + "PildorasInformaticas" + File.separator + "GitPildorasInformaticas" + File.separator + "AccesoFicheros" + File.separator + "Nuevo Directorio" + File.separator + "Prueba Texto.txt");
        //ruta.mkdir();

        String archivoDestino = ruta.getAbsolutePath();

        try {
            ruta.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Transcribiendo accedeEs = new Transcribiendo();
        accedeEs.escribir(archivoDestino);
    }
}

class Transcribiendo{
    public void escribir(String rutaArchivo){
        String frase = "Esto es un ejemplo, espero que salga";

        try {
            FileWriter escritura = new FileWriter(rutaArchivo);

            for (int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }

            escritura.close();
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
}