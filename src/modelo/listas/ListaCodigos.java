package modelo.listas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.FicheiroCSVOrixe;
import modelo.FicheiroDestino;

/**
 *
 * @author coegho
 */
public class ListaCodigos implements ListModel, ListSelectionListener {

    private FicheiroCSVOrixe ficheiroOrixe;
    private FicheiroDestino ficheiroDestino;
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
        for(ListDataListener l : listener) {
                l.contentsChanged(new ListDataEvent(this,
                    ListDataEvent.CONTENTS_CHANGED,0,ficheiroOrixe.getSize()));
        }
    }

    public FicheiroDestino getFicheiroDestino() {
        return ficheiroDestino;
    }

    public void setFicheiroDestino(FicheiroDestino ficheiroDestino) {
        this.ficheiroDestino = ficheiroDestino;
    }
    

    @Override
    public int getSize() {
        if(ficheiroOrixe != null) {
            return ficheiroOrixe.getSize();
        }
        return 0;
    }

    @Override
    public Object getElementAt(int index) {
        return ficheiroOrixe.lerCodigo(index);
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
        setFicheiroOrixe(lf.getFicheiroOrixe(list.getSelectedIndex()));
        for(ListDataListener l : listener) {
            l.contentsChanged(new ListDataEvent(this,
                    ListDataEvent.CONTENTS_CHANGED,0,getFicheiroOrixe().getSize()));
        }
    }

}