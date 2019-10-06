package Logica;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Imagenes {

    private ImageIcon pasto;
    private ImageIcon bloqued;
    private ImageIcon inicial;
    private ImageIcon bloques;
    private ImageIcon[] UP_IMAGES;
    private ImageIcon[] DOWN_IMAGES;
    private ImageIcon[] RIGHT_IMAGES;
    private ImageIcon[] LEFT_IMAGES;
    private ImageIcon[] DIE;
    private ImageIcon bombaG;
    private ImageIcon bombaP;

    public ImageIcon getBombaG() {
        return bombaG;
    }

    public ImageIcon getBombaP() {
        return bombaP;
    }

    public void crearBombas() {
        ImageIcon pivot2 = new ImageIcon(getClass().getResource("/IMAGENES/1.png"));
        Image aux2 = pivot2.getImage();
        Image tamaño2 = aux2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        bombaG = new ImageIcon(tamaño2);
        ImageIcon pivot3 = new ImageIcon(getClass().getResource("/IMAGENES/2.png"));
        Image aux3 = pivot3.getImage();
        Image tamaño3 = aux3.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        bombaP = new ImageIcon(tamaño3);
    }

    public void crearImagenes() {
        UP_IMAGES = new ImageIcon[5];
        for (int i = 0; i < UP_IMAGES.length; i++) {
            ImageIcon pivot1 = new ImageIcon(getClass().getResource("/IMAGENES/0" + (i + 1) + ".gif"));
            Image aux1 = pivot1.getImage();
            Image tamaño = aux1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            UP_IMAGES[i] = new ImageIcon(tamaño);
        }
        DOWN_IMAGES = new ImageIcon[5];
        for (int i = 0; i < DOWN_IMAGES.length; i++) {
            ImageIcon pivot1 = new ImageIcon(getClass().getResource("/IMAGENES/" + (i + 11) + ".gif"));
            Image aux1 = pivot1.getImage();
            Image tamaño = aux1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            DOWN_IMAGES[i] = new ImageIcon(tamaño);
        }
        LEFT_IMAGES = new ImageIcon[5];
        for (int i = 0; i < LEFT_IMAGES.length; i++) {
            ImageIcon pivot1 = new ImageIcon(getClass().getResource("/IMAGENES/" + (i + 21) + ".gif"));
            Image aux1 = pivot1.getImage();
            Image tamaño = aux1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            LEFT_IMAGES[i] = new ImageIcon(tamaño);
        }
        RIGHT_IMAGES = new ImageIcon[5];
        for (int i = 0; i < RIGHT_IMAGES.length; i++) {
            ImageIcon pivot1 = new ImageIcon(getClass().getResource("/IMAGENES/" + (i + 31) + ".gif"));
            Image aux1 = pivot1.getImage();
            Image tamaño = aux1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            RIGHT_IMAGES[i] = new ImageIcon(tamaño);
        }
        DIE = new ImageIcon[5];
        for (int i = 0; i < DIE.length; i++) {
            ImageIcon pivot1 = new ImageIcon(getClass().getResource("/IMAGENES/" + (i + 41) + ".gif"));
            Image aux1 = pivot1.getImage();
            Image tamaño = aux1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            DIE[i] = new ImageIcon(tamaño);
        }

    }

    public void cargarFondo() {
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

    public ImageIcon[] getUP_IMAGES() {
        return UP_IMAGES;
    }

    public ImageIcon[] getDOWN_IMAGES() {
        return DOWN_IMAGES;
    }

    public ImageIcon[] getLEFT_IMAGES() {
        return LEFT_IMAGES;
    }

    public ImageIcon[] getRIGHT_IMAGES() {
        return RIGHT_IMAGES;
    }

    public ImageIcon[] getDIE() {
        return DIE;
    }

}
