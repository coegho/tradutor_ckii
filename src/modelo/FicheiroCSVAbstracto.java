package modelo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coegho
 */
public abstract class FicheiroCSVAbstracto {
    protected static String delim = ";";
    protected String nome;
    protected File ficheiro;
    
    public List<String> lerCadeasDendeFicheiro(File ficheiro) throws FileNotFoundException, IOException {
        List<String> ret = new ArrayList<>();
        this.ficheiro = ficheiro;
        nome = ficheiro.getName();
        BufferedReader buffer = new BufferedReader(
                new InputStreamReader(
                        new DataInputStream(
                                new FileInputStream(ficheiro)),Charset.forName("ISO-8859-1")));
        String fila;
        while((fila = buffer.readLine()) != null) {
            ret.add(fila);
        }
        buffer.close();
        return ret;
    }
    
    public static String getDelim() {
        return delim;
    }
    
    public String getNome() {
        return nome;
    }

}
