/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Aldo_Consultas;
import Clases.Aldo_Controlador;
import Clases.Aldo_EventosKey;
import Clases.Aldo_General;
import Clases.Aldo_Mensajes;
import Clases.Aldo_Tabla;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aldo Omar
 */
public class JInt_Stand extends javax.swing.JInternalFrame {

    Aldo_Controlador controlador = new Aldo_Controlador();
    Aldo_Tabla tabla = new Aldo_Tabla();
    Aldo_Mensajes mensaje = new Aldo_Mensajes();
    Aldo_Consultas consulta = new Aldo_Consultas();
    Aldo_EventosKey evento = new Aldo_EventosKey();
    Aldo_General general = new Aldo_General();
    DefaultTableModel modelo;
    private String idstand = "";

    /**
     * Creates new form JInt_Prueba
     */
    public JInt_Stand() {
        initComponents();
        general.setIconoJInternal(this, "/Imagenes/logo.png");
        limpiarCampos();
        estadoCampos(false);
        estadoBotones(false);
        tituloTabla();
        cargarTabla();
        tabla.tablaNoEditable(jTableStand);
    }

    public void limpiarCampos() {
        controlador.limpiarJTexField(jCTextFieldNumero);
        controlador.limpiarJTextArea(jTextAreaDetalle);
    }

    public void estadoCampos(boolean estado) {
        jCTextFieldNumero.setEnabled(estado);
        jTextAreaDetalle.setEnabled(estado);
    }

    public void estadoBotones(boolean estado) {
        jCButtonCancelar.setEnabled(estado);
        jCButtonEditar.setEnabled(estado);
    }

    public void tituloTabla() {
        String[] titulo = {"ID", "NÚMERO", "DESCRIPCIÓN"};
        modelo = new DefaultTableModel(null, titulo);
        modelo.setColumnIdentifiers(titulo);
        jTableStand.setModel(modelo);
    }

    public void cargarTabla() {
        tabla.MostrarEnTabla("CALL listStand()", jTableStand, modelo, 3);
        tabla.setMaxWidthColumnTable(jTableStand, 30, 0);
        tabla.setMaxWidthColumnTable(jTableStand, 80, 1);
    }

    public void buscarStand() {
        controlador.BuscarDato("CALL searchStand(?)", modelo, 3, jCTextFieldBuscar);
    }

    public void insertarStand() {
        try {
            String sql = "CALL insertStand("
                    + "'" + jCTextFieldNumero.getText() + "',"
                    + "'" + jTextAreaDetalle.getText() + "'"
                    + " );";
            mensaje.mensajeInformacion(consulta.CrearRegistro(sql));
        } catch (Exception e) {
            mensaje.mensajeError("Insertar Stand");
        }
    }

    public void editarStand() {
        try {
            String sql = "CALL editStand("
                    + "'" + jCTextFieldNumero.getText() + "',"
                    + "'" + jTextAreaDetalle.getText() + "',"
                    + "'" + idstand + "'"
                    + " );";
            mensaje.mensajeInformacion(consulta.CrearRegistro(sql));
        } catch (Exception e) {
            mensaje.mensajeError("Editar Stand");
        }
    }

    public void eliminarStand() {
        try {
            String sql = "CALL deleteStand("
                    + "'" + idstand + "'"
                    + " );";
            mensaje.mensajeInformacion(consulta.CrearRegistro(sql));
        } catch (Exception e) {
            mensaje.mensajeError("Eliminar Stand");
        }
    }

    public boolean ValidarCampos() {
        boolean valor = false;
        if (jCTextFieldNumero.getText().length() != 0) {
            valor = true;
        } else {
            mensaje.mensajeError("Debe ingresar número del stand.");
            jCTextFieldNumero.requestFocus();
        }
        return valor;
    }

    public void asignarCampos() {
        try {
            idstand = modelo.getValueAt(jTableStand.getSelectedRow(), 0).toString();
            controlador.asignarJTexField(jCTextFieldNumero, modelo, jTableStand, 1);
            controlador.asignarJTextArea(jTextAreaDetalle, modelo, jTableStand, 2);
        } catch (Exception e) {
            mensaje.mensajeError("Asignar campos");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItemModificar = new javax.swing.JMenuItem();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDetalle = new javax.swing.JTextArea();
        jCTextFieldNumero = new ControlSwing.JCTextField();
        jPanel3 = new javax.swing.JPanel();
        jCButtonNuevo = new ControlSwing.JCButton();
        jCButtonEditar = new ControlSwing.JCButton();
        jCButtonCancelar = new ControlSwing.JCButton();
        jCButtonSalir = new ControlSwing.JCButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStand = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jCTextFieldBuscar = new ControlSwing.JCTextField();

        jMenuItemModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenuItemModificar.setText("Modificar");
        jMenuItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemModificar);

        jMenuItemEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        jMenuItemEliminar.setText("Eliminar");
        jMenuItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemEliminar);

        setTitle("MANTENIMIENTO DE LIBROS");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS DEL LIBRO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("N° Libro");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Detalle");

