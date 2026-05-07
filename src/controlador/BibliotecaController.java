package controlador;

import java.util.ArrayList;
import modelo.*;

public class BibliotecaController {
    private Biblioteca biblioteca;

    public BibliotecaController() {
        this.biblioteca = new Biblioteca();
    }

    // Agregamos "throws BibliotecaException" a los metodos de registro
    public void registrarLibro(String codigo, String titulo, String autor) throws BibliotecaException {
        biblioteca.agregarLibro(new Libro(codigo, titulo, autor));
    }

    public void registrarUsuario(String id, String nombre, String correo) throws BibliotecaException {
        biblioteca.agregarUsuario(new Usuario(id, nombre, correo));
    }

    public void prestarLibro(String idUsuario, String codigoLibro) throws BibliotecaException {
        biblioteca.registrarPrestamo(idUsuario, codigoLibro);
    }

    public void devolverLibro(String codigoLibro) throws BibliotecaException {
        biblioteca.devolverLibro(codigoLibro);
    }

    public ArrayList<Libro> obtenerLibros() { return biblioteca.listarLibros(); }
    public ArrayList<Usuario> obtenerUsuarios() { return biblioteca.listarUsuarios(); }
    public ArrayList<Prestamo> obtenerPrestamosActivos() { return biblioteca.listarPrestamosActivos(); }
}