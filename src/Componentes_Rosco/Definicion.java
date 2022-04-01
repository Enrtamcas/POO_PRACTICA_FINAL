package Componentes_Rosco;

import java.io.Serializable;
import java.util.Objects;

public class Definicion implements Serializable {
    String definicion;

    public Definicion(String definicion) {
        this.definicion = definicion;
    }

    public String getDefinicion() {
        return definicion;
    }

    @Override
    public String toString() {
        return "Definicion = " + definicion + ".\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.definicion);
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
        final Definicion other = (Definicion) obj;
        if (!Objects.equals(this.definicion, other.definicion)) {
            return false;
        }
        return true;
    }
    
    
    
}
