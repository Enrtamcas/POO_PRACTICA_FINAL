package Comparators;

import Personas.Jugador;

import java.util.Comparator;

public class ComparaPartidasGanadas implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Jugador j1 = (Jugador) o1;
        Jugador j2 = (Jugador) o2;
        if (j1.getHistorial().getPartidasGanadas() > j2.getHistorial().getPartidasGanadas()) return 1;
        
        return -1;
    }
}
