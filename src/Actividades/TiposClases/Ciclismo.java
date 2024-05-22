package Actividades.TiposClases;

import Actividades.Enums.Horario;
import Actividades.Enums.TipoCiclismo;
import Actividades.TiposClases.ClasesAbstractas.Clases;
import Personas.ClasesAbstractas.Empleado;

public class Ciclismo extends Clases{
    TipoCiclismo tipo;
    
    public Ciclismo(String nombre, Horario horario, String aforo, String duracion, Empleado monitor, TipoCiclismo tipo) {
        super(nombre, horario, aforo, duracion, monitor);
        this.tipo = tipo;
    }

    public TipoCiclismo getTipo() {
        return tipo;
    }

    public void setTipo(TipoCiclismo tipo) {
        this.tipo = tipo;
    }

    @Override

    public String toString() {
        return "Ciclismo{" + "nombre=" + getNombre() + ", horario=" + getHorario() + ", aforo=" + getAforo() + ", duracion=" + getDuracion() + ", monitor=" + getMonitor() + ", tipo=" + tipo + '}';
    }

}
