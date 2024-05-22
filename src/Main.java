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
                System.out.println("4. Actualizar datos de un usuario");
                System.out.println("5. Eliminar un usuario");
                System.out.println("7. Salir");
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
                        actualizarUsuario();
                        break;
                    case 5:
                        eliminarUsuario();
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción correcta.");
                        break;
                }
            } while (opcion != 4);
        }

        private static void actualizarUsuario() {
            System.out.print("Introduce el ID del usuario a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume el salto de línea

            if (!usuarios.containsKey(id)) {
                System.out.println("Error: No existe un usuario con ese ID.");
                return;
            }

            Usuario usuario = usuarios.get(id);
            System.out.println("Introduce los nuevos datos del usuario (deja en blanco para mantener los datos actuales):");

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                usuario.setNombre(nombre);
            }

            System.out.print("Edad: ");
            String edadStr = scanner.nextLine();
            if (!edadStr.isEmpty()) {
                int edad = Integer.parseInt(edadStr);
                usuario.setEdad(edad);
            }

            System.out.print("Peso (en kg): ");
            String pesoStr = scanner.nextLine();
            if (!pesoStr.isEmpty()) {
                double peso = Double.parseDouble(pesoStr);
                usuario.setPeso(peso);
            }

            System.out.print("Altura (en cm): ");
            String alturaStr = scanner.nextLine();
            if (!alturaStr.isEmpty()) {
                int altura = Integer.parseInt(alturaStr);
                usuario.setAltura(altura);
            }

            System.out.print("Plan de entrenamiento: ");
            String planEntrenamiento = scanner.nextLine();
            if (!planEntrenamiento.isEmpty()) {
                usuario.setPlanEntrenamiento(planEntrenamiento);
            }
            conexiondb.registarUrusarios(usuario.getNombre(),usuario.getEdad(), usuario.getId(), usuario.getPeso(), usuario.getAltura(), usuario.getPlanEntrenamiento());
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
            conexiondb.comporbarRegistro(id);
        }

        private static void mostrarDetallesUsuario() {
            System.out.print("Introduce el ID del usuario cuyos detalles quieres ver: ");
            String id = scanner.nextLine();
            conexiondb.mostrarDatosUsuario(Integer.parseInt(id));
        }

        private static void eliminarUsuario() {
            System.out.print("Introduce el ID del usuario a eliminar: ");
            int id = scanner.nextInt();
            conexiondb.eliminarDatos(id);
        }
    }