package app;

import controlador.BibliotecaController;
import vista.BibliotecaVista;

public class Main {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController();
        // Al arreglar el archivo de arriba, esta línea roja desaparecerá mágicamente:
        BibliotecaVista vista = new BibliotecaVista(controller);
        vista.iniciar();
    }
}
