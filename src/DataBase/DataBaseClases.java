package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Actividades.Enums.Horario;
import Actividades.Enums.TipoCiclismo;
import Actividades.TiposClases.Bodypump;
import Actividades.TiposClases.Ciclismo;
import Actividades.TiposClases.Yoga;
import Actividades.TiposClases.ClasesAbstractas.Clases;
import Personas.ClasesAbstractas.Empleado;
import Personas.TiposPersonas.Entrenador;
import Personas.TiposPersonas.Gerente;
import Personas.TiposPersonas.Recepcionista;
import Personas.TiposPersonas.Usuario;
import Util.Constantes;

public class DataBaseClases {

    // Verificar si hay clases en una franja horaria específica
    public   boolean existeClase(String nombre, Horario horario) {
        String selectClaseSQL = Constantes.SELECT_CLASE_POR_NOMBRE_Y_HORARIO;

        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(selectClaseSQL)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, horario.name());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Guardar la clase en la base de datos
    public  void guardarClaseEnBaseDeDatos(Clases clase) {
        String insertClaseSQL = "";

        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(insertClaseSQL)) {

            if (clase instanceof Bodypump) {
                insertClaseSQL = Constantes.INSERT_DATOS_BODYPUMP;
                Bodypump bodypump = (Bodypump) clase;
                preparedStatement.setString(1, bodypump.getNombre());
                preparedStatement.setString(2, bodypump.getHorario().name());
                preparedStatement.setString(3, bodypump.getAforo());
                preparedStatement.setString(4, bodypump.getDuracion());
                preparedStatement.setString(5, ((Empleado) bodypump.getMonitor()).getNumeroEmpleado());
                preparedStatement.setString(6, bodypump.getNivel());
                preparedStatement.setString(7, bodypump.getIntensidad());

            } else if (clase instanceof Ciclismo) {
                insertClaseSQL = Constantes.INSERT_DATOS_CICLISMO;
                Ciclismo ciclismo = (Ciclismo) clase;
                preparedStatement.setString(1, ciclismo.getNombre());
                preparedStatement.setString(2, ciclismo.getHorario().name());
                preparedStatement.setString(3, ciclismo.getAforo());
                preparedStatement.setString(4, ciclismo.getDuracion());
                preparedStatement.setString(5, ((Empleado) ciclismo.getMonitor()).getNumeroEmpleado());
                preparedStatement.setString(6, ciclismo.getTipo().name());

            } else if (clase instanceof Yoga) {
                insertClaseSQL = Constantes.INSERT_DATOS_YOGA;
                Yoga yoga = (Yoga) clase;
                preparedStatement.setString(1, yoga.getNombre());
                preparedStatement.setString(2, yoga.getHorario().name());
                preparedStatement.setString(3, yoga.getAforo());
                preparedStatement.setString(4, yoga.getDuracion());
                preparedStatement.setString(5, ((Empleado) yoga.getMonitor()).getNumeroEmpleado());
                preparedStatement.setString(6, yoga.getNivel());
                preparedStatement.setString(7, yoga.getMaterial());
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cargar clases desde la base de datos
    public  ArrayList<Clases> cargarClasesDesdeBaseDatos() {
        ArrayList<Clases> listaClases = new ArrayList<>();

        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(Constantes.SELECT_DATOS_CLASES)) {

            while (resultSet.next()) {
                String tipo = resultSet.getString("tipo");
                String nombre = resultSet.getString("nombre");
                Horario horario = Horario.valueOf(resultSet.getString("horario"));
                String aforo = resultSet.getString("aforo");
                String duracion = resultSet.getString("duracion");
                Empleado monitor = obtenerEmpleadoPorNumeroDeEmpleado(resultSet.getInt("monitor_id"));

                switch (tipo) {
                    case "Bodypump":
                        String nivel = resultSet.getString("nivel");
                        String intensidad = resultSet.getString("intensidad");
                        listaClases.add(new Bodypump(nombre, horario, aforo, duracion, monitor, nivel, intensidad));
                        break;
                    case "Ciclismo":
                        TipoCiclismo tipoCiclismo = TipoCiclismo.valueOf(resultSet.getString("tipoCiclismo"));
                        listaClases.add(new Ciclismo(nombre, horario, aforo, duracion, monitor, tipoCiclismo));
                        break;
                    case "Yoga":
                        nivel = resultSet.getString("nivel");
                        String material = resultSet.getString("material");
                        listaClases.add(new Yoga(nombre, horario, aforo, duracion, monitor, nivel, material));
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaClases;
    }

    // Obtener empleado por número de empleado
    public  Empleado obtenerEmpleadoPorNumeroDeEmpleado(int numeroEmpleado) {
        Empleado empleado = null;
        String selectEmpleadoSQL = Constantes.SELECT_DATOS_ENTRENADORES;

        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(selectEmpleadoSQL)) {

            preparedStatement.setInt(1, numeroEmpleado);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    int edad = resultSet.getInt("edad");
                    String dni = resultSet.getString("dni");
                    String numeroEmpleadoStr = resultSet.getString("numeroEmpleado");
                    String antiguedad = resultSet.getString("antiguedad");
                    String horario = resultSet.getString("horario");
                    String especialidad = resultSet.getString("especialidad");
                    String departamento = resultSet.getString("departamento");
                    String idiomas = resultSet.getString("idiomas");

                    if (especialidad != null) {
                        empleado = new Entrenador(nombre, edad, dni, numeroEmpleadoStr, antiguedad, especialidad, horario);
                    } else if (departamento != null) {
                        empleado = new Gerente(nombre, edad, dni, numeroEmpleadoStr, antiguedad, horario, departamento);
                    } else if (idiomas != null) {
                        empleado = new Recepcionista(nombre, edad, dni, numeroEmpleadoStr, antiguedad, horario, idiomas);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleado;
    }

    public  boolean añadirUsuarioAClaseEnBaseDeDatos(Usuario Usuario, Clases Clase) {
        String insertUsuarioClaseSQL = Constantes.INSERT_USUARIO_CLASE;

        String dni = Usuario.getDni();
        String nombre = Clase.getNombre();

        try (Connection conexion = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.CONTRASENA);
             PreparedStatement preparedStatement = conexion.prepareStatement(insertUsuarioClaseSQL)) {

            preparedStatement.setString(1, dni);
            preparedStatement.setString(2, nombre);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }
}
