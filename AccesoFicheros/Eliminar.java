package AccesoFicheros;

import java.io.File;

public class Eliminar {
    public static void main(String[] args) {
        File ruta = new File("D:" + File.separator + "AMD" + File.separator + "Desktop" + File.separator + "Curso Java" + File.separator + "PildorasInformaticas" + File.separator + "GitPildorasInformaticas" + File.separator + "AccesoFicheros" + File.separator + "Nuevo Directorio" + File.separator + "Prueba Texto.txt");
        ruta.delete();
    }
}
