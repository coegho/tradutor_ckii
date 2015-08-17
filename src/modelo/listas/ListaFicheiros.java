package modelo.listas;

import excepcions.MalFormatoExcepcion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import modelo.ficheiros.FicheiroCSVOrixe;
import modelo.ficheiros.FicheiroCSVDestino;

/**
 *
 * @author coegho
 */
public class ListaFicheiros implements ListModel {

    private File directorioOrixe;
    private File directorioDestino;
    private List<String> nomesFicheirosOrixe;
    private List<String> nomesFicheirosDestino;
    private Map<String, FicheiroCSVOrixe> ficheirosOrixe;
    private Map<String, FicheiroCSVDestino> ficheirosDestino;
    private final List<ListDataListener> listener = new ArrayList<>();

    /**
     *
     */
    public ListaFicheiros() {
        
    }

    public void setFicheirosOrixe(Map<String, FicheiroCSVOrixe> ficheirosOrixe) {
        this.ficheirosOrixe = ficheirosOrixe;
    }
    /**
     *
     * @param ficheirosDestino
     */
    public void setFicheirosDestino(Map<String, FicheiroCSVDestino> ficheirosDestino) {
        this.ficheirosDestino = ficheirosDestino;
        for(ListDataListener l : listener) {
            l.contentsChanged(new ListDataEvent(this,
                    ListDataEvent.CONTENTS_CHANGED,0,ficheirosDestino.size()));
        }
    }
    

    /**
     *
     * @param index
     * @return
     */
    public FicheiroCSVOrixe getFicheiroOrixe(int index) {
        return ficheirosOrixe.get(nomesFicheirosOrixe.get(index));
    }

    /**
     *
     * @param index
     * @return
     */
    public FicheiroCSVDestino getFicheiroDestino(int index) {
        return ficheirosDestino.get(nomesFicheirosDestino.get(index));
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
     * @param directorioOrixe
     */
    public void setDirectorioOrixe(File directorioOrixe) {
        this.directorioOrixe = directorioOrixe;
    }

    /**
     *
     * @return
     */
    public File getDirectorioOrixe() {
        return directorioOrixe;
    }

    
    /**
     *
     * @return
     */
    public List<String> compararDirectorios() {
        List<String> saida = new ArrayList<>();
        List<String> nomesFicheiros = 
                Arrays.asList(directorioDestino.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".csv");
            }
        }));
        for (String f : ficheirosOrixe.keySet()) {
            if (!nomesFicheiros.contains(ficheirosOrixe.get(f).getNome())) {
                saida.add(ficheirosOrixe.get(f).getNome());
            }
        }
        return saida;
    }
    
    /**
     *
     * @throws IOException
     */
    public void gardarDatos() throws IOException {
        for (String f : ficheirosDestino.keySet()) {
            ficheirosDestino.get(f).escribirDatos();
        }
    }

    @Override
    public int getSize() {
        if(ficheirosDestino != null) {
            return ficheirosDestino.size();
        }
        else {
            return 0;
        }
    }

    @Override
    public Object getElementAt(int index) {
        return ficheirosDestino.get(nomesFicheirosDestino.get(index)).getNome();
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
     * @param orixe
     * @throws IOException
     * @throws FileNotFoundException
     * @throws MalFormatoExcepcion
     */
    public void cargarFicheirosOrixe(File orixe) throws IOException, FileNotFoundException, MalFormatoExcepcion {
        setDirectorioOrixe(orixe);
        if (orixe.isDirectory()) {
            File[] ficheiros = orixe.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".csv");
                }
            });
            HashMap<String, FicheiroCSVOrixe> csv = new HashMap<>();
            nomesFicheirosOrixe = new ArrayList<>();
            for (File f : ficheiros) {
                csv.put(f.getName(), new FicheiroCSVOrixe(f));
                nomesFicheirosOrixe.add(f.getName());
            }
            setFicheirosOrixe(csv);
            Collections.sort(nomesFicheirosOrixe);
        }
    }
    
    /**
     *
     * @param destino
     * @throws IOException
     * @throws excepcions.MalFormatoExcepcion
     */
    public void cargarFicheirosDestino(File destino) throws IOException, MalFormatoExcepcion {
        setDirectorioDestino(destino);
        
        if (destino.isDirectory()) {
            File[] ficheiros = destino.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".csv");
                }
            });
            HashMap<String, FicheiroCSVDestino> csv = new HashMap<>();
            nomesFicheirosDestino = new ArrayList<>();
            
            for (File f : ficheiros) {
                csv.put(f.getName(), new FicheiroCSVDestino(f));
                nomesFicheirosDestino.add(f.getName());
            }
            
            if(ficheirosOrixe != null) {
                //Engádense os ficheiros que faltan
                for(String f : ficheirosOrixe.keySet()) {
                    if(!nomesFicheirosDestino.contains(f)) {
                        File novoF = new File(directorioDestino, f);
                        FicheiroCSVDestino novoCSV =
                                new FicheiroCSVDestino(ficheirosOrixe.get(f).getFicheiro(),novoF);
                        csv.put(f, novoCSV);
                        nomesFicheirosDestino.add(f);
                    }
                }
            }
            
            setFicheirosDestino(csv);
            Collections.sort(nomesFicheirosDestino);
        }
    }
    
    /**
     *
     * @throws IOException
     * @throws MalFormatoExcepcion
     */
    public void recargarDestino() throws IOException, MalFormatoExcepcion {
        cargarFicheirosDestino(getDirectorioDestino());
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
        for (String f : ficheirosDestino.keySet()) {
            if (ficheirosDestino.get(f).getNumCambios() > 0) {
                ret++;
            }
        }
        return ret;
    }

}
