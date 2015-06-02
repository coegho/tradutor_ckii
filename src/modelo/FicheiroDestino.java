package modelo;

import java.io.File;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coegho
 */
public class FicheiroDestino extends FicheiroCSVAbstracto {

    protected List<CadeaTraducionDestino> cadeas;

    /**
     *
     * @param ficheiro
     * @throws IOException
     */
    public FicheiroDestino(File ficheiro) throws IOException {
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
    public FicheiroDestino(File orixe, File ficheiro) throws IOException {
        this.ficheiro = ficheiro;
        cadeas = new ArrayList<>();
        for (String l : lerCadeasDendeFicheiro(orixe)) {
            cadeas.add(new CadeaTraducionDestino(l));
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
            if (c.haiCambios()) {
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
        return cadeas.get(index).haiCambios();
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

    public boolean haiCambios() {
        return (traducion != null || houboCambios == true);
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

    void aceptarCambios() {
        traducions.set(0, traducion);
        traducion = null;
    }

}
