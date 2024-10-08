package Colecciones;

import java.util.Comparator;
import java.util.TreeSet;

public class PruebaTreeSet {
    public static void main(String[] args) {

        /*
         * TreeSet<String> ordenaPersonas = new TreeSet<String>();
         * ordenaPersonas.add("Sandra");
         * ordenaPersonas.add("Amanda");
         * ordenaPersonas.add("Diana");
         * 
         * for (String s : ordenaPersonas) {
         * System.out.println(s);
         * }
         */

        Articulo primero = new Articulo(1, "Primer artículo");
        Articulo segundo = new Articulo(2, "Segundo artículo");
        Articulo tercero = new Articulo(3, "Tercer artículo");

        TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
        ordenaArticulos.add(tercero);
        ordenaArticulos.add(primero);
        ordenaArticulos.add(segundo);

        for (Articulo art : ordenaArticulos) {
            System.out.println(art.getDescripcion());
        }

        /*
         * Articulo comparadorArticulos = new Articulo();
         * 
         * TreeSet<Articulo> ordenaArticulos2 = new
         * TreeSet<Articulo>(comparadorArticulos);
         */

        // ComparadorArticulos comparaArt = new ComparadorArticulos();

        TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(new Comparator<Articulo>() {
            @Override
            public int compare(Articulo o1, Articulo o2) {
                // TODO Auto-generated method stub

                String desc1 = o1.getDescripcion();
                String desc2 = o2.getDescripcion();

                return desc1.compareTo(desc2);

            }
        });
        ordenaArticulos2.add(primero);
        ordenaArticulos2.add(segundo);
        ordenaArticulos2.add(tercero);

        for (Articulo art : ordenaArticulos2) {
            System.out.println(art.getDescripcion());
        }

    }
}

class Articulo implements Comparable<Articulo> {

    public Articulo(int num, String desc) {
        numeroArticulo = num;
        descripcion = desc;
    }

    @Override
    public int compareTo(Articulo o) {
        // TODO Auto-generated method stub

        return numeroArticulo - o.numeroArticulo;

    }

    public String getDescripcion() {
        return descripcion;
    }

    private int numeroArticulo;
    private String descripcion;

}

/*class ComparadorArticulos implements Comparator<Articulo> {

    @Override
    public int compare(Articulo o1, Articulo o2) {
        // TODO Auto-generated method stub

        String desc1 = o1.getDescripcion();
        String desc2 = o2.getDescripcion();

        return desc1.compareTo(desc2);

    }

}*/