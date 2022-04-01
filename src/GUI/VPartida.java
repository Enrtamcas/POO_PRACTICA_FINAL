/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Almacenes.Almacen_Palabras;
import Almacenes.Almacen_Partidas;
import Componentes_Rosco.Palabra;
import Tipos_de_Juego.Partida;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author e.tamajon.2020
 */
public class VPartida extends javax.swing.JFrame {

    int x, y;

    Almacen_Palabras aPalabras;
    Almacen_Partidas aPartidas;

    VJugador vJugador;
    VAdmin vAdmin;

    Partida partida;
    Palabra[] palabraActual;

    boolean[] haAcabado;

    /**
     * Creates new form VPartida
     */
    public VPartida(Partida partida, Almacen_Palabras aPalabras, Almacen_Partidas aPartidas, VJugador vJugador) {
        initComponents();

        this.aPalabras = aPalabras;
        this.aPartidas = aPartidas;
        this.partida = partida;
        this.vJugador = vJugador;
        this.setLocationRelativeTo(vJugador);

        haAcabado = new boolean[2];
        palabraActual = new Palabra[2];

        haAcabado[0] = false;
        haAcabado[1] = false;

        cTurno.setEnabled(false);
        cTurno2.setEnabled(false);

        tNombreJ.setText(partida.getJ(0).getNombre());
        tNombreJ2.setText(partida.getJ(1).getNombre());

        tPuntos.setText(partida.getJ(0).getPuntos());
        tPuntos2.setText(partida.getJ(1).getPuntos());

        tAciertos.setText(partida.getJAciertos(0));
        tAciertos2.setText(partida.getJAciertos(1));

        tFallos.setText(partida.getJFallos(0));
        tFallos2.setText(partida.getJFallos(1));

        tVueltas.setText(partida.getVuelta(0));
        tVueltas2.setText(partida.getVuelta(1));

        tRespuesta.setEditable(false);
        tRespuesta2.setEditable(false);

        turnoJ();
        setNuevaPalabra(0);
        setNuevaPalabra(1);

    }

    public VPartida(Partida partida, Almacen_Palabras aPalabras, Almacen_Partidas aPartidas, VAdmin vAdmin) {
        initComponents();

        this.aPalabras = aPalabras;
        this.aPartidas = aPartidas;
        this.partida = partida;
        this.vAdmin = vAdmin;
        this.setLocationRelativeTo(vAdmin);

        haAcabado = new boolean[2];
        palabraActual = new Palabra[2];

        haAcabado[0] = false;
        haAcabado[1] = false;

        cTurno.setEnabled(false);
        cTurno2.setEnabled(false);

        tNombreJ.setText(partida.getJ(0).getNombre());
        tNombreJ2.setText(partida.getJ(1).getNombre());

        tPuntos.setText(partida.getJ(0).getPuntos());
        tPuntos2.setText(partida.getJ(1).getPuntos());

        tAciertos.setText(partida.getJAciertos(0));
        tAciertos2.setText(partida.getJAciertos(1));

        tFallos.setText(partida.getJFallos(0));
        tFallos2.setText(partida.getJFallos(1));

        tVueltas.setText(partida.getVuelta(0));
        tVueltas2.setText(partida.getVuelta(1));

        tRespuesta.setEditable(false);
        tRespuesta2.setEditable(false);

        turnoJ();
        setNuevaPalabra(0);
        setNuevaPalabra(1);

    }

    private void setNuevaPalabra(int jugador) {
        do {
            partida.setPosActual(jugador, partida.getPosActual(jugador) + 1);;

            if (partida.getPosActual(jugador) == partida.getNumPal()) {

                partida.setPosActual(jugador, 0);
                String nuevaVuelta = partida.sumarVuelta(jugador);
                int nuevaIntVuelta = Integer.parseInt(nuevaVuelta);
                if (jugador == 0) {
                    tVueltas.setText(nuevaVuelta);
                }
                if (jugador == 1) {
                    tVueltas2.setText(nuevaVuelta);
                }

            }
            palabraActual[jugador] = partida.getPalabraActual(jugador, partida.getPosActual(jugador));
        } while (palabraActual[jugador].isAcertada() || palabraActual[jugador].isFallada());

        String palabra = palabraActual[jugador].adivinarPalabra();
        if (jugador == 0) {
            tMostrarPalabras.setText(palabra);
        }
        if (jugador == 1) {
            tMostrarPalabras2.setText(palabra);
        }
    }

