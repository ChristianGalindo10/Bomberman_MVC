/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Tipos.Movimiento;
import java.awt.Rectangle;

/**
 *
 * @author USUARIO
 */
public class evaluarMov {
    
    private Mapa mapa;
    private Player player;
    private char mapa2[][] = new char[15][15];

    public void evaluar(Movimiento move) {
        player=Player.getSingletonInstance();
        mapa = Mapa.getSingletonInstance();
        mapa2 = mapa.getMapa();
        for (int i = 0; i < mapa2.length; i++) {
            for (int j = 0; j < mapa2.length; j++) {
                if (mapa2[i][j] == '1' || mapa2[i][j] == '2' || mapa2[i][j]=='*') {
                    switch (move) {
                        case UP:
                            if (player.getBounds(move).intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                player.setMoviendo(false);
                            }
                            break;
                        case DOWN:
                            if (player.getBounds(move).intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                player.setMoviendo(false);
                            }
                            break;
                        case RIGHT:
                            if (player.getBounds(move).intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                player.setMoviendo(false);
                            }
                            break;
                        case LEFT:
                            if (player.getBounds(move).intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                player.setMoviendo(false);
                            }
                            break;
                    }

                }
            }
        }
        player.setMoviendo(true);
    }
    
    public void mostramapa() {
        int aux = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (mapa2[i][j] == '2') {
                    aux += 1;
                }
                System.out.print(mapa2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(aux + " " + mapa2[1][1]);
    }
    }
    
    
    

