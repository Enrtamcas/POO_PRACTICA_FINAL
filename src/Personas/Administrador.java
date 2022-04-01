package Personas;

import Almacenes.Almacen_Jugadores;
import Almacenes.Almacen_Palabras;
import Almacenes.Almacen_Partidas;

import java.io.Serializable;
import java.util.Objects;


public class Administrador implements Serializable {

    private String nombre;
    private String contraseña;
    private int puntos;

    public Administrador(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        puntos = 1000000;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getPuntos() {
        return puntos;
    }



    public boolean equalsWA(Jugador obj) {

        if (this.nombre.equals(obj.getNombre())) {
            return true;
        }
        return false;
    }
    
    
}
