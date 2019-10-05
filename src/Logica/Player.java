package Logica;

import Logica.Tipos.Movimiento;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;

public class Player {

    private Imagenes Img;
    private ImageIcon[] UP_IMAGES; 
    private ImageIcon[] DOWN_IMAGES;
    private ImageIcon[] LEFT_IMAGES; 
    private ImageIcon[] RIGHT_IMAGES; 
    private ImageIcon[] DIE; 
    private boolean vivo;
    private Movimiento direccion = Movimiento.STOP;
    private int estado = 0;
    private Posicion posicion;
    private Image imagen;
    private final int playerHeight = 64;
    private final int playerWidth = 32;
    private int velocidad = 2;

    public Player() {
        vivo = true;
        Img = new Imagenes();
        Img.crearImagenes();
        UP_IMAGES = Img.getUP_IMAGES();
        DOWN_IMAGES = Img.getDOWN_IMAGES();
        LEFT_IMAGES = Img.getLEFT_IMAGES();
        RIGHT_IMAGES = Img.getRIGHT_IMAGES();
        DIE = Img.getDIE();
    }
    
    
    public Posicion getPosicion(){
        return posicion;
    }

    public Image getImagen() {
        return imagen;
    }
    
    
    public int getX(){
        return getPosicion().getxPos();
    }
    public int getY(){
        return getPosicion().getyPos();
    }
    
    public void setImage(Image im){
        imagen = im;
    }
    
     public void cycleRight() {
        switch (estado) {
            case 0:
                setImage(RIGHT_IMAGES[1].getImage());
                estado = 1;
                break;
            case 1:
                setImage(RIGHT_IMAGES[2].getImage());
                estado = 2;
                break;
            case 2:
                setImage(RIGHT_IMAGES[3].getImage());
                estado = 3;
                break;
            case 3:
                setImage(RIGHT_IMAGES[4].getImage());
                estado = 4;
                break;
            case 4:
                setImage(RIGHT_IMAGES[0].getImage());
                estado = 0;
                break;
        }
    }

    public void cycleLeft() {
        switch (estado) {
            case 0:
                setImage(LEFT_IMAGES[1].getImage());
                estado = 1;
                break;
            case 1:
                setImage(LEFT_IMAGES[2].getImage());
                estado = 2;
                break;
            case 2:
                setImage(LEFT_IMAGES[3].getImage());
                estado = 3;
                break;
            case 3:
                setImage(LEFT_IMAGES[4].getImage());
                estado = 4;
                break;
            case 4:
                setImage(LEFT_IMAGES[0].getImage());
                estado = 0;
                break;
        }
    }

    public void cycleUp() {
        switch (estado) {
            case 0:
                setImage(UP_IMAGES[1].getImage());
                estado = 1;
                break;
            case 1:
                setImage(UP_IMAGES[2].getImage());
                estado = 2;
                break;
            case 2:
                setImage(UP_IMAGES[3].getImage());
                estado = 3;
                break;
            case 3:
                setImage(UP_IMAGES[4].getImage());
                estado = 4;
                break;
            case 4:
                setImage(UP_IMAGES[0].getImage());
                estado = 0;
                break;
        }
    }

    public void cycleDown() {
        switch (estado) {
            case 0:
                setImage(DOWN_IMAGES[1].getImage());
                estado = 1;
                break;
            case 1:
                setImage(DOWN_IMAGES[2].getImage());
                estado = 2;
                break;
            case 2:
                setImage(DOWN_IMAGES[3].getImage());
                estado = 3;
                break;
            case 3:
                setImage(DOWN_IMAGES[4].getImage());
                estado = 4;
                break;
            case 4:
                setImage(DOWN_IMAGES[0].getImage());
                estado = 0;
                break;
        }
    }

    public void Stop() {
        if (!vivo) {
            return;
        }
        switch (direccion) {
            case RIGHT:
                setImage(RIGHT_IMAGES[0].getImage());
                break;
            case LEFT:
                setImage(LEFT_IMAGES[0].getImage());
                break;
            case UP:
                setImage(UP_IMAGES[0].getImage());
                break;
            case DOWN:
                setImage(DOWN_IMAGES[0].getImage());
                break;
        }
        direccion = Movimiento.STOP;
    }

    public Rectangle getBounds(Movimiento move) {
        Rectangle rect = new Rectangle(getX(), getY() + playerHeight - 30, playerWidth, 30);
        switch (move) {
            case UP:
                rect = new Rectangle(getX(), getY() + playerHeight - 30 - velocidad, playerWidth, 30);
                break;
            case DOWN:
                rect = new Rectangle(getX(), getY() + playerHeight - 30 + velocidad, playerWidth, 30);
                break;
            case LEFT:
                rect = new Rectangle(getX() - velocidad, getY() + playerHeight - 30, playerWidth, 30);
                break;
            case RIGHT:
                rect = new Rectangle(getX() + velocidad, getY() + playerHeight - 30, playerWidth, 30);
                break;
        }
        return rect;
    }


}
