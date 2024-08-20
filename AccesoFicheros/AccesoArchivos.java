package AccesoFicheros;

import java.io.File;

public class AccesoArchivos {
    public static void main(String[] args) {
        File ruta = new File("D:" + File.separator + "AMD" + File.separator + "Desktop" + File.separator + "Curso Java" + File.separator + "PildorasInformaticas" + File.separator + "GitPildorasInformaticas");
        System.out.println(ruta.getAbsolutePath());

        String[] nombresArchivos = ruta.list();

        for (String i : nombresArchivos) {
            System.out.println(i);

            File f = new File(ruta.getAbsolutePath(), i);

            if(f.isDirectory()){
                String[] archivosSubCarpeta = f.list();

                for (String j : archivosSubCarpeta) {
                    System.out.println(j);
                }
            }
        }
    }
}
