package Util;

public class Constantes {
    public static final String URL = "jdbc:mariadb://localhost:3306/proyectojava";
    public static final String USUARIO = "root";
    public static final String CONTRASENA = "123456789";

    // Constantes para la tabla Usuarios
    public static final String SELECT_DATOS_USUARIOS = "SELECT nombre, edad, dni, peso, altura, planEntrenamiento " +
            "FROM Usuarios WHERE id = ?";
    public static final String INSERT_DATOS_USUARIOS = "INSERT INTO Usuarios (nombre, edad, dni, peso, altura, planEntrenamiento) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_DATOS_USUARIOS = "UPDATE Usuarios SET nombre = ?, edad = ?, dni = ?, peso = ?, altura = ?, planEntrenamiento = ? WHERE dni = ?";
    public static final String DELETE_DATOS_USUARIOS = "DELETE FROM Usuarios WHERE dni = ?";

    // Constantes para la tabla Entrenadores
    public static final String SELECT_DATOS_ENTRENADORES = "SELECT nombre, edad, dni, numeroEmpleado, antiguedad, horario, especialidad " +
            "FROM Entrenadores WHERE numeroEmpleado = ?";
    public static final String INSERT_DATOS_ENTRENADORES = "INSERT INTO Entrenadores (nombre, edad, dni, numeroEmpleado, antiguedad, horario, especialidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_DATOS_ENTRENADORES = "UPDATE Entrenadores SET nombre = ?, edad = ?, dni = ?, numeroEmpleado = ?, antiguedad = ?, horario = ?, especialidad = ? WHERE numeroEmpleado = ?";
    public static final String DELETE_DATOS_ENTRENADORES = "DELETE FROM Entrenadores WHERE numeroEmpleado = ?";

    // Constantes para la tabla Gerentes
    public static final String SELECT_DATOS_GERENTES = "SELECT nombre, edad, dni, numeroEmpleado, antiguedad, horario, departamento " +
            "FROM Gerentes WHERE numeroEmpleado = ?";
    public static final String INSERT_DATOS_GERENTES = "INSERT INTO Gerentes (nombre, edad, dni, numeroEmpleado, antiguedad, horario, departamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_DATOS_GERENTES = "UPDATE Gerentes SET nombre = ?, edad = ?, dni = ?, numeroEmpleado = ?, antiguedad = ?, horario = ?, departamento = ? WHERE numeroEmpleado = ?";
    public static final String DELETE_DATOS_GERENTES = "DELETE FROM Gerentes WHERE numeroEmpleado = ?";

    // Constantes para la tabla Recepcionistas
    public static final String SELECT_DATOS_RECEPCIONISTAS = "SELECT nombre, edad, dni, numeroEmpleado, antiguedad, horario, idiomas " +
            "FROM Recepcionistas WHERE numeroEmpleado = ?";
    public static final String INSERT_DATOS_RECEPCIONISTAS = "INSERT INTO Recepcionistas (nombre, edad, dni, numeroEmpleado, antiguedad, horario, idiomas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_DATOS_RECEPCIONISTAS = "UPDATE Recepcionistas SET nombre = ?, edad = ?, dni = ?, numeroEmpleado = ?, antiguedad = ?, horario = ?, idiomas = ? WHERE numeroEmpleado = ?";
    public static final String DELETE_DATOS_RECEPCIONISTAS = "DELETE FROM Recepcionistas WHERE numeroEmpleado = ?";

    // Constantes para la tabla Clases
    public static final String SELECT_DATOS_CLASES = "SELECT * FROM Clases";

    public static final String INSERT_DATOS_BODYPUMP = "INSERT INTO Bodypump (nombre, horario, aforo, duracion, monitor_id, nivel, intensidad) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String INSERT_DATOS_CICLISMO = "INSERT INTO Ciclismo (nombre, horario, aforo, duracion, monitor_id, tipoCiclismo) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String INSERT_DATOS_YOGA = "INSERT INTO Yoga (nombre, horario, aforo, duracion, monitor_id, nivel, material) VALUES (?, ?, ?, ?, ?, ?, ?)";

    // Consultas especificas para la tabla Clases
    public static final String SELECT_CLASE_POR_NOMBRE_Y_HORARIO = "SELECT * FROM Clases WHERE nombre = ? AND horario = ?";

    // Constantes Tabla intermedia ClasesUsuarios
    public static final String INSERT_USUARIO_CLASE = "INSERT INTO Usuario_Clase (dniUsuario, nombreClase) VALUES (?, ?)";
    public static final String DELETE_USUARIO_CLASE = "DELETE FROM Usuario_Clase WHERE dniUsuario = ? AND nombreClase = ?";
}
