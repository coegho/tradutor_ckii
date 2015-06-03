package modelo.ficheiros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.ficheiros.cadeas.CadeaTraducionOrixe;

/**
 *
 * @author coegho
 */
public class FicheiroCSVOrixe extends FicheiroCSVAbstracto {

    private final Map<String, CadeaTraducionOrixe> cadeas;

    /**
     *
     * @param ficheiro
     * @throws FileNotFoundException
     * @throws IOException
     */
    public FicheiroCSVOrixe(File ficheiro) throws FileNotFoundException, IOException {
        this.ficheiro = ficheiro;
        cadeas = new HashMap<>();
        codigos = new ArrayList<>();
        for (String l : lerCadeasDendeFicheiro(ficheiro)) {
            CadeaTraducionOrixe c = new CadeaTraducionOrixe(l);
            codigos.add(c.getCodigo());
            cadeas.put(c.getCodigo(), c);
        }
    }

    /**
     *
     * @param index
     * @param l
     * @return
     * @deprecated 
     */
    public String lerTraducion(int index, idiomaBase l) {
        return lerTraducion(codigos.get(index), l);
    }
    
    /**
     *
     * @param codigo
     * @param l
     * @return
     */
    public String lerTraducion(String codigo, idiomaBase l) {
        return cadeas.get(codigo).getIdioma(l);
    }

    /**
     *
     * @param index
     * @return
     * @deprecated
     */
    @Override
    public String lerCadea(int index) {
        return lerCadea(codigos.get(index));
    }
    
    @Override
    public String lerCadea(String codigo) {
         return cadeas.get(codigo).toString();
    }

    /**
     *
     * @param index
     * @return
     * @deprecated 
     */
    @Override
    public String lerCodigo(int index) {
        if (index >= 0 && index < cadeas.size()) {
            return cadeas.get(codigos.get(index)).getCodigo();
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