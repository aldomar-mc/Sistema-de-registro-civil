/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import org.bolivia.time.TimeChooser;

/**
 *
 * @author Aldo
 */
public class Aldo_Controlador {

    Aldo_Mensajes mensajes = new Aldo_Mensajes();
    Aldo_Tabla tabla = new Aldo_Tabla();
    Aldo_General general = new Aldo_General();

    public Clip clip;

    //Hacer filtro para buscar una imagen en la PC
    public void AsignarFiltro(JFileChooser jFileEscoger) {
        jFileEscoger.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                if (extension(f).equalsIgnoreCase("JPG") || extension(f).equalsIgnoreCase("PNG") || extension(f).equalsIgnoreCase("GIF")) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public String getDescription() {
                return "Solo Imágenes(*.jpg, *.png, *.gif)";
            }

            public String extension(File f) {
                int index = f.getName().lastIndexOf('.');
                if (index > 0 && index < f.getName().length() - 1) {
                    return f.getName().substring(index + 1);
                } else {
                    return "";
                }
            }
        });
    }

    //Cargar una foto desde una direccion
    public void CargarFoto(JLabel label, String src) {
        Image imagen = Toolkit.getDefaultToolkit().getImage(src).getScaledInstance(150,
                175, Image.SCALE_DEFAULT);
        label.setIcon(new ImageIcon(imagen));
    }

    //Generamos un codigo de 4 cifras con un numero qeu ingresamos
    public String GeneraNumero(int num) {
        String rs = "";
        if ((num > 0) && (num < 10)) {
            rs = "000" + num;
        }
        if ((num >= 10) && (num < 100)) {
            rs = "00" + num;
        }
        if ((num >= 100) && (num < 1000)) {
            rs = "0" + num;
        }
        if ((num >= 1000) && (num < 10000)) {
            rs = "" + num;
        }
        return rs;
    }

    /*
     * *************************************************************************
     * ASIGNACION DE DATOS EN LOS CAMPOS
     * ***************************************************************************
     */
    //Asignamos la fecha en datechooser
    public void AsignarFechaenDateChooser(JDateChooser fecha, String fec) {
        ((JTextComponent) fecha.getDateEditor().getUiComponent()).setText(fec);
    }

    //Asignamos dato en Jlabel
    public void asignarJLabel(JLabel text, DefaultTableModel md, JTable tabla, int pos) {
        text.setText(md.getValueAt(tabla.getSelectedRow(), pos).toString());
    }

    //Asignamos datos en Jformatted
    public void asignarJFormattedTextField(JFormattedTextField fec, DefaultTableModel md, JTable tabla, int pos) {
        fec.setText(md.getValueAt(tabla.getSelectedRow(), pos).toString());
    }

    //Asignamos dato en jtextField
    public void asignarJTexField(JTextField text, DefaultTableModel md, JTable tabla, int pos) {
        text.setText(md.getValueAt(tabla.getSelectedRow(), pos).toString());
    }

    //Asignamos dato en Jcombo
    public void asignarComboBox(JComboBox combo, DefaultTableModel md, JTable tabla, int pos) {
        combo.setSelectedItem(md.getValueAt(tabla.getSelectedRow(), pos).toString());
    }

    public void asignarJTextArea(JTextArea area, DefaultTableModel md, JTable tabla, int pos) {
        area.setText(md.getValueAt(tabla.getSelectedRow(), pos).toString());
    }

    //Asignamos un dato en un String
    public void asignarId(String id, DefaultTableModel md, JTable tabla, int pos) {
        id = md.getValueAt(tabla.getSelectedRow(), pos).toString();
    }

    /*
     * *************************************************************************
     * LIMPIEZA DE CAMPOS
     * ***************************************************************************
     */
    public void limpiarJTexField(JTextField text) {
        text.setText("");
    }

    public void limpiarjPasswordField(JPasswordField text) {
        text.setText("");
    }

    public void limpiarComboBox(JComboBox combo) {
        combo.setSelectedIndex(0);
    }

    public void limpiarDataChooser(JDateChooser fec) {
        fec.setDate(null);
    }

    public void limpiarTimeChooser(TimeChooser tc) {
        tc.setText(null);
    }

    public void limpiarjFormattedTextField(JFormattedTextField fec) {
        fec.setText("");
    }

    public void limpiarJTextArea(JTextArea area) {
        area.setText("");
    }

    /*
     * *************************************************************************
     * METODOS
     * ***************************************************************************
     */
    public void BuscarDato(String consulta, DefaultTableModel md, int ndatos, JTextField textbuscar) {
        String[] datos = new String[ndatos];
        int i = 0;
        try {
            tabla.LimpiarTabla(md);
            Connection connection = Conexion.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, "%" + textbuscar.getText() + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                while (i < ndatos) {
                    datos[i] = rs.getString(i + 1);
                    i++;
                }
                md.addRow(datos);
                i = 0;
            }
        } catch (Exception e) {
            mensajes.mensajeError("Mostrar en la tabla");
        }
    }

    //Capturamos las letras iniciales de una cadena
    public String CapturaIniciales(String apnom) {
        String inis = "" + apnom.trim().charAt(0);
        for (int i = 0; i < apnom.length(); i++) {
            if (apnom.charAt(i) == ' ') {
                inis = inis + apnom.charAt(i + 1);
            }
        }
        return inis.toUpperCase();
    }

    //Contamos cuantas letras se esta escribiendo
    public void contadorletras(JTextArea textarea, JLabel contador, JLabel mensaje) {
        int n = textarea.getText().length();
        String k = textarea.getText();
        contador.setText(String.valueOf(n));
        if (n > 39) {
            String cadenaNueva = k.substring(0, k.length() - 1);
            textarea.setText(cadenaNueva);
            mensaje.setVisible(true);
        }
    }

    //Verificamos si existe un dato en una determinada tabla para un campo, si existe es true
    public boolean oneAttribRepeat(String tabla, String campo, String valor) {
        boolean b = false;
        try {
            Connection connection = Conexion.getInstance().getConnection();
            String sql = "select * from " + tabla + " where " + campo + "=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, valor);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                b = true;
            }
            connection.close();
        } catch (Exception e) {

        }
        return b;
    }

    //Crear un directorio o una carpeta
    public void CrearDirectorio(String direc) {
        File directorio = new File(direc);
        if (!directorio.exists()) {
            directorio.mkdir();
        }
    }

    //Cambiar nombre del directorio
    public void CambiarNombreDirectorio(String direcAnt, String direcNew) {
        File directorioAnt = new File(direcAnt);
        File directorioNuevo = new File(direcNew);
        directorioAnt.renameTo(directorioNuevo);
    }

    //Copiamos un archivo desde su origen a un destino
    public void CopiarImagen(String rtaorigen, String rtadestino) {

        File dirOrigen = new File(rtaorigen);
        File dirSalida = new File(rtadestino);
        try {
            FileInputStream fis = new FileInputStream(dirOrigen); //inFile -> Archivo a copiar
            FileOutputStream fos = new FileOutputStream(dirSalida); //outFile -> Copia del archivo
            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();
            inChannel.transferTo(0, inChannel.size(), outChannel);
            fis.close();
            fos.close();
        } catch (IOException ioe) {
        }
    }

    //Copiar un archivo de un directorio1 a otro directorio2
    public void CopiarArchivo(String direcOrigen, String direcDestino) throws IOException {
        File ArchivoOrigen = new File(direcOrigen);
        File ArchivoDestino = new File(direcDestino);
        ArchivoDestino.delete();
        ArchivoDestino.createNewFile();

        FileChannel origen = null;
        FileChannel destino = null;
        try {
            origen = new FileInputStream(ArchivoOrigen).getChannel();
            destino = new FileOutputStream(ArchivoDestino).getChannel();

            long count = 0;
            long size = origen.size();
            while ((count += destino.transferFrom(origen, count, size - count)) < size);
        } finally {
            if (origen != null) {
                origen.close();
            }
            if (destino != null) {
                destino.close();
            }
        }
    }

    //Verificar si existe el archivo en una ruta determinada
    public boolean ExisteArchivo(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    //Eliminar archivo de una ruta determinada
    public void EliminarFichero(String Ruta) {
        File Archivo = new File(Ruta);
        Archivo.delete();
    }

    //Eliminar un directorio con todo su contenido
    public void EliminarDirectorio(File Archivo) {
        if (!Archivo.exists()) {
            return;
        }
        if (Archivo.isDirectory()) {
            String[] archivosYDirectorios = Archivo.list();
            for (int i = 0; i < archivosYDirectorios.length; i++) {
                String rutaActual = Archivo.getAbsolutePath() + "\\" + archivosYDirectorios[i];
                EliminarDirectorio(new File(rutaActual));
            }
        }
        Archivo.delete();
    }

    //Seleccionar el texto de un campo
    public void selectAllText(JTextField tx) {
        tx.setSelectionEnd(tx.getText().length());
        tx.setSelectionStart(0);
        tx.requestFocus();
    }

    //Mostrar Jinternal encima del DesktopPane ---> Primer metodo
    public void MotrarInternal(JDesktopPane jDesktop, JInternalFrame internal) {
        jDesktop.removeAll();
        internal.setBorder(null);
        jDesktop.add(internal);
        try {
            internal.setMaximum(true);
        } catch (Exception e) {
            e.getMessage();
        }
        internal.show();
        internal.toFront();
    }

    //Mostrar Jinternal encima del DesktopPane ---> Segundo metodo
    public void MostrarJFrameInternos(JDesktopPane Desk, JInternalFrame jIf) {
        //Desk.removeAll();
        Desk.updateUI();
        Desk.add(jIf, JLayeredPane.DEFAULT_LAYER);
        jIf.setLocation(jIf.getParent().getWidth() / 2 - jIf.getWidth() / 2, jIf.getParent().getHeight() / 2 - jIf.getHeight() / 2 - 20);
        jIf.setVisible(true);
    }

    //Mostrar modulos comos Jinternal encima del DesktopPane ---> Tercer metodo
    public void MostrarModulos(JDesktopPane Desk, JInternalFrame jIf) {
        Desk.removeAll();
        Desk.updateUI();
        Desk.add(jIf, JLayeredPane.DEFAULT_LAYER);
        jIf.setVisible(true);
    }

    //Mostrar JFrame
    public void MostrarJFrame(JFrame jFrm) {
        jFrm.setVisible(true);
    }

    //Metodo para llamar a otros programas como: calculadora (calc), etc.
    public void MostrarUtilitarios(String util) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(util);
            int p = proc.exitValue();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    //Dar sonido a los botones
    public void sonido(String archivo) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Audio/" + archivo + ".wav")));
            clip.start();
        } catch (Exception e) {

        }
    }

    //Capturar foto del usuario desde la base de datos --> Primer método
    public void CapturarFoto(String consulta, JTextField text, JLabel label) {
        ImageIcon foto;
        InputStream is;
        try {
            Connection connection = Conexion.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, text.getText());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                is = rs.getBinaryStream(1);
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                if (img.equals(foto.getImage())) {//validacion si existe el imagen lo crgar sino lo carga el default
                    Image newimg = img.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newicon = new ImageIcon(newimg);
                    label.setIcon(newicon);
                } else {
                    ImageIcon fot = new ImageIcon(System.getProperties().getProperty("user.dir") + "\\Fotos\\default.png");
                    Icon icono = new ImageIcon(fot.getImage().getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH));
                    label.setIcon(icono);
                    label.repaint();
                }
            }
        } catch (Exception e) {
            mensajes.mensajeError("Capturar Foto");
        }
    }

    //Capturar foto del usuario desde la base de datos --> Primer método
    public void UsuarioFoto(String consulta, JTextField text, JLabel fotousu) {
        ImageIcon foto;
        InputStream is;
        try {
            Connection connection = Conexion.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, text.getText());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                is = rs.getBinaryStream(1);
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(fotousu.getWidth(), fotousu.getHeight(), java.awt.Image.SCALE_SMOOTH);
                ImageIcon newicon = new ImageIcon(newimg);
                fotousu.setIcon(newicon);
            }
        } catch (Exception ex) {
            mensajes.mensajeError("Usuario Foto");
        }
    }

    //Abrir una URL
    public void OpenURL(String url) {
        String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (osName.startsWith("Mac OS X")) {
                // Runtime.getRuntime().exec("open -a safari " + url);
                // Runtime.getRuntime().exec("open " + url + "/index.html");
                Runtime.getRuntime().exec("open " + url);
            } else {
                System.out.println("Please open a browser and go to " + url);
            }
        } catch (IOException e) {
            System.out.println("Failed to start a browser to open the url " + url);
            e.printStackTrace();
        }
    }

    //Redondear un numero con dos decimales --> Primer metodo
    public String Redondeo(String numero) {
        DecimalFormat redondea = new DecimalFormat("#############.00");
        String num = redondea.format(Double.parseDouble(numero));
        num = num.substring(0, num.length() - 3) + "." + num.substring(num.length() - 2, num.length());
        if (num.charAt(0) == '.') {
            num = "0" + num;
        } else if (num.charAt(0) == '-') {
            if (num.charAt(1) == '.') {
                num = "-0." + num.substring(num.length() - 2, num.length());
            }
        }
        return num;
    }

    //Redondear un numero con dos decimales --> Segundo metodo
    public void Numero_1Punto_2Decimales(KeyEvent e, JTextField tx) {
        int t = e.getKeyChar();
        if (t == 46) {
            boolean b = false;
            if (tx.getText().length() == 0) {
                e.consume();
            } else {
                int l = tx.getText().length();
                int i = 0;
                for (i = 0; i < l; i++) {
                    if (tx.getText().charAt(i) == '.') {
                        b = true;
                        i = l;
                    }
                }
                if (b == true) {
                    e.consume();
                }
            }
        } else {
            if (t < 48 || t > 57) {
                e.consume();
            }
            boolean b = false;
            int l = tx.getText().length();
            for (int i = 0; i < l - 2; i++) {
                if (tx.getText().charAt(i) == '.') {
                    b = true;
                    i = l;
                }
            }
            if (b == true) {
                e.consume();
            }
        }
    }

    //Click
    public boolean click(MouseEvent evt, int clicks) {
        if (evt.getClickCount() == clicks) {
            return true;
        }
        return false;
    }

    /**
     * *************************************************************************************************
     */
    public void letras(KeyEvent e) {
        int arrayletras[] = {32, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
            97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122,
            193, 201, 205, 209, 211, 218, 220, 225, 233, 237, 243, 250, 241, 252};
        char c = e.getKeyChar();
        if (Arrays.binarySearch(arrayletras, c) < 0) {
            e.consume();
        }
//            System.out.println("el caracter es-->>: "+(int)c);
    }

    public void DNI(JTextField tx, KeyEvent e) {
        int arraynumero[] = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
        char c = e.getKeyChar();
        if (tx.getText().length() < 8) {
            if (Arrays.binarySearch(arraynumero, c) < 0) {
                e.consume();
            }
        } else {
            e.consume();
        }
    }

    public void Telefonos(KeyEvent e) {
        int arraynumero[] = {45, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 32};
        char c = e.getKeyChar();
        if (Arrays.binarySearch(arraynumero, c) < 0) {
            e.consume();
        }
    }

    public void AnularTecl(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_BACK_SPACE) || (e.getKeyChar() == KeyEvent.VK_DELETE)) {
            e.consume();
        }
    }

    //Metodo para buscar una palabra dentro de una cadena (texto)
    public boolean buscarPalabra(String texto, String palabraBuscar) {
        boolean ver = false;
        String[] palabras = palabraBuscar.split("\\W+");
        for (String palabra : palabras) {
            if (texto.contains(palabra)) {
                ver = true;
            }
        }
        return ver;
    }
}
