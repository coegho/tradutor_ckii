package modelo.ficheiros.cadeas;

import excepcions.MalFormatoExcepcion;
import java.util.ArrayList;
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
        List<String> traducionsOrixinais = Arrays.asList(cadea.split(";"));
        
        codigo = traducionsOrixinais.get(0);
        if(traducionsOrixinais.size() < 6) {
            //Os ficheiros orixinais teñen demasiados erros de formato, non
            //funcionaría
            //System.out.println(traducions.size());
            //throw new MalFormatoExcepcion(traducions.get(0));
            
            /*Pequeno apaño para pasar por alto os erros de formato de Paradox...
            Dios mío, espero que hayan despedido a alguien por ese patinazo*/
            traducions = new ArrayList<>();
            int i;
            for(i = 1; i < 6; i++) {
                if(traducionsOrixinais.size() > i) { //Atopa cadea
                    traducions.add(traducionsOrixinais.get(i));
                }
            }
            /*Aquí remata o apaño*/
        }
        else {
            traducions = traducionsOrixinais.subList(1, traducionsOrixinais.size());
        }
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
