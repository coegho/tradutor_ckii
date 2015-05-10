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
    
    public FicheiroDestino(FicheiroCSVOrixe orixe, File ficheiro) {
        this.ficheiro = ficheiro;
        cadeas = new ArrayList<>();
        int i;
        for(i = 0; i < orixe.getSize(); i++) {
            cadeas.add(new CadeaTraducionDestino(orixe.lerCodigo(i),
                    orixe.lerCadea(i, FicheiroCSVOrixe.idiomaBase.POR_DEFECTO)));
        }
    }
    
    public void setTraducion(int index, String texto) {
        cadeas.get(index).setTraducion(texto);
    }
 
    public String getCadea(int index) {
        return cadeas.get(index).getTraducion();
    }

    public void escribirDatos() throws FileNotFoundException, IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new DataOutputStream(new FileOutputStream(ficheiro, false)),
                Charset.forName("ISO-8859-1")));
        
        for(CadeaTraducionDestino c : cadeas) {
            bw.write(c.getCodigo() + ";" + c.getTraducion() + ";;;;;;;;;;;;;x");
            bw.newLine();
        }
        bw.close();
    }
}


class CadeaTraducionDestino extends CadeaTraducion {
    String traducion;
    boolean cambiado = false;

    public CadeaTraducionDestino(String codigo, String texto) {
        this.codigo = codigo;
        this.traducion = texto;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public String getTraducion() {
        return traducion;
    }

    public void setTraducion(String traducion) {
        this.traducion = traducion.replace(";",",").replace("\n"," ").replace("\r","").trim();
    }

}
