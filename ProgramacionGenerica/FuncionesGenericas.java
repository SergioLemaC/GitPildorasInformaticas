package ProgramacionGenerica;

import java.util.GregorianCalendar;

public class FuncionesGenericas {
    public static void main(String[] args) {
        String nombres[] = {"María", "Pepe", "José"};

        /*System.out.println(MisMatrices.getElementos(nombres));

        Empleado listaEmpleados[] = {new Empleado("Ana", 45, 2500), 
        new Empleado("Juan", 27, 2000),
        new Empleado("Pepe", 41, 1500),
        new Empleado("Luis", 35, 2200),
        new Empleado("María", 23, 2500)};

        System.out.println(MisMatrices.getElementos(listaEmpleados));*/

        System.out.println(MisMatrices.getMenor(nombres));

        //ESTAS CLASES IMPLEMENTAN LA INTERFAZ Comparable
        GregorianCalendar fechas[] = {new GregorianCalendar(2015, 07, 12),
        new GregorianCalendar(2015, 05, 12),
        new GregorianCalendar(2015, 04, 12)};

        System.out.println(MisMatrices.getMenor(fechas));
    }
}

class MisMatrices{
    public static <T> String getElementos(T[] a){
        return "El array tiene " + a.length + " elementos";
    }

    public static <T extends Comparable> T getMenor(T[] a){
        if(a == null || a.length == 0){
            return null;
        }

        T elementoMenor = a[0];

        for(int i = 1; i < a.length; i++){
            if(elementoMenor.compareTo(a[i]) > 0){
                elementoMenor = a[i];
            }
        }

        return elementoMenor;
    }
}