/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Aldo_Consultas;
import Clases.Aldo_Controlador;
import Clases.Aldo_Fechas;
import Clases.Aldo_FondoJDesktopPane;
import Clases.Aldo_General;
import Clases.Aldo_Mensajes;
import Clases.Aldo_Reportes;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author Aldo Omar
 */
public class JFrm_Menu extends javax.swing.JFrame {
    
    Aldo_Controlador controlador = new Aldo_Controlador();
    Aldo_General general = new Aldo_General();
    Aldo_Fechas fecha = new Aldo_Fechas();
    Aldo_Mensajes mensaje = new Aldo_Mensajes();
    Aldo_Consultas consulta = new Aldo_Consultas();
    Aldo_Reportes reporte = new Aldo_Reportes();

    /**
     * Creates new form Menu
     */
    public JFrm_Menu() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jDesktopPane1.setBorder(new Aldo_FondoJDesktopPane("/Imagenes/fondoMenu.jpg"));
        general.setIconoJFrame(this, "/Imagenes/logo.png");
        jLabelFecha.setText(fecha.fecha_db());
        this.setTitle("SISTEMA DE REGISTRO CIVIL V.1.0 - GRUPO: J&M SYSTEM-SOFT" + " USUARIO: " + JFrm_Acceso.jCTextFieldUsuario.getText());
    }
    
    public boolean verificarPermiso(String permiso) {
        boolean a = false;
        String sql1 = "select idpermiso from permiso where nom_per=";
        String idpermiso = consulta.devolverDato(sql1, permiso, 1);
        String sql2 = "select idusuario from usuario where nom=";
        String idusuario = consulta.devolverDato(sql2, JFrm_Acceso.jCTextFieldUsuario.getText(), 1);
        String sql3 = "select count(*) from detalle_permiso dp, usuario u, permiso p where u.idusuario=dp.idusuario "
                + "and p.idpermiso=dp.idpermiso and u.idusuario='" + idusuario + "' and p.idpermiso='" + idpermiso + "';";
        String totalpermiso = consulta.devolverRegistroDato(sql3, 1);
        if (totalpermiso.compareTo("1") == 0) {
            a = true;
        }
        return a;
    }
    
    public void CargarFormulario(int dto) {
        boolean b = false;
        JInternalFrame frame = null;
        switch (dto) {
            case 1: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_TipoUsuario) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_TipoUsuario Objifrm = new JInt_TipoUsuario();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 2: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_Usuario) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_Usuario Objifrm = new JInt_Usuario();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 3: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_TipoRegistro) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_TipoRegistro Objifrm = new JInt_TipoRegistro();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 4: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_TipoDocumento) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_TipoDocumento Objifrm = new JInt_TipoDocumento();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 5: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_Stand) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_Stand Objifrm = new JInt_Stand();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 6: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_Registro) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_Registro Objifrm = new JInt_Registro();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 7: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_PermisoUsuario) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_PermisoUsuario Objifrm = new JInt_PermisoUsuario();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 8: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_Permiso) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_Permiso Objifrm = new JInt_Permiso();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 9: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_Archivo) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_Archivo Objifrm = new JInt_Archivo();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 10: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_Apoderado) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_Apoderado Objifrm = new JInt_Apoderado();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 11: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_ActualizarPassword) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_ActualizarPassword Objifrm = new JInt_ActualizarPassword();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
