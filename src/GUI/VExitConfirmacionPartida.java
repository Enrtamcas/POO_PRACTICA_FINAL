/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author e.tamajon.2020
 */
public class VExitConfirmacionPartida extends javax.swing.JFrame {

    int x, y;

    VPartida vPartida;
    VEntrenamiento vEntrenamiento;

    /**
     * Creates new form VExitConfirmacionPartida
     */
    public VExitConfirmacionPartida(VEntrenamiento vEntrenamiento) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.vEntrenamiento = vEntrenamiento;
    }

    public VExitConfirmacionPartida(VPartida vPartida) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.vPartida = vPartida;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iSalir = new javax.swing.JLabel();
        bSi = new javax.swing.JButton();
        bVolver = new javax.swing.JButton();
        iCabecera = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        iFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_Images/Boton_salir.png"))); // NOI18N
        iSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iSalirMouseClicked(evt);
            }
        });
        getContentPane().add(iSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        bSi.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bSi.setText("Sí");
        bSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSiMouseClicked(evt);
            }
        });
        getContentPane().add(bSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 90, 30));

        bVolver.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bVolver.setText("Volver");
        bVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bVolverMouseClicked(evt);
            }
        });
        getContentPane().add(bVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 90, 30));

        iCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_Images/Cabecera.png"))); // NOI18N
        iCabecera.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        iCabecera.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                iCabeceraMouseDragged(evt);
            }
        });
        iCabecera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iCabeceraMousePressed(evt);
            }
        });
        getContentPane().add(iCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("Si sales ahora, perderás todos los");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setText("¿Estás seguro?");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setText("datos que no hayas guardado.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        iFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_Images/489.jpg"))); // NOI18N
        getContentPane().add(iFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iSalirMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);

        if (vPartida != null) {
            vPartida.setVisible(true);
        }
        if (vEntrenamiento != null)
            vEntrenamiento.setVisible(true);
    }//GEN-LAST:event_iSalirMouseClicked

    private void iCabeceraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iCabeceraMouseDragged
        // TODO add your handling code here:
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_iCabeceraMouseDragged

    private void iCabeceraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iCabeceraMousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_iCabeceraMousePressed

    private void bSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSiMouseClicked
        System.exit(0);
    }//GEN-LAST:event_bSiMouseClicked

    private void bVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bVolverMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);

        if (vPartida != null) {
            vPartida.setVisible(true);
        }
        if (vEntrenamiento != null)
            vEntrenamiento.setVisible(true);
    }//GEN-LAST:event_bVolverMouseClicked

    /**
     * @param args the command line arguments
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("GUI_Images/icono.png"));
        return retValue;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSi;
    private javax.swing.JButton bVolver;
    private javax.swing.JLabel iCabecera;
    private javax.swing.JLabel iFondo;
    private javax.swing.JLabel iSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}