package modelo.listas;

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

    /**
     *
     * @param lf
     */
    public ListaCodigos(ListaFicheiros lf) {
        this.lf = lf;
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
        for(ListDataListener l : listener) {
                l.contentsChanged(new ListDataEvent(this,
                    ListDataEvent.CONTENTS_CHANGED,0,ficheiroDestino.getSize()));
        }
    }
    

    @Override
    public int getSize() {
        if(ficheiroDestino != null) {
            return ficheiroDestino.getSize();
        }
        return 0;
    }

    @Override
    public Object getElementAt(int index) {
        return ficheiroDestino.lerCodigo(index);
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
                    ListDataEvent.CONTENTS_CHANGED,0,getFicheiroDestino().getSize()));
        }
    }

}