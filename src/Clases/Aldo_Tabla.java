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
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Aldo
 */
public class Aldo_Tabla {

    Aldo_Mensajes mensajes = new Aldo_Mensajes();

    //Limpiar el modelo de la tabla
    public void LimpiarTabla(DefaultTableModel md) {
        while (md.getRowCount() > 0) {
            md.removeRow(0);
        }
    }

    public void setMaxWidthColumnTable(JTable table, int width, int... indexs) {
        for (int j : indexs) {
            table.getColumnModel().getColumn(j).setMaxWidth(width);
            table.getColumnModel().getColumn(j).setWidth(width);
            table.getColumnModel().getColumn(j).setPreferredWidth(width);
        }
    }

    public void TablaTamañoColumnas(JTable table, int columna, int tamaño) {
        table.getColumnModel().getColumn(columna).setPreferredWidth(tamaño);
    }

    public void TablaLongitudColumnas(javax.swing.JTable table, int longitudes[]) {
        int ancho = 0;
        TableColumnModel mc = table.getColumnModel();
        TableColumn columnaTabla;
        for (int i = 0; i < table.getColumnCount(); i++) {
            columnaTabla = mc.getColumn(i);
            ancho = longitudes[i];
            columnaTabla.setPreferredWidth(ancho);
        }
    }

    //Metodo para poder ocultar las columnas -- Primer metodo
    public void ocultarColumnasTabla(JTable table, int... indexsOcultar) {
        for (int j : indexsOcultar) {
            table.getColumnModel().getColumn(j).setMinWidth(0);
            table.getColumnModel().getColumn(j).setPreferredWidth(0);
            table.getColumnModel().getColumn(j).setWidth(0);
            table.getColumnModel().getColumn(j).setMaxWidth(-1);
        }
    }

    public void tablaVerColumnas(javax.swing.JTable tbl, int columna[]) {
        for (int i = 0; i < columna.length; i++) {
            tbl.getColumnModel().getColumn(columna[i]).setMaxWidth(columna.length);
            tbl.getColumnModel().getColumn(columna[i]).setMinWidth(columna.length);
            tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMaxWidth(columna.length);
            tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMinWidth(columna.length);
        }
    }

    //Generar codigo de la tabla de una base de datos
    public String generarCodigoCount(String tabla, int tamaño) {
        String cdg = "";
        int valor = 0;
        try {
            Connection connection = Conexion.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("select count(*) from " + tabla);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                valor = Integer.parseInt(rs.getString(1));
            }
            connection.close();
        } catch (Exception e) {
        }
        valor = valor + 1;
        cdg = Integer.toString(valor);
        while (cdg.length() < tamaño) {
            cdg = "0" + cdg;
        }
        return cdg;
    }

    //Mostrar o llenar en la tabla -- Primera forma
    public void MostrarEnTabla(String consulta, JTable tabl, DefaultTableModel md, int ndatos) {
        String[] datos = new String[ndatos];
        int i = 0;
        try {
            LimpiarTabla(md);
            Connection connection = Conexion.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                while (i < ndatos) {
                    datos[i] = rs.getString(i + 1);
                    i++;
                }
                md.addRow(datos);
                i = 0;
            }
            //para ordenar la tabla ---->con un click en la cabecera
            TableRowSorter<TableModel> ordena = new TableRowSorter<TableModel>(md);
            tabl.setRowSorter(ordena);
            tabl.setModel(md);
        } catch (Exception e) {
            mensajes.mensajeError("Mostrar en la tabla");
        }
    }

    //Mostrar o llenar en la tabla -- Segunda forma
    public void llenarJTabla(String sq, DefaultTableModel mdl, int cdt) {
        LimpiarTabla(mdl);
        int Veces = 0;
        String Data[] = new String[20];
        try {
            Connection connection = Conexion.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sq);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                for (Veces = 1; Veces <= cdt; Veces++) {
                    Data[Veces - 1] = rs.getString(Veces);
                }
                mdl.addRow(Data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //genera numero siguiente como codigo de la tabla en la primera columna
    public int generanumSgtTabla(JTable table) {
        int nuevoCodigo = Integer.parseInt((String) table.getValueAt(table.getRowCount() - 1, 0)) + 1;
        return nuevoCodigo;
    }

    //Seleccionamos una fila de una tabla
    public void eliminarFilaTabla(JTable tabla, DefaultTableModel modelo) {
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            modelo.removeRow(fila);
        } else {
            mensajes.mensajeError("Debe seleccionar una fila");
        }
    }

    //limpiar la parte que hemos seleccionado en la tabla
    public void limpiarSeleccion(JTable table) {
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(false);
        table.clearSelection();
    }

    //para que la tabla no sea editable
    public void tablaNoEditable(JTable table) {
        table.setDefaultEditor(Object.class, null);
    }
}
