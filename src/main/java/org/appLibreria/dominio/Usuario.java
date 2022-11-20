package org.appLibreria.dominio;

import java.util.List;

public abstract class Usuario {
  private String nombre;
  private String rut;
  private char genero;
  private String prestamo;

  public Usuario(String nombre, String rut, char genero, String prestamo) {
    setNombre(nombre);
    setRut(rut);
    setGenero(genero);
    setPrestamo(prestamo);
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getRut() {
    return rut;
  }

  public void setRut(String rut) {
    this.rut = rut;
  }

  public char getGenero() {
    return genero;
  }

  public void setGenero(char genero) {
    this.genero = genero;
  }

  public String getPrestamo() {
    return prestamo;
  }

  public void setPrestamo(String prestamo) {
    this.prestamo = prestamo;
  }

  @Override
  public String toString() {
    return "Usuario{"
        + "nombre='"
        + nombre
        + '\''
        + ", rut='"
        + rut
        + '\''
        + ", genero='"
        + genero
        + '\''
        + ", prestamo="
        + prestamo
        + '}';
  }

  public static Usuario validarRun(String rut, List<Usuario> usuarios) {
    return usuarios.stream().filter(x -> x.getRut().equals(rut)).findFirst().orElse(null);
  }

  public static boolean habilitadoPrestamo(Usuario usr){
    return usr.getPrestamo().equals("0");
  }
}
