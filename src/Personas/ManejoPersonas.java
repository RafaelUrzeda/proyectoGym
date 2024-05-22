package Personas;

import DataBase.DataBaseEntrenador;
import DataBase.DataBaseGerente;
import DataBase.DataBaseRecepcionista;
import DataBase.DataBaseUsuario;
import Personas.TiposPersonas.Entrenador;
import Personas.TiposPersonas.Gerente;
import Personas.TiposPersonas.Recepcionista;
import Personas.TiposPersonas.Usuario;

public class ManejoPersonas {

    private DataBaseEntrenador dbEntrenador;
    private DataBaseGerente dbGerente;
    private DataBaseRecepcionista dbRecepcionista;
    private DataBaseUsuario dbUsuario;

    public ManejoPersonas() {
        dbEntrenador = new DataBaseEntrenador();
        dbGerente = new DataBaseGerente();
        dbRecepcionista = new DataBaseRecepcionista();
        dbUsuario = new DataBaseUsuario();
    }

    // Métodos para manejar Entrenadores
    public boolean registrarEntrenador(Entrenador entrenador) {
        return dbEntrenador.insertarEntrenador(entrenador);
    }

    public boolean eliminarEntrenador(String id) {
        return dbEntrenador.eliminarEntrenador(id);
    }

    public boolean actualizarEntrenador(Entrenador entrenador) {
        return dbEntrenador.actualizarEntrenador(entrenador);
    }

    public Entrenador obtenerEntrenadorPorNumeroEmpleado(String numeroEmpleado) {
        return dbEntrenador.obtenerEntrenadorPorNumeroEmpleado(numeroEmpleado);
    }

    // Métodos para manejar Gerentes
    public boolean registrarGerente(Gerente gerente) {
        return dbGerente.insertarGerente(gerente);
    }

    public boolean eliminarGerente(String id) {
        return dbGerente.eliminarGerente(id);
    }

    public boolean actualizarGerente(Gerente gerente) {
        return dbGerente.actualizarGerente(gerente);
    }

    public Gerente obtenerGerentePorNumeroEmpleado(String numeroEmpleado) {
        return dbGerente.obtenerGerentePorNumeroEmpleado(numeroEmpleado);
    }

    // Métodos para manejar Recepcionistas
    public boolean registrarRecepcionista(Recepcionista recepcionista) {
        return dbRecepcionista.insertarRecepcionista(recepcionista);
    }

    public boolean eliminarRecepcionista(String id) {
        return dbRecepcionista.eliminarRecepcionista(id);
    }

    public boolean actualizarRecepcionista(Recepcionista recepcionista) {
        return dbRecepcionista.actualizarRecepcionista(recepcionista);
    }

    public Recepcionista obtenerRecepcionistaPorNumeroEmpleado(String numeroEmpleado) {
        return dbRecepcionista.obtenerRecepcionistaPorNumeroEmpleado(numeroEmpleado);
    }
    
    // Métodos para manejar Usuarios
    public boolean registrarUsuario(Usuario usuario) {
        return dbUsuario.insertarUsuario(usuario);
    }

    public boolean eliminarUsuario(String id) {
        return dbUsuario.eliminarUsuario(id);
    }

    public boolean actualizarUsuario(Usuario usuario) {
        return dbUsuario.actualizarUsuario(usuario);
    }

    public Usuario obtenerUsuarioPorDni(String dni) {
        return dbUsuario.obtenerUsuarioPorDni(dni);
    }
}
