package Logica;

import Logica.Tipos.Movimiento;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Player {

    ArrayList<Bomba> bombas = new ArrayList<Bomba>();
    int totalBombas = 1;
    private Imagenes Img;
    private ImageIcon[] UP_IMAGES;
    private ImageIcon[] DOWN_IMAGES;
    private ImageIcon[] LEFT_IMAGES;
    private ImageIcon[] RIGHT_IMAGES;
    private ImageIcon[] DIE;
    private boolean vivo;
    private boolean moviendo;
    private Movimiento direccion = Movimiento.STOP;
    private int estado = 0;
    private Image imagen;
    private evaluarMov evaluar;
    private final int playerHeight = 64;
    private final int playerWidth = 32;
    private static Player player;

    private int velocidad = 2;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    

    private Player() {
        vivo = true;
        moviendo = true;
        Img = new Imagenes();
        evaluar = new evaluarMov();
        Img.crearImagenes();
        UP_IMAGES = Img.getUP_IMAGES();
        DOWN_IMAGES = Img.getDOWN_IMAGES();
        LEFT_IMAGES = Img.getLEFT_IMAGES();
        RIGHT_IMAGES = Img.getRIGHT_IMAGES();
        DIE = Img.getDIE();
        x = 40;
        y = 40;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setDireccion(Movimiento direccion) {
        this.direccion = direccion;
    }

    public void setMoviendo(boolean moviendo) {
        this.moviendo = moviendo;
    }

    public void setImage(Image im) {
        imagen = im;
    }

    public void cycleRight() {
        switch (estado) {
            case 0:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(RIGHT_IMAGES[1].getImage());
                estado = 1;
                x = x + 2;
                break;
            case 1:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(RIGHT_IMAGES[2].getImage());
                estado = 2;
                x = x + 2;
                break;
            case 2:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(RIGHT_IMAGES[3].getImage());
                estado = 3;
                x = x + 2;
                break;
            case 3:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(RIGHT_IMAGES[4].getImage());
                estado = 4;
                x = x + 2;
                break;
            case 4:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(RIGHT_IMAGES[0].getImage());
                estado = 0;
                x = x + 2;
                break;
        }
    }

    public void cycleLeft() {
        switch (estado) {
            case 0:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(LEFT_IMAGES[1].getImage());
                estado = 1;
                x = x - 2;
                break;
            case 1:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(LEFT_IMAGES[2].getImage());
                estado = 2;
                x = x - 2;
                break;
            case 2:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(LEFT_IMAGES[3].getImage());
                estado = 3;
                x = x - 2;
                break;
            case 3:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(LEFT_IMAGES[4].getImage());
                estado = 4;
                x = x - 2;
                break;
            case 4:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(LEFT_IMAGES[0].getImage());
                estado = 0;
                x = x - 2;
                break;
        }
    }

    public void cycleUp() {
        switch (estado) {
            case 0:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(UP_IMAGES[1].getImage());
                estado = 1;
                y = y - 2;
                break;
            case 1:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(UP_IMAGES[2].getImage());
                estado = 2;
                y = y - 2;
                break;
            case 2:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(UP_IMAGES[3].getImage());
                estado = 3;
                y = y - 2;
                break;
            case 3:
                evaluar.evaluar(direccion);
                setImage(UP_IMAGES[4].getImage());
                estado = 4;
                y = y - 2;
                break;
            case 4:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(UP_IMAGES[0].getImage());
                estado = 0;
                y = y - 2;
                break;
        }
    }

    public void cycleDown() {
        switch (estado) {
            case 0:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(DOWN_IMAGES[1].getImage());
                estado = 1;
                y = y + 2;
                break;
            case 1:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(DOWN_IMAGES[2].getImage());
                estado = 2;
                y = y + 2;
                break;
            case 2:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(DOWN_IMAGES[3].getImage());
                estado = 3;
                y = y + 2;
                break;
            case 3:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(DOWN_IMAGES[4].getImage());
                estado = 4;
                y = y + 2;
                break;
            case 4:
                evaluar.evaluar(direccion);
                System.out.println(moviendo);
                setImage(DOWN_IMAGES[0].getImage());
                estado = 0;
                y = y + 2;
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
        Rectangle rect = new Rectangle(getX(), getY() + 10, playerWidth, 30);
        switch (move) {
            case UP:
                rect = new Rectangle(getX(), getY() + 10 - velocidad, playerWidth, 30);
                break;
            case DOWN:
                rect = new Rectangle(getX(), getY() + 10 + velocidad, playerWidth, 30);
                break;
            case LEFT:
                rect = new Rectangle(getX() - velocidad, getY() + 10, playerWidth, 30);
                break;
            case RIGHT:
                rect = new Rectangle(getX() + velocidad, getY() + 10, playerWidth, 30);
                break;
        }
        return rect;
    }

    public static Player getSingletonInstance() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    public void plantBomb() {
        int x2 = getX();
        int y2 = getY();
     

        if (totalBombas > bombas.size()) {
            Bomba bomba = new Bomba(x2,y2);
            bombas.add(bomba);
            Bomba.allBombas.add(bomba);
        }
    }

    public ArrayList<Bomba> getBombas() {
        return bombas;
    }

}
