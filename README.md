@startuml
skinparam classAttributeIconSize 0

package "app" {
    class Main
}

package "vista" {
    class BibliotecaVista
}

package "controlador" {
    class BibliotecaController
}

package "modelo" {
    class Biblioteca
    class Libro
    class Usuario
    class Prestamo
    class BibliotecaException
}

Main ..> BibliotecaVista : "crea >"
Main ..> BibliotecaController : "crea >"

BibliotecaVista --> "1" BibliotecaController : "-controller"

BibliotecaController --> "1" Biblioteca : "-biblioteca"

Biblioteca o-- "*" Libro : "-libros"
Biblioteca o-- "*" Usuario : "-usuarios"
Biblioteca *-- "*" Prestamo : "-prestamos"

Prestamo --> "1" Usuario : "-usuario"
Prestamo --> "1" Libro : "-libro"

note right of BibliotecaException: Extensión Sec. 16:\nManejo de Errores
@enduml
