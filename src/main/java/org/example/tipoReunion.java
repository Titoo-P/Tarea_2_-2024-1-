package org.example;

public enum tipoReunion {
    TECNICA("Tecnica"),
    MARKETING("Marketing"),
    OTRO("Otro");

    public final String tipo;

    tipoReunion(String tipo){
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return tipo;
    }
}
