package Presentacion;

import Logica.Add;
import Logica.Bomba;
import Logica.Enemigo;
import Logica.Fuego;
import Logica.Imagenes;
import Logica.Mapa;
import Logica.Player;
import Logica.Tipos;
import Logica.Tipos.Movimiento;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Modelo implements Runnable {

    private Thread hiloDibujo = new Thread();
    private VistaStart ventanaJuego;
    private VistaAyuda ventanaAyuda;
    private VistaPuntaje ventanaPuntaje;
    private Vista ventana;
    private boolean corriendo;
    private BufferedImage dobleBuffer;
    private Player player;
    private int contador;
    private char dmapa[][] = new char[15][15];
    private Imagenes imagenes;
    private Add add;

    public Modelo() {
        player = Player.getSingletonInstance();
        add= new Add();
        add.addEnemies();
        corriendo = true;
        contador = 0;
        dobleBuffer = new BufferedImage(getVentanaJuego().getLienzo().getWidth(), getVentanaJuego().getLienzo().getHeight(), BufferedImage.TYPE_INT_ARGB);
        hiloDibujo = new Thread(this);
    }
    

    public VistaStart getVentanaJuego() {
        if (ventanaJuego == null) {
            ventanaJuego = new VistaStart(this);
        }
        return ventanaJuego;
    }

    public void iniciar(int a) {
        switch (a) {
            case 1:
                getVentana().setVisible(true);
                getVentana().setLocationRelativeTo(null);
                Mapa mimapa = Mapa.getSingletonInstance();
                dmapa = mimapa.getMapa();
                break;
            case 2:
                if (getVentana().isVisible() == true) {
                    getVentana().setVisible(false);
                    getVentanaJuego().setVisible(true);
                    getVentanaJuego().setResizable(false);
                    getVentanaJuego().setLocationRelativeTo(null);

                    hiloDibujo.start();
                } else {
                    getVentanaJuego().setVisible(false);
                    getVentana().setVisible(false);
                }
                break;
            case 3:
                if (getVentana().isVisible() == true) {
                    getVentana().setVisible(false);
                    getVentanaAyuda().setVisible(true);
                    getVentanaAyuda().setLocationRelativeTo(null);
                } else {
                    getVentanaAyuda().setVisible(false);
                    getVentana().setVisible(true);
                }

                break;
            case 4:
                if (getVentana().isVisible() == true) {
                    getVentana().setVisible(false);
                    getVentanaPuntaje().setVisible(true);
                    getVentanaPuntaje().setLocationRelativeTo(null);
                } else {
                    getVentanaPuntaje().setVisible(false);
                    getVentana().setVisible(true);
                }
                break;
        }

    }

    public void Cargarmapa() {
        Canvas lienzo = ventanaJuego.getLienzo();
        Graphics lapizc = lienzo.getGraphics();
        lapizc.drawImage(dobleBuffer, 0, 0, lienzo);
        Graphics lapiz = dobleBuffer.createGraphics();
        imagenes = new Imagenes();
        imagenes.cargarFondo();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {

                if (dmapa[i][j] == '*') {

                    lapiz.drawImage(imagenes.getBloqued().getImage(), (j * 40), (i * 40), lienzo);
                }

                if (dmapa[i][j] == '1') {
                    lapiz.drawImage(imagenes.getBloqued().getImage(), (j * 40), (i * 40), lienzo);

                }
                if (dmapa[i][j] != '*' && dmapa[i][j] != '1') {

                    lapiz.drawImage(imagenes.getPasto().getImage(), (j * 40), (i * 40), lienzo);
                }
                if (dmapa[i][j] == '2' && (i + j) != 2) {
                    lapiz.drawImage(imagenes.getBloques().getImage(), (j * 40), (i * 40), lienzo);
                }
            }
        }
        
        for (Enemigo enemigo : add.getEnemigos()) {
            lapiz.drawImage(enemigo.getImage(), enemigo.getX(), enemigo.getY(), lienzo);
            enemigo.move();
            lapiz.drawRect(enemigo.getX(), enemigo.getY() , 30, 30);
        }
        
         lapiz.drawImage(player.getImagen(), player.getX(), player.getY(), lienzo);
        lapiz.drawRect(player.getX(), player.getY() + 10, 32, 30);
        
        for (Bomba bomba : player.getBombas()) {
            lapiz.drawImage(bomba.getImagen(), bomba.getX(), bomba.getY(), lienzo);
        }
        
        
       
        for (Fuego f : Fuego.fuego) {
            lapiz.drawImage(f.getImagen(), f.getX(), f.getY(), lienzo);
            lapiz.drawRect(f.getX(), f.getY() , 38, 38);
        }
    }

    public VistaAyuda getVentanaAyuda() {
        if (ventanaAyuda == null) {
            ventanaAyuda = new VistaAyuda(this);
        }
        return ventanaAyuda;
    }

    public VistaPuntaje getVentanaPuntaje() {
        if (ventanaPuntaje == null) {
            ventanaPuntaje = new VistaPuntaje(this);
        }
        return ventanaPuntaje;
    }

    public Vista getVentana() {
        if (ventana == null) {
            ventana = new Vista(this);
        }
        return ventana;
    }

    @Override
    public void run() {
        while (ventanaJuego.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
            Cargarmapa();
        }
    }

    public void movR() {
        player.setDireccion(Tipos.Movimiento.RIGHT);
        player.cycleRight();
    }

    public void movI() {
        player.setDireccion(Tipos.Movimiento.LEFT);
        player.cycleLeft();
    }

    public void movU() {
        player.setDireccion(Tipos.Movimiento.UP);
        player.cycleUp();
    }

    public void movD() {
        player.setDireccion(Tipos.Movimiento.DOWN);
        player.cycleDown();
    }

    
    public void stop() {
        player.Stop();
    }

    public void plantBomb() {
        player.plantBomb();
    }

}
