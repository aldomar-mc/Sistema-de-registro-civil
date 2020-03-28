/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Aldo_Consultas;
import Clases.Aldo_Controlador;
import Clases.Aldo_EventosKey;
import Clases.Aldo_Fechas;
import Clases.Aldo_General;
import Clases.Aldo_Mensajes;
import Clases.Aldo_Tabla;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aldo Omar
 */
public class JFrm_CrearUsuario extends javax.swing.JFrame {

    Aldo_Controlador controlador = new Aldo_Controlador();
    Aldo_Tabla tabla = new Aldo_Tabla();
    Aldo_Mensajes mensaje = new Aldo_Mensajes();
    Aldo_Consultas consulta = new Aldo_Consultas();
    Aldo_EventosKey evento = new Aldo_EventosKey();
    Aldo_Fechas fecha = new Aldo_Fechas();
    Aldo_General general = new Aldo_General();
    DefaultTableModel modelo;
    String idusuario = "";
    String idtipousuario = "";

    /**
     * Creates new form JFrm_CrearUsuario
     */
    public JFrm_CrearUsuario() {
        initComponents();
        general.setIconoJFrame(this, "/Imagenes/logo.png");
        this.setLocationRelativeTo(null);
        limpiarCampos();
        consulta.llenarCombo("select * from tipousuario", jComboBoxTipoUsuario, 2);
        jCTextFieldNombres.requestFocus();
        jCTextFieldUsuario.setText(JFrm_Acceso.jCTextFieldUsuario.getText());
        jComboBoxEstado.setEnabled(false);
    }

    public void limpiarCampos() {
        controlador.limpiarJTexField(jCTextFieldNombres);
        controlador.limpiarJTexField(jCTextFieldApellidos);
        controlador.limpiarJTexField(jCTextFieldDNI);
        controlador.limpiarJTexField(jCTextFieldDireccion);
        controlador.limpiarJTexField(jCTextFieldUsuario);
        controlador.limpiarComboBox(jComboBoxGenero);
        controlador.limpiarComboBox(jComboBoxEstado);
        controlador.limpiarComboBox(jComboBoxTipoUsuario);
        controlador.limpiarDataChooser(jDateChooserFechaNacimiento);
        controlador.limpiarjPasswordField(jPasswordFieldPassword);
        controlador.limpiarjPasswordField(jPasswordFieldPasswordRepetir);
        controlador.limpiarTimeChooser(timeChooserHoraNacimiento);
    }

    public void insertarUsuario() {
        idtipousuario = consulta.devolverDato("select * from tipousuario where tpusr=", jComboBoxTipoUsuario.getSelectedItem().toString(), 1);
        try {
            String sql = "CALL insertUsuario("
                    + "'" + jCTextFieldDNI.getText() + "',"
                    + "'" + jCTextFieldNombres.getText() + "',"
                    + "'" + jCTextFieldApellidos.getText() + "',"
                    + "'" + jComboBoxGenero.getSelectedItem().toString() + "',"
                    + "'" + jCTextFieldDireccion.getText() + "',"
                    + "'" + fecha.Formato_AMD(jDateChooserFechaNacimiento.getDate()) + "',"
                    + "'" + fecha.HoraMysql(timeChooserHoraNacimiento.getText()) + "',"
                    + "'" + jCTextFieldUsuario.getText() + "',"
                    + "'" + jPasswordFieldPassword.getText() + "',"
                    + "'" + jComboBoxEstado.getSelectedItem().toString() + "',"
                    + "'" + idtipousuario + "'"
                    + " );";
            mensaje.mensajeInformacion(consulta.CrearRegistro(sql));
        } catch (Exception e) {
            mensaje.mensajeError("Insertar usuario");
        }
    }

    public void insertarPermiso() {
        try {
            consulta.Consulta("CALL insertDetallePermiso()");
        } catch (Exception e) {
            mensaje.mensajeError("Insertar permiso usuario");
        }
    }

