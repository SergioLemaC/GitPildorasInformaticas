package AccesoFicheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LecturaEscritura {
    public static void main(String[] args) {
        int contador = 0;

        int datosEntrada[] = new int[145981];

        try{
            FileInputStream archivoLectura = new FileInputStream("D:/AMD/Desktop/Curso Java/PildorasInformaticas/GitPildorasInformaticas/graficos/IMG-20200120-WA0002.jpg");

            boolean finalAr = false;

            while (!finalAr) {
                int byteEntrada = archivoLectura.read();

                if(byteEntrada != -1){
                    datosEntrada[contador] = byteEntrada;
                }else{
                    finalAr = true;
                }
                System.out.println(datosEntrada[contador]);

                contador++;
            }
            archivoLectura.close();
        }catch(IOException e){
            System.out.println("No se encuentra la imagen");
        }
        System.out.println(contador);

        creaFichero(datosEntrada);
    }

    public static void creaFichero(int datosNuevoFichero[]){
        try{
            FileOutputStream ficheroNuevo = new FileOutputStream("D:/AMD/Desktop/Curso Java/PildorasInformaticas/GitPildorasInformaticas/AccesoFicheros/fotoconmama.jpg");

            for(int i = 0; i < datosNuevoFichero.length; i++){
                ficheroNuevo.write(datosNuevoFichero[i]);
            }

            ficheroNuevo.close();
        }catch(IOException e){
            System.out.println("Error al crear el archivo");
        }
    }
}