    private void turnoJ() {

        boolean turnoJ1 = partida.checkTurno(0);
        boolean turnoJ2 = partida.checkTurno(1);
        cTurno.setEnabled(turnoJ1);
        tRespuesta.setEditable(turnoJ1);
        cTurno2.setEnabled(turnoJ2);
        tRespuesta2.setEditable(turnoJ2);

        if (haAcabado[0] && !haAcabado[1]) {
            partida.setTurnoJugador(0, false);
            partida.setTurnoJugador(1, true);
            cTurno.setEnabled(false);
            tRespuesta.setEditable(false);
            cTurno2.setEnabled(true);
            tRespuesta2.setEditable(true);
        }

        if (haAcabado[1] && !haAcabado[0]) {
            partida.setTurnoJugador(1, false);
            partida.setTurnoJugador(0, true);
            cTurno.setEnabled(true);
            tRespuesta.setEditable(true);
            cTurno2.setEnabled(false);
            tRespuesta2.setEditable(false);
        }

        if (haAcabado[1] && haAcabado[0]) {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Partida finalizada.");
            partida.empate();
            aPartidas.añadirPartida(partida);

            this.setVisible(false);
            if (vJugador == null) {
                vAdmin.setVisible(true);
            } else {
                vJugador.setVisible(true);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTitulo = new javax.swing.JLabel();
        cTurno = new javax.swing.JCheckBox();
        jJugador = new javax.swing.JLabel();
        tNombreJ = new javax.swing.JTextField();
        jPuntos = new javax.swing.JLabel();
        tPuntos = new javax.swing.JTextField();
        jAciertos = new javax.swing.JLabel();
        tAciertos = new javax.swing.JTextField();
        jFallos = new javax.swing.JLabel();
        tFallos = new javax.swing.JTextField();
        jVueltas = new javax.swing.JLabel();
        tVueltas = new javax.swing.JTextField();
        jRespuesta = new javax.swing.JLabel();
        tRespuesta = new javax.swing.JTextField();
        bEnviarRespuesta = new javax.swing.JButton();
        jPista = new javax.swing.JLabel();
        tPista = new javax.swing.JTextField();
        bPedirPista = new javax.swing.JButton();
        jPalabra = new javax.swing.JLabel();
        tComprarPalabra = new javax.swing.JTextField();
        bComprarPalabra = new javax.swing.JButton();
        spMostrarPalabras = new javax.swing.JScrollPane();
        tMostrarPalabras = new javax.swing.JTextArea();
        cTurno2 = new javax.swing.JCheckBox();
        jJugador2 = new javax.swing.JLabel();
        tNombreJ2 = new javax.swing.JTextField();
        jPuntos2 = new javax.swing.JLabel();
        tPuntos2 = new javax.swing.JTextField();
        jAciertos2 = new javax.swing.JLabel();
        tAciertos2 = new javax.swing.JTextField();
        jFallos2 = new javax.swing.JLabel();
        tFallos2 = new javax.swing.JTextField();
        jVueltas2 = new javax.swing.JLabel();
        tVueltas2 = new javax.swing.JTextField();
        tRespuesta2 = new javax.swing.JTextField();
        jRespuesta2 = new javax.swing.JLabel();
        bEnviarRespuesta2 = new javax.swing.JButton();
        jPista2 = new javax.swing.JLabel();
        tPista2 = new javax.swing.JTextField();
        bPedirPista2 = new javax.swing.JButton();
        jPalabra2 = new javax.swing.JLabel();
        tComprarPalabra2 = new javax.swing.JTextField();
        bComprarPalabra2 = new javax.swing.JButton();
        spMostrarPalabras2 = new javax.swing.JScrollPane();
        tMostrarPalabras2 = new javax.swing.JTextArea();
        iSalir = new javax.swing.JLabel();
        iCabecera = new javax.swing.JLabel();
        iFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTitulo.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jTitulo.setText("Partida");
        getContentPane().add(jTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, -1));

        cTurno.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        cTurno.setText("Turno del jugador 1");
        cTurno.setBorder(null);
        cTurno.setOpaque(false);
        getContentPane().add(cTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 190, 30));

        jJugador.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jJugador.setText("Jugador 1:");
        getContentPane().add(jJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 20));

