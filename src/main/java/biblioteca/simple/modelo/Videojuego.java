package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

/**
 * Clase Videojuego que extiende Producto e implementa la interfaz Prestable.
 * Representa un videojuego que puede ser prestado a un usuario.
 */
public class Videojuego extends Producto implements Prestable {

    // =======================
    // Atributos propios
    // =======================
    private String plataforma;     // Ej: PS5, PC, Switch...
    private int edadMinima;        // PEGI o restricción de edad

    // Estado del préstamo
    private boolean prestado = false;
    private Usuario usuarioPrestamo;  // Usuario que tiene prestado el videojuego

    // =======================
    // Constructor
    // =======================
    public Videojuego(int id, String titulo, String anio, Formato formato,
                      String plataforma, int edadMinima) {
        super(id, titulo, anio, formato);
        this.plataforma = plataforma;
        this.edadMinima = edadMinima;
    }

    // =======================
    // Implementación Prestable
    // =======================

    @Override
    public void prestar(Usuario u) {
        if (prestado) {
            System.out.println("El videojuego ya está prestado.");
            return;
        }
        this.prestado = true;
        this.usuarioPrestamo = u;
        System.out.println("Videojuego prestado correctamente a " + u.getNombre());
    }

    @Override
    public void devolver() {
        if (!prestado) {
            System.out.println("El videojuego no está prestado.");
            return;
        }
        this.prestado = false;
        this.usuarioPrestamo = null;
        System.out.println("Videojuego devuelto correctamente.");
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }

    // =======================
    // toString
    // =======================

    @Override
    public String toString() {
        return "Videojuego {" +
                "ID=" + getId() +
                ", Título='" + getTitulo() + '\'' +
                ", Año='" + getAnho() + '\'' +
                ", Formato=" + getFormato() +
                ", Plataforma='" + plataforma + '\'' +
                ", Edad mínima=" + edadMinima +
                ", Prestado=" + (prestado ? "Sí" : "No") +
                '}';
    }
}