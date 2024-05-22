package Actividades.TiposClases.ClasesAbstractas;

import java.util.ArrayList;

import Actividades.Enums.Horario;
import Personas.ClasesAbstractas.Empleado;
import Personas.TiposPersonas.Usuario;

public abstract class Clases {
    
    private String nombre;
    protected Horario horario;
    private String aforo;
    private String duracion;
    private Empleado monitor;  
    private ArrayList<Usuario> listaUsuarios;  

    public Clases(String nombre, Horario horario, String aforo, String duracion, Empleado monitor) {
        this.nombre = nombre;
        this.horario = horario;
        this.aforo = aforo;
        this.duracion = duracion;
        this.monitor = monitor;
        this.listaUsuarios = new ArrayList<>();
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
    
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public boolean añadirUsuario(Usuario usuario) {
        int aforoMaximo = Integer.parseInt(this.aforo);
        if (this.listaUsuarios.size() < aforoMaximo) {
            this.listaUsuarios.add(usuario);
            return true;
        } else {
            System.out.println("Aforo máximo alcanzado para la clase: " + this.nombre);
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Clase: " + nombre + " Horario: " + horario + " Aforo: " + aforo + " Duración: " + duracion + " Monitor: " + monitor;
    }
}
