package Almacenes;

import Componentes_Rosco.Palabra;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Almacen_Palabras implements Serializable {

    ArrayList<Palabra>[] palabras;
    String abecedario;
    char[] abecedarioArray;

    public Almacen_Palabras() {
        abecedario = "abcdefghijlmnopqrstuvxyz";
        abecedarioArray = abecedario.toCharArray();

        palabras = new ArrayList[abecedarioArray.length];

        for (int i = 0; i < palabras.length; i++) {
            palabras[i] = new ArrayList<>();
        }

    }

    public int sizeAlmacen() {
        return palabras.length;
    }

    public int sizeAlmacenLetra(int i) {
        return palabras[i].size();
    }

    public Palabra getPalabra(int index, int letra) {
        return palabras[index].get(letra);
    }

    public Palabra getPalabra(String p) {

        for (int i = 0; i < palabras.length; i++) {
            for (int j = 0; j < palabras[i].size(); j++) {
                if (palabras[i].get(j).getPalabra().equals(p)) {
                    return palabras[i].get(j);
                }
            }
        }
        return null;
    }

    public void sustituirPalabra(Palabra p, String texto) {
        for (int i = 0; i < palabras.length; i++) {
            for (int j = 0; j < palabras[i].size(); j++) {
                
                if (palabras[i].get(j).equals(p)) {
                    System.out.println("He llegado aqui");
                    System.out.println(p);
                    System.out.println(palabras[i].get(j));
                    
                    Palabra palabraAux = new Palabra(texto);
                    palabraAux.setDefiniciones(palabras[i].get(j).getDefiniciones());

                    palabras[i].remove(palabras[i].get(j));
                    
                    System.out.println(palabraAux);
                    
                    addPalabra(palabraAux);
                }
                
            }
        }
    }

    public boolean remove(Palabra p) {
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].remove(p))
                return true;
        }
        return false;
    }

    public void addPalabra(Palabra p) {

        char inicial = p.getInicial();
        String inicialString = String.valueOf(inicial);
        inicialString = inicialString.toLowerCase();

        for (int i = 0; i < palabras.length; i++) {
            String abecedario = String.valueOf(abecedarioArray[i]);
            if (inicialString.equalsIgnoreCase(abecedario)) {
                palabras[i].add(p);
            }
        }

    }

    public Palabra getPalabra(char c) {
        Palabra palabraBuscada = null;

        String caracter = String.valueOf(c);
        int pos = 0;

        for (int i = 0; i < palabras.length; i++) {

            String caracterDelArray = String.valueOf(palabras[i].get(0).getInicial());

            if (caracter.equalsIgnoreCase(caracterDelArray)) {
                if (palabras[i].size() > 1) {
                    pos = (int) Math.floor(Math.random() * palabras[i].size());
                }
                palabraBuscada = palabras[i].get(pos);
                return palabraBuscada;
            }

        }
        return palabraBuscada;
    }

    public void editPalabra(Palabra p) {
        boolean encontrado = false;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < abecedarioArray.length && !encontrado; i++) {
            if (palabras[i].remove(p)) {
                encontrado = true;

                System.out.println("Por favor, intrduzca la nueva palabra: ");

                Palabra palabra = new Palabra(scanner.nextLine());

                do {
                    System.out.println("Añada una definición, por favor:");
                    palabra.addDefinicion(scanner.nextLine());
                    System.out.println("¿Desea añadir otra más? \n1 -> Sí.\n2 -> No.");
                } while (scanner.nextInt() != 1);
                palabras[i].add(p);
            }
        }
    }

    public boolean esVacio(int numPal) {
        for (int i = 0; i < abecedarioArray.length; i++) {
            if (palabras[i].isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void guardarAlmacen(String current) {
        try {

            //String current = "almacen_de_jugadores.ser";
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(current));

            System.out.println("Archivo: " + current + " creado para guardar el almacen de palabras.");

            salida.writeObject(this);
            salida.close();

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public Almacen_Palabras cargarAlmacen(String current) {
        try {

            //String current = "almacen_de_palabras.ser";
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(current));

            System.out.println("Almacen de palabras cargado desde " + current + ".");
            Almacen_Palabras ap = (Almacen_Palabras) entrada.readObject();

            entrada.close();
            return ap;

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        String current = "[";

        for (int i = 0; i < abecedarioArray.length; i++) {
            for (int j = 0; j < palabras[i].size(); j++) {
                if (i != abecedarioArray.length - 1) {
                    current += palabras[i].get(j) + ", ";
                } else {
                    current += palabras[i].get(j);
                }

            }
        }

        current += "]";
        return current;
    }

}
