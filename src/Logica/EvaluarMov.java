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
public class EvaluarMov {
    
    private Mapa mapa;
    private Player player;
    private char mapa2[][] = new char[15][15];

    public boolean evaluar(Movimiento move) {
        player=Player.getSingletonInstance();
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
        
        for (int i = 0; i < mapa2.length; i++) {
            for (int j = 0; j < mapa2.length; j++) {
                if (mapa2[i][j] == '1' || mapa2[i][j] == '2' || mapa2[i][j]=='*') {
                    switch (move) {
                        case UP:
                            if (player.getBounds(move).intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                System.out.println("bloque");
                                return false;
                            }break;
                        case DOWN:
                            if (player.getBounds(move).intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                System.out.println("bloque");
                                return false;
                            }break;
                        case RIGHT:
                            if (player.getBounds(move).intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                System.out.println("bloque");
                                return false;
                            }
                            break;
                        case LEFT:
                            if (player.getBounds(move).intersects(new Rectangle(j * 40, i * 40, 40, 30))) {
                                System.out.println("bloque");
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

    }
    
    
    
