package Excepciones;

import javax.swing.JOptionPane;

public class CompruebaMail {
    public static void main(String[] args) {
        String elMail = JOptionPane.showInputDialog("Introduce mail");

        try{
            examinaMail(elMail);
        }catch(Exception e){
            System.out.println("La dirección de email no es correcta");

            e.printStackTrace(); //Nos dice qué clase nos da la excepción
        }
    }

    public static void examinaMail(String mail) throws LongitudMailErronea /*throws ArrayIndexOutOfBoundsException*/{
        int arroba = 0;

        boolean punto = false;

        if(mail.length() <= 3){
            //ArrayIndexOutOfBoundsException miExcepcion = new ArrayIndexOutOfBoundsException();
            //throw miExcepcion;

            //throw new ArrayIndexOutOfBoundsException();
            throw new LongitudMailErronea("El mail es demasiado corto");
        }else{
            for(int i = 0; i < mail.length(); i++){
                if(mail.charAt(i) == '@'){
                    arroba++;
                }if(mail.charAt(i) == '.'){
                    punto = true;
                }
            }

            if(arroba == 1 && punto == true){
                System.out.println("Es correcto");
            }else{
                System.out.println("No es correcto");
            }
        }
    }
}

class LongitudMailErronea extends Exception{
    public LongitudMailErronea(){

    }

    public LongitudMailErronea(String msjError){
        super(msjError); //Llamamos al constructor de la clase padre (Exception) y le pasamos lo que hay almacenado en msjError
    }
}