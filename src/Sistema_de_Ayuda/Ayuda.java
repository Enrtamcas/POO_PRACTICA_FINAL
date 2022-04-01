package Sistema_de_Ayuda;

import java.io.Serializable;

public abstract class Ayuda implements Serializable {
    int precio;

    public Ayuda(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public String mostrar_info() {
        String current = "";
        return current;
    }
}
