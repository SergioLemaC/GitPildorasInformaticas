package POO;

public interface Trabajadores {

    //Puedes poner los modificadores de acceso o no, Java da por hecho que son public y abstract
    double estableceBonus(double gratificacion);

    //Constante
    //Puedes poner los modificadores de acceso o no
    //En el caso de las constantes Java da por hecho que 
    //son public static final
    public static final double bonusBase = 1500;
}
