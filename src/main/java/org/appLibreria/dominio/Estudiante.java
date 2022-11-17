package org.appLibreria.dominio;

public class Estudiante extends Usuario{
    private String carrera;

    public Estudiante(String nombre, String rut, String genero, String carrera, int prestamo) {
        super(nombre, rut, genero, prestamo);
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "carrera='" + carrera + '\'' +
                '}';
    }
}
