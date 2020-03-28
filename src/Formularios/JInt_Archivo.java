/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.Aldo_Consultas;
import Clases.Aldo_Controlador;
import Clases.Aldo_Encrypt;
import Clases.Aldo_EventosKey;
import Clases.Aldo_Fechas;
import Clases.Aldo_General;
import Clases.Aldo_Impresora;
import Clases.Aldo_Mensajes;
import Clases.Aldo_Tabla;
import JcSampleBar.Job;
import JcSampleBar.jcThread;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aldo Omar
 */
public class JInt_Archivo extends javax.swing.JInternalFrame {

    Aldo_Controlador controlador = new Aldo_Controlador();
    Aldo_Tabla tabla = new Aldo_Tabla();
    Aldo_Mensajes mensaje = new Aldo_Mensajes();
    Aldo_Consultas consulta = new Aldo_Consultas();
    Aldo_EventosKey evento = new Aldo_EventosKey();
    Aldo_Fechas fecha = new Aldo_Fechas();
    Aldo_Impresora impresora = new Aldo_Impresora();
    Aldo_Encrypt encrypt = new Aldo_Encrypt();
    Aldo_General general = new Aldo_General();
    private DefaultTableModel modelo;
    private DefaultTableModel modeloR;
    private String idarchivo = "";
    private String numeroActa = "";
    private String query = "";
    private String idstan = "";
    private String idregistr = "";
    private String idtipodoc = "";
    private String rutaArchivo_dirr = "";
    private String numacta = "";
    public static String ruta_archivo_abrir = "";
    private String directorioPrincipal = "";
    private String nombreArchivo = "";

    /**
     * Creates new form JInt_Prueba
     */
    public JInt_Archivo() {
        initComponents();
        general.setIconoJInternal(this, "/Imagenes/logo.png");
        limpiarCampos();
        estadoCampos(false);
        estadoBotones(true);
        //cargarCombo();
        tituloTabla();
        cargarTabla();
        tituloTablaR();
        cargarTablaR();
        //Asignamos la ruta del directorio donde se va guardr los archivos
        jCTextFieldDirectorio.setText(consulta.devolverRegistroDato("select * from directorio", 2));
        //No editables
        jCTextFieldDirectorio.setEnabled(false);
        jCTextFieldRutaFrontal.setEnabled(false);
        jCTextFieldRutaPosterior.setEnabled(false);
        tabla.tablaNoEditable(jTableArchivo);
        tabla.tablaNoEditable(jTableListaRegistros);

        jCButtonArchivoFrontal.setEnabled(false);
        jCButtonArchivoPosterior.setEnabled(false);
    }

    public void cargaArchivo() {
        //trabajo cualquiera
        //Tiempo de trabajo de 5 segundos
        new Thread(new Job(Integer.valueOf(3))).start();
        // animacion de jProgressBar
        //Velocidad de barra de progreso 50 milisegundos
        new Thread(new jcThread(this.jProgressBar1, Integer.valueOf(50))).start();
    }

    public void limpiarCampos() {
        controlador.limpiarJTexField(jCTextFieldRutaFrontal);
        controlador.limpiarJTexField(jCTextFieldRutaPosterior);
        controlador.limpiarComboBox(jComboBoxNLibro);
        //controlador.limpiarComboBox(jComboBoxTipoDoc);
        jLabelarchivo.setIcon(null);
        jLabelarchivo1.setIcon(null);
    }

    public void estadoCampos(boolean estado) {
        jComboBoxNLibro.setEnabled(estado);
        jComboBoxTipoDoc.setEnabled(estado);
    }

    public void estadoBotones(boolean estado) {
        jCButtonCancelar.setEnabled(estado);
        jCButtonEditar.setEnabled(estado);
    }

    public void cargarCombo(String numacta, String tiporeg) {
        //cargamos los datos a los combos
        consulta.llenarCombo("select * from tipo_doc tdo where nom_doc not in (select td.nom_doc\n"
                + "from archivo a, tipo_doc td, registro r where r.idregistro=a.idregistro and\n"
                + "td.idtipo_doc=a.idtipo_doc and r.num_acta=" + numacta + ")", jComboBoxTipoDoc, 2);
        consulta.llenarCombo("select * from stand s, tipo_reg tr, detalle_libro dl\n"
                + "where s.idstand=dl.idstand and tr.idtipo_reg=dl.idtipo_reg and tr.nomtpo='" + tiporeg + "'", jComboBoxNLibro, 2);
    }

    public void tituloTabla() {
        String[] titulo = {"ID", "DNI", "APELLIDOS Y NOMBRES", "TIPO REGISTRO", "N° ACTA", "DOCUMENTO", "N° LIBRO", "ARCHIVO", "FEC. SUBIDO", "HRA. SUBIDO"};
        modelo = new DefaultTableModel(null, titulo);
        modelo.setColumnIdentifiers(titulo);
        jTableArchivo.setModel(modelo);
    }

    public void cargarTabla() {
        tabla.MostrarEnTabla("CALL listArchivo()", jTableArchivo, modelo, 10);
        tabla.ocultarColumnasTabla(jTableArchivo, 0);
        tabla.ocultarColumnasTabla(jTableArchivo, 1);
        tabla.setMaxWidthColumnTable(jTableArchivo, 300, 2);
        tabla.setMaxWidthColumnTable(jTableArchivo, 90, 3);
        tabla.setMaxWidthColumnTable(jTableArchivo, 90, 4);
        tabla.setMaxWidthColumnTable(jTableArchivo, 90, 5);
        tabla.setMaxWidthColumnTable(jTableArchivo, 60, 6);
        tabla.setMaxWidthColumnTable(jTableArchivo, 80, 8);
        tabla.setMaxWidthColumnTable(jTableArchivo, 80, 9);
    }

    public void buscarArchivoRN() {
        controlador.BuscarDato("CALL searchArchivoRN(?)", modelo, 10, jCTextFieldBuscar);
    }

