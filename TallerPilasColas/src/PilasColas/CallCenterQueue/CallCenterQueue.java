package PilasColas.CallCenterQueue;

import javax.swing.*;
import java.io.IOException;

public class CallCenterQueue {
    NodeCallCenter cab;
    NodeCallCenter mobile;
    NodeCallCenter end;

    public CallCenterQueue() {
    }
    public void iniciar_cola() {
        cab = null;
    }

    public void insertar_nodo_cola() throws IOException {
        NodeCallCenter nuevo = new NodeCallCenter();
        nuevo.numero = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de la llamada: "));
        nuevo.nombre = JOptionPane.showInputDialog("Digite el nombre del cliente: ");
        nuevo.motivo = JOptionPane.showInputDialog("Digite el motivo de la llamada: ");
        if (cab == null) {
            nuevo.sig = cab;
            cab = nuevo;
            end = cab;
        } else {
            end.sig = nuevo;
            nuevo.sig = null;
            end = nuevo;
        }
    }

    public void borrar_nodo_cola() {
        NodeCallCenter borra;
        if (cab == null) {
            JOptionPane.showMessageDialog(null,"No hay llamadas en la cola");
            return;
        }
        borra = cab;
        cab = borra.sig;
        borra = null;
    }

    public void imprimir_cola() {
        StringBuilder printer= new StringBuilder();
        mobile = cab;
        while (mobile != null) {
            printer.append("\nLlamada número: ").append(mobile.numero)
                    .append("- Nombre del cliente: ").append(mobile.nombre)
                    .append("- Motivo de la llamada: ").append(mobile.motivo);
            mobile = mobile.sig;
        }
        JOptionPane.showMessageDialog(null,printer);
    }

    public void destruir_cola() {
        NodeCallCenter borra;
        borra = cab;
        mobile = cab;
        while (mobile != null) {
            mobile = mobile.sig;
            borra = null;
            borra = mobile;
        }
    }

    public void mostrarPrimeraLlamadaEnCola() {
        if (cab == null) {
            JOptionPane.showMessageDialog(null,"No hay llamadas en la cola");
            return;
        }
        JOptionPane.showMessageDialog(null,"Información de la primera llamada en cola:\n"
        +"Número de la llamada: " + cab.numero+"\nNombre del cliente: " + cab.nombre
        +"\nMotivo de la llamada: " + cab.motivo);
    }

    public void calcularTiempoPromedioEspera() {
        int totalTiempo = 0;
        int totalLlamadas = 0;
        NodeCallCenter temp = cab;
        while (temp != null) {
            totalTiempo += temp.numero;
            totalLlamadas++;
            temp = temp.sig;
        }
        if (totalLlamadas > 0) {
            double tiempoPromedio = (double) totalTiempo / totalLlamadas;
            JOptionPane.showMessageDialog(null,
                    "El tiempo promedio de espera en la cola es: " + tiempoPromedio + " minutos");
        } else {
            JOptionPane.showMessageDialog(null,"No hay llamadas en la cola");
        }
    }
}
