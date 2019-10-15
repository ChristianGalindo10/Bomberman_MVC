package Logica;

import java.time.Clock;

public class Mapa {

    private char mapa[][] = new char[15][15];
    private char pared = '*';
    private char bloqued = '1';
    private char bloqueS = '2';
    private char poderes = '3';
    private char enemigos = '4';
    private Posicion[][] position;
    private static Mapa mapa2;

    private Mapa() {
        position = new Posicion[15][15];
        constrirmapa();
        //mostramapa();
    }

    public void constrirmapa() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                position[i][j] = new Posicion(i * 40, j * 40);
                if (i == 0 || j == 0 || i == 14 || j == 14) {
                    mapa[i][j] = pared;
                    position[i][j] = new Posicion(10000, 10000);

                } else {
                    mapa[i][j] = ' ';
                }

            }

        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (i % 2 == 0 && j % 2 == 0 && i != 14 && i != 0 && j != 14 && j != 0) {
                    mapa[i][j] = bloqued;
                    position[i][j] = new Posicion(10000, 10000);
                }

            }
        }
        int cant = 70;
        for (int a = 0; a < 15; a++) {
            for (int b = 0; b < 15; b++) {
                int i = (int) (Math.random() * 14);
                int j = (int) (Math.random() * 14);
                if (mapa[a][b] != pared && mapa[a][b] != bloqued) {
                    if (i != 2 && j != 2) {
                        if (mapa[i][j] != pared && mapa[i][j] != bloqued && (i + j) != 2 && (i + j) != 5 && (i + j) != 4) {
                            mapa[i][j] = getBloqueS();
                            position[i][j] = new Posicion(10000, 10000);
                            cant = cant - 1;
                            //System.out.println(i + " " + j);
                            if (cant == 0) {
                                //System.out.println("si entra");
                                break;
                            }
                        }
                    }
                }
            }
            
            if (cant == 0) {
                //System.out.println("si entra");
                break;
            }
        }
        mapa[13][1]='p';
    }

    public void mostramapa() {
        int aux = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (mapa[i][j] == '2') {
                    aux += 1;
                }
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(aux + " " + mapa[1][1]);
    }

    public char getPared() {
        return pared;
    }

    public char getBloqued() {
        return bloqued;
    }

    public char getBloqueS() {
        return bloqueS;
    }

    public char[][] getMapa() {
        return mapa;
    }
    

    public static Mapa getSingletonInstance() {
        if (mapa2 == null) {
            mapa2 = new Mapa();
        }
        return mapa2;
    }
    
    
    public int brickAtPosition(Posicion pos) {
        int x = pos.getxPos();
        int y = pos.getyPos();
        x=round(x);
        y=round(y);
        int x2 = (int) x/40;
        int y2 = (int) y/40;
        System.out.println("Rounderd off: " + x + " " + y);
        System.out.println(""+x2+" "+y2);
        
        
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
                
                if (position[i][j].getxPos() == x && position[i][j].getyPos() == y) {
                    //System.out.println(position[i][j].getxPos());
                    return 0;
                }
                
                if(position[i][j].getxPos()<10000 && position[i][j].getyPos()<10000&&mapa[x2][y2]!='*'&&mapa[x2][y2]!='1'&&mapa[x2][y2]!='2'){
                    return 0;
                }
                
            }
        }
        /*
        if(mapa[x2][y2]!='*'&&mapa[x2][y2]!='1'&&mapa[x2][y2]!='2'){
            return 0;
        }*/
        
        return 99;
    }
    
     public int round(int x) {
        for (int i = 0; i < 520; i = i + 40) {
            if (x < i) {
                x = i - 40;
                break;
            }
        }
        return x;
    }
}
