/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Desktop;
import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JComboBox;
import java.io.*;

/**
 *
 * @author Aldo
 */
public class Aldo_Impresora {

    //Cargamos todas las impresoras instaladas en nuestro equipo
    public void cargarImpresoras(JComboBox jc) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService printService : printServices) {
            jc.addItem(printService.getName());
        }
    }

    public void imprimirPDF(String direcciopdf) throws IOException {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(direcciopdf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (inputStream == null) {
            return;
        }
        //Formtato de documento
        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        //Lectura de documento
        Doc document = new SimpleDoc(inputStream, docFormat, null);
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }
        inputStream.close();
    }

    //Metodo para imprimir todo tipo de archivos, a una empresora que podemos elegir
    public void imprimirArchivo(String rutaDoc) {
        //Codigo que nos ayuda para poder seleccionar nuestra impresora
        PrinterJob job = PrinterJob.getPrinterJob();
        //Ponemos en un if, cuando el usuario pulsa cancelar no se mande a imprimir
        if (job.printDialog()) {
            String impresora = job.getPrintService().getName();
            //ESTE ES TU CÓDIGO
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            java.io.File fichero = new java.io.File(rutaDoc);
            if (desktop.isSupported(Desktop.Action.PRINT)) {
                try {
                    try {
                        Process pr = Runtime.getRuntime().exec("Rundll32 printui.dll,PrintUIEntry /y /n \"" + impresora + "\"");
                    } catch (Exception ex) {
                        System.out.println("Ha ocurrido un error al ejecutar el comando. Error: " + ex);
                    }
                    desktop.print(fichero);
                } catch (Exception e) {
                    System.out.print("El sistema no permite imprimir usando la clase Desktop");
                    e.printStackTrace();
                }
            } else {
                System.out.print("El sistema no permite imprimir usando la clase Desktop");
            }
        }
    }
    
    //Metodo para abrir documentos pdf, word, etc. desde Java -- NOTA: la ruta es de esta forma: "carpeta/tuArchivo.pdf"
    public void abrirDoc(String ruta) {
        try {
            File path = new File(ruta);
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
