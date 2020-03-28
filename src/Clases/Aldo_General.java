/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Aldo
 */
public class Aldo_General {

    public void Apariencia(JFrame frm, int tipo) {
        try {
            UIManager.LookAndFeelInfo apar[];
            apar = UIManager.getInstalledLookAndFeels();
            UIManager.setLookAndFeel(apar[tipo].getClassName());
            SwingUtilities.updateComponentTreeUI(frm);
        } catch (Exception e) {
        }
        //frm.getContentPane().setBackground(new Color(122,150,180));
    }

    public void Apariencia(JDialog frm, int tipo) {
        try {
            UIManager.LookAndFeelInfo apar[];
            apar = UIManager.getInstalledLookAndFeels();
            UIManager.setLookAndFeel(apar[tipo].getClassName());
            SwingUtilities.updateComponentTreeUI(frm);
        } catch (Exception e) {
        }
        //frm.getContentPane().setBackground(new Color(122,150,180));//255,255,0
    }

    public void setIconoJFrame(JFrame frm, String url) {
        frm.setIconImage(new ImageIcon(getClass().getResource(url)).getImage());
    }

    public void setIconoJDialogo(JDialog frm, String url) {
        frm.setIconImage(new ImageIcon(getClass().getResource(url)).getImage());
    }

    public void setIconoJInternal(JInternalFrame frm, String url) {
        frm.setFrameIcon(new ImageIcon(this.getClass().getResource(url)));
    }

    //Agregar icono a un Button
    public void IconButton(JButton buton, String rutaIcono) {
        buton.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(rutaIcono)));
    }

    //METODO QUE DEVUELVE UN VALOR BOOLEAN PARA SABER SI UN JINTERNALFRAME ESTA ABIERTO O NO
    public boolean estacerrado(Object obj, JDesktopPane panel) {
        JInternalFrame[] activos = panel.getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {
                cerrado = false;
            }
            i++;
        }
        return cerrado;
    }

}
