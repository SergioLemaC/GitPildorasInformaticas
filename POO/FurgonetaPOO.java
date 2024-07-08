package POO;
public class FurgonetaPOO extends CarroPOO{
    private int capacidadCarga;
    private int plazasExtra;

    public FurgonetaPOO(int plazasExtra, int capacidadCarga){
        super(); //Llamar al constructor de la clase padre
        this.capacidadCarga = capacidadCarga;
        this.plazasExtra = plazasExtra;
    }

    public String dimeDatosFurgoneta(){
        return "La capacidad de carga es: " + capacidadCarga + 
        " y las plazas son: " + plazasExtra;
    }
}
