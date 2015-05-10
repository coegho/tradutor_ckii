package modelo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author coegho
 */
public class FicheiroCSVOrixe extends FicheiroCSVAbstracto {
    
    
    protected List<CadeaTraducionOrixe> cadeas;
    
    public FicheiroCSVOrixe(File ficheiro) throws FileNotFoundException, IOException {
        this.ficheiro = ficheiro;
        nome = ficheiro.getName();
        BufferedReader buffer = new BufferedReader(
                new InputStreamReader(
                        new DataInputStream(
                                new FileInputStream(ficheiro)),Charset.forName("ISO-8859-1")));
        String fila;
        cadeas = new ArrayList<>();
        while((fila = buffer.readLine()) != null) {
            String[] split = fila.split(getDelim());
            cadeas.add(new CadeaTraducionOrixe(split[0],split[1],split[2],split[3],split[5]));
        }
        buffer.close();
    }
    
    public String lerCadea(int index, idiomaBase l) {
        return cadeas.get(index).getIdioma(l);
    }
    
    public String lerCodigo(int index) {
        if(index >= 0 && index < cadeas.size()) {
           return cadeas.get(index).getCodigo();
        }
        else {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    
    public int getSize() {
        return cadeas.size();
    }
    
    public enum idiomaBase {
            POR_DEFECTO, FRANCES, ALEMAN, ESPANHOL;
    }   
 
}

class CadeaTraducionOrixe extends CadeaTraducion {
    final String ingles, frances, aleman, espanhol;

    
    public CadeaTraducionOrixe(String codigo, String ingles, String frances, String aleman, String espanhol) {
        this.codigo = codigo;
        this.ingles = ingles;
        this.frances = frances;
        this.aleman = aleman;
        this.espanhol = espanhol;
    }


    public String getIdioma(FicheiroCSVOrixe.idiomaBase i) {
        switch(i) {
            case POR_DEFECTO:
                return ingles;
            case FRANCES:
                return frances;
            case ALEMAN:
                return aleman;
            case ESPANHOL:
                return espanhol;
            default:
                return ingles;
        }
    }

}
