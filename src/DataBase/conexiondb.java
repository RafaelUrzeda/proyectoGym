package DataBase;

import Interfaces.*;
import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;
import static Util.Constantes.*;

public class conexiondb implements Actualizable, Registrable{

    public static void main(String[] args) {
        comprobarConexion();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del usuario: ");
        int id = Integer.parseInt(scanner.nextLine());
        mostrarDatosUsuario(id);
        scanner.close();
    }

    public static void comprobarConexion() {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }


    public static void mostrarDatosUsuario(int id) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement pstmt = conn.prepareStatement(SELECT_DATOS_USUARIOS)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    int edad = rs.getInt("edad");
                    double peso = rs.getDouble("peso");
                    double altura = rs.getDouble("altura");
                    String planEntrenamiento = rs.getString("planEntrenamiento");

                    System.out.println("ID: " + id);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Edad: " + edad);
                    System.out.println("Peso: " + peso + " kg");
                    System.out.println("Altura: " + altura + " cm");
                    System.out.println("Plan de Entrenamiento: " + planEntrenamiento);
                } else {
                    System.out.println("No se encontró un usuario con el ID: " + id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public static void registarUrusarios(String nombre,int edad,int id,double peso,double altura,String planEntrenamiento){
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement pstmt = conn.prepareStatement(INSERT_DATOS_PERSONAS)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, edad);
            pstmt.executeUpdate();
            System.out.println("Datos de la persona registrados con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al registrar los datos de la persona: " + e.getMessage());
        }
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement pstmt = conn.prepareStatement(INSERT_DATOS_USUARIOS)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, id);
            pstmt.setDouble(3, peso);
            pstmt.setDouble(4, altura);
            pstmt.setString(5, planEntrenamiento);
            pstmt.executeUpdate();
            System.out.println("Datos del usuario registrados con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al registrar los datos del usuario: " + e.getMessage());
        }
    }

    public static boolean comporbarRegistro(int id){
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement pstmt = conn.prepareStatement(SELECT_DATOS_USUARIOS)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("El usuario con ID: " + id + " está registrado.");
                    return true;
                } else {
                    System.out.println("El usuario con ID: " + id + " no está registrado.");
                    return false;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            return false;
        }
    }

    public static void actualizarDatos(int id, String nombre, int edad, double peso, double altura, String planEntrenamiento) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_DATOS_PERSONAS)) {
            pstmt.setString(1, nombre);
            pstmt.setInt(2, edad);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Datos de la persona actualizados con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar los datos de la persona: " + e.getMessage());
        }
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_DATOS_USUARIOS)) {
            pstmt.setDouble(1, peso);
            pstmt.setDouble(2, altura);
            pstmt.setString(3, planEntrenamiento);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            System.out.println("Datos del usuario actualizados con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar los datos del usuario: " + e.getMessage());
        }
    }

    public static void eliminarDatos(int id){
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement pstmt = conn.prepareStatement(DELETE_DATOS_PERSONAS)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Datos de la persona eliminados con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar los datos de la persona: " + e.getMessage());
        }
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement pstmt = conn.prepareStatement(DELETE_DATOS_USUARIOS)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Datos del usuario eliminados con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar los datos del usuario: " + e.getMessage());
        }
    }

}
