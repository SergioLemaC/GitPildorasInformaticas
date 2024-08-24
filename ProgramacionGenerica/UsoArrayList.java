package ProgramacionGenerica;

//import java.io.File;

public class UsoArrayList {
    public static void main(String[] args) {
        ArrayListEj archivos = new ArrayListEj(5);

        archivos.add("Juan");
        archivos.add("María");
        archivos.add("Ana");
        archivos.add("Sandra");
        //archivos.add(new File("gestion_Pedidos.accdb"));

        String nombrePersona = (String)archivos.get(2);

        System.out.println(nombrePersona);

        /*archivos.add(new File("gestion_Pedidos.accdb"));

        File nombrePersona = (File)archivos.get(0);

        System.out.println(nombrePersona);*/
    }
}
