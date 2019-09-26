package Presentacion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

public class ControladorS implements KeyListener {

    private VistaStart vistaStart;
    private int  contador=0;


    public ControladorS(VistaStart vistaStart) {
        this.vistaStart = vistaStart;
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
         
    }

    @Override
    public void keyPressed(KeyEvent e) {     
        int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    vistaStart.getModelostart().movI();
                    System.out.println("LEFT"); 
                    break;
                case KeyEvent.VK_RIGHT:
                    vistaStart.getModelostart().movR();
                    System.out.println("RIGHT"); 
                    break;
                case KeyEvent.VK_UP:
                    vistaStart.getModelostart().movU();
                    System.out.println("UP"); 
                    break;
                case KeyEvent.VK_DOWN:
                    vistaStart.getModelostart().movD();
                    System.out.println("DOWN"); 
                    break;
                case KeyEvent.VK_SPACE:
                    System.out.println("SPACE");  
                    break;
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       if(e.getKeyCode()==e.VK_RIGHT){ 
           /*boolean teclado=false;
          int a=0;
        
           vistastart.getModelostart().dibujar(teclado,a);  
           if(contador==4){
               contador=0;
           }
           */
       }
        
    }
    public int getContador() {
        return contador;
    }

}
