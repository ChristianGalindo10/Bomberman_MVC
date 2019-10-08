/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Image;
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

    public Image getImagen() {
        return imagen;
    }

    
    public Fuego(final Posicion _position, int dir) {
        //super(Tipos.TipoBloque.FUEGO, _position);
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
        int x = round(w);
        int y = round(z);
        Fuego f = new Fuego(new Posicion(x, y), 1);
        //right = 4
        Posicion right = new Posicion(x + 50, y);
        //if (BomberMan.mapa.brickAtPosition(right) == 0) {
            new Fuego(right, 4);
        //}
        //down = 2
        Posicion down = new Posicion(x, y + 50);
        //if (BomberMan.mapa.brickAtPosition(down) == 0) {
            new Fuego(down, 2);
        //}
        Posicion left = new Posicion(x - 50, y);
        //if (BomberMan.mapa.brickAtPosition(left) == 0) {
            new Fuego(left, 3);
        //}
        Posicion up = new Posicion(x, y - 50);
        //if (BomberMan.mapa.brickAtPosition(up) == 0) {
            new Fuego(up, 5);
        //}
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
        for (int i = 0; i < 1000; i = i + 50) {
            if (x < i) {
                x = i - 50;
                break;
            }
        }
        return x;
    }

    private void setImage(Image image) {
        imagen=image;
    }
}
