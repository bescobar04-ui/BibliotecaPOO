@startuml
skinparam style strictuml
skinparam packageStyle rectangle

title Diagrama de Clases: Sistema Biblioteca POO (Arquitectura MVC)

package "app" {
    class Main {
        + main(args: String[])
    }
}

package "vista" {
    class BibliotecaVista {
        + mostrarMenu()
        + mostrarMensaje(msj: String)
        + leerEntrada(): String
    }
}

package "controlador" {
    class BibliotecaController {
        - vista: BibliotecaVista
        - modelo: Biblioteca
        + iniciar()
        + procesarAccion(opcion: int)
    }
}

package "modelo" {
    class Biblioteca {
        - libros: List<Libro>
        - usuarios: List<Usuario>
        + agregarLibro(l: Libro)
        + registrarUsuario(u: Usuario)
        + realizarPrestamo(u: Usuario, l: Libro)
    }

    class Libro {
        - titulo: String
        - autor: String
        - disponible: boolean
    }

    class Usuario {
        - nombre: String
        - correo: String
        + validarCorreo(): boolean
    }

    class Prestamo {
        - fecha: Date
        - usuario: Usuario
        - libro: Libro
    }

    class BibliotecaException {
        <<Exception>>
        + BibliotecaException(msj: String)
    }
}

' Relaciones
Main ..> BibliotecaVista : crea
Main ..> BibliotecaController : crea
BibliotecaController --> BibliotecaVista : usa
BibliotecaController --> Biblioteca : gestiona
Biblioteca "1" *-- "many" Libro : contiene
Biblioteca "1" *-- "many" Usuario : registra
Biblioteca "1" *-- "many" Prestamo : controla
Prestamo --> Libro : asocia
Prestamo --> Usuario : asocia
Usuario ..> BibliotecaException : lanza (validación @)
@enduml
