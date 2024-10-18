package BBDD_JDBC;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AppConsulta {
    public static void main(String[] args) {
        JFrame miMarco = new MarcoAplicacion();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoAplicacion extends JFrame{
    public MarcoAplicacion(){
        setTitle("Consulta BBDD");
        setBounds(500, 300, 400, 400);
        setLayout(new BorderLayout());

        JPanel menus = new JPanel();
        menus.setLayout(new FlowLayout());

        secciones = new JComboBox();
        secciones.setEditable(false);
        secciones.addItem("Todos");

        paises = new JComboBox();
        paises.setEditable(false);
        paises.addItem("Todos");

        resultado = new JTextArea(4, 50);
        resultado.setEditable(false);
        
        add(resultado);

        menus.add(secciones);
        menus.add(paises);

        add(menus, BorderLayout.NORTH);
        add(resultado, BorderLayout.CENTER);

        JButton botonConsulta = new JButton("Consulta");
        botonConsulta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                ejecutaConsulta();
            }
            
        });
        add(botonConsulta, BorderLayout.SOUTH);

        //Conexión a BD
        try {
            //MYSQL
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "Contraseña");

            //ORACLE
            //Primero desde la terminal hay que iniciar el servicio de Oracle "lsnrctl start"
            //miConexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "Contraseña");

            //SQLSERVER
            //miConexion = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-P70AUTP:1433;databaseName=elqsea;trustServerCertificate=true" ,"lemac1nside", "Contraseña");

            //POSTGRESQL
            //miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Contraseña");

            Statement miStatement = miConexion.createStatement();

            String consulta = "SELECT DISTINCT CARGO FROM USUARIOS";

            ResultSet miResultSet = miStatement.executeQuery(consulta);

            while (miResultSet.next()) {
                secciones.addItem(miResultSet.getString(1));
            }

            miResultSet.close();

            //Cargar los paises

            consulta = "SELECT DISTINCT PAIS FROM USUARIOS";

            miResultSet = miStatement.executeQuery(consulta);

            while (miResultSet.next()) {
                paises.addItem(miResultSet.getString(1));
            }

            miResultSet.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void ejecutaConsulta(){
        ResultSet resultSet = null;

        try {
            resultado.setText("");

            String seccion = (String)secciones.getSelectedItem();

            String pais = (String)paises.getSelectedItem();

            if(!seccion.equals("Todos") && pais.equals("Todos")){
        
                enviaConsultaCargo = miConexion.prepareStatement(consultaCargo);

                enviaConsultaCargo.setString(1, seccion);

                resultSet = enviaConsultaCargo.executeQuery();
            }else if(seccion.equals("Todos") && !pais.equals("Todos")){
                enviaConsultaPais = miConexion.prepareStatement(consultaPais);

                enviaConsultaPais.setString(1, pais);

                resultSet = enviaConsultaPais.executeQuery();
            }else if(!seccion.equals("Todos") && !pais.equals("Todos")){
                enviaConsultaAmbos = miConexion.prepareStatement(consultaAmbos);

                enviaConsultaAmbos.setString(1, seccion);
                enviaConsultaAmbos.setString(2, pais);

                resultSet = enviaConsultaAmbos.executeQuery();
            }else if(seccion.equals("Todos") && pais.equals("Todos")){
                enviaConsultaTodos = miConexion.prepareStatement(consultaTodos);

                resultSet = enviaConsultaTodos.executeQuery();
            }

            while (resultSet.next()) {
                resultado.append(resultSet.getString(1));
                resultado.append(" | ");
                resultado.append(resultSet.getString(2));
                resultado.append(" | ");
                resultado.append(resultSet.getString(3));
                resultado.append(" | ");
                resultado.append(resultSet.getString(4));
                resultado.append(" | ");
                resultado.append(resultSet.getString(5));
                resultado.append("\n");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Connection miConexion;
    private PreparedStatement enviaConsultaCargo, enviaConsultaPais, enviaConsultaAmbos, enviaConsultaTodos;
    private final String consultaCargo = "SELECT CEDULA, NOMBRE, APELLIDO, EMAIL, TELEFONO FROM USUARIOS WHERE CARGO=?";
    private final String consultaPais = "SELECT CEDULA, NOMBRE, APELLIDO, EMAIL, TELEFONO FROM USUARIOS WHERE PAIS=?";
    private final String consultaAmbos = "SELECT CEDULA, NOMBRE, APELLIDO, EMAIL, TELEFONO FROM USUARIOS WHERE CARGO=? AND PAIS=?";
    private final String consultaTodos = "SELECT CEDULA, NOMBRE, APELLIDO, EMAIL, TELEFONO FROM USUARIOS";
    private JComboBox secciones, paises;
    private JTextArea resultado;
}