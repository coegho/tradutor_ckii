package modelo.ficheiros;

import java.io.File;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coegho
 */
public class FicheiroCSVDestino extends FicheiroCSVAbstracto {

    protected List<CadeaTraducionDestino> cadeas;

    /**
     *
     * @param ficheiro
     * @throws IOException
     */
    public FicheiroCSVDestino(File ficheiro) throws IOException {
        this.ficheiro = ficheiro;
        cadeas = new ArrayList<>();
        for (String l : lerCadeasDendeFicheiro(ficheiro)) {
            cadeas.add(new CadeaTraducionDestino(l));
        }
    }

    /**
     *
     * @param orixe
     * @param ficheiro
     * @throws IOException
     */
    public FicheiroCSVDestino(File orixe, File ficheiro) throws IOException {
        this.ficheiro = ficheiro;
        cadeas = new ArrayList<>();
        for (String l : lerCadeasDendeFicheiro(orixe)) {
            cadeas.add(new CadeaTraducionDestino(l));
        }
    }

    
    /**
     *
     * @param index
     * @return
     */
    @Override
    public String lerCodigo(int index) {
        if (index >= 0 && index < cadeas.size()) {
            return cadeas.get(index).getCodigo();
        } else {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }
    
    /**
     *
     * @param index
     * @param texto
     */
    public void setTraducion(int index, String texto) {
        cadeas.get(index).setTraducion(texto);
    }

    /**
     *
     * @param index
     * @return
     */
    public String getTraducion(int index) {
        return cadeas.get(index).getTraducion();
    }

    /**
     *
     * @param index
     * @param cadeaOrixe
     */
    public void restaurarTraducion(int index, String cadeaOrixe) {
        cadeas.get(index).setTraducionsDendeCadea(cadeaOrixe);
    }

    /**
     *
     * @return
     */
    public int getNumCambios() {
        int ret = 0;
        for (CadeaTraducionDestino c : cadeas) {
            if (c.modificada()) {
                ret++;
            }
        }
        return ret;
    }

    /**
     *
     * @param index
     * @return
     */
    public boolean haiCambios(int index) {
        return cadeas.get(index).modificada();
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void escribirDatos() throws FileNotFoundException, IOException {
        if (getNumCambios() == 0) {
            return;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new DataOutputStream(new FileOutputStream(ficheiro, false)),
                Charset.forName("ISO-8859-1")));

        for (CadeaTraducionDestino c : cadeas) {
            bw.write(c.toString());
            bw.newLine();
            c.aceptarCambios();
        }
        bw.close();
    }

    @Override
    public String lerCadea(int index) {
        return cadeas.get(index).toString();
    }
    
    /**
     *
     * @return
     */
    @Override
    public int getSize() {
        return cadeas.size();
    }
    
    public boolean xaTraducida(int index) {
        return cadeas.get(index).xaTraducida();
    }

}

class CadeaTraducionDestino extends CadeaTraducion {
    boolean houboCambios = false;
    String traducion;

    CadeaTraducionDestino(String cadea) {
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
    void aceptarCambios() {
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
