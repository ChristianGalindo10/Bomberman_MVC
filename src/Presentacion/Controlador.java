package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private Vista vista;

    public Controlador(Vista v) {
        vista = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getBtnstart()) {
            vista.getModelo().iniciar(2);
            vista.getModelo().Cargarmapa();
        }
        if (e.getSource() == vista.getBtnayuda()) {
            vista.getModelo().iniciar(3);
        }
        if (e.getSource() == vista.getBtnpuntajes()) {
            vista.getModelo().iniciar(4);
        }
    }

}