    public void tituloTablaR() {
        String[] titulo = {"N° ACTA", "APELLIDOS Y NOMBRES", "TIPO REGISTRO", "N° DOC."};
        modeloR = new DefaultTableModel(null, titulo);
        modeloR.setColumnIdentifiers(titulo);
        jTableListaRegistros.setModel(modeloR);
    }

    public void cargarTablaR() {
        tabla.MostrarEnTabla("CALL listRegistroSinArchivoRN()", jTableListaRegistros, modeloR, 4);
        tabla.setMaxWidthColumnTable(jTableListaRegistros, 80, 0);
        tabla.setMaxWidthColumnTable(jTableListaRegistros, 350, 1);
        tabla.setMaxWidthColumnTable(jTableListaRegistros, 60, 3);
    }

    public void buscarListRegistroRN() {
        controlador.BuscarDato("CALL searchRegistroSinArchivoRN(?)", modeloR, 4, jCTextFieldBuscar1);
    }

    public String ruta(String numacta, JTextField ruta, String tipo) {
        String directoriogeneral = "/" + tipo + "_" + numacta + "_" + fecha.fecha_db1();
        String ultimoscarac3 = ruta.getText().substring(ruta.getText().length() - 3, ruta.getText().length());
        if (ultimoscarac3.equals("pdf")) {
            String directoriotemporal = directoriogeneral + ".pdf";
            if (controlador.ExisteArchivo(directoriotemporal)) {
                directoriogeneral = directoriogeneral + "_1" + ".pdf";
            } else {
                directoriogeneral = directoriogeneral + ".pdf";
            }
        } else {
            String directoriotemporal = directoriogeneral + ".jpg";
            if (controlador.ExisteArchivo(directoriotemporal)) {
                directoriogeneral = directoriogeneral + "_1" + ".jpg";
            } else {
                directoriogeneral = directoriogeneral + ".jpg";
            }
        }
        return directoriogeneral;
    }

    public void insertarArcCons() {
        numacta = modeloR.getValueAt(jTableListaRegistros.getSelectedRow(), 0).toString();
        idstan = consulta.devolverDato("select * from stand where num_stand=", jComboBoxNLibro.getSelectedItem().toString(), 1);
        idregistr = consulta.devolverDato("select * from registro where num_acta=", numacta, 1);
        idtipodoc = consulta.devolverDato("select * from tipo_doc where nom_doc=", jComboBoxTipoDoc.getSelectedItem().toString(), 1);
        //Insertamos el archivo frontal
        String directoriogeneral = ruta(numacta, jCTextFieldRutaFrontal, "Frontal");
        String hashArchivo = encrypt.hashArchivo(jCTextFieldRutaFrontal.getText());
        try {
            query = "CALL insertArchivo("
                    + "'" + directoriogeneral + "',"
                    + "'" + idstan + "',"
                    + "'" + idregistr + "',"
                    + "'" + idtipodoc + "',"
                    + "'" + hashArchivo + "'"
                    + " );";
            consulta.Consulta(query);
            controlador.CopiarArchivo(jCTextFieldRutaFrontal.getText(), jCTextFieldDirectorio.getText() + directoriogeneral);
        } catch (Exception e) {
            mensaje.mensajeError("Insertar archivo frontal");
        }
        //Insertamos el archivo posterior
        String directoriogeneral_1 = ruta(numacta, jCTextFieldRutaPosterior, "Posterior");
        String hashArchivo_1 = encrypt.hashArchivo(jCTextFieldRutaPosterior.getText());
        try {
            query = "CALL insertArchivo("
                    + "'" + directoriogeneral_1 + "',"
                    + "'" + idstan + "',"
                    + "'" + idregistr + "',"
                    + "'" + idtipodoc + "',"
                    + "'" + hashArchivo_1 + "'"
                    + " );";
            consulta.Consulta(query);
            controlador.CopiarArchivo(jCTextFieldRutaPosterior.getText(), jCTextFieldDirectorio.getText() + directoriogeneral_1);
            mensaje.mensajeInformacion("Se ingreso satisfactoriamente.");
        } catch (Exception e) {
            mensaje.mensajeError("Insertar archivo posterior");
        }
    }

    public void insertarArchivoExp() {
        numacta = modeloR.getValueAt(jTableListaRegistros.getSelectedRow(), 0).toString();
        idstan = consulta.devolverDato("select * from stand where num_stand=", jComboBoxNLibro.getSelectedItem().toString(), 1);
        idregistr = consulta.devolverDato("select * from registro where num_acta=", numacta, 1);
        idtipodoc = consulta.devolverDato("select * from tipo_doc where nom_doc=", jComboBoxTipoDoc.getSelectedItem().toString(), 1);
        //Insertamos el archivo expediente
        String directoriogeneral = ruta(numacta, jCTextFieldRutaFrontal, "Expediente");
        String hashArchivo = encrypt.hashArchivo(jCTextFieldRutaFrontal.getText());
        try {
            String sql_1 = "CALL insertArchivo("
                    + "'" + directoriogeneral + "',"
                    + "'" + idstan + "',"
                    + "'" + idregistr + "',"
                    + "'" + idtipodoc + "',"
                    + "'" + hashArchivo + "'"
                    + " );";
            consulta.Consulta(sql_1);
            controlador.CopiarArchivo(jCTextFieldRutaFrontal.getText(), jCTextFieldDirectorio.getText() + directoriogeneral);
            mensaje.mensajeInformacion("Se ingreso satisfactoriamente.");
        } catch (Exception e) {
            mensaje.mensajeError("Insertar expediente");
        }
    }

