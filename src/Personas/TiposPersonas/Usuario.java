package Personas.TiposPersonas;

import Personas.ClasesAbstractas.Persona;

public class Usuario extends Persona{
    private double peso;
    private double altura;
    private String planEntrenamiento;

    public Usuario(String nombre, int edad, String dni, double peso, double altura, String planEntrenamiento) {
        super(nombre, edad, dni);
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

    @Override
    public String toString() {
        return "Usuario:" + getNombre() + "peso=" + peso + ", altura=" + altura + ", planEntrenamiento=" + planEntrenamiento;
    }
}
