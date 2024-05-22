package Personas;

public class Entrenador extends Empleado{
    private String especialidad;

    public Entrenador(String nombre, int edad, String dni, String numeroEmpleado, String antiguedad, String especialidad, String horario) {
        super(nombre, edad, dni, numeroEmpleado, antiguedad, horario);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
}