package Tipos_de_Juego;

import Almacenes.Almacen_Palabras;
import Componentes_Rosco.Palabra;
import Componentes_Rosco.Rosco;
import Personas.Jugador;
import Sistema_de_Ayuda.Ayuda;
import Sistema_de_Ayuda.Compra;
import Sistema_de_Ayuda.Letras;
import Sistema_de_Ayuda.SegundaDefinicion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Partida implements Serializable {

    private int precio;
    private int numPalabras;
    private String fechaActual;

    Jugador[] jugadores;
    String[] aciertos;
    String[] fallos;
    Rosco[] roscos;

    Ayuda[][] ayudas;
    boolean[][] ayudaUsada;

    boolean[] turno;

    String[] vueltas;

    int[] posPalabra;

    Palabra[] palabra;

    public Partida(Jugador jugador1, Jugador jugador2, int numPalabras, Almacen_Palabras almacen) {

        this.numPalabras = numPalabras;
        int nJugadores = 2;

        precio = 5;
        jugadores = new Jugador[nJugadores];
        aciertos = new String[nJugadores];
        fallos = new String[nJugadores];
        posPalabra = new int[nJugadores];
        vueltas = new String[nJugadores];
        turno = new boolean[nJugadores];
        //*   *
        //1   1
        //2   2
        //3   3
        //.   .

        ayudas = new Ayuda[nJugadores][numPalabras];
        ayudaUsada = new boolean[nJugadores][numPalabras];

        roscos = new Rosco[nJugadores];

        jugadores[0] = jugador1;
        jugadores[1] = jugador2;


        for (int i = 0; i < nJugadores; i++) {
            
            aciertos[i] = "0";
            fallos[i] = "0";
            posPalabra[i] = -1;
            vueltas[i] = "1";
            for (int j = 0; j < numPalabras; j++){
                ayudaUsada[i][j] = false;
            }
        }
        
        turno[0] = true;
        turno[1] = false;

        for (int i = 0; i < 2; i++) {
            roscos[i] = new Rosco(this.numPalabras, almacen);
            jugadores[i].setPuntos(jugadores[i].getIntPuntos() - precio);
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        fechaActual = dtf.format(LocalDateTime.now());

    }
    
    
    public void actualizarPalabra(int jugador, Palabra p) {
        roscos[jugador].setPalabra(p, posPalabra[jugador]);
    }
    
    public boolean getAyudaUsada(int index, int jugador){
        return ayudaUsada[jugador][index];
    }
    
    public void setAyudaUsada(int index, int jugador, boolean ayuda){
        ayudaUsada[jugador][index] = ayuda;
    }
    
    public String mostrarPista(int index, int jugador) {
        Palabra palabraActual = getPalabraActual( jugador, index);

        if (palabraActual.tieneMasDeUnaDefinicion()) {
            ayudas[jugador][index] = new SegundaDefinicion(palabraActual);
        } else {
            ayudas[jugador][index] = new Letras(palabraActual);
        }
        
        ayudaUsada[jugador][index] = true;

        String ayuda = ayudas[jugador][index].mostrar_info();
 
        jugadores[jugador].setPuntos(jugadores[jugador].getIntPuntos()-ayudas[jugador][index].getPrecio());
        return ayuda;
    }

    public String comprarPalabra( int index, int jugador) {
        Palabra palabraActual = getPalabraActual(jugador, index);
        
        ayudas[jugador][index] = new Compra(palabraActual);

        ayudaUsada[jugador][index] = true;
        
        String ayuda = ayudas[jugador][index].mostrar_info();
        jugadores[jugador].setPuntos(jugadores[jugador].getIntPuntos()-ayudas[jugador][index].getPrecio());
        return ayuda;

    }
    public String getFechaActual() {
        return fechaActual;
    }

    public boolean checkJugar() {
        if (jugadores[0].getIntPuntos() < precio || jugadores[1].getIntPuntos() < precio) {
            
            return false;
        } else {
       
            return true;
        }
    }

    public String getAciertos(int jugador) {
        return aciertos[jugador];
    }

    public int getIntAciertos(int jugador) {
        int aciertos = Integer.parseInt(this.aciertos[jugador]);
        return aciertos;
    }

    public int getIntFallos(int jugador) {
        int fallos = Integer.parseInt(this.fallos[jugador]);
        return fallos;
    }

    public String getFallos(int jugador) {
        return fallos[jugador];
    }

    public int getNumPal(int jugador) {
        return roscos[jugador].getNumPalabras();
    }

    public Jugador getJ(int jugador) {
        return jugadores[jugador];
    }

    public String getJAciertos(int jugador) {
        return aciertos[jugador];
    }

    public String getJFallos(int jugador) {
        return String.valueOf(fallos[jugador]);
    }

    public int getPosActual(int jugador) {
        return posPalabra[jugador];
    }

    public void setPosActual(int jugador, int posPalabra) {
        this.posPalabra[jugador] = posPalabra;
    }

    public Palabra getPalabraActual(int jugador, int index) {
        return roscos[jugador].getPalabra(index);
    }

    public boolean checkTurno(int jugador) {
        return this.turno[jugador];
    }

    public int getNumPal() {
        return roscos[0].getNumPalabras();
    }

    public void cambiarTurno() {
        turno[0] = !turno[0];
        turno[1] = !turno[1];
    }

    public String acertar(int jugador) {
        int puntosAntes = Integer.parseInt(aciertos[jugador]);
        puntosAntes++;
        String puntosAhora = String.valueOf(puntosAntes);
        aciertos[jugador] = puntosAhora;
        return aciertos[jugador];
    }

    public String fallar(int jugador) {
        int fallosAntes = Integer.parseInt(fallos[jugador]);
        fallosAntes++;
        String fallosAhora = String.valueOf(fallosAntes);
        fallos[jugador] = fallosAhora;
        return fallos[jugador];
    }

    public void ganaJ1() {
        jugadores[0].getHistorial().ganarPartida(this);
        jugadores[1].getHistorial().perderPartida(this);
        int puntos = Integer.parseInt(aciertos[0]);
        jugadores[0].getHistorial().sumarPuntos(100);
        jugadores[0].setPuntos(jugadores[0].getIntPuntos() + 100);
    }

    public void ganaJ2() {
        jugadores[1].getHistorial().ganarPartida(this);
        jugadores[0].getHistorial().perderPartida(this);
        int puntos = Integer.parseInt(aciertos[1]);
        jugadores[1].getHistorial().sumarPuntos(100);
        jugadores[1].setPuntos(jugadores[1].getIntPuntos() + 100);
    }

    public void empate() {
        int aciertoJ1 = Integer.parseInt(aciertos[0]);
        int aciertoJ2 = Integer.parseInt(aciertos[1]);

        int fallosJ1 = Integer.parseInt(fallos[0]);
        int fallosJ2 = Integer.parseInt(fallos[1]);

        if (aciertoJ1 > aciertoJ2) {
            jugadores[0].getHistorial().ganarPartida(this);
            jugadores[1].getHistorial().perderPartida(this);
            jugadores[0].getHistorial().sumarPuntos(10);
            jugadores[0].setPuntos(jugadores[0].getIntPuntos() + 10);
        }
        if (aciertoJ1 < aciertoJ2) {
            jugadores[1].getHistorial().ganarPartida(this);
            jugadores[0].getHistorial().perderPartida(this);
            jugadores[1].getHistorial().sumarPuntos(10);
            jugadores[1].setPuntos(jugadores[1].getIntPuntos() + 10);
        }

        if (aciertoJ1 == aciertoJ2) {
            if (fallosJ1 < fallosJ2) {
                jugadores[0].getHistorial().ganarPartida(this);
                jugadores[1].getHistorial().perderPartida(this);
                jugadores[0].getHistorial().sumarPuntos(10);
                jugadores[0].setPuntos(jugadores[0].getIntPuntos() + 10);
            }
            if (fallosJ1 > fallosJ2) {
                jugadores[1].getHistorial().ganarPartida(this);
                jugadores[0].getHistorial().perderPartida(this);
                jugadores[1].getHistorial().sumarPuntos(10);
                jugadores[1].setPuntos(jugadores[1].getIntPuntos() + 10);
            }
            if (fallosJ1 == fallosJ2) {
                jugadores[0].getHistorial().sumarPuntos(5);
                jugadores[1].getHistorial().sumarPuntos(5);
                jugadores[0].getHistorial().empatarPartida(this);
                jugadores[1].getHistorial().empatarPartida(this);
                jugadores[0].setPuntos(jugadores[0].getIntPuntos() + 5);
                jugadores[1].setPuntos(jugadores[1].getIntPuntos() + 5);
            }
        }
    }

    public String sumarVuelta(int jugador) {
        String current;

        int vuelta = Integer.parseInt(vueltas[jugador]);
        vuelta++;
        current = String.valueOf(vuelta);
        vueltas[jugador] = current;
        return current;
    }

    public String getVuelta(int jugador) {
        return vueltas[jugador];
    }

    public int getIntVuelta(int jugador) {
        int vuelta = Integer.parseInt(vueltas[jugador]);
        return vuelta;
    }

    public void setTurnoJugador(int jugador, boolean turno) {
        this.turno[jugador] = turno;
    }

    @Override    
    public String toString() {
        String current;
        current
                = "FECHA DE LA PARTIDA: " + getFechaActual() + ".\n"
                + "------------------------------------------------\n";

        for (int i = 0; i < 2; i++) {
            current
                    += "--------------------------------------------------------\n"
                    + "Jugador numero " + i + ": " + jugadores[i].getNombre() + ".\n"
                    + "\t-Puntos en esta partida: " + aciertos[i] + ".\n"
                    + "\t-Informacion del rosco: " + roscos[i] + ".\n";

            for (int j = 0; j < numPalabras; j++) {
                if (ayudaUsada[i][j]) {
                    current += "\tEl jugador tambien ha usado una ayuda de tipo: " + ayudas[i][j].getClass() + "\n";
                }
            }
        }

        return current;
    }

}
