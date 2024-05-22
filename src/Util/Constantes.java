package Util;

public class Constantes {
    public static final String URL = "jdbc:mariadb://localhost:3306/proyectojava";
    public static final String USUARIO = "root";
    public static final String CONTRASENA = "123456789";

    public static final  String SELECT_DATOS_USUARIOS = "SELECT p.id, p.nombre, p.edad, u.peso, u.altura, u.planEntrenamiento " +
            "FROM Personas p JOIN Usuarios u ON p.id = u.id " +
            "WHERE p.id = ?";

    public static final String INSERT_DATOS_PERSONAS = "INSERT INTO Personas (id, nombre, edad) VALUES (?, ?, ?)";
    public static final String INSERT_DATOS_USUARIOS = "INSERT INTO Usuarios (id, id_persona, peso, altura, planEntrenamiento) VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE_DATOS_PERSONAS = "UPDATE Personas SET nombre = ?, edad = ? WHERE id = ?";
    public static final String UPDATE_DATOS_USUARIOS = "UPDATE Usuarios SET peso = ?, altura = ?, planEntrenamiento = ? WHERE id = ?";
    public static final String DELETE_DATOS_PERSONAS = "DELETE FROM Personas WHERE id = ?";
    public static final String DELETE_DATOS_USUARIOS = "DELETE FROM Usuarios WHERE id = ?";

}
