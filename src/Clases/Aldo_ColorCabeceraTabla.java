/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Aldo
 */
public class Aldo_ColorCabeceraTabla extends javax.swing.table.DefaultTableCellRenderer {

    java.awt.Color Fondo;
    java.awt.Color Contenido;

    public Aldo_ColorCabeceraTabla(java.awt.Color Color_De_Fondo, java.awt.Color Color_De_Letras) {
        super();
        this.Fondo = Color_De_Fondo;
        this.Contenido = Color_De_Letras;
    }

    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable Tablita, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        java.awt.Component Componentes = super.getTableCellRendererComponent(Tablita, value, isSelected, hasFocus, row, column);
        Componentes.setBackground(Fondo);
        Componentes.setForeground(Contenido);
        Componentes.setFont(new java.awt.Font("Tahoma", 1, 15));

        this.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 193, 37)));
        return Componentes;
    }
}
