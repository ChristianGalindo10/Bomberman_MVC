package Presentacion;


import java.applet.AudioClip;
import javax.swing.JButton;


public class Vista extends javax.swing.JFrame {
   
    private Controlador control ;
    private Modelo modelo;
    public Vista(Modelo m) {
        initComponents();
        modelo=m;
        capturareventos();
        AudioClip sonido;
        sonido=  java.applet.Applet.newAudioClip(getClass().getResource("/IMAGENES/musicafondo.wav"));
        //sonido.play();
    }

    public JButton getBtnayuda() {
        return btnayuda;
    }

    public JButton getBtnpuntajes() {
        return btnpuntajes;
    }

    public JButton getBtnstart() {
        return btnstart;
    }

    public Controlador getControl() {
        if(control==null){
            control = new Controlador (this);   
        }
        return control;
    }
    public Modelo getModelo() {
        return modelo;
    }

    public void capturareventos(){
        btnstart.addActionListener(getControl());
        btnayuda.addActionListener(getControl());
        btnpuntajes.addActionListener(getControl());     
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnstart = new javax.swing.JButton();
        btnayuda = new javax.swing.JButton();
        btnpuntajes = new javax.swing.JButton();
        lbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnstart.setText("start");
        jPanel1.add(btnstart, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 100, 50));

        btnayuda.setText("Ayuda");
        jPanel1.add(btnayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 110, 50));

        btnpuntajes.setText("Puntajes ");
        jPanel1.add(btnpuntajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 100, 50));

        lbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/vista principal 2.jpg"))); // NOI18N
        lbFondo.setText("jLabel2");
        lbFondo.setPreferredSize(new java.awt.Dimension(900, 506));
        jPanel1.add(lbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnayuda;
    private javax.swing.JButton btnpuntajes;
    private javax.swing.JButton btnstart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFondo;
    // End of variables declaration//GEN-END:variables
}
