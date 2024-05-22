package Actividades;

import Actividades.Enums.Horario;
import Personas.Empleado;

public abstract class Clases {
    
    private String nombre;
    protected Horario horario;
    private String aforo;
    private String duracion;
    private Empleado monitor;    

    public Clases(String nombre, Horario horario, String aforo, String duracion, Empleado monitor) {
        this.nombre = nombre;
        this.horario = horario;
        this.aforo = aforo;
        this.duracion = duracion;
        this.monitor = monitor;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Horario getHorario() {
        return horario;
    }
    
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    public String getAforo() {
        return aforo;
    }
    
    public void setAforo(String aforo) {
        this.aforo = aforo;
    }
    
    public String getDuracion() {
        return duracion;
    }
    
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    
    public Empleado getMonitor() {
        return monitor;
    }
    
    public void setMonitor(Empleado monitor) {
        this.monitor = monitor;
    }
    
    @Override
    public String toString() {
        return "Clase: " + nombre + "Horario: " + horario + "Aforo: " + aforo + "Duración: " + duracion + "Monitor: " + monitor;
    }
}
