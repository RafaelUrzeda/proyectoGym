package Actividades;

import java.util.ArrayList;

import Actividades.Enums.Horario;
import Actividades.TiposClases.ClasesAbstractas.Clases;
import DataBase.DataBaseClases;
import Personas.Usuario;

public class ManejoActividades {
    private ArrayList<Clases> listaClases;
    DataBaseClases dataBaseClases = new DataBaseClases();


    public ManejoActividades() {
        listaClases = new ArrayList<>();

    }

    public ArrayList<Clases> getListaClases() {
        return listaClases;
    }

    // Convertir Horario enum a franjas horarias
    public String convertirHorario(Horario horario) {
        switch (horario) {
            case PimeraHora:
                return "08:00 - 10:00";
            case SegundaHora:
                return "10:00 - 12:00";
            case TerceraHora:
                return "12:00 - 14:00";
            case CuartaHora:
                return "14:00 - 16:00";
            default:
                return "Horario no definido";
        }
    }

    // Crear nuevas clases, si devuelve true es que se ha creado correctamente
    public boolean crearClase(Clases clase) {
        if (dataBaseClases.existeClase(clase.getNombre(), clase.getHorario())) {
            return false; 
        } else {
            listaClases.add(clase);
            dataBaseClases.guardarClaseEnBaseDeDatos(clase);
            return true; 
        }
    }

    // Añadir una persona a una clase, verificando el aforo
    public boolean añadirPersonaAClase(Clases clase, Usuario usuario) {
        if (clase.añadirUsuario(usuario)) {
            return dataBaseClases.añadirUsuarioAClaseEnBaseDeDatos(usuario, clase);
        }
        return false;
    }

    // Comprobar aforo de la clase
    public boolean comprobarAforo(Clases clase) {
        return clase.getListaUsuarios().size() < Integer.parseInt(clase.getAforo());
    }

    // Cargar clases desde la base de datos
    public void cargarClasesDesdeBaseDatos() {
        listaClases = dataBaseClases.cargarClasesDesdeBaseDatos();
    }
}
