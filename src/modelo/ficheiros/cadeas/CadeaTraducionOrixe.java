package modelo.ficheiros.cadeas;

import excepcions.MalFormatoExcepcion;
import modelo.ficheiros.FicheiroCSVOrixe;

public class CadeaTraducionOrixe extends CadeaTraducion {

    public CadeaTraducionOrixe(String cadea) throws MalFormatoExcepcion {
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
