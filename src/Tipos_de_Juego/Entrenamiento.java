package Tipos_de_Juego;

import Almacenes.Almacen_Palabras;
import Componentes_Rosco.Palabra;
import Componentes_Rosco.Rosco;
import Personas.Jugador;
import Sistema_de_Ayuda.*;

import java.util.Scanner;

public class Entrenamiento {

    Jugador jugador;
    int beneficio;
    int numPalabras;
    int posActual;
    Rosco rosco;

    String aciertos;
    String fallos;
    String vueltas;

    Ayuda[] ayudas;

    public Entrenamiento(Jugador jugador, int numPalabras, Almacen_Palabras almacen) {
        this.jugador = jugador;
        beneficio = 5;

        aciertos = "0";
        fallos = "0";
        vueltas = "1";

        this.numPalabras = numPalabras;

        posActual = -1;

        ayudas = new Ayuda[numPalabras];

        if (jugador.getIntPuntos() == 0) {
            jugador.setPuntos(jugador.getIntPuntos() + beneficio);
        }
        this.rosco = new Rosco(numPalabras, almacen);
    }

    public Palabra devolverPalabraActual(int index) {
        return rosco.getPalabra(index);
    }

    public int posPalabraActual() {
        return posActual;
    }

    public void setPosPalabraActual(int posActual) {
        this.posActual = posActual;
    }

    public Rosco getRosco() {
        return rosco;
    }

    public String sumarVuelta() {
        String current;

        int vuelta = Integer.parseInt(vueltas);
        vuelta++;
        current = String.valueOf(vuelta);
        vueltas = current;
        return current;
    }

    public String acertar() {
        int puntosAntes = Integer.parseInt(aciertos);
        puntosAntes++;
        String puntosAhora = String.valueOf(puntosAntes);
        aciertos = puntosAhora;
        return aciertos;
    }

    public String fallar() {
        int fallosAntes = Integer.parseInt(fallos);
        fallosAntes++;
        String fallosAhora = String.valueOf(fallosAntes);
        fallos = fallosAhora;
        return fallos;
    }

    public String mostrarPista(int index) {
        Palabra palabraActual = devolverPalabraActual(index);

        if (palabraActual.tieneMasDeUnaDefinicion()) {
            ayudas[index] = new SegundaDefinicion(palabraActual);
        } else {
            ayudas[index] = new Letras(palabraActual);
        }

        String ayuda = ayudas[index].mostrar_info();

        return ayuda;
    }

    public int getNumPal() {
        return rosco.getNumPalabras();
    }

    public String comprarPalabra(int index) {
        Palabra palabraActual = devolverPalabraActual(index);

        ayudas[index] = new Compra(palabraActual);

        String ayuda = ayudas[index].mostrar_info();

        return ayuda;

    }

    public String getAciertos() {
        return aciertos;
    }

    public int getIntAciertos() {
        int aciertos = Integer.parseInt(this.aciertos);
        return aciertos;
    }

    public int getIntFallos() {
        int fallos = Integer.parseInt(this.fallos);
        return fallos;
    }

    public String getFallos() {
        return fallos;
    }

    public String getVuelta() {
        return vueltas;
    }
}

/*JFrame jf = new JFrame();
                   JOptionPane.showMessageDialog(jf, "Has perdido.");

                    this.setVisible(false);
                    vJugador.setVisible(true);*/
