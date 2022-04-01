package Componentes_Rosco;

import Almacenes.Almacen_Palabras;

import java.io.Serializable;
import java.util.ArrayList;

public class Rosco implements Serializable {

    private int numPalabras;
    private String vuelta;
    private ArrayList<Palabra> palabras;

    String abecedario;
    char[] abecedarioArray;

    public Rosco(int numPalabras, Almacen_Palabras almacen) {
        vuelta = "1";
        this.numPalabras = numPalabras;

        palabras = new ArrayList<>();

        abecedario = "abcdefghijlmnopqrstuvxyz";
        abecedarioArray = abecedario.toCharArray();

        for (int i = 0; i < numPalabras; i++) {
            Palabra palabraAñadir = almacen.getPalabra(abecedarioArray[i]);
           
            palabras.add(new Palabra(palabraAñadir));
        }

    }

    public void setPalabra(Palabra p, int index) {
        palabras.set(index, p);
    }

    public int getNumPalabras() {
        return numPalabras;
    }

    public Palabra getPalabra(int index) {
        return palabras.get(index);
    }

    @Override
    public String toString() {
        String current;

        current = "\nNumero de letras: " + numPalabras + ".\n";
        for (int i = 0; i < numPalabras; i++) {
            Palabra palabraActual = palabras.get(i);
            String inicial = String.valueOf(palabraActual.getInicial());
            String definicion = palabraActual.getDefinicion().toString();

            current += inicial + ": " + palabraActual.toString() + ".\n";
            current += definicion;
        }

        return current;
    }
}
