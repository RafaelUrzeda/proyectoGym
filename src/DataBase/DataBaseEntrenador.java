package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Personas.TiposPersonas.Entrenador;
import Util.Constantes;

public class DataBaseEntrenador {

    public Entrenador obtenerEntrenadorPorNumeroEmpleado(String numeroEmpleado) {
        Entrenador entrenador = null;

        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.SELECT_DATOS_ENTRENADORES)) {

            preparedStatement.setString(1, numeroEmpleado);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    int edad = resultSet.getInt("edad");
                    String dni = resultSet.getString("dni");
                    String antiguedad = resultSet.getString("antiguedad");
                    String horario = resultSet.getString("horario");
                    String especialidad = resultSet.getString("especialidad");

                    entrenador = new Entrenador(nombre, edad, dni, numeroEmpleado, antiguedad, especialidad, horario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entrenador;
    }

    public boolean insertarEntrenador(Entrenador entrenador) {
        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.INSERT_DATOS_ENTRENADORES)) {

            preparedStatement.setString(1, entrenador.getNombre());
            preparedStatement.setInt(2, entrenador.getEdad());
            preparedStatement.setString(3, entrenador.getDni());
            preparedStatement.setString(4, entrenador.getNumeroEmpleado());
            preparedStatement.setString(5, entrenador.getAntiguedad());
            preparedStatement.setString(6, entrenador.getHorario());
            preparedStatement.setString(7, entrenador.getEspecialidad());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarEntrenador(Entrenador entrenador) {
        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.UPDATE_DATOS_ENTRENADORES)) {

            preparedStatement.setString(1, entrenador.getNombre());
            preparedStatement.setInt(2, entrenador.getEdad());
            preparedStatement.setString(3, entrenador.getDni());
            preparedStatement.setString(4, entrenador.getNumeroEmpleado());
            preparedStatement.setString(5, entrenador.getAntiguedad());
            preparedStatement.setString(6, entrenador.getHorario());
            preparedStatement.setString(7, entrenador.getEspecialidad());
            preparedStatement.setString(8, entrenador.getNumeroEmpleado());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarEntrenador(String id) {
        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.DELETE_DATOS_ENTRENADORES)) {

            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
