
package Logica;

import java.awt.Image;
import java.awt.Rectangle;
import Logica.Tipos.Movimiento;
import java.util.concurrent.CopyOnWriteArrayList;

public class Enemigo{
     boolean vivo;
    int velocidad = 2;
    Imagenes img2;
    Movimiento direction = randomDirection();
    private EvaluarMov evaluar;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    Image img;
    private int x;
    private int y;

    public Enemigo(int x, int y) {
        this.x=x;
        this.y=y;
        evaluar = new EvaluarMov();
        img2=new Imagenes();
        img=img2.getEnemigo().getImage();
        vivo = true;
    }

    public Image getImg() {
        return img;
    }

    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return img;
    }
    
        public void setImage(Image im) {
        img = im;
    }

    public void move() {
        if(direction == Movimiento.STOP) return;
        int r = 0 + (int) (Math.random() * ((25 - 0) + 1));

        if (evaluar.evaluarE(direction,getBounds(direction))) {
            switch (direction) {
                case UP:
                    this.setY(getY() - velocidad);
                    break;
                case DOWN:
                    this.setY(getY() + velocidad);
                    break;
                case LEFT:
                    this.setX(getX() - velocidad);
                    break;
                case RIGHT:
                    this.setX(getX() + velocidad);
                    break;
            }
        } else {
            direction = randomDirection();
        }
    }
    
    

    private Movimiento randomDirection() {
        int r = 0 + (int) (Math.random() * ((3 - 0) + 1));
        if (r == 0) {
            return Movimiento.UP;
        } else if (r == 1) {
            return Movimiento.DOWN;
        } else if (r == 2) {
            return Movimiento.LEFT;
        } else {
            return Movimiento.RIGHT;
        }
    }

    public Rectangle getBounds(Movimiento move) {
        Rectangle rect = null;
        switch (move) {
            case UP:
                rect = new Rectangle(getX(), getY() -10, 30, 30);
                break;
            case DOWN:
                rect = new Rectangle(getX(), getY()+velocidad , 30, 30);
                break;
            case LEFT:
                rect = new Rectangle(getX()-velocidad , getY(), 30, 30);
                break;
            case RIGHT:
                rect = new Rectangle(getX()+velocidad , getY(), 30, 30);
                break;
            case STOP:
                rect = new Rectangle(getX(), getY(), 30, 30);
                break;
        }
        return rect;
    }

    /*
    public void die() {
        direction= Movimiento.STOP;
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int c = 0; c < 5; c++) {
                    try {
                        setImage(Img.muerteEnemigo[c]);
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                    }
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
            System.out.println("Enemy -> Die -> Join");
        }
        BomberMan.enemigos.remove(this);
    }*/

   
}
