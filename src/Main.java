import Clases.Usuario;
import DataBase.conexiondb;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

 class Main {
     private static Map<Integer, Usuario> usuarios = new HashMap<>();
     private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

            int opcion = 0;
            do {
                System.out.println("\n--- Menú de Gestión del Gimnasio ---");
                System.out.println("1. Introducir un nuevo usuario");
                System.out.println("2. Comprobar si un usuario ya existe");
                System.out.println("3. Mostrar detalles de un usuario");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();  // Consume el salto de línea restante

                switch (opcion) {
                    case 1:
                        registrarUsuario();
                        break;
                    case 2:
                        comprobarUsuario();
                        break;
                    case 3:
                        mostrarDetallesUsuario();
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción correcta.");
                        break;
                }
            } while (opcion != 4);
        }

        private static void registrarUsuario() {
            System.out.println("Introduzca los detalles del nuevo usuario:");

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();  // Consume el salto de línea

            System.out.print("ID(DNI): ");
            int id = Integer.parseInt(scanner.nextLine());

            if (usuarios.containsKey(id)) {
                System.out.println("Error: Ya existe un usuario con ese ID.");
                return;
            }

            System.out.print("Peso (en kg): ");
            double peso = scanner.nextDouble();

            System.out.print("Altura (en cm): ");
            int altura = scanner.nextInt();

            System.out.print("Plan de entrenamiento: ");
            String planEntrenamiento = scanner.nextLine();

            Usuario usuario = new Usuario(nombre, edad, id, peso, altura, planEntrenamiento);
            usuarios.put(id, usuario);
            conexiondb.registarUrusarios(nombre,edad, id, peso, altura, planEntrenamiento);
        }

        private static void comprobarUsuario() {
            System.out.print("Introduce el ID del usuario a comprobar: ");
            int id = scanner.nextInt();
            conexiondb.comprobarConexion();
            conexiondb.mostrarDatosUsuario(id);
        }

        private static void mostrarDetallesUsuario() {
            System.out.print("Introduce el ID del usuario cuyos detalles quieres ver: ");
            String id = scanner.nextLine();
            conexiondb.mostrarDatosUsuario(Integer.parseInt(id));
        }
    }