    public boolean ValidarCampos() {
        boolean valor = false;
        if (jCTextFieldNombres.getText().length() != 0) {
            if (jCTextFieldApellidos.getText().length() != 0) {
                if (jCTextFieldDNI.getText().length() != 0) {
                    if (jComboBoxGenero.getSelectedIndex() != 0) {
                        if (jDateChooserFechaNacimiento.getDate() != null) {
                            if (timeChooserHoraNacimiento.getText().length() != 0) {
                                if (jCTextFieldDireccion.getText().length() != 0) {
                                    if (jComboBoxTipoUsuario.getSelectedIndex() != 0) {
                                        if (jCTextFieldUsuario.getText().length() != 0) {
                                            if (jPasswordFieldPassword.getText().length() != 0) {
                                                if (jPasswordFieldPasswordRepetir.getText().length() != 0) {
                                                    if (jPasswordFieldPassword.getText().equals(jPasswordFieldPasswordRepetir.getText())) {
                                                        if (jComboBoxEstado.getSelectedIndex() != -1) {
                                                            valor = true;
                                                        } else {
                                                            mensaje.mensajeError("Debe seleccionar su estado.");
                                                            jComboBoxEstado.requestFocus();
                                                        }
                                                    } else {
                                                        mensaje.mensajeError("Los passwords ingresados no coinciden.");
                                                        jPasswordFieldPassword.requestFocus();
                                                    }
                                                } else {
                                                    mensaje.mensajeError("Debe volver a ingresar su password.");
                                                    jPasswordFieldPasswordRepetir.requestFocus();
                                                }
                                            } else {
                                                mensaje.mensajeError("Debe ingresar su password.");
                                                jPasswordFieldPassword.requestFocus();
                                            }
                                        } else {
                                            mensaje.mensajeError("Debe ingresar su usuario.");
                                            jCTextFieldUsuario.requestFocus();
                                        }
                                    } else {
                                        mensaje.mensajeError("Debe seleccionar su tipo de usuario.");
                                        jComboBoxTipoUsuario.requestFocus();
                                    }
                                } else {
                                    mensaje.mensajeError("Debe ingresar su dirección.");
                                    jCTextFieldDireccion.requestFocus();
                                }
                            } else {
                                mensaje.mensajeError("Debe ingresar su hora de nacimiento.");
                                timeChooserHoraNacimiento.requestFocus();
                            }
                        } else {
                            mensaje.mensajeError("Debe ingresar su fecha de nacimiento.");
                            jDateChooserFechaNacimiento.requestFocusInWindow();
                        }
                    } else {
                        mensaje.mensajeError("Debe Seleccionar su género.");
                        jComboBoxGenero.requestFocus();
                    }
                } else {
                    mensaje.mensajeError("Debe ingresar su DNI.");
                    jCTextFieldDNI.requestFocus();
                }
            } else {
                mensaje.mensajeError("Debe ingresar su apellido.");
                jCTextFieldApellidos.requestFocus();
            }
        } else {
            mensaje.mensajeError("Debe ingresar su nombre.");
            jCTextFieldNombres.requestFocus();
        }
        return valor;
    }

    public void verificarDNI(KeyEvent evt) {
        if (controlador.oneAttribRepeat("persona", "dni", jCTextFieldDNI.getText())) {
            mensaje.mensajeError("El DNI ingresado ya existe.");
            controlador.selectAllText(jCTextFieldDNI);
            jCTextFieldDNI.requestFocus();
        } else {
            evento.EnterJTexfield_A_JComboBox(evt, jCTextFieldDNI, jComboBoxGenero);
        }
    }

