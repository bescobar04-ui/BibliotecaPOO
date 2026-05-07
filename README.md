# Sistema de Gestión de Biblioteca - Patrón MVC (POO)

Este proyecto es una implementación en Java de un sistema de gestión de biblioteca, estructurado bajo el patrón arquitectónico **Modelo-Vista-Controlador (MVC)**. 

Desarrollado para la asignatura de Programación Orientada a Objetos, este software demuestra la correcta separación de responsabilidades, alta cohesión y bajo acoplamiento.

### 🚀 Extensiones Implementadas (Sección 16 del apunte)
1. **Validación de Datos (Integridad):** Se implementó una lógica de validación de negocio en la clase `Usuario`, exigiendo obligatoriamente el formato correcto del correo (uso del `@`).
2. **Excepciones Personalizadas (Manejo de Errores):** Se reemplazaron las excepciones nativas genéricas por una excepción propia (`BibliotecaException`). Esto permite aislar errores de lógica de negocio y evitar bloqueos en el sistema (`try-catch` capturado de forma limpia en la Vista).

### 📂 Arquitectura (Paquetes)
* **app:** Contiene el punto de arranque (`Main`).
* **vista:** Gestión de E/S por consola (`BibliotecaVista`).
* **controlador:** Intermediario que delega peticiones (`BibliotecaController`).
* **modelo:** Core del negocio, clases de dominio (`Biblioteca`, `Libro`, `Usuario`, `Prestamo`) y manejo de excepciones.
