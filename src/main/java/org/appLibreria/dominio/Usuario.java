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
<<<<<<< HEAD
  
  //Se agrego para complementar Borrar Usuarios (faltan unos atributos que aparecen en el csv como "Profesion, Grado y Carrera")
   public String toCSV() {
        // AGREGAR LOS ATRIBUTOS ADICIONALES SEPARADOS POR ;
        // 1-1;Tomás S;1
        
        return getNombre() + ";" +getRut() + ";" +  getGenero() + ";" + getPrestamo();
    }   

  
=======

  public static Usuario validarRun(String rut, List<Usuario> usuarios) {
    return usuarios.stream().filter(x -> x.getRut().equals(rut)).findFirst().orElse(null);
  }

  public static boolean habilitadoPrestamo(Usuario usr){
    return usr.getPrestamo().equals("0");
  }
>>>>>>> 32b955c1cc96b66f841e50d5b2691634747ce082
}
