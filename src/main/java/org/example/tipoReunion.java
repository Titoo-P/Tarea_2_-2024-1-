package org.example;

/**
 * Enumeración que representa los tipos de reuniones posibles.
 */
public enum tipoReunion {
    TECNICA("Tecnica"),
    MARKETING("Marketing"),
    OTRO("Otro");

    public final String tipo;

    /**
     * Constructor privado de TipoReunion.
     *
     * @param tipo El nombre del tipo de reunión.
     */
    tipoReunion(String tipo){
        this.tipo = tipo;
    }

    /**
     * Devuelve el nombre del tipo de reunión.
     *
     * @return El nombre del tipo de reunión.
     */
    @Override
    public String toString(){
        return tipo;
    }
}
