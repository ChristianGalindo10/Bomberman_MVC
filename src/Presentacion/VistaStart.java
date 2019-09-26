package Presentacion;

import java.awt.Canvas;
import java.io.IOException;
import javax.swing.ImageIcon;

public class VistaStart extends javax.swing.JFrame {

    private Modelo modelostart;
    private ControladorS control;

    public VistaStart(Modelo m) {
        modelostart = m;
        initComponents();
        this.setBounds(0, 0, 606, 629);
        //Lienzo.setBounds(0, 0, 640, 640);
        capturarteclado();
        

    }

    public void capturarteclado() {
        this.addKeyListener(getControl());
    }

    public ControladorS getControl() {
        if (control == null) {
            control = new ControladorS(this);
        }

        return control;
    }

    public Canvas getLienzo() {
        return Lienzo;
    }

    public void setLienzo(Canvas Lienzo) {
        this.Lienzo = Lienzo;
    }

    public Modelo getModelostart() {
        return modelostart;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lienzo = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 600, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas Lienzo;
    // End of variables declaration//GEN-END:variables
}
