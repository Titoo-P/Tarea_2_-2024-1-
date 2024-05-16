package org.example;

public class Nota {

    private String contenido;

    public Nota(String contenido) {
        this.contenido = contenido;
    }

    // Getter y Setter
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    // Método para representar el objeto como String
    @Override
    public String toString() {
        return "Nota{" +
                "contenido='" + contenido + '\'' +
                '}';
    }
}
