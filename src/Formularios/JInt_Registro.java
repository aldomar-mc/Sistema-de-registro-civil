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
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import java.sql.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.bolivia.time.TimeChooser;

/**
 *
 * @author Aldo Omar
 */
public class JInt_Registro extends javax.swing.JInternalFrame {

    Aldo_Controlador controlador = new Aldo_Controlador();
    Aldo_Tabla tabla = new Aldo_Tabla();
    Aldo_Mensajes mensaje = new Aldo_Mensajes();
    Aldo_Consultas consulta = new Aldo_Consultas();
    Aldo_EventosKey evento = new Aldo_EventosKey();
    Aldo_Fechas fecha = new Aldo_Fechas();
    Aldo_General general = new Aldo_General();
    //********************************************************************************
    //REGISTRO DE NACIMIENTO
    private DefaultTableModel modeloRN;
    private DefaultTableModel modeloRNA;
    private String idregistroRN = "";
    private String iddepartamentoRN = "";
    private String idprovinciaRN = "";
    private String iddistritoRN = "";
    private String idtiporegistroRN = "";
    private String idusuarioRN = "";
    private String idapoderadoRN = "";
    //********************************************************************************
    //REGISTRO DE MATRIMONIO
    private DefaultTableModel modeloRM;
    private String idregistroRM = "";
    private String iddepartamentoRM = "";
    private String idprovinciaRM = "";
    private String iddistritoRM = "";
    private String idtiporegistroRM = "";
    private String idusuarioRM = "";
    private String horaNacMH = "";
    private String horaNacMM = "";
    public static String idregistroFecRM = "";
    //********************************************************************************
    //REGISTRO DE DEFUNCIÓN
    private DefaultTableModel modeloRD;
    private DefaultTableModel modeloRDA;
    private String idregistroRD = "";
    private String iddepartamentoRD = "";
    private String idprovinciaRD = "";
    private String iddistritoRD = "";
    private String idtiporegistroRD = "";
    private String idusuarioRD = "";
    private String idapoderadoRD = "";
    private String horaNacD = "";
    public static String idregistroFecRD = "";

    /**
     * Creates new form JInt_Registro
     */
    public JInt_Registro() {
        initComponents();
        general.setIconoJInternal(this, "/Imagenes/logo.png");
        //********************************************************************************
        //REGISTRO DE NACIMIENTO
        limpiarCamposRN();
        estadoCamposRN(true);
        estadoBotonesRN(false);
        llenarComboRN();
        tituloTablaRN();
        cargarTablaRN();
        tituloTablaRNA();
        jComboBoxTipoRegistroRN.setEnabled(false);
        jCButtonCancelarRN.setEnabled(true);
        jCTextFieldNombresRN.requestFocus();
        tabla.tablaNoEditable(jTableApoderadoRN);
        tabla.tablaNoEditable(jTableRegistroRN);

        //*********************************************************************************
        //REGISTRO DE MATRIMONIO
        limpiarCamposRM();
        estadoCamposRM(true);
        estadoBotonesRM(false);
        llenarComboRM();
        tituloTablaRM();
        cargarTablaRM();
        jComboBoxTipoRegRM.setEnabled(false);
        jComboBoxGeneroHRM.setEnabled(false);
        jComboBoxGeneroMRM.setEnabled(false);
        jCButtonCancelarRM.setEnabled(true);
//        jCTextFieldNombreHRM.requestFocus();
        tabla.tablaNoEditable(jTableRegistroRM);

        //********************************************************************************
        //REGISTRO DE DEFUNCIÓN
        limpiarCamposRD();
        estadoCamposRD(true);
        estadoBotonesRD(false);
        llenarComboRD();
        tituloTablaRD();
        cargarTablaRD();
        tituloTablaRDA();
        jComboBoxTipoRegistroRD.setEnabled(false);
        jCButtonCancelarRD.setEnabled(true);
        jCTextFieldNombresRD.requestFocus();
        tabla.tablaNoEditable(jTableApoderadoRD);
        tabla.tablaNoEditable(jTableRegistroRD);
    }

    //****************************************************************************************
    //REGISTRO DE NACIMIENTO
    public void limpiarCamposRN() {
        controlador.limpiarJTexField(jCTextFieldNombresRN);
        controlador.limpiarJTexField(jCTextFieldNombreApoRN);
        controlador.limpiarJTexField(jCTextFieldApellidosRN);
        controlador.limpiarJTexField(jCTextFieldApellidoApoRN);
        controlador.limpiarJTexField(jCTextFieldDNIRN);
        controlador.limpiarJTexField(jCTextFieldDNIApoRN);
        controlador.limpiarJTexField(jCTextFieldDireccionRN);
        controlador.limpiarJTexField(jCTextFieldDireccionApoRN);
        controlador.limpiarJTexField(jCTextFieldNactaRN);
        controlador.limpiarComboBox(jComboBoxGeneroRN);
        controlador.limpiarComboBox(jComboBoxGeneroApoRN);
        controlador.limpiarComboBox(jComboBoxApoderadoRN);
        controlador.limpiarDataChooser(jDateChooserFechaNacimientoRN);
        controlador.limpiarDataChooser(jDateChooserFechaNacApoRN);
        controlador.limpiarTimeChooser(timeChooserHoraNacimientoRN);
    }

    public void estadoCamposRN(boolean estado) {
        jCTextFieldApellidosRN.setEnabled(estado);
        jCTextFieldApellidoApoRN.setEnabled(estado);
        jCTextFieldDNIRN.setEnabled(estado);
        jCTextFieldDNIApoRN.setEnabled(estado);
        jCTextFieldDireccionRN.setEnabled(estado);
        jCTextFieldDireccionApoRN.setEnabled(estado);
        jCTextFieldNombresRN.setEnabled(estado);
        jCTextFieldNombreApoRN.setEnabled(estado);
        jCTextFieldNactaRN.setEnabled(estado);
        jComboBoxGeneroRN.setEnabled(estado);
        jComboBoxApoderadoRN.setEnabled(estado);
        jComboBoxDepartamentoRN.setEnabled(estado);
        jComboBoxProvinciaRN.setEnabled(estado);
        jComboBoxDistritoRN.setEnabled(estado);
        jComboBoxGeneroApoRN.setEnabled(estado);
        jDateChooserFechaNacimientoRN.setEnabled(estado);
        jDateChooserFechaNacApoRN.setEnabled(estado);
        timeChooserHoraNacimientoRN.setEnabled(estado);
    }

    public void estadoBotonesRN(boolean estado) {
        jCButtonCancelarRN.setEnabled(estado);
        jCButtonEditarRN.setEnabled(estado);
    }

    public void llenarComboRN() {
        consulta.llenarCombo("select * from tipo_reg where idtipo_reg=1", jComboBoxTipoRegistroRN, 2);
        consulta.llenarCombo("select * from departamento", jComboBoxDepartamentoRN, 2);
        consulta.llenarCombo("select a.nom_apo, tr.nomtpo\n"
                + "from apoderado a, tipo_reg tr, aporegistro ar\n"
                + "where a.idapoderado=ar.idapoderado and tr.idtipo_reg=ar.idtipo_reg and tr.nomtpo='" + jComboBoxTipoRegistroRN.getSelectedItem().toString() + "'", jComboBoxApoderadoRN, 1);
    }

    private void llenarProvinciaRN() {
        if (jComboBoxDepartamentoRN.getSelectedIndex() >= 0) {
            iddepartamentoRN = consulta.devolverDato("select iddepartamento from departamento where nomdep=", jComboBoxDepartamentoRN.getSelectedItem().toString(), 1);
            jComboBoxProvinciaRN.removeAllItems();
            consulta.llenarCombo("SELECT * FROM provincia WHERE iddepartamento='" + iddepartamentoRN + "'", jComboBoxProvinciaRN, 2);
        }
    }

    private void llenarDistritoRN() {
        if (jComboBoxProvinciaRN.getSelectedIndex() >= 0) {
            idprovinciaRN = consulta.devolverDato("select idprovincia from provincia where nomprov=", jComboBoxProvinciaRN.getSelectedItem().toString(), 1);
            jComboBoxDistritoRN.removeAllItems();
            consulta.llenarCombo("SELECT * FROM distrito where idprovincia='" + idprovinciaRN + "'", jComboBoxDistritoRN, 2);
        }
    }

    public void tituloTablaRN() {
        String[] titulo = {"ID", "DNI", "APELLIDOS Y NOMBRES", "FEC. NAC", "N° ACTA", "DISTRITO", "PROVINCIA", "DEPARTAMENTO", "FECHA REGISTRO", "HORA REGISTRO"};
        modeloRN = new DefaultTableModel(null, titulo);
        modeloRN.setColumnIdentifiers(titulo);
        jTableRegistroRN.setModel(modeloRN);
    }

    public void columnasTablaRN() {
        tabla.setMaxWidthColumnTable(jTableRegistroRN, 80, 1);
        tabla.setMaxWidthColumnTable(jTableRegistroRN, 250, 2);
        tabla.ocultarColumnasTabla(jTableRegistroRN, 0);
    }

    public void cargarTablaRN() {
        tabla.MostrarEnTabla("CALL listRegistroRN()", jTableRegistroRN, modeloRN, 10);
        columnasTablaRN();
    }

    public void buscarRN() {
        controlador.BuscarDato("CALL searchRegistroRN(?)", modeloRN, 10, jCTextFieldBuscarRN);
    }

    public void insertarRegistroRN() {
        idtiporegistroRN = consulta.devolverDato("select * from tipo_reg where nomtpo=", jComboBoxTipoRegistroRN.getSelectedItem().toString(), 1);
        iddistritoRN = consulta.devolverDato("select * from distrito where nomdist=", jComboBoxDistritoRN.getSelectedItem().toString(), 1);
        idusuarioRN = consulta.devolverDato("select * from usuario where nom=", JFrm_Acceso.jCTextFieldUsuario.getText(), 1);
        try {
            String sql = "CALL insertRegistroRN("
                    + "'" + jCTextFieldDNIRN.getText() + "',"
                    + "'" + jCTextFieldNombresRN.getText() + "',"
                    + "'" + jCTextFieldApellidosRN.getText() + "',"
                    + "'" + jComboBoxGeneroRN.getSelectedItem().toString() + "',"
                    + "'" + jCTextFieldDireccionRN.getText() + "',"
                    + "'" + fecha.Formato_AMD(jDateChooserFechaNacimientoRN.getDate()) + "',"
                    + "'" + fecha.HoraMysql(timeChooserHoraNacimientoRN.getText()) + "',"
                    + "'" + idusuarioRN + "',"
                    + "'" + idtiporegistroRN + "',"
                    + "'" + jCTextFieldNactaRN.getText() + "',"
                    + "'" + iddistritoRN + "'"
                    + " );";
            mensaje.mensajeInformacion(consulta.CrearRegistro(sql));
        } catch (Exception e) {
            mensaje.mensajeError("Insertar registro de nacimiento");
        }
    }

    public void editarRegistroRN() {
        iddistritoRN = consulta.devolverDato("select * from distrito where nomdist=", jComboBoxDistritoRN.getSelectedItem().toString(), 1);
        idusuarioRN = consulta.devolverDato("select * from usuario where nom=", JFrm_Acceso.jCTextFieldUsuario.getText(), 1);
        try {
            String sql = "CALL editRegistroRN("
                    + "'" + jCTextFieldDNIRN.getText() + "',"
                    + "'" + jCTextFieldNombresRN.getText() + "',"
                    + "'" + jCTextFieldApellidosRN.getText() + "',"
                    + "'" + jComboBoxGeneroRN.getSelectedItem().toString() + "',"
                    + "'" + jCTextFieldDireccionRN.getText() + "',"
                    + "'" + fecha.Formato_AMD(jDateChooserFechaNacimientoRN.getDate()) + "',"
                    + "'" + fecha.HoraMysql(timeChooserHoraNacimientoRN.getText()) + "',"
                    + "'" + idusuarioRN + "',"
                    + "'" + jCTextFieldNactaRN.getText() + "',"
                    + "'" + iddistritoRN + "',"
                    + "'" + idregistroRN + "'"
                    + " );";
            mensaje.mensajeInformacion(consulta.CrearRegistro(sql));
        } catch (Exception e) {
            mensaje.mensajeError("Editar registro de nacimiento");
        }
    }

    public void verificarDNI(KeyEvent evt, JTextField campodni, JComboBox campoEnter, JTextField apePer, JTextField nomPer,
            JTextField dirPer, JComboBox genePer, JDateChooser fecnacPer, TimeChooser horPer, JTextField numactPer) {
        if (controlador.oneAttribRepeat("persona", "dni", campodni.getText())) {
            String cad = consulta.devolverDato("select count(*) from persona where dni=", campodni.getText(), 1);
            if (Integer.parseInt(cad) != 0) {
                //Si existe una persona ya registrada devolvemos sus datos
                String sq = "select * from persona where dni=";
                String dniper = consulta.devolverDato(sq, campodni.getText(), 2);
                String nombreper = consulta.devolverDato(sq, campodni.getText(), 3);
                String apellidoper = consulta.devolverDato(sq, campodni.getText(), 4);
                String generoper = consulta.devolverDato(sq, campodni.getText(), 5);
                String direccionper = consulta.devolverDato(sq, campodni.getText(), 6);
                String fecnacper = consulta.devolverDato(sq, campodni.getText(), 7);
                String hornacper = consulta.devolverDato("select TIME_FORMAT(hor_nac,'%r') from persona where dni=", campodni.getText(), 1);
                apePer.setText(apellidoper);
                campodni.setText(dniper);
                dirPer.setText(direccionper);
                nomPer.setText(nombreper);
                genePer.setSelectedItem(generoper);
                fecnacPer.setDate(Date.valueOf(fecnacper));
                horPer.setText(hornacper);
                numactPer.requestFocus();
            }
        } else {
            evento.EnterJTexfield_A_JComboBox(evt, campodni, campoEnter);
        }
    }

    public boolean verificarReg(JTextField camDNI, JComboBox tiporeg) {
        boolean res = false;
        String canreg = consulta.devolverRegistroDato("select count(*) from persona p, detregistro dr, registro r, tipo_reg tr\n"
                + "where p.idpersona=dr.iddetRegistro and tr.idtipo_reg=r.idtipo_reg and r.idregistro=dr.idregistro and\n"
                + "p.dni='" + camDNI.getText() + "' and tr.nomtpo='" + tiporeg.getSelectedItem().toString() + "'", 1);
        if (Integer.parseInt(canreg) == 0) {
            res = true;
        } else {
            mensaje.mensajeError("Ya existe un registro con el dni ingresado.");
            camDNI.requestFocus();
        }
        return res;
    }

    public void verificarNumActa(KeyEvent evt, JTextField campoNumac, JComboBox campoEnter) {
        if (controlador.oneAttribRepeat("registro", "num_acta", campoNumac.getText())) {
            mensaje.mensajeError("El número de acta ingresado ya existe.");
            controlador.selectAllText(campoNumac);
            campoNumac.requestFocus();
        } else {
            evento.EnterJTexfield_A_JComboBox(evt, campoNumac, campoEnter);
        }
    }

    public void tituloTablaRNA() {
        modeloRNA = new DefaultTableModel();
        jTableApoderadoRN.setModel(modeloRNA);
        modeloRNA.addColumn("DNI");
        modeloRNA.addColumn("NOMBRE");
        modeloRNA.addColumn("APELLIDO");
        modeloRNA.addColumn("GENERO");
        modeloRNA.addColumn("DIRECCIÓN");
        modeloRNA.addColumn("FEC. NAC");
        modeloRNA.addColumn("DECLARANTE");
    }

    public void limpiarCamposRNA() {
        controlador.limpiarJTexField(jCTextFieldNombreApoRN);
        controlador.limpiarJTexField(jCTextFieldApellidoApoRN);
        controlador.limpiarJTexField(jCTextFieldDNIApoRN);
        controlador.limpiarJTexField(jCTextFieldDireccionApoRN);
        controlador.limpiarComboBox(jComboBoxGeneroApoRN);
        controlador.limpiarComboBox(jComboBoxApoderadoRN);
        controlador.limpiarDataChooser(jDateChooserFechaNacApoRN);
    }

    public void insertarApoderadoRN() {
        try {
            String dni, nombre, apellido, genero, direccion, fec_nac, apoderado;
            int contador = 0;
            while (contador < jTableApoderadoRN.getRowCount()) {
                dni = jTableApoderadoRN.getValueAt(contador, 0).toString();
                nombre = jTableApoderadoRN.getValueAt(contador, 1).toString();
                apellido = jTableApoderadoRN.getValueAt(contador, 2).toString();
                genero = jTableApoderadoRN.getValueAt(contador, 3).toString();
                direccion = jTableApoderadoRN.getValueAt(contador, 4).toString();
                fec_nac = jTableApoderadoRN.getValueAt(contador, 5).toString();
                apoderado = jTableApoderadoRN.getValueAt(contador, 6).toString();
                idapoderadoRN = consulta.devolverDato("select * from apoderado where nom_apo=", apoderado, 1);
                if (fec_nac.length() == 0) {
                    fec_nac = "1900-01-01";
                }
                String sql = "CALL insertApoderadoRN("
                        + "'" + dni + "',"
                        + "'" + nombre + "',"
                        + "'" + apellido + "',"
                        + "'" + genero + "',"
                        + "'" + direccion + "',"
                        + "'" + fec_nac + "',"
                        + "'" + idapoderadoRN + "'"
                        + " );";
                //mensaje.mensajeInformacion(consulta.CrearRegistro(sql));
                consulta.CrearRegistro(sql);
                contador++;
            }
        } catch (Exception e) {
            mensaje.mensajeError("Insertar declarante de registro de nacimiento");
        }
    }

    public boolean verificarDNI_RNA1(String dat) {
        boolean exi = false;
        if (controlador.oneAttribRepeat("persona", "dni", dat)) {
            exi = true;
        }
        return exi;
    }

    public void editarApoderadoRN() {
        try {
            String dni1, nombre1, apellido1, genero1, direccion1, fec_nac1, apoderado1;
            int contador1 = 0;
            while (contador1 < jTableApoderadoRN.getRowCount()) {
                dni1 = jTableApoderadoRN.getValueAt(contador1, 0).toString();
                nombre1 = jTableApoderadoRN.getValueAt(contador1, 1).toString();
                apellido1 = jTableApoderadoRN.getValueAt(contador1, 2).toString();
                genero1 = jTableApoderadoRN.getValueAt(contador1, 3).toString();
                direccion1 = jTableApoderadoRN.getValueAt(contador1, 4).toString();
                fec_nac1 = jTableApoderadoRN.getValueAt(contador1, 5).toString();
                apoderado1 = jTableApoderadoRN.getValueAt(contador1, 6).toString();
                String idapodRN = consulta.devolverDato("select * from apoderado where nom_apo=", apoderado1, 1);
                if (fec_nac1.length() == 0) {
                    fec_nac1 = "1900-01-01";
                }
                String query1 = "CALL countApoderadoRN("
                        + "'" + idregistroRN + "'"
                        + " );";
                String totalRegs = consulta.devolverRegistroDato(query1, 1);
                int cont1 = 0;
                while (cont1 < Integer.parseInt(totalRegs)) {
                    String query2 = "CALL modifyApoderadoRN("
                            + "'" + idregistroRN + "',"
                            + "'" + cont1 + "'"
                            + " );";
                    String dnibd = consulta.devolverRegistroDato(query2, 1);
                    String query3 = "CALL editApoderadoRN("
                            + "'" + dni1 + "',"
                            + "'" + nombre1 + "',"
                            + "'" + apellido1 + "',"
                            + "'" + genero1 + "',"
                            + "'" + direccion1 + "',"
                            + "'" + fec_nac1 + "',"
                            + "'" + dnibd + "',"
                            + "'" + idapodRN + "',"
                            + "'" + idregistroRN + "'"
                            + " );";
                    //mensaje.mensajeInformacion(consulta.CrearRegistro(query3));
                    consulta.Consulta(query3);
                    cont1++;
                }
                contador1++;
            }
        } catch (Exception e) {
            mensaje.mensajeError("Insertar declarante de registro de nacimiento");
        }

    }

