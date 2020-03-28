package Clases;


import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aldo Omar
 */
public class Aldo_Encrypt {

    //Metodo que me devuelve su hash de un archivo: NOTA: encriptado en SHA-1
    public String hashArchivo(String rutaArchivo) {
        String codigoHash = "";
        //declarar funciones resumen
        try {
            MessageDigest messageDigest2 = MessageDigest.getInstance("SHA"); // Inicializa SHA-1
            //leer fichero byte a byte
            try {
                InputStream archivo = new FileInputStream(rutaArchivo);
                byte[] buffer = new byte[1];
                int fin_archivo = -1;
                int caracter;
                caracter = archivo.read(buffer);
                while (caracter != fin_archivo) {
                    // Pasa texto claro a la función resumen
                    messageDigest2.update(buffer);
                    caracter = archivo.read(buffer);
                }
                archivo.close();
                byte[] resumen2 = messageDigest2.digest(); // Genera el resumen SHA-1
                //Pasar los resumenes a hexadecimal
                String m = "";
                for (int i = 0; i < resumen2.length; i++) {
                    m += Integer.toHexString((resumen2[i] >> 4) & 0xf);
                    m += Integer.toHexString(resumen2[i] & 0xf);
                }
                codigoHash = m;
            } //lectura de los datos del fichero
            catch (java.io.FileNotFoundException fnfe) {
            } catch (java.io.IOException ioe) {
            }
        } //declarar funciones resumen
        catch (java.security.NoSuchAlgorithmException nsae) {
        }
        return codigoHash;
    }
}
