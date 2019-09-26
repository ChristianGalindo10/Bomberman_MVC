package Logica;

import Logica.Tipos.Movimiento;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Player {

    private Imagenes Img;
    private Image[] UP_IMAGES; 
    private Image[] DOWN_IMAGES;
    private Image[] LEFT_IMAGES; 
    private Image[] RIGHT_IMAGES; 
    private Image[] DIE; 
    private boolean vivo = true;
    private Movimiento direccion = Movimiento.STOP;
    private int estado = 0;
    private Posicion posicion;
    private Image imagen;
    private final int playerHeight = 64;
    private final int playerWidth = 32;
    private int velocidad = 2;

    public Player() {
        Img = new Imagenes();
        UP_IMAGES = Img.getUP_IMAGES();
        DOWN_IMAGES = Img.getDOWN_IMAGES();
        LEFT_IMAGES = Img.getLEFT_IMAGES();
        RIGHT_IMAGES = Img.getRIGHT_IMAGES();
        DIE = Img.getDIE();
    }

    
    
    public void setDireccion(Movimiento direccion) {
        this.direccion = direccion;
    }
    
    public Posicion getPosicion(){
        return posicion;
    }

    public Image getImagen() {
        return imagen;
    }
    
    
    public int getX(){
        return this.getPosicion().getxPos();
    }
    public int getY(){
        return this.getPosicion().getyPos();
    }
    
    public void setImage(Image im){
        imagen = im;
    }
    
     public void cycleRight() {
        switch (estado) {
            case 0:
                this.setImage(RIGHT_IMAGES[1]);
                estado = 1;
                break;
            case 1:
                this.setImage(RIGHT_IMAGES[2]);
                estado = 2;
                break;
            case 2:
                this.setImage(RIGHT_IMAGES[3]);
                estado = 3;
                break;
            case 3:
                this.setImage(RIGHT_IMAGES[4]);
                estado = 4;
                break;
            case 4:
                this.setImage(RIGHT_IMAGES[0]);
                estado = 0;
                break;
        }
    }

    public void cycleLeft() {
        switch (estado) {
            case 0:
                this.setImage(LEFT_IMAGES[1]);
                estado = 1;
                break;
            case 1:
                this.setImage(LEFT_IMAGES[2]);
                estado = 2;
                break;
            case 2:
                this.setImage(LEFT_IMAGES[3]);
                estado = 3;
                break;
            case 3:
                this.setImage(LEFT_IMAGES[4]);
                estado = 4;
                break;
            case 4:
                this.setImage(LEFT_IMAGES[0]);
                estado = 0;
                break;
        }
    }

    public void cycleUp() {
        switch (estado) {
            case 0:
                this.setImage(UP_IMAGES[1]);
                estado = 1;
                break;
            case 1:
                this.setImage(UP_IMAGES[2]);
                estado = 2;
                break;
            case 2:
                this.setImage(UP_IMAGES[3]);
                estado = 3;
                break;
            case 3:
                this.setImage(UP_IMAGES[4]);
                estado = 4;
                break;
            case 4:
                this.setImage(UP_IMAGES[0]);
                estado = 0;
                break;
        }
    }

    public void cycleDown() {
        switch (estado) {
            case 0:
                this.setImage(DOWN_IMAGES[1]);
                estado = 1;
                break;
            case 1:
                this.setImage(DOWN_IMAGES[2]);
                estado = 2;
                break;
            case 2:
                this.setImage(DOWN_IMAGES[3]);
                estado = 3;
                break;
            case 3:
                this.setImage(DOWN_IMAGES[4]);
                estado = 4;
                break;
            case 4:
                this.setImage(DOWN_IMAGES[0]);
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
                this.setImage(RIGHT_IMAGES[0]);
                break;
            case LEFT:
                this.setImage(LEFT_IMAGES[0]);
                break;
            case UP:
                this.setImage(UP_IMAGES[0]);
                break;
            case DOWN:
                this.setImage(DOWN_IMAGES[0]);
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
