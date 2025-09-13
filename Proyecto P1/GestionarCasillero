public class GestionarCasillero {
    private Casillero [][] casilleros;

    public GestionarCasillero (int filas, int columnas) {
        casilleros = new Casillero [filas][columnas];
        int contador = 1;
        for (int i=0; i <filas, i++) {
            for (int j=0; j <columnas, j++){
                casilleros [i][j] = new Casillero (contador++)
            }
        }
    }

    public void registrarPaquete(int id, String destinatario, String fecha) {
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                if (!casilleros[i][j].estaOcupado()) {
                    Paquete p = new Paquete(id, destinatario, fecha);
                    casilleros[i][j].asignarPaquete(p);
                    return;
                }
            }
        }
        System.out.println("No hay casilleros disponibles.");
    }
    public void ConsultarDisponibilidad() {
    system.out.println("\nCasilleros Disponibles: ");
    Boolean Libre = false;
    for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                if (!casilleros[i][j].estaOcupado()) {
                    System.out.print("[ " + (i+1) + "," + (j+1) + " ] ");
                    Libre = true;
                }
            }
        }
        if (!Libre) {
            System.out.println("No hay casilleros libres.");
        }
        System.out.println();
    }
    public void MostrarInformacion () {
        system.out.println("\nInformación de casilleros:");
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                casilleros[i][j].mostrarInfo();
            }
        }
    }
    }

}