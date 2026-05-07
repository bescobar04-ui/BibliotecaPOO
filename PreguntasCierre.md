1. ¿Qué ventaja tiene organizar el proyecto en paquetes?
Facilita la mantenibilidad, el orden y la cohesión. Permite separar las responsabilidades lógicas del sistema, haciendo que el código sea más fácil de navegar, entender y escalar en el futuro.

2. ¿Qué problema podría surgir si toda la lógica estuviera en la clase Main?
Se generaría un alto acoplamiento y un "código espagueti". Sería muy difícil encontrar errores, imposible reutilizar partes del código y muy complejo de modificar, ya que un pequeño cambio en la interfaz podría romper la lógica de los datos.

3. ¿Qué diferencia existe entre una clase del modelo y una clase controladora?
La clase del modelo gestiona los datos puros y aplica las reglas de negocio (ej. un libro no se puede prestar si no está disponible). La clase controladora actúa como puente o intermediario: no interactúa con el usuario, sino que recibe las peticiones de la Vista y decide a qué métodos del Modelo llamar.

4. ¿Qué diferencia existe entre asociación y dependencia?
La asociación es una relación estructural fuerte y prolongada (ej. Biblioteca "tiene" una lista de Libros como atributo). La dependencia es una relación temporal de uso, donde una clase necesita de otra solo para hacer una tarea (ej. Main instancia a BibliotecaVista y termina).

5. ¿Por qué Prestamo debe ser una clase independiente?
Porque un préstamo tiene información propia (fecha de inicio, fecha de devolución, estado activo/inactivo). Si estos datos se guardaran dentro de Usuario o Libro, se rompería el Principio de Responsabilidad Única. Prestamo funciona como una clase asociativa entre el usuario y el libro.

6. ¿Qué regla impide prestar dos veces el mismo libro?
El atributo disponible (booleano) encapsulado en la clase Libro. Al prestar un libro, este cambia a false. Si se intenta hacer otro préstamo, el constructor de Prestamo o el método de Biblioteca valida este estado y lanza una excepción (BibliotecaException).

7. ¿Qué clase debería encargarse de mostrar mensajes al usuario?
Exclusivamente la clase BibliotecaVista (dentro del paquete vista), ya que es la única responsable de la interacción con el usuario (entradas y salidas por consola).

8. ¿Qué clase debería encargarse de modificar el estado de un libro?
La propia clase Libro mediante sus métodos internos (como prestar() o devolver()). Esto respeta el principio de encapsulamiento, evitando que otras clases cambien sus variables directamente.

9. ¿Qué cambios serían necesarios para agregar persistencia en archivos?
Se debería modificar el paquete modelo (o crear un paquete DAO/Repository) para agregar métodos que lean y escriban las listas en archivos (.txt, .json o serializados). Gracias a la arquitectura MVC, ni la Vista ni el Controlador tendrían que sufrir grandes alteraciones.

10. ¿Qué cambios serían necesarios para transformar este sistema en una aplicación con interfaz gráfica?
Gracias al patrón MVC, el Modelo y el Controlador quedarían intactos. Solo habría que cambiar el paquete vista, reemplazando la consola (Scanner y System.out) por ventanas de JavaFX o Swing, y conectar los botones a los métodos del Controlador que ya existen.

11. ¿Por qué la vista no debería acceder directamente a las listas internas de Biblioteca?
Para no violar el encapsulamiento ni el patrón MVC. Si la Vista accede directamente, podría modificar la lista (ej. hacer un .add()) saltándose las validaciones de negocio del Modelo, corrompiendo la información. Siempre debe hacerlo solicitando la acción al Controlador.

12. ¿Qué ventajas tiene que Biblioteca retorne copias de sus listas?
Protege la integridad de los datos. Al retornar una copia (con new ArrayList<>(libros)), se evita que desde fuera del modelo se puedan agregar o eliminar elementos de la lista original por accidente o de forma no autorizada.
