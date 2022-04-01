/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Almacenes.Almacen_Jugadores;
import Almacenes.Almacen_Palabras;
import Almacenes.Almacen_Partidas;
import Personas.Administrador;
import Personas.Jugador;
import Tipos_de_Juego.Partida;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author e.tamajon.2020
 */
public class VAdmin extends javax.swing.JFrame {

    int x, y;
    Jugador jugador;
    Administrador admin;

    VLogin vLogin;
    VEditJugador vEditJugador;
    VEditPalabra vEditPalabra;
    VPartida vPartida;

    Partida partida;
    VEntrenamiento vEntrenamiento;

    Almacen_Jugadores aJugadores;
    Almacen_Palabras aPalabras;
    Almacen_Partidas aPartidas;

    boolean otroUser;

    boolean porPuntosB;
    boolean puntosSel;

    /**
     * Creates new form VAdmin
     */
    public VAdmin(VLogin vLogin, Administrador admin,
            Almacen_Jugadores aJugadores, Almacen_Palabras aPalabras,
            Almacen_Partidas aPartidas) {

        initComponents();

        this.admin = admin;
        this.vLogin = vLogin;
        this.setLocationRelativeTo(vLogin);
        this.aJugadores = aJugadores;
        this.aPalabras = aPalabras;
        this.aPartidas = aPartidas;

        puntosSel = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iSalir = new javax.swing.JLabel();
        jNumPal = new javax.swing.JLabel();
        tNumPal = new javax.swing.JTextField();
        tOtraPass = new javax.swing.JTextField();
        jJugador4 = new javax.swing.JLabel();
        jPuntos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jJugador = new javax.swing.JLabel();
        bJugarPartida = new javax.swing.JButton();
        bJugarEntrenamiento = new javax.swing.JButton();
        bVolver = new javax.swing.JButton();
        jJugador1 = new javax.swing.JLabel();
        bAdministrarPalabra = new javax.swing.JButton();
        porPuntos = new javax.swing.JRadioButton();
        porPartidas = new javax.swing.JRadioButton();
        tOtroUsuario = new javax.swing.JTextField();
        jJugador2 = new javax.swing.JLabel();
        bAdministrarJugador = new javax.swing.JButton();
        bConsultarJugadores = new javax.swing.JButton();
        bConsultarPartida = new javax.swing.JButton();
        jJugador3 = new javax.swing.JLabel();
        spMostrarPalabras1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        iCabecera = new javax.swing.JLabel();
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
        getContentPane().add(iSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        jNumPal.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jNumPal.setText("N. Palabras:");
        getContentPane().add(jNumPal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 100, -1));

        tNumPal.setBackground(new java.awt.Color(102, 102, 102));
        tNumPal.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        tNumPal.setForeground(new java.awt.Color(255, 255, 255));
        tNumPal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNumPalActionPerformed(evt);
            }
        });
        getContentPane().add(tNumPal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 180, 30));

        tOtraPass.setBackground(new java.awt.Color(102, 102, 102));
        tOtraPass.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        tOtraPass.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tOtraPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 200, 30));

        jJugador4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jJugador4.setText("Usuario");
        getContentPane().add(jJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        jPuntos.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jPuntos.setText("Contraseña");
        getContentPane().add(jPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel1.setText("Admin");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        jJugador.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jJugador.setText("Jugar :");
        getContentPane().add(jJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        bJugarPartida.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bJugarPartida.setText("Partida");
        bJugarPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bJugarPartidaMouseClicked(evt);
            }
        });
        getContentPane().add(bJugarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 200, 30));

        bJugarEntrenamiento.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bJugarEntrenamiento.setText("Entrenamiento");
        bJugarEntrenamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bJugarEntrenamientoMouseClicked(evt);
            }
        });
        bJugarEntrenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bJugarEntrenamientoActionPerformed(evt);
            }
        });
        getContentPane().add(bJugarEntrenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 200, 30));

        bVolver.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bVolver.setText("Volver");
        bVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bVolverMouseClicked(evt);
            }
        });
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });
        getContentPane().add(bVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 200, 30));

        jJugador1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jJugador1.setText("Palabra :");
        getContentPane().add(jJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        bAdministrarPalabra.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bAdministrarPalabra.setText("Administrar");
        bAdministrarPalabra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAdministrarPalabraMouseClicked(evt);
            }
        });
        getContentPane().add(bAdministrarPalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 200, 30));

        porPuntos.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        porPuntos.setText("Por puntos");
        porPuntos.setContentAreaFilled(false);
        porPuntos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                porPuntosMouseClicked(evt);
            }
        });
        getContentPane().add(porPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 100, 40));

        porPartidas.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        porPartidas.setText("Por partidas");
        porPartidas.setContentAreaFilled(false);
        porPartidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                porPartidasMouseClicked(evt);
            }
        });
        getContentPane().add(porPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 120, 40));

        tOtroUsuario.setBackground(new java.awt.Color(102, 102, 102));
        tOtroUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        tOtroUsuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tOtroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 200, 30));

        jJugador2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jJugador2.setText("Jugador :");
        getContentPane().add(jJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        bAdministrarJugador.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bAdministrarJugador.setText("Administrar");
        bAdministrarJugador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAdministrarJugadorMouseClicked(evt);
            }
        });
        getContentPane().add(bAdministrarJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 200, 30));

        bConsultarJugadores.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bConsultarJugadores.setText("Consultar jugadores");
        bConsultarJugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bConsultarJugadoresMouseClicked(evt);
            }
        });
        getContentPane().add(bConsultarJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 200, 30));

        bConsultarPartida.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bConsultarPartida.setText("Consultar partida");
        bConsultarPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bConsultarPartidaMouseClicked(evt);
            }
        });
        getContentPane().add(bConsultarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 200, 30));

        jJugador3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jJugador3.setText("Partida :");
        getContentPane().add(jJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        spMostrarPalabras1.setViewportView(jTextArea1);

        getContentPane().add(spMostrarPalabras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 410, 310));

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
        getContentPane().add(iCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 830, -1));

        iFondo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        iFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_Images/489.jpg"))); // NOI18N
        getContentPane().add(iFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 523));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iSalirMouseClicked
        // TODO add your handling code here:
        VExit vExit = new VExit(this, aPalabras, aPartidas, aJugadores);
        this.setVisible(false);
        vExit.setVisible(true);
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

    private void initPartida(Partida partida) {
        if (partida.checkJugar()) {

            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Va a comenzar la partida.");

            this.setVisible(false);
            vPartida = new VPartida(partida, aPalabras, aPartidas, this);
            vPartida.setVisible(true);
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Uno de los dos jugadores no tiene puntos suficientes.");
        }
    }

    public boolean checkInputError(int rango, String respuestaUsuario) {

        int posicion = 1;
        boolean errorInput = false;

        char[] chars = respuestaUsuario.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1' || chars[i] == '2' || chars[i] == '3' || chars[i] == '4' || chars[i] == '5' || chars[i] == '6' || chars[i] == '7' || chars[i] == '8' || chars[i] == '9' || chars[i] == '0') {
                errorInput = false;
            } else {

                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame, "Debes introducir un valor numérico entre 1 y " + (rango));
                errorInput = true;
                break;
            }
        }
        if (!errorInput) {
            posicion = Integer.parseInt(respuestaUsuario);
            if (posicion < 1 || posicion > (rango)) {
                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame, "Debes introducir un valor numérico entre 1 y " + (rango));
                errorInput = true;
            }
        }

        return errorInput;
    }

    private void bJugarPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bJugarPartidaMouseClicked
        boolean vacio = tNumPal.getText().equals("");
        JFrame jFrame;

        if (!otroUser) {
            jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Es necesario iniciar sesión con otro usuario.");
        }
        otroUser = true;

        String user = tOtroUsuario.getText();
        String password = tOtraPass.getText();

        String respuestaUsuario = tNumPal.getText();

        if (user.equals(admin.getNombre()) && password.equals(admin.getContraseña())) {
            jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Has introducido los datos del administrador. Seleccione a otro jugador.");
        }

        if (!vacio) {
            if (!checkInputError(24, respuestaUsuario)) {
                int numPal = Integer.parseInt(respuestaUsuario);

                if (!aPalabras.esVacio(numPal)) {
                    if (aJugadores.checkUser(user, password)) {
                        Jugador jugadorSel = aJugadores.selectJugador(user, password);
                        Partida partida = new Partida(new Jugador(admin), jugadorSel, numPal, aPalabras);
                        tNumPal.setText("");
                        initPartida(partida);
                    } else {
                        jFrame = new JFrame();
                        JOptionPane.showMessageDialog(jFrame, "El jugador no esta registrado");

                    }
                } else {
                    jFrame = new JFrame();
                    JOptionPane.showMessageDialog(jFrame, "No hay palabras suficientes. Ingrese como administrador y cree nuevas palabras."
                            + "Recuerde que debe de haber letras desde la a, hasta la letra con la que desee jugar.");
                }

            } else {
                jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame, "Inserte un valor numerico entre 1 y 24");
            }
        } else {
            jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Rellene el campo de palabras.");
        }


    }//GEN-LAST:event_bJugarPartidaMouseClicked

    private void bJugarEntrenamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bJugarEntrenamientoMouseClicked

        JFrame jFrame;
        String respuestaUsuario = tNumPal.getText();
        boolean vacio = tNumPal.getText().equals("");

        if (!vacio) {
            if (!checkInputError(24, respuestaUsuario)) {
                int numPal = Integer.parseInt(respuestaUsuario);

                if (!aPalabras.esVacio(numPal)) {
                    vEntrenamiento = new VEntrenamiento(this, new Jugador(admin), numPal, aPalabras);
                    tNumPal.setText("");
                    this.setVisible(false);
                    vEntrenamiento.setVisible(true);
                } else {
                    jFrame = new JFrame();
                    JOptionPane.showMessageDialog(jFrame, "No hay palabras suficientes. Ingrese como administrador y cree nuevas palabras."
                            + "Recuerde que debe de haber letras desde la a, hasta la letra con la que desee jugar.");
                }

            } else {
                jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame, "Inserte un valor numerico entre 1 y 24");
            }
        } else {
            jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Rellene el campo de palabras.");
        }

    }//GEN-LAST:event_bJugarEntrenamientoMouseClicked

    private void bAdministrarPalabraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAdministrarPalabraMouseClicked
        // TODO add your handling code here:
        vEditPalabra = new VEditPalabra(this, aPalabras);
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Accediendo a edicion de palabras.");
        this.setVisible(false);
        vEditPalabra.setVisible(true);
    }//GEN-LAST:event_bAdministrarPalabraMouseClicked

    private void bAdministrarJugadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAdministrarJugadorMouseClicked
        // TODO add your handling code here:
        vEditJugador = new VEditJugador(this, aJugadores);
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Accediendo a edicion de jugadores.");
        this.setVisible(false);
        vEditJugador.setVisible(true);
    }//GEN-LAST:event_bAdministrarJugadorMouseClicked

    private void bConsultarPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bConsultarPartidaMouseClicked
        jTextArea1.setText(aPartidas.consultarPartida());
    }//GEN-LAST:event_bConsultarPartidaMouseClicked

    private void tNumPalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNumPalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNumPalActionPerformed

    private void bJugarEntrenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bJugarEntrenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bJugarEntrenamientoActionPerformed

    private void bVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bVolverMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        vLogin.setVisible(true);
    }//GEN-LAST:event_bVolverMouseClicked

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_bVolverActionPerformed

    private void bConsultarJugadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bConsultarJugadoresMouseClicked
        // TODO add your handling code here:
        if (puntosSel) {
            jTextArea1.setText(aJugadores.mostrarClasificacion(porPuntosB));
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Seleccione si clasificar por puntos o por partidas ganadas..");
        }

    }//GEN-LAST:event_bConsultarJugadoresMouseClicked

    private void porPuntosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_porPuntosMouseClicked
        // TODO add your handling code here:
        porPuntosB = true;
        puntosSel = true;
        porPartidas.setSelected(false);
    }//GEN-LAST:event_porPuntosMouseClicked

    private void porPartidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_porPartidasMouseClicked
        // TODO add your handling code here:
        porPuntosB = false;
        puntosSel = true;
        porPuntos.setSelected(false);
    }//GEN-LAST:event_porPartidasMouseClicked
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("GUI_Images/icono.png"));
        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdministrarJugador;
    private javax.swing.JButton bAdministrarPalabra;
    private javax.swing.JButton bConsultarJugadores;
    private javax.swing.JButton bConsultarPartida;
    private javax.swing.JButton bJugarEntrenamiento;
    private javax.swing.JButton bJugarPartida;
    private javax.swing.JButton bVolver;
    private javax.swing.JLabel iCabecera;
    private javax.swing.JLabel iFondo;
    private javax.swing.JLabel iSalir;
    private javax.swing.JLabel jJugador;
    private javax.swing.JLabel jJugador1;
    private javax.swing.JLabel jJugador2;
    private javax.swing.JLabel jJugador3;
    private javax.swing.JLabel jJugador4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jNumPal;
    private javax.swing.JLabel jPuntos;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton porPartidas;
    private javax.swing.JRadioButton porPuntos;
    private javax.swing.JScrollPane spMostrarPalabras1;
    private javax.swing.JTextField tNumPal;
    private javax.swing.JTextField tOtraPass;
    private javax.swing.JTextField tOtroUsuario;
    // End of variables declaration//GEN-END:variables
}
