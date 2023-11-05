package PilasColas.CallCenterQueue;

import javax.swing.*;
import java.io.IOException;

public class TestCallCenter {
    public static void main(String[] args) throws IOException {
        int opc;
        CallCenterQueue listaC = new CallCenterQueue();
        listaC.iniciar_cola();
        String message = "1. Agregar llamada a la cola\n" +"2. Eliminar llamada de la cola\n"+
                "3. Mostrar todas las llamadas en cola\n"+"4. Mostrar primera llamada en cola\n"
                +"5. Calcular tiempo promedio de espera\n"+"6. Salir\n"+"Digite la opción: ";
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(message));
            switch (opc) {
                case 1 -> listaC.insertar_nodo_cola();
                case 2 -> listaC.borrar_nodo_cola();
                case 3 -> listaC.imprimir_cola();
                case 4 -> listaC.mostrarPrimeraLlamadaEnCola();
                case 5 -> listaC.calcularTiempoPromedioEspera();
            }
        } while (opc != 6);
        listaC.destruir_cola();
    }
}
