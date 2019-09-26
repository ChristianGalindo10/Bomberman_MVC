
package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorP implements ActionListener {
    private VistaPuntaje ventanap;

    public ControladorP(VistaPuntaje ventap) {
        this.ventanap = ventap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ventanap.getModelo().iniciar(4);
    }
    
}
