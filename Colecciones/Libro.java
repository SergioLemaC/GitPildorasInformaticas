package Colecciones;

public class Libro {
    
    public Libro(String titulo, String autor, int ISBN){
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
    }

    public String getDatos(){
        return "El título es: " + titulo + 
        ". El autor es: " + autor +
        ". Y el ISBN es: " + ISBN;
    }

    @Override
    public boolean equals(Object object){
        //instanceof nos permite averiguar si un objeto es una instancia de una clase en concreto
        if(object instanceof Libro){
            Libro otro = (Libro)object;

            if(this.ISBN == otro.ISBN){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    private String titulo, autor;
    private int ISBN;
}
