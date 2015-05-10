package modelo;

import java.io.File;

/**
 *
 * @author coegho
 */
public abstract class FicheiroCSVAbstracto {
    protected static String delim = ";";
    protected String nome;
    protected File ficheiro;
    
    public static String getDelim() {
        return delim;
    }
    
    public String getNome() {
        return nome;
    }

}
