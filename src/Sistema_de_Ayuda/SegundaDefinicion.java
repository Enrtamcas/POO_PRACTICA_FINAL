package Sistema_de_Ayuda;

import Componentes_Rosco.Palabra;

import java.io.Serializable;

public class SegundaDefinicion extends Pista implements Serializable {


    Palabra palabra;

    public SegundaDefinicion(Palabra palabra) {
        super(5);
        this.palabra = palabra;
    }

    public String mostrar_info() {
        return palabra.mostrarOtraDefinicion();
    }
}
