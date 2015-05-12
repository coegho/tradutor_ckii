package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author coegho
 */
public class Configuracion {
    private static String rutaOrixe;
    private static String rutaDestino;

    public static String getRutaOrixe() {
        if(rutaOrixe == null) {
            return ".";
        }
        return rutaOrixe;
    }

    public static void setRutaOrixe(String rutaOrixe) {
        Configuracion.rutaOrixe = rutaOrixe;
    }

    public static String getRutaDestino() {
        if(rutaDestino == null) {
            return ".";
        }
        return rutaDestino;
    }

    public static void setRutaDestino(String rutaDestino) {
        Configuracion.rutaDestino = rutaDestino;
    }
    
    public static void cargarConfiguracion() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new DataInputStream(new FileInputStream(new File("conf.txt")))));
            setRutaOrixe(br.readLine());
            setRutaDestino(br.readLine());
            br.close();
        } catch (IOException ex) {
            
        }
    }
    
    public static void gardarConfiguracion() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    new DataOutputStream(new FileOutputStream(new File("conf.txt"), false))));
            bw.write(getRutaOrixe());
            bw.newLine();
            bw.write(getRutaDestino());
            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