    public boolean validarCamposRN() {
        boolean valor = false;
        if (jCTextFieldNombresRN.getText().length() != 0) {
            if (jCTextFieldApellidosRN.getText().length() != 0) {
                if (jComboBoxGeneroRN.getSelectedIndex() != 0) {
                    if (jCTextFieldDireccionRN.getText().length() != 0) {
                        if (jDateChooserFechaNacimientoRN.getDate() != null) {
                            if (timeChooserHoraNacimientoRN.getText().length() != 0) {
                                if (jComboBoxTipoRegistroRN.getSelectedIndex() != -1) {
                                    if (jCTextFieldNactaRN.getText().length() != 0) {
                                        if (jComboBoxDepartamentoRN.getSelectedIndex() != 0) {
                                            if (jComboBoxProvinciaRN.getSelectedIndex() > -1) {
                                                if (jComboBoxDistritoRN.getSelectedIndex() > -1) {
                                                    if (jTableApoderadoRN.getRowCount() != 0) {
                                                        valor = true;
                                                    } else {
                                                        mensaje.mensajeError("Debes ingresar los declarantes.");
                                                        jCTextFieldNombreApoRN.requestFocus();
                                                    }
                                                } else {
                                                    mensaje.mensajeError("Debe seleccionar un distrito.");
                                                    jComboBoxDistritoRN.requestFocus();
                                                }
                                            } else {
                                                mensaje.mensajeError("Debe seleccionar una provincia.");
                                                jComboBoxProvinciaRN.requestFocus();
                                            }
                                        } else {
                                            mensaje.mensajeError("Debe seleccionar un departamento.");
                                            jComboBoxDepartamentoRN.requestFocus();
                                        }
                                    } else {
                                        mensaje.mensajeError("Debe ingresar el número del acta.");
                                        jCTextFieldNactaRN.requestFocus();
                                    }
                                } else {
                                    mensaje.mensajeError("Debe seleccionar el tipo de registro.");
                                    jComboBoxTipoRegistroRN.requestFocus();
                                }
                            } else {
                                mensaje.mensajeError("Debe ingresar su hora de nacimiento.");
                                timeChooserHoraNacimientoRN.requestFocus();
                            }
                        } else {
                            mensaje.mensajeError("Debe ingresar su fecha de nacimiento.");
                            jDateChooserFechaNacimientoRN.requestFocusInWindow();
                        }
                    } else {
                        mensaje.mensajeError("Debe ingresar su dirección.");
                        jCTextFieldDireccionRN.requestFocus();
                    }
                } else {
                    mensaje.mensajeError("Debe seleccionar su género.");
                    jComboBoxGeneroRN.requestFocus();
                }
            } else {
                mensaje.mensajeError("Debe ingresar su apellido.");
                jCTextFieldApellidosRN.requestFocus();
            }
        } else {
            mensaje.mensajeError("Debe ingresar su nombre.");
            jCTextFieldNombresRN.requestFocus();
        }
        return valor;
    }

    public boolean validarCamposRNA() {
        boolean valor = false;
        if (jCTextFieldNombreApoRN.getText().length() != 0) {
            if (jCTextFieldApellidoApoRN.getText().length() != 0) {
                if (jCTextFieldDNIApoRN.getText().length() != 0) {
                    if (jComboBoxGeneroApoRN.getSelectedIndex() != 0) {
                        if (jCTextFieldDireccionApoRN.getText().length() != 0) {
                            if (jComboBoxApoderadoRN.getSelectedIndex() != 0) {
                                valor = true;
                            } else {
                                mensaje.mensajeError("Debe seleccionar el declarante.");
                                jComboBoxApoderadoRN.requestFocus();
                            }
                        } else {
                            mensaje.mensajeError("Debe ingresar su dirección del declarante.");
                            jCTextFieldDireccionApoRN.requestFocus();
                        }
                    } else {
                        mensaje.mensajeError("Debe seleccionar su género del declarante.");
                        jComboBoxGeneroApoRN.requestFocus();
                    }
                } else {
                    mensaje.mensajeError("Debe ingresar su DNI del declarante.");
                    jCTextFieldDNIApoRN.requestFocus();
                }
            } else {
                mensaje.mensajeError("Debe ingresar su apellido del declarante.");
                jCTextFieldApellidoApoRN.requestFocus();
            }
        } else {
            mensaje.mensajeError("Debe ingresar su nombre del declarante.");
            jCTextFieldNombreApoRN.requestFocus();
        }
        return valor;
    }

    public void asignarCamposRN() {
        try {
            idregistroRN = modeloRN.getValueAt(jTableRegistroRN.getSelectedRow(), 0).toString();
            String sql = "CALL modifyRegistroRN("
                    + "'" + idregistroRN + "'"
                    + " );";
            jCTextFieldNombresRN.setText(consulta.devolverRegistroDato(sql, 1));
            jCTextFieldApellidosRN.setText(consulta.devolverRegistroDato(sql, 2));
            jCTextFieldDNIRN.setText(consulta.devolverRegistroDato(sql, 3));
            jComboBoxGeneroRN.setSelectedItem(consulta.devolverRegistroDato(sql, 4));
            jDateChooserFechaNacimientoRN.setDate(Date.valueOf(consulta.devolverRegistroDato(sql, 5)));
            timeChooserHoraNacimientoRN.setText(consulta.devolverRegistroDato(sql, 6));
            jCTextFieldDireccionRN.setText(consulta.devolverRegistroDato(sql, 7));
            jComboBoxTipoRegistroRN.setSelectedItem(consulta.devolverRegistroDato(sql, 8));
            jCTextFieldNactaRN.setText(consulta.devolverRegistroDato(sql, 9));
            jComboBoxDepartamentoRN.setSelectedItem(consulta.devolverRegistroDato(sql, 10));
            jComboBoxProvinciaRN.setSelectedItem(consulta.devolverRegistroDato(sql, 11));
            jComboBoxDistritoRN.setSelectedItem(consulta.devolverRegistroDato(sql, 12));
            //Devolvemos todos los apoderados que tiene un determinado registro
            String sql1 = "CALL countApoderadoRN("
                    + "'" + idregistroRN + "'"
                    + " );";

            String totalReg = consulta.devolverRegistroDato(sql1, 1);
            int cont = 0;
            while (cont < Integer.parseInt(totalReg)) {
                String sql2 = "CALL modifyApoderadoRN("
                        + "'" + idregistroRN + "',"
                        + "'" + cont + "'"
                        + " );";
                Object[] object = new Object[7];
                object[0] = consulta.devolverRegistroDato(sql2, 1);
                object[1] = consulta.devolverRegistroDato(sql2, 2);
                object[2] = consulta.devolverRegistroDato(sql2, 3);
                object[3] = consulta.devolverRegistroDato(sql2, 4);
                object[4] = consulta.devolverRegistroDato(sql2, 5);
                object[5] = consulta.devolverRegistroDato(sql2, 6);
                object[6] = consulta.devolverRegistroDato(sql2, 7);
                modeloRNA.addRow(object);
                cont++;
            }
        } catch (Exception e) {
            mensaje.mensajeError("Asignar campos");
        }
    }

    public void asignarCamposApoderadoRN() {
        try {
            controlador.asignarJTexField(jCTextFieldDNIApoRN, modeloRNA, jTableApoderadoRN, 0);
            controlador.asignarJTexField(jCTextFieldNombreApoRN, modeloRNA, jTableApoderadoRN, 1);
            controlador.asignarJTexField(jCTextFieldApellidoApoRN, modeloRNA, jTableApoderadoRN, 2);
            controlador.asignarComboBox(jComboBoxGeneroApoRN, modeloRNA, jTableApoderadoRN, 3);
            controlador.asignarJTexField(jCTextFieldDireccionApoRN, modeloRNA, jTableApoderadoRN, 4);
            String fec = modeloRNA.getValueAt(jTableApoderadoRN.getSelectedRow(), 5).toString();
            if (fec.length() != 0) {
                String fec1 = fecha.fechaMysqlNormal(fec);
                controlador.AsignarFechaenDateChooser(jDateChooserFechaNacApoRN, fec1);
            }
            controlador.asignarComboBox(jComboBoxApoderadoRN, modeloRNA, jTableApoderadoRN, 6);
        } catch (Exception e) {
            mensaje.mensajeError("Asignar campos del declarante");
        }
    }

    public boolean verificarExisteDNI(JTable tabla, JTextField jtex) {
        boolean rps = false;
        int contad = 0;
        while (contad < tabla.getRowCount()) {
            String dniz = tabla.getValueAt(contad, 0).toString();
            String apodz = tabla.getValueAt(contad, 6).toString();
            if (dniz.equals(jtex.getText())) {
                rps = true;
            }
            contad++;
        }
        return rps;
    }

    public boolean verificarExisteApo(JTable tabla, JComboBox jc) {
        boolean rps = false;
        int contad = 0;
        while (contad < tabla.getRowCount()) {
            String apodz = tabla.getValueAt(contad, 6).toString();
            if (apodz.equals(jc.getSelectedItem().toString())) {
                rps = true;
            }
            contad++;
        }
        return rps;
    }

    public boolean verificarExisteGenero(JTable tabla, JComboBox jc) {
        boolean rps = false;
        int contad = 0;
        while (contad < tabla.getRowCount()) {
            String gnz = tabla.getValueAt(contad, 3).toString();
            if (gnz.equals(jc.getSelectedItem().toString())) {
                rps = true;
            }
            contad++;
        }
        return rps;
    }

    //********************************************************************************************
    //REGISTRO DE MATRIMONIO
    public void limpiarCamposRM() {
        controlador.limpiarJTexField(jCTextFieldNombreHRM);
        controlador.limpiarJTexField(jCTextFieldNombreMRM);
        controlador.limpiarJTexField(jCTextFieldApellidoHRM);
        controlador.limpiarJTexField(jCTextFieldApellidoMRM);
        controlador.limpiarJTexField(jCTextFieldDNIHRM);
        controlador.limpiarJTexField(jCTextFieldDNIMRM);
        controlador.limpiarJTexField(jCTextFieldDireccionHRM);
        controlador.limpiarJTexField(jCTextFieldDireccionMRM);
        controlador.limpiarJTexField(jCTextFieldNactaRM);
//        controlador.limpiarComboBox(jComboBoxGeneroHRM);
//        controlador.limpiarComboBox(jComboBoxGeneroMRM);
        controlador.limpiarDataChooser(jDateChooserFechaNacHRM);
        controlador.limpiarDataChooser(jDateChooserFechaNacMRM);
        controlador.limpiarTimeChooser(timeChooserHoraNacHRM);
        controlador.limpiarTimeChooser(timeChooserHoraNacMRM);
    }

    public void estadoCamposRM(boolean estado) {
        jCTextFieldApellidoHRM.setEnabled(estado);
        jCTextFieldApellidoMRM.setEnabled(estado);
        jCTextFieldDNIHRM.setEnabled(estado);
        jCTextFieldDNIMRM.setEnabled(estado);
        jCTextFieldDireccionHRM.setEnabled(estado);
        jCTextFieldDireccionMRM.setEnabled(estado);
        jCTextFieldNombreHRM.setEnabled(estado);
        jCTextFieldNombreMRM.setEnabled(estado);
        jCTextFieldNactaRM.setEnabled(estado);
//        jComboBoxGeneroHRM.setEnabled(estado);
//        jComboBoxGeneroMRM.setEnabled(estado);
        jComboBoxDepartamentoRM.setEnabled(estado);
        jComboBoxProvinciaRM.setEnabled(estado);
        jComboBoxDistritoRM.setEnabled(estado);
        jDateChooserFechaNacHRM.setEnabled(estado);
        jDateChooserFechaNacMRM.setEnabled(estado);
        timeChooserHoraNacHRM.setEnabled(estado);
        timeChooserHoraNacMRM.setEnabled(estado);
    }

    public void estadoBotonesRM(boolean estado) {
        jCButtonCancelarRM.setEnabled(estado);
        jCButtonEditarRM.setEnabled(estado);
    }

    public void llenarComboRM() {
        consulta.llenarCombo("select * from tipo_reg where idtipo_reg=2", jComboBoxTipoRegRM, 2);
        consulta.llenarCombo("select * from departamento", jComboBoxDepartamentoRM, 2);
    }

    private void llenarProvinciaRM() {
        if (jComboBoxDepartamentoRM.getSelectedIndex() >= 0) {
            iddepartamentoRM = consulta.devolverDato("select iddepartamento from departamento where nomdep=", jComboBoxDepartamentoRM.getSelectedItem().toString(), 1);
            jComboBoxProvinciaRM.removeAllItems();
            consulta.llenarCombo("SELECT * FROM provincia WHERE iddepartamento='" + iddepartamentoRM + "'", jComboBoxProvinciaRM, 2);
        }
    }

    private void llenarDistritoRM() {
        if (jComboBoxProvinciaRM.getSelectedIndex() >= 0) {
            idprovinciaRM = consulta.devolverDato("select idprovincia from provincia where nomprov=", jComboBoxProvinciaRM.getSelectedItem().toString(), 1);
            jComboBoxDistritoRM.removeAllItems();
            consulta.llenarCombo("SELECT * FROM distrito where idprovincia='" + idprovinciaRM + "'", jComboBoxDistritoRM, 2);
        }
    }

    public void tituloTablaRM() {
        String[] titulo = {"ID", "ESPOSOS", "N° ACTA", "DISTRITO", "PROVINCIA", "DEPARTAMENTO", "FECHA REGISTRO", "HORA REGISTRO"};
        modeloRM = new DefaultTableModel(null, titulo);
        modeloRM.setColumnIdentifiers(titulo);
        jTableRegistroRM.setModel(modeloRM);
    }

    public void columnasTablaRM() {
        tabla.setMaxWidthColumnTable(jTableRegistroRM, 400, 1);
        tabla.ocultarColumnasTabla(jTableRegistroRM, 0);
    }

    public void cargarTablaRM() {
        tabla.MostrarEnTabla("CALL listRegistroRM()", jTableRegistroRM, modeloRM, 8);
        columnasTablaRM();
    }

    public void buscarRM() {
        controlador.BuscarDato("CALL searchRegistroRM(?)", modeloRM, 8, jCTextFieldBuscarRM);
        columnasTablaRM();
    }

    public void insertarRegistroRM() {
        idtiporegistroRM = consulta.devolverDato("select * from tipo_reg where nomtpo=", jComboBoxTipoRegRM.getSelectedItem().toString(), 1);
        iddistritoRM = consulta.devolverDato("select * from distrito where nomdist=", jComboBoxDistritoRM.getSelectedItem().toString(), 1);
        idusuarioRM = consulta.devolverDato("select * from usuario where nom=", JFrm_Acceso.jCTextFieldUsuario.getText(), 1);
        if (timeChooserHoraNacHRM.getText().length() != 0) {
            horaNacMH = fecha.HoraMysql(timeChooserHoraNacHRM.getText());
        } else {
            horaNacMH = "00:00:00";
        }
        if (timeChooserHoraNacMRM.getText().length() != 0) {
            horaNacMM = fecha.HoraMysql(timeChooserHoraNacMRM.getText());
        } else {
            horaNacMM = "00:00:00";
        }
        try {
            //Insertamos los datos del Hombre
            String sql_1 = "CALL insertRegistroRM("
                    + "'" + jCTextFieldDNIHRM.getText() + "',"
                    + "'" + jCTextFieldNombreHRM.getText() + "',"
                    + "'" + jCTextFieldApellidoHRM.getText() + "',"
                    + "'" + jComboBoxGeneroHRM.getSelectedItem().toString() + "',"
                    + "'" + jCTextFieldDireccionHRM.getText() + "',"
                    + "'" + fecha.Formato_AMD(jDateChooserFechaNacHRM.getDate()) + "',"
                    + "'" + horaNacMH + "',"
                    + "'" + idusuarioRM + "',"
                    + "'" + idtiporegistroRM + "',"
                    + "'" + jCTextFieldNactaRM.getText() + "',"
                    + "'" + JInt_FechaHora.fechaImportante + "',"
                    + "'" + JInt_FechaHora.horaImportante + "',"
                    + "'" + iddistritoRM + "'"
                    + " );";
            consulta.Consulta(sql_1);
            //Insertamos los datos de la Mujer
            String sql_2 = "CALL insertRegistroRM("
                    + "'" + jCTextFieldDNIMRM.getText() + "',"
                    + "'" + jCTextFieldNombreMRM.getText() + "',"
                    + "'" + jCTextFieldApellidoMRM.getText() + "',"
                    + "'" + jComboBoxGeneroMRM.getSelectedItem().toString() + "',"
                    + "'" + jCTextFieldDireccionMRM.getText() + "',"
                    + "'" + fecha.Formato_AMD(jDateChooserFechaNacMRM.getDate()) + "',"
                    + "'" + horaNacMM + "',"
                    + "'" + idusuarioRM + "',"
                    + "'" + idtiporegistroRM + "',"
                    + "'" + jCTextFieldNactaRM.getText() + "',"
                    + "'" + JInt_FechaHora.fechaImportante + "',"
                    + "'" + JInt_FechaHora.horaImportante + "',"
                    + "'" + iddistritoRM + "'"
                    + " );";
            mensaje.mensajeInformacion(consulta.CrearRegistro(sql_2));
            JInt_FechaHora.fechaImportante = "";
            JInt_FechaHora.horaImportante = "";
        } catch (Exception e) {
            mensaje.mensajeError("Insertar registro de matrimonio");
        }
    }

    public void editarRegistroRM() {
        idtiporegistroRM = consulta.devolverDato("select * from tipo_reg where nomtpo=", jComboBoxTipoRegRM.getSelectedItem().toString(), 1);
        iddistritoRM = consulta.devolverDato("select * from distrito where nomdist=", jComboBoxDistritoRM.getSelectedItem().toString(), 1);
        idusuarioRM = consulta.devolverDato("select * from usuario where nom=", JFrm_Acceso.jCTextFieldUsuario.getText(), 1);
        if (timeChooserHoraNacHRM.getText().length() != 0) {
            horaNacMH = fecha.HoraMysql(timeChooserHoraNacHRM.getText());
        } else {
            horaNacMH = "00:00:00";
        }
        if (timeChooserHoraNacMRM.getText().length() != 0) {
            horaNacMM = fecha.HoraMysql(timeChooserHoraNacMRM.getText());
        } else {
            horaNacMM = "00:00:00";
        }
        try {
            //Editamos los datos del Hombre
            String sql_1 = "CALL editRegistroRM("
                    + "'" + jCTextFieldDNIHRM.getText() + "',"
                    + "'" + jCTextFieldNombreHRM.getText() + "',"
                    + "'" + jCTextFieldApellidoHRM.getText() + "',"
                    + "'" + jComboBoxGeneroHRM.getSelectedItem().toString() + "',"
                    + "'" + jCTextFieldDireccionHRM.getText() + "',"
                    + "'" + fecha.Formato_AMD(jDateChooserFechaNacHRM.getDate()) + "',"
                    + "'" + horaNacMH + "',"
                    + "'" + idusuarioRM + "',"
                    + "'" + jCTextFieldNactaRM.getText() + "',"
                    + "'" + iddistritoRM + "',"
                    + "'" + idregistroRM + "'"
                    + " );";
            consulta.Consulta(sql_1);
            //Editamos los datos de la Mujer
            String sql_2 = "CALL editRegistroRM("
                    + "'" + jCTextFieldDNIMRM.getText() + "',"
                    + "'" + jCTextFieldNombreMRM.getText() + "',"
                    + "'" + jCTextFieldApellidoMRM.getText() + "',"
                    + "'" + jComboBoxGeneroMRM.getSelectedItem().toString() + "',"
                    + "'" + jCTextFieldDireccionMRM.getText() + "',"
                    + "'" + fecha.Formato_AMD(jDateChooserFechaNacMRM.getDate()) + "',"
                    + "'" + horaNacMM + "',"
                    + "'" + idusuarioRM + "',"
                    + "'" + jCTextFieldNactaRM.getText() + "',"
                    + "'" + iddistritoRM + "',"
                    + "'" + idregistroRM + "'"
                    + " );";
//            mensaje.mensajeInformacion(consulta.CrearRegistro(sql_2));
            consulta.Consulta(sql_2);
            mensaje.mensajeInformacion("Se actualizo satisfactoriamente.");
        } catch (Exception e) {
            mensaje.mensajeError("Editar registro de matrimonio");
        }
    }

