package modelo.listas;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import modelo.FicheiroCSVOrixe;
import modelo.FicheiroDestino;

/**
 *
 * @author coegho
 */
public class ListaFicheiros implements ListModel {

    private File directorioDestino;
    private List<FicheiroCSVOrixe> ficheirosOrixe;
    private List<FicheiroDestino> ficheirosDestino;
    private final List<ListDataListener> listener = new ArrayList<>();

    /**
     *
     */
    public ListaFicheiros() {
        
    }

    public void setFicheirosOrixe(List<FicheiroCSVOrixe> ficheirosOrixe) {
        this.ficheirosOrixe = ficheirosOrixe;
        for(ListDataListener l : listener) {
            l.contentsChanged(new ListDataEvent(this,
                    ListDataEvent.CONTENTS_CHANGED,0,ficheirosOrixe.size()));
        }
    }
    /**
     *
     * @param ficheirosDestino
     */
    public void setFicheirosDestino(List<FicheiroDestino> ficheirosDestino) {
        this.ficheirosDestino = ficheirosDestino;
    }
    

    /**
     *
     * @param index
     * @return
     */
    public FicheiroCSVOrixe getFicheiroOrixe(int index) {
        return ficheirosOrixe.get(index);
    }

    /**
     *
     * @param index
     * @return
     */
    public FicheiroDestino getFicheiroDestino(int index) {
        return ficheirosDestino.get(index);
    }

    /**
     *
     * @param directorioDestino
     */
    public void setDirectorioDestino(File directorioDestino) {
        this.directorioDestino = directorioDestino;
    }

    /**
     *
     * @return
     */
    public File getDirectorioDestino() {
        return directorioDestino;
    }

    
    /**
     *
     * @param d
     * @return
     */
    public List<String> compararDirectorio(File d) {
        List<String> saida = new ArrayList<>();
        List<String> nomesFicheiros = Arrays.asList(d.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".csv");
            }
        }));
        for (FicheiroCSVOrixe csv : ficheirosOrixe) {
            if (!nomesFicheiros.contains(csv.getNome())) {
                saida.add(csv.getNome());
            }
        }
        return saida;
    }
    
    /**
     *
     * @throws IOException
     */
    public void gardarDatos() throws IOException {
        for (FicheiroDestino f : ficheirosDestino) {
            f.escribirDatos();
        }
    }

    @Override
    public int getSize() {
        if(ficheirosOrixe != null) {
            return ficheirosOrixe.size();
        }
        else {
            return 0;
        }
    }

    @Override
    public Object getElementAt(int index) {
        return ficheirosOrixe.get(index).getNome();
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        listener.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        listener.remove(l);
    }

    /**
     *
     * @param destino
     * @throws IOException
     */
    public void cargarFicheirosDestino(File destino) throws IOException {
        directorioDestino = destino;
        ficheirosDestino = new ArrayList<>();
        for (FicheiroCSVOrixe orixe : ficheirosOrixe) {
            File f = new File(destino, orixe.getNome());
            if (f.exists()) {
                //Tomamos o destino como "orixe" para cargar os datos que xa teña
                ficheirosDestino.add(new FicheiroDestino(f));
            } else {
                //Tomamos o orixe como "molde" por defecto
                ficheirosDestino.add(new FicheiroDestino(orixe.getFicheiro(), f));
            }
        }
    }

    /**
     *
     * @return
     */
    public int numFicheirosCambiados() {
        int ret = 0;
        if (ficheirosDestino == null) {
            return 0;
        }
        for (FicheiroDestino f : ficheirosDestino) {
            if (f.getNumCambios() > 0) {
                ret++;
            }
        }
        return ret;
    }

}
