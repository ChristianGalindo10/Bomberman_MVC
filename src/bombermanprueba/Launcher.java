package bombermanprueba;

import Presentacion.Modelo;
import Presentacion.Vista;

public class Launcher {
    private Modelo miapp;

    public Launcher() {
        miapp= new Modelo();
        this.miapp=miapp;
        miapp.iniciar(1);
        
    }
    
    
    public static void main(String[] args) {
        new Launcher();    
    }

}
