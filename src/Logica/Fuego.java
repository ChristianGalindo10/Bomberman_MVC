/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Tipos.Movimiento;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author USUARIO
 */
public class Fuego implements Runnable{
    
    public static CopyOnWriteArrayList<Fuego> fuego = new CopyOnWriteArrayList<Fuego>();
    int retraso = 300;
    Thread animacionFuego;
    int direccion;
    Imagenes img;
    private Image imagen;
    private int x;
    private int y;

    public Image getImagen() {
        return imagen;
    }

    
    public Fuego( Posicion pos, int dir) {
        this.x=pos.getxPos();
        this.y=pos.getyPos();
        img=new Imagenes();
        img.crearFuego();
        direccion = dir;
        switch (dir) {
            case 1:
                setImage(img.getFuegoCentro().getImage());
                break;
            case 2:
                setImage(img.getFuegoAbajo().getImage());
                break;
            case 3:
                setImage(img.getFuegoIzquierda().getImage());
                break;
            case 4:
                setImage(img.getFuegoDerecha().getImage());
                break;
            case 5:
                setImage(img.getFuegoArriba().getImage());
                break;
        }

        fuego.add(this);
        animacionFuego = new Thread(this);
        animacionFuego.start();
    }

    
    public static void startFire(int w, int z) {
        Mapa mapa;
        mapa = Mapa.getSingletonInstance();
        int x = w;
        int y = z;
        new Fuego(new Posicion(x,y),1);
        //right = 4
        Posicion right = new Posicion(x + 40, y);
        if (mapa.brickAtPosition(right)==0) {
            new Fuego(right, 4);
        }
        //down = 2
         Posicion down = new Posicion(x, y+40);
        if (mapa.brickAtPosition(down)==0) {
            new Fuego(down, 2);
        }
        Posicion left = new Posicion(x-40, y);
        if (mapa.brickAtPosition(left)==0) {
            new Fuego(left, 3);
        }
        Posicion up = new Posicion(x, y-40);
        if (mapa.brickAtPosition(up)==0) {
            new Fuego(up, 5);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
    @Override
    public void run() {
        final Fuego c = this;
        try {
            Thread.sleep(retraso);
            fuego.remove(c);
            //romperBloque();
            //matarEnemigos();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }
    
     public static int round(int x) {
        for (int i = 0; i < 1000; i = i + 40) {
            if (x < i) {
                x = i - 40;
                break;
            }
        }
        return x;
    }

    private void setImage(Image image) {
        imagen=image;
    }
}
