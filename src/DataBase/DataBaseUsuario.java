package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Personas.Usuario;
import Util.Constantes;

public class DataBaseUsuario {

    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = null;

        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.SELECT_DATOS_USUARIOS)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    int edad = resultSet.getInt("edad");
                    String dni = resultSet.getString("dni");
                    double peso = resultSet.getDouble("peso");
                    double altura = resultSet.getDouble("altura");
                    String planEntrenamiento = resultSet.getString("planEntrenamiento");

                    usuario = new Usuario(nombre, edad, dni, peso, altura, planEntrenamiento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public boolean insertarUsuario(Usuario usuario) {
        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.INSERT_DATOS_USUARIOS)) {

            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setInt(2, usuario.getEdad());
            preparedStatement.setString(3, usuario.getDni());
            preparedStatement.setDouble(4, usuario.getPeso());
            preparedStatement.setDouble(5, usuario.getAltura());
            preparedStatement.setString(6, usuario.getPlanEntrenamiento());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarUsuario(Usuario usuario) {
        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.UPDATE_DATOS_USUARIOS)) {

            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setInt(2, usuario.getEdad());
            preparedStatement.setString(3, usuario.getDni());
            preparedStatement.setDouble(4, usuario.getPeso());
            preparedStatement.setDouble(5, usuario.getAltura());
            preparedStatement.setString(6, usuario.getPlanEntrenamiento());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarUsuario(int id) {
        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.DELETE_DATOS_USUARIOS)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
