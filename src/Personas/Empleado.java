package Personas;

public abstract class Empleado extends Persona{
    private String numeroEmpleado;
    private String antiguedad;
    private String horario;

    public Empleado(String nombre, int edad, String dni, String numeroEmpleado, String antiguedad, String horario) {
        super(nombre, edad, dni);
        this.numeroEmpleado = numeroEmpleado;
        this.antiguedad = antiguedad;
        this.horario = horario;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
