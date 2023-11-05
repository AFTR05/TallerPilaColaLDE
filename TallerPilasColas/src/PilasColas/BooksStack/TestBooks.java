package PilasColas.BooksStack;

import javax.swing.*;
import java.io.IOException;

public class TestBooks {
    public static void main(String[] args) throws IOException {
        int opc;
        BooksStack pilaLibros = new BooksStack();
        pilaLibros.iniciar_pila();
        String message="1. Añadir un libro a la pila\n"+"2. Sacar un libro de la pila\n"
                +"3. Mostrar todos los libros en la pila\n"+"4. Buscar libro"+"5. Vaciar Pila"+"6. Cantidad de libros"+
                "7. Salir\n"+"Ingrese la opción: ";
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(message));
            switch (opc) {
                case 1 -> pilaLibros.insertar_libro();
                case 2 -> pilaLibros.sacar_libro();
                case 3 -> pilaLibros.imprimir_pila();
                case 4 -> pilaLibros.buscarLibro(JOptionPane.showInputDialog("Digite el nombre del libro"));
                case 5 -> pilaLibros.vaciar_pila();
                case 6 -> pilaLibros.contarLibros();
            }
        } while (opc != 7);
        pilaLibros.vaciar_pila();
    }
}
