package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Personas.Recepcionista;
import Util.Constantes;

public class DataBaseRecepcionista {

    public Recepcionista obtenerRecepcionistaPorId(int id) {
        Recepcionista recepcionista = null;

        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.SELECT_DATOS_RECEPCIONISTAS)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    int edad = resultSet.getInt("edad");
                    String dni = resultSet.getString("dni");
                    String numeroEmpleado = resultSet.getString("numeroEmpleado");
                    String antiguedad = resultSet.getString("antiguedad");
                    String horario = resultSet.getString("horario");
                    String idiomas = resultSet.getString("idiomas");

                    recepcionista = new Recepcionista(nombre, edad, dni, numeroEmpleado, antiguedad, horario, idiomas);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recepcionista;
    }

    public boolean insertarRecepcionista(Recepcionista recepcionista) {
        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.INSERT_DATOS_RECEPCIONISTAS)) {

            preparedStatement.setString(2, recepcionista.getNombre());
            preparedStatement.setInt(3, recepcionista.getEdad());
            preparedStatement.setString(4, recepcionista.getDni());
            preparedStatement.setString(5, recepcionista.getNumeroEmpleado());
            preparedStatement.setString(6, recepcionista.getAntiguedad());
            preparedStatement.setString(7, recepcionista.getHorario());
            preparedStatement.setString(8, recepcionista.getIdiomas());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarRecepcionista(Recepcionista recepcionista) {
        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.UPDATE_DATOS_RECEPCIONISTAS)) {

            preparedStatement.setString(1, recepcionista.getNombre());
            preparedStatement.setInt(2, recepcionista.getEdad());
            preparedStatement.setString(3, recepcionista.getDni());
            preparedStatement.setString(4, recepcionista.getNumeroEmpleado());
            preparedStatement.setString(5, recepcionista.getAntiguedad());
            preparedStatement.setString(6, recepcionista.getHorario());
            preparedStatement.setString(7, recepcionista.getIdiomas());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarRecepcionista(int id) {
        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.DELETE_DATOS_RECEPCIONISTAS)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