    public void verificarUsuario(KeyEvent evt) {
        if (controlador.oneAttribRepeat("usuario", "nom", jCTextFieldUsuario.getText())) {
            mensaje.mensajeError("El usuario ingresado ya existe.");
            controlador.selectAllText(jCTextFieldUsuario);
            jCTextFieldUsuario.requestFocus();
        } else {
            evento.EnterJTexfieldAJPasswordField(evt, jCTextFieldUsuario, jPasswordFieldPassword);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCTextFieldNombres = new ControlSwing.JCTextField();
        jCTextFieldApellidos = new ControlSwing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCTextFieldDNI = new ControlSwing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxGenero = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jCTextFieldDireccion = new ControlSwing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jDateChooserFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        timeChooserHoraNacimiento = new org.bolivia.time.TimeChooser();
        jPanel3 = new javax.swing.JPanel();
        jCButtonNuevo = new ControlSwing.JCButton();
        jCButtonCancelar = new ControlSwing.JCButton();
        jCButtonSalir = new ControlSwing.JCButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxTipoUsuario = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jCTextFieldUsuario = new ControlSwing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jPasswordFieldPasswordRepetir = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CREAR USUARIO");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS PERSONALES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nombres");

        jCTextFieldNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldNombres.setPlaceholder("Ingrese sus nombres completos");
        jCTextFieldNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldNombresActionPerformed(evt);
            }
        });
        jCTextFieldNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldNombresKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldNombresKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldNombresKeyTyped(evt);
            }
        });

        jCTextFieldApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldApellidos.setPlaceholder("Ingrese sus apellidos completos");
        jCTextFieldApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldApellidosActionPerformed(evt);
            }
        });
        jCTextFieldApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidosKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("DNI");

        jCTextFieldDNI.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDNI.setPlaceholder("Ingrese su DNI");
        jCTextFieldDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDNIActionPerformed(evt);
            }
        });
        jCTextFieldDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Género");

        jComboBoxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "FEMENINO", "MASCULINO" }));
        jComboBoxGenero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxGeneroKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Dirección");

        jCTextFieldDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDireccion.setPlaceholder("Ingrese su dirección");
        jCTextFieldDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDireccionActionPerformed(evt);
            }
        });
        jCTextFieldDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Fec. Nac");

        jDateChooserFechaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserFechaNacimientoKeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Hor. Nac");

        timeChooserHoraNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timeChooserHoraNacimientoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCTextFieldNombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCTextFieldApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jDateChooserFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel5)
                                        .addGap(11, 11, 11)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxGenero, 0, 114, Short.MAX_VALUE)
                                    .addComponent(timeChooserHoraNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timeChooserHoraNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "CONTROLES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jCButtonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar.png"))); // NOI18N
        jCButtonNuevo.setText("Guardar");
        jCButtonNuevo.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jCButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonNuevoActionPerformed(evt);
            }
        });

        jCButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jCButtonCancelar.setText("Cancelar");
        jCButtonCancelar.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jCButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonCancelarActionPerformed(evt);
            }
        });

        jCButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jCButtonSalir.setText("Salir");
        jCButtonSalir.setMargin(new java.awt.Insets(2, 5, 2, 5));
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
                .addComponent(jCButtonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(jCButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCButtonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS DEL USUARIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tipo Usuario");

        jComboBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        jComboBoxTipoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxTipoUsuarioKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Usuario");

        jCTextFieldUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldUsuario.setPlaceholder("Ingrese su usuario");
        jCTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldUsuarioActionPerformed(evt);
            }
        });
        jCTextFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldUsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldUsuarioKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Password");

        jPasswordFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordKeyPressed(evt);
            }
        });

        jPasswordFieldPasswordRepetir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldPasswordRepetirKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Repetir Password");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Estado");

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldPasswordRepetir, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(jComboBoxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jComboBoxTipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordFieldPassword)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jPasswordFieldPasswordRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCTextFieldNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldNombresActionPerformed

    private void jCTextFieldNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombresKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldNombres, jCTextFieldApellidos);
    }//GEN-LAST:event_jCTextFieldNombresKeyPressed

    private void jCTextFieldNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombresKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldNombres);
    }//GEN-LAST:event_jCTextFieldNombresKeyReleased

    private void jCTextFieldNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombresKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldNombres, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldNombres);
    }//GEN-LAST:event_jCTextFieldNombresKeyTyped

    private void jCTextFieldApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldApellidosActionPerformed

    private void jCTextFieldApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidosKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldApellidos, jCTextFieldDNI);
    }//GEN-LAST:event_jCTextFieldApellidosKeyPressed

    private void jCTextFieldApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidosKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldApellidos);
    }//GEN-LAST:event_jCTextFieldApellidosKeyReleased

    private void jCTextFieldApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidosKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldApellidos, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldApellidos);
    }//GEN-LAST:event_jCTextFieldApellidosKeyTyped

    private void jCTextFieldDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDNIActionPerformed

    private void jCTextFieldDNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIKeyPressed
        // TODO add your handling code here:
        if (jCTextFieldDNI.getText().trim().length() > 0) {
            if (evt.getKeyChar() == evt.VK_ENTER) {
                verificarDNI(evt);
            }
        }
    }//GEN-LAST:event_jCTextFieldDNIKeyPressed

    private void jCTextFieldDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDNIKeyReleased

    private void jCTextFieldDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIKeyTyped
        // TODO add your handling code here:
        evento.soloNumeros(evt);
        evento.soloNcarc(8, jCTextFieldDNI, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDNI);
    }//GEN-LAST:event_jCTextFieldDNIKeyTyped

    private void jComboBoxGeneroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxGeneroKeyPressed
        // TODO add your handling code here:
        evento.EnterJComboBox_A_JDateChosster(evt, jComboBoxGenero, jDateChooserFechaNacimiento);
    }//GEN-LAST:event_jComboBoxGeneroKeyPressed

    private void jCTextFieldDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDireccionActionPerformed

    private void jCTextFieldDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield_A_JComboBox(evt, jCTextFieldDireccion, jComboBoxTipoUsuario);
    }//GEN-LAST:event_jCTextFieldDireccionKeyPressed

    private void jCTextFieldDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldDireccion);
    }//GEN-LAST:event_jCTextFieldDireccionKeyReleased

    private void jCTextFieldDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionKeyTyped
        // TODO add your handling code here:
        evento.soloNcarc(85, jCTextFieldDireccion, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDireccion);
    }//GEN-LAST:event_jCTextFieldDireccionKeyTyped

    private void jDateChooserFechaNacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFechaNacimientoKeyPressed
        // TODO add your handling code here:
        evento.EnterJDateChosster_A_JTexField(evt, jDateChooserFechaNacimiento, timeChooserHoraNacimiento);
    }//GEN-LAST:event_jDateChooserFechaNacimientoKeyPressed

    private void timeChooserHoraNacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeChooserHoraNacimientoKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, timeChooserHoraNacimiento, jCTextFieldDireccion);
    }//GEN-LAST:event_timeChooserHoraNacimientoKeyPressed

    private void jCButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonNuevoActionPerformed
        // TODO add your handling code here:
        if (ValidarCampos() == true) {
            insertarUsuario();
            insertarPermiso();
            JFrm_Acceso jrm = new JFrm_Acceso();
            jrm.setVisible(true);
            JFrm_Acceso.jCTextFieldUsuario.setText(jCTextFieldUsuario.getText());
            dispose();
        }
    }//GEN-LAST:event_jCButtonNuevoActionPerformed

    private void jCButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        jCTextFieldNombres.requestFocus();
    }//GEN-LAST:event_jCButtonCancelarActionPerformed

    private void jCButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonSalirActionPerformed
        // TODO add your handling code here:
        mensaje.cerrarVentanaConfirmarJF(this);
    }//GEN-LAST:event_jCButtonSalirActionPerformed

    private void jComboBoxTipoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxTipoUsuarioKeyPressed
        // TODO add your handling code here:
        evento.EnterJComboBox_A_JTexField(evt, jCTextFieldUsuario);
    }//GEN-LAST:event_jComboBoxTipoUsuarioKeyPressed

    private void jCTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldUsuarioActionPerformed

    private void jCTextFieldUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldUsuarioKeyPressed
        // TODO add your handling code here:
        if (jCTextFieldDNI.getText().trim().length() > 0) {
            if (evt.getKeyChar() == evt.VK_ENTER) {
                verificarUsuario(evt);
            }
        }
    }//GEN-LAST:event_jCTextFieldUsuarioKeyPressed

    private void jCTextFieldUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldUsuarioKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldUsuario);
    }//GEN-LAST:event_jCTextFieldUsuarioKeyReleased

    private void jCTextFieldUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldUsuarioKeyTyped
        // TODO add your handling code here:
        evento.soloNcarc(15, jCTextFieldUsuario, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldUsuario);
    }//GEN-LAST:event_jCTextFieldUsuarioKeyTyped

    private void jPasswordFieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordKeyPressed
        // TODO add your handling code here:
        evento.EnterJPasswordField(evt, jPasswordFieldPassword, jPasswordFieldPasswordRepetir);
    }//GEN-LAST:event_jPasswordFieldPasswordKeyPressed

    private void jPasswordFieldPasswordRepetirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordRepetirKeyPressed
        // TODO add your handling code here:
        evento.EnterJPasswordField_A_JComboBox(evt, jPasswordFieldPasswordRepetir, jComboBoxEstado);
    }//GEN-LAST:event_jPasswordFieldPasswordRepetirKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrm_CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrm_CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrm_CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrm_CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrm_CrearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ControlSwing.JCButton jCButtonCancelar;
    private ControlSwing.JCButton jCButtonNuevo;
    private ControlSwing.JCButton jCButtonSalir;
    private ControlSwing.JCTextField jCTextFieldApellidos;
    private ControlSwing.JCTextField jCTextFieldDNI;
    private ControlSwing.JCTextField jCTextFieldDireccion;
    private ControlSwing.JCTextField jCTextFieldNombres;
    private ControlSwing.JCTextField jCTextFieldUsuario;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxGenero;
    private javax.swing.JComboBox<String> jComboBoxTipoUsuario;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JPasswordField jPasswordFieldPasswordRepetir;
    private org.bolivia.time.TimeChooser timeChooserHoraNacimiento;
    // End of variables declaration//GEN-END:variables
}