        jTextAreaDetalle.setColumns(20);
        jTextAreaDetalle.setRows(5);
        jTextAreaDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaDetalleKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTextAreaDetalle);

        jCTextFieldNumero.setPlaceholder("Ingrese número del libro");
        jCTextFieldNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldNumeroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldNumeroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldNumeroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jCTextFieldNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "CONTROLES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jCButtonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        jCButtonNuevo.setText("Nuevo");
        jCButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonNuevoActionPerformed(evt);
            }
        });

        jCButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar.png"))); // NOI18N
        jCButtonEditar.setText("Editar");
        jCButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonEditarActionPerformed(evt);
            }
        });

        jCButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jCButtonCancelar.setText("Cancelar");
        jCButtonCancelar.setMargin(new java.awt.Insets(2, 3, 2, 3));
        jCButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonCancelarActionPerformed(evt);
            }
        });

        jCButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jCButtonSalir.setText("Salir");
        jCButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCButtonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "LISTADO DE LIBROS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jTableStand.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableStand.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTableStand);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Buscar");

        jCTextFieldBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldBuscar.setPlaceholder("Ingrese un dato para buscar");
        jCTextFieldBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldBuscarActionPerformed(evt);
            }
        });
        jCTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCTextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldBuscarActionPerformed

    private void jCButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonSalirActionPerformed
        // TODO add your handling code here:
        mensaje.cerrarVentanaSinConfirmarJI(this);
    }//GEN-LAST:event_jCButtonSalirActionPerformed

    private void jCButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonNuevoActionPerformed
        // TODO add your handling code here:
        if (jCButtonNuevo.getText().equals("Nuevo")) {
            general.IconButton(jCButtonNuevo, "./src/Iconos/guardar.png");
            jCButtonNuevo.setText("Guardar");
            jCButtonCancelar.setEnabled(true);
            limpiarCampos();
            estadoCampos(true);
            jCTextFieldNumero.requestFocus();
        } else {
            if (ValidarCampos() == true) {
                insertarStand();
                cargarTabla();
                limpiarCampos();
                estadoCampos(false);
                jCButtonCancelar.setEnabled(false);
                general.IconButton(jCButtonNuevo, "./src/Iconos/nuevo.png");
                jCButtonNuevo.setText("Nuevo");
            }
        }
    }//GEN-LAST:event_jCButtonNuevoActionPerformed

    private void jMenuItemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarActionPerformed
        // TODO add your handling code here:
        estadoCampos(true);
        estadoBotones(true);
        jCButtonNuevo.setEnabled(false);
        int filamodificar = jTableStand.getSelectedRow();
        if (filamodificar >= 0) {
            asignarCampos();
        } else {
            mensaje.mensajeError("Modificar...");
        }
    }//GEN-LAST:event_jMenuItemModificarActionPerformed

    private void jCButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonEditarActionPerformed
        // TODO add your handling code here:
        if (jTableStand.getSelectedRow() >= 0) {
            if (mensaje.mensajeConsulta("Realmente desea actualizar el registro?") == JOptionPane.YES_NO_OPTION) {
                editarStand();
                cargarTabla();
                limpiarCampos();
                estadoCampos(false);
                estadoBotones(false);
                jCButtonNuevo.setEnabled(true);
            } else {
                mensaje.mensajeInformacion("No se actualizo ningún registro.");
            }
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para editar.");
        }
    }//GEN-LAST:event_jCButtonEditarActionPerformed

    private void jMenuItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarActionPerformed
        // TODO add your handling code here:
        if (jTableStand.getSelectedRow() >= 0) {
            if (mensaje.mensajeConsulta("Estás seguro de eliminar el registro?") == JOptionPane.YES_NO_OPTION) {
                asignarCampos();
                eliminarStand();
                cargarTabla();
                limpiarCampos();
                estadoCampos(false);
                estadoBotones(false);
                jCButtonNuevo.setEnabled(true);
            } else {
                mensaje.mensajeInformacion("No se elimino ningún registro.");
            }
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para eliminar.");
        }
    }//GEN-LAST:event_jMenuItemEliminarActionPerformed

    private void jCButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        estadoCampos(false);
        estadoBotones(false);
        general.IconButton(jCButtonNuevo, "./src/Iconos/nuevo.png");
        jCButtonNuevo.setText("Nuevo");
        jCButtonNuevo.setEnabled(true);
    }//GEN-LAST:event_jCButtonCancelarActionPerformed

    private void jCTextFieldNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNumeroKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield_A_JTexArea(evt, jCTextFieldNumero, jTextAreaDetalle);
    }//GEN-LAST:event_jCTextFieldNumeroKeyPressed

    private void jCTextFieldNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNumeroKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldNumero);
    }//GEN-LAST:event_jCTextFieldNumeroKeyReleased

    private void jCTextFieldNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNumeroKeyTyped
        // TODO add your handling code here:
        evento.soloNcarc(20, jCTextFieldNumero, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldNumero);
    }//GEN-LAST:event_jCTextFieldNumeroKeyTyped

    private void jTextAreaDetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaDetalleKeyTyped
        // TODO add your handling code here:
        evento.SoloNCaracteresJTextArea(evt, jTextAreaDetalle, 100);
    }//GEN-LAST:event_jTextAreaDetalleKeyTyped

    private void jCTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldBuscar);
        buscarStand();
    }//GEN-LAST:event_jCTextFieldBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ControlSwing.JCButton jCButtonCancelar;
    private ControlSwing.JCButton jCButtonEditar;
    private ControlSwing.JCButton jCButtonNuevo;
    private ControlSwing.JCButton jCButtonSalir;
    private ControlSwing.JCTextField jCTextFieldBuscar;
    private ControlSwing.JCTextField jCTextFieldNumero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JMenuItem jMenuItemModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableStand;
    private javax.swing.JTextArea jTextAreaDetalle;
    // End of variables declaration//GEN-END:variables
}
