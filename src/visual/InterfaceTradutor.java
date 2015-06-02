package visual;

import excepcions.CancelarAccionExcepcion;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import modelo.Configuracion;
import modelo.FicheiroCSVOrixe;
import modelo.FicheiroDestino;
import modelo.listas.ListaCodigos;
import modelo.listas.ListaFicheiros;

/**
 *
 * @author coegho
 */
public class InterfaceTradutor extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public InterfaceTradutor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialEscollerFicheiro = new javax.swing.JFileChooser();
        lblCodigo = new javax.swing.JLabel();
        btbArriba = new javax.swing.JButton();
        btbAbaixo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTraducion = new javax.swing.JTextArea();
        lblEspanhol = new javax.swing.JLabel();
        lblIngles = new javax.swing.JLabel();
        lblFrances = new javax.swing.JLabel();
        lblAleman = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listFicheiros = new javax.swing.JList();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        listCodigos = new javax.swing.JList();
        txtCodigo = new javax.swing.JTextField();
        txtIngles = new javax.swing.JTextField();
        txtFrances = new javax.swing.JTextField();
        txtAleman = new javax.swing.JTextField();
        txtEspanhol = new javax.swing.JTextField();
        lblDestino = new javax.swing.JLabel();
        lblOrixe = new javax.swing.JLabel();
        txtRutaOrixe = new javax.swing.JTextField();
        txtRutaDestino = new javax.swing.JTextField();
        lblGardado = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        mFicheiro = new javax.swing.JMenu();
        miOrixe = new javax.swing.JMenuItem();
        miDestino = new javax.swing.JMenuItem();
        miGardar = new javax.swing.JMenuItem();
        mNavegacion = new javax.swing.JMenu();
        miCopiar = new javax.swing.JMenuItem();
        miRestaurarTraducion = new javax.swing.JMenuItem();

        dialEscollerFicheiro.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Tradutor CKII");
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setName("Tradutor CKII"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblCodigo.setText("Código:");

        btbArriba.setText("↑");
        btbArriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbArribaActionPerformed(evt);
            }
        });

        btbAbaixo.setText("↓");
        btbAbaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbAbaixoActionPerformed(evt);
            }
        });

        txtTraducion.setColumns(20);
        txtTraducion.setLineWrap(true);
        txtTraducion.setRows(3);
        txtTraducion.setWrapStyleWord(true);
        txtTraducion.setEnabled(false);
        txtTraducion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTraducionKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtTraducion);
        txtTraducion.getDocument().addDocumentListener(new CampoTraducionListener(this));

        lblEspanhol.setText("Español:");

        lblIngles.setText("Inglés:");

        lblFrances.setText("Francés:");

        lblAleman.setText("Alemán:");

        listFicheiros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listFicheiros.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listFicheirosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listFicheiros);
        lf = new ListaFicheiros();
        listFicheiros.setModel(lf);

        listCodigos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listCodigos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listCodigosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listCodigos);
        lc = new ListaCodigos(getListaFicheiros());
        listCodigos.setModel(lc);
        listFicheiros.addListSelectionListener(lc);

        txtCodigo.setEditable(false);

        txtIngles.setEditable(false);

        txtFrances.setEditable(false);
        txtFrances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFrancesActionPerformed(evt);
            }
        });

        txtAleman.setEditable(false);

        txtEspanhol.setEditable(false);

        lblDestino.setText("Ruta destino:");

        lblOrixe.setText("Ruta orixe:");

        txtRutaOrixe.setEditable(false);
        txtRutaOrixe.setText("<Sen ruta seleccionada>");

        txtRutaDestino.setEditable(false);
        txtRutaDestino.setText("<Sen ruta seleccionada>");

        lblGardado.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lblGardado.setText("Sen cambios que gardar");

        mFicheiro.setText("Ficheiro");

        miOrixe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        miOrixe.setText("Escoller directorio orixe...");
        miOrixe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOrixeActionPerformed(evt);
            }
        });
        mFicheiro.add(miOrixe);

        miDestino.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        miDestino.setText("Escoller directorio destino...");
        miDestino.setEnabled(false);
        miDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDestinoActionPerformed(evt);
            }
        });
        mFicheiro.add(miDestino);

        miGardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        miGardar.setText("Gardar todos os cambios");
        miGardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGardarActionPerformed(evt);
            }
        });
        mFicheiro.add(miGardar);

        barraMenu.add(mFicheiro);

        mNavegacion.setText("Navegación");

        miCopiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        miCopiar.setText("Copiar do inglés");
        miCopiar.setEnabled(false);
        miCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCopiarActionPerformed(evt);
            }
        });
        mNavegacion.add(miCopiar);

        miRestaurarTraducion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        miRestaurarTraducion.setText("Restaurar tradución");
        miRestaurarTraducion.setEnabled(false);
        miRestaurarTraducion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRestaurarTraducionActionPerformed(evt);
            }
        });
        mNavegacion.add(miRestaurarTraducion);

        barraMenu.add(mNavegacion);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGardado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btbArriba)
                            .addComponent(btbAbaixo)))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblEspanhol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(lblAleman, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFrances, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIngles, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIngles)
                            .addComponent(txtFrances)
                            .addComponent(txtAleman)
                            .addComponent(txtEspanhol)
                            .addComponent(txtCodigo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrixe)
                            .addComponent(lblDestino))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRutaOrixe)
                            .addComponent(txtRutaDestino)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrixe)
                    .addComponent(txtRutaOrixe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestino)
                    .addComponent(txtRutaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngles)
                    .addComponent(txtIngles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrances)
                    .addComponent(txtFrances, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAleman)
                    .addComponent(txtAleman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspanhol)
                    .addComponent(txtEspanhol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btbArriba)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btbAbaixo))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGardado))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String rutaDirectorioOrixe;
    private String rutaDirectorioDestino;
    private ListaFicheiros lf;
    private ListaCodigos lc;
    private FicheiroCSVOrixe ficheiroOrixeActivo;
    private FicheiroDestino ficheiroDestinoActivo;
    int indexActual = -1;
    boolean cambiando = false;
    boolean traducionTocada = false;

    private void btbArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbArribaActionPerformed
        listCodigos.setSelectedIndex(listCodigos.getSelectedIndex() - 1);
    }//GEN-LAST:event_btbArribaActionPerformed

    private void btbAbaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbAbaixoActionPerformed
        listCodigos.setSelectedIndex(listCodigos.getSelectedIndex() + 1);
    }//GEN-LAST:event_btbAbaixoActionPerformed

    private void miOrixeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOrixeActionPerformed
        dialEscollerFicheiro.setCurrentDirectory(new File(Configuracion.getRutaOrixe()));

        File directorio;
        if (dialEscollerFicheiro.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            directorio = dialEscollerFicheiro.getSelectedFile();
            try {
                if (directorio.isDirectory()) {
                    File[] ficheiros = directorio.listFiles(new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.toLowerCase().endsWith(".csv");
                        }
                    });
                    List<FicheiroCSVOrixe> csv = new ArrayList<>();
                    for (File f : ficheiros) {
                        csv.add(new FicheiroCSVOrixe(f));
                    }

                    setRutaDirectorioOrixe(directorio.getAbsolutePath());
                    getListaFicheiros().setFicheirosOrixe(csv);
                    txtTraducion.setEnabled(false);
                    miDestino.setEnabled(true);
                    miCopiar.setEnabled(false);
                    miRestaurarTraducion.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Débese escoller un directorio.");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Non se puido abrir o ficheiro.");
            } catch (CancelarAccionExcepcion ex) {
                JOptionPane.showMessageDialog(this, "Operación cancelada polo usuario.");
            }
        }

    }//GEN-LAST:event_miOrixeActionPerformed

    private void listFicheirosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listFicheirosValueChanged
        if (listFicheiros.getSelectedIndex() < 0) { //non hai ficheiro seleccionado
            return;
        }
        ficheiroOrixeActivo = getListaFicheiros().getFicheiroOrixe(listFicheiros.getSelectedIndex());
        if (getRutaDirectorioDestino() != null) {
            ficheiroDestinoActivo = getListaFicheiros().getFicheiroDestino(listFicheiros.getSelectedIndex());
        }
        listCodigosValueChanged(evt);
    }//GEN-LAST:event_listFicheirosValueChanged

    private void listCodigosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCodigosValueChanged
        boolean g;
        int index = listCodigos.getSelectedIndex();
        //Gárdase a tradución
        if (indexActual != -1 && txtTraducion.isEnabled() && traducionTocada) {
            getFicheiroDestinoActivo().setTraducion(indexActual, txtTraducion.getText());
        }

        //Cárgase a seguinte
        if (index != -1) {
            txtCodigo.setText(getFicheiroOrixeActivo().lerCodigo(index));
            txtIngles.setText(getFicheiroOrixeActivo().lerTraducion(index,
                    FicheiroCSVOrixe.idiomaBase.INGLES));
            txtFrances.setText(getFicheiroOrixeActivo().lerTraducion(index,
                    FicheiroCSVOrixe.idiomaBase.FRANCES));
            txtAleman.setText(getFicheiroOrixeActivo().lerTraducion(index,
                    FicheiroCSVOrixe.idiomaBase.ALEMAN));
            txtEspanhol.setText(getFicheiroOrixeActivo().lerTraducion(index,
                    FicheiroCSVOrixe.idiomaBase.ESPANHOL));
            if (txtTraducion.isEnabled()) {
                cambiando = true;
                txtTraducion.setText(getFicheiroDestinoActivo().getTraducion(index));
                cambiando = false;
            }
        } else {
            txtCodigo.setText("");
            txtIngles.setText("");
            txtFrances.setText("");
            txtAleman.setText("");
            txtEspanhol.setText("");
            if (txtTraducion.isEnabled()) {
                txtTraducion.setText("");
            }
        }
        indexActual = index;
        traducionTocada = false;
        txtTraducion.setEnabled(true);
        miCopiar.setEnabled(true);
        miRestaurarTraducion.setEnabled(true);
    }//GEN-LAST:event_listCodigosValueChanged

    private void txtFrancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFrancesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFrancesActionPerformed

    private void txtTraducionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTraducionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            listCodigos.setSelectedIndex(listCodigos.getSelectedIndex() + 1);
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            listCodigos.setSelectedIndex(listCodigos.getSelectedIndex() - 1);
        }
    }//GEN-LAST:event_txtTraducionKeyPressed

    private void miDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDestinoActionPerformed
        dialEscollerFicheiro.setCurrentDirectory(new File(Configuracion.getRutaDestino()));

        try {
            if (dialEscollerFicheiro.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File directorio = dialEscollerFicheiro.getSelectedFile();
                List<String> faltantes = getListaFicheiros().compararDirectorio(directorio);
                if (faltantes.size() > 0) {
                    //Ao directorio fáltalle algún ficheiro
                    int ret = JOptionPane.showConfirmDialog(this,
                            "O directorio destino non contén todos os ficheiros necesarios. "
                            + "Desexa crealos agora?", "Aviso",
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (ret == JOptionPane.YES_OPTION) {
                        faltantes.clear();
                    } else {
                        throw new CancelarAccionExcepcion();
                    }
                }

                setRutaDirectorioDestino(directorio.getAbsolutePath());
                getListaFicheiros().cargarFicheirosDestino(directorio);
                mostrarEstadoGardado();

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu un erro cos ficheiros. Comprobe os permisos do directorio.");
        } catch (CancelarAccionExcepcion ex) {
            JOptionPane.showMessageDialog(this, "Operación cancelada polo usuario.");
        }
    }//GEN-LAST:event_miDestinoActionPerformed

    private void miCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCopiarActionPerformed
        txtTraducion.append(txtIngles.getText());
    }//GEN-LAST:event_miCopiarActionPerformed

    private void miGardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGardarActionPerformed
        try {
            gardarDatos();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu un erro cos ficheiros. Comprobe os permisos do directorio.");
        }
    }//GEN-LAST:event_miGardarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            confirmarGardado();
            Configuracion.gardarConfiguracion();
            System.exit(0);
        } catch (CancelarAccionExcepcion ex) {
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu un erro cos ficheiros. Comprobe os permisos do directorio.");
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Configuracion.cargarConfiguracion();
    }//GEN-LAST:event_formWindowOpened

    private void miRestaurarTraducionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRestaurarTraducionActionPerformed
        String cadeaOrixe = getFicheiroOrixeActivo().lerCadea(indexActual);
        getFicheiroDestinoActivo().restaurarTraducion(indexActual, cadeaOrixe);
        cambiando = true;
        txtTraducion.setText(getFicheiroOrixeActivo().lerTraducion(indexActual, FicheiroCSVOrixe.idiomaBase.INGLES));
        cambiando = false;
        traducionTocada = false;
    }//GEN-LAST:event_miRestaurarTraducionActionPerformed

    /**
     *
     * @return
     */
    public String getRutaDirectorioOrixe() {
        return rutaDirectorioOrixe;
    }

    /**
     *
     * @param rutaDirectorioOrixe
     * @throws CancelarAccionExcepcion
     * @throws IOException
     */
    public void setRutaDirectorioOrixe(String rutaDirectorioOrixe) throws CancelarAccionExcepcion, IOException {
        this.rutaDirectorioOrixe = rutaDirectorioOrixe;
        setRutaDirectorioDestino(null);
        txtRutaOrixe.setText(rutaDirectorioOrixe);
        if (rutaDirectorioOrixe != null) {
            Configuracion.setRutaOrixe(rutaDirectorioOrixe);
        }
    }

    /**
     *
     * @return
     */
    public String getRutaDirectorioDestino() {
        return rutaDirectorioDestino;
    }

    /**
     *
     * @param rutaDirectorioDestino
     * @throws CancelarAccionExcepcion
     * @throws IOException
     */
    public void setRutaDirectorioDestino(String rutaDirectorioDestino) throws CancelarAccionExcepcion, IOException {
        if (this.rutaDirectorioDestino != null) {
            //Xa se escolleu un directorio de destino
            confirmarGardado();
        } else {

        }
        this.rutaDirectorioDestino = rutaDirectorioDestino;
        txtRutaDestino.setText(rutaDirectorioDestino);
        if (rutaDirectorioDestino != null) {
            Configuracion.setRutaDestino(rutaDirectorioDestino);
        }
    }

    public boolean senCambios() {
        return numFicheirosCambiados() == 0;
    }

    public int numLinhasCambiadas() {
        if (getFicheiroDestinoActivo() != null) {
            return ficheiroDestinoActivo.getNumCambios();
        } else {
            return 0;
        }
    }

    /**
     *
     * @return
     */
    public int numFicheirosCambiados() {
        if (getListaFicheiros() != null) {
            return getListaFicheiros().numFicheirosCambiados();
        } else {
            return 0;
        }
    }

    /**
     *
     */
    public void mostrarEstadoGardado() {
        if (senCambios()) {
            lblGardado.setText("Sen cambios que gardar");
        } else {
            lblGardado.setText("Ficheiros modificados");
        }
    }

    /**
     *
     * @return
     */
    public boolean isLinhaCambiada() {
        if (getFicheiroDestinoActivo() != null) {
            return getFicheiroDestinoActivo().haiCambios(indexActual);
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public FicheiroCSVOrixe getFicheiroOrixeActivo() {
        return ficheiroOrixeActivo;
    }

    /**
     *
     * @param ficheiroOrixeActivo
     */
    public void setFicheiroOrixeActivo(FicheiroCSVOrixe ficheiroOrixeActivo) {
        this.ficheiroOrixeActivo = ficheiroOrixeActivo;
    }

    /**
     *
     * @return
     */
    public FicheiroDestino getFicheiroDestinoActivo() {
        return ficheiroDestinoActivo;
    }

    /**
     *
     * @param ficheiroDestinoActivo
     */
    public void setFicheiroDestinoActivo(FicheiroDestino ficheiroDestinoActivo) {
        this.ficheiroDestinoActivo = ficheiroDestinoActivo;
    }

    /**
     *
     */
    public void notificarCambioNaTraducion() {
        if (!cambiando) {
            traducionTocada = true;
        }
    }

    /**
     *
     * @throws CancelarAccionExcepcion
     * @throws IOException
     */
    public void confirmarGardado() throws CancelarAccionExcepcion, IOException {
        if (indexActual != -1 && txtTraducion.isEnabled() && traducionTocada) {
            ficheiroDestinoActivo.setTraducion(indexActual, txtTraducion.getText());
        }
        if (senCambios()) {
            return; //Xa está gardado
        }
        int ret = JOptionPane.showConfirmDialog(this, "Desexa gardar os cambios realizados?",
                "Pregunta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (ret == JOptionPane.CANCEL_OPTION) {
            throw new CancelarAccionExcepcion();
        }
        if (ret == JOptionPane.YES_OPTION) {
            gardarDatos();
        }
    }

    private ListaFicheiros getListaFicheiros() {
        return lf;
    }

    private void setListaFicheiros(ListaFicheiros lf) {
        this.lf = lf;
        setListaCodigos(null);
    }

    private ListaCodigos getListaCodigos() {
        return lc;
    }

    private void setListaCodigos(ListaCodigos lc) {
        this.lc = lc;
        txtTraducion.setEnabled(lc != null);
    }
    
    /**
     *
     * @throws IOException
     */
    public void gardarDatos() throws IOException {
        if (indexActual != -1 && txtTraducion.isEnabled() && traducionTocada) {
            ficheiroDestinoActivo.setTraducion(indexActual, txtTraducion.getText());
        }
        getListaFicheiros().gardarDatos();
        mostrarEstadoGardado();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceTradutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfaceTradutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btbAbaixo;
    private javax.swing.JButton btbArriba;
    private javax.swing.JFileChooser dialEscollerFicheiro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAleman;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblEspanhol;
    private javax.swing.JLabel lblFrances;
    private javax.swing.JLabel lblGardado;
    private javax.swing.JLabel lblIngles;
    private javax.swing.JLabel lblOrixe;
    private javax.swing.JList listCodigos;
    private javax.swing.JList listFicheiros;
    private javax.swing.JMenu mFicheiro;
    private javax.swing.JMenu mNavegacion;
    private javax.swing.JMenuItem miCopiar;
    private javax.swing.JMenuItem miDestino;
    private javax.swing.JMenuItem miGardar;
    private javax.swing.JMenuItem miOrixe;
    private javax.swing.JMenuItem miRestaurarTraducion;
    private javax.swing.JTextField txtAleman;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEspanhol;
    private javax.swing.JTextField txtFrances;
    private javax.swing.JTextField txtIngles;
    private javax.swing.JTextField txtRutaDestino;
    private javax.swing.JTextField txtRutaOrixe;
    private javax.swing.JTextArea txtTraducion;
    // End of variables declaration//GEN-END:variables


}

class CampoTraducionListener implements DocumentListener {

    InterfaceTradutor pai;

    CampoTraducionListener(InterfaceTradutor pai) {
        this.pai = pai;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        pai.notificarCambioNaTraducion();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        pai.notificarCambioNaTraducion();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        pai.notificarCambioNaTraducion();
    }
}
