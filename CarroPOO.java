//POO estructura y organización de clases
//Clase
public class CarroPOO{
    //Atributos
    //Modificador de acceso para encapsular datos
    private int ruedas;
    private int largo;
    private int ancho;
    private int motor;
    private int pesoPlataforma;
    private String color;
    private int pesoTotal;
    private boolean asientosCuero, climatizador;

    //Constructor: es un método que se encarga de dar
    //un estado inicial a nuestro objeto; además de
    //tener el mismo nombre de la clase
    public CarroPOO(){
        ruedas = 4;
        largo = 2000;
        ancho = 300;
        motor = 1600;
        pesoPlataforma = 500;
    }

    //Método Getter para acceder a las propiedades de los objetos
    public String /*String porque va a devolver una acción, si solo 
    fuera a devolver un dato, pues el tipo de dato a devolver */ dimeLargo(){
        return "El largo del carro es " + largo; //Podemos acceder a la variable privada porque estamos dentro de su propia clase
    }

    //Método Setter modifica el valor de las propiedades de los objetos
    public void estableceColor(/*Se le pasa el parámetro o argumento */String colorCarro){
        //color = "Azul";
        color = colorCarro;
    }

    //Ahora el método Getter que informe lo modificado en el método Setter
    public String dimeColor(){
        return "El color del carro es " + color;
    }

    //Función para devolver (Getter) todas las propiedades
    public String dimeDatosGenerales(){
        return "La plataforma del vehículo tiene: " + ruedas + " ruedas, " +
        "mide: " + largo/1000 + " metros, con un ancho de " + ancho + " cm y un peso de " + 
        pesoPlataforma + " kg.";
    }

    public void configuraAsientos(String asientosCuero){
        if(asientosCuero.equalsIgnoreCase("si")){
            this.asientosCuero = true;
        }else{
            this.asientosCuero = false;
        }
    }

    public String dimeAsientos(){
        if(asientosCuero == true){
            return "El carro tiene asientos de cuero";
        }else{
            return "El carro tiene asientos de serie";
        }
    }

    public void configuraClimatizador(String climatizador){
        if(climatizador.equalsIgnoreCase("si")){
            this.climatizador = true;
        }else{
            this.climatizador = false;
        }
    }

    public String dimeClimatizador(){
        if(climatizador == true){
            return "El carro incorpora climatizador";
        }else{
            return "El carro lleva aire acondicionado";
        }
    }

    //Esta función realiza ambos métodos Getter y Setter
    public String dimePesoCarro(){
        int pesoCarroceria = 500;
        pesoTotal = pesoPlataforma + pesoCarroceria;

        if(asientosCuero == true){
            pesoTotal = pesoTotal + 50;
        }
        if(climatizador == true){
            pesoTotal = pesoTotal + 20;
        }

        return "El peso del carro es de: " + pesoTotal + " kg";
    }

    public int precioCarro(){
        int precioFinal = 10000;

        if(asientosCuero == true){
            precioFinal += 2000;
        }
        if(climatizador == true){
            precioFinal += 1500;
        }

        return precioFinal;
    }
}