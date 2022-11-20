package org.appLibreria.dominio;

public class Estudiante extends Usuario {
  private String carrera;

  public Estudiante(String nombre, String rut, char genero, String carrera, String prestamo) {
    super(nombre, rut, genero, prestamo);
    this.carrera = carrera;
  }

  public String getCarrera() {
    return carrera;
  }

  public void setCarrera(String carrera) {
    this.carrera = carrera;
  }

  @Override
  public String toString() {
    return "Estudiante{" + "carrera='" + carrera + '\'' + '}';
  }
}
