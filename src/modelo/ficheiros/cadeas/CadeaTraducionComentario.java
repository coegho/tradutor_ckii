package modelo.ficheiros.cadeas;

import excepcions.MalFormatoExcepcion;

/**
 * Clase simple que simula unha liña de tradución, pero en realidade almacena
 * un comentario.
 * @author coegho
 */
public class CadeaTraducionComentario extends CadeaTraducionDestino {

    private String comentario;
    private boolean modificada = false;

    public CadeaTraducionComentario(String comentario) throws MalFormatoExcepcion {
        super(comentario);
        this.comentario = comentario;
    }
    
    
    @Override
    public String toString() {
        return this.comentario;
    }

    @Override
    public void setTraducion(String traducion) {
        if(traducion.equals(comentario)) {
            return;
        }
        if(traducion.charAt(0) != '#') {
            traducion = '#' + traducion;
        }
        this.comentario = traducion;
        modificada = true;
    }

    @Override
    public String getTraducion() {
        return this.comentario;
    }

    @Override
    public boolean xaTraducida() {
        return true;
    }

    @Override
    public boolean modificada() {
        return modificada;
    }

    @Override
    public void aceptarCambios() {
        modificada = false;
    }
    
    
}
