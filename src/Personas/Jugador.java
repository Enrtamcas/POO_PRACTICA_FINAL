package Personas;

import java.io.Serializable;
import java.util.Objects;

public class Jugador implements Serializable {

    private String nombre;
    private String contraseña;
    private int puntos;
    private Historial historial;
    private int porPuntos;

    public Jugador(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        porPuntos = 0;
        puntos = 25;
        historial = new Historial(this);
    }

    public Jugador(Administrador admin) {
        this.nombre = admin.getNombre();
        this.contraseña = admin.getContraseña();
        porPuntos = 0;
        puntos = admin.getPuntos();
        historial = new Historial(this);
    }

    //GETS
    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getPuntos() {
        return String.valueOf(puntos);
    }

    public int getIntPuntos() {
        return puntos;
    }

    public Historial getHistorial() {
        return historial;
    }

    public int isPorPuntos() {
        return porPuntos;
    }

    public void setPorPuntos(int porPuntos) {
        this.porPuntos = porPuntos;
    }

    //SETS
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHistorial(Historial historial) {
        if (historial == null) {
            this.historial = null;
            return;
        }
        if (this.historial != historial) {
            Historial oldHistorial = this.historial;
            if (oldHistorial != null) {
                oldHistorial.setDueño(null);
                this.historial = historial;
                historial.setDueño(this);
            }
        }
    }

@Override
    public String toString() {
        String current = "";
        if (porPuntos == 1) {
            current = "Jugador{"
                + "nombre= " + nombre 
                + ", puntos ganados hasta el momento=" + historial.getPuntosTotales()
                + ", puntos actualmente=" + puntos
                + "}\n";
        } else if (porPuntos == 2) {
            current = "Jugador{"
                + "nombre= " + nombre 
                + ", partidas ganados hasta el momento=" + historial.getPartidasGanadas()
                + ", puntos actualmente=" + puntos
                + "}\n";
        } else {
            current = "Jugador{" +
                "nombre= " + nombre +
                ", puntos= " + puntos +
                "}\n";
        }
        return current;
    }

//
    public void mostrarHistorial() {
        System.out.println(historial);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    public boolean equalsWA(Administrador obj) {

        if (this.nombre.equals(obj.getNombre())) {
            return true;
        }
        return false;
    }

}