        tNombreJ.setEditable(false);
        tNombreJ.setBackground(new java.awt.Color(102, 102, 102));
        tNombreJ.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tNombreJ.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tNombreJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 210, 20));

        jPuntos.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jPuntos.setText("Puntos:");
        getContentPane().add(jPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 60, 20));

        tPuntos.setEditable(false);
        tPuntos.setBackground(new java.awt.Color(102, 102, 102));
        tPuntos.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tPuntos.setForeground(new java.awt.Color(255, 255, 255));
        tPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPuntosActionPerformed(evt);
            }
        });
        getContentPane().add(tPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 210, 20));

        jAciertos.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jAciertos.setText("Aciertos:");
        getContentPane().add(jAciertos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 90, 20));

        tAciertos.setEditable(false);
        tAciertos.setBackground(new java.awt.Color(102, 102, 102));
        tAciertos.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tAciertos.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tAciertos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 210, 20));

        jFallos.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jFallos.setText("Fallos:");
        getContentPane().add(jFallos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 60, 20));

        tFallos.setEditable(false);
        tFallos.setBackground(new java.awt.Color(102, 102, 102));
        tFallos.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tFallos.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tFallos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 210, 20));

        jVueltas.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jVueltas.setText("Vueltas:");
        getContentPane().add(jVueltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 80, 20));

        tVueltas.setEditable(false);
        tVueltas.setBackground(new java.awt.Color(102, 102, 102));
        tVueltas.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tVueltas.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tVueltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 210, 20));

        jRespuesta.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jRespuesta.setText("Respuesta:");
        getContentPane().add(jRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, 20));

        tRespuesta.setBackground(new java.awt.Color(102, 102, 102));
        tRespuesta.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tRespuesta.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 210, 20));

        bEnviarRespuesta.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bEnviarRespuesta.setText("Enviar respuesta");
        bEnviarRespuesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEnviarRespuestaMouseClicked(evt);
            }
        });
        getContentPane().add(bEnviarRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 210, 20));

        jPista.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jPista.setText("Pista:");
        jPista.setToolTipText("");
        getContentPane().add(jPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 50, 20));

        tPista.setEditable(false);
        tPista.setBackground(new java.awt.Color(102, 102, 102));
        tPista.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tPista.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 210, 20));

        bPedirPista.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bPedirPista.setText("Pedir pista");
        bPedirPista.setActionCommand("jPedirPista");
        bPedirPista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPedirPistaMouseClicked(evt);
            }
        });
        getContentPane().add(bPedirPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 210, 20));

        jPalabra.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jPalabra.setText("Palabra:");
        getContentPane().add(jPalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 70, 20));

        tComprarPalabra.setEditable(false);
        tComprarPalabra.setBackground(new java.awt.Color(102, 102, 102));
        tComprarPalabra.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tComprarPalabra.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tComprarPalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 210, 20));

        bComprarPalabra.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bComprarPalabra.setText("Comprar palabra");
        bComprarPalabra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bComprarPalabraMouseClicked(evt);
            }
        });
        getContentPane().add(bComprarPalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 210, 20));

        tMostrarPalabras.setColumns(20);
        tMostrarPalabras.setRows(5);
        spMostrarPalabras.setViewportView(tMostrarPalabras);

        getContentPane().add(spMostrarPalabras, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 300, 90));

        cTurno2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        cTurno2.setText("Turno del jugador 2");
        cTurno2.setBorder(null);
        cTurno2.setOpaque(false);
        getContentPane().add(cTurno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 190, 30));

        jJugador2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jJugador2.setText("Jugador 2:");
        getContentPane().add(jJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 100, 20));

        tNombreJ2.setEditable(false);
        tNombreJ2.setBackground(new java.awt.Color(102, 102, 102));
        tNombreJ2.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tNombreJ2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tNombreJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 210, 20));

        jPuntos2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jPuntos2.setText("Puntos:");
        getContentPane().add(jPuntos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 60, 20));

        tPuntos2.setEditable(false);
        tPuntos2.setBackground(new java.awt.Color(102, 102, 102));
        tPuntos2.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tPuntos2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tPuntos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 210, 20));

        jAciertos2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jAciertos2.setText("Aciertos:");
        getContentPane().add(jAciertos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 90, 20));

        tAciertos2.setEditable(false);
        tAciertos2.setBackground(new java.awt.Color(102, 102, 102));
        tAciertos2.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tAciertos2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tAciertos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 210, 20));

        jFallos2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jFallos2.setText("Fallos:");
        getContentPane().add(jFallos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 60, 20));

        tFallos2.setEditable(false);
        tFallos2.setBackground(new java.awt.Color(102, 102, 102));
        tFallos2.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tFallos2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tFallos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 210, 20));

        jVueltas2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jVueltas2.setText("Vueltas:");
        getContentPane().add(jVueltas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 70, 20));

        tVueltas2.setEditable(false);
        tVueltas2.setBackground(new java.awt.Color(102, 102, 102));
        tVueltas2.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tVueltas2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tVueltas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 210, 20));

        tRespuesta2.setBackground(new java.awt.Color(102, 102, 102));
        tRespuesta2.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tRespuesta2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tRespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 210, 20));

        jRespuesta2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jRespuesta2.setText("Respuesta:");
        getContentPane().add(jRespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 100, 20));

        bEnviarRespuesta2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bEnviarRespuesta2.setText("Enviar respuesta");
        bEnviarRespuesta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEnviarRespuesta2MouseClicked(evt);
            }
        });
        bEnviarRespuesta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnviarRespuesta2ActionPerformed(evt);
            }
        });
        getContentPane().add(bEnviarRespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 210, 20));

        jPista2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jPista2.setText("Pista:");
        jPista2.setToolTipText("");
        getContentPane().add(jPista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 50, 20));

        tPista2.setEditable(false);
        tPista2.setBackground(new java.awt.Color(102, 102, 102));
        tPista2.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tPista2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tPista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 210, 20));

        bPedirPista2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bPedirPista2.setText("Pedir pista");
        bPedirPista2.setActionCommand("jPedirPista");
        bPedirPista2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPedirPista2MouseClicked(evt);
            }
        });
        getContentPane().add(bPedirPista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 210, 20));

        jPalabra2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jPalabra2.setText("Palabra:");
        getContentPane().add(jPalabra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 70, 20));

        tComprarPalabra2.setEditable(false);
        tComprarPalabra2.setBackground(new java.awt.Color(102, 102, 102));
        tComprarPalabra2.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tComprarPalabra2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tComprarPalabra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 210, 20));

        bComprarPalabra2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bComprarPalabra2.setText("Comprar palabra");
        bComprarPalabra2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bComprarPalabra2MouseClicked(evt);
            }
        });
        getContentPane().add(bComprarPalabra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 210, 20));

        tMostrarPalabras2.setColumns(20);
        tMostrarPalabras2.setRows(5);
        spMostrarPalabras2.setViewportView(tMostrarPalabras2);

        getContentPane().add(spMostrarPalabras2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 300, 90));

        iSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_Images/Boton_salir.png"))); // NOI18N
        iSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iSalirMouseClicked(evt);
            }
        });
        getContentPane().add(iSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

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
        VExitConfirmacionPartida vExit = new VExitConfirmacionPartida(this);
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

    private void bEnviarRespuestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEnviarRespuestaMouseClicked
        // TODO add your handling code here:
        int jugador = 0;
        jugar(jugador);
    }//GEN-LAST:event_bEnviarRespuestaMouseClicked

    private void bEnviarRespuesta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEnviarRespuesta2MouseClicked
        // TODO add your handling code here:
        int jugador = 1;
        jugar(jugador);

    }//GEN-LAST:event_bEnviarRespuesta2MouseClicked
    private void jugar(int jugador) {
        if (!haAcabado[jugador]) {
            if (partida.checkTurno(jugador)) {
                if (!responder(jugador)) {
                    partida.cambiarTurno();
                    turnoJ();
                } else {
                    if (haAcabado[jugador]) {
                        turnoJ();
                    }
                }
            } else {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf, "No es tu turno.");
            }
        } else {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Ya no puedes jugar mas.");
        }
    }

    private boolean responder(int jugador) {
        String respuesta = "";
        if (jugador == 0) {
            respuesta = tRespuesta.getText();
        }
        if (jugador == 1) {
            respuesta = tRespuesta2.getText();
        }

        boolean acierto = respuesta.equalsIgnoreCase(palabraActual[jugador].getPalabra());
        boolean paso = respuesta.equalsIgnoreCase("paso");
        boolean salida = false;
        int vueltaActual = Integer.parseInt(partida.getVuelta(jugador));

        if (acierto) {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Palabra acertada.");

            if (jugador == 0) {
                tAciertos.setText(partida.acertar(jugador));
            }
            if (jugador == 1) {
                tAciertos2.setText(partida.acertar(jugador));
            }

            palabraActual[jugador].setAcertada(true);
            partida.actualizarPalabra(jugador, palabraActual[jugador]);

            if (jugador == 0) {
                tRespuesta.setText("");
            }
            if (jugador == 1) {
                tRespuesta2.setText("");
            }

            salida = true;

        }

        if (vueltaActual == 1) {

        }
        if (paso && vueltaActual == 1) {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Palabra aplazada.");

            palabraActual[jugador].setAplazada(true);
            partida.actualizarPalabra(jugador, palabraActual[jugador]);
            salida = false;

            if (jugador == 0) {
                tRespuesta.setText("");
            }
            if (jugador == 1) {
                tRespuesta2.setText("");
            }
        }
        if ((!acierto && !paso && vueltaActual == 1) || (!acierto && vueltaActual == 2)) {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Palabra fallada.");

            if (jugador == 0) {
                tFallos.setText(partida.fallar(jugador));
            }
            if (jugador == 1) {
                tFallos2.setText(partida.fallar(jugador));
            }

            palabraActual[jugador].setFallada(true);
            partida.actualizarPalabra(jugador, palabraActual[jugador]);
            if (jugador == 0) {
                tRespuesta.setText("");
            }
            if (jugador == 1) {
                tRespuesta2.setText("");
            }
            salida = false;
        }

        if (jugador == 0) {
            tPista.setText("");
            tComprarPalabra.setText("");
        }
        if (jugador == 1) {
            tPista2.setText("");
            tComprarPalabra2.setText("");
        }

        boolean partidaTerminada;

        if (!checkGanarPartida(jugador)) {
            partidaTerminada = checkPerderPartida(jugador);
            if (!partidaTerminada) {
                if (!vueltasFin(jugador)) {
                    setNuevaPalabra(jugador);
                } else {
                    haAcabado[jugador] = true;
                    salida = false;
                }
            }
        } else {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Has ganado.");

            aPartidas.añadirPartida(partida);

            this.setVisible(false);
            if (vJugador == null) {
                vAdmin.setVisible(true);
            } else {
                vJugador.setVisible(true);
            }
        }

        return salida;
    }

    private boolean checkGanarPartida(int jugador) {
        int puntosActuales = partida.getIntAciertos(jugador);
        int numPal = partida.getNumPal(jugador);
        if (puntosActuales == numPal) {
            if (jugador == 0) {
                partida.ganaJ1();
            }
            if (jugador == 1) {
                partida.ganaJ2();
            }
            return true;
        }
        return false;
    }

    private boolean checkPerderPartida(int jugador) {

        int todosPuntos = partida.getIntAciertos(jugador) + partida.getIntFallos(jugador);
        int fallos = partida.getIntFallos(jugador);
        int numPal = partida.getNumPal(jugador);
        if (todosPuntos == numPal && (fallos != 0)) {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Has fallado " + partida.getFallos(jugador) + " palabras.");
            haAcabado[jugador] = true;
            return true;
        }
        return false;
    }

    private boolean vueltasFin(int jugador) {

        int nuevaIntVuelta = partida.getIntVuelta(jugador);

        if (nuevaIntVuelta == 3) {

            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Ya ha recorrido el rosco todo lo posible.");
            return true;
        }
        return false;
    }

    private void bPedirPistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPedirPistaMouseClicked
        // TODO add your handling code here:
        int jugador = 0;
        jugarPista(jugador);
    }//GEN-LAST:event_bPedirPistaMouseClicked

    private void bPedirPista2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPedirPista2MouseClicked
        // TODO add your handling code here:
        int jugador = 1;
        jugarPista(jugador);
    }//GEN-LAST:event_bPedirPista2MouseClicked

    private void jugarPista(int jugador) {
        if (!haAcabado[jugador]) {
            if (partida.checkTurno(jugador)) {
                pedirPista(jugador);
            } else {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf, "No es tu turno.");
            }
        } else {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Ya has terminado la partida.");
        }
    }

    private void pedirPista(int jugador) {
        int posActual = partida.getPosActual(jugador);

        if (!partida.getAyudaUsada(posActual, jugador)) {
            if (partida.getJ(jugador).getIntPuntos() >= 5) {
                if (jugador == 0) {
                    tPista.setText(partida.mostrarPista(posActual, jugador));
                    tPuntos.setText(partida.getJ(jugador).getPuntos());
                }
                if (jugador == 1) {
                    tPista2.setText(partida.mostrarPista(posActual, jugador));
                    tPuntos2.setText(partida.getJ(jugador).getPuntos());
                }
            } else {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf, "No tienes dinero suficiente.");
            }
        } else {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Ya has usado una pista en esta palabra.");
        }
    }
    private void bComprarPalabraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bComprarPalabraMouseClicked
        // TODO add your handling code here:
        int jugador = 0;
        comprarPista(jugador);
    }//GEN-LAST:event_bComprarPalabraMouseClicked

    private void bComprarPalabra2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bComprarPalabra2MouseClicked
        // TODO add your handling code here:
        int jugador = 1;
        comprarPista(jugador);
    }//GEN-LAST:event_bComprarPalabra2MouseClicked

    private void bEnviarRespuesta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnviarRespuesta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bEnviarRespuesta2ActionPerformed

    private void tPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPuntosActionPerformed

    private void comprarPista(int jugador) {
        if (!haAcabado[jugador]) {
            if (partida.checkTurno(jugador)) {
                comprarPalabra(jugador);
            } else {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf, "No es tu turno.");
            }
        } else {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Ya has terminado la partida.");
        }
    }

    private void comprarPalabra(int jugador) {
        int posActual = partida.getPosActual(jugador);

        if (!partida.getAyudaUsada(posActual, jugador)) {
            if (partida.getJ(jugador).getIntPuntos() >= 20) {
                if (jugador == 0) {
                    tComprarPalabra.setText(partida.comprarPalabra(posActual, jugador));
                    tPuntos.setText(partida.getJ(jugador).getPuntos());
                }
                if (jugador == 1) {
                    tComprarPalabra2.setText(partida.comprarPalabra(posActual, jugador));
                    tPuntos2.setText(partida.getJ(jugador).getPuntos());
                }
            } else {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf, "No tienes dinero suficiente.");
            }
        } else {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Ya has usado una pista en esta palabra.");
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("GUI_Images/icono.png"));
        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bComprarPalabra;
    private javax.swing.JButton bComprarPalabra2;
    private javax.swing.JButton bEnviarRespuesta;
    private javax.swing.JButton bEnviarRespuesta2;
    private javax.swing.JButton bPedirPista;
    private javax.swing.JButton bPedirPista2;
    private javax.swing.JCheckBox cTurno;
    private javax.swing.JCheckBox cTurno2;
    private javax.swing.JLabel iCabecera;
    private javax.swing.JLabel iFondo;
    private javax.swing.JLabel iSalir;
    private javax.swing.JLabel jAciertos;
    private javax.swing.JLabel jAciertos2;
    private javax.swing.JLabel jFallos;
    private javax.swing.JLabel jFallos2;
    private javax.swing.JLabel jJugador;
    private javax.swing.JLabel jJugador2;
    private javax.swing.JLabel jPalabra;
    private javax.swing.JLabel jPalabra2;
    private javax.swing.JLabel jPista;
    private javax.swing.JLabel jPista2;
    private javax.swing.JLabel jPuntos;
    private javax.swing.JLabel jPuntos2;
    private javax.swing.JLabel jRespuesta;
    private javax.swing.JLabel jRespuesta2;
    private javax.swing.JLabel jTitulo;
    private javax.swing.JLabel jVueltas;
    private javax.swing.JLabel jVueltas2;
    private javax.swing.JScrollPane spMostrarPalabras;
    private javax.swing.JScrollPane spMostrarPalabras2;
    private javax.swing.JTextField tAciertos;
    private javax.swing.JTextField tAciertos2;
    private javax.swing.JTextField tComprarPalabra;
    private javax.swing.JTextField tComprarPalabra2;
    private javax.swing.JTextField tFallos;
    private javax.swing.JTextField tFallos2;
    private javax.swing.JTextArea tMostrarPalabras;
    private javax.swing.JTextArea tMostrarPalabras2;
    private javax.swing.JTextField tNombreJ;
    private javax.swing.JTextField tNombreJ2;
    private javax.swing.JTextField tPista;
    private javax.swing.JTextField tPista2;
    private javax.swing.JTextField tPuntos;
    private javax.swing.JTextField tPuntos2;
    private javax.swing.JTextField tRespuesta;
    private javax.swing.JTextField tRespuesta2;
    private javax.swing.JTextField tVueltas;
    private javax.swing.JTextField tVueltas2;
    // End of variables declaration//GEN-END:variables
}
