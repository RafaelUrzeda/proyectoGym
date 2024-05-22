package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Personas.TiposPersonas.Gerente;
import Util.Constantes;

public class DataBaseGerente {

    public Gerente obtenerGerentePorNumeroEmpleado(String id) {
        Gerente gerente = null;

        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.SELECT_DATOS_GERENTES)) {

            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    int edad = resultSet.getInt("edad");
                    String dni = resultSet.getString("dni");
                    String numeroEmpleado = resultSet.getString("numeroEmpleado");
                    String antiguedad = resultSet.getString("antiguedad");
                    String horario = resultSet.getString("horario");
                    String departamento = resultSet.getString("departamento");

                    gerente = new Gerente(nombre, edad, dni, numeroEmpleado, antiguedad, horario, departamento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gerente;
    }

    public boolean insertarGerente(Gerente gerente) {
        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.INSERT_DATOS_GERENTES)) {

            preparedStatement.setString(2, gerente.getNombre());
            preparedStatement.setInt(3, gerente.getEdad());
            preparedStatement.setString(4, gerente.getDni());
            preparedStatement.setString(5, gerente.getNumeroEmpleado());
            preparedStatement.setString(6, gerente.getAntiguedad());
            preparedStatement.setString(7, gerente.getHorario());
            preparedStatement.setString(8, gerente.getDepartamento());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarGerente(Gerente gerente) {
        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.UPDATE_DATOS_GERENTES)) {

            preparedStatement.setString(1, gerente.getNombre());
            preparedStatement.setInt(2, gerente.getEdad());
            preparedStatement.setString(3, gerente.getDni());
            preparedStatement.setString(4, gerente.getNumeroEmpleado());
            preparedStatement.setString(5, gerente.getAntiguedad());
            preparedStatement.setString(6, gerente.getHorario());
            preparedStatement.setString(7, gerente.getDepartamento());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarGerente(String id) {
        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(Constantes.DELETE_DATOS_GERENTES)) {

            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
