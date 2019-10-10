/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author USUARIO
 */
public class Add {
    private static CopyOnWriteArrayList<Enemigo> enemigos = new CopyOnWriteArrayList<Enemigo>();
    
    public void addEnemies() {
        for (int i = 0; i < 3; i++) {
            enemigos.add(new Enemigo(45, 520));
        }
    }

    public void deleteEnemies(){
        //enemigos.remove(0)
    }
    
    public  CopyOnWriteArrayList<Enemigo> getEnemigos() {
        return enemigos;
    }
    
    
}
