package Personas.TiposPersonas;

import Personas.ClasesAbstractas.Empleado;

public class Recepcionista extends Empleado{
    private String idiomas;

    public Recepcionista(String nombre, int edad, String dni, String numeroEmpleado, String antiguedad, String horario, String idiomas) {
        super(nombre, edad, dni, numeroEmpleado, antiguedad, horario);
        this.idiomas = idiomas;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    @Override
    public String toString() {
        return "Recepcionista:" + getNombre() + "idiomas=" + idiomas;
    }
}