//            case 12: {
//                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
//                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_ConfigurarImpresora) {
//                        b = true;
//                        frame = jDesktopPane1.getAllFrames()[i];
//                        break;
//                    }
//                }
//                if (!b) {
//                    JInt_ConfigurarImpresora Objifrm = new JInt_ConfigurarImpresora();
//                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
//                } else {
//                    frame.toFront();
//                }
//                break;
//            }
            case 13: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_Directorio) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_Directorio Objifrm = new JInt_Directorio();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 14: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_ListadoArchivos) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_ListadoArchivos Objifrm = new JInt_ListadoArchivos();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 15: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_ListadoHash) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_ListadoHash Objifrm = new JInt_ListadoHash();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 16: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_ValidarArchivos) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_ValidarArchivos Objifrm = new JInt_ValidarArchivos();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 17: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_RegistroDeclarante) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_RegistroDeclarante Objifrm = new JInt_RegistroDeclarante();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
            case 18: {
                for (int i = 0; i < jDesktopPane1.getAllFrames().length; i++) {
                    if (jDesktopPane1.getAllFrames()[i] instanceof JInt_AsignarLibro) {
                        b = true;
                        frame = jDesktopPane1.getAllFrames()[i];
                        break;
                    }
                }
                if (!b) {
                    JInt_AsignarLibro Objifrm = new JInt_AsignarLibro();
                    controlador.MostrarJFrameInternos(jDesktopPane1, Objifrm);
                } else {
                    frame.toFront();
                }
                break;
            }
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        jLabelFecha = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemTipoUsuario = new javax.swing.JMenuItem();
        jMenuItemListaUsuario = new javax.swing.JMenuItem();
        jMenuItemActualizarPassword = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemListaPermiso = new javax.swing.JMenuItem();
        jMenuItemPermisoUsuario = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemBackupBD = new javax.swing.JMenuItem();
        jMenuItemRestaurarBD = new javax.swing.JMenuItem();
        jMenuItemReiniciarSistema = new javax.swing.JMenuItem();
        jMenuItemSalirSistema = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemRegistro = new javax.swing.JMenuItem();
        jMenuItemArchivos = new javax.swing.JMenuItem();
        jMenuItemListaArchivos = new javax.swing.JMenuItem();
        jMenuItemHashArchivos = new javax.swing.JMenuItem();
        jMenuItemValidarArchivos = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItemTipoDocumento = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItemTipoRegistro = new javax.swing.JMenuItem();
        jMenuItemAsignarDeclarantes = new javax.swing.JMenuItem();
        jMenuItemAsignarLibros = new javax.swing.JMenuItem();
        jMenuItemLibro = new javax.swing.JMenuItem();
        jMenuItemApoderados = new javax.swing.JMenuItem();
        jMenuItemDirectorio = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelFecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFecha.setText("jLabel1");

        jDesktopPane1.setLayer(clockFace1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(105, 424, Short.MAX_VALUE)
                .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(jLabelFecha)
                .addContainerGap())
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setBorder(null);
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/configuraciones.png"))); // NOI18N
        jMenu1.setText("CONFIGURACIÓN");

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/permisoUsuario.png"))); // NOI18N
        jMenu3.setText("Usuarios");

        jMenuItemTipoUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemTipoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/tipoUsuario.png"))); // NOI18N
        jMenuItemTipoUsuario.setText("Tipos de usuario");
        jMenuItemTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTipoUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemTipoUsuario);

        jMenuItemListaUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemListaUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/usuarios.png"))); // NOI18N
        jMenuItemListaUsuario.setText("Lista usuarios");
        jMenuItemListaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListaUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemListaUsuario);

        jMenuItemActualizarPassword.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemActualizarPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/password.png"))); // NOI18N
        jMenuItemActualizarPassword.setText("Actualizar password");
        jMenuItemActualizarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActualizarPasswordActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemActualizarPassword);

        jMenu1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/lista.png"))); // NOI18N
        jMenu4.setText("Permisos");

        jMenuItemListaPermiso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemListaPermiso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/listaPermiso.png"))); // NOI18N
        jMenuItemListaPermiso.setText("Lista permisos");
        jMenuItemListaPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListaPermisoActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemListaPermiso);

        jMenuItemPermisoUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPermisoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/permisoUsuario.png"))); // NOI18N
        jMenuItemPermisoUsuario.setText("Asignar permiso a usuario");
        jMenuItemPermisoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPermisoUsuarioActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemPermisoUsuario);

        jMenu1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/database.png"))); // NOI18N
        jMenu5.setText("Base de datos");

        jMenuItemBackupBD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemBackupBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/backup.png"))); // NOI18N
        jMenuItemBackupBD.setText("Backup - Base de datos");
        jMenu5.add(jMenuItemBackupBD);

        jMenuItemRestaurarBD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRestaurarBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/restaurar.png"))); // NOI18N
        jMenuItemRestaurarBD.setText("Restaurar - Base de datos");
        jMenu5.add(jMenuItemRestaurarBD);

        jMenu1.add(jMenu5);

        jMenuItemReiniciarSistema.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemReiniciarSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reiniciar.png"))); // NOI18N
        jMenuItemReiniciarSistema.setText("Reiniciar el sistema");
        jMenuItemReiniciarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReiniciarSistemaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemReiniciarSistema);

        jMenuItemSalirSistema.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemSalirSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/exit.png"))); // NOI18N
        jMenuItemSalirSistema.setText("Salir del sistema");
        jMenuItemSalirSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirSistemaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSalirSistema);

        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(null);
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/usuarios_1.png"))); // NOI18N
        jMenu2.setText("REGISTRO CIVIL");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItemRegistro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/registro.png"))); // NOI18N
        jMenuItemRegistro.setText("Registro");
        jMenuItemRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistroActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemRegistro);

        jMenuItemArchivos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemArchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/files folders.png"))); // NOI18N
        jMenuItemArchivos.setText("Archivos");
        jMenuItemArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemArchivosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemArchivos);

        jMenuItemListaArchivos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemListaArchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/lista.png"))); // NOI18N
        jMenuItemListaArchivos.setText("Lista Archivos");
        jMenuItemListaArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListaArchivosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemListaArchivos);

        jMenuItemHashArchivos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemHashArchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/hash.png"))); // NOI18N
        jMenuItemHashArchivos.setText("Hash Archivos");
        jMenuItemHashArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHashArchivosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemHashArchivos);

        jMenuItemValidarArchivos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemValidarArchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check.png"))); // NOI18N
        jMenuItemValidarArchivos.setText("Validar Archivos");
        jMenuItemValidarArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemValidarArchivosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemValidarArchivos);

        jMenuBar1.add(jMenu2);

        jMenu6.setBorder(null);
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/matenimient.png"))); // NOI18N
        jMenu6.setText("MANTENIMIENTO");

        jMenuItemTipoDocumento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemTipoDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/documento.png"))); // NOI18N
        jMenuItemTipoDocumento.setText("Tipo documento");
        jMenuItemTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTipoDocumentoActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemTipoDocumento);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/lista.png"))); // NOI18N
        jMenu8.setText("Tipo registro");

        jMenuItemTipoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/tipoRegistro.png"))); // NOI18N
        jMenuItemTipoRegistro.setText("Listado tipo registro");
        jMenuItemTipoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTipoRegistroActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItemTipoRegistro);

        jMenuItemAsignarDeclarantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar.png"))); // NOI18N
        jMenuItemAsignarDeclarantes.setText("Asignar Declarantes");
        jMenuItemAsignarDeclarantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAsignarDeclarantesActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItemAsignarDeclarantes);

        jMenuItemAsignarLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar.png"))); // NOI18N
        jMenuItemAsignarLibros.setText("Asignar Libros");
        jMenuItemAsignarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAsignarLibrosActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItemAsignarLibros);

        jMenu6.add(jMenu8);

        jMenuItemLibro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/libro.png"))); // NOI18N
        jMenuItemLibro.setText("Libro");
        jMenuItemLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLibroActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemLibro);

        jMenuItemApoderados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemApoderados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/usuarios.png"))); // NOI18N
        jMenuItemApoderados.setText("Declarantes");
        jMenuItemApoderados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemApoderadosActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemApoderados);

        jMenuItemDirectorio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemDirectorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/carpeta.png"))); // NOI18N
        jMenuItemDirectorio.setText("Directorio");
        jMenuItemDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDirectorioActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemDirectorio);

        jMenuBar1.add(jMenu6);

        jMenu7.setBorder(null);
        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reporte.png"))); // NOI18N
        jMenu7.setText("REPORTES");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/repor.png"))); // NOI18N
        jMenuItem1.setText("Total de registros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/report_1.png"))); // NOI18N
        jMenuItem2.setText("Registro de nacimiento");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem2);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/report_2.png"))); // NOI18N
        jMenuItem4.setText("Registro de matrimonio");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem4);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/report_3.png"))); // NOI18N
        jMenuItem3.setText("Registro de defunción");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem3);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/report_4.png"))); // NOI18N
        jMenuItem5.setText("Lista archivos por libro");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem5);

        jMenuBar1.add(jMenu7);

        jMenu9.setText("AYUDA");

        jMenuItem6.setText("Tutorial");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem6);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSalirSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirSistemaActionPerformed
        // TODO add your handling code here:
        mensaje.salirSistema();
    }//GEN-LAST:event_jMenuItemSalirSistemaActionPerformed

    private void jMenuItemReiniciarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReiniciarSistemaActionPerformed
        // TODO add your handling code here:
        JFrm_Acceso acceso = new JFrm_Acceso();
        mensaje.reiniciarSistema(this, acceso);
    }//GEN-LAST:event_jMenuItemReiniciarSistemaActionPerformed

    private void jMenuItemListaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListaUsuarioActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemListaUsuario.getText())) {
            CargarFormulario(2);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemListaUsuarioActionPerformed

    private void jMenuItemRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistroActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemRegistro.getText())) {
            CargarFormulario(6);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemRegistroActionPerformed

    private void jMenuItemArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemArchivosActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemArchivos.getText())) {
            CargarFormulario(9);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemArchivosActionPerformed

    private void jMenuItemTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTipoDocumentoActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemTipoDocumento.getText())) {
            CargarFormulario(4);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemTipoDocumentoActionPerformed

    private void jMenuItemTipoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTipoRegistroActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemTipoRegistro.getText())) {
            CargarFormulario(3);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemTipoRegistroActionPerformed

    private void jMenuItemLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLibroActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemLibro.getText())) {
            CargarFormulario(5);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemLibroActionPerformed

    private void jMenuItemApoderadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemApoderadosActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemApoderados.getText())) {
            CargarFormulario(10);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemApoderadosActionPerformed

    private void jMenuItemTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTipoUsuarioActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemTipoUsuario.getText())) {
            CargarFormulario(1);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemTipoUsuarioActionPerformed

    private void jMenuItemActualizarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActualizarPasswordActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemActualizarPassword.getText())) {
            CargarFormulario(11);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemActualizarPasswordActionPerformed

    private void jMenuItemListaPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListaPermisoActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemListaPermiso.getText())) {
            CargarFormulario(8);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemListaPermisoActionPerformed

    private void jMenuItemPermisoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPermisoUsuarioActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemPermisoUsuario.getText())) {
            CargarFormulario(7);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemPermisoUsuarioActionPerformed

    private void jMenuItemDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDirectorioActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemDirectorio.getText())) {
            CargarFormulario(13);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemDirectorioActionPerformed

    private void jMenuItemListaArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListaArchivosActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemListaArchivos.getText())) {
            CargarFormulario(14);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemListaArchivosActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItemHashArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHashArchivosActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemHashArchivos.getText())) {
            CargarFormulario(15);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemHashArchivosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        reporte.reportGeneral("reportRegistros", "REPORTE DE REGISTROS");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemValidarArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemValidarArchivosActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemValidarArchivos.getText())) {
            CargarFormulario(16);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemValidarArchivosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        reporte.reportLogo("reportRegNacimiento", "logo", "/reportes/mph.jpg", "REPORTE DE REGISTRO DE NACIMIENTOS");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        reporte.reportLogo("reportRegDefuncion", "logo", "/reportes/mph.jpg", "REPORTE DE REGISTRO DE DEFUNCIONES");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        reporte.reportLogo("reportRegMatrimonio", "logo", "/reportes/mph.jpg", "REPORTE DE REGISTRO DE MATRIMONIOS");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        reporte.reportGeneral("reportLibroRegistro", "LISTA ARCHIVOS POR LIBRO");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItemAsignarDeclarantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAsignarDeclarantesActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemAsignarDeclarantes.getText())) {
            CargarFormulario(17);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemAsignarDeclarantesActionPerformed

    private void jMenuItemAsignarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAsignarLibrosActionPerformed
        // TODO add your handling code here:
        if (verificarPermiso(jMenuItemAsignarLibros.getText())) {
            CargarFormulario(18);
        } else {
            mensaje.mensajeInformacion("No tiene Permiso para este menu");
        }
    }//GEN-LAST:event_jMenuItemAsignarLibrosActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        JFrm_Tutorial tuto = new JFrm_Tutorial();
        controlador.MostrarJFrame(tuto);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(JFrm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrm_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemActualizarPassword;
    private javax.swing.JMenuItem jMenuItemApoderados;
    private javax.swing.JMenuItem jMenuItemArchivos;
    private javax.swing.JMenuItem jMenuItemAsignarDeclarantes;
    private javax.swing.JMenuItem jMenuItemAsignarLibros;
    private javax.swing.JMenuItem jMenuItemBackupBD;
    private javax.swing.JMenuItem jMenuItemDirectorio;
    private javax.swing.JMenuItem jMenuItemHashArchivos;
    private javax.swing.JMenuItem jMenuItemLibro;
    private javax.swing.JMenuItem jMenuItemListaArchivos;
    private javax.swing.JMenuItem jMenuItemListaPermiso;
    private javax.swing.JMenuItem jMenuItemListaUsuario;
    private javax.swing.JMenuItem jMenuItemPermisoUsuario;
    private javax.swing.JMenuItem jMenuItemRegistro;
    private javax.swing.JMenuItem jMenuItemReiniciarSistema;
    private javax.swing.JMenuItem jMenuItemRestaurarBD;
    private javax.swing.JMenuItem jMenuItemSalirSistema;
    private javax.swing.JMenuItem jMenuItemTipoDocumento;
    private javax.swing.JMenuItem jMenuItemTipoRegistro;
    private javax.swing.JMenuItem jMenuItemTipoUsuario;
    private javax.swing.JMenuItem jMenuItemValidarArchivos;
    // End of variables declaration//GEN-END:variables
}
