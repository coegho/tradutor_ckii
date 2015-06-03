package modelo.ficheiros;

import java.io.File;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.ficheiros.cadeas.CadeaTraducionComentario;
import modelo.ficheiros.cadeas.CadeaTraducionDestino;

/**
 *
 * @author coegho
 */
public class FicheiroCSVDestino extends FicheiroCSVAbstracto {

    private final Map<String, CadeaTraducionDestino> cadeas;

    /**
     *
     * @param ficheiro
     * @throws IOException
     */
    public FicheiroCSVDestino(File ficheiro) throws IOException {
        this.ficheiro = ficheiro;
        cadeas = new HashMap<>();
        codigos = new ArrayList<>();
        int nComentario = 1;
        for (String l : lerCadeasDendeFicheiro(ficheiro)) {
            if(l.charAt(0) != '#') { //cadea normal
                CadeaTraducionDestino c = new CadeaTraducionDestino(l);
                codigos.add(c.getCodigo());
                cadeas.put(c.getCodigo(), c);
            }
            else { //comentario
                String nomeComentario = "Comentario nº " + Integer.toString(nComentario);
                codigos.add(nomeComentario);
                cadeas.put(nomeComentario, new CadeaTraducionComentario(l));
                nComentario++;
            }
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
        cadeas = new HashMap<>();
        codigos = new ArrayList<>();
        for (String l : lerCadeasDendeFicheiro(orixe)) {
            CadeaTraducionDestino c = new CadeaTraducionDestino(l);
            codigos.add(c.getCodigo());
            cadeas.put(c.getCodigo(), c);
        }
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
     * @param index
     * @param texto
     * @deprecated 
     */
    public void setTraducion(int index, String texto) {
        setTraducion(codigos.get(index), texto);
    }
    
    /**
     *
     * @param codigo
     * @param texto
     */
    public void setTraducion(String codigo, String texto) {
        cadeas.get(codigo).setTraducion(texto);
    }

    /**
     *
     * @param index Índice da liña da que se quere obter a tradución.
     * @return
     * @deprecated 
     */
    public String getTraducion(int index) {
        return getTraducion(codigos.get(index));
    }
    
    /**
     *
     * @param codigo Código da liña da que se quere obter a tradución.
     * @return
     */
    public String getTraducion(String codigo) {
        return cadeas.get(codigo).getTraducion();
    }

    /**
     *
     * @param index
     * @param cadeaOrixe
     * @deprecated 
     */
    public void restaurarTraducion(int index, String cadeaOrixe) {
       restaurarTraducion(codigos.get(index), cadeaOrixe);
    }
    
    /**
     *
     * @param codigo
     * @param cadeaOrixe
     */
    public void restaurarTraducion(String codigo, String cadeaOrixe) {
        cadeas.get(codigo).setTraducionsDendeCadea(cadeaOrixe);
    }

    /**
     *
     * @return
     */
    public int getNumCambios() {
        int ret = 0;
        for (String c : cadeas.keySet()) {
            if (cadeas.get(c).modificada()) {
                ret++;
            }
        }
        return ret;
    }

    /**
     *
     * @param index
     * @return
     * @deprecated 
     */
    public boolean haiCambios(int index) {
        return cadeas.get(codigos.get(index)).modificada();
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean haiCambios(String codigo) {
        return cadeas.get(codigo).modificada();
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
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new DataOutputStream(new FileOutputStream(ficheiro, false)),
                Charset.forName("ISO-8859-1")))) {
            //Lese a lista de cadeas para que se garden nunha orde determinada
            for (String c : codigos) {
                bw.write(cadeas.get(c).toString());
                bw.newLine();
                cadeas.get(c).aceptarCambios();
            }
        }
    }

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
     * @return
     */
    @Override
    public int getSize() {
        return cadeas.size();
    }
    
    /**
     *
     * @param index
     * @return
     * @deprecated 
     */
    public boolean xaTraducida(int index) {
        return xaTraducida(codigos.get(index));
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean xaTraducida(String codigo) {
        return cadeas.get(codigo).xaTraducida();
    }


}