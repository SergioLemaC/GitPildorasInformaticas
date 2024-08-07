package practicas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class MarcoDialogo extends JFrame{
    public MarcoDialogo(){
        setTitle("Prueba de diálogos");
        setBounds(500, 300, 600, 450);

        JPanel laminaCuadricula = new JPanel();
        laminaCuadricula.setLayout(new GridLayout(2,3));
        
        String primero[] = {
            "Mensaje", "Confirmar", "Opción", "Entrada"
        };

        laminaTipo = new LaminaBotones("Tipo", primero);

        laminaTipoMsj = new LaminaBotones("Tipo de mensaje", new String[]{
            "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"
        });

        laminaMsj = new LaminaBotones("Mensaje", new String[]{
            "Cadena", "Icono", "Componente", "Otros", "Object[]"
        });

        laminaTipoOpcion = new LaminaBotones("Confirmar", new String[]{
            "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"
        });

        laminaOpciones = new LaminaBotones("Opción", new String[]{
            "String[]", "Icon[]", "Object[]"
        });

        laminaEntrada = new LaminaBotones("Entrada", new String[]{
            "Campo de texto", "Combo"
        });

        setLayout(new BorderLayout());

        laminaCuadricula.add(laminaTipo);
        laminaCuadricula.add(laminaTipoMsj);
        laminaCuadricula.add(laminaMsj);
        laminaCuadricula.add(laminaTipoOpcion);
        laminaCuadricula.add(laminaOpciones);
        laminaCuadricula.add(laminaEntrada);

        //Construímos la lámina inferior

        JPanel laminaMostrar = new JPanel();

        JButton botonMostrar = new JButton("Mostrar");

        laminaMostrar.add(botonMostrar);

        add(laminaMostrar, BorderLayout.SOUTH);
        add(laminaCuadricula, BorderLayout.CENTER);
    }

    private LaminaBotones laminaTipo, laminaTipoMsj, laminaMsj, laminaTipoOpcion, laminaOpciones, laminaEntrada;
}
