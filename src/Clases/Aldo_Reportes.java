/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author SAMSUNG
 */
public class Aldo_Reportes {

    public String url = "";

    public void imprime_par_2(String url, String nompar1, String valpar1, String nompar2, String valpar2) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            Map parame = new HashMap();
            parame.put(nompar1, valpar1);
            parame.put(nompar2, valpar2);
            //parame.put("imagen", System.getProperties().getProperty("user.dir") + "/imagenesper/default.png");
            JasperPrint prt = JasperFillManager.fillReport(url, parame, connection);
            JasperViewer JsperView = new JasperViewer(prt, false);
            JsperView.setTitle("REPORTE SISTEMA DE VENTAS");
            JsperView.setExtendedState(6);
            JsperView.setVisible(true);
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
//            gnrl.aviso("Verifique si los datos que ingreso son correctos y vuelva a intentarlo");
        }
    }

    public void ImpresionConDisProDep(String nomRep, String logo, JComboBox distrito, JComboBox provincia, JComboBox departamento) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            Map parame = new HashMap();
            url = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + nomRep;
            parame.put("logo", this.getClass().getResourceAsStream(logo));
            parame.put("distrito", distrito.getSelectedItem().toString());
            parame.put("provincia", provincia.getSelectedItem().toString());
            parame.put("departamento", departamento.getSelectedItem().toString());
            JasperPrint prt = JasperFillManager.fillReport(url, parame, connection);
            JasperViewer JsperView = new JasperViewer(prt, false);
            JsperView.setTitle("REPORTE SISTEMA DE VENTAS");
            JsperView.setExtendedState(6);
            JsperView.setVisible(true);
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
//            gnrl.aviso("Verifique si los datos que ingreso son correctos y vuelva a intentarlo");
        }
    }

    public void ImpresionConFechaHora(String nomRep, JFormattedTextField fecha, JFormattedTextField Hora_inicio, JFormattedTextField Hora_fin, JComboBox combo1, JComboBox combo2) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            Map parame = new HashMap();
            url = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + nomRep;
            parame.put("fec", fecha.getText());
            parame.put("h_ini", Hora_inicio.getText() + " " + combo1.getSelectedItem().toString());
            parame.put("h_fin", Hora_fin.getText() + " " + combo2.getSelectedItem().toString());
            JasperPrint prt = JasperFillManager.fillReport(url, parame, connection);
            JasperViewer JsperView = new JasperViewer(prt, false);
            JsperView.setTitle("REPORTE DE VISITANTES");
            JsperView.setExtendedState(6);
            JsperView.setVisible(true);
            connection.close();
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Impresion con fecha y hora");
        }
    }

    public void imprime_con_Fecha(String nomRep, String logo, JFormattedTextField ingreso, JFormattedTextField salida) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            Map parame = new HashMap();
            url = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + nomRep;
            parame.put("logo", this.getClass().getResourceAsStream(logo));
            parame.put("fec_ini", ingreso.getText());
            parame.put("fec_fin", salida.getText());
            JasperPrint prt = JasperFillManager.fillReport(url, parame, connection);
            JasperViewer JsperView = new JasperViewer(prt, false);
            JsperView.setTitle("REPORTE DE VISITANTES");
            JsperView.setExtendedState(6);
            JsperView.setVisible(true);
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Reporte con dos fechas");
        }
    }

    public void Estado(String nomRep, String logo, String nompar, String valpar) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            Map parame = new HashMap();
            url = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + nomRep;
            parame.put(nompar, valpar);
            parame.put("logo", this.getClass().getResourceAsStream(logo));
            JasperPrint prt = JasperFillManager.fillReport(url, parame, connection);
            JasperViewer JsperView = new JasperViewer(prt, false);
            JsperView.setTitle("REPORTE DE USUARIOS");
            JsperView.setExtendedState(6);
            JsperView.setVisible(true);
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Reporte estado usuario");
        }
    }

    public void EstadoFotos(String nomRep, String logo, String nompar, JComboBox combo) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            Map parame = new HashMap();
            url = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + nomRep;
            parame.put(nompar, combo.getSelectedItem().toString());
            parame.put("logo", this.getClass().getResourceAsStream(logo));
            JasperPrint prt = JasperFillManager.fillReport(url, parame, connection);
            JasperViewer JsperView = new JasperViewer(prt, false);
            JsperView.setTitle("REPORTE DE USUARIOS");
            JsperView.setExtendedState(6);
            JsperView.setVisible(true);
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Reporte estado usuario");
        }
    }

    public void Ocurrencia(String nomRep, String logo, String nompar, String valpar) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            Map parame = new HashMap();
            url = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + nomRep;
            parame.put(nompar, valpar);
            parame.put("logo", this.getClass().getResourceAsStream(logo));
            JasperPrint prt = JasperFillManager.fillReport(url, parame, connection);
            JasperViewer JsperView = new JasperViewer(prt, false);
            JsperView.setTitle("REPORTE OCURRENCIAS");
            JsperView.setExtendedState(6);
            JsperView.setVisible(true);
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Reporte de ocurrencias");
        }
    }

    public void vigilante(String nomRep, String logo, JLabel label, JTextField dni, String valpar) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            Map parame = new HashMap();
            url = System.getProperties().getProperty("user.dir") + "/src/Reportes/" + nomRep;
            parame.put(dni, valpar);
            parame.put("logo", this.getClass().getResourceAsStream(logo));
            parame.put("foto", label.getText());
            JasperPrint prt = JasperFillManager.fillReport(url, parame, connection);
            JasperViewer JsperView = new JasperViewer(prt, false);
            JsperView.setTitle("REPORTE DE VIGILANTE");
            JsperView.setExtendedState(6);
            JsperView.setVisible(true);
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Reporte vigilante");
        }
    }

    public void ReportePDF(String ruta, String archivo) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            String rutainforme = ruta;
            JasperPrint informe = JasperFillManager.fillReport(rutainforme, null, connection);
            JasperExportManager.exportReportToPdfFile(informe, archivo);
            JasperViewer ventanavisor = new JasperViewer(informe, false);
            ventanavisor.setTitle("INFORME");
            ventanavisor.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error exportar el documento");
        }
    }

    //Exportar un Reporte a pdf
    public void BotonExportarPDF(String nomRep) {
        //ABRIR CUADRO DE DIALOGO PARA GUARDAR EL ARCHIVO         
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("todos los archivos *.PDF", "pdf", "PDF"));//filtro para ver solo archivos .pdf
        int seleccion = fileChooser.showSaveDialog(null);
        try {
            if (seleccion == JFileChooser.APPROVE_OPTION) {//comprueba si ha presionado el boton de aceptar
                File JFC = fileChooser.getSelectedFile();
                String PATH = JFC.getAbsolutePath();//obtenemos la direccion del archivo + el nombre a guardar
                try (PrintWriter printwriter = new PrintWriter(JFC)) {
                    printwriter.print("src\\Reportes\\" + nomRep + ".jasper");
                }
                this.ReportePDF("src\\Reportes\\" + nomRep + ".jasper", PATH);//mandamos como parametros la ruta del archivo a compilar y el nombre y ruta donde se guardaran    
                //comprobamos si a la hora de guardar obtuvo la extension y si no se la asignamos
                if (!(PATH.endsWith(".pdf"))) {
                    File temp = new File(PATH + ".pdf");
                    JFC.renameTo(temp);//renombramos el archivo
                }
                JOptionPane.showMessageDialog(null, "Esto puede tardar unos segundos, espere porfavor", "Estamos Generando el Reporte", JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null, "Documento Exportado Exitosamente!", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException | HeadlessException e) {//por alguna excepcion salta un mensaje de error
            JOptionPane.showMessageDialog(null, "Error al Exportar el archivo!", "Oops! Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //REPORTE GENERAL
    public void reportGeneral(String nombrerep, String titulo) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            Map parame = new HashMap();
            String rta = System.getProperties().getProperty("user.dir") + "/src/reportes/" + nombrerep + ".jasper";
            JasperPrint prt = JasperFillManager.fillReport(rta, parame, connection);
            int n = prt.getPages().size();
            if (n > 0) {
                JasperViewer JsperView = new JasperViewer(prt, false);
                JsperView.setTitle(titulo);
                JsperView.setExtendedState(6);
                JsperView.show();
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos");
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    //REPORTE CON UN LOGO
    public void reportLogo(String nomRep, String nomlogoiReport, String logo, String tituloReport) {
        try {
            Connection connection = Conexion.getInstance().getConnection();
            Map parame = new HashMap();
            String rta = System.getProperties().getProperty("user.dir") + "/src/reportes/" + nomRep + ".jasper";
            parame.put(nomlogoiReport, this.getClass().getResourceAsStream(logo));
            JasperPrint prt = JasperFillManager.fillReport(rta, parame, connection);
            JasperViewer JsperView = new JasperViewer(prt, false);
            JsperView.setTitle(tituloReport);
            JsperView.setExtendedState(6);
            JsperView.setVisible(true);
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Reporte con logo");
        }
    }
}
