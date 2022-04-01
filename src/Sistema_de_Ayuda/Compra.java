package Sistema_de_Ayuda;

import Componentes_Rosco.Palabra;

import java.io.Serializable;

public class Compra extends Ayuda implements Serializable {

    Palabra palabra;

    public Compra(Palabra palabra) {
        super(20);
        this.palabra = palabra;
    }

    @Override
    public String mostrar_info() {
        String current;
        current = palabra.toString();
        return current;
    }
}
