package POO;

public interface Jefes extends Trabajadores{
    
    //Puedes poner los modificadores de acceso o no, Java da por hecho que son public y abstract
    public abstract String tomarDecisiones(String decision);
}
