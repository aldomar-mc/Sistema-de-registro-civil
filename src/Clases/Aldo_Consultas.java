/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aldo
 */
public class Aldo_Consultas {

    Aldo_General general = new Aldo_General();
    Aldo_Controlador control = new Aldo_Controlador();
    Aldo_Mensajes mensajes = new Aldo_Mensajes();
    static String sql = "";
    String idestado = "";
    public int Veces = 0;

    //Metodo para poder ejecutar una consulta
    public void Consulta(String sql) {
        boolean b = true;
        if (sql != null) {
            try {
                Connection connection = Conexion.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                connection.close();
            } catch (Exception e) {
                b = false;
                System.out.println(e);
            }
//            if (b == true) {
//                mensajes.mensajeInformacion("Se grabaron los datos satisfactoriamente");
//            } else {
//                mensajes.mensajeError("Ocurrio un problema");
//            }
        }
    }

    public void CrearRegistro1(String sq) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String CrearRegistro(String sql) {
        String cad = "";
        try {
            Connection connection = Conexion.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                cad = rs.getString(1);
            }
        } catch (Exception e) {
            //mensajes.mensajeError("Ocurrio un problema al crear el registro");
        }
        return cad;
    }

    public void llenarCombo(String sql, JComboBox cb, int campo) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                cb.addItem(rs.getString(campo));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Devolver un registro desde la BD --Primera forma
    public String devolverDato(String sql, String campo, int pos) {
        String dato = "";
        try {
            Connection connection = Conexion.getInstance().getConnection();
            PreparedStatement statement = connection.prepareCall(sql + "'" + campo + "'");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                dato = rs.getString(pos);
            }
            connection.close();
        } catch (Exception e) {
            mensajes.mensajeError("Devolver dato");
        }
        return dato;
    }

    //Devolver un dato desde la bd -- Segunda forma
    public String devolverRegistroDato(String sql, int pos) {
        String rsl = "";
        try {
            Connection connection = Conexion.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                rsl = rs.getString(pos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public boolean verificarUsuario(JTextField login, JPasswordField password, String sql) {
        boolean b = false;
        try {
            Connection connection = Conexion.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login.getText());
            statement.setString(2, password.getText());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                b = true;
            }
            connection.close();
        } catch (Exception e) {
            mensajes.mensajeError("Verificar usuario");
        }
        return b;
    }

    //Verificamos si un usuario pertenece a un tipo de usuario
    public boolean verificarTipoUsuario(JComboBox tipouser, JTextField login, String sql) {
        boolean b = false;
        try {
            Connection connection = Conexion.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, tipouser.getSelectedItem().toString());
            statement.setString(2, login.getText());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                b = true;
            }
            connection.close();
        } catch (Exception e) {
            mensajes.mensajeError("Verificar usuario");
        }
        return b;
    }

    //Acceso con tipo usuario, usuario, password
    public void AccesoSistemaTU(JComboBox tipouser, JTextField jtexusu, JPasswordField jpass, JFrame vtac, JFrame vtpos,
            int inten, JLabel label, String sql_verificarTipoUsuario, String sql_verificarusurio, String sql_verificarestado) {
        try {
            if (verificarUsuario(jtexusu, jpass, sql_verificarusurio)) {
                if (verificarTipoUsuario(tipouser, jtexusu, sql_verificarTipoUsuario)) {
                    idestado = this.devolverDato(sql_verificarestado, jtexusu.getText(), 1);
                    if ("ACTIVO".equals(idestado)) {
                        vtac.dispose();
                        vtpos.setVisible(true);
                    } else {
                        mensajes.mensajeError("El usuario corresponde a un usuario que fue dado de baja");
                        jtexusu.requestFocus();
                    }
                } else {
                    mensajes.mensajeError("El usuario seleccionado no pertenece al tipo de usuario.");
                    tipouser.requestFocus();
                }
            } else {
                mensajes.mensajeError("Ingrese correctamente su usuario y/o contraseña");
                Veces++;
                if (Veces == 1) {
                    JOptionPane.showMessageDialog(null, "Llevas un intento");
                    label.setText("Escriba correcto sus datos");
                    jtexusu.requestFocus();
                } else {
                    if (Veces == inten) {
                        JOptionPane.showMessageDialog(null, "Cumplistes tus " + inten + " Intentos");
                        vtac.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Llevas " + Veces + " Intentos");
                        label.setText("Escriba correcto sus datos");
                        jtexusu.requestFocus();
                    }
                }
            }
        } catch (Exception e) {
            mensajes.mensajeError("Acceso al sistema");
        }
    }
}
