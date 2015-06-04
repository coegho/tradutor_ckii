package modelo.listas;

import excepcions.MalFormatoExcepcion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.ficheiros.FicheiroCSVOrixe;
import modelo.ficheiros.FicheiroCSVDestino;

/**
 *
 * @author coegho
 */
public class ListaCodigos implements ListModel, ListSelectionListener {

    private FicheiroCSVOrixe ficheiroOrixe;
    private FicheiroCSVDestino ficheiroDestino;
    ListaFicheiros lf;
    private final List<ListDataListener> listener = new ArrayList<>();
    private List<String> codigosFiltrados;
    private String filtro = "";
    private boolean filtrarNonTraducidas = false;

    /**
     *
     * @param lf
     */
    public ListaCodigos(ListaFicheiros lf) {
        this.lf = lf;
        codigosFiltrados = new ArrayList<>();
    }


    public FicheiroCSVOrixe getFicheiroOrixe() {
        return ficheiroOrixe;
    }

    public void setFicheiroOrixe(FicheiroCSVOrixe ficheiroOrixe) {
        this.ficheiroOrixe = ficheiroOrixe;
        
    }

    public FicheiroCSVDestino getFicheiroDestino() {
        return ficheiroDestino;
    }

    public void setFicheiroDestino(FicheiroCSVDestino ficheiroDestino) {
        this.ficheiroDestino = ficheiroDestino;
        this.borrarFiltros();
        this.aplicarFiltro();
        for(ListDataListener l : listener) {
                l.contentsChanged(new ListDataEvent(this,
                    ListDataEvent.CONTENTS_CHANGED,0,ficheiroDestino.getSize()));
        }
    }
    

    @Override
    public int getSize() {
        return codigosFiltrados.size();
    }

    @Override
    public Object getElementAt(int index) {
        //return ficheiroDestino.lerCodigo(index);
        return getCodigo(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        listener.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        listener.remove(l);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //Chámase cando cambia a lista de códigos
        JList list = (JList) e.getSource();
        setFicheiroDestino(lf.getFicheiroDestino(list.getSelectedIndex()));
        for(ListDataListener l : listener) {
            l.contentsChanged(new ListDataEvent(this,
                    ListDataEvent.CONTENTS_CHANGED,0,codigosFiltrados.size()));
        }
    }
    
    /**
     *
     */
    public void aplicarFiltro() {
        if(getFicheiroDestino() == null) {
            return;
        }
        List<String> novosCodigos = new ArrayList<>();
        for(String c : codigosFiltrados) {
            if((!filtrarNonTraducidas || !getFicheiroDestino().xaTraducida(c)) &&
                    getFicheiroDestino().lerCadea(c).contains(filtro)) {
                novosCodigos.add(c);
            }
        }
        codigosFiltrados = novosCodigos;
        for(ListDataListener l : listener) {
            l.contentsChanged(new ListDataEvent(this,
                    ListDataEvent.CONTENTS_CHANGED,0,codigosFiltrados.size()));
        }
    }
    
    /**
     *
     */
    public void borrarFiltros() {
        if(getFicheiroDestino() == null) {
            return;
        }
        codigosFiltrados = getFicheiroDestino().getCodigos();
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public boolean isFiltrarNonTraducidas() {
        return filtrarNonTraducidas;
    }

    public void setFiltrarNonTraducidas(boolean filtrarNonTraducidas) {
        this.filtrarNonTraducidas = filtrarNonTraducidas;
    }

    /**
     * Escribe unha tradución. A clase ListaCodigos encárgase de convertir o
     * índice recibido nun código correcto.
     * @param index
     * @param text
     * @deprecated
     */
    public void setTraducion(int index, String text) {
        getFicheiroDestino().setTraducion(codigosFiltrados.get(index), text);
    }
    
    /**
     * Escribe unha tradución.
     * @param codigo
     * @param text
     */
    public void setTraducion(String codigo, String text) {
        getFicheiroDestino().setTraducion(codigo, text);
    }

    /**
     * Devolve unha tradución. A clase ListaCodigos encárgase de convertir o
     * índice recibido nun código correcto.
     * @param index
     * @return
     * @deprecated 
     */
    public String getTraducion(int index) {
        return getFicheiroDestino().getTraducion(codigosFiltrados.get(index));
    }
    
    /**
     * Devolve unha tradución.
     * @param codigo
     * @return
     */
    public String getTraducion(String codigo) {
        return getFicheiroDestino().getTraducion(codigo);
    }

    /**
     *
     * @param index
     * @param cadeaOrixe
     */
    public void restaurarTraducion(int index, String cadeaOrixe) throws MalFormatoExcepcion {
        getFicheiroDestino().restaurarTraducion(codigosFiltrados.get(index), cadeaOrixe);
    }
    
    /**
     *
     * @param index
     * @return
     */
    public String getCodigo(int index) {
        return codigosFiltrados.get(index);
    }

}