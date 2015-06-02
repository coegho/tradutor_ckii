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
    
    /**
     *
     * @return
     */
    public static String getRutaFicheiroConfiguracion() {
        return System.getProperty("user.home") + File.separator + "rutas_trad_ckii.txt";
    }

    /**
     *
     * @return
     */
    public static String getRutaOrixe() {
        if(rutaOrixe == null) {
            return ".";
        }
        return rutaOrixe;
    }

    /**
     *
     * @param rutaOrixe
     */
    public static void setRutaOrixe(String rutaOrixe) {
        Configuracion.rutaOrixe = rutaOrixe;
    }

    /**
     *
     * @return
     */
    public static String getRutaDestino() {
        if(rutaDestino == null) {
            return ".";
        }
        return rutaDestino;
    }

    /**
     *
     * @param rutaDestino
     */
    public static void setRutaDestino(String rutaDestino) {
        Configuracion.rutaDestino = rutaDestino;
    }
    
    /**
     *
     */
    public static void cargarConfiguracion() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new DataInputStream(new FileInputStream(new File(getRutaFicheiroConfiguracion())))));
            setRutaOrixe(br.readLine());
            setRutaDestino(br.readLine());
            br.close();
        } catch (IOException ex) {
            
        }
    }
    
    /**
     *
     */
    public static void gardarConfiguracion() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    new DataOutputStream(new FileOutputStream(new File(getRutaFicheiroConfiguracion()), false))));
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
