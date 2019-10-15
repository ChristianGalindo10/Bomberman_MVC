/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Tipos.Movimiento;
import java.awt.Rectangle;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author USUARIO
 */
public class EvaluarMov {

    private Mapa mapa;
    private Player player;
    Add add;
    private char mapa2[][] = new char[15][15];

    public boolean evaluar(Movimiento move) {
        add = new Add();
        player = Player.getSingletonInstance();
        mapa = Mapa.getSingletonInstance();
        mapa2 = mapa.getMapa();

        for (Bomba b : player.bombas) {
            if (!b.puesta) {
                if (b.getBounds().intersects(player.getBounds(move))) {
                    return false;
                }
            } else {
                if (!b.getBounds().intersects(player.getBounds(move))) {
                    b.puesta = false;
                }
            }
        }
        /*
        for (Enemigo enemigo : add.getEnemigos()) {
            if (player.getBounds(Movimiento.STOP).intersects(enemigo.getBounds(Movimiento.STOP))) {
                System.out.println("DEAD");
                player.DIE();
            }
        }*/

        for (int i = 0; i < mapa2.length; i++) {
            for (int j = 0; j < mapa2.length; j++) {
                if (mapa2[i][j] == '1' || mapa2[i][j] == '2' || mapa2[i][j] == '*') {
                    switch (move) {
                        case UP:
                            if (player.getBounds(move).intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                //System.out.println("bloque");
                                return false;
                            }
                            break;
                        case DOWN:
                            if (player.getBounds(move).intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                //System.out.println("bloque");
                                return false;
                            }
                            break;
                        case RIGHT:
                            if (player.getBounds(move).intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                //System.out.println("bloque");
                                return false;
                            }
                            break;
                        case LEFT:
                            if (player.getBounds(move).intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                //System.out.println("bloque");
                                return false;
                            }
                            break;
                    }

                }
            }
        }
        //player.setMoviendo(true);
        return true;
    }

    public boolean evaluarE(Movimiento move, Rectangle rect) {
        player = Player.getSingletonInstance();
        mapa = Mapa.getSingletonInstance();
        mapa2 = mapa.getMapa();

        for (Bomba b : player.bombas) {
            if (b.getBounds().intersects(rect)) {
                return false;
            }
        }
        for (int i = 0; i < mapa2.length; i++) {
            for (int j = 0; j < mapa2.length; j++) {
                if (mapa2[i][j] == '1' || mapa2[i][j] == '2' || mapa2[i][j] == '*') {
                    switch (move) {
                        case UP:
                            if (rect.intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                //System.out.println("bloque");
                                return false;
                            }
                            break;
                        case DOWN:
                            if (rect.intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                //System.out.println("bloque");
                                return false;
                            }
                            break;
                        case RIGHT:
                            if (rect.intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                //System.out.println("bloque");
                                return false;
                            }
                            break;
                        case LEFT:
                            if (rect.intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                //System.out.println("bloque");
                                return false;
                            }
                            break;
                    }

                }
            }
        }

        if (player.getBounds(Movimiento.STOP).intersects(rect)) {
            System.out.println("DEAD");
            player.DIE();
        }

        return true;

    }

    /*
    public boolean evaluarBloque(int x, int y) {
        Rectangle rect = null;
        rect = new Rectangle(x, y , 40, 40);
        for (int i = 0; i < mapa2.length; i++) {
            for (int j = 0; j < mapa2.length; j++) {
                if (mapa2[i][j] == '1' || mapa2[i][j] == '2' || mapa2[i][j] == '*') {
                    System.out.println("HOLAAAAAAAA ");
                    if (rect.intersects(new Rectangle(x, y, 40, 30))) {
                       return false;
                    }
                    return false;
                }
            }
        }    
        return true;
    }*/
}