    public void editarArchivo() {
        idstan = consulta.devolverDato("select * from stand where num_stand=", jComboBoxNLibro.getSelectedItem().toString(), 1);
        idregistr = consulta.devolverDato("select * from registro where num_acta=", numeroActa, 1);
        idtipodoc = consulta.devolverDato("select * from tipo_doc where nom_doc=", jComboBoxTipoDoc.getSelectedItem().toString(), 1);
        if (jCTextFieldRutaFrontal.getText().length() != 0) {
            if (controlador.ExisteArchivo(jCTextFieldRutaFrontal.getText())) {
                if (rutaArchivo_dirr.equals(jCTextFieldRutaFrontal.getText())) {
                    String hashArchivo_F = encrypt.hashArchivo(jCTextFieldRutaFrontal.getText().replace("/", "\\"));
                    try {
                        query = "CALL editArchivo("
                                + "'" + rutaArchivo_dirr + "',"
                                + "'" + idstan + "',"
                                + "'" + idregistr + "',"
                                + "'" + idtipodoc + "',"
                                + "'" + idarchivo + "',"
                                + "'" + hashArchivo_F + "'"
                                + " );";
                        mensaje.mensajeInformacion(consulta.CrearRegistro(query));
                    } catch (Exception e) {
                        mensaje.mensajeError("Ya no se debe de modificar el archivo");
                    }
                } else {
                    String directoriogeneral = "";
                    String ultimoscarac3 = jCTextFieldRutaFrontal.getText().substring(jCTextFieldRutaFrontal.getText().length() - 3, jCTextFieldRutaFrontal.getText().length());
                    if (ultimoscarac3.equals("pdf")) {
                        directoriogeneral = ruta(numeroActa, jCTextFieldRutaFrontal, "Expediente");
                    } else {
                        directoriogeneral = ruta(numeroActa, jCTextFieldRutaFrontal, "Frontal");
                    }

                    String hashArchivo_F = encrypt.hashArchivo(jCTextFieldRutaFrontal.getText());
                    try {
                        query = "CALL editArchivo("
                                + "'" + directoriogeneral + "',"
                                + "'" + idstan + "',"
                                + "'" + idregistr + "',"
                                + "'" + idtipodoc + "',"
                                + "'" + idarchivo + "',"
                                + "'" + hashArchivo_F + "'"
                                + " );";
                        mensaje.mensajeInformacion(consulta.CrearRegistro(query));
                        //Eliminamos el archivo anterior
                        controlador.EliminarFichero(rutaArchivo_dirr);
                        //Copiamos el nuevo archivo
                        controlador.CopiarArchivo(jCTextFieldRutaFrontal.getText(), jCTextFieldDirectorio.getText() + directoriogeneral);

                    } catch (Exception e) {
                        mensaje.mensajeError("Se debe de modificar el archivo");
                    }
                }
            } else {
                mensaje.mensajeInformacion("No existe el archivo");
            }
        } else {
            if (controlador.ExisteArchivo(jCTextFieldRutaPosterior.getText())) {
                if (rutaArchivo_dirr.equals(jCTextFieldRutaPosterior.getText())) {
                    String hashArchivo_P = encrypt.hashArchivo(jCTextFieldRutaPosterior.getText().replace("/", "\\"));
                    try {
                        query = "CALL editArchivo("
                                + "'" + rutaArchivo_dirr + "',"
                                + "'" + idstan + "',"
                                + "'" + idregistr + "',"
                                + "'" + idtipodoc + "',"
                                + "'" + idarchivo + "',"
                                + "'" + hashArchivo_P + "'"
                                + " );";
                        mensaje.mensajeInformacion(consulta.CrearRegistro(query));
                    } catch (Exception e) {
                        mensaje.mensajeError("Ya no se debe de modificar el archivo");
                    }
                } else {
                    String directoriogeneral = ruta(numeroActa, jCTextFieldRutaPosterior, "Posterior");
                    String hashArchivo_P = encrypt.hashArchivo(jCTextFieldRutaPosterior.getText());
                    try {
                        query = "CALL editArchivo("
                                + "'" + directoriogeneral + "',"
                                + "'" + idstan + "',"
                                + "'" + idregistr + "',"
                                + "'" + idtipodoc + "',"
                                + "'" + idarchivo + "',"
                                + "'" + hashArchivo_P + "'"
                                + " );";
                        mensaje.mensajeInformacion(consulta.CrearRegistro(query));
                        //Eliminamos el archivo anterior
                        controlador.EliminarFichero(rutaArchivo_dirr);
                        //Copiamos el nuevo archivo
                        controlador.CopiarArchivo(jCTextFieldRutaPosterior.getText(), jCTextFieldDirectorio.getText() + directoriogeneral);
                    } catch (Exception e) {
                        mensaje.mensajeError("Se debe de modificar el archivo");
                    }
                }
            } else {
                mensaje.mensajeInformacion("No existe el archivo");
            }
        }
    }

    public void eliminarArchivo() {
        try {
            String sql = "CALL deleteArchivo("
                    + "'" + idarchivo + "'"
                    + " );";
            String idtipodoc = consulta.devolverRegistroDato("select td.idtipo_doc from archivo a, tipo_doc td where td.idtipo_doc=a.idtipo_doc and a.idarchivo='" + idarchivo + "'", 1);
            String idreg = consulta.devolverRegistroDato("select r.idregistro from archivo a, registro r where r.idregistro=a.idregistro and a.idarchivo='" + idarchivo + "'", 1);
            String can_reg = consulta.devolverRegistroDato("select count(*) from registro r, archivo a , tipo_doc td\n"
                    + " where r.idregistro=a.idregistro and td.idtipo_doc=a.idtipo_doc and td.idtipo_doc='" + idtipodoc + "' and r.idregistro='" + idreg + "'", 1);
            int con = 0;
            while (con < Integer.parseInt(can_reg)) {
                String dirarcFrontal = consulta.devolverRegistroDato("select a.directorio from registro r, archivo a , tipo_doc td\n"
                        + " where r.idregistro=a.idregistro and td.idtipo_doc=a.idtipo_doc and td.idtipo_doc='" + idtipodoc + "'\n"
                        + " and r.idregistro='" + idreg + "' limit 0,1", 1);
                String dirarcPosterior = consulta.devolverRegistroDato("select a.directorio from registro r, archivo a , tipo_doc td\n"
                        + " where r.idregistro=a.idregistro and td.idtipo_doc=a.idtipo_doc and td.idtipo_doc='" + idtipodoc + "'\n"
                        + " and r.idregistro='" + idreg + "' limit 1,2", 1);
                if (dirarcFrontal.length() != 0 && dirarcPosterior.length() != 0) {
                    controlador.EliminarFichero(jCTextFieldDirectorio.getText() + dirarcFrontal);
                    controlador.EliminarFichero(jCTextFieldDirectorio.getText() + dirarcPosterior);
                } else if (dirarcFrontal.length() != 0) {
                    controlador.EliminarFichero(jCTextFieldDirectorio.getText() + dirarcFrontal);
                }
                con++;
            }
            mensaje.mensajeInformacion(consulta.CrearRegistro(sql));
        } catch (Exception e) {
            mensaje.mensajeError("Eliminar Archivo");
        }
    }

