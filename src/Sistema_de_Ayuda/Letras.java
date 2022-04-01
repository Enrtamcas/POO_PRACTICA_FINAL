package Sistema_de_Ayuda;

import Componentes_Rosco.Palabra;

import java.io.Serializable;

public class Letras extends Pista implements Serializable {

    Palabra palabra;

    public Letras(Palabra palabra) {
        super(5);
        this.palabra = palabra;
    }

    @Override
    public String mostrar_info() {
        return palabra.mostrarUnTercio();
    }
}
