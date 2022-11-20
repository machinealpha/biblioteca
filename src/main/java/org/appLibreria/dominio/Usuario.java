package org.appLibreria.dominio;

public abstract class Usuario {
  private String nombre;
  private String rut;
  private String genero;
  private int prestamo;

  public Usuario(String nombre, String rut, String genero, int prestamo) {
    this.nombre = nombre;
    this.rut = rut;
    this.genero = genero;
    this.prestamo = prestamo;
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

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public int getPrestamo() {
    return prestamo;
  }

  public void setPrestamo(int prestamo) {
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
  
  //Se agrego para complementar Borrar Usuarios (faltan unos atributos que aparecen en el csv como "Profesion, Grado y Carrera")
   public String toCSV() {
        // AGREGAR LOS ATRIBUTOS ADICIONALES SEPARADOS POR ;
        // 1-1;Tomás S;1
        
        return getNombre() + ";" +getRut() + ";" +  getGenero() + ";" + getPrestamo();
    }   

  
}
