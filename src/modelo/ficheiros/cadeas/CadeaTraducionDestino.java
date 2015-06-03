package modelo.ficheiros.cadeas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coegho
 */

public class CadeaTraducionDestino extends CadeaTraducion {
    boolean houboCambios = false;
    String traducion;

    public CadeaTraducionDestino(String cadea) {
        super.CadeaTraducion(cadea);
    }

    public String getTraducion() {
        if (traducion != null) {
            return traducion;
        } else {
            return traducions.get(0);
        }
    }

    public void setTraducionsDendeCadea(String cadea) {
        if(this.toString().contentEquals(cadea)) { //xa está gardado así en disco
            houboCambios = false;
        }
        else { //no disco está gardado doutra forma
            construirDendeCadea(cadea);
            houboCambios = true;
        }
        traducion = null;
    }

    public void setTraducion(String traducion) {
        this.traducion = traducion.replace(";", ",").replace("\n", " ").
                replace("\r", "").trim();
        houboCambios = true;
    }

    /**
     * 
     * @return 
     */
    public boolean modificada() {
        return (traducion != null);
    }

    @Override
    public String toString() {
        List<String> ret;
        if (traducion != null) { //Cadea xa traducida
            ret = new ArrayList<>();
            ret.add(getTraducion());
            for (int i = 0; i < traducions.size() - 2; i++) {
                ret.add("");
            }
            ret.add("x");
        } else { //Cadea sen traducir
            ret = traducions;
        }
        return unirCadea(codigo, ret);
    }

    /**
     * Os cambios aceptáronse, de modo que poden suceder dúas cousas:
     * 1. A cadea traduciuse: borrarase todas as traducións básicas (francés,
     * alemán, español).
     * 2. A cadea non se traduciu / restaurouse da orixinal: non sucede nada.
     */
    public void aceptarCambios() {
        if(traducion != null) { //houbo tradución
            for(int i = 1; i < traducions.size(); i++) {
                traducions.set(i, "");
            }
        }
        traducions.set(0, traducion);
        traducion = null;
    }

    
    public boolean xaTraducida() {
        return traducions.get(1).equals("");
    }
}
