package Almacenes;

import Comparators.ComparaPartidasGanadas;
import Comparators.ComparaPuntos;
import Personas.Jugador;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Almacen_Jugadores implements Serializable {

    ArrayList<Jugador> jugadores;

    public Almacen_Jugadores() {
        jugadores = new ArrayList<>();
    }

    public String mostrarClasificacion(boolean porPuntos) {
        Set<Jugador> jugadoresOrdenado = null;
        if (porPuntos) {
            ComparaPuntos comparaPuntos = new ComparaPuntos();
            jugadoresOrdenado = new TreeSet<>(comparaPuntos);
        }
        if (!porPuntos) {
            ComparaPartidasGanadas comparaPartidas = new ComparaPartidasGanadas();
            jugadoresOrdenado = new TreeSet<>(comparaPartidas);
        }

        for (int i = 0; i < jugadores.size(); i++) {
            if (porPuntos) {
                jugadores.get(i).setPorPuntos(1);
            }
            if (!porPuntos) {
                jugadores.get(i).setPorPuntos(2);
            }
            jugadoresOrdenado.add(jugadores.get(i));
        }

        String current = "";
        Iterator it = jugadoresOrdenado.iterator();
        while (it.hasNext()) {
            current += ((Jugador) it.next());
        }

        return current;
    }

    public boolean addJugador(Jugador j) {
        if (!jugadores.contains(j)) {
            jugadores.add(j);
            return true;
        }
        return false;
    }

    public void removeJugador(Jugador j) {
        jugadores.remove(j);
    }

    public void guardarAlmacen(String current) {
        try {

            //String current = "almacen_de_jugadores.ser";
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(current));

            System.out.println("Archivo: " + current + " creado para guardar el almacen de jugadores.");

            salida.writeObject(this);
            salida.close();

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public Almacen_Jugadores cargarAlmacen(String current) {
        try {

            //String current = "almacen_de_jugadores.ser";
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(current));

            System.out.println("Almacen de jugadores cargado desde " + current + ".");
            Almacen_Jugadores aj = (Almacen_Jugadores) entrada.readObject();
            entrada.close();
            return aj;

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkUser(String user, String password) {

        for (int i = 0; i < jugadores.size(); i++) {
            String currentUser = jugadores.get(i).getNombre();
            String currentPass = jugadores.get(i).getContraseña();

            if ((user.equals(currentUser)) && (password.equals(currentPass))) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return jugadores.isEmpty();
    }

    public Jugador selectJugador(String user, String password) {
        for (int i = 0; i < jugadores.size(); i++) {
            String currentUser = jugadores.get(i).getNombre();
            String currentPass = jugadores.get(i).getContraseña();

            if ((user.equals(currentUser)) && (password.equals(currentPass))) {
                Jugador jugador = jugadores.get(i);
                return jugador;
            }
        }
        return null;
    }

    public int sizeJugadores() {
        return jugadores.size();
    }

    public Jugador getJugador(int index) {
        return jugadores.get(index);
    }

    @Override
    public String toString() {
        return "Almacen_Jugadores{" + "jugadores=" + jugadores + '}';
    }

}
