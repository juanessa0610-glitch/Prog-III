public class Casillero {

    private int numero;
    private boolean ocupado;
    private Paquete paquete;

    public Casillero(int numero) {
        this.numero = numero;
        this.ocupado = false;
        this.paquete = null;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    public void asignarPaquete(Paquete paquete) {
        if (!ocupado) {
            this.paquete = paquete;
            this.ocupado = true;
            System.out.println(" Paquete asignado al casillero " + numero);
        } else {
            System.out.println(" Casillero " + numero + " ya está ocupado.");
        }
    }

    public void liberarCasillero() {
        if (ocupado) {
            this.paquete = null;
            this.ocupado = false;
            System.out.println("Casillero " + numero + " liberado.");
        }
    }

    public void mostrarInfo() {
        if (ocupado) {
            System.out.println("Casillero " + numero + " ---> " + paquete);
        } else {
            System.out.println("Casillero " + numero + " está libre.");
        }
    }
}