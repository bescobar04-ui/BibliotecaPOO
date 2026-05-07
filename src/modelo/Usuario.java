package modelo;

public class Usuario {
    private String id;
    private String nombre;
    private String correo;

    // Agregamos "throws BibliotecaException"
    public Usuario(String id, String nombre, String correo) throws BibliotecaException {
        if (id == null || id.isBlank()) throw new BibliotecaException("El ID no puede estar vacio.");
        if (nombre == null || nombre.isBlank()) throw new BibliotecaException("El nombre no puede estar vacio.");

        // --- ESTA ES LA EXTENSIÓN: VALIDACIÓN DEL @ ---
        if (correo == null || !correo.contains("@")) {
            throw new BibliotecaException("Error: El correo '" + correo + "' no es valido (falta el '@').");
        }

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " - " + correo;
    }
}