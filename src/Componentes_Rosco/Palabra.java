package Componentes_Rosco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Palabra implements Serializable {

    private char inicial;
    private StringBuilder palabra;
    private boolean acertada;
    private boolean fallada;
    private boolean aplazada;
    private ArrayList<Definicion> definiciones;
    private boolean ayudaUtilizada;

    public Palabra(String texto) {
        definiciones = new ArrayList<>();

        char[] palabraArr = texto.toCharArray();
        inicial = palabraArr[0];
        palabra = new StringBuilder(texto);

        acertada = false;
        fallada = false;
        aplazada = false;
        ayudaUtilizada = false;
    }
    
    
    public Palabra(Palabra p) {
        definiciones = new ArrayList<>();
        for(int i = 0; i < p.getDefiniciones().size(); i++) {
            definiciones.add(new Definicion(p.getDefiniciones().get(i).getDefinicion()));
        }
        String texto = p.getPalabra();
        
        char[] palabraArr = texto.toCharArray();
        inicial = palabraArr[0];
        palabra = new StringBuilder(texto);

        acertada = false;
        fallada = false;
        aplazada = false;
        ayudaUtilizada = false;
    }

    public char getInicial() {
        return inicial;
    }

    public boolean getAyudaUtilizada() {
        return ayudaUtilizada;
    }
    
    public ArrayList<Definicion> getDefiniciones(){
        return definiciones;
    }
    
    public void setDefiniciones(ArrayList<Definicion> definiciones){
        this.definiciones = definiciones;
    }

    public void setAyudaUtilizada(boolean ayudaUtilizada) {
        this.ayudaUtilizada = ayudaUtilizada;
    }

    private Palabra rellenarPalabra(char[] palabraArr) {
        for (int i = 0; i < palabraArr.length; i++) {
            palabra.append(palabraArr[i]);
        }
        return this;
    }

    public void addDefinicion(String definicion) {
        Definicion definicionPalabra = new Definicion(definicion);
        definiciones.add(definicionPalabra);
    }
    
    public int sizeDefiniciones(){
        return definiciones.size();
    }


    public void editDefinicion(String texto, int def) {
        definiciones.set(def, new Definicion(texto));
    }

    public void mostrarPrimeraDefinicion() {
        System.out.println(definiciones.get(0));
    }

    public String mostrarOtraDefinicion() {

        int pos = (int) Math.floor(Math.random() * (definiciones.size() - 1) + 1);
        Definicion definicionBuscada = definiciones.get(pos);

        return definicionBuscada.toString();
    }

    public int nDefiniciones() {
        return definiciones.size();
    }

    public String mostrarUnTercio() {
        int longitud = palabra.length() / 3;
        Set<Integer> pos = new TreeSet<>();

        for (int i = 0; i < longitud; i++) {
            if (!pos.add((int) Math.floor(Math.random() * palabra.length()))) {
                i--;
            }
        }

        String palabraAux = palabra.toString();
        char[] palabraArray = palabraAux.toCharArray();

        String current = "";

        for (int i = 0; i < palabra.length(); i++) {
            if (pos.contains(i)) {
                current += palabraArray[i];
            } else {
                current += "_";
            }
        }

        return current;
    }

    public boolean tieneMasDeUnaDefinicion() {
        if (definiciones.size() > 1) {
            return true;
        } else {
            return false;
        }
    }

    public void setAcertada(boolean acertada) {
        this.acertada = acertada;
    }

    public void setFallada(boolean fallada) {
        this.fallada = fallada;
    }

    public void setAplazada(boolean aplazada) {
        this.aplazada = aplazada;
    }

    public boolean isAcertada() {
        return acertada;
    }

    public boolean isFallada() {
        return fallada;
    }

    public boolean isAplazada() {
        return aplazada;
    }

    public String getPalabra() {
        String palabra = this.palabra.toString();
        return palabra;
    }

    @Override
    public String toString() {
        String palabra = this.palabra.toString();
        return palabra;
    }

    public String adivinarPalabra() {
        String current;
        current = inicial + ":\n";
        current += this.definiciones.get(0).toString();
        return current;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.inicial;
        hash = 89 * hash + Objects.hashCode(this.palabra);
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
        final Palabra other = (Palabra) obj;
        if (this.inicial != other.inicial) {
            return false;
        }
        if (!Objects.equals(this.palabra, other.palabra)) {
            return false;
        }
        return true;
    }

    public void reset() {
        acertada = false;
        aplazada = false;
        fallada = false;
        ayudaUtilizada = false;
    }

    public Definicion getDefinicion() {
        return definiciones.get(0);
    }
}