    public void asignarCamposRM() {
        String datogene = "";
        try {
            idregistroRM = modeloRM.getValueAt(jTableRegistroRM.getSelectedRow(), 0).toString();
            datogene = "MASCULINO";
            String sql = "CALL modifyRegistroRM("
                    + "'" + idregistroRM + "',"
                    + "'" + datogene + "'"
                    + " );";
            jCTextFieldNombreHRM.setText(consulta.devolverRegistroDato(sql, 1));
            jCTextFieldApellidoHRM.setText(consulta.devolverRegistroDato(sql, 2));
            jCTextFieldDNIHRM.setText(consulta.devolverRegistroDato(sql, 3));
            jComboBoxGeneroHRM.setSelectedItem(consulta.devolverRegistroDato(sql, 4));
            jDateChooserFechaNacHRM.setDate(Date.valueOf(consulta.devolverRegistroDato(sql, 5)));
            timeChooserHoraNacHRM.setText(consulta.devolverRegistroDato(sql, 6));
            jCTextFieldDireccionHRM.setText(consulta.devolverRegistroDato(sql, 7));

            jComboBoxTipoRegRM.setSelectedItem(consulta.devolverRegistroDato(sql, 8));
            jCTextFieldNactaRM.setText(consulta.devolverRegistroDato(sql, 9));
            jComboBoxDepartamentoRM.setSelectedItem(consulta.devolverRegistroDato(sql, 10));
            jComboBoxProvinciaRM.setSelectedItem(consulta.devolverRegistroDato(sql, 11));
            jComboBoxDistritoRM.setSelectedItem(consulta.devolverRegistroDato(sql, 12));

            datogene = "FEMENINO";
            String sql_1 = "CALL modifyRegistroRM("
                    + "'" + idregistroRM + "',"
                    + "'" + datogene + "'"
                    + " );";
            jCTextFieldNombreMRM.setText(consulta.devolverRegistroDato(sql_1, 1));
            jCTextFieldApellidoMRM.setText(consulta.devolverRegistroDato(sql_1, 2));
            jCTextFieldDNIMRM.setText(consulta.devolverRegistroDato(sql_1, 3));
            jComboBoxGeneroMRM.setSelectedItem(consulta.devolverRegistroDato(sql_1, 4));
            jDateChooserFechaNacMRM.setDate(Date.valueOf(consulta.devolverRegistroDato(sql_1, 5)));
            timeChooserHoraNacMRM.setText(consulta.devolverRegistroDato(sql_1, 6));
            jCTextFieldDireccionMRM.setText(consulta.devolverRegistroDato(sql_1, 7));
        } catch (Exception e) {
            mensaje.mensajeError("Asignar campos en registro de matrimonio");
        }
    }

    public void asignarCamposFechaRM() {
        idregistroFecRM = modeloRM.getValueAt(jTableRegistroRM.getSelectedRow(), 0).toString();
        String sql = "CALL modifyFecRM("
                + "'" + idregistroFecRM + "'"
                + " );";

        JInt_FechaHora jrm = new JInt_FechaHora();
        controlador.MostrarJFrameInternos(JFrm_Menu.jDesktopPane1, jrm);
        JInt_FechaHora.jLabelFecha.setText("Fecha de matrimonio*");
        JInt_FechaHora.jLabelHora.setText("Hora de matrimonio*");
        JInt_FechaHora.jCButtonAgregarRN.setText("Aceptar");

        JInt_FechaHora.jDateChooserFecha.setDate(Date.valueOf(consulta.devolverRegistroDato(sql, 7)));
        JInt_FechaHora.timeChooserHora.setText(consulta.devolverRegistroDato(sql, 8));
    }

    public boolean validarCamposRM() {
        boolean valor = false;
        if (jCTextFieldNombreHRM.getText().length() != 0) {
            if (jCTextFieldApellidoHRM.getText().length() != 0) {
                if (jCTextFieldDNIHRM.getText().length() != 0) {
                    if (jComboBoxGeneroHRM.getSelectedIndex() != -1) {
                        if (jCTextFieldDireccionHRM.getText().length() != 0) {
                            if (jDateChooserFechaNacHRM.getDate() != null) {
//                                if (timeChooserHoraNacHRM.getText().length() != 0) {
                                if (jCTextFieldNombreMRM.getText().length() != 0) {
                                    if (jCTextFieldApellidoMRM.getText().length() != 0) {
                                        if (jCTextFieldDNIMRM.getText().length() != 0) {
                                            if (jComboBoxGeneroMRM.getSelectedIndex() != -1) {
                                                if (jCTextFieldDireccionMRM.getText().length() != 0) {
                                                    if (jDateChooserFechaNacMRM.getDate() != null) {
//                                                            if (timeChooserHoraNacMRM.getText().length() != 0) {
                                                        if (jComboBoxTipoRegRM.getSelectedIndex() != -1) {
                                                            if (jCTextFieldNactaRM.getText().length() != 0) {
                                                                if (jComboBoxDepartamentoRM.getSelectedIndex() != 0) {
                                                                    if (jComboBoxProvinciaRM.getSelectedIndex() > -1) {
                                                                        if (jComboBoxDistritoRM.getSelectedIndex() > -1) {
                                                                            if (JInt_FechaHora.fechaImportante != "" && JInt_FechaHora.horaImportante != "") {
                                                                                valor = true;
                                                                            } else {
                                                                                mensaje.mensajeError("Debe agregar la fecha y hora del matrimonio.");
                                                                                jCButtonFechaImportanteRM.requestFocus();
                                                                                jCButtonFechaImportanteRM.doClick();
                                                                            }
                                                                        } else {
                                                                            mensaje.mensajeError("Debe seleccionar un distrito.");
                                                                            jComboBoxDistritoRM.requestFocus();
                                                                        }
                                                                    } else {
                                                                        mensaje.mensajeError("Debe seleccionar una provincia.");
                                                                        jComboBoxProvinciaRM.requestFocus();
                                                                    }
                                                                } else {
                                                                    mensaje.mensajeError("Debe seleccionar un departamento.");
                                                                    jComboBoxDepartamentoRM.requestFocus();
                                                                }
                                                            } else {
                                                                mensaje.mensajeError("Debe ingresar el número del acta.");
                                                                jCTextFieldNactaRM.requestFocus();
                                                            }
                                                        } else {
                                                            mensaje.mensajeError("Debe seleccionar el tipo de registro.");
                                                            jComboBoxTipoRegRM.requestFocus();
                                                        }
//                                                            } else {
//                                                                mensaje.mensajeError("Debe ingresar la hora de nacimiento de la esposa.");
//                                                                timeChooserHoraNacMRM.requestFocus();
//                                                            }
                                                    } else {
                                                        mensaje.mensajeError("Debe ingresar la fecha de nacimiento de la esposa.");
                                                        jDateChooserFechaNacMRM.requestFocusInWindow();
                                                    }
                                                } else {
                                                    mensaje.mensajeError("Debe ingresar la dirección de la esposa.");
                                                    jCTextFieldDireccionMRM.requestFocus();
                                                }
                                            } else {
                                                mensaje.mensajeError("Debe seleccionar el género de la esposa.");
                                                jComboBoxGeneroMRM.requestFocus();
                                            }
                                        } else {
                                            mensaje.mensajeError("Debe ingresar el DNI de la esposa.");
                                            jCTextFieldDNIMRM.requestFocus();
                                        }
                                    } else {
                                        mensaje.mensajeError("Debe ingresar el apellido de la esposa.");
                                        jCTextFieldApellidoMRM.requestFocus();
                                    }
                                } else {
                                    mensaje.mensajeError("Debe ingresar el nombre de la esposa.");
                                    jCTextFieldNombreMRM.requestFocus();
                                }
//                                } else {
//                                    mensaje.mensajeError("Debe ingresar la hora de nacimiento del esposo.");
//                                    timeChooserHoraNacHRM.requestFocus();
//                                }
                            } else {
                                mensaje.mensajeError("Debe ingresar la fecha de nacimiento del esposo.");
                                jDateChooserFechaNacHRM.requestFocusInWindow();
                            }
                        } else {
                            mensaje.mensajeError("Debe ingresar la dirección del esposo.");
                            jCTextFieldDireccionHRM.requestFocus();
                        }
                    } else {
                        mensaje.mensajeError("Debe seleccionar el género del esposo.");
                        jComboBoxGeneroHRM.requestFocus();
                    }
                } else {
                    mensaje.mensajeError("Debe ingresar el DNI del esposo.");
                    jCTextFieldDNIHRM.requestFocus();
                }
            } else {
                mensaje.mensajeError("Debe ingresar el apellido del esposo.");
                jCTextFieldApellidoHRM.requestFocus();
            }
        } else {
            mensaje.mensajeError("Debe ingresar el nombre del esposo.");
            jCTextFieldNombreHRM.requestFocus();
        }
        return valor;
    }

    //****************************************************************************************
    //REGISTRO DE DEFUNCIÓN
    public void limpiarCamposRD() {
        controlador.limpiarJTexField(jCTextFieldNombresRD);
        controlador.limpiarJTexField(jCTextFieldNombreApoRD);
        controlador.limpiarJTexField(jCTextFieldApellidosRD);
        controlador.limpiarJTexField(jCTextFieldApellidoApoRD);
        controlador.limpiarJTexField(jCTextFieldDNIRD);
        controlador.limpiarJTexField(jCTextFieldDNIApoRD);
        controlador.limpiarJTexField(jCTextFieldDireccionRD);
        controlador.limpiarJTexField(jCTextFieldDireccionApoRD);
        controlador.limpiarJTexField(jCTextFieldNactaRD);
        controlador.limpiarComboBox(jComboBoxGeneroRD);
        controlador.limpiarComboBox(jComboBoxGeneroApoRD);
        controlador.limpiarComboBox(jComboBoxApoderadoRD);
        controlador.limpiarDataChooser(jDateChooserFechaNacimientoRD);
        controlador.limpiarDataChooser(jDateChooserFechaNacApoRD);
        controlador.limpiarTimeChooser(timeChooserHoraNacimientoRD);
    }

    public void estadoCamposRD(boolean estado) {
        jCTextFieldApellidosRD.setEnabled(estado);
        jCTextFieldApellidoApoRD.setEnabled(estado);
        jCTextFieldDNIRD.setEnabled(estado);
        jCTextFieldDNIApoRD.setEnabled(estado);
        jCTextFieldDireccionRD.setEnabled(estado);
        jCTextFieldDireccionApoRD.setEnabled(estado);
        jCTextFieldNombresRD.setEnabled(estado);
        jCTextFieldNombreApoRD.setEnabled(estado);
        jCTextFieldNactaRD.setEnabled(estado);
        jComboBoxGeneroRD.setEnabled(estado);
        jComboBoxApoderadoRD.setEnabled(estado);
        jComboBoxDepartamentoRD.setEnabled(estado);
        jComboBoxProvinciaRD.setEnabled(estado);
        jComboBoxDistritoRD.setEnabled(estado);
        jComboBoxGeneroApoRD.setEnabled(estado);
        jDateChooserFechaNacimientoRD.setEnabled(estado);
        jDateChooserFechaNacApoRD.setEnabled(estado);
        timeChooserHoraNacimientoRD.setEnabled(estado);
    }

    public void estadoBotonesRD(boolean estado) {
        jCButtonCancelarRD.setEnabled(estado);
        jCButtonEditarRD.setEnabled(estado);
    }

    public void llenarComboRD() {
        consulta.llenarCombo("select * from tipo_reg where idtipo_reg=3", jComboBoxTipoRegistroRD, 2);
        consulta.llenarCombo("select * from departamento", jComboBoxDepartamentoRD, 2);
        consulta.llenarCombo("select a.nom_apo, tr.nomtpo\n"
                + "from apoderado a, tipo_reg tr, aporegistro ar\n"
                + "where a.idapoderado=ar.idapoderado and tr.idtipo_reg=ar.idtipo_reg and tr.nomtpo='" + jComboBoxTipoRegistroRD.getSelectedItem().toString() + "'", jComboBoxApoderadoRD, 1);
    }

    private void llenarProvinciaRD() {
        if (jComboBoxDepartamentoRD.getSelectedIndex() >= 0) {
            iddepartamentoRD = consulta.devolverDato("select iddepartamento from departamento where nomdep=", jComboBoxDepartamentoRD.getSelectedItem().toString(), 1);
            jComboBoxProvinciaRD.removeAllItems();
            consulta.llenarCombo("SELECT * FROM provincia WHERE iddepartamento='" + iddepartamentoRD + "'", jComboBoxProvinciaRD, 2);
        }
    }

    private void llenarDistritoRD() {
        if (jComboBoxProvinciaRD.getSelectedIndex() >= 0) {
            idprovinciaRD = consulta.devolverDato("select idprovincia from provincia where nomprov=", jComboBoxProvinciaRD.getSelectedItem().toString(), 1);
            jComboBoxDistritoRD.removeAllItems();
            consulta.llenarCombo("SELECT * FROM distrito where idprovincia='" + idprovinciaRD + "'", jComboBoxDistritoRD, 2);
        }
    }

    public void tituloTablaRD() {
        String[] titulo = {"ID", "DNI", "APELLIDOS Y NOMBRES", "FEC. NAC", "N° ACTA", "DISTRITO", "PROVINCIA", "DEPARTAMENTO", "FECHA REGISTRO", "HORA REGISTRO"};
        modeloRD = new DefaultTableModel(null, titulo);
        modeloRD.setColumnIdentifiers(titulo);
        jTableRegistroRD.setModel(modeloRD);
    }

    public void columnasTablaRD() {
        tabla.setMaxWidthColumnTable(jTableRegistroRD, 80, 1);
        tabla.setMaxWidthColumnTable(jTableRegistroRD, 250, 2);
        tabla.ocultarColumnasTabla(jTableRegistroRD, 0);
    }

    public void cargarTablaRD() {
        tabla.MostrarEnTabla("CALL listRegistroRD()", jTableRegistroRD, modeloRD, 10);
        columnasTablaRD();
    }

    public void buscarRD() {
        controlador.BuscarDato("CALL searchRegistroRD(?)", modeloRD, 10, jCTextFieldBuscarRD);
    }

    public void tituloTablaRDA() {
        modeloRDA = new DefaultTableModel();
        jTableApoderadoRD.setModel(modeloRDA);
        modeloRDA.addColumn("DNI");
        modeloRDA.addColumn("NOMBRE");
        modeloRDA.addColumn("APELLIDO");
        modeloRDA.addColumn("GENERO");
        modeloRDA.addColumn("DIRECCIÓN");
        modeloRDA.addColumn("FEC. NAC");
        modeloRDA.addColumn("DECLARANTE");
    }

    public void limpiarCamposRDA() {
        controlador.limpiarJTexField(jCTextFieldNombreApoRD);
        controlador.limpiarJTexField(jCTextFieldApellidoApoRD);
        controlador.limpiarJTexField(jCTextFieldDNIApoRD);
        controlador.limpiarJTexField(jCTextFieldDireccionApoRD);
        controlador.limpiarComboBox(jComboBoxGeneroApoRD);
        controlador.limpiarComboBox(jComboBoxApoderadoRD);
        controlador.limpiarDataChooser(jDateChooserFechaNacApoRD);
    }

    public void insertarRegistroRD() {
        idtiporegistroRD = consulta.devolverDato("select * from tipo_reg where nomtpo=", jComboBoxTipoRegistroRD.getSelectedItem().toString(), 1);
        iddistritoRD = consulta.devolverDato("select * from distrito where nomdist=", jComboBoxDistritoRD.getSelectedItem().toString(), 1);
        idusuarioRD = consulta.devolverDato("select * from usuario where nom=", JFrm_Acceso.jCTextFieldUsuario.getText(), 1);
        if (timeChooserHoraNacimientoRD.getText().length() != 0) {
            horaNacD = fecha.HoraMysql(timeChooserHoraNacimientoRD.getText());
        } else {
            horaNacD = "00:00:00";
        }
        try {
            String sql = "CALL insertRegistroRD("
                    + "'" + jCTextFieldDNIRD.getText() + "',"
                    + "'" + jCTextFieldNombresRD.getText() + "',"
                    + "'" + jCTextFieldApellidosRD.getText() + "',"
                    + "'" + jComboBoxGeneroRD.getSelectedItem().toString() + "',"
                    + "'" + jCTextFieldDireccionRD.getText() + "',"
                    + "'" + fecha.Formato_AMD(jDateChooserFechaNacimientoRD.getDate()) + "',"
                    + "'" + horaNacD + "',"
                    + "'" + idusuarioRD + "',"
                    + "'" + idtiporegistroRD + "',"
                    + "'" + jCTextFieldNactaRD.getText() + "',"
                    + "'" + JInt_FechaHora.fechaImportante + "',"
                    + "'" + JInt_FechaHora.horaImportante + "',"
                    + "'" + iddistritoRD + "'"
                    + " );";
            mensaje.mensajeInformacion(consulta.CrearRegistro(sql));
            JInt_FechaHora.fechaImportante = "";
            JInt_FechaHora.horaImportante = "";
        } catch (Exception e) {
            mensaje.mensajeError("Insertar registro de defunción");
        }
    }

    public void editarRegistroRD() {
        iddistritoRD = consulta.devolverDato("select * from distrito where nomdist=", jComboBoxDistritoRD.getSelectedItem().toString(), 1);
        idusuarioRD = consulta.devolverDato("select * from usuario where nom=", JFrm_Acceso.jCTextFieldUsuario.getText(), 1);
        if (timeChooserHoraNacimientoRD.getText().length() != 0) {
            horaNacD = fecha.HoraMysql(timeChooserHoraNacimientoRD.getText());
        } else {
            horaNacD = "00:00:00";
        }
        try {
            String sql = "CALL editRegistroRD("
                    + "'" + jCTextFieldDNIRD.getText() + "',"
                    + "'" + jCTextFieldNombresRD.getText() + "',"
                    + "'" + jCTextFieldApellidosRD.getText() + "',"
                    + "'" + jComboBoxGeneroRD.getSelectedItem().toString() + "',"
                    + "'" + jCTextFieldDireccionRD.getText() + "',"
                    + "'" + fecha.Formato_AMD(jDateChooserFechaNacimientoRD.getDate()) + "',"
                    + "'" + horaNacD + "',"
                    + "'" + idusuarioRD + "',"
                    + "'" + jCTextFieldNactaRD.getText() + "',"
                    + "'" + iddistritoRD + "',"
                    + "'" + idregistroRD + "'"
                    + " );";
            mensaje.mensajeInformacion(consulta.CrearRegistro(sql));
        } catch (Exception e) {
            mensaje.mensajeError("Editar registro de defunción");
        }
    }

    public void insertarApoderadoRD() {
        try {
            String dni, nombre, apellido, genero, direccion, fec_nac, apoderado;
            int contador = 0;
            while (contador < jTableApoderadoRD.getRowCount()) {
                dni = jTableApoderadoRD.getValueAt(contador, 0).toString();
                nombre = jTableApoderadoRD.getValueAt(contador, 1).toString();
                apellido = jTableApoderadoRD.getValueAt(contador, 2).toString();
                genero = jTableApoderadoRD.getValueAt(contador, 3).toString();
                direccion = jTableApoderadoRD.getValueAt(contador, 4).toString();
                fec_nac = jTableApoderadoRD.getValueAt(contador, 5).toString();
                apoderado = jTableApoderadoRD.getValueAt(contador, 6).toString();
                idapoderadoRD = consulta.devolverDato("select * from apoderado where nom_apo=", apoderado, 1);
                if (fec_nac.length() == 0) {
                    fec_nac = "1900-01-01";
                }
                String sql = "CALL insertApoderadoRD("
                        + "'" + dni + "',"
                        + "'" + nombre + "',"
                        + "'" + apellido + "',"
                        + "'" + genero + "',"
                        + "'" + direccion + "',"
                        + "'" + fec_nac + "',"
                        + "'" + idapoderadoRD + "'"
                        + " );";
                //mensaje.mensajeInformacion(consulta.CrearRegistro(sql));
                consulta.CrearRegistro(sql);
                contador++;
            }
        } catch (Exception e) {
            mensaje.mensajeError("Insertar declarante de registro de defunción");
        }
    }

