package vista;

import java.util.ArrayList;
import java.util.Scanner;
import controlador.BibliotecaController;
import modelo.*;

public class BibliotecaVista {
    private BibliotecaController controller;
    private Scanner scanner;

    public BibliotecaVista(BibliotecaController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            try {
                switch (opcion) {
                    case 1: registrarLibro(); break;
                    case 2: registrarUsuario(); break;
                    case 3: prestarLibro(); break;
                    case 4: devolverLibro(); break;
                    case 5: listarLibros(); break;
                    case 6: listarUsuarios(); break;
                    case 7: listarPrestamosActivos(); break;
                    case 0: System.out.println("Saliendo..."); break;
                    default: System.out.println("Opcion no valida.");
                }
                // CAMBIO CLAVE: Captura cualquier error y lo muestra en pantalla
            } catch (Exception e) {
                System.out.println("\n⚠️ ATENCION: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n===== Sistema Biblioteca =====");
        System.out.println("1. Registrar libro | 2. Registrar usuario");
        System.out.println("3. Prestar libro   | 4. Devolver libro");
        System.out.println("0. Salir");
    }

    private void registrarLibro() throws BibliotecaException {
        controller.registrarLibro(leerTexto("Codigo: "), leerTexto("Titulo: "), leerTexto("Autor: "));
        System.out.println("Libro registrado.");
    }

    private void registrarUsuario() throws BibliotecaException {
        controller.registrarUsuario(leerTexto("ID: "), leerTexto("Nombre: "), leerTexto("Correo: "));
        System.out.println("Usuario registrado.");
    }

    private void prestarLibro() throws BibliotecaException {
        controller.prestarLibro(leerTexto("ID Usuario: "), leerTexto("Cod Libro: "));
        System.out.println("Prestamo realizado.");
    }

    private void devolverLibro() throws BibliotecaException {
        controller.devolverLibro(leerTexto("Cod Libro: "));
        System.out.println("Libro devuelto.");
    }

    private void listarLibros() {
        for (Libro l : controller.obtenerLibros()) System.out.println(l);
    }

    private void listarUsuarios() {
        for (Usuario u : controller.obtenerUsuarios()) System.out.println(u);
    }

    private void listarPrestamosActivos() {
        for (Prestamo p : controller.obtenerPrestamosActivos()) System.out.println(p);
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }
}