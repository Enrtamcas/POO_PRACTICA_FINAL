package Personas;

import Tipos_de_Juego.Partida;

import java.io.Serializable;
import java.util.ArrayList;

public class Historial implements Serializable {

    private Jugador jugador;
    private ArrayList<Partida> partidasGanadas;
    private ArrayList<Partida> partidasPerdidas;
    private ArrayList<Partida> partidasEmpatadas;
    int puntosTotales;

    public int getPartidasGanadas() {
        return partidasGanadas.size();
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas.size();
    }

    public int getPartidasEmpatadas() {
        return partidasEmpatadas.size();
    }
    public int getPartidasJugadas() {

        return getPartidasEmpatadas() + getPartidasPerdidas() + getPartidasGanadas();
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public Historial(Jugador jugador) {
        this.jugador = jugador;
        jugador.setHistorial(this);

        partidasGanadas = new ArrayList<>();
        partidasPerdidas = new ArrayList<>();
        partidasEmpatadas = new ArrayList<>();
        puntosTotales = jugador.getIntPuntos();

    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setDueño(Jugador jugador) {
        if (jugador == null) {
            this.jugador = null;
            return;
        }
        if (this.jugador != jugador) {
            Jugador oldJugador = this.jugador;
            if (oldJugador != null) {
                oldJugador.setHistorial(null);
                this.jugador = jugador;
                jugador.setHistorial(this);
            }
        }
    }

    public void ganarPartida(Partida partida) {
        partidasGanadas.add(partida);
    }

    public void perderPartida(Partida partida) {
        partidasPerdidas.add(partida);
    }

    public void empatarPartida(Partida partida) {
        partidasEmpatadas.add(partida);
    }

    public void sumarPuntos(int puntos) {
        puntosTotales += puntos;
    }


    @Override
    public String toString() {
        String current;
        current =
                "---------------------------------------------------\n" +
                        "Nombre del jugador: " + jugador.getNombre() + ".\n" +
                        "Puntos ganados hasta el momento: " + puntosTotales + ".\n" +
                        "Puntos para jugar actualmente: " + jugador.getPuntos() + ".\n" +
                        "Numero de partidas jugadas: " + getPartidasJugadas() + ".\n" +
                        "Numero de partidas ganadas: " + getPartidasGanadas() + ".\n" +
                        "Numero de partidas perdidas: " + getPartidasPerdidas() + ".\n" +
                        "Numero de partidas empatadas: " + getPartidasEmpatadas() + ".\n" +
                        "----------------------------------------------------\n";

        current +=
                "-------------------------\n" +
                        "PARTIDAS GANADAS: \n" +
                "-------------------------\n";

        for (Partida p : partidasGanadas) {
            current += p;
        }

        current +=
                "-------------------------\n" +
                        "PARTIDAS PERDIDAS:\n" +
                "-------------------------\n";

        for (Partida p : partidasPerdidas) {
            current += p;
        }

        current +=
                "-------------------------\n" +
                        "PARTIDAS EMPATADAS:\n" +
                 "-------------------------\n";

        for (Partida p : partidasEmpatadas) {
            current += p;
        }

        
        return current;
    }
}
