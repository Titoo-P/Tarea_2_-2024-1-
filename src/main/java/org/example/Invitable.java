package org.example;

/**
 * La interfaz Invitable define un método para invitar a la clase que la implementa a una reunión.
 */
public interface Invitable {

    /**
     * Invita a la clase que implementa la interfaz a una reunión.
     *
     * @param reunion La reunión a la que se invita a la clase.
     */
    public void invitar(Reunion reunion);
}
