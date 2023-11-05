package PilasColas.BooksStack;

import javax.swing.*;
import java.io.IOException;

public class BooksStack {
    BookNode cab;
    BookNode mobile;
    public BooksStack() {
    } // constructor de la clase

    public void iniciar_pila() {
        cab = null;
    }

    public void insertar_libro() throws IOException {
        BookNode nuevo = new BookNode();
        nuevo.title = JOptionPane.showInputDialog("Ingrese el titulo del libro: ");
        nuevo.autor = JOptionPane.showInputDialog("Ingrese el autor del libro: ");
        nuevo.publicationYear = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de publicacion del libro: "));
        nuevo.sig = cab;
        cab = nuevo;
    }

    public void sacar_libro() {
        BookNode saca;
        mobile = cab;
        if (cab == null) {
            JOptionPane.showMessageDialog(null,"No hay libros en la pila");
            return;
        }
        if (mobile != null) {
            saca = cab;
            cab = mobile.sig;
            saca = null;
        }
    }

    public void imprimir_pila() {
        mobile = cab;
        StringBuilder message= new StringBuilder();
        while (mobile != null) {
            message.append("Título: ").append(mobile.title).append(" - Autor: ")
                    .append(mobile.autor).append(" - Año de publicación: ").append(mobile.publicationYear);
            mobile = mobile.sig;
        }
        JOptionPane.showMessageDialog(null,message);
    }

    public boolean buscarLibro(String titulo) {
        mobile = cab;
        while (mobile != null) {
            if (mobile.title.equalsIgnoreCase(titulo)) {
                JOptionPane.showMessageDialog(null,"El libro con el título '" + titulo +
                                "' se encontró en la pila.\n" +
                                "Título: "+mobile.title+" - Autor: "+mobile.autor+
                        " - Año de publicación: "+mobile.publicationYear);
                return true;
            }
            mobile = mobile.sig;
        }
        JOptionPane.showMessageDialog(null,"El libro con el título '" + titulo
                + "' no se encontró en la pila.");
        return false;
    }

    public void vaciarPilaCompleta() {
        cab = null;
        JOptionPane.showMessageDialog(null,"La pila de libros se ha vaciado por completo.");
    }

    public int contarLibros() {
        int contador = 0;
        mobile = cab;
        while (mobile != null) {
            contador++;
            mobile = mobile.sig;
        }
        return contador;
    }
    public void mostrarNumeroLibros() {
        int contador = contarLibros();
        JOptionPane.showMessageDialog(null,"El número total de libros en la pila es: " + contador);
    }


    public void vaciar_pila() {
        BookNode saca;
        saca = cab;
        mobile = cab;
        while (mobile != null) {
            mobile = mobile.sig;
            saca = null;
            saca = mobile;
        }
    }
}