    public boolean validarCamposConstancia() {
        boolean valor = false;
        if (jComboBoxTipoDoc.getSelectedIndex() != 0) {
            if (jComboBoxNLibro.getSelectedIndex() != 0) {
                if (jCTextFieldRutaFrontal.getText().length() != 0) {
                    if (jCTextFieldRutaPosterior.getText().length() != 0) {
                        if (jCTextFieldDirectorio.getText().length() != 0) {
                            valor = true;
                        } else {
                            mensaje.mensajeError("Debe ingresar la ruta del directorio.");
                            jCTextFieldDirectorio.requestFocus();
                        }
                    } else {
                        mensaje.mensajeError("Debe seleccionar el archivo posterior.");
                        jCButtonArchivoPosterior.requestFocus();
                    }
                } else {
                    mensaje.mensajeError("Debe seleccionar el archivo frontal.");
                    jCButtonArchivoFrontal.requestFocus();
                }
            } else {
                mensaje.mensajeError("Debe seleccionar el N° del libro.");
                jComboBoxNLibro.requestFocus();
            }
        } else {
            mensaje.mensajeError("Debe seleccionar el tipo de documento.");
            jComboBoxTipoDoc.requestFocus();
        }
        return valor;
    }

    public boolean validarCamposExpediente() {
        boolean valor = false;
        if (jComboBoxTipoDoc.getSelectedIndex() != 0) {
            if (jComboBoxNLibro.getSelectedIndex() != 0) {
                if (jCTextFieldRutaFrontal.getText().length() != 0) {
                    if (jCTextFieldDirectorio.getText().length() != 0) {
                        valor = true;
                    } else {
                        mensaje.mensajeError("Debe ingresar la ruta del directorio.");
                        jCTextFieldDirectorio.requestFocus();
                    }
                } else {
                    mensaje.mensajeError("Debe seleccionar el expediente.");
                    jCButtonArchivoFrontal.requestFocus();
                }
            } else {
                mensaje.mensajeError("Debe seleccionar el N° del libro.");
                jComboBoxNLibro.requestFocus();
            }
        } else {
            mensaje.mensajeError("Debe seleccionar el tipo de documento.");
            jComboBoxTipoDoc.requestFocus();
        }
        return valor;
    }

    public void asignarCampos() {
        jComboBoxTipoDoc.removeAllItems();
        jComboBoxNLibro.removeAllItems();
        consulta.llenarCombo("select * from tipo_doc", jComboBoxTipoDoc, 2);
        consulta.llenarCombo("select * from stand", jComboBoxNLibro, 2);

//        consulta.llenarCombo("select * from tipo_doc", jComboBoxTipoDoc, 2);
        String ultimoscarac3 = "";
        try {
            idarchivo = modelo.getValueAt(jTableArchivo.getSelectedRow(), 0).toString();
            String sql = "CALL modifyArchivo("
                    + "'" + idarchivo + "'"
                    + " );";
            numeroActa = consulta.devolverRegistroDato(sql, 1);

            nombreArchivo = consulta.devolverRegistroDato(sql, 2);
            directorioPrincipal = consulta.devolverRegistroDato("select * from directorio", 2);
            ruta_archivo_abrir = directorioPrincipal + nombreArchivo;

            rutaArchivo_dirr = directorioPrincipal + nombreArchivo;

            jComboBoxNLibro.setSelectedItem(consulta.devolverRegistroDato(sql, 3));
            jComboBoxTipoDoc.setSelectedItem(consulta.devolverRegistroDato(sql, 4));
            //Mostramos el archivo
            String rutaArc = consulta.devolverDato("select * from archivo where idarchivo=", idarchivo, 4);
            if (controlador.buscarPalabra(rutaArc, "Frontal")) {
                jCTextFieldRutaFrontal.setText(rutaArchivo_dirr);
                Image foto = getToolkit().getImage(jCTextFieldRutaFrontal.getText());
                foto = foto.getScaledInstance(167, 216, Image.SCALE_DEFAULT);
                jLabelarchivo.setIcon(new ImageIcon(foto));
                ultimoscarac3 = jCTextFieldRutaFrontal.getText().substring(jCTextFieldRutaFrontal.getText().length() - 3, jCTextFieldRutaFrontal.getText().length());
            } else if (controlador.buscarPalabra(rutaArc, "Posterior")) {
                jCTextFieldRutaPosterior.setText(rutaArchivo_dirr);
                Image foto = getToolkit().getImage(jCTextFieldRutaPosterior.getText());
                foto = foto.getScaledInstance(167, 216, Image.SCALE_DEFAULT);
                jLabelarchivo.setIcon(new ImageIcon(foto));
                ultimoscarac3 = jCTextFieldRutaPosterior.getText().substring(jCTextFieldRutaPosterior.getText().length() - 3, jCTextFieldRutaPosterior.getText().length());
            } else {
                jCTextFieldRutaFrontal.setText(rutaArchivo_dirr);
                ultimoscarac3 = jCTextFieldRutaFrontal.getText().substring(jCTextFieldRutaFrontal.getText().length() - 3, jCTextFieldRutaFrontal.getText().length());
            }
            if (ultimoscarac3.equals("pdf")) {
                Image foto1 = getToolkit().getImage(jCTextFieldDirectorio.getText() + "\\pdf.png");
                foto1 = foto1.getScaledInstance(167, 216, Image.SCALE_DEFAULT);
                jLabelarchivo.setIcon(new ImageIcon(foto1));
            }
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
        jMenuItemImprimir = new javax.swing.JMenuItem();
        jMenuItemVisualizar = new javax.swing.JMenuItem();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCTextFieldDirectorio = new ControlSwing.JCTextField();
        jComboBoxTipoDoc = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxNLibro = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabelarchivo = new javax.swing.JLabel();
        jLabelRutaFrontal = new javax.swing.JLabel();
        jCButtonArchivoFrontal = new ControlSwing.JCButton();
        jLabelArchivoFrontal = new javax.swing.JLabel();
        jCTextFieldRutaFrontal = new ControlSwing.JCTextField();
        jCButtonArchivoPosterior = new ControlSwing.JCButton();
        jLabelArchivoPosterior = new javax.swing.JLabel();
        jLabelRutaPosterior = new javax.swing.JLabel();
        jCTextFieldRutaPosterior = new ControlSwing.JCTextField();
        jPanel3 = new javax.swing.JPanel();
        jCButtonGuardar = new ControlSwing.JCButton();
        jCButtonEditar = new ControlSwing.JCButton();
        jCButtonCancelar = new ControlSwing.JCButton();
        jCButtonSalir = new ControlSwing.JCButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableArchivo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jCTextFieldBuscar = new ControlSwing.JCTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableListaRegistros = new javax.swing.JTable();
        jCTextFieldBuscar1 = new ControlSwing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabelarchivo1 = new javax.swing.JLabel();

        jMenuItemModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenuItemModificar.setText("Modificar");
        jMenuItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemModificar);

        jMenuItemImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/impresora.png"))); // NOI18N
        jMenuItemImprimir.setText("Imprimir");
        jMenuItemImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImprimirActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemImprimir);

        jMenuItemVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ver.png"))); // NOI18N
        jMenuItemVisualizar.setText("Visualizar");
        jMenuItemVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVisualizarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemVisualizar);

        jMenuItemEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        jMenuItemEliminar.setText("Eliminar");
        jMenuItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemEliminar);

        setTitle("MANTENIMIENTO DE ARCHIVOS");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS DEL ARCHIVO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Directorio");

        jCTextFieldDirectorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDirectorio.setPlaceholder("Ingrese la ruta del directorio");
        jCTextFieldDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDirectorioActionPerformed(evt);
            }
        });

        jComboBoxTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        jComboBoxTipoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoDocActionPerformed(evt);
            }
        });
        jComboBoxTipoDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxTipoDocKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tipo doc.");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("N° Libro");

        jComboBoxNLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "ARCHIVO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelarchivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelarchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabelRutaFrontal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelRutaFrontal.setText("Ruta Frontal");

        jCButtonArchivoFrontal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/archivo.png"))); // NOI18N
        jCButtonArchivoFrontal.setText("Seleccionar");
        jCButtonArchivoFrontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonArchivoFrontalActionPerformed(evt);
            }
        });

        jLabelArchivoFrontal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelArchivoFrontal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelArchivoFrontal.setText("Archivo Frontal");

        jCTextFieldRutaFrontal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldRutaFrontal.setPlaceholder("Ingrese la ruta del archivo");
        jCTextFieldRutaFrontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldRutaFrontalActionPerformed(evt);
            }
        });

        jCButtonArchivoPosterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/archivo.png"))); // NOI18N
        jCButtonArchivoPosterior.setText("Seleccionar");
        jCButtonArchivoPosterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonArchivoPosteriorActionPerformed(evt);
            }
        });

        jLabelArchivoPosterior.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelArchivoPosterior.setText("Archivo Posterior");

        jLabelRutaPosterior.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelRutaPosterior.setText("Ruta Posterior");

        jCTextFieldRutaPosterior.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldRutaPosterior.setPlaceholder("Ingrese la ruta del archivo");
        jCTextFieldRutaPosterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldRutaPosteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)))
                            .addComponent(jLabelArchivoFrontal, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCTextFieldDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCButtonArchivoFrontal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxNLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelArchivoPosterior)
                            .addComponent(jLabelRutaPosterior))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCButtonArchivoPosterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCTextFieldRutaPosterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabelRutaFrontal)
                        .addGap(18, 18, 18)
                        .addComponent(jCTextFieldRutaFrontal, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxNLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jCTextFieldDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCButtonArchivoFrontal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelArchivoFrontal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRutaFrontal)
                            .addComponent(jCTextFieldRutaFrontal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCButtonArchivoPosterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelArchivoPosterior))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRutaPosterior)
                            .addComponent(jCTextFieldRutaPosterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "CONTROLES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jCButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar.png"))); // NOI18N
        jCButtonGuardar.setText("Guardar");
        jCButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonGuardarActionPerformed(evt);
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
        jCButtonCancelar.setMargin(new java.awt.Insets(2, 5, 2, 5));
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
                    .addComponent(jCButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "LISTADO DE ARCHIVOS POR REGISTRO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jTableArchivo.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableArchivo.setComponentPopupMenu(jPopupMenu1);
        jTableArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableArchivoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableArchivo);

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
                        .addComponent(jCTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jCTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "LISTADO DE REGISTROS SIN ARCHIVO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 204))); // NOI18N

        jTableListaRegistros.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableListaRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListaRegistrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableListaRegistros);

        jCTextFieldBuscar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldBuscar1.setPlaceholder("Ingrese un dato para buscar");
        jCTextFieldBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldBuscar1ActionPerformed(evt);
            }
        });
        jCTextFieldBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscar1KeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Buscar");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldBuscar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCTextFieldBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "ARCHIVO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelarchivo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelarchivo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCTextFieldDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDirectorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDirectorioActionPerformed

    private void jCTextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldBuscarActionPerformed

    private void jCButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonSalirActionPerformed
        // TODO add your handling code here:
        mensaje.cerrarVentanaSinConfirmarJI(this);
    }//GEN-LAST:event_jCButtonSalirActionPerformed

    private void jCTextFieldRutaFrontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldRutaFrontalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldRutaFrontalActionPerformed

    private void jCButtonArchivoFrontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonArchivoFrontalActionPerformed
        // TODO add your handling code here:
        //Creamos nuestra variable archivo en la cual podremos usar todos los metodos de la clase jFileChooser
        JFileChooser archivo = new JFileChooser();
        //Si deseamos crear filtros para la selecion de archivos
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg", "jpeg", "pdf");
        //Si deseas que se muestre primero los filtros usa la linea q esta abajo de esta.
        //archivo.setFileFilter(filtro);
        // Agregamos el Filtro pero cuidado se mostrara despues de todos los archivos
        archivo.addChoosableFileFilter(filtro);
        // Colocamos titulo a nuestra ventana de Seleccion
        archivo.setDialogTitle("Abrir Archivo");
        //Si deseamos que muestre una carpeta predetermina usa la siguiente linea
