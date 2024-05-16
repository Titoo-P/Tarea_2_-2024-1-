package org.example;

/**
 * La clase Nota representa una nota asociada a una reunión.
 */
public class Nota {

    private String contenido;

    /**
     * Constructor que inicializa una nota con un contenido especificado.
     *
     * @param contenido El contenido de la nota.
     */
    public Nota(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Devuelve el contenido de la nota.
     *
     * @return El contenido de la nota.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido de la nota.
     *
     * @param contenido El nuevo contenido de la nota.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Devuelve una representación en formato de cadena de la nota,
     * incluyendo su contenido.
     *
     * @return Una cadena que representa la nota.
     */
    @Override
    public String toString() {
        return "Nota{" +
                "contenido='" + contenido + '\'' +
                '}';
    }
}

