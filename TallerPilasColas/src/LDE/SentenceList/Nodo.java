package LDE.SentenceList;

class Nodo {
    String palabra;
    int longitud;
    Nodo anterior;
    Nodo siguiente;

    public Nodo(String palabra) {
        this.palabra = palabra;
        this.longitud = palabra.length();
        this.anterior = null;
        this.siguiente = null;
    }
}