//        File ruta = new File(jCTextFieldDirectorio.getText());
        File ruta = new File("");//Si lo dejamos en vacio por defecto nos enruta a la carpeta documentos
        //Le implementamos a nuestro ventana de seleccion
        archivo.setCurrentDirectory(ruta);
        //Abrimos nuestra Ventana de Selccion
        int ventana = archivo.showOpenDialog(null);
        //hacemos comparacion en caso de aprete el boton abrir
        if (ventana == JFileChooser.APPROVE_OPTION) {
            //si acepta en la ventana modal limpiamos la caja
            jCTextFieldRutaFrontal.setText("");
            //Obtenemos la ruta de nuestra imagen seleccionada
            File file = archivo.getSelectedFile();
            //Lo imprimimos en una caja de texto para ver su ruta
            jCTextFieldRutaFrontal.setText(String.valueOf(file));
            //de cierto modo necesitamos tener la imagen para ello debemos conocer la ruta de dicha imagen
            Image foto = getToolkit().getImage(jCTextFieldRutaFrontal.getText());
            //Le damos dimension a nuestro label que tendra la imagen
            foto = foto.getScaledInstance(167, 216, Image.SCALE_DEFAULT);
            //Imprimimos la imagen en el label
            jLabelarchivo.setIcon(new ImageIcon(foto));
            //mensaje.mensajeInformacion(jLabelarchivo.getIcon().toString());
            String ultimoscara3 = jCTextFieldRutaFrontal.getText().substring(jCTextFieldRutaFrontal.getText().length() - 3, jCTextFieldRutaFrontal.getText().length());
            if (ultimoscara3.equals("pdf")) {
                Image foto1 = getToolkit().getImage(jCTextFieldDirectorio.getText() + "\\pdf.png");
                foto1 = foto1.getScaledInstance(167, 216, Image.SCALE_DEFAULT);
                jLabelarchivo.setIcon(new ImageIcon(foto1));
            }
        }
    }//GEN-LAST:event_jCButtonArchivoFrontalActionPerformed

    private void jCButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonGuardarActionPerformed
        // TODO add your handling code here:
        if (jTableListaRegistros.getSelectedRow() >= 0) {
            String tipodoc = consulta.devolverRegistroDato("select * from tipo_doc where idtipo_doc='2'", 2);
            if (jComboBoxTipoDoc.getSelectedItem().toString().equals(tipodoc)) {
                if (validarCamposExpediente()) {
                    cargaArchivo();
                    insertarArchivoExp();
                    cargarTabla();
                    cargarTablaR();
                    limpiarCampos();
                    jCButtonCancelar.setEnabled(false);
                    jCTextFieldBuscar1.requestFocus();
                    estadoCampos(false);
                }
            } else {
                if (validarCamposConstancia()) {
                    cargaArchivo();
                    insertarArcCons();
                    cargarTabla();
                    cargarTablaR();
                    limpiarCampos();
                    jCButtonCancelar.setEnabled(false);
                    jCTextFieldBuscar1.requestFocus();
                    estadoCampos(false);
                }
            }
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para guardar.");
        }
    }//GEN-LAST:event_jCButtonGuardarActionPerformed

    private void jCTextFieldBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldBuscar1ActionPerformed

    private void jCTextFieldBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscar1KeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldBuscar1);
        buscarListRegistroRN();
    }//GEN-LAST:event_jCTextFieldBuscar1KeyReleased

    private void jCTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldBuscar);
        buscarArchivoRN();
    }//GEN-LAST:event_jCTextFieldBuscarKeyReleased

    private void jTableArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableArchivoMouseClicked
        // TODO add your handling code here:
        ruta_archivo_abrir = directorioPrincipal + nombreArchivo;
        if (evt.getClickCount() == 2) {
            String idarchi = modelo.getValueAt(jTableArchivo.getSelectedRow(), 0).toString();
            nombreArchivo = consulta.devolverDato("select directorio from archivo where idarchivo=", idarchi, 1);
            directorioPrincipal = consulta.devolverRegistroDato("select * from directorio", 2);
            String ruta_archivo = directorioPrincipal + nombreArchivo;
            Image foto = getToolkit().getImage(ruta_archivo);
            //Le damos dimension a nuestro label que tendra la imagen
            foto = foto.getScaledInstance(237, 306, Image.SCALE_DEFAULT);
            //Imprimimos la imagen en el label
            jLabelarchivo1.setIcon(new ImageIcon(foto));
            //mensaje.mensajeInformacion(jLabelarchivo.getIcon().toString());
            String ultimoscarac3 = ruta_archivo.substring(ruta_archivo.length() - 3, ruta_archivo.length());
            if (ultimoscarac3.equals("pdf")) {
                Image foto1 = getToolkit().getImage(jCTextFieldDirectorio.getText() + "\\pdf.png");
                foto1 = foto1.getScaledInstance(237, 306, Image.SCALE_DEFAULT);
                jLabelarchivo1.setIcon(new ImageIcon(foto1));
            }
        }
    }//GEN-LAST:event_jTableArchivoMouseClicked

    private void jMenuItemImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImprimirActionPerformed
        // TODO add your handling code here:
        if (jTableArchivo.getSelectedRow() >= 0) {
            String idarchi = modelo.getValueAt(jTableArchivo.getSelectedRow(), 0).toString();
            nombreArchivo = consulta.devolverDato("select directorio from archivo where idarchivo=", idarchi, 1);
            directorioPrincipal = consulta.devolverRegistroDato("select * from directorio", 2);
            String ruta_archivo = directorioPrincipal + nombreArchivo;
            String ruta = ruta_archivo.replace("/", "\\");
            impresora.imprimirArchivo(ruta);
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para imprimir.");
        }
    }//GEN-LAST:event_jMenuItemImprimirActionPerformed

    private void jMenuItemVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVisualizarActionPerformed
        // TODO add your handling code here:
        if (jTableArchivo.getSelectedRow() >= 0) {
            String idarchi = modelo.getValueAt(jTableArchivo.getSelectedRow(), 0).toString();
            nombreArchivo = consulta.devolverDato("select directorio from archivo where idarchivo=", idarchi, 1);
            directorioPrincipal = consulta.devolverRegistroDato("select * from directorio", 2);
            ruta_archivo_abrir = directorioPrincipal + nombreArchivo;
            String ultimoscarac3 = ruta_archivo_abrir.substring(ruta_archivo_abrir.length() - 3, ruta_archivo_abrir.length());
            if (ultimoscarac3.equals("pdf")) {
                JFrm_VisualizarPDF pdf = new JFrm_VisualizarPDF();
                controlador.MostrarJFrame(pdf);
            } else {
                Image foto = getToolkit().getImage(ruta_archivo_abrir);
                foto = foto.getScaledInstance(237, 306, Image.SCALE_DEFAULT);
                jLabelarchivo1.setIcon(new ImageIcon(foto));
            }
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para visualizar.");
        }
    }//GEN-LAST:event_jMenuItemVisualizarActionPerformed

    private void jMenuItemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        estadoCampos(true);
        estadoBotones(true);
        jCButtonGuardar.setEnabled(false);
        int filamodificar = jTableArchivo.getSelectedRow();
        if (filamodificar >= 0) {
            asignarCampos();
            if (jCTextFieldRutaFrontal.getText().length() != 0) {
                jCButtonArchivoFrontal.setEnabled(true);
                jCButtonArchivoPosterior.setEnabled(false);
            } else {
                jCButtonArchivoFrontal.setEnabled(false);
                jCButtonArchivoPosterior.setEnabled(true);
            }
        } else {
            mensaje.mensajeError("Modificar...");
        }
    }//GEN-LAST:event_jMenuItemModificarActionPerformed

    private void jMenuItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarActionPerformed
        // TODO add your handling code here:
        if (jTableArchivo.getSelectedRow() >= 0) {
            String tipodoc = modelo.getValueAt(jTableArchivo.getSelectedRow(), 5).toString();
            if (tipodoc.equals("CONSTANCIA")) {
                if (mensaje.mensajeConsulta("Estás seguro de eliminar la constancia? porque tiene dos archivos.") == JOptionPane.YES_NO_OPTION) {
                    asignarCampos();
                    eliminarArchivo();
                    cargarTabla();
                    cargarTablaR();
                    limpiarCampos();
                    estadoCampos(true);
                    estadoBotones(false);
                    jCButtonGuardar.setEnabled(true);
                } else {
                    mensaje.mensajeInformacion("No se elimino ninguna constancia.");
                }
            } else {
                if (mensaje.mensajeConsulta("Estás seguro de eliminar el expediente?") == JOptionPane.YES_NO_OPTION) {
                    asignarCampos();
                    eliminarArchivo();
                    cargarTabla();
                    cargarTablaR();
                    limpiarCampos();
                    estadoCampos(true);
                    estadoBotones(false);
                    jCButtonGuardar.setEnabled(true);
                } else {
                    mensaje.mensajeInformacion("No se elimino ningún expediente.");
                }
            }
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para eliminar.");
        }
    }//GEN-LAST:event_jMenuItemEliminarActionPerformed

    private void jCButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        estadoBotones(false);
        jCButtonArchivoFrontal.setEnabled(true);
        jCButtonGuardar.setEnabled(true);
        jComboBoxTipoDoc.requestFocus();
    }//GEN-LAST:event_jCButtonCancelarActionPerformed

    private void jCButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonEditarActionPerformed
        // TODO add your handling code here:
        if (jTableArchivo.getSelectedRow() >= 0) {
            if (mensaje.mensajeConsulta("Realmente desea actualizar el registro?") == JOptionPane.YES_NO_OPTION) {
                editarArchivo();
                cargarTabla();
                limpiarCampos();
                estadoCampos(false);
                estadoBotones(false);
                jCButtonGuardar.setEnabled(true);
                jCButtonArchivoFrontal.setEnabled(true);
            } else {
                mensaje.mensajeInformacion("No se actualizo ningún registro.");
            }
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para editar.");
        }
    }//GEN-LAST:event_jCButtonEditarActionPerformed

    private void jCButtonArchivoPosteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonArchivoPosteriorActionPerformed
        // TODO add your handling code here:
        //Creamos nuestra variable archivo en la cual podremos usar todos los metodos de la clase jFileChooser
        JFileChooser archivo = new JFileChooser();
        //Si deseamos crear filtros para la selecion de archivos
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg", "jpeg", "pdf");
        //Si deseas que se muestre primero los filtros usa la linea q esta abajo de esta.
        //archivo.setFileFilter(filtro);
        // Agregamos el Filtro pero cuidado se mostrara despues de todos los archivos
        archivo.addChoosableFileFilter(filtro);
        // Colocamos titulo a nuestra ventana de Seleccion
        archivo.setDialogTitle("Abrir Archivo");
        //Si deseamos que muestre una carpeta predetermina usa la siguiente linea
        File ruta = new File("");
        //Le implementamos a nuestro ventana de seleccion
        archivo.setCurrentDirectory(ruta);
        //Abrimos nuestra Ventana de Selccion
        int ventana = archivo.showOpenDialog(null);
        //hacemos comparacion en caso de aprete el boton abrir
        if (ventana == JFileChooser.APPROVE_OPTION) {
            //si acepta en la ventana modal limpiamos la caja
            jCTextFieldRutaPosterior.setText("");
            //Obtenemos la ruta de nuestra imagen seleccionada
            File file = archivo.getSelectedFile();
            //Lo imprimimos en una caja de texto para ver su ruta
            jCTextFieldRutaPosterior.setText(String.valueOf(file));
            //de cierto modo necesitamos tener la imagen para ello debemos conocer la ruta de dicha imagen
            Image foto = getToolkit().getImage(jCTextFieldRutaPosterior.getText());
            //Le damos dimension a nuestro label que tendra la imagen
            foto = foto.getScaledInstance(167, 216, Image.SCALE_DEFAULT);
            //Imprimimos la imagen en el label
            jLabelarchivo.setIcon(new ImageIcon(foto));
            //mensaje.mensajeInformacion(jLabelarchivo.getIcon().toString());
            String ultimoscarac3 = jCTextFieldRutaPosterior.getText().substring(jCTextFieldRutaPosterior.getText().length() - 3, jCTextFieldRutaPosterior.getText().length());
            if (ultimoscarac3.equals("pdf")) {
                Image foto1 = getToolkit().getImage(jCTextFieldDirectorio.getText() + "\\pdf.png");
                foto1 = foto1.getScaledInstance(167, 216, Image.SCALE_DEFAULT);
                jLabelarchivo.setIcon(new ImageIcon(foto1));
            }
        }
    }//GEN-LAST:event_jCButtonArchivoPosteriorActionPerformed

    private void jCTextFieldRutaPosteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldRutaPosteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldRutaPosteriorActionPerformed

    private void jComboBoxTipoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoDocActionPerformed
        // TODO add your handling code here:
        if (jComboBoxTipoDoc.getSelectedIndex() >= 0) {
            String tipodoc = consulta.devolverRegistroDato("select * from tipo_doc where idtipo_doc='2'", 2);
            if (jComboBoxTipoDoc.getSelectedItem().toString().equals(tipodoc)) {
                jLabelArchivoFrontal.setText("Archivo Exp.");
                jLabelRutaFrontal.setText("Ruta de Exp.");
                jCButtonArchivoFrontal.setEnabled(true);
                jCButtonArchivoPosterior.setEnabled(false);

//                jLabelArchivoPosterior.setVisible(false);
//                jCButtonArchivoPosterior.setVisible(false);
//                jLabelRutaPosterior.setVisible(false);
//                jCTextFieldRutaPosterior.setVisible(false);
            } else {
                jCButtonArchivoFrontal.setEnabled(true);
                jCButtonArchivoPosterior.setEnabled(true);
                jLabelArchivoFrontal.setText("Archivo Frontal");
                jLabelRutaFrontal.setText("Ruta Frontal");
//
//                jLabelArchivoPosterior.setVisible(true);
//                jCButtonArchivoPosterior.setVisible(true);
//                jLabelRutaPosterior.setVisible(true);
//                jCTextFieldRutaPosterior.setVisible(true);
            }
        }
    }//GEN-LAST:event_jComboBoxTipoDocActionPerformed

    private void jComboBoxTipoDocKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxTipoDocKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoDocKeyPressed

    private void jTableListaRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaRegistrosMouseClicked
        // TODO add your handling code here:
        if (jTableListaRegistros.getSelectedRow() >= 0) {
            jComboBoxTipoDoc.removeAllItems();
            jComboBoxNLibro.removeAllItems();
            jComboBoxTipoDoc.addItem("-- Seleccionar --");
            jComboBoxNLibro.addItem("-- Seleccionar --");
            numacta = modeloR.getValueAt(jTableListaRegistros.getSelectedRow(), 0).toString();
            String tipoReg = modeloR.getValueAt(jTableListaRegistros.getSelectedRow(), 2).toString();
            cargarCombo(numacta, tipoReg);
            estadoCampos(true);
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para cargar.");
        }
    }//GEN-LAST:event_jTableListaRegistrosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ControlSwing.JCButton jCButtonArchivoFrontal;
    private ControlSwing.JCButton jCButtonArchivoPosterior;
    private ControlSwing.JCButton jCButtonCancelar;
    private ControlSwing.JCButton jCButtonEditar;
    private ControlSwing.JCButton jCButtonGuardar;
    private ControlSwing.JCButton jCButtonSalir;
    private ControlSwing.JCTextField jCTextFieldBuscar;
    private ControlSwing.JCTextField jCTextFieldBuscar1;
    private ControlSwing.JCTextField jCTextFieldDirectorio;
    private ControlSwing.JCTextField jCTextFieldRutaFrontal;
    private ControlSwing.JCTextField jCTextFieldRutaPosterior;
    private javax.swing.JComboBox<String> jComboBoxNLibro;
    private javax.swing.JComboBox<String> jComboBoxTipoDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelArchivoFrontal;
    private javax.swing.JLabel jLabelArchivoPosterior;
    private javax.swing.JLabel jLabelRutaFrontal;
    private javax.swing.JLabel jLabelRutaPosterior;
    private javax.swing.JLabel jLabelarchivo;
    private javax.swing.JLabel jLabelarchivo1;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JMenuItem jMenuItemImprimir;
    private javax.swing.JMenuItem jMenuItemModificar;
    private javax.swing.JMenuItem jMenuItemVisualizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableArchivo;
    private javax.swing.JTable jTableListaRegistros;
    // End of variables declaration//GEN-END:variables
}
