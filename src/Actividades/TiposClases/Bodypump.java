package Actividades.TiposClases;

import Actividades.Enums.Horario;
import Actividades.TiposClases.ClasesAbstractas.Clases;
import Personas.ClasesAbstractas.Empleado;

public class Bodypump extends Clases{

    private String nivel;
    private String intensidad;

    public Bodypump(String nombre, Horario horario, String aforo, String duracion, Empleado monitor, String nivel, String intensidad) {
        super(nombre, horario, aforo, duracion, monitor);
        this.nivel = nivel;
        this.intensidad = intensidad;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

    @Override
    public String toString() {
        return "Bodypump{" + "nombre=" + getNombre() + ", horario=" + getHorario() + ", aforo=" + getAforo() + ", duracion=" + getDuracion() + ", monitor=" + getMonitor() + ", nivel=" + nivel + ", intensidad=" + intensidad + '}';
    }
    
}
