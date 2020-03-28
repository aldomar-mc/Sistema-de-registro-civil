package Clases;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author Aldo Omar
 */
public class Aldo_FormatoTabla extends DefaultTableCellRenderer {

    private int columna_patron;
    private String columna_valor;

    public Aldo_FormatoTabla(int Colpatron, String Colvalor) {
        this.columna_patron = Colpatron;
        this.columna_valor = Colvalor;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        setBackground(Color.white);//color de fondo
        table.setForeground(Color.black);//color de texto
        //Si la celda corresponde a una fila con estado FALSE, se cambia el color de fondo a rojo
        if (table.getValueAt(row, columna_patron).equals(columna_valor)) {
            setBackground(Color.red);
        }

        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
    }

}
