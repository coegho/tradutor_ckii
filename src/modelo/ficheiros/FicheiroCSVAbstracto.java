package modelo.ficheiros;

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
    protected List<String> codigos;

    public FicheiroCSVAbstracto(String nome, File ficheiro, List<String> codigos) {
        this.nome = nome;
        this.ficheiro = ficheiro;
        this.codigos = codigos;
    }
    
    /**
     *
     * @param ficheiro
     * @return Devolve unha lista de cadeas en bruto.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static List<String> lerCadeasDendeFicheiro(File ficheiro) throws FileNotFoundException, IOException {
        List<String> ret = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(
                new InputStreamReader(
                        new DataInputStream(
                                new FileInputStream(ficheiro)),Charset.forName("ISO-8859-1")))) {
            String fila;
            while((fila = buffer.readLine()) != null) {
                ret.add(fila);
            }
        }
        return ret;
    }
    
    /**
     *
     * @return
     */
    public static String getDelim() {
        return delim;
    }
    
    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }
    
    /**
     *
     * @param index
     * @return
     * @deprecated 
     */
    public abstract String lerCadea(int index);
    
    /**
     *
     * @param codigo
     * @return
     */
    public abstract String lerCadea(String codigo);
    
    /**
     *
     * @return
     */
    public abstract int getSize();
    
    /**
     *
     * @param index
     * @return
     */
    public abstract String lerCodigo(int index);
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean conten(String codigo) {
        return codigos.contains(codigo);
    }
    
    /**
     *
     * @return
     */
    public List<String> getCodigos() {
        return new ArrayList(codigos);
    }
}
