/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Clases.Aldo_Mensajes;
import java.io.FileInputStream;
import java.sql.*;
import java.util.PropertyResourceBundle;

/**
 *
 * @author AldomarMoralesCarlos
 */
public class Conexion {

    Aldo_Mensajes mensaje = new Aldo_Mensajes();
    private static Conexion conex;
    String properties = "Configurar.properties";
    PropertyResourceBundle file;
    public static Connection conec = null;
    public static String host, username, password, database;

    public static Conexion getInstance() {
        if (conex == null) {
            conex = new Conexion();
        }
        return conex;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            file = new PropertyResourceBundle(new FileInputStream(properties));
            host = file.getString("host");
            username = file.getString("username");
            password = file.getString("password");
            database = file.getString("database");
            Class.forName("com.mysql.jdbc.Driver");
            conec = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, username, password);
        } catch (Exception e) {
            mensaje.mensajeError("Error en las credenciales del servidor.");
            System.exit(0);
        }
        return conec;
    }

}
