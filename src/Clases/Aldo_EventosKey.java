/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Aldo
 */
public class Aldo_EventosKey {

    /*
     * *************************************************************************
     * EVENTOS ENTER
     * ***************************************************************************
     */
    //Pasamos con un enter de un Jtextfield a otro Jtextfield
    public void EnterJTexfield(KeyEvent e, JTextField t1, JTextField t2) {
        if (t1.getText().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                t2.requestFocus();
            }
        } else {
            t1.requestFocus();
        }
    }

    //Pasamos con un enter de un Jtextfield a otro JPasswordField
    public void EnterJTexfieldAJPasswordField(KeyEvent e, JTextField t1, JPasswordField t2) {
        if (t1.getText().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                t2.requestFocus();
            }
        } else {
            t1.requestFocus();
        }
    }

    //pasamos con un entrer de un JtextField a buton
    public void EnterJTexfieldAButton(KeyEvent e, JTextField t1, JButton boton) {
        if (t1.getText().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) {
                boton.requestFocus();
                boton.doClick();
            }
        } else {
            t1.requestFocus();
        }
    }

    //Pasamos con un enter de un JFormattedTextField1 a otro JFormattedTextField2
    public void EnterJFormatted(KeyEvent e, JFormattedTextField t1, JFormattedTextField t2) {
        if (t1.getText().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                t2.requestFocus();
            }
        } else {
            t1.requestFocus();
        }
    }

    //Pasamos con un enter desde JFormattedTextField a JTextArea
    public void EnterJFormatted_A_JTextArea(KeyEvent e, JFormattedTextField t1, JTextArea t2) {
        if (t1.getText().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                t2.requestFocus();
            }
        } else {
            t1.requestFocus();
        }
    }

    //Pasamos con un enter desde un JFormattedTextField a Jcombo
    public void EnterJFormatted_A_JComboBox(KeyEvent e, JFormattedTextField t1, JComboBox t2) {
        if (t1.getText().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                t2.requestFocus();
            }
        } else {
            t1.requestFocus();
        }
    }

    //Pasamos con un enter desde Jcombo1 a Jcombo2
    public void EnterJComboBox(KeyEvent e, JComboBox c1, JComboBox c2) {
        if (c1.getSelectedIndex() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                c2.requestFocus();
            }
        } else {
            c1.requestFocus();
        }
    }

    public void EnterJFormatted_A_JTextField(KeyEvent e, JFormattedTextField t1, JTextField t2) {
        if (t1.getText().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                t2.requestFocus();
            }
        } else {
            t1.requestFocus();
        }
    }

    //pasamos con un enter desde JtextField a JFormattedTextField
    public void EnterJTextField_A_JFormatted(KeyEvent e, JTextField t1, JFormattedTextField t2) {
        if (t1.getText().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                t2.requestFocus();
            }
        } else {
            t1.requestFocus();
        }
    }

    //Pasamos con un enter desde Jcombo JtextArea
    public void EnterJComboBox_A_JTexArea(KeyEvent e, JComboBox c1, JTextArea t2) {
        if (c1.getSelectedIndex() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                t2.requestFocus();
            }
        } else {
            c1.requestFocus();
        }
    }

    //Pasamos con un enter desde Jpassword1 a Jpassword2
    public void EnterJPasswordField(KeyEvent e, JPasswordField c1, JPasswordField t2) {
        if (c1.getText().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                t2.requestFocus();
            }
        } else {
            c1.requestFocus();
        }
    }

    //Pasamos con un enter desde Jpassword a Jcombo
    public void EnterJPasswordField_A_JComboBox(KeyEvent e, JPasswordField t1, JComboBox c2) {
        if (t1.getText().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                c2.requestFocus();
            }
        } else {
            t1.requestFocus();
        }
    }

    //Pasamos con un enter desde Jtext a Jcombo
    public void EnterJTexfield_A_JComboBox(KeyEvent e, JTextField t1, JComboBox c2) {
        if (t1.getText().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                c2.requestFocus();
            }
        } else {
            t1.requestFocus();
        }
    }

    //Pasamos con un enter desde Jtext a JtextArea
    public void EnterJTexfield_A_JTexArea(KeyEvent e, JTextField t1, JTextArea c2) {
        if (t1.getText().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                c2.requestFocus();
            }
        } else {
            t1.requestFocus();
        }
    }

    //Pasamos con un enter desde Jcombo a Jdatechooser
    public void EnterJComboBox_A_JDateChosster(KeyEvent e, JComboBox combo, JDateChooser c2) {
        if (combo.getSelectedIndex() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                c2.requestFocusInWindow();
            }
        } else {
            combo.requestFocus();
        }
    }

    //Pasamos con un enter desde Jcombo a JTexField
    public void EnterJComboBox_A_JTexField(KeyEvent e, JComponent component) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            component.requestFocus();
        }
    }

    //pasamos con un enter desde Jdatechooser a Jtext
    public void EnterJDateChosster_A_JTexField(KeyEvent e, JDateChooser c2, JTextField text) {
        if (c2.getDateFormatString().trim().length() > 0) {
            if (e.getKeyChar() == e.VK_ENTER) { //10
                text.requestFocusInWindow();
            }
        } else {
            c2.requestFocus();
        }
    }
    

    /*
     * *************************************************************************
     * EVENTOS RELEASE
     * ***************************************************************************
     */
    public void mayusculas(KeyEvent evt, JTextField tf) {
        //Llamar en evento keyreleased
        int carro = tf.getCaretPosition();
        tf.setText(tf.getText().toUpperCase());
        tf.setCaretPosition(carro);
    }

    /*
     * *************************************************************************
     * EVENTOS TYPE
     * ***************************************************************************
     */
    public void soloLetras(KeyEvent e) {
        if ((e.getKeyChar() >= 48) && (e.getKeyChar() <= 57)) {
            e.consume();
        }
    }

    public void soloNumeros(KeyEvent e) {
        if ((e.getKeyChar() < 48) || (e.getKeyChar() > 57)) {
            e.consume();
        }
    }

    public void numerosSinCero(KeyEvent e) {
        char c = e.getKeyChar();
        if (c <= 48 || c > 57) {
            e.consume();
        }
    }

    public void SinEspacioBlancoJTextField(KeyEvent e, JTextField t) {
        //llamar en evento keytyped
        //permite escribir cualquier cadena en el texfield sin espacios en blanco
        //al inicio y sin dos espacios en blanco consecutivos
        if (e.getKeyChar() == 32) {
            if (t.getCaretPosition() == 0) {
                e.consume();
            } else {
                if (t.getCaretPosition() < t.getText().length()) {
                    if ((t.getText().charAt(t.getCaretPosition() - 1) == ' ') || (t.getText().charAt(t.getCaretPosition()) == ' ')) {
                        e.consume();
                    }
                } else {
                    if (t.getText().charAt(t.getCaretPosition() - 1) == ' ') {
                        e.consume();
                    }
                }
            }
        }
    }

    public void SinEspacioBlancoJTextArea(KeyEvent e, JTextArea t) {
        //llamar en evento keytyped
        //permite escribir cualquier cadena en el JTextArea sin espacios en blanco
        //al inicio y sin dos espacios en blanco consecutivos
        if (e.getKeyChar() == 32) {
            if (t.getCaretPosition() == 0) {
                e.consume();
            } else {
                if (t.getCaretPosition() < t.getText().length()) {
                    if ((t.getText().charAt(t.getCaretPosition() - 1) == ' ') || (t.getText().charAt(t.getCaretPosition()) == ' ')) {
                        e.consume();
                    }
                } else {
                    if (t.getText().charAt(t.getCaretPosition() - 1) == ' ') {
                        e.consume();
                    }
                }
            }
        }
    }

    public void soloNcarc(int numcarac, JTextField tf, KeyEvent e) {
        //Llamar en evento keytyped
        //permite escribir solo numcarac caracteres en el textfield
        if (tf.getText().length() >= numcarac) {
            e.consume();
        }
    }

    public void SoloNCaracteresJTextArea(KeyEvent e, JTextArea caja, int cantidad) {
        int t = e.getKeyChar();
        if (caja.getText().length() >= cantidad) {
            e.consume();
        }
    }

    public void EscribirMaximoConDis(JTextField field, KeyEvent evt, int numMaximo) {
        if (field.getForeground().equals(Color.black)) {
            if (field.getText().length() > numMaximo - 1) {
                evt.consume();
            }
        }
    }

    public void EscribirMaximoSinEspacio(KeyEvent evt, JTextField field, int numMaximo) {
        if (field.getText().length() > numMaximo - 1) {
            evt.consume();
        }
    }

    public void EscribirSoloLetrasSinEspacio(KeyEvent evt, JTextField field) {
        if (evt.getKeyChar() >= 48 && evt.getKeyChar() <= 57) {
            evt.consume();
        }
    }

    public void EscribirSoloNumerosSinEspacio(KeyEvent evt, JTextField field) {
        if (evt.getKeyChar() < 48 || evt.getKeyChar() > 57) {
            evt.consume();
        }
    }
}
