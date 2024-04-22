package DataBase;

import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;
import static Util.Constantes.*;

public class conexiondb {

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

    public static void registarUrusarios(String nombre,int edad,int id,double peso,int altura,String planEntrenamiento){
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

}