    public void editarApoderadoRD() {
        try {
            String dni1, nombre1, apellido1, genero1, direccion1, fec_nac1, apoderado1;
            int contador1 = 0;
            while (contador1 < jTableApoderadoRD.getRowCount()) {
                dni1 = jTableApoderadoRD.getValueAt(contador1, 0).toString();
                nombre1 = jTableApoderadoRD.getValueAt(contador1, 1).toString();
                apellido1 = jTableApoderadoRD.getValueAt(contador1, 2).toString();
                genero1 = jTableApoderadoRD.getValueAt(contador1, 3).toString();
                direccion1 = jTableApoderadoRD.getValueAt(contador1, 4).toString();
                fec_nac1 = jTableApoderadoRD.getValueAt(contador1, 5).toString();
                apoderado1 = jTableApoderadoRD.getValueAt(contador1, 6).toString();
                String idapodRD = consulta.devolverDato("select * from apoderado where nom_apo=", apoderado1, 1);
                if (fec_nac1.length() == 0) {
                    fec_nac1 = "1900-01-01";
                }
                String query1 = "CALL countApoderadoRD("
                        + "'" + idregistroRD + "'"
                        + " );";
                String totalRegs = consulta.devolverRegistroDato(query1, 1);
                int cont1 = 0;
                while (cont1 < Integer.parseInt(totalRegs)) {
                    String query2 = "CALL modifyApoderadoRD("
                            + "'" + idregistroRD + "',"
                            + "'" + cont1 + "'"
                            + " );";
                    String dnibd = consulta.devolverRegistroDato(query2, 1);
                    String query3 = "CALL editApoderadoRD("
                            + "'" + dni1 + "',"
                            + "'" + nombre1 + "',"
                            + "'" + apellido1 + "',"
                            + "'" + genero1 + "',"
                            + "'" + direccion1 + "',"
                            + "'" + fec_nac1 + "',"
                            + "'" + dnibd + "',"
                            + "'" + idapodRD + "',"
                            + "'" + idregistroRD + "'"
                            + " );";
                    //mensaje.mensajeInformacion(consulta.CrearRegistro(query3));
                    consulta.Consulta(query3);
                    cont1++;
                }
                contador1++;
            }
        } catch (Exception e) {
            mensaje.mensajeError("Editar declarante de registro de defunción");
        }
    }

    public boolean validarCamposRD() {
        boolean valor = false;
        if (jCTextFieldNombresRD.getText().length() != 0) {
            if (jCTextFieldApellidosRD.getText().length() != 0) {
                if (jComboBoxGeneroRD.getSelectedIndex() != 0) {
                    if (jCTextFieldDireccionRD.getText().length() != 0) {
                        if (jDateChooserFechaNacimientoRD.getDate() != null) {
//                            if (timeChooserHoraNacimientoRD.getText().length() != 0) {
                            if (jComboBoxTipoRegistroRD.getSelectedIndex() != -1) {
                                if (jCTextFieldNactaRD.getText().length() != 0) {
                                    if (jComboBoxDepartamentoRD.getSelectedIndex() != 0) {
                                        if (jComboBoxProvinciaRD.getSelectedIndex() > -1) {
                                            if (jComboBoxDistritoRD.getSelectedIndex() > -1) {
                                                if (jTableApoderadoRD.getRowCount() != 0) {
                                                    if (JInt_FechaHora.fechaImportante != "" && JInt_FechaHora.horaImportante != "") {
                                                        valor = true;
                                                    } else {
                                                        mensaje.mensajeError("Debe agregar la fecha y hora de la defunción.");
                                                        jCButtonFechaImportanteRM.requestFocus();
                                                        jCButtonFechaImportanteRM.doClick();
                                                        JInt_FechaHora.jLabelFecha.setText("Fecha de defunción*");
                                                        JInt_FechaHora.jLabelHora.setText("Hora de defunción*");
                                                    }
                                                } else {
                                                    mensaje.mensajeError("Debes ingresar los declarantes.");
                                                    jCTextFieldNombreApoRD.requestFocus();
                                                }
                                            } else {
                                                mensaje.mensajeError("Debe seleccionar un distrito.");
                                                jComboBoxDistritoRD.requestFocus();
                                            }
                                        } else {
                                            mensaje.mensajeError("Debe seleccionar una provincia.");
                                            jComboBoxProvinciaRD.requestFocus();
                                        }
                                    } else {
                                        mensaje.mensajeError("Debe seleccionar un departamento.");
                                        jComboBoxDepartamentoRD.requestFocus();
                                    }
                                } else {
                                    mensaje.mensajeError("Debe ingresar el número del acta.");
                                    jCTextFieldNactaRD.requestFocus();
                                }
                            } else {
                                mensaje.mensajeError("Debe seleccionar el tipo de registro.");
                                jComboBoxTipoRegistroRD.requestFocus();
                            }
//                            } else {
//                                mensaje.mensajeError("Debe ingresar su hora de nacimiento.");
//                                timeChooserHoraNacimientoRD.requestFocus();
//                            }
                        } else {
                            mensaje.mensajeError("Debe ingresar su fecha de nacimiento.");
                            jDateChooserFechaNacimientoRD.requestFocusInWindow();
                        }
                    } else {
                        mensaje.mensajeError("Debe ingresar su dirección.");
                        jCTextFieldDireccionRD.requestFocus();
                    }
                } else {
                    mensaje.mensajeError("Debe seleccionar su género.");
                    jComboBoxGeneroRD.requestFocus();
                }
            } else {
                mensaje.mensajeError("Debe ingresar su apellido.");
                jCTextFieldApellidosRD.requestFocus();
            }
        } else {
            mensaje.mensajeError("Debe ingresar su nombre.");
            jCTextFieldNombresRD.requestFocus();
        }
        return valor;
    }

    public boolean validarCamposRDA() {
        boolean valor = false;
        if (jCTextFieldNombreApoRD.getText().length() != 0) {
            if (jCTextFieldApellidoApoRD.getText().length() != 0) {
                if (jCTextFieldDNIApoRD.getText().length() != 0) {
                    if (jComboBoxGeneroApoRD.getSelectedIndex() != 0) {
                        if (jCTextFieldDireccionApoRD.getText().length() != 0) {
                            if (jComboBoxApoderadoRD.getSelectedIndex() != 0) {
                                valor = true;
                            } else {
                                mensaje.mensajeError("Debe seleccionar el declarante.");
                                jComboBoxApoderadoRD.requestFocus();
                            }
                        } else {
                            mensaje.mensajeError("Debe ingresar su dirección del declarante.");
                            jCTextFieldDireccionApoRD.requestFocus();
                        }
                    } else {
                        mensaje.mensajeError("Debe seleccionar su género del declarante.");
                        jComboBoxGeneroApoRD.requestFocus();
                    }
                } else {
                    mensaje.mensajeError("Debe ingresar su DNI del declarante.");
                    jCTextFieldDNIApoRD.requestFocus();
                }
            } else {
                mensaje.mensajeError("Debe ingresar su apellido del declarante.");
                jCTextFieldApellidoApoRD.requestFocus();
            }
        } else {
            mensaje.mensajeError("Debe ingresar su nombre del declarante.");
            jCTextFieldNombreApoRD.requestFocus();
        }
        return valor;
    }

    public void asignarCamposApoderadoRD() {
        try {
            controlador.asignarJTexField(jCTextFieldDNIApoRD, modeloRDA, jTableApoderadoRD, 0);
            controlador.asignarJTexField(jCTextFieldNombreApoRD, modeloRDA, jTableApoderadoRD, 1);
            controlador.asignarJTexField(jCTextFieldApellidoApoRD, modeloRDA, jTableApoderadoRD, 2);
            controlador.asignarComboBox(jComboBoxGeneroApoRD, modeloRDA, jTableApoderadoRD, 3);
            controlador.asignarJTexField(jCTextFieldDireccionApoRD, modeloRDA, jTableApoderadoRD, 4);
            String fec = modeloRDA.getValueAt(jTableApoderadoRD.getSelectedRow(), 5).toString();
            if (fec.length() != 0) {
                String fec1 = fecha.fechaMysqlNormal(fec);
                controlador.AsignarFechaenDateChooser(jDateChooserFechaNacApoRD, fec1);
            }
            controlador.asignarComboBox(jComboBoxApoderadoRD, modeloRDA, jTableApoderadoRD, 6);
        } catch (Exception e) {
            mensaje.mensajeError("Asignar campos del declarante de defunción");
        }
    }

    public void asignarCamposRD() {
        try {
            idregistroRD = modeloRD.getValueAt(jTableRegistroRD.getSelectedRow(), 0).toString();
            String sql = "CALL modifyRegistroRD("
                    + "'" + idregistroRD + "'"
                    + " );";
            jCTextFieldNombresRD.setText(consulta.devolverRegistroDato(sql, 1));
            jCTextFieldApellidosRD.setText(consulta.devolverRegistroDato(sql, 2));
            jCTextFieldDNIRD.setText(consulta.devolverRegistroDato(sql, 3));
            jComboBoxGeneroRD.setSelectedItem(consulta.devolverRegistroDato(sql, 4));
            jDateChooserFechaNacimientoRD.setDate(Date.valueOf(consulta.devolverRegistroDato(sql, 5)));
            timeChooserHoraNacimientoRD.setText(consulta.devolverRegistroDato(sql, 6));
            jCTextFieldDireccionRD.setText(consulta.devolverRegistroDato(sql, 7));
            jComboBoxTipoRegistroRD.setSelectedItem(consulta.devolverRegistroDato(sql, 8));
            jCTextFieldNactaRD.setText(consulta.devolverRegistroDato(sql, 9));
            jComboBoxDepartamentoRD.setSelectedItem(consulta.devolverRegistroDato(sql, 10));
            jComboBoxProvinciaRD.setSelectedItem(consulta.devolverRegistroDato(sql, 11));
            jComboBoxDistritoRD.setSelectedItem(consulta.devolverRegistroDato(sql, 12));
            //Devolvemos todos los apoderados que tiene un determinado registro
            String sql1 = "CALL countApoderadoRD("
                    + "'" + idregistroRD + "'"
                    + " );";

            String totalReg = consulta.devolverRegistroDato(sql1, 1);
            int cont = 0;
            while (cont < Integer.parseInt(totalReg)) {
                String sql2 = "CALL modifyApoderadoRD("
                        + "'" + idregistroRD + "',"
                        + "'" + cont + "'"
                        + " );";
                Object[] object = new Object[7];
                object[0] = consulta.devolverRegistroDato(sql2, 1);
                object[1] = consulta.devolverRegistroDato(sql2, 2);
                object[2] = consulta.devolverRegistroDato(sql2, 3);
                object[3] = consulta.devolverRegistroDato(sql2, 4);
                object[4] = consulta.devolverRegistroDato(sql2, 5);
                object[5] = consulta.devolverRegistroDato(sql2, 6);
                object[6] = consulta.devolverRegistroDato(sql2, 7);
                modeloRDA.addRow(object);
                cont++;
            }
        } catch (Exception e) {
            mensaje.mensajeError("Asignar campos de defunción");
        }
    }

    public void asignarCamposFechaRD() {
        idregistroFecRD = modeloRD.getValueAt(jTableRegistroRD.getSelectedRow(), 0).toString();
        String sql = "CALL modifyFecRD("
                + "'" + idregistroFecRD + "'"
                + " );";

        JInt_FechaHora jrm = new JInt_FechaHora();
        controlador.MostrarJFrameInternos(JFrm_Menu.jDesktopPane1, jrm);
        JInt_FechaHora.jLabelFecha.setText("Fecha de defunción*");
        JInt_FechaHora.jLabelHora.setText("Hora de defunción*");
        JInt_FechaHora.jCButtonAgregarRN.setText("Modificar");

        JInt_FechaHora.jDateChooserFecha.setDate(Date.valueOf(consulta.devolverRegistroDato(sql, 7)));
        JInt_FechaHora.timeChooserHora.setText(consulta.devolverRegistroDato(sql, 8));
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
        jMenuItemModificarRN = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItemModificarApoRN = new javax.swing.JMenuItem();
        jMenuItemEliminarApoRN = new javax.swing.JMenuItem();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jMenuItemModificarRM = new javax.swing.JMenuItem();
        jMenuItemModificarFecRM = new javax.swing.JMenuItem();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jMenuItemModificarRD = new javax.swing.JMenuItem();
        jMenuItemModificarFecRD = new javax.swing.JMenuItem();
        jPopupMenu5 = new javax.swing.JPopupMenu();
        jMenuItemModificarApoRD = new javax.swing.JMenuItem();
        jMenuItemEliminarApoRD = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCTextFieldNombresRN = new ControlSwing.JCTextField();
        jCTextFieldApellidosRN = new ControlSwing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCTextFieldDNIRN = new ControlSwing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxGeneroRN = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jCTextFieldDireccionRN = new ControlSwing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jDateChooserFechaNacimientoRN = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        timeChooserHoraNacimientoRN = new org.bolivia.time.TimeChooser();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxTipoRegistroRN = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jCTextFieldNactaRN = new ControlSwing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxDepartamentoRN = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxProvinciaRN = new javax.swing.JComboBox<>();
        jComboBoxDistritoRN = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRegistroRN = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jCTextFieldBuscarRN = new ControlSwing.JCTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jCTextFieldNombreApoRN = new ControlSwing.JCTextField();
        jCTextFieldApellidoApoRN = new ControlSwing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jCTextFieldDNIApoRN = new ControlSwing.JCTextField();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxGeneroApoRN = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jCTextFieldDireccionApoRN = new ControlSwing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        jDateChooserFechaNacApoRN = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        jCButtonGuardarRN = new ControlSwing.JCButton();
        jCButtonEditarRN = new ControlSwing.JCButton();
        jCButtonCancelarRN = new ControlSwing.JCButton();
        jCButtonSalirRN = new ControlSwing.JCButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jCTextFieldBuscarRN1 = new ControlSwing.JCTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableApoderadoRN = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxApoderadoRN = new javax.swing.JComboBox<>();
        jCButtonAgregarRN = new ControlSwing.JCButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jCTextFieldNombreHRM = new ControlSwing.JCTextField();
        jCTextFieldApellidoHRM = new ControlSwing.JCTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jCTextFieldDNIHRM = new ControlSwing.JCTextField();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxGeneroHRM = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jCTextFieldDireccionHRM = new ControlSwing.JCTextField();
        jLabel27 = new javax.swing.JLabel();
        jDateChooserFechaNacHRM = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        timeChooserHoraNacHRM = new org.bolivia.time.TimeChooser();
        jPanel11 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jCTextFieldNombreMRM = new ControlSwing.JCTextField();
        jCTextFieldApellidoMRM = new ControlSwing.JCTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jCTextFieldDNIMRM = new ControlSwing.JCTextField();
        jLabel32 = new javax.swing.JLabel();
        jComboBoxGeneroMRM = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jCTextFieldDireccionMRM = new ControlSwing.JCTextField();
        jLabel34 = new javax.swing.JLabel();
        jDateChooserFechaNacMRM = new com.toedter.calendar.JDateChooser();
        jLabel35 = new javax.swing.JLabel();
        timeChooserHoraNacMRM = new org.bolivia.time.TimeChooser();
        jPanel12 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jComboBoxTipoRegRM = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jCTextFieldNactaRM = new ControlSwing.JCTextField();
        jLabel38 = new javax.swing.JLabel();
        jComboBoxDepartamentoRM = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jComboBoxProvinciaRM = new javax.swing.JComboBox<>();
        jComboBoxDistritoRM = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jCButtonFechaImportanteRM = new ControlSwing.JCButton();
        jPanel17 = new javax.swing.JPanel();
        jCButtonGuardarRM = new ControlSwing.JCButton();
        jCButtonEditarRM = new ControlSwing.JCButton();
        jCButtonCancelarRM = new ControlSwing.JCButton();
        jCButtonSalirRM = new ControlSwing.JCButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableRegistroRM = new javax.swing.JTable();
        jLabel79 = new javax.swing.JLabel();
        jCTextFieldBuscarRM = new ControlSwing.JCTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jCButtonGuardarRD = new ControlSwing.JCButton();
        jCButtonEditarRD = new ControlSwing.JCButton();
        jCButtonCancelarRD = new ControlSwing.JCButton();
        jCButtonSalirRD = new ControlSwing.JCButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jCTextFieldBuscarRD1 = new ControlSwing.JCTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableApoderadoRD = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jComboBoxApoderadoRD = new javax.swing.JComboBox<>();
        jCButtonAgregarRD = new ControlSwing.JCButton();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableRegistroRD = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jCTextFieldBuscarRD = new ControlSwing.JCTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jCTextFieldNombresRD = new ControlSwing.JCTextField();
        jCTextFieldApellidosRD = new ControlSwing.JCTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jCTextFieldDNIRD = new ControlSwing.JCTextField();
        jLabel47 = new javax.swing.JLabel();
        jComboBoxGeneroRD = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        jCTextFieldDireccionRD = new ControlSwing.JCTextField();
        jLabel49 = new javax.swing.JLabel();
        jDateChooserFechaNacimientoRD = new com.toedter.calendar.JDateChooser();
        jLabel50 = new javax.swing.JLabel();
        timeChooserHoraNacimientoRD = new org.bolivia.time.TimeChooser();
        jPanel16 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jComboBoxTipoRegistroRD = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        jCTextFieldNactaRD = new ControlSwing.JCTextField();
        jLabel53 = new javax.swing.JLabel();
        jComboBoxDepartamentoRD = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jComboBoxProvinciaRD = new javax.swing.JComboBox<>();
        jComboBoxDistritoRD = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();
        jCButtonFechaImportanteRD = new ControlSwing.JCButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jCTextFieldNombreApoRD = new ControlSwing.JCTextField();
        jCTextFieldApellidoApoRD = new ControlSwing.JCTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jCTextFieldDNIApoRD = new ControlSwing.JCTextField();
        jLabel59 = new javax.swing.JLabel();
        jComboBoxGeneroApoRD = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        jCTextFieldDireccionApoRD = new ControlSwing.JCTextField();
        jLabel61 = new javax.swing.JLabel();
        jDateChooserFechaNacApoRD = new com.toedter.calendar.JDateChooser();

        jMenuItemModificarRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenuItemModificarRN.setText("Modificar");
        jMenuItemModificarRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarRNActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemModificarRN);

        jMenuItemModificarApoRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenuItemModificarApoRN.setText("Modificar");
        jMenuItemModificarApoRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarApoRNActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItemModificarApoRN);

        jMenuItemEliminarApoRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        jMenuItemEliminarApoRN.setText("Eliminar");
        jMenuItemEliminarApoRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarApoRNActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItemEliminarApoRN);

        jMenuItemModificarRM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenuItemModificarRM.setText("Modificar");
        jMenuItemModificarRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarRMActionPerformed(evt);
            }
        });
        jPopupMenu3.add(jMenuItemModificarRM);

        jMenuItemModificarFecRM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenuItemModificarFecRM.setText("Modificar Fec. Matrimonio");
        jMenuItemModificarFecRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarFecRMActionPerformed(evt);
            }
        });
        jPopupMenu3.add(jMenuItemModificarFecRM);

        jMenuItemModificarRD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenuItemModificarRD.setText("Modificar");
        jMenuItemModificarRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarRDActionPerformed(evt);
            }
        });
        jPopupMenu4.add(jMenuItemModificarRD);

        jMenuItemModificarFecRD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenuItemModificarFecRD.setText("Modificar Fec. Defunción");
        jMenuItemModificarFecRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarFecRDActionPerformed(evt);
            }
        });
        jPopupMenu4.add(jMenuItemModificarFecRD);

        jMenuItemModificarApoRD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenuItemModificarApoRD.setText("Modificar");
        jMenuItemModificarApoRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarApoRDActionPerformed(evt);
            }
        });
        jPopupMenu5.add(jMenuItemModificarApoRD);

        jMenuItemEliminarApoRD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        jMenuItemEliminarApoRD.setText("Eliminar");
        jMenuItemEliminarApoRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarApoRDActionPerformed(evt);
            }
        });
        jPopupMenu5.add(jMenuItemEliminarApoRD);

        setTitle("MANTENIMIENTO DE REGISTROS");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS DEL TITULAR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nombres*");

        jCTextFieldNombresRN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldNombresRN.setPlaceholder("Ingrese sus nombres completos");
        jCTextFieldNombresRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldNombresRNActionPerformed(evt);
            }
        });
        jCTextFieldNombresRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldNombresRNKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldNombresRNKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldNombresRNKeyTyped(evt);
            }
        });

        jCTextFieldApellidosRN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldApellidosRN.setPlaceholder("Ingrese sus apellidos completos");
        jCTextFieldApellidosRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldApellidosRNActionPerformed(evt);
            }
        });
        jCTextFieldApellidosRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidosRNKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidosRNKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidosRNKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Apellidos*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("DNI*");

        jCTextFieldDNIRN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDNIRN.setPlaceholder("Ingrese su DNI");
        jCTextFieldDNIRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDNIRNActionPerformed(evt);
            }
        });
        jCTextFieldDNIRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIRNKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIRNKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Género*");

        jComboBoxGeneroRN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "FEMENINO", "MASCULINO" }));
        jComboBoxGeneroRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxGeneroRNKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Dirección*");

        jCTextFieldDireccionRN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDireccionRN.setPlaceholder("Ingrese su dirección");
        jCTextFieldDireccionRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDireccionRNActionPerformed(evt);
            }
        });
        jCTextFieldDireccionRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionRNKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionRNKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionRNKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Fec. Nac*");

        jDateChooserFechaNacimientoRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserFechaNacimientoRNKeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Hor. Nac.*");

        timeChooserHoraNacimientoRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timeChooserHoraNacimientoRNKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCTextFieldNombresRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCTextFieldApellidosRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCTextFieldDNIRN, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jDateChooserFechaNacimientoRN, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxGeneroRN, 0, 114, Short.MAX_VALUE)
                                    .addComponent(timeChooserHoraNacimientoRN, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldDireccionRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCTextFieldNombresRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCTextFieldApellidosRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCTextFieldDNIRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGeneroRN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooserFechaNacimientoRN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timeChooserHoraNacimientoRN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCTextFieldDireccionRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS DEL REGISTRO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tipo registro*");

        jComboBoxTipoRegistroRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxTipoRegistroRNKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("N° Acta/Part.*");

        jCTextFieldNactaRN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldNactaRN.setPlaceholder("Ingrese su usuario");
        jCTextFieldNactaRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldNactaRNActionPerformed(evt);
            }
        });
        jCTextFieldNactaRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldNactaRNKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldNactaRNKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldNactaRNKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Departamento*");

        jComboBoxDepartamentoRN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        jComboBoxDepartamentoRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentoRNActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Provincia*");

        jComboBoxProvinciaRN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        jComboBoxProvinciaRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProvinciaRNActionPerformed(evt);
            }
        });

        jComboBoxDistritoRN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        jComboBoxDistritoRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxDistritoRNKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Distrito*");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCTextFieldNactaRN, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(jComboBoxTipoRegistroRN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDepartamentoRN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxProvinciaRN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxDistritoRN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoRegistroRN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCTextFieldNactaRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDepartamentoRN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProvinciaRN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDistritoRN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "LISTA DE REGISTRO DE NACIMIENTOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jTableRegistroRN.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableRegistroRN.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTableRegistroRN);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Buscar");

        jCTextFieldBuscarRN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldBuscarRN.setPlaceholder("Ingrese un dato para buscar");
        jCTextFieldBuscarRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldBuscarRNActionPerformed(evt);
            }
        });
        jCTextFieldBuscarRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscarRNKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscarRNKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldBuscarRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCTextFieldBuscarRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS DEL DECLARANTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Nombres*");

        jCTextFieldNombreApoRN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldNombreApoRN.setPlaceholder("Ingrese sus nombres completos");
        jCTextFieldNombreApoRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldNombreApoRNActionPerformed(evt);
            }
        });
        jCTextFieldNombreApoRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldNombreApoRNKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldNombreApoRNKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldNombreApoRNKeyTyped(evt);
            }
        });

        jCTextFieldApellidoApoRN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldApellidoApoRN.setPlaceholder("Ingrese sus apellidos completos");
        jCTextFieldApellidoApoRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldApellidoApoRNActionPerformed(evt);
            }
        });
        jCTextFieldApellidoApoRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidoApoRNKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidoApoRNKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidoApoRNKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Apellidos*");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("DNI*");

        jCTextFieldDNIApoRN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDNIApoRN.setPlaceholder("Ingrese su DNI");
        jCTextFieldDNIApoRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDNIApoRNActionPerformed(evt);
            }
        });
        jCTextFieldDNIApoRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIApoRNKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIApoRNKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Género*");

        jComboBoxGeneroApoRN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "FEMENINO", "MASCULINO" }));
        jComboBoxGeneroApoRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxGeneroApoRNKeyPressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Dirección*");

        jCTextFieldDireccionApoRN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDireccionApoRN.setPlaceholder("Ingrese su dirección");
        jCTextFieldDireccionApoRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDireccionApoRNActionPerformed(evt);
            }
        });
        jCTextFieldDireccionApoRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionApoRNKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionApoRNKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionApoRNKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Fec. Nac.");

        jDateChooserFechaNacApoRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserFechaNacApoRNKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCTextFieldDNIApoRN, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jDateChooserFechaNacApoRN, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxGeneroApoRN, 0, 113, Short.MAX_VALUE))
                            .addComponent(jCTextFieldApellidoApoRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCTextFieldNombreApoRN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldDireccionApoRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCTextFieldNombreApoRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jCTextFieldApellidoApoRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jCTextFieldDNIApoRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGeneroApoRN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooserFechaNacApoRN, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jCTextFieldDireccionApoRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "CONTROLES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jCButtonGuardarRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar.png"))); // NOI18N
        jCButtonGuardarRN.setText("Guardar");
        jCButtonGuardarRN.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jCButtonGuardarRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonGuardarRNActionPerformed(evt);
            }
        });

        jCButtonEditarRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar.png"))); // NOI18N
        jCButtonEditarRN.setText("Editar");
        jCButtonEditarRN.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jCButtonEditarRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonEditarRNActionPerformed(evt);
            }
        });

        jCButtonCancelarRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jCButtonCancelarRN.setText("Cancelar");
        jCButtonCancelarRN.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jCButtonCancelarRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonCancelarRNActionPerformed(evt);
            }
        });

        jCButtonSalirRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jCButtonSalirRN.setText("Salir");
        jCButtonSalirRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonSalirRNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCButtonEditarRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonCancelarRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonSalirRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonGuardarRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCButtonGuardarRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCButtonEditarRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCButtonCancelarRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCButtonSalirRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "LISTA DE DECLARANTES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("Buscar");

        jCTextFieldBuscarRN1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldBuscarRN1.setPlaceholder("Ingrese un dato para buscar");
        jCTextFieldBuscarRN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldBuscarRN1ActionPerformed(evt);
            }
        });
        jCTextFieldBuscarRN1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscarRN1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscarRN1KeyTyped(evt);
            }
        });

        jTableApoderadoRN.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableApoderadoRN.setComponentPopupMenu(jPopupMenu2);
        jScrollPane2.setViewportView(jTableApoderadoRN);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Declarante*");

        jComboBoxApoderadoRN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));

        jCButtonAgregarRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar.png"))); // NOI18N
        jCButtonAgregarRN.setText("Agregar");
        jCButtonAgregarRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonAgregarRNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldBuscarRN1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxApoderadoRN, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jCButtonAgregarRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxApoderadoRN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCButtonAgregarRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCTextFieldBuscarRN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REGISTRO DE NACIMIENTO", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS DEL ESPOSO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Nombres*");

        jCTextFieldNombreHRM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldNombreHRM.setPlaceholder("Ingrese sus nombres completos");
        jCTextFieldNombreHRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldNombreHRMActionPerformed(evt);
            }
        });
        jCTextFieldNombreHRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldNombreHRMKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldNombreHRMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldNombreHRMKeyTyped(evt);
            }
        });

        jCTextFieldApellidoHRM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldApellidoHRM.setPlaceholder("Ingrese sus apellidos completos");
        jCTextFieldApellidoHRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldApellidoHRMActionPerformed(evt);
            }
        });
        jCTextFieldApellidoHRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidoHRMKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidoHRMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidoHRMKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Apellidos*");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("DNI*");

        jCTextFieldDNIHRM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDNIHRM.setPlaceholder("Ingrese su DNI");
        jCTextFieldDNIHRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDNIHRMActionPerformed(evt);
            }
        });
        jCTextFieldDNIHRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIHRMKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIHRMKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Género*");

        jComboBoxGeneroHRM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO" }));
        jComboBoxGeneroHRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxGeneroHRMKeyPressed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Dirección*");

        jCTextFieldDireccionHRM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDireccionHRM.setPlaceholder("Ingrese su dirección");
        jCTextFieldDireccionHRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDireccionHRMActionPerformed(evt);
            }
        });
        jCTextFieldDireccionHRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionHRMKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionHRMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionHRMKeyTyped(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Fec. Nac*");

        jDateChooserFechaNacHRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserFechaNacHRMKeyPressed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Hor. Nac");

        timeChooserHoraNacHRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timeChooserHoraNacHRMKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCTextFieldNombreHRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCTextFieldApellidoHRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCTextFieldDNIHRM, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jDateChooserFechaNacHRM, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxGeneroHRM, 0, 114, Short.MAX_VALUE)
                                    .addComponent(timeChooserHoraNacHRM, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldDireccionHRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jCTextFieldNombreHRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jCTextFieldApellidoHRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jCTextFieldDNIHRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGeneroHRM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserFechaNacHRM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timeChooserHoraNacHRM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28))
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jCTextFieldDireccionHRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS DE LA ESPOSA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Nombres*");

        jCTextFieldNombreMRM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldNombreMRM.setPlaceholder("Ingrese sus nombres completos");
        jCTextFieldNombreMRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldNombreMRMActionPerformed(evt);
            }
        });
        jCTextFieldNombreMRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldNombreMRMKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldNombreMRMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldNombreMRMKeyTyped(evt);
            }
        });

        jCTextFieldApellidoMRM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldApellidoMRM.setPlaceholder("Ingrese sus apellidos completos");
        jCTextFieldApellidoMRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldApellidoMRMActionPerformed(evt);
            }
        });
        jCTextFieldApellidoMRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidoMRMKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidoMRMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidoMRMKeyTyped(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Apellidos*");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("DNI*");

        jCTextFieldDNIMRM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDNIMRM.setPlaceholder("Ingrese su DNI");
        jCTextFieldDNIMRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDNIMRMActionPerformed(evt);
            }
        });
        jCTextFieldDNIMRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIMRMKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIMRMKeyTyped(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Género*");

        jComboBoxGeneroMRM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEMENINO" }));
        jComboBoxGeneroMRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxGeneroMRMKeyPressed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Dirección*");

        jCTextFieldDireccionMRM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDireccionMRM.setPlaceholder("Ingrese su dirección");
        jCTextFieldDireccionMRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDireccionMRMActionPerformed(evt);
            }
        });
        jCTextFieldDireccionMRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionMRMKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionMRMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionMRMKeyTyped(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Fec. Nac.*");

        jDateChooserFechaNacMRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserFechaNacMRMKeyPressed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("Hor. Nac");

        timeChooserHoraNacMRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timeChooserHoraNacMRMKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel29)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCTextFieldNombreMRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCTextFieldApellidoMRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCTextFieldDNIMRM, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jDateChooserFechaNacMRM, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel32)
                                        .addGap(11, 11, 11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxGeneroMRM, 0, 114, Short.MAX_VALUE)
                                    .addComponent(timeChooserHoraNacMRM, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldDireccionMRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jCTextFieldNombreMRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jCTextFieldApellidoMRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jCTextFieldDNIMRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGeneroMRM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserFechaNacMRM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timeChooserHoraNacMRM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35))
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jCTextFieldDireccionMRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS DEL REGISTRO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("Tipo registro*");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("N° Acta*");

        jCTextFieldNactaRM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldNactaRM.setPlaceholder("Ingrese su usuario");
        jCTextFieldNactaRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldNactaRMActionPerformed(evt);
            }
        });
        jCTextFieldNactaRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldNactaRMKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldNactaRMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldNactaRMKeyTyped(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setText("Departamento*");

        jComboBoxDepartamentoRM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        jComboBoxDepartamentoRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentoRMActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setText("Provincia*");

        jComboBoxProvinciaRM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        jComboBoxProvinciaRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProvinciaRMActionPerformed(evt);
            }
        });

        jComboBoxDistritoRM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Distrito*");

        jCButtonFechaImportanteRM.setText("...");
        jCButtonFechaImportanteRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonFechaImportanteRMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTipoRegRM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jCTextFieldNactaRM, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCButtonFechaImportanteRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel38))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel39)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel40)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDepartamentoRM, 0, 225, Short.MAX_VALUE)
                            .addComponent(jComboBoxProvinciaRM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxDistritoRM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoRegRM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCButtonFechaImportanteRM, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(jCTextFieldNactaRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDepartamentoRM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProvinciaRM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDistritoRM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "CONTROLES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jCButtonGuardarRM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar.png"))); // NOI18N
        jCButtonGuardarRM.setText("Guardar");
        jCButtonGuardarRM.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jCButtonGuardarRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonGuardarRMActionPerformed(evt);
            }
        });

        jCButtonEditarRM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar.png"))); // NOI18N
        jCButtonEditarRM.setText("Editar");
        jCButtonEditarRM.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jCButtonEditarRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonEditarRMActionPerformed(evt);
            }
        });

        jCButtonCancelarRM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jCButtonCancelarRM.setText("Cancelar");
        jCButtonCancelarRM.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jCButtonCancelarRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonCancelarRMActionPerformed(evt);
            }
        });

        jCButtonSalirRM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jCButtonSalirRM.setText("Salir");
        jCButtonSalirRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonSalirRMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCButtonCancelarRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonEditarRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonGuardarRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonSalirRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCButtonGuardarRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCButtonEditarRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCButtonCancelarRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCButtonSalirRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3), "LISTADO DE REGISTROS DE MATRIMONIOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jTableRegistroRM.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableRegistroRM.setComponentPopupMenu(jPopupMenu3);
        jScrollPane3.setViewportView(jTableRegistroRM);

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel79.setText("Buscar");

        jCTextFieldBuscarRM.setPlaceholder("Ingrese un dato para buscar");
        jCTextFieldBuscarRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscarRMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscarRMKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCTextFieldBuscarRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jCTextFieldBuscarRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REGISTRO DE MATRIMONIO", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "CONTROLES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jCButtonGuardarRD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar.png"))); // NOI18N
        jCButtonGuardarRD.setText("Guardar");
        jCButtonGuardarRD.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jCButtonGuardarRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonGuardarRDActionPerformed(evt);
            }
        });

        jCButtonEditarRD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar.png"))); // NOI18N
        jCButtonEditarRD.setText("Editar");
        jCButtonEditarRD.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jCButtonEditarRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonEditarRDActionPerformed(evt);
            }
        });

        jCButtonCancelarRD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jCButtonCancelarRD.setText("Cancelar");
        jCButtonCancelarRD.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jCButtonCancelarRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonCancelarRDActionPerformed(evt);
            }
        });

        jCButtonSalirRD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jCButtonSalirRD.setText("Salir");
        jCButtonSalirRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonSalirRDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCButtonCancelarRD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonEditarRD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonGuardarRD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCButtonSalirRD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCButtonGuardarRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCButtonEditarRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCButtonCancelarRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCButtonSalirRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "LISTA DE DECLARANTES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("Buscar");

        jCTextFieldBuscarRD1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldBuscarRD1.setPlaceholder("Ingrese un dato para buscar");
        jCTextFieldBuscarRD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldBuscarRD1ActionPerformed(evt);
            }
        });
        jCTextFieldBuscarRD1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscarRD1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscarRD1KeyTyped(evt);
            }
        });

        jTableApoderadoRD.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableApoderadoRD.setComponentPopupMenu(jPopupMenu5);
        jScrollPane5.setViewportView(jTableApoderadoRD);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Declarante*");

        jComboBoxApoderadoRD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));

        jCButtonAgregarRD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar.png"))); // NOI18N
        jCButtonAgregarRD.setText("Agregar");
        jCButtonAgregarRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonAgregarRDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldBuscarRD1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxApoderadoRD, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jCButtonAgregarRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxApoderadoRD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCButtonAgregarRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCTextFieldBuscarRD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "LISTA DE REGISTRO DE DEFUNCIONES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jTableRegistroRD.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableRegistroRD.setComponentPopupMenu(jPopupMenu4);
        jScrollPane7.setViewportView(jTableRegistroRD);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Buscar");

        jCTextFieldBuscarRD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldBuscarRD.setPlaceholder("Ingrese un dato para buscar");
        jCTextFieldBuscarRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldBuscarRDActionPerformed(evt);
            }
        });
        jCTextFieldBuscarRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscarRDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldBuscarRDKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldBuscarRD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jCTextFieldBuscarRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS DEL TITULAR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setText("Nombres*");

        jCTextFieldNombresRD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldNombresRD.setPlaceholder("Ingrese sus nombres completos");
        jCTextFieldNombresRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldNombresRDActionPerformed(evt);
            }
        });
        jCTextFieldNombresRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldNombresRDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldNombresRDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldNombresRDKeyTyped(evt);
            }
        });

        jCTextFieldApellidosRD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldApellidosRD.setPlaceholder("Ingrese sus apellidos completos");
        jCTextFieldApellidosRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldApellidosRDActionPerformed(evt);
            }
        });
        jCTextFieldApellidosRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidosRDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidosRDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidosRDKeyTyped(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("Apellidos*");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("DNI*");

        jCTextFieldDNIRD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDNIRD.setPlaceholder("Ingrese su DNI");
        jCTextFieldDNIRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDNIRDActionPerformed(evt);
            }
        });
        jCTextFieldDNIRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIRDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIRDKeyTyped(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("Género*");

        jComboBoxGeneroRD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "FEMENINO", "MASCULINO" }));
        jComboBoxGeneroRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxGeneroRDKeyPressed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("Dirección*");

        jCTextFieldDireccionRD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDireccionRD.setPlaceholder("Ingrese su dirección");
        jCTextFieldDireccionRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDireccionRDActionPerformed(evt);
            }
        });
        jCTextFieldDireccionRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionRDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionRDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionRDKeyTyped(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setText("Fec. Nac.*");

        jDateChooserFechaNacimientoRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserFechaNacimientoRDKeyPressed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setText("Hor. Nac");

        timeChooserHoraNacimientoRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timeChooserHoraNacimientoRDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel44)
                            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCTextFieldNombresRD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCTextFieldApellidosRD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCTextFieldDNIRD, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jDateChooserFechaNacimientoRD, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel47)
                                        .addGap(11, 11, 11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel50)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxGeneroRD, 0, 114, Short.MAX_VALUE)
                                    .addComponent(timeChooserHoraNacimientoRD, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldDireccionRD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jCTextFieldNombresRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jCTextFieldApellidosRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jCTextFieldDNIRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGeneroRD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooserFechaNacimientoRD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timeChooserHoraNacimientoRD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel50))
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jCTextFieldDireccionRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS DEL REGISTRO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setText("Tipo registro*");

        jComboBoxTipoRegistroRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxTipoRegistroRDKeyPressed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setText("N° Acta/Part.*");

        jCTextFieldNactaRD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldNactaRD.setPlaceholder("Ingrese su usuario");
        jCTextFieldNactaRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldNactaRDActionPerformed(evt);
            }
        });
        jCTextFieldNactaRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldNactaRDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldNactaRDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldNactaRDKeyTyped(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel53.setText("Departamento*");

        jComboBoxDepartamentoRD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        jComboBoxDepartamentoRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentoRDActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setText("Provincia*");

        jComboBoxProvinciaRD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        jComboBoxProvinciaRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProvinciaRDActionPerformed(evt);
            }
        });

        jComboBoxDistritoRD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --" }));
        jComboBoxDistritoRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxDistritoRDKeyPressed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel55.setText("Distrito*");

        jCButtonFechaImportanteRD.setText("...");
        jCButtonFechaImportanteRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCButtonFechaImportanteRDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel51))
                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTipoRegistroRD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jCTextFieldNactaRD, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCButtonFechaImportanteRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel54))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel55))
                            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxProvinciaRD, javax.swing.GroupLayout.Alignment.TRAILING, 0, 215, Short.MAX_VALUE)
                            .addComponent(jComboBoxDepartamentoRD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxDistritoRD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoRegistroRD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jCTextFieldNactaRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCButtonFechaImportanteRD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDepartamentoRD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProvinciaRD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDistritoRD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3), "DATOS DEL DECLARANTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setText("Nombres*");

        jCTextFieldNombreApoRD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldNombreApoRD.setPlaceholder("Ingrese sus nombres completos");
        jCTextFieldNombreApoRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldNombreApoRDActionPerformed(evt);
            }
        });
        jCTextFieldNombreApoRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldNombreApoRDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldNombreApoRDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldNombreApoRDKeyTyped(evt);
            }
        });

        jCTextFieldApellidoApoRD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldApellidoApoRD.setPlaceholder("Ingrese sus apellidos completos");
        jCTextFieldApellidoApoRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldApellidoApoRDActionPerformed(evt);
            }
        });
        jCTextFieldApellidoApoRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidoApoRDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidoApoRDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldApellidoApoRDKeyTyped(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setText("Apellidos*");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setText("DNI*");

        jCTextFieldDNIApoRD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDNIApoRD.setPlaceholder("Ingrese su DNI");
        jCTextFieldDNIApoRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDNIApoRDActionPerformed(evt);
            }
        });
        jCTextFieldDNIApoRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIApoRDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDNIApoRDKeyTyped(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setText("Género*");

        jComboBoxGeneroApoRD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "FEMENINO", "MASCULINO" }));
        jComboBoxGeneroApoRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxGeneroApoRDKeyPressed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel60.setText("Dirección*");

        jCTextFieldDireccionApoRD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTextFieldDireccionApoRD.setPlaceholder("Ingrese su dirección");
        jCTextFieldDireccionApoRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextFieldDireccionApoRDActionPerformed(evt);
            }
        });
        jCTextFieldDireccionApoRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionApoRDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionApoRDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCTextFieldDireccionApoRDKeyTyped(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel61.setText("Fec. Nac.");

        jDateChooserFechaNacApoRD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserFechaNacApoRDKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57)
                            .addComponent(jLabel56)
                            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCTextFieldDNIApoRD, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jDateChooserFechaNacApoRD, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxGeneroApoRD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jCTextFieldApellidoApoRD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCTextFieldNombreApoRD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTextFieldDireccionApoRD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jCTextFieldNombreApoRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jCTextFieldApellidoApoRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jCTextFieldDNIApoRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGeneroApoRD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooserFechaNacApoRD, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jCTextFieldDireccionApoRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("REGISTRO DE DEFUNCIÓN", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jCTextFieldNombresRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldNombresRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldNombresRNActionPerformed

    private void jCTextFieldApellidosRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldApellidosRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldApellidosRNActionPerformed

    private void jCTextFieldDNIRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDNIRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDNIRNActionPerformed

    private void jCTextFieldDireccionRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDireccionRNActionPerformed

    private void jCTextFieldNactaRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldNactaRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldNactaRNActionPerformed

    private void jCTextFieldBuscarRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldBuscarRNActionPerformed

    private void jCTextFieldNombreApoRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldNombreApoRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldNombreApoRNActionPerformed

    private void jCTextFieldApellidoApoRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoApoRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldApellidoApoRNActionPerformed

    private void jCTextFieldDNIApoRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDNIApoRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDNIApoRNActionPerformed

    private void jCTextFieldDireccionApoRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionApoRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDireccionApoRNActionPerformed

    private void jCButtonSalirRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonSalirRNActionPerformed
        // TODO add your handling code here:
        mensaje.cerrarVentanaSinConfirmarJI(this);
    }//GEN-LAST:event_jCButtonSalirRNActionPerformed

    private void jCTextFieldNombreHRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldNombreHRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldNombreHRMActionPerformed

    private void jCTextFieldApellidoHRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoHRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldApellidoHRMActionPerformed

    private void jCTextFieldDNIHRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDNIHRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDNIHRMActionPerformed

    private void jCTextFieldDireccionHRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionHRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDireccionHRMActionPerformed

    private void jCTextFieldNombreMRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldNombreMRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldNombreMRMActionPerformed

    private void jCTextFieldApellidoMRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoMRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldApellidoMRMActionPerformed

    private void jCTextFieldDNIMRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDNIMRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDNIMRMActionPerformed

    private void jCTextFieldDireccionMRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionMRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDireccionMRMActionPerformed

    private void jCTextFieldNactaRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldNactaRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldNactaRMActionPerformed

    private void jCButtonSalirRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonSalirRMActionPerformed
        // TODO add your handling code here:
        mensaje.cerrarVentanaSinConfirmarJI(this);
    }//GEN-LAST:event_jCButtonSalirRMActionPerformed

    private void jCButtonSalirRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonSalirRDActionPerformed
        // TODO add your handling code here:
        mensaje.cerrarVentanaSinConfirmarJI(this);
    }//GEN-LAST:event_jCButtonSalirRDActionPerformed

    private void jCButtonGuardarRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonGuardarRNActionPerformed
        // TODO add your handling code here:
        if (validarCamposRN()) {
            if (verificarReg(jCTextFieldDNIRN, jComboBoxTipoRegistroRN)) {
                if (controlador.oneAttribRepeat("registro", "num_acta", jCTextFieldNactaRN.getText())) {
                    mensaje.mensajeError("Ya existe un registro con número de acta ingresado.");
                    jCTextFieldNactaRN.requestFocus();
                } else {
                    insertarRegistroRN();
                    insertarApoderadoRN();
                    cargarTablaRN();
                    limpiarCamposRN();
                    limpiarCamposRNA();
                    estadoCamposRN(true);
                    tabla.LimpiarTabla(modeloRNA);
                    jCButtonCancelarRN.setEnabled(false);
                    jCTextFieldNombresRN.requestFocus();
                }
            } else {
                jCTextFieldDNIRN.requestFocus();
            }
        }
    }//GEN-LAST:event_jCButtonGuardarRNActionPerformed

    private void jComboBoxDepartamentoRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentoRNActionPerformed
        // TODO add your handling code here:
        if (jComboBoxDepartamentoRN.getSelectedIndex() >= 0) {
            llenarProvinciaRN();
        }
    }//GEN-LAST:event_jComboBoxDepartamentoRNActionPerformed

    private void jComboBoxProvinciaRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProvinciaRNActionPerformed
        // TODO add your handling code here:
        if (jComboBoxProvinciaRN.getSelectedIndex() >= 0) {
            llenarDistritoRN();
        }
    }//GEN-LAST:event_jComboBoxProvinciaRNActionPerformed

    private void jCButtonAgregarRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonAgregarRNActionPerformed
        // TODO add your handling code here:
        if (jTableApoderadoRN.getRowCount() < 3) {
            if (!verificarExisteDNI(jTableApoderadoRN, jCTextFieldDNIApoRN)) {
                if (!verificarExisteApo(jTableApoderadoRN, jComboBoxApoderadoRN)) {
//                    if (!verificarExisteGenero(jTableApoderadoRN, jComboBoxGeneroApoRN)) {
                    if (validarCamposRNA()) {
                        String validargenero = consulta.devolverDato("select genero from apoderado where nom_apo=", jComboBoxApoderadoRN.getSelectedItem().toString(), 1);
                        if (jComboBoxGeneroApoRN.getSelectedItem().toString().equals(validargenero)) {
                            Object[] object = new Object[7];
                            object[0] = jCTextFieldDNIApoRN.getText();
                            object[1] = jCTextFieldNombreApoRN.getText();
                            object[2] = jCTextFieldApellidoApoRN.getText();
                            object[3] = jComboBoxGeneroApoRN.getSelectedItem().toString();
                            object[4] = jCTextFieldDireccionApoRN.getText();
                            if (jDateChooserFechaNacApoRN.getDate() != null) {
                                object[5] = fecha.Formato_AMD(jDateChooserFechaNacApoRN.getDate());
                            } else {
                                object[5] = "";
                            }
                            object[6] = jComboBoxApoderadoRN.getSelectedItem().toString();
                            modeloRNA.addRow(object);
                            limpiarCamposRNA();
                            jCTextFieldNombreApoRN.requestFocus();
                        } else {
                            mensaje.mensajeError("El género del declarante es inconsistente.");
                            jComboBoxGeneroApoRN.requestFocus();
                        }
                    }
//                    } else {
//                        mensaje.mensajeError("El registro con el género seleccionado ya existe.");
//                        jComboBoxGeneroApoRN.requestFocus();
//                    }
                } else {
                    mensaje.mensajeError("El registro con el declarante seleccionado ya existe.");
                    jComboBoxApoderadoRN.requestFocus();
                }
            } else {
                mensaje.mensajeError("El registro con el DNI ingresado ya existe.");
                jCTextFieldDNIApoRN.requestFocus();
            }
        } else {
            mensaje.mensajeError("No puede ingresar más de dos registros.");
        }

    }//GEN-LAST:event_jCButtonAgregarRNActionPerformed

    private void jMenuItemEliminarApoRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarApoRNActionPerformed
        // TODO add your handling code here:
        if (jTableApoderadoRN.getSelectedRow() >= 0) {
            if (mensaje.mensajeConsulta("Estás seguro de eliminar el registro?") == JOptionPane.YES_NO_OPTION) {
                String dn = modeloRNA.getValueAt(jTableApoderadoRN.getSelectedRow(), 0).toString();
                String exi_dni = consulta.devolverDato("select p.dni from detregistro dr, persona p where p.idpersona=dr.idpersona and p.dni=", dn, 1);
                if (exi_dni.length() != 0) {
                    mensaje.mensajeInformacion("se va eliminar desde la BD");
                    String que1 = "CALL deleteAntiguosApoRN("
                            + "'" + exi_dni + "'"
                            + " );";
                    consulta.Consulta(que1);
                    //Para poder eliminar el residuo que queda en la tabla
                    tabla.eliminarFilaTabla(jTableApoderadoRN, modeloRNA);
                    jCTextFieldNombreApoRN.requestFocus();
                } else {
                    tabla.eliminarFilaTabla(jTableApoderadoRN, modeloRNA);
                }
            } else {
                mensaje.mensajeInformacion("No se elimino ningún registro.");
            }
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para eliminar.");
        }
    }//GEN-LAST:event_jMenuItemEliminarApoRNActionPerformed

    private void jCButtonCancelarRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonCancelarRNActionPerformed
        // TODO add your handling code here:
        limpiarCamposRN();
        tabla.LimpiarTabla(modeloRNA);
        estadoCamposRN(true);
        estadoBotonesRN(false);
        jCButtonCancelarRN.setEnabled(true);
        jCButtonGuardarRN.setEnabled(true);
        jCTextFieldNombresRN.requestFocus();
    }//GEN-LAST:event_jCButtonCancelarRNActionPerformed

    private void jCButtonEditarRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonEditarRNActionPerformed
        // TODO add your handling code here:
        if (jTableRegistroRN.getSelectedRow() >= 0) {
            if (mensaje.mensajeConsulta("Realmente desea actualizar el registro?") == JOptionPane.YES_NO_OPTION) {
                editarRegistroRN();
                editarApoderadoRN();
                cargarTablaRN();
                limpiarCamposRN();
                limpiarCamposRNA();
                tabla.LimpiarTabla(modeloRNA);
                estadoCamposRN(true);
                estadoBotonesRN(false);
                jCButtonGuardarRN.setEnabled(true);
                jCTextFieldNombresRN.requestFocus();
            } else {
                mensaje.mensajeInformacion("No se actualizo ningún registro.");
            }
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para editar.");
        }
    }//GEN-LAST:event_jCButtonEditarRNActionPerformed

    private void jCTextFieldDNIRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIRNKeyPressed
        // TODO add your handling code here:
        if (jCTextFieldDNIRN.getText().trim().length() > 0) {
            if (evt.getKeyChar() == evt.VK_ENTER) {
                verificarDNI(evt, jCTextFieldDNIRN, jComboBoxGeneroRN, jCTextFieldApellidosRN, jCTextFieldNombresRN,
                        jCTextFieldDireccionRN, jComboBoxGeneroRN, jDateChooserFechaNacimientoRN, timeChooserHoraNacimientoRN,
                        jCTextFieldNactaRN);
            }
        }
    }//GEN-LAST:event_jCTextFieldDNIRNKeyPressed

    private void jCTextFieldDNIApoRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIApoRNKeyPressed
        // TODO add your handling code here:
        if (jCTextFieldDNIApoRN.getText().trim().length() > 0) {
            if (evt.getKeyChar() == evt.VK_ENTER) {
//                verificarDNI(evt, jCTextFieldDNIApoRN, jComboBoxGeneroApoRN);
                verificarDNI(evt, jCTextFieldDNIApoRN, jComboBoxGeneroApoRN, jCTextFieldApellidoApoRN, jCTextFieldNombreApoRN,
                        jCTextFieldDireccionApoRN, jComboBoxGeneroApoRN, jDateChooserFechaNacApoRN, timeChooserHoraNacimientoRN,
                        jCTextFieldDireccionApoRN);
            }
        }
    }//GEN-LAST:event_jCTextFieldDNIApoRNKeyPressed

    private void jCTextFieldNactaRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNactaRNKeyPressed
        // TODO add your handling code here:
        if (jCTextFieldNactaRN.getText().trim().length() > 0) {
            if (evt.getKeyChar() == evt.VK_ENTER) {
                verificarNumActa(evt, jCTextFieldNactaRN, jComboBoxDepartamentoRN);
            }
        }
    }//GEN-LAST:event_jCTextFieldNactaRNKeyPressed

    private void jCTextFieldBuscarRN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldBuscarRN1ActionPerformed

    private void jCTextFieldNombresRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombresRNKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldNombresRN, jCTextFieldApellidosRN);
    }//GEN-LAST:event_jCTextFieldNombresRNKeyPressed

    private void jCTextFieldApellidosRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidosRNKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldApellidosRN, jCTextFieldDNIRN);
    }//GEN-LAST:event_jCTextFieldApellidosRNKeyPressed

    private void jComboBoxGeneroRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxGeneroRNKeyPressed
        // TODO add your handling code here:
        evento.EnterJComboBox_A_JDateChosster(evt, jComboBoxGeneroRN, jDateChooserFechaNacimientoRN);
    }//GEN-LAST:event_jComboBoxGeneroRNKeyPressed

    private void jDateChooserFechaNacimientoRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFechaNacimientoRNKeyPressed
        // TODO add your handling code here:
        evento.EnterJDateChosster_A_JTexField(evt, jDateChooserFechaNacimientoRN, timeChooserHoraNacimientoRN);
    }//GEN-LAST:event_jDateChooserFechaNacimientoRNKeyPressed

    private void timeChooserHoraNacimientoRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeChooserHoraNacimientoRNKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, timeChooserHoraNacimientoRN, jCTextFieldDireccionRN);
    }//GEN-LAST:event_timeChooserHoraNacimientoRNKeyPressed

    private void jCTextFieldDireccionRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionRNKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldDireccionRN, jCTextFieldNactaRN);
    }//GEN-LAST:event_jCTextFieldDireccionRNKeyPressed

    private void jComboBoxTipoRegistroRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxTipoRegistroRNKeyPressed
        // TODO add your handling code here:
        evento.EnterJComboBox_A_JTexField(evt, jCTextFieldNactaRN);
    }//GEN-LAST:event_jComboBoxTipoRegistroRNKeyPressed

    private void jComboBoxDistritoRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxDistritoRNKeyPressed
        // TODO add your handling code here:
        evento.EnterJComboBox_A_JTexField(evt, jCTextFieldNombreApoRN);
    }//GEN-LAST:event_jComboBoxDistritoRNKeyPressed

    private void jCTextFieldNombreApoRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombreApoRNKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldNombreApoRN, jCTextFieldApellidoApoRN);
    }//GEN-LAST:event_jCTextFieldNombreApoRNKeyPressed

    private void jCTextFieldApellidoApoRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoApoRNKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldApellidoApoRN, jCTextFieldDNIApoRN);
    }//GEN-LAST:event_jCTextFieldApellidoApoRNKeyPressed

    private void jComboBoxGeneroApoRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxGeneroApoRNKeyPressed
        // TODO add your handling code here:
        evento.EnterJComboBox_A_JTexField(evt, jCTextFieldDireccionApoRN);
    }//GEN-LAST:event_jComboBoxGeneroApoRNKeyPressed

    private void jDateChooserFechaNacApoRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFechaNacApoRNKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jDateChooserFechaNacApoRNKeyPressed

    private void jCTextFieldDireccionApoRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionApoRNKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield_A_JComboBox(evt, jCTextFieldDireccionApoRN, jComboBoxApoderadoRN);
    }//GEN-LAST:event_jCTextFieldDireccionApoRNKeyPressed

    private void jCTextFieldNombresRNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombresRNKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldNombresRN);
    }//GEN-LAST:event_jCTextFieldNombresRNKeyReleased

    private void jCTextFieldApellidosRNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidosRNKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldApellidosRN);
    }//GEN-LAST:event_jCTextFieldApellidosRNKeyReleased

    private void jCTextFieldDireccionRNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionRNKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldDireccionRN);
    }//GEN-LAST:event_jCTextFieldDireccionRNKeyReleased

    private void jCTextFieldNactaRNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNactaRNKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldNactaRN);
    }//GEN-LAST:event_jCTextFieldNactaRNKeyReleased

    private void jCTextFieldNombreApoRNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombreApoRNKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldNombreApoRN);
    }//GEN-LAST:event_jCTextFieldNombreApoRNKeyReleased

    private void jCTextFieldApellidoApoRNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoApoRNKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldApellidoApoRN);
    }//GEN-LAST:event_jCTextFieldApellidoApoRNKeyReleased

    private void jCTextFieldDireccionApoRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionApoRNKeyTyped
        // TODO add your handling code here:
        evento.soloNcarc(85, jCTextFieldDireccionApoRN, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDireccionApoRN);
    }//GEN-LAST:event_jCTextFieldDireccionApoRNKeyTyped

    private void jCTextFieldDireccionApoRNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionApoRNKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldDireccionApoRN);
    }//GEN-LAST:event_jCTextFieldDireccionApoRNKeyReleased

    private void jCTextFieldNombresRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombresRNKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldNombresRN, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldNombresRN);
    }//GEN-LAST:event_jCTextFieldNombresRNKeyTyped

    private void jCTextFieldApellidosRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidosRNKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldApellidosRN, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldApellidosRN);
    }//GEN-LAST:event_jCTextFieldApellidosRNKeyTyped

    private void jCTextFieldDNIRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIRNKeyTyped
        // TODO add your handling code here:
        evento.soloNumeros(evt);
        evento.soloNcarc(8, jCTextFieldDNIRN, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDNIRN);
    }//GEN-LAST:event_jCTextFieldDNIRNKeyTyped

    private void jCTextFieldDireccionRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionRNKeyTyped
        // TODO add your handling code here:
        evento.soloNcarc(85, jCTextFieldDireccionRN, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDireccionRN);
    }//GEN-LAST:event_jCTextFieldDireccionRNKeyTyped

    private void jCTextFieldNactaRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNactaRNKeyTyped
        // TODO add your handling code here:
        evento.soloNcarc(20, jCTextFieldNactaRN, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldNactaRN);
    }//GEN-LAST:event_jCTextFieldNactaRNKeyTyped

    private void jCTextFieldNombreApoRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombreApoRNKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldNombreApoRN, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldNombreApoRN);
    }//GEN-LAST:event_jCTextFieldNombreApoRNKeyTyped

    private void jCTextFieldApellidoApoRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoApoRNKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldApellidoApoRN, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldApellidoApoRN);
    }//GEN-LAST:event_jCTextFieldApellidoApoRNKeyTyped

    private void jCTextFieldDNIApoRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIApoRNKeyTyped
        // TODO add your handling code here:
        evento.soloNumeros(evt);
        evento.soloNcarc(8, jCTextFieldDNIApoRN, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDNIApoRN);
    }//GEN-LAST:event_jCTextFieldDNIApoRNKeyTyped

    private void jCTextFieldBuscarRN1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRN1KeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldBuscarRN1);
    }//GEN-LAST:event_jCTextFieldBuscarRN1KeyReleased

    private void jCTextFieldBuscarRN1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRN1KeyTyped
        // TODO add your handling code here:
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldBuscarRN1);
    }//GEN-LAST:event_jCTextFieldBuscarRN1KeyTyped

    private void jCTextFieldBuscarRNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRNKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldBuscarRN);
        buscarRN();
    }//GEN-LAST:event_jCTextFieldBuscarRNKeyReleased

    private void jCTextFieldBuscarRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRNKeyTyped
        // TODO add your handling code here:
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldBuscarRN);
    }//GEN-LAST:event_jCTextFieldBuscarRNKeyTyped

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
//        vistaRegistro();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jMenuItemModificarRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarRNActionPerformed
        // TODO add your handling code here:
        limpiarCamposRN();
        tabla.LimpiarTabla(modeloRNA);
        estadoCamposRN(true);
        estadoBotonesRN(true);
        jCButtonGuardarRN.setEnabled(false);
        int filamodificar = jTableRegistroRN.getSelectedRow();
        if (filamodificar >= 0) {
            asignarCamposRN();
            jCTextFieldNombresRN.requestFocus();
        } else {
            mensaje.mensajeError("Modificar...");
        }
    }//GEN-LAST:event_jMenuItemModificarRNActionPerformed

    private void jMenuItemModificarApoRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarApoRNActionPerformed
        // TODO add your handling code here:
        limpiarCamposRNA();
        int filamodificar = jTableApoderadoRN.getSelectedRow();
        if (filamodificar >= 0) {
            asignarCamposApoderadoRN();
            jCTextFieldNombreApoRN.requestFocus();
            tabla.eliminarFilaTabla(jTableApoderadoRN, modeloRNA);
        } else {
            mensaje.mensajeError("Modificar declarante...");
        }
    }//GEN-LAST:event_jMenuItemModificarApoRNActionPerformed

    private void jComboBoxDepartamentoRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentoRMActionPerformed
        // TODO add your handling code here:
        if (jComboBoxDepartamentoRM.getSelectedIndex() >= 0) {
            llenarProvinciaRM();
        }
    }//GEN-LAST:event_jComboBoxDepartamentoRMActionPerformed

    private void jComboBoxProvinciaRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProvinciaRMActionPerformed
        // TODO add your handling code here:
        if (jComboBoxProvinciaRM.getSelectedIndex() >= 0) {
            llenarDistritoRM();
        }
    }//GEN-LAST:event_jComboBoxProvinciaRMActionPerformed

    private void jCButtonGuardarRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonGuardarRMActionPerformed
        // TODO add your handling code here:
        if (validarCamposRM()) {
            if (verificarReg(jCTextFieldDNIHRM, jComboBoxTipoRegRM)) {
                if (verificarReg(jCTextFieldDNIMRM, jComboBoxTipoRegRM)) {
                    if (controlador.oneAttribRepeat("registro", "num_acta", jCTextFieldNactaRM.getText())) {
                        mensaje.mensajeError("Ya existe un registro con número de acta ingresado.");
                        jCTextFieldNactaRM.requestFocus();
                    } else {
                        insertarRegistroRM();
                        cargarTablaRM();
                        limpiarCamposRM();
                        estadoCamposRM(true);
                        jCButtonCancelarRM.setEnabled(false);
                        jCTextFieldNombreHRM.requestFocus();
                    }
                } else {
                    jCTextFieldDNIMRM.requestFocus();
                }
            } else {
                jCTextFieldDNIHRM.requestFocus();
            }
        }
    }//GEN-LAST:event_jCButtonGuardarRMActionPerformed

    private void jCTextFieldNombreHRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombreHRMKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldNombreHRM, jCTextFieldApellidoHRM);
    }//GEN-LAST:event_jCTextFieldNombreHRMKeyPressed

    private void jCTextFieldApellidoHRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoHRMKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldApellidoHRM, jCTextFieldDNIHRM);
    }//GEN-LAST:event_jCTextFieldApellidoHRMKeyPressed

    private void jCTextFieldDNIHRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIHRMKeyPressed
        // TODO add your handling code here:
        if (jCTextFieldDNIHRM.getText().trim().length() > 0) {
            if (evt.getKeyChar() == evt.VK_ENTER) {
//                verificarDNI(evt, jCTextFieldDNIHRM, jComboBoxGeneroHRM);
                verificarDNI(evt, jCTextFieldDNIHRM, jComboBoxGeneroHRM, jCTextFieldApellidoHRM, jCTextFieldNombreHRM,
                        jCTextFieldDireccionHRM, jComboBoxGeneroHRM, jDateChooserFechaNacHRM, timeChooserHoraNacHRM,
                        jCTextFieldNombreMRM);
            }
        }
    }//GEN-LAST:event_jCTextFieldDNIHRMKeyPressed

    private void jComboBoxGeneroHRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxGeneroHRMKeyPressed
        // TODO add your handling code here:
        evento.EnterJComboBox_A_JDateChosster(evt, jComboBoxGeneroHRM, jDateChooserFechaNacHRM);
    }//GEN-LAST:event_jComboBoxGeneroHRMKeyPressed

    private void jDateChooserFechaNacHRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFechaNacHRMKeyPressed
        // TODO add your handling code here:
        evento.EnterJDateChosster_A_JTexField(evt, jDateChooserFechaNacHRM, jCTextFieldDireccionHRM);
    }//GEN-LAST:event_jDateChooserFechaNacHRMKeyPressed

    private void timeChooserHoraNacHRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeChooserHoraNacHRMKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, timeChooserHoraNacHRM, jCTextFieldDireccionHRM);
    }//GEN-LAST:event_timeChooserHoraNacHRMKeyPressed

    private void jCTextFieldDireccionHRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionHRMKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldDireccionHRM, jCTextFieldNombreMRM);
    }//GEN-LAST:event_jCTextFieldDireccionHRMKeyPressed

    private void jCTextFieldNombreMRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombreMRMKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldNombreMRM, jCTextFieldApellidoMRM);
    }//GEN-LAST:event_jCTextFieldNombreMRMKeyPressed

    private void jCTextFieldApellidoMRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoMRMKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldApellidoMRM, jCTextFieldDNIMRM);
    }//GEN-LAST:event_jCTextFieldApellidoMRMKeyPressed

    private void jCTextFieldDNIMRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIMRMKeyPressed
        // TODO add your handling code here:
        if (jCTextFieldDNIMRM.getText().trim().length() > 0) {
            if (evt.getKeyChar() == evt.VK_ENTER) {
//                verificarDNI(evt, jCTextFieldDNIMRM, jComboBoxGeneroMRM);
                verificarDNI(evt, jCTextFieldDNIMRM, jComboBoxGeneroMRM, jCTextFieldApellidoMRM, jCTextFieldNombreMRM,
                        jCTextFieldDireccionMRM, jComboBoxGeneroMRM, jDateChooserFechaNacMRM, timeChooserHoraNacMRM,
                        jCTextFieldNactaRM);
            }
        }
    }//GEN-LAST:event_jCTextFieldDNIMRMKeyPressed

    private void jComboBoxGeneroMRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxGeneroMRMKeyPressed
        // TODO add your handling code here:
        evento.EnterJComboBox_A_JDateChosster(evt, jComboBoxGeneroMRM, jDateChooserFechaNacMRM);
    }//GEN-LAST:event_jComboBoxGeneroMRMKeyPressed

    private void jDateChooserFechaNacMRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFechaNacMRMKeyPressed
        // TODO add your handling code here:
        evento.EnterJDateChosster_A_JTexField(evt, jDateChooserFechaNacMRM, timeChooserHoraNacMRM);
    }//GEN-LAST:event_jDateChooserFechaNacMRMKeyPressed

    private void timeChooserHoraNacMRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeChooserHoraNacMRMKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, timeChooserHoraNacMRM, jCTextFieldDireccionMRM);
    }//GEN-LAST:event_timeChooserHoraNacMRMKeyPressed

    private void jCTextFieldDireccionMRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionMRMKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldDireccionMRM, jCTextFieldNactaRM);
    }//GEN-LAST:event_jCTextFieldDireccionMRMKeyPressed

    private void jCTextFieldNactaRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNactaRMKeyPressed
        // TODO add your handling code here:
        if (jCTextFieldNactaRM.getText().trim().length() > 0) {
            if (evt.getKeyChar() == evt.VK_ENTER) {
                verificarNumActa(evt, jCTextFieldNactaRM, jComboBoxDepartamentoRM);
            }
        }
    }//GEN-LAST:event_jCTextFieldNactaRMKeyPressed

    private void jCTextFieldNombreHRMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombreHRMKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldNombreHRM);
    }//GEN-LAST:event_jCTextFieldNombreHRMKeyReleased

    private void jCTextFieldApellidoHRMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoHRMKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldApellidoHRM);
    }//GEN-LAST:event_jCTextFieldApellidoHRMKeyReleased

    private void jCTextFieldDireccionHRMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionHRMKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldDireccionHRM);
    }//GEN-LAST:event_jCTextFieldDireccionHRMKeyReleased

    private void jCTextFieldNombreMRMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombreMRMKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldNombreMRM);
    }//GEN-LAST:event_jCTextFieldNombreMRMKeyReleased

    private void jCTextFieldApellidoMRMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoMRMKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldApellidoMRM);
    }//GEN-LAST:event_jCTextFieldApellidoMRMKeyReleased

    private void jCTextFieldDireccionMRMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionMRMKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldDireccionMRM);
    }//GEN-LAST:event_jCTextFieldDireccionMRMKeyReleased

    private void jCTextFieldNactaRMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNactaRMKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldNactaRM);
    }//GEN-LAST:event_jCTextFieldNactaRMKeyReleased

    private void jCTextFieldNombreHRMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombreHRMKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldNombreHRM, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldNombreHRM);
    }//GEN-LAST:event_jCTextFieldNombreHRMKeyTyped

    private void jCTextFieldApellidoHRMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoHRMKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldApellidoHRM, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldApellidoHRM);
    }//GEN-LAST:event_jCTextFieldApellidoHRMKeyTyped

    private void jCTextFieldNombreMRMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombreMRMKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldNombreMRM, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldNombreMRM);
    }//GEN-LAST:event_jCTextFieldNombreMRMKeyTyped

    private void jCTextFieldApellidoMRMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoMRMKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldApellidoMRM, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldApellidoMRM);
    }//GEN-LAST:event_jCTextFieldApellidoMRMKeyTyped

    private void jCTextFieldDNIHRMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIHRMKeyTyped
        // TODO add your handling code here:
        evento.soloNumeros(evt);
        evento.soloNcarc(8, jCTextFieldDNIHRM, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDNIHRM);
    }//GEN-LAST:event_jCTextFieldDNIHRMKeyTyped

    private void jCTextFieldDNIMRMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIMRMKeyTyped
        // TODO add your handling code here:
        evento.soloNumeros(evt);
        evento.soloNcarc(8, jCTextFieldDNIMRM, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDNIMRM);
    }//GEN-LAST:event_jCTextFieldDNIMRMKeyTyped

    private void jCTextFieldDireccionHRMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionHRMKeyTyped
        // TODO add your handling code here:
        evento.soloNcarc(85, jCTextFieldDireccionHRM, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDireccionHRM);
    }//GEN-LAST:event_jCTextFieldDireccionHRMKeyTyped

    private void jCTextFieldDireccionMRMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionMRMKeyTyped
        // TODO add your handling code here:
        evento.soloNcarc(85, jCTextFieldDireccionMRM, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDireccionMRM);
    }//GEN-LAST:event_jCTextFieldDireccionMRMKeyTyped

    private void jCTextFieldNactaRMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNactaRMKeyTyped
        // TODO add your handling code here:
        evento.soloNcarc(20, jCTextFieldNactaRM, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldNactaRM);
    }//GEN-LAST:event_jCTextFieldNactaRMKeyTyped

    private void jCTextFieldBuscarRMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRMKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldBuscarRM);
        buscarRM();
    }//GEN-LAST:event_jCTextFieldBuscarRMKeyReleased

    private void jCTextFieldBuscarRMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRMKeyTyped
        // TODO add your handling code here:
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldBuscarRM);
    }//GEN-LAST:event_jCTextFieldBuscarRMKeyTyped

    private void jMenuItemModificarRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarRMActionPerformed
        // TODO add your handling code here:
        limpiarCamposRM();
        estadoCamposRM(true);
        estadoBotonesRM(true);
        jCButtonGuardarRM.setEnabled(false);
        jCButtonFechaImportanteRM.setEnabled(false);
        int filamodificar = jTableRegistroRM.getSelectedRow();
        if (filamodificar >= 0) {
            asignarCamposRM();
            jCTextFieldNombreHRM.requestFocus();
        } else {
            mensaje.mensajeError("Modificar...");
        }
    }//GEN-LAST:event_jMenuItemModificarRMActionPerformed

    private void jCButtonEditarRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonEditarRMActionPerformed
        // TODO add your handling code here:
        if (jTableRegistroRM.getSelectedRow() >= 0) {
            if (mensaje.mensajeConsulta("Realmente desea actualizar el registro?") == JOptionPane.YES_NO_OPTION) {
                editarRegistroRM();
                cargarTablaRM();
                limpiarCamposRM();
                estadoCamposRM(true);
                estadoBotonesRM(false);
                jCButtonGuardarRM.setEnabled(true);
                jCTextFieldNombreHRM.requestFocus();
                jCButtonFechaImportanteRM.setEnabled(true);
            } else {
                mensaje.mensajeInformacion("No se actualizo ningún registro.");
            }
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para editar.");
        }
    }//GEN-LAST:event_jCButtonEditarRMActionPerformed

    private void jCTextFieldBuscarRD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldBuscarRD1ActionPerformed

    private void jCTextFieldBuscarRD1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRD1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldBuscarRD1KeyReleased

    private void jCTextFieldBuscarRD1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRD1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldBuscarRD1KeyTyped

    private void jCButtonAgregarRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonAgregarRDActionPerformed
        // TODO add your handling code here:
        if (jTableApoderadoRD.getRowCount() < 3) {
            if (!verificarExisteDNI(jTableApoderadoRD, jCTextFieldDNIApoRD)) {
                if (!verificarExisteApo(jTableApoderadoRD, jComboBoxApoderadoRD)) {
//                    if (!verificarExisteGenero(jTableApoderadoRD, jComboBoxGeneroApoRD)) {
                    if (validarCamposRDA()) {
                        String validargener = consulta.devolverDato("select genero from apoderado where nom_apo=", jComboBoxApoderadoRD.getSelectedItem().toString(), 1);
                        if (jComboBoxGeneroApoRD.getSelectedItem().toString().equals(validargener)) {
                            Object[] object = new Object[7];
                            object[0] = jCTextFieldDNIApoRD.getText();
                            object[1] = jCTextFieldNombreApoRD.getText();
                            object[2] = jCTextFieldApellidoApoRD.getText();
                            object[3] = jComboBoxGeneroApoRD.getSelectedItem().toString();
                            object[4] = jCTextFieldDireccionApoRD.getText();
                            if (jDateChooserFechaNacApoRD.getDate() != null) {
                                object[5] = fecha.Formato_AMD(jDateChooserFechaNacApoRD.getDate());
                            } else {
                                object[5] = "";
                            }
                            object[6] = jComboBoxApoderadoRD.getSelectedItem().toString();
                            modeloRDA.addRow(object);
                            limpiarCamposRDA();
                            jCTextFieldNombreApoRD.requestFocus();
                        } else {
                            mensaje.mensajeError("El género del declarante es inconsistente.");
                            jComboBoxGeneroApoRD.requestFocus();
                        }
                    }
//                    } else {
//                        mensaje.mensajeError("El registro con el género seleccionado ya existe.");
//                        jComboBoxGeneroApoRD.requestFocus();
//                    }
                } else {
                    mensaje.mensajeError("El registro con el declarante seleccionado ya existe.");
                    jComboBoxApoderadoRD.requestFocus();
                }
            } else {
                mensaje.mensajeError("El registro con el DNI ingresado ya existe.");
                jCTextFieldDNIApoRD.requestFocus();
            }
        } else {
            mensaje.mensajeError("No puede ingresar más de dos registros.");
        }
    }//GEN-LAST:event_jCButtonAgregarRDActionPerformed

    private void jCTextFieldBuscarRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldBuscarRDActionPerformed

    private void jCTextFieldBuscarRDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldBuscarRDKeyReleased

    private void jCTextFieldBuscarRDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldBuscarRDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldBuscarRDKeyTyped

    private void jCTextFieldNombresRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldNombresRDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldNombresRDActionPerformed

    private void jCTextFieldNombresRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombresRDKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldNombresRD, jCTextFieldApellidosRD);
    }//GEN-LAST:event_jCTextFieldNombresRDKeyPressed

    private void jCTextFieldNombresRDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombresRDKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldNombresRD);
    }//GEN-LAST:event_jCTextFieldNombresRDKeyReleased

    private void jCTextFieldNombresRDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombresRDKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldNombresRD, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldNombresRD);
    }//GEN-LAST:event_jCTextFieldNombresRDKeyTyped

    private void jCTextFieldApellidosRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldApellidosRDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldApellidosRDActionPerformed

    private void jCTextFieldApellidosRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidosRDKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldApellidosRD, jCTextFieldDNIRD);
    }//GEN-LAST:event_jCTextFieldApellidosRDKeyPressed

    private void jCTextFieldApellidosRDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidosRDKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldApellidosRD);
    }//GEN-LAST:event_jCTextFieldApellidosRDKeyReleased

    private void jCTextFieldApellidosRDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidosRDKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldApellidosRD, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldApellidosRD);
    }//GEN-LAST:event_jCTextFieldApellidosRDKeyTyped

    private void jCTextFieldDNIRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDNIRDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDNIRDActionPerformed

    private void jCTextFieldDNIRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIRDKeyPressed
        // TODO add your handling code here:
        if (jCTextFieldDNIRD.getText().trim().length() > 0) {
            if (evt.getKeyChar() == evt.VK_ENTER) {
                verificarDNI(evt, jCTextFieldDNIRD, jComboBoxGeneroRD, jCTextFieldApellidosRD, jCTextFieldNombresRD,
                        jCTextFieldDireccionRD, jComboBoxGeneroRD, jDateChooserFechaNacimientoRD, timeChooserHoraNacimientoRD,
                        jCTextFieldNactaRD);
            }
        }
    }//GEN-LAST:event_jCTextFieldDNIRDKeyPressed

    private void jCTextFieldDNIRDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIRDKeyTyped
        // TODO add your handling code here:
        evento.soloNumeros(evt);
        evento.soloNcarc(8, jCTextFieldDNIRD, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDNIRD);
    }//GEN-LAST:event_jCTextFieldDNIRDKeyTyped

    private void jComboBoxGeneroRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxGeneroRDKeyPressed
        // TODO add your handling code here:
        evento.EnterJComboBox_A_JDateChosster(evt, jComboBoxGeneroRD, jDateChooserFechaNacimientoRD);
    }//GEN-LAST:event_jComboBoxGeneroRDKeyPressed

    private void jCTextFieldDireccionRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionRDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDireccionRDActionPerformed

    private void jCTextFieldDireccionRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionRDKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldDireccionRD, jCTextFieldNactaRD);
    }//GEN-LAST:event_jCTextFieldDireccionRDKeyPressed

    private void jCTextFieldDireccionRDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionRDKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldDireccionRD);
    }//GEN-LAST:event_jCTextFieldDireccionRDKeyReleased

    private void jCTextFieldDireccionRDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionRDKeyTyped
        // TODO add your handling code here:
        evento.soloNcarc(85, jCTextFieldDireccionRD, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDireccionRD);
    }//GEN-LAST:event_jCTextFieldDireccionRDKeyTyped

    private void jDateChooserFechaNacimientoRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFechaNacimientoRDKeyPressed
        // TODO add your handling code here:
        evento.EnterJDateChosster_A_JTexField(evt, jDateChooserFechaNacimientoRD, timeChooserHoraNacimientoRD);
    }//GEN-LAST:event_jDateChooserFechaNacimientoRDKeyPressed

    private void timeChooserHoraNacimientoRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeChooserHoraNacimientoRDKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, timeChooserHoraNacimientoRD, jCTextFieldDireccionRD);
    }//GEN-LAST:event_timeChooserHoraNacimientoRDKeyPressed

    private void jComboBoxTipoRegistroRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxTipoRegistroRDKeyPressed
        // TODO add your handling code here:
        evento.EnterJComboBox_A_JTexField(evt, jCTextFieldNactaRD);
    }//GEN-LAST:event_jComboBoxTipoRegistroRDKeyPressed

    private void jCTextFieldNactaRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldNactaRDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldNactaRDActionPerformed

    private void jCTextFieldNactaRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNactaRDKeyPressed
        // TODO add your handling code here:
        if (jCTextFieldNactaRD.getText().trim().length() > 0) {
            if (evt.getKeyChar() == evt.VK_ENTER) {
                verificarNumActa(evt, jCTextFieldNactaRD, jComboBoxDepartamentoRD);
            }
        }
    }//GEN-LAST:event_jCTextFieldNactaRDKeyPressed

    private void jCTextFieldNactaRDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNactaRDKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldNactaRD);
    }//GEN-LAST:event_jCTextFieldNactaRDKeyReleased

    private void jCTextFieldNactaRDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNactaRDKeyTyped
        // TODO add your handling code here:
        evento.soloNcarc(20, jCTextFieldNactaRD, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldNactaRD);
    }//GEN-LAST:event_jCTextFieldNactaRDKeyTyped

    private void jComboBoxDepartamentoRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentoRDActionPerformed
        // TODO add your handling code here:
        if (jComboBoxDepartamentoRD.getSelectedIndex() >= 0) {
            llenarProvinciaRD();
        }
    }//GEN-LAST:event_jComboBoxDepartamentoRDActionPerformed

    private void jComboBoxProvinciaRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProvinciaRDActionPerformed
        // TODO add your handling code here:
        if (jComboBoxProvinciaRD.getSelectedIndex() >= 0) {
            llenarDistritoRD();
        }
    }//GEN-LAST:event_jComboBoxProvinciaRDActionPerformed

    private void jComboBoxDistritoRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxDistritoRDKeyPressed
        // TODO add your handling code here:
        evento.EnterJComboBox_A_JTexField(evt, jCTextFieldNombreApoRD);
    }//GEN-LAST:event_jComboBoxDistritoRDKeyPressed

    private void jCTextFieldNombreApoRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldNombreApoRDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldNombreApoRDActionPerformed

    private void jCTextFieldNombreApoRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombreApoRDKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldNombreApoRD, jCTextFieldApellidoApoRD);
    }//GEN-LAST:event_jCTextFieldNombreApoRDKeyPressed

    private void jCTextFieldNombreApoRDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombreApoRDKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldNombreApoRD);
    }//GEN-LAST:event_jCTextFieldNombreApoRDKeyReleased

    private void jCTextFieldNombreApoRDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldNombreApoRDKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldNombreApoRD, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldNombreApoRD);
    }//GEN-LAST:event_jCTextFieldNombreApoRDKeyTyped

    private void jCTextFieldApellidoApoRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoApoRDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldApellidoApoRDActionPerformed

    private void jCTextFieldApellidoApoRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoApoRDKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield(evt, jCTextFieldApellidoApoRD, jCTextFieldDNIApoRD);
    }//GEN-LAST:event_jCTextFieldApellidoApoRDKeyPressed

    private void jCTextFieldApellidoApoRDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoApoRDKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldApellidoApoRD);
    }//GEN-LAST:event_jCTextFieldApellidoApoRDKeyReleased

    private void jCTextFieldApellidoApoRDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldApellidoApoRDKeyTyped
        // TODO add your handling code here:
        evento.soloLetras(evt);
        evento.soloNcarc(45, jCTextFieldApellidoApoRD, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldApellidoApoRD);
    }//GEN-LAST:event_jCTextFieldApellidoApoRDKeyTyped

    private void jCTextFieldDNIApoRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDNIApoRDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDNIApoRDActionPerformed

    private void jCTextFieldDNIApoRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIApoRDKeyPressed
        // TODO add your handling code here:
        if (jCTextFieldDNIApoRD.getText().trim().length() > 0) {
            if (evt.getKeyChar() == evt.VK_ENTER) {
                verificarDNI(evt, jCTextFieldDNIApoRD, jComboBoxGeneroApoRD, jCTextFieldApellidoApoRD, jCTextFieldNombreApoRD,
                        jCTextFieldDireccionApoRD, jComboBoxGeneroApoRD, jDateChooserFechaNacApoRD, timeChooserHoraNacimientoRD,
                        jCTextFieldDireccionApoRD);
            }
        }
    }//GEN-LAST:event_jCTextFieldDNIApoRDKeyPressed

    private void jCTextFieldDNIApoRDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDNIApoRDKeyTyped
        // TODO add your handling code here:
        evento.soloNumeros(evt);
        evento.soloNcarc(8, jCTextFieldDNIApoRD, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDNIApoRD);
    }//GEN-LAST:event_jCTextFieldDNIApoRDKeyTyped

    private void jComboBoxGeneroApoRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxGeneroApoRDKeyPressed
        // TODO add your handling code here:
        evento.EnterJComboBox_A_JTexField(evt, jCTextFieldDireccionApoRD);
    }//GEN-LAST:event_jComboBoxGeneroApoRDKeyPressed

    private void jCTextFieldDireccionApoRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionApoRDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextFieldDireccionApoRDActionPerformed

    private void jCTextFieldDireccionApoRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionApoRDKeyPressed
        // TODO add your handling code here:
        evento.EnterJTexfield_A_JComboBox(evt, jCTextFieldDireccionApoRD, jComboBoxApoderadoRD);
    }//GEN-LAST:event_jCTextFieldDireccionApoRDKeyPressed

    private void jCTextFieldDireccionApoRDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionApoRDKeyReleased
        // TODO add your handling code here:
        evento.mayusculas(evt, jCTextFieldDireccionApoRD);
    }//GEN-LAST:event_jCTextFieldDireccionApoRDKeyReleased

    private void jCTextFieldDireccionApoRDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCTextFieldDireccionApoRDKeyTyped
        // TODO add your handling code here:
        evento.soloNcarc(85, jCTextFieldDireccionApoRD, evt);
        evento.SinEspacioBlancoJTextField(evt, jCTextFieldDireccionApoRD);
    }//GEN-LAST:event_jCTextFieldDireccionApoRDKeyTyped

    private void jDateChooserFechaNacApoRDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFechaNacApoRDKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserFechaNacApoRDKeyPressed

    private void jMenuItemModificarApoRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarApoRDActionPerformed
        // TODO add your handling code here:
        limpiarCamposRDA();
        int filamodificar = jTableApoderadoRD.getSelectedRow();
        if (filamodificar >= 0) {
            asignarCamposApoderadoRD();
            jCTextFieldNombreApoRD.requestFocus();
            tabla.eliminarFilaTabla(jTableApoderadoRD, modeloRDA);
        } else {
            mensaje.mensajeError("Modificar declarante...");
        }
    }//GEN-LAST:event_jMenuItemModificarApoRDActionPerformed

    private void jMenuItemEliminarApoRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarApoRDActionPerformed
        // TODO add your handling code here:
        if (jTableApoderadoRD.getSelectedRow() >= 0) {
            if (mensaje.mensajeConsulta("Estás seguro de eliminar el registro?") == JOptionPane.YES_NO_OPTION) {
                String dn = modeloRDA.getValueAt(jTableApoderadoRD.getSelectedRow(), 0).toString();
                String exi_dni = consulta.devolverDato("select p.dni from detregistro dr, persona p where p.idpersona=dr.idpersona and p.dni=", dn, 1);
                if (exi_dni.length() != 0) {
                    mensaje.mensajeInformacion("se va eliminar desde la BD");
                    String que1 = "CALL deleteAntiguosApoRD("
                            + "'" + exi_dni + "'"
                            + " );";
                    consulta.Consulta(que1);
                    //Para poder eliminar el residuo que queda en la tabla
                    tabla.eliminarFilaTabla(jTableApoderadoRD, modeloRDA);
                    jCTextFieldNombreApoRD.requestFocus();
                } else {
                    tabla.eliminarFilaTabla(jTableApoderadoRD, modeloRDA);
                }
            } else {
                mensaje.mensajeInformacion("No se elimino ningún registro.");
            }
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para eliminar.");
        }
    }//GEN-LAST:event_jMenuItemEliminarApoRDActionPerformed

    private void jCButtonGuardarRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonGuardarRDActionPerformed
        // TODO add your handling code here:
        if (validarCamposRD()) {
            if (verificarReg(jCTextFieldDNIRD, jComboBoxTipoRegistroRD)) {
                if (controlador.oneAttribRepeat("registro", "num_acta", jCTextFieldNactaRD.getText())) {
                    mensaje.mensajeError("Ya existe un registro con número de acta ingresado.");
                    jCTextFieldNactaRD.requestFocus();
                } else {
                    insertarRegistroRD();
                    insertarApoderadoRD();
                    cargarTablaRD();
                    limpiarCamposRD();
                    limpiarCamposRDA();
                    estadoCamposRD(true);
                    tabla.LimpiarTabla(modeloRDA);
                    jCButtonCancelarRD.setEnabled(false);
                    jCTextFieldNombresRD.requestFocus();
                }
            } else {
                jCTextFieldDNIRD.requestFocus();
            }
        }
    }//GEN-LAST:event_jCButtonGuardarRDActionPerformed

    private void jMenuItemModificarRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarRDActionPerformed
        // TODO add your handling code here:
        limpiarCamposRD();
        tabla.LimpiarTabla(modeloRDA);
        estadoCamposRD(true);
        estadoBotonesRD(true);
        jCButtonGuardarRD.setEnabled(false);
        jCButtonFechaImportanteRD.setEnabled(false);
        int filamodificar = jTableRegistroRD.getSelectedRow();
        if (filamodificar >= 0) {
            asignarCamposRD();
            jCTextFieldNombresRD.requestFocus();
        } else {
            mensaje.mensajeError("Modificar...");
        }
    }//GEN-LAST:event_jMenuItemModificarRDActionPerformed

    private void jCButtonEditarRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonEditarRDActionPerformed
        // TODO add your handling code here:
        if (jTableRegistroRD.getSelectedRow() >= 0) {
            if (mensaje.mensajeConsulta("Realmente desea actualizar el registro?") == JOptionPane.YES_NO_OPTION) {
                editarRegistroRD();
                editarApoderadoRD();
                cargarTablaRD();
                limpiarCamposRD();
                limpiarCamposRDA();
                tabla.LimpiarTabla(modeloRDA);
                estadoCamposRD(true);
                estadoBotonesRD(false);
                jCButtonGuardarRD.setEnabled(true);
                jCTextFieldNombresRD.requestFocus();
                jCButtonFechaImportanteRD.setEnabled(true);
            } else {
                mensaje.mensajeInformacion("No se actualizo ningún registro.");
            }
        } else {
            mensaje.mensajeInformacion("Debe seleccionar un registro para editar.");
        }
    }//GEN-LAST:event_jCButtonEditarRDActionPerformed

    private void jCButtonCancelarRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonCancelarRDActionPerformed
        // TODO add your handling code here:
        limpiarCamposRD();
        tabla.LimpiarTabla(modeloRDA);
        estadoCamposRD(true);
        estadoBotonesRD(false);
        jCButtonCancelarRD.setEnabled(true);
        jCButtonGuardarRD.setEnabled(true);
        jCTextFieldNombresRD.requestFocus();
        jCButtonFechaImportanteRD.setEnabled(true);
    }//GEN-LAST:event_jCButtonCancelarRDActionPerformed

    private void jCButtonCancelarRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonCancelarRMActionPerformed
        // TODO add your handling code here:
        limpiarCamposRM();
        estadoCamposRM(true);
        estadoBotonesRM(false);
        jCButtonCancelarRM.setEnabled(true);
        jCButtonGuardarRM.setEnabled(true);
        jCTextFieldNombreHRM.requestFocus();
        jCButtonFechaImportanteRM.setEnabled(true);
    }//GEN-LAST:event_jCButtonCancelarRMActionPerformed

    private void jCButtonFechaImportanteRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonFechaImportanteRMActionPerformed
        // TODO add your handling code here:
        JInt_FechaHora jrm = new JInt_FechaHora();
        controlador.MostrarJFrameInternos(JFrm_Menu.jDesktopPane1, jrm);
        JInt_FechaHora.jLabelFecha.setText("Fecha de matrimonio*");
        JInt_FechaHora.jLabelHora.setText("Hora de matrimonio*");
    }//GEN-LAST:event_jCButtonFechaImportanteRMActionPerformed

    private void jCButtonFechaImportanteRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCButtonFechaImportanteRDActionPerformed
        // TODO add your handling code here:
        JInt_FechaHora jrm = new JInt_FechaHora();
        controlador.MostrarJFrameInternos(JFrm_Menu.jDesktopPane1, jrm);
        JInt_FechaHora.jLabelFecha.setText("Fecha de defunción*");
        JInt_FechaHora.jLabelHora.setText("Hora de defunción*");
    }//GEN-LAST:event_jCButtonFechaImportanteRDActionPerformed

    private void jMenuItemModificarFecRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarFecRMActionPerformed
        // TODO add your handling code here:
        limpiarCamposRM();
        jCButtonFechaImportanteRM.setEnabled(false);
        int filamodificar = jTableRegistroRM.getSelectedRow();
        if (filamodificar >= 0) {
            asignarCamposFechaRM();
        } else {
            mensaje.mensajeError("Modificar...");
        }
    }//GEN-LAST:event_jMenuItemModificarFecRMActionPerformed

    private void jMenuItemModificarFecRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarFecRDActionPerformed
        // TODO add your handling code here:
        limpiarCamposRM();
        jCButtonFechaImportanteRD.setEnabled(false);
        int filamodificar = jTableRegistroRD.getSelectedRow();
        if (filamodificar >= 0) {
            asignarCamposFechaRD();
        } else {
            mensaje.mensajeError("Modificar...");
        }
    }//GEN-LAST:event_jMenuItemModificarFecRDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ControlSwing.JCButton jCButtonAgregarRD;
    private ControlSwing.JCButton jCButtonAgregarRN;
    private ControlSwing.JCButton jCButtonCancelarRD;
    private ControlSwing.JCButton jCButtonCancelarRM;
    private ControlSwing.JCButton jCButtonCancelarRN;
    private ControlSwing.JCButton jCButtonEditarRD;
    private ControlSwing.JCButton jCButtonEditarRM;
    private ControlSwing.JCButton jCButtonEditarRN;
    private ControlSwing.JCButton jCButtonFechaImportanteRD;
    private ControlSwing.JCButton jCButtonFechaImportanteRM;
    private ControlSwing.JCButton jCButtonGuardarRD;
    private ControlSwing.JCButton jCButtonGuardarRM;
    private ControlSwing.JCButton jCButtonGuardarRN;
    private ControlSwing.JCButton jCButtonSalirRD;
    private ControlSwing.JCButton jCButtonSalirRM;
    private ControlSwing.JCButton jCButtonSalirRN;
    private ControlSwing.JCTextField jCTextFieldApellidoApoRD;
    private ControlSwing.JCTextField jCTextFieldApellidoApoRN;
    private ControlSwing.JCTextField jCTextFieldApellidoHRM;
    private ControlSwing.JCTextField jCTextFieldApellidoMRM;
    private ControlSwing.JCTextField jCTextFieldApellidosRD;
    private ControlSwing.JCTextField jCTextFieldApellidosRN;
    private ControlSwing.JCTextField jCTextFieldBuscarRD;
    private ControlSwing.JCTextField jCTextFieldBuscarRD1;
    private ControlSwing.JCTextField jCTextFieldBuscarRM;
    private ControlSwing.JCTextField jCTextFieldBuscarRN;
    private ControlSwing.JCTextField jCTextFieldBuscarRN1;
    private ControlSwing.JCTextField jCTextFieldDNIApoRD;
    private ControlSwing.JCTextField jCTextFieldDNIApoRN;
    private ControlSwing.JCTextField jCTextFieldDNIHRM;
    private ControlSwing.JCTextField jCTextFieldDNIMRM;
    private ControlSwing.JCTextField jCTextFieldDNIRD;
    private ControlSwing.JCTextField jCTextFieldDNIRN;
    private ControlSwing.JCTextField jCTextFieldDireccionApoRD;
    private ControlSwing.JCTextField jCTextFieldDireccionApoRN;
    private ControlSwing.JCTextField jCTextFieldDireccionHRM;
    private ControlSwing.JCTextField jCTextFieldDireccionMRM;
    private ControlSwing.JCTextField jCTextFieldDireccionRD;
    private ControlSwing.JCTextField jCTextFieldDireccionRN;
    private ControlSwing.JCTextField jCTextFieldNactaRD;
    private ControlSwing.JCTextField jCTextFieldNactaRM;
    private ControlSwing.JCTextField jCTextFieldNactaRN;
    private ControlSwing.JCTextField jCTextFieldNombreApoRD;
    private ControlSwing.JCTextField jCTextFieldNombreApoRN;
    private ControlSwing.JCTextField jCTextFieldNombreHRM;
    private ControlSwing.JCTextField jCTextFieldNombreMRM;
    private ControlSwing.JCTextField jCTextFieldNombresRD;
    private ControlSwing.JCTextField jCTextFieldNombresRN;
    private javax.swing.JComboBox<String> jComboBoxApoderadoRD;
    private javax.swing.JComboBox<String> jComboBoxApoderadoRN;
    private javax.swing.JComboBox<String> jComboBoxDepartamentoRD;
    private javax.swing.JComboBox<String> jComboBoxDepartamentoRM;
    private javax.swing.JComboBox<String> jComboBoxDepartamentoRN;
    private javax.swing.JComboBox<String> jComboBoxDistritoRD;
    private javax.swing.JComboBox<String> jComboBoxDistritoRM;
    private javax.swing.JComboBox<String> jComboBoxDistritoRN;
    private javax.swing.JComboBox<String> jComboBoxGeneroApoRD;
    private javax.swing.JComboBox<String> jComboBoxGeneroApoRN;
    private javax.swing.JComboBox<String> jComboBoxGeneroHRM;
    private javax.swing.JComboBox<String> jComboBoxGeneroMRM;
    private javax.swing.JComboBox<String> jComboBoxGeneroRD;
    private javax.swing.JComboBox<String> jComboBoxGeneroRN;
    private javax.swing.JComboBox<String> jComboBoxProvinciaRD;
    private javax.swing.JComboBox<String> jComboBoxProvinciaRM;
    private javax.swing.JComboBox<String> jComboBoxProvinciaRN;
    private javax.swing.JComboBox<String> jComboBoxTipoRegRM;
    private javax.swing.JComboBox<String> jComboBoxTipoRegistroRD;
    private javax.swing.JComboBox<String> jComboBoxTipoRegistroRN;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNacApoRD;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNacApoRN;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNacHRM;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNacMRM;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNacimientoRD;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNacimientoRN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItemEliminarApoRD;
    private javax.swing.JMenuItem jMenuItemEliminarApoRN;
    private javax.swing.JMenuItem jMenuItemModificarApoRD;
    private javax.swing.JMenuItem jMenuItemModificarApoRN;
    private javax.swing.JMenuItem jMenuItemModificarFecRD;
    private javax.swing.JMenuItem jMenuItemModificarFecRM;
    private javax.swing.JMenuItem jMenuItemModificarRD;
    private javax.swing.JMenuItem jMenuItemModificarRM;
    private javax.swing.JMenuItem jMenuItemModificarRN;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JPopupMenu jPopupMenu5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableApoderadoRD;
    private javax.swing.JTable jTableApoderadoRN;
    private javax.swing.JTable jTableRegistroRD;
    private javax.swing.JTable jTableRegistroRM;
    private javax.swing.JTable jTableRegistroRN;
    private org.bolivia.time.TimeChooser timeChooserHoraNacHRM;
    private org.bolivia.time.TimeChooser timeChooserHoraNacMRM;
    private org.bolivia.time.TimeChooser timeChooserHoraNacimientoRD;
    private org.bolivia.time.TimeChooser timeChooserHoraNacimientoRN;
    // End of variables declaration//GEN-END:variables
}
