package main;

import java.util.ArrayList;
import java.util.Scanner;

import Actividades.ManejoActividades;
import Actividades.Enums.Horario;
import Actividades.Enums.TipoCiclismo;
import Actividades.TiposClases.Bodypump;
import Actividades.TiposClases.Ciclismo;
import Actividades.TiposClases.Yoga;
import Actividades.TiposClases.ClasesAbstractas.Clases;
import Personas.ManejoPersonas;
import Personas.TiposPersonas.Entrenador;
import Personas.TiposPersonas.Gerente;
import Personas.TiposPersonas.Recepcionista;
import Personas.TiposPersonas.Usuario;

public class main {
    private static ManejoPersonas manejoPersonas = new ManejoPersonas();
    private static ManejoActividades manejoActividades = new ManejoActividades();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("***** Menú Principal *****");
            System.out.println("1. Manejar Personas");
            System.out.println("2. Manejar Actividades");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuPersonas();
                    break;
                case 2:
                    menuActividades();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número válido.");
            }
        }
    }

    private static void menuPersonas() {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n***** Menú de Personas *****");
            System.out.println("1. Registrar Entrenador");
            System.out.println("2. Eliminar Entrenador");
            System.out.println("3. Actualizar Datos de Entrenador");
            System.out.println("4. Registrar Gerente");
            System.out.println("5. Eliminar Gerente");
            System.out.println("6. Actualizar Datos de Gerente");
            System.out.println("7. Registrar Recepcionista");
            System.out.println("8. Eliminar Recepcionista");
            System.out.println("9. Actualizar Datos de Recepcionista");
            System.out.println("10. Registrar Usuario");
            System.out.println("11. Eliminar Usuario");
            System.out.println("12. Actualizar Datos de Usuario");
            System.out.println("13. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Entrenador entrenador = crearEntrenador();
                    manejoPersonas.registrarEntrenador(entrenador);
                    break;
                case 2:
                    System.out.print("Ingrese el número de empleado del entrenador a eliminar: ");
                    String numeroEliminar = scanner.nextLine();
                    manejoPersonas.eliminarEntrenador(numeroEliminar);
                    break;
                case 3:
                    actualizarDatosEntrenador();
                    break;
                case 4:
                    Gerente gerente = crearGerente();
                    manejoPersonas.registrarGerente(gerente);
                    break;
                case 5:
                    System.out.print("Ingrese el número de empleado del gerente a eliminar: ");
                    String numeroEliminarGerente = scanner.nextLine();
                    manejoPersonas.eliminarGerente(numeroEliminarGerente);
                    break;
                case 6:
                    actualizarDatosGerente();
                    break;
                case 7:
                    Recepcionista recepcionista = crearRecepcionista();
                    manejoPersonas.registrarRecepcionista(recepcionista);
                    break;
                case 8:
                    System.out.print("Ingrese el número de empleado del recepcionista a eliminar: ");
                    String numeroEliminarRecepcionista = scanner.nextLine();
                    manejoPersonas.eliminarRecepcionista(numeroEliminarRecepcionista);
                    break;
                case 9:
                    actualizarDatosRecepcionista();
                    break;
                case 10:
                    Usuario usuario = crearUsuario();
                    manejoPersonas.registrarUsuario(usuario);
                    break;
                case 11:
                    System.out.print("Ingrese el número de empleado del usuario a eliminar: ");
                    String numeroEliminarUsuario = scanner.nextLine();
                    manejoPersonas.eliminarUsuario(numeroEliminarUsuario);
                    break;
                case 12:
                    actualizarDatosUsuario();
                    break;
                case 13:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número válido.");
            }
        }
    }

    private static void menuActividades() {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n***** Menú de Actividades *****");
            System.out.println("1. Crear Clase");
            System.out.println("2. Añadir Persona a Clase");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Clases clase = crearClase();
                    manejoActividades.crearClase(clase);
                    break;

                case 2:
                    añadirPersonaAClase();
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número válido.");
            }
        }
    }

    private static Entrenador crearEntrenador() {
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad del entrenador: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el DNI del entrenador: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el número de empleado del entrenador: ");
        String numeroEmpleado = scanner.nextLine();
        System.out.print("Ingrese la antigüedad del entrenador: ");
        String antiguedad = scanner.nextLine();
        System.out.print("Ingrese la especialidad del entrenador: ");
        String especialidad = scanner.nextLine();
        System.out.print("Ingrese el horario del entrenador: ");
        String horario = scanner.nextLine();

        return new Entrenador(nombre, edad, dni, numeroEmpleado, antiguedad, especialidad, horario);
    }

    private static void actualizarDatosEntrenador() {
        System.out.print("Ingrese el número de empleado del entrenador a actualizar: ");
        String numeroEmpleado = scanner.nextLine();
        scanner.nextLine();

        Entrenador entrenador = manejoPersonas.obtenerEntrenadorPorNumeroEmpleado(numeroEmpleado);

        if (entrenador != null) {
            System.out.println("Datos actuales del entrenador:");
            System.out.println(entrenador.toString());

            System.out.print("Ingrese el nuevo nombre del entrenador: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva edad del entrenador: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ingrese el nuevo DNI del entrenador: ");
            String dni = scanner.nextLine();
            System.out.print("Ingrese la nueva antigüedad del entrenador: ");
            String antiguedad = scanner.nextLine();
            System.out.print("Ingrese la nueva especialidad del entrenador: ");
            String especialidad = scanner.nextLine();
            System.out.print("Ingrese el nuevo horario del entrenador: ");
            String horario = scanner.nextLine();

            entrenador.setNombre(nombre);
            entrenador.setEdad(edad);
            entrenador.setDni(dni);
            entrenador.setAntiguedad(antiguedad);
            entrenador.setEspecialidad(especialidad);
            entrenador.setHorario(horario);

            manejoPersonas.actualizarEntrenador(entrenador);
        } else {
            System.out.println("No se encontró ningún entrenador con el número de empleado ingresado.");
        }
    }

    private static Gerente crearGerente() {
        System.out.print("Ingrese el nombre del gerente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad del gerente: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el DNI del gerente: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el número de empleado del gerente: ");
        String numeroEmpleado = scanner.nextLine();
        System.out.print("Ingrese la antigüedad del gerente: ");
        String antiguedad = scanner.nextLine();
        System.out.print("Ingrese el horario del gerente: ");
        String horario = scanner.nextLine();
        System.out.print("Ingrese el departamento del gerente: ");
        String departamento = scanner.nextLine();

        return new Gerente(nombre, edad, dni, numeroEmpleado, antiguedad, horario, departamento);
    }

    private static void actualizarDatosGerente() {
        System.out.print("Ingrese el número de empleado del gerente a actualizar: ");
        String numeroEmpleado = scanner.nextLine();
        scanner.nextLine();

        Gerente gerente = manejoPersonas.obtenerGerentePorNumeroEmpleado(numeroEmpleado);

        if (gerente != null) {
            System.out.println("Datos actuales del gerente:");
            System.out.println(gerente);

            System.out.print("Ingrese el nuevo nombre del gerente: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva edad del gerente: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ingrese el nuevo DNI del gerente: ");
            String dni = scanner.nextLine();
            System.out.print("Ingrese la nueva antigüedad del gerente: ");
            String antiguedad = scanner.nextLine();
            System.out.print("Ingrese el nuevo horario del gerente: ");
            String horario = scanner.nextLine();
            System.out.print("Ingrese el nuevo departamento del gerente: ");
            String departamento = scanner.nextLine();

            gerente.setNombre(nombre);
            gerente.setEdad(edad);
            gerente.setDni(dni);
            gerente.setAntiguedad(antiguedad);
            gerente.setHorario(horario);
            gerente.setDepartamento(departamento);

            manejoPersonas.actualizarGerente(gerente);
        } else {
            System.out.println("No se encontró ningún gerente con el número de empleado ingresado.");
        }
    }

    public static Recepcionista crearRecepcionista() {
        System.out.print("Ingrese el nombre del recepcionista: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad del recepcionista: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el DNI del recepcionista: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el número de empleado del recepcionista: ");
        String numeroEmpleado = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ingrese la antigüedad del recepcionista: ");
        String antiguedad = scanner.nextLine();
        System.out.print("Ingrese el horario del recepcionista: ");
        String horario = scanner.nextLine();
        System.out.print("Ingrese los idiomas que habla el recepcionista en una sola linea, separados por ',' : ");
        String idiomas = scanner.nextLine();
        return new Recepcionista(nombre, edad, dni, numeroEmpleado, antiguedad, horario, idiomas);
    }

    private static void actualizarDatosRecepcionista() {
        System.out.print("Ingrese el número de empleado del recepcionista a actualizar: ");
        String numeroEmpleado = scanner.nextLine();
        scanner.nextLine();

        Recepcionista recepcionista = manejoPersonas.obtenerRecepcionistaPorNumeroEmpleado(numeroEmpleado);

        if (recepcionista != null) {
            System.out.println("Datos actuales del recepcionista:");
            System.out.println(recepcionista);

            System.out.print("Ingrese el nuevo nombre del recepcionista: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva edad del recepcionista: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ingrese el nuevo DNI del recepcionista: ");
            String dni = scanner.nextLine();
            System.out.print("Ingrese la nueva antigüedad del recepcionista: ");
            String antiguedad = scanner.nextLine();
            System.out.print("Ingrese el nuevo horario del recepcionista: ");
            String horario = scanner.nextLine();
            System.out.print("Ingrese los idiomas que habla el recepcionista en una sola linea, separados por ','  : ");
            String idiomas = scanner.nextLine();

            recepcionista.setNombre(nombre);
            recepcionista.setEdad(edad);
            recepcionista.setDni(dni);
            recepcionista.setAntiguedad(antiguedad);
            recepcionista.setHorario(horario);
            recepcionista.setIdiomas(idiomas);

            manejoPersonas.actualizarRecepcionista(recepcionista);
        } else {
            System.out.println("No se encontró ningún recepcionista con el número de empleado ingresado.");
        }
    }

    private static Usuario crearUsuario() {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad del usuario: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el DNI del usuario: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el peso del usuario: ");
        double peso = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese la altura del usuario: ");
        double altura = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese el plan de entrenamiento del usuario: ");
        String planEntrenamiento = scanner.nextLine();

        return new Usuario(nombre, edad, dni, peso, altura, planEntrenamiento);
    }

    // public Usuario(String nombre, int edad, String dni, double peso, double
    // altura, String planEntrenamiento) {
    public static void actualizarDatosUsuario() {
        System.out.print("Ingrese el DNI del usuario a actualizar: ");
        String dni = scanner.nextLine();
        scanner.nextLine();

        Usuario usuario = manejoPersonas.obtenerUsuarioPorDni(dni);

        if (usuario != null) {
            System.out.println("Datos actuales del usuario:");
            System.out.println(usuario);

            System.out.print("Ingrese el nuevo nombre del usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva edad del usuario: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ingrese el nuevo DNI del usuario: ");
            String nuevoDni = scanner.nextLine();
            System.out.print("Ingrese el nuevo peso del usuario: ");
            double peso = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Ingrese la nueva altura del usuario: ");
            double altura = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Ingrese el nuevo plan de entrenamiento del usuario: ");
            String planEntrenamiento = scanner.nextLine();

            usuario.setNombre(nombre);
            usuario.setEdad(edad);
            usuario.setDni(nuevoDni);
            usuario.setPeso(peso);
            usuario.setAltura(altura);
            usuario.setPlanEntrenamiento(planEntrenamiento);

            manejoPersonas.actualizarUsuario(usuario);
        } else {
            System.out.println("No se encontró ningún usuario con el DNI ingresado.");
        }

    }

    private static Clases crearClase() {
        System.out.println("***** Crear Clase *****");
        System.out.println("Que tipo de clase quiere ingresar? 1. Yoga, 2. BodyPump, 3.Ciclismo");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                return crearClaseYoga();
            case 2:
                return crearClaseBodyPump();
            case 3:
                return crearClaseCiclismo();
            default:
                System.out.println("Opción no válida. Por favor, ingrese un número válido.");
                return null;
        }
    }

    private static Clases crearClaseYoga() {
        System.out.print("Ingrese el nombre de la clase de Yoga: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el horario de la clase de Yoga: ");
        String horarioString = scanner.nextLine();
        Horario horario = Horario.valueOf(horarioString);
        System.out.print("Ingrese el aforo de la clase de Yoga: ");
        String aforo = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ingrese la duración de la clase de Yoga: ");
        String duracion = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ingrese el Numero de empleado del monitor de la clase de Yoga: ");
        Entrenador monitor = manejoPersonas.obtenerEntrenadorPorNumeroEmpleado(scanner.nextLine());
        System.out.print("Ingrese el nivel de la clase de Yoga: ");
        String nivel = scanner.nextLine();
        System.out.print("Ingrese el material de la clase de Yoga: ");
        String material = scanner.nextLine();

        return new Yoga(nombre, horario, aforo, duracion, monitor, nivel, material);
    }

    private static Clases crearClaseBodyPump() {
        System.out.print("Ingrese el nombre de la clase de BodyPump: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el horario de la clase de BodyPump: ");
        Horario horario = Horario.valueOf(scanner.nextLine());
        System.out.print("Ingrese el aforo de la clase de BodyPump: ");
        String aforo = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ingrese la duración de la clase de BodyPump: ");
        String duracion = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ingrese el Numero de empleador del monitor de la clase de BodyPump: ");
        Entrenador monitor = manejoPersonas.obtenerEntrenadorPorNumeroEmpleado(scanner.nextLine());
        System.out.print("Ingrese el nivel de la clase de BodyPump: ");
        String nivel = scanner.nextLine();
        System.out.print("Ingrese la intensidad de la clase de BodyPump: ");
        String intensidad = scanner.nextLine();

        return new Bodypump(nombre, horario, aforo, duracion, monitor, nivel, intensidad);
    }

    private static Clases crearClaseCiclismo() {
        System.out.print("Ingrese el nombre de la clase de Ciclismo: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el horario de la clase de Ciclismo: ");
        Horario horario = Horario.valueOf(scanner.nextLine());
        System.out.print("Ingrese el aforo de la clase de Ciclismo: ");
        String aforo = scanner.nextLine();
        System.out.print("Ingrese la duración de la clase de Ciclismo: ");
        String duracion = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ingrese el monitor de la clase de Ciclismo: ");
        Entrenador monitor = manejoPersonas.obtenerEntrenadorPorNumeroEmpleado(scanner.nextLine());
        System.out.print("Ingrese el tipo de ciclismo de la clase de Ciclismo: ");
        TipoCiclismo tipoCiclismo = TipoCiclismo.valueOf(scanner.nextLine());

        return new Ciclismo(nombre, horario, aforo, duracion, monitor, tipoCiclismo);
    }

    private static void añadirPersonaAClase() {
        System.out.println("***** Añadir Persona a Clase *****");
        
        // Obtener la lista de clases disponibles
        ArrayList<Clases> listaClases = manejoActividades.getListaClases();
        
        // Verificar si hay clases disponibles
        if (listaClases.isEmpty()) {
            System.out.println("No hay clases disponibles para añadir personas.");
            return;
        }
        
        // Mostrar las clases disponibles para elegir
        System.out.println("Clases Disponibles:");
        for (int i = 0; i < listaClases.size(); i++) {
            Clases clase = listaClases.get(i);
            String estadoAforo = manejoActividades.comprobarAforo(clase) ? " (Aforo Disponible)" : " (Aforo Completo)";
            System.out.println((i + 1) + ". " + clase.getNombre() + estadoAforo);
        }

        System.out.print("Ingrese el número de la clase a la que desea añadir una persona: ");
        int numeroClase = scanner.nextInt();
        scanner.nextLine();

        // Verificar si el número de clase es válido
        if (numeroClase < 1 || numeroClase > listaClases.size()) {
            System.out.println("Número de clase no válido. Por favor, ingrese un número válido.");
            return;
        }

        Clases clase = listaClases.get(numeroClase - 1);

        // Verificar si el aforo de la clase está completo

        if (manejoActividades.comprobarAforo(clase)) {
            System.out.println("Dni del Usuario a añadir: ");
            String dni = scanner.nextLine();
            Usuario usuario = manejoPersonas.obtenerUsuarioPorDni(dni);
            clase.añadirUsuario(usuario);
            manejoActividades.añadirPersonaAClase(clase, usuario);
        } else {
            System.out.println("El aforo de la clase está completo. No se puede añadir más personas.");
        }       
    }
    
}



