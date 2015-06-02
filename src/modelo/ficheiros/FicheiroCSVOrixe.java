package modelo.ficheiros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coegho
 */
public class FicheiroCSVOrixe extends FicheiroCSVAbstracto {

    protected List<CadeaTraducionOrixe> cadeas;

    /**
     *
     * @param ficheiro
     * @throws FileNotFoundException
     * @throws IOException
     */
    public FicheiroCSVOrixe(File ficheiro) throws FileNotFoundException, IOException {
        cadeas = new ArrayList<>();
        for (String l : lerCadeasDendeFicheiro(ficheiro)) {
            cadeas.add(new CadeaTraducionOrixe(l));
        }
    }

    /**
     *
     * @param index
     * @param l
     * @return
     */
    public String lerTraducion(int index, idiomaBase l) {
        return cadeas.get(index).getIdioma(l);
    }

    /**
     *
     * @param index
     * @return
     */
    public String lerCadea(int index) {
        return cadeas.get(index).toString();
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
     * @return
     */
    @Override
    public int getSize() {
        return cadeas.size();
    }

    /**
     *
     * @return
     */
    public File getFicheiro() {
        return ficheiro;
    }

    /**
     *
     */
    public enum idiomaBase {

        INGLES, FRANCES, ALEMAN, ESPANHOL;
    }

}

class CadeaTraducionOrixe extends CadeaTraducion {

    CadeaTraducionOrixe(String cadea) {
        super.CadeaTraducion(cadea);
    }

    public String getIdioma(FicheiroCSVOrixe.idiomaBase i) {
        switch (i) {
            case INGLES:
                return getIngles();
            case FRANCES:
                return getFrances();
            case ALEMAN:
                return getAleman();
            case ESPANHOL:
                return getEspanhol();
            default:
                return getIngles();
        }
    }

    public String getIngles() {
        return traducions.get(0);
    }

    public void setIngles(String ingles) {
        traducions.set(0, ingles);
    }

    public String getFrances() {
        return traducions.get(1);
    }

    public void setFrances(String frances) {
        traducions.set(1, frances);
    }

    public String getAleman() {
        return traducions.get(2);
    }

    public void setAleman(String aleman) {
        traducions.set(2, aleman);

    }

    public String getEspanhol() {
        return traducions.get(4);
    }

    public void setEspanhol(String espanhol) {
        traducions.set(4, espanhol);
    }

}
