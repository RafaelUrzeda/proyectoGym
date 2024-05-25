package Util;

public class Constantes {
    public static final String URL = "jdbc:mariadb://localhost:3306/proyectojava1";
    public static final String USUARIO = "root";
    public static final String CONTRASENA = "123456789";

    // Entrenadores
    public static final String SELECT_DATOS_ENTRENADORES = "SELECT * FROM Entrenadores WHERE numeroEmpleado = ?";
    public static final String INSERT_DATOS_ENTRENADORES = "INSERT INTO Entrenadores (nombre, edad, dni, numeroEmpleado, antiguedad, horario, especialidad) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_DATOS_ENTRENADORES = "UPDATE Entrenadores SET nombre = ?, edad = ?, dni = ?, numeroEmpleado = ?, antiguedad = ?, horario = ?, especialidad = ? WHERE numeroEmpleado = ?";
    public static final String DELETE_DATOS_ENTRENADORES = "DELETE FROM Entrenadores WHERE numeroEmpleado = ?";

    // Gerentes
    public static final String SELECT_DATOS_GERENTES = "SELECT * FROM Gerentes WHERE numeroEmpleado = ?";
    public static final String INSERT_DATOS_GERENTES = "INSERT INTO Gerentes (nombre, edad, dni, numeroEmpleado, antiguedad, horario, departamento) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_DATOS_GERENTES = "UPDATE Gerentes SET nombre = ?, edad = ?, dni = ?, numeroEmpleado = ?, antiguedad = ?, horario = ?, departamento = ? WHERE numeroEmpleado = ?";
    public static final String DELETE_DATOS_GERENTES = "DELETE FROM Gerentes WHERE numeroEmpleado = ?";

    // Recepcionistas
    public static final String SELECT_DATOS_RECEPCIONISTAS = "SELECT * FROM Recepcionistas WHERE numeroEmpleado = ?";
    public static final String INSERT_DATOS_RECEPCIONISTAS = "INSERT INTO Recepcionistas (nombre, edad, dni, numeroEmpleado, antiguedad, horario, idiomas) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_DATOS_RECEPCIONISTAS = "UPDATE Recepcionistas SET nombre = ?, edad = ?, dni = ?, numeroEmpleado = ?, antiguedad = ?, horario = ?, idiomas = ? WHERE numeroEmpleado = ?";
    public static final String DELETE_DATOS_RECEPCIONISTAS = "DELETE FROM Recepcionistas WHERE numeroEmpleado = ?";

    // Clases
    public static final String SELECT_CLASE_POR_NOMBRE_Y_HORARIO = "SELECT * FROM Clases WHERE nombre = ? AND horario = ?";
    public static final String INSERT_DATOS_BODYPUMP = "INSERT INTO Clases (tipo, nombre, horario, aforo, duracion, numeroEmpleado, nivel, intensidad) VALUES ('Bodypump', ?, ?, ?, ?, ?, ?, ?)";
    public static final String INSERT_DATOS_CICLISMO = "INSERT INTO Clases (tipo, nombre, horario, aforo, duracion, numeroEmpleado, tipoCiclismo) VALUES ('Ciclismo', ?, ?, ?, ?, ?, ?)";
    public static final String INSERT_DATOS_YOGA = "INSERT INTO Clases (tipo, nombre, horario, aforo, duracion, numeroEmpleado, nivel, material) VALUES ('Yoga', ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_DATOS_CLASES = "SELECT * FROM Clases";

    // Usuarios
    public static final String SELECT_DATOS_USUARIOS = "SELECT * FROM Usuarios WHERE dni = ?";
    public static final String INSERT_DATOS_USUARIOS = "INSERT INTO Usuarios (nombre, edad, dni, peso, altura, planEntrenamiento) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_DATOS_USUARIOS = "UPDATE Usuarios SET nombre = ?, edad = ?, dni = ?, peso = ?, altura = ?, planEntrenamiento = ? WHERE dni = ?";
    public static final String DELETE_DATOS_USUARIOS = "DELETE FROM Usuarios WHERE dni = ?";

    // UsuarioClase
    public static final String INSERT_USUARIO_CLASE = "INSERT INTO UsuarioClase (usuario_dni, clase_nombre) VALUES (?, ?)";
}
