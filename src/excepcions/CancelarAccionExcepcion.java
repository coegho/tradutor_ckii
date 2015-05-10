

package excepcions;

/**
 *
 * @author coegho
 */
public class CancelarAccionExcepcion extends Exception {

    /**
     * Creates a new instance of <code>CancelarAccionExcepcion</code> without detail message.
     */
    public CancelarAccionExcepcion() {
    }


    /**
     * Constructs an instance of <code>CancelarAccionExcepcion</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CancelarAccionExcepcion(String msg) {
        super(msg);
    }
}
