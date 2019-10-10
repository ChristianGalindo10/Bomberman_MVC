/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author USUARIO
 */
public class Bomba implements Runnable {
    private Imagenes img;
    private int x,y;
    boolean puesta = true;
    static CopyOnWriteArrayList<Bomba> allBombas = new CopyOnWriteArrayList<Bomba>();
    int size = 40;
    int retraso = 200;
    int temporizadorExplosion = 10;
    private Image imagen;
    Player player;
    Thread pulsate;
    Thread explode;
    //Sonidos sonido;

    public Bomba(int x, int y)  {

        //super(Tipos.TipoBloque.BOMBA, _position);
        img = new Imagenes();
        img.crearBombas();
        setImagen(img.getBombaG().getImage());
        player = Player.getSingletonInstance();
        this.x=x;
        this.y=y;
        pulsate = new Thread(this);
        pulsate.start();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), size, size);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void run() {
        int timer = 0;
        while (timer < temporizadorExplosion) {
            try {
                Thread.sleep(retraso);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            timer++;
            parpadear();
        }
        explotar();
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/IMAGENES/explosion.wav"));
        sonido.play();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bomba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void explotar() {
        player.bombas.remove(0);
        //Fuego.startFire(getX(),getY());
    }

    public void parpadear() {
        if (getImagen().equals(img.getBombaG().getImage())) {
            setX(getX()+5);
            setY(getY()+5 );
            setImagen(img.getBombaP().getImage());
        } else {
            setX(getX()-5 );
            setY(getY()-5 );
            setImagen(img.getBombaG().getImage());
        }
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
}
