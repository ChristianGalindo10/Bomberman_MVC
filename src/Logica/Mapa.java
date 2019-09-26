package Logica;

import java.time.Clock;

public class Mapa {

    private char mapa[][] = new char[15][15];
    private char pared = '*';
    private char bloqued = '1';
    private char bloqueS = '2';
    private char poderes='3';
    private char enemigos='4';
    public Mapa(){
        constrirmapa();
        mostramapa();
    }
    public void constrirmapa() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (i == 0 | j == 0 || i == 14 || j == 14) {
                    mapa[i][j] = pared;
                    
                } else {
                    mapa[i][j] =' ';
                }

            }

        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (i %2== 0 && j%2 == 0 && i != 14&&i!=0&& j != 14&&j!=0) {
                    mapa[i][j] = bloqued;
                }
                
            }     
        }
        int cant = 70;
        for(int a=0;a<15;a++){
            for(int b=0;b<15;b++){
               int i= (int) (Math.random()*14);
               int j= (int) (Math.random()*14);
              if(mapa[a][b]!=pared&&mapa[a][b]!=bloqued){
                    if(i!=2&&j!=2){
                      if(mapa[i][j]!=pared&&mapa[i][j]!=bloqued&&(i+j)!=2&&(i+j)!=5&&(i+j)!=4){
                            mapa[i][j]=getBloqueS();
                            cant= cant-1;
                            System.out.println(i+" "+j);
                            if(cant==0){
                                System.out.println("si entra");
                                break;   
                            }
                       }
                    }
               }
            }
            if(cant==0){
                System.out.println("si entra");
                break;   
            }
        }
        
        
    }
    public void mostramapa(){
        int aux =0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if(mapa[i][j]=='2'){
                    aux+=1;
                }
                System.out.print(mapa[i][j]+" ");
            }     
            System.out.println();
        }
        System.out.println(aux+" "+mapa[1][1]);
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
}
