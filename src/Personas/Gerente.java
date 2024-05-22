package Personas;

public class Gerente extends Empleado{

    private String departamento;

    public Gerente(String nombre, int edad, String dni, String numeroEmpleado, String antiguedad, String horario, String departamento) {
        super(nombre, edad, dni, numeroEmpleado, antiguedad, horario);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    @Override
    public String toString() {
        return "Gerente:" + getNombre() + "departamento=" + departamento;
    }
}
