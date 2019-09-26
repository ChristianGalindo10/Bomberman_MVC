
package Presentacion;

import javax.swing.JButton;

public class VistaAyuda extends javax.swing.JFrame {
     
    private ControladorA control;
    private Modelo modelo;
    public VistaAyuda(Modelo m) {
        modelo=m;
        initComponents();
        Capturareventos();
    }

    public void Capturareventos(){
        btnAtrás.addActionListener(getControl());
    }

    public ControladorA getControl() {
        if(control== null){
            control = new ControladorA(this);
        }
        return control;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public JButton getBtnAtrás() {
        return btnAtrás;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAtrás = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAtrás.setText("Atras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnAtrás, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(429, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addComponent(btnAtrás)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtrás;
    // End of variables declaration//GEN-END:variables
}
