package modelo.ficheiros.cadeas;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author coegho
 */
public abstract class CadeaTraducion {
    protected String codigo;
    protected List<String> traducions;
    protected final String delim = ";";

    /**
     *
     * @param cadea
     */
    public void CadeaTraducion(String cadea) {
        construirDendeCadea(cadea);
    }
    
    /**
     *
     * @param cadea
     */
    public void construirDendeCadea(String cadea) {
        traducions = Arrays.asList(cadea.split(";"));
        codigo = traducions.get(0);
        traducions = traducions.subList(1, traducions.size());
    }
            
    /**
     *
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     * @param traducions
     * @return
     */
    public static String unirCadea(String codigo, List<String> traducions) {
        StringBuilder sb = new StringBuilder(codigo);
        for(String s : traducions) {
            sb.append(";");
            sb.append(s);
        }
        return sb.toString();
    }
            
    @Override
    public String toString() {
        return unirCadea(codigo, traducions);
    }
}
