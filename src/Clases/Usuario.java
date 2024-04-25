package Clases;

import Clases.Persona;
import Interfaces.Actualizable;
import Interfaces.Registrable;
import java.sql.*;
import java.util.Scanner;

public class Usuario extends Persona implements Registrable, Actualizable {
    private double peso;
    private double altura;
    private String planEntrenamiento;
    private boolean registrado = false; // Atributo para gestionar el estado de registro

    public Usuario(String nombre, int edad, int id, double peso, double altura, String planEntrenamiento) {
        super(nombre, edad, id);
        this.peso = peso;
        this.altura = altura;
        this.planEntrenamiento = planEntrenamiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getPlanEntrenamiento() {
        return planEntrenamiento;
    }

    public void setPlanEntrenamiento(String planEntrenamiento) {
        this.planEntrenamiento = planEntrenamiento;
    }

    public void mostrarDetalles() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("ID: " + getId());
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Altura: " + altura + " cm");
        System.out.println("Plan de Entrenamiento: " + planEntrenamiento);
    }

    public void registrar() {
        registrado = true;
        System.out.println("Clases.Usuario registrado con éxito: " + getNombre());
    }

    public boolean estaRegistrado() {
        return registrado;
    }

    public void actualizarDatos() {
        System.out.println("Datos del usuario con ID: " + getId() + " han sido actualizados.");
    }
}
