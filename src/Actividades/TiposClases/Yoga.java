package Actividades.TiposClases;

import Actividades.Enums.Horario;
import Actividades.TiposClases.ClasesAbstractas.Clases;
import Personas.ClasesAbstractas.Empleado;

public class Yoga extends Clases{
    
    private String nivel;
    private String material;
    
    public Yoga(String nombre, Horario horario, String aforo, String duracion, Empleado monitor, String nivel, String material) {
        super(nombre, horario, aforo, duracion, monitor);
        this.nivel = nivel;
        this.material = material;
    }
    
    public String getNivel() {
        return nivel;
    }
    
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    @Override
    public String toString() {
        return "Yoga{" + "nombre=" + getNombre() + ", horario=" + getHorario() + ", aforo=" + getAforo() + ", duracion=" + getDuracion() + ", monitor=" + getMonitor() + ", nivel=" + nivel + ", material=" + material + '}';
    }
}
