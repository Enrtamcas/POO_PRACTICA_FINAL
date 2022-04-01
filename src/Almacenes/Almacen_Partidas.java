package Almacenes;

import Tipos_de_Juego.Partida;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Almacen_Partidas implements Serializable {

    Set<Partida> partidas;

    public Almacen_Partidas() {
        partidas = new HashSet<>();
    }

    public void añadirPartida(Partida p) {
        partidas.add(p);
    }


    public String consultarPartida() {
        return partidas.toString();
    }
        

    public void guardarAlmacen(String current) {
        try {

            //String current = "almacen_de_jugadores.ser";
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(current));

            System.out.println("Archivo: " + current + " creado para guardar el almacen de palabras.");

            salida.writeObject(this);
            salida.close();

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public Almacen_Partidas cargarAlmacen(String current) {
        try {

            //String current = "almacen_de_jugadores.ser";
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(current));

            System.out.println("Almacen de partidas cargado desde " + current + ".");

            Almacen_Partidas ap = (Almacen_Partidas) entrada.readObject();
            entrada.close();
            return ap;


        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
