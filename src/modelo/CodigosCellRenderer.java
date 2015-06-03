package modelo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import modelo.listas.ListaCodigos;

/**
 *
 * @author coegho
 */
public class CodigosCellRenderer extends DefaultListCellRenderer {

    ListaCodigos lc;

    public CodigosCellRenderer(ListaCodigos lc) {
        this.lc = lc;
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if(!lc.getFicheiroDestino().xaTraducida(lc.getCodigo(index))) {
            setForeground(Color.red);
        }
        if(lc.getFicheiroDestino().haiCambios(lc.getCodigo(index))) {
            setFont(getFont().deriveFont(Font.BOLD));
        }
        return this;
    }
    
}
