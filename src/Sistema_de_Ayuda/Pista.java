package Sistema_de_Ayuda;

import Componentes_Rosco.Palabra;

import java.io.Serializable;

abstract class Pista extends Ayuda implements Serializable {

    public Pista(int precio) {
        super(precio);
    }

}
