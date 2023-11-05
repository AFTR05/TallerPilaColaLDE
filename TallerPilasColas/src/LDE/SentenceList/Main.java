package LDE.SentenceList;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDobleEnlazada lista = new ListaDobleEnlazada();

        System.out.println("Ingresa una oración:");
        String oracion = scanner.nextLine();
        String[] palabras = oracion.split(" ");

        for (String palabra : palabras) {
            lista.insertar(palabra);
        }

        System.out.println("Oración en orden inverso:");
        lista.imprimirEnOrdenInverso();

        System.out.println("Ingresa una palabra para borrar:");
        String palabraABorrar = scanner.nextLine();
        lista.borrarNodo(palabraABorrar);

        System.out.println("Oración después de borrar la palabra:");
        lista.imprimirEnOrden();

        System.out.println("Ingresa una palabra para obtener la palabra anterior y siguiente:");
        String palabraBuscada = scanner.nextLine();
        lista.imprimirPalabraAnteriorSiguiente(palabraBuscada);
    }
}