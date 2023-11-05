package LDE.SentenceList;

class ListaDobleEnlazada {
    Nodo cabeza;
    Nodo cola;

    public void insertar(String palabra) {
        Nodo nuevoNodo = new Nodo(palabra);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
    }

    public void imprimirEnOrden() {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            System.out.print(nodoActual.palabra + " ");
            nodoActual = nodoActual.siguiente;
        }
        System.out.println();
    }

    public void imprimirEnOrdenInverso() {
        Nodo nodoActual = cola;
        while (nodoActual != null) {
            System.out.print(nodoActual.palabra + " ");
            nodoActual = nodoActual.anterior;
        }
        System.out.println();
    }

    public void borrarNodo(String palabra) {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            if (nodoActual.palabra.equals(palabra)) {
                if (nodoActual == cabeza) {
                    cabeza = nodoActual.siguiente;
                    if (cabeza != null) {
                        cabeza.anterior = null;
                    }
                } else if (nodoActual == cola) {
                    cola = nodoActual.anterior;
                    cola.siguiente = null;
                } else {
                    nodoActual.anterior.siguiente = nodoActual.siguiente;
                    nodoActual.siguiente.anterior = nodoActual.anterior;
                }
                return;
            }
            nodoActual = nodoActual.siguiente;
        }
        System.out.println("Palabra no encontrada en la lista.");
    }

    public void imprimirPalabraAnteriorSiguiente(String palabra) {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            if (nodoActual.palabra.equals(palabra)) {
                Nodo anterior = nodoActual.anterior;
                Nodo siguiente = nodoActual.siguiente;

                if (anterior != null) {
                    System.out.println("Palabra anterior: " + anterior.palabra);
                } else {
                    System.out.println("No hay palabra anterior.");
                }

                if (siguiente != null) {
                    System.out.println("Palabra siguiente: " + siguiente.palabra);
                } else {
                    System.out.println("No hay palabra siguiente.");
                }
                return;
            }
            nodoActual = nodoActual.siguiente;
        }
        System.out.println("Palabra no encontrada en la lista.");
    }
}