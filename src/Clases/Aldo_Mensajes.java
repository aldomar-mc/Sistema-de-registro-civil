/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Aldo
 */
public class Aldo_Mensajes {

    public void mensajeInformacion(String content) {
        JOptionPane.showMessageDialog(null, content, "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mensajeError(String content) {
        JOptionPane.showMessageDialog(null, content, "Error del Sistema", JOptionPane.ERROR_MESSAGE);
    }

    public int mensajeConsulta(String mensaje) {
        //Si es "SI" nos devuelve 0, si es "NO" nos devuelve 1
        int i = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar", JOptionPane.YES_NO_OPTION);
        return i;
    }

    public void salirSistema() {
        if (JOptionPane.showConfirmDialog(null, "¿Desea salir del Sistema?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
            System.exit(0);
        }
    }

    public void reiniciarSistema(JFrame frm_actual, JFrame frm_nuevo) {
        frm_actual.dispose();
        frm_nuevo.setVisible(true);
    }

    public void cerrarVentanaConfirmarJF(JFrame frm) {
        if (JOptionPane.showConfirmDialog(null, "¿Desea salir del Sistema?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
            frm.dispose();
        }
    }

    public void cerrarVentanaSinConfirmarJF(JFrame frm) {
        frm.dispose();
    }

    public void cerrarVentanaConfirmarJD(JDialog frm) {
        if (JOptionPane.showConfirmDialog(null, "¿Desea salir del Sistema?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
            frm.dispose();
        }
    }

    public void cerrarVentanaSinConfirmarJD(JDialog frm) {
        frm.dispose();
    }

    public void cerrarVentanaConfirmarJI(JInternalFrame frm) {
        if (JOptionPane.showConfirmDialog(null, "¿Desea salir del Sistema?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
            frm.dispose();
        }
    }

    public void cerrarVentanaSinConfirmarJI(JInternalFrame frm) {
        frm.dispose();
    }
}
