package AccesoFicheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccesoFichero {
    public static void main(String[] args) {
        LeerFichero accediendo = new LeerFichero();
        accediendo.lee();
    }
}

class LeerFichero{
    public void lee(){
        try {
            FileReader entrada = new FileReader("D:/AMD/Desktop/Curso Java/PildorasInformaticas/GitPildorasInformaticas/AccesoFicheros/Ej.txt");

            BufferedReader miBuffer = new BufferedReader(entrada);

            //int c = 0;

            String linea = "";

            while(/*c != -1*/ linea != null){
                //c = entrada.read();
                //char letra = (char) c;

                linea = miBuffer.readLine();

                if(linea != null){
                    System.out.println(linea);
                }

                //System.out.println(letra);
            }

            entrada.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("No se ha encontrado el archivo");
        }
    }
}