import java.util.*;

public class Estudiante {

    // Atributos
    private int Id;
    private String nombre;
    private String Facultad;

    // Constructor
    public Estudiante(int Id, String nombre, String Facultad) {
        this.Id = Id;
        this.nombre = nombre;
        this.Facultad = Facultad;
    }

    @Override
    public String toString() {
        return "Estudiante{ Id: " + Id + "  Nombre: " + nombre + "  Facultad: " + Facultad + " }";
    }

    // Método para contar estudiantes de una facultad
    public static int CantidadEstudiantes(Estudiante[] estudiantes, String facultadBuscada) {
        int contador = 0;
        for (Estudiante est : estudiantes) {
            if (est != null && est.Facultad.equalsIgnoreCase(facultadBuscada)) {
                contador++;
            }
        }
        return contador;
    }

    // Clase ejecutora
    public static class EjecutarEstudiante {

        public static void main(String[] args) {
            // Facultades
            String[] facultades = {
                "Ingenieria de sistemas",
                "Ingenieria civil",
                "Derecho",
                "Medicina",
                "Administracion"
            };

            // Listas de nombres y apellidos
            String[] nombres = {
                "Juan", "Pedro", "Maria", "Luisa", "Andres", "Carolina", "Daniel", "Valentina", "Sofia", "Camilo",
                "Laura", "Felipe", "Paula", "David", "Alejandra", "Sebastian", "Angela", "Esteban", "Manuela", "Jorge"
            };
            String[] apellidos = {
                "Gomez", "Perez", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Garcia", "Ramirez", "Castro", "Mora",
                "Gutierrez", "Ortega", "Suarez", "Castaño", "Diaz", "Moreno", "Salazar", "Pardo", "Rios", "Vargas"
            };

            // Generar todas las combinaciones posibles
            List<String> combinaciones = new ArrayList<>();
            for (String nom : nombres) {
                for (String ape : apellidos) {
                    combinaciones.add(nom + " " + ape);
                }
            }

            // Mezclamos las combinaciones
            Collections.shuffle(combinaciones);

            // Creamos un arreglo para 30 estudiantes únicos
            Estudiante[] estudiantes = new Estudiante[30];
            int id = 100;
            int index = 0;

            // Generamos 6 estudiantes por facultad
            for (String fac : facultades) {
                for (int i = 0; i < 6; i++) {
                    estudiantes[index] = new Estudiante(
                        id,
                        combinaciones.get(index), // nombre único
                        fac
                    );
                    id++;
                    index++;
                }
            }

            // Imprimir todos los estudiantes
            for (Estudiante e : estudiantes) {
                System.out.println(e);
            }

            System.out.println("--------------------------------------------------");

            // Contar por facultad
            for (String fac : facultades) {
                int cantidad = Estudiante.CantidadEstudiantes(estudiantes, fac);
                System.out.println("Cantidad de estudiantes en " + fac + " = " + cantidad);
            }
        }
    }
}