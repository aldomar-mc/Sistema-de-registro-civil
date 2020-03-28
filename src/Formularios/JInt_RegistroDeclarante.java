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
public class JInt_RegistroDeclarante extends javax.swing.JInternalFrame {

    Aldo_Controlador controlador = new Aldo_Controlador();
    Aldo_Tabla tabla = new Aldo_Tabla();
    Aldo_Mensajes mensaje = new Aldo_Mensajes();
    Aldo_Consultas consulta = new Aldo_Consultas();
    Aldo_EventosKey evento = new Aldo_EventosKey();
    Aldo_General general = new Aldo_General();
    DefaultTableModel modelo;
    String idaporegistro = "";
    String idtiporegistro = "";
    String idapoderado = "";

    /**
     * Creates new form JInt_Prueba
     */
    public JInt_RegistroDeclarante() {
        initComponents();
        general.setIconoJInternal(this, "/Imagenes/logo.png");
        limpiarCampos();
        estadoCampos(false);
        estadoBotones(false);
        tituloTabla();
        cargarTabla();
        tabla.tablaNoEditable(jTableRegistroDeclarante);
        consulta.llenarCombo("select * from tipo_reg where nomtpo<>'MATRIMONIO'", jComboBoxTipoRegistro, 2);
        consulta.llenarCombo("select * from apoderado where nom_apo<>'NINGUNO'", jComboBoxDeclarante, 2);
    }

    public void limpiarCampos() {
        controlador.limpiarComboBox(jComboBoxDeclarante);
        controlador.limpiarComboBox(jComboBoxTipoRegistro);
    }

    public void estadoCampos(boolean estado) {
        jComboBoxDeclarante.setEnabled(estado);
        jComboBoxTipoRegistro.setEnabled(estado);
    }

    public void estadoBotones(boolean estado) {
        jCButtonCancelar.setEnabled(estado);
    }

    public void tituloTabla() {
        String[] titulo = {"ID", "REGISTRO", "DECLARANTES"};
        modelo = new DefaultTableModel(null, titulo);
        modelo.setColumnIdentifiers(titulo);
        jTableRegistroDeclarante.setModel(modelo);
    }

    public void cargarTabla() {
        tabla.MostrarEnTabla("CALL listRegistroApode()", jTableRegistroDeclarante, modelo, 3);
        tabla.setMaxWidthColumnTable(jTableRegistroDeclarante, 30, 0);
    }

    public void buscarTipoDocumento() {
        controlador.BuscarDato("CALL searchRegistroApode(?)", modelo, 3, jCTextFieldBuscar);
    }

    public void insertarRegApo() {
        idtiporegistro = consulta.devolverDato("select idtipo_reg from tipo_reg where nomtpo=", jComboBoxTipoRegistro.getSelectedItem().toString(), 1);
        idapoderado = consulta.devolverDato("select idapoderado from apoderado where nom_apo=", jComboBoxDeclarante.getSelectedItem().toString(), 1);
        try {
            String sql = "CALL insertRegistroApode("
                    + "'" + idtiporegistro + "',"
                    + "'" + idapoderado + "'"
                    + " );";
            mensaje.mensajeInformacion(consulta.CrearRegistro(sql));
        } catch (Exception e) {
            mensaje.mensajeError("Insertar registroApoderado");
        }
    }

    public boolean ValidarCampos() {
        boolean valor = false;
        if (jComboBoxTipoRegistro.getSelectedIndex() != 0) {
            if (jComboBoxDeclarante.getSelectedIndex() != 0) {
                valor = true;
            } else {
                mensaje.mensajeError("Debe seleccionar un declarante.");
                jComboBoxDeclarante.requestFocus();
            }
        } else {
            mensaje.mensajeError("Debe seleccionar un tipo de registro.");
            jComboBoxTipoRegistro.requestFocus();
        }
        return valor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxTipoRegistro = new javax.swing.JComboBox<>();
        jComboBoxDeclarante = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jCButtonNuevo = new ControlSwing.JCButton();
        jCButtonCancelar = new ControlSwing.JCButton();
        jCButtonSalir = new ControlSwing.JCButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRegistroDeclarante = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jCTextFieldBuscar = new ControlSwing.JCTextField();

        setTitle("ASIGNAR DECLARANTES AL REGISTRO");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Tipo registro");

        jComboBoxTipoRegistro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));

        jComboBoxDeclarante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Declarante");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxTipoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxDeclarante, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBoxDeclarante, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBoxTipoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
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

        jCButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jCButtonCancelar.setText("Cancelar");
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCButtonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCButtonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "LISTADO DE REGISTROS CON DECLARANTES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jTableRegistroDeclarante.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableRegistroDeclarante);

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscarKeyTyped(evt);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            jComboBoxTipoRegistro.requestFocus();
        } else {
            if (ValidarCampos() == true) {
                insertarRegApo();
                cargarTabla();
                limpiarCampos();
                estadoCampos(false);
                jCButtonCancelar.setEnabled(false);
                general.IconButton(jCButtonNuevo, "./src/Iconos/nuevo.png");
                jCButtonNuevo.setText("Nuevo");
            }
        }
    }//GEN-LAST:event_jCButtonNuevoActionPerformed

    private void jCButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        estadoCampos(false);
        estadoBotones(false);
        general.IconButton(jCButtonNuevo, "./src/Iconos/nuevo.png");
        jCButtonNuevo.setText("Nuevo");
        jCButtonNuevo.setEnabled(true);
    }//GEN-LAST:event_jCButtonCancelarActionPerformed

    private void jCTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldBuscar);
        buscarTipoDocumento();
    }//GEN-LAST:event_jCTextFieldBuscarKeyReleased

    private void jCTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
    }//GEN-LAST:event_jCTextFieldBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ControlSwing.JCButton jCButtonCancelar;
    private ControlSwing.JCButton jCButtonNuevo;
    private ControlSwing.JCButton jCButtonSalir;
    private ControlSwing.JCTextField jCTextFieldBuscar;
    private javax.swing.JComboBox<String> jComboBoxDeclarante;
    private javax.swing.JComboBox<String> jComboBoxTipoRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRegistroDeclarante;
    // End of variables declaration//GEN-END:variables
}