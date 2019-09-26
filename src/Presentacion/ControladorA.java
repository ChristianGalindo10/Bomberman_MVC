
package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorA implements ActionListener{
    private VistaAyuda ventanaA;

    public ControladorA(VistaAyuda ventanaA) {
        this.ventanaA = ventanaA;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      ventanaA.getModelo().iniciar(3);
    }
    
}
