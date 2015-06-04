package excepcions;

/**
 *
 * @author coegho
 */
public class MalFormatoExcepcion extends Exception {
    private String nomeFicheiro, linha;

    public MalFormatoExcepcion(String nomeFicheiro, String linha) {
        this.nomeFicheiro = nomeFicheiro;
        this.linha = linha;
    }

    public MalFormatoExcepcion(String linha) {
        this.linha = linha;
        this.nomeFicheiro = "<descoñecido>";
    }

    public String getNomeFicheiro() {
        return nomeFicheiro;
    }

    public void setNomeFicheiro(String nomeFicheiro) {
        this.nomeFicheiro = nomeFicheiro;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    @Override
    public String getMessage() {
        return "Erro de formato ao ler o ficheiro " + nomeFicheiro + " na liña " 
        + linha;
    }
    
    
}
