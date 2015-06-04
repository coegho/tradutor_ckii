package modelo.ficheiros.cadeas;

import excepcions.MalFormatoExcepcion;
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
     * @throws excepcions.MalFormatoExcepcion
     */
    public void CadeaTraducion(String cadea) throws MalFormatoExcepcion {
        construirDendeCadea(cadea);
    }
    
    /**
     *
     * @param cadea
     * @throws excepcions.MalFormatoExcepcion
     */
    public void construirDendeCadea(String cadea) throws MalFormatoExcepcion {
        traducions = Arrays.asList(cadea.split(";"));
        if(traducions.size() < 6 /*|| !"x".equals(traducions.get(14))*/) {
            /*Os ficheiros orixinais teñen demasiados erros de formato, non
            funcionaría*/
            System.out.println(traducions.size());
            throw new MalFormatoExcepcion(traducions.get(0));
        }
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
