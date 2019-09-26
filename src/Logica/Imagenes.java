package Logica;


import java.awt.Image;
import javax.swing.ImageIcon;

public class Imagenes {

    private Image[] UP_IMAGES = {new ImageIcon("/IMAGENES/01.gif").getImage(),
        new ImageIcon("/IMAGENES/02.gif").getImage(),
        new ImageIcon("/IMAGENES/03.gif").getImage(),
        new ImageIcon("/IMAGENES/04.gif").getImage(),
        new ImageIcon("/IMAGENES/05.gif").getImage()};
    private Image[] DOWN_IMAGES = {new ImageIcon("/IMAGENES/11.gif").getImage(),
        new ImageIcon("/IMAGENES/12.gif").getImage(),
        new ImageIcon("/IMAGENES/13.gif").getImage(),
        new ImageIcon("/IMAGENES/14.gif").getImage(),
        new ImageIcon("/IMAGENES/15.gif").getImage()};
    private Image[] LEFT_IMAGES = {new ImageIcon("/IMAGENES/21.gif").getImage(),
        new ImageIcon("/IMAGENES/22.gif").getImage(),
        new ImageIcon("/IMAGENES/23.gif").getImage(),
        new ImageIcon("/IMAGENES/24.gif").getImage(),
        new ImageIcon("/IMAGENES/25.gif").getImage()};
    private Image[] RIGHT_IMAGES = {new ImageIcon("/IMAGENES/31.gif").getImage(),
        new ImageIcon("/IMAGENES/32.gif").getImage(),
        new ImageIcon("/IMAGENES/33.gif").getImage(),
        new ImageIcon("/IMAGENES/34.gif").getImage(),
        new ImageIcon("/IMAGENES/35.gif").getImage()};
    private Image[] DIE = {new ImageIcon("/IMAGENES/41.gif").getImage(),
        new ImageIcon("/IMAGENES/42.gif").getImage(),
        new ImageIcon("/IMAGENES/43.gif").getImage(),
        new ImageIcon("/IMAGENES/44.gif").getImage(),
        new ImageIcon("/IMAGENES/45.gif").getImage(),
        new ImageIcon("/IMAGENES/46.gif").getImage()};
    
    private ImageIcon pasto;
    private ImageIcon bloqued;
    private ImageIcon inicial;
    private ImageIcon bloques;
    
    public void cargarFondo(){
        ImageIcon pivot1 = new ImageIcon(getClass().getResource("/IMAGENES/pasto.gif"));
        Image aux1 = pivot1.getImage();
        Image tamaño = aux1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        pasto = new ImageIcon(tamaño);
        ImageIcon pivot2 = new ImageIcon(getClass().getResource("/IMAGENES/bloqued.gif"));
        Image aux2 = pivot2.getImage();
        Image tamaño2 = aux2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        bloqued = new ImageIcon(tamaño2);
        ImageIcon pivot3 = new ImageIcon(getClass().getResource("/IMAGENES/31.gif"));
        Image aux3 = pivot3.getImage();
        Image tamaño3 = aux3.getScaledInstance(23, 40, Image.SCALE_SMOOTH);
        inicial = new ImageIcon(tamaño3);
        ImageIcon pivot4 = new ImageIcon(getClass().getResource("/IMAGENES/bloques.jpg"));
        Image aux4 = pivot4.getImage();
        Image tamaño4 = aux4.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        bloques = new ImageIcon(tamaño4);
    }

    public ImageIcon getPasto() {
        return pasto;
    }

    public ImageIcon getBloqued() {
        return bloqued;
    }

    public ImageIcon getInicial() {
        return inicial;
    }

    public ImageIcon getBloques() {
        return bloques;
    }
    
    
    
    
    
    public Image[] getUP_IMAGES() {
        return UP_IMAGES;
    }

    public Image[] getDOWN_IMAGES() {
        return DOWN_IMAGES;
    }

    public Image[] getLEFT_IMAGES() {
        return LEFT_IMAGES;
    }

    public Image[] getRIGHT_IMAGES() {
        return RIGHT_IMAGES;
    }

    public Image[] getDIE() {
        return DIE;
    }

}
