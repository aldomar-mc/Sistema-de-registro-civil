/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Calendar;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Aldo
 */
public class Aldo_Fechas {

    public Date ObtenerFecha(JDateChooser dateChooser) {
        return new Date(dateChooser.getDate().getYear(), dateChooser.getDate().getMonth(), dateChooser.getDate().getDate());
    }

    public void PonerFechaenDateChooser(JDateChooser fecha, String fec) {
        ((JTextComponent) fecha.getDateEditor().getUiComponent()).setText(fec);
    }

    public String Formato_AMD(java.util.Date v1) {
        java.util.Date fecha1 = v1;
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String fecha = df.format(fecha1);
        return fecha;
    }

    public String Formato_DMA(java.util.Date v1) {
        java.util.Date fecha1 = v1;
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("dd-MM-yyyy");
        String fecha = df.format(fecha1);
        return fecha;
    }

    public String fechaNormalMysql(String feff) {
        String f = feff.substring(6, 10) + "/" + feff.substring(3, 5) + "/" + feff.substring(0, 2);
        return f;
    }

    public String fechaMysqlNormal(String feff) {
        String f = feff.substring(8, 10) + "/" + feff.substring(5, 7) + "/" + feff.substring(0, 4);
        return f;
    }

    public Date ObtenerFechaSistema() {
        return new Date(System.currentTimeMillis());
    }

    public Time ObtenerHoraSistema() {
        return new Time(System.currentTimeMillis());
    }

    public void capturaFechaHora(JLabel fec, JLabel hor) {
        Calendar cal = Calendar.getInstance();
        String fecha = cal.get(cal.DATE) + "/" + cal.get(cal.MONTH) + "/" + cal.get(cal.YEAR);
        String hora = cal.get(cal.HOUR_OF_DAY) + ":" + cal.get(cal.MINUTE) + ":" + cal.get(cal.SECOND);
        fec.setText(fecha);
        hor.setText(hora);
    }

    public Time ObtenerTiempo(JFormattedTextField field) {
        String hora = field.getText();
        int horas = Integer.parseInt(hora.substring(0, 2));
        int minutos = Integer.parseInt(hora.substring(3, 5));
        Time tiempo = new Time(horas, minutos, 0);
        return tiempo;
    }

    public Time SumarTiempo(Time tiempoInicial, int numeroMinutos) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(tiempoInicial);
        cal.add(Calendar.MINUTE, numeroMinutos);
        System.out.println(new Time(cal.getTime().getTime()));
        return new Time(cal.getTime().getTime());
    }

    public String fecha_db() {
        String va = "";
        try {
            Connection connection = Conexion.getInstance().getConnection();
            String sql = "select curdate()";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                va = rs.getString(1);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        va = va.substring(8, 10) + "/" + va.substring(5, 7) + "/" + va.substring(0, 4);
        return va;
    }
    
     public String fecha_db1() {
        String va = "";
        try {
            Connection connection = Conexion.getInstance().getConnection();
            String sql = "select curdate()";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                va = rs.getString(1);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        va = va.substring(8, 10) + "" + va.substring(5, 7) + "" + va.substring(0, 4);
        return va;
    }

    public String monthToNum(String month) {
        String number = "";
        if (month.equalsIgnoreCase("enero")) {
            number = "01";
        }
        if (month.equalsIgnoreCase("febrero")) {
            number = "02";
        }
        if (month.equalsIgnoreCase("marzo")) {
            number = "03";
        }
        if (month.equalsIgnoreCase("abril")) {
            number = "04";
        }
        if (month.equalsIgnoreCase("mayo")) {
            number = "05";
        }
        if (month.equalsIgnoreCase("junio")) {
            number = "06";
        }
        if (month.equalsIgnoreCase("julio")) {
            number = "07";
        }
        if (month.equalsIgnoreCase("agosto")) {
            number = "08";
        }
        if (month.equalsIgnoreCase("setiembre") || month.equalsIgnoreCase("septiembre")) {
            number = "09";
        }
        if (month.equalsIgnoreCase("octubre")) {
            number = "10";
        }
        if (month.equalsIgnoreCase("noviembre")) {
            number = "11";
        }
        if (month.equalsIgnoreCase("diciembre")) {
            number = "12";
        }
        return number;
    }

    public String numToMonth(int number) {
        String month = "";
        switch (number) {
            case 1:
                month = "enero";
                break;
            case 2:
                month = "febrero";
                break;
            case 3:
                month = "marzo";
                break;
            case 4:
                month = "abril";
                break;
            case 5:
                month = "mayo";
                break;
            case 6:
                month = "junio";
                break;
            case 7:
                month = "julio";
                break;
            case 8:
                month = "agosto";
                break;
            case 9:
                month = "septiembre";
                break;
            case 10:
                month = "octubre";
                break;
            case 11:
                month = "noviembre";
                break;
            case 12:
                month = "diciembre";
                break;
        }
        return month;
    }

    //Convierte una fecha tipo string a date
    public Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    public String HoraMysql(String s) {
        String time = "";
        String[] a = s.split(" ");
        String[] f;
        f = a[0].split(":");
        int hora = Integer.parseInt(f[0]);
        switch (hora) {
            case 0:
                if (a[1].equals("PM")) {
                    time = "12:" + f[1] + ":00";
                } else {
                    time = "00:" + f[1] + ":00";
                }
                break;

            case 1:
                if (a[1].equals("PM")) {
                    time = "13:" + f[1] + ":00";
                } else {
                    time = "01:" + f[1] + ":00";
                }
                break;

            case 2:
                if (a[1].equals("PM")) {
                    time = "14:" + f[1] + ":00";
                } else {
                    time = "02:" + f[1] + ":00";
                }
                break;

            case 3:
                if (a[1].equals("PM")) {
                    time = "15:" + f[1] + ":00";
                } else {
                    time = "03:" + f[1] + ":00";
                }
                break;

            case 4:
                if (a[1].equals("PM")) {
                    time = "16:" + f[1] + ":00";
                } else {
                    time = "04:" + f[1] + ":00";
                }
                break;

            case 5:
                if (a[1].equals("PM")) {
                    time = "17:" + f[1] + ":00";
                } else {
                    time = "05:" + f[1] + ":00";
                }
                break;

            case 6:
                if (a[1].equals("PM")) {
                    time = "18:" + f[1] + ":00";
                } else {
                    time = "06:" + f[1] + ":00";
                }
                break;

            case 7:
                if (a[1].equals("PM")) {
                    time = "19:" + f[1] + ":00";
                } else {
                    time = "07:" + f[1] + ":00";
                }
                break;

            case 8:
                if (a[1].equals("PM")) {
                    time = "20:" + f[1] + ":00";
                } else {
                    time = "08:" + f[1] + ":00";
                }
                break;

            case 9:
                if (a[1].equals("PM")) {
                    time = "21:" + f[1] + ":00";
                } else {
                    time = "09:" + f[1] + ":00";
                }
                break;

            case 10:
                if (a[1].equals("PM")) {
                    time = "22:" + f[1] + ":00";
                } else {
                    time = "10:" + f[1] + ":00";
                }
                break;

            case 11:
                if (a[1].equals("PM")) {
                    time = "23:" + f[1] + ":00";
                } else {
                    time = "11:" + f[1] + ":00";
                }
                break;

            case 12:
                if (a[1].equals("PM")) {
                    time = "12:" + f[1] + ":00";
                } else {
                    time = "00:" + f[1] + ":00";
                }
                break;
        }
        return time;
    }
}
