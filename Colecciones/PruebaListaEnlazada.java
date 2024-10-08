package Colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

public class PruebaListaEnlazada {
    public static void main(String[] args) {
        
        LinkedList<String> paises = new LinkedList<String>();
        paises.add("España");
        paises.add("Colombia");
        paises.add("México");
        paises.add("Perú");

        LinkedList<String> capitales = new LinkedList<String>();
        capitales.add("Madrid");
        capitales.add("Bogotá");
        capitales.add("DF");
        capitales.add("Lima");

        ListIterator<String> iterA = paises.listIterator();
        ListIterator<String> iterB = capitales.listIterator();

        while (iterB.hasNext()) {
            if(iterA.hasNext()){
                iterA.next();
            }
            iterA.add(iterB.next());
        }

        System.out.println(paises);

        iterB = capitales.listIterator();

        while (iterB.hasNext()) {
            iterB.next();

            if(iterB.hasNext()){
                iterB.next();
                iterB.remove();
            }
        }
        paises.removeAll(capitales);
        System.out.println(paises);
    }
}
