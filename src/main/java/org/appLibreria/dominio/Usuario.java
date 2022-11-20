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
    validarRun(rut);
    this.rut = rut;
  }

  public char getGenero() {
    return genero;
  }

  public void setGenero(char genero) {
    validarGenero(genero);
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

  public static Usuario buscarUsuario(String rut, List<Usuario> usuarios) {
    return usuarios.stream().filter(x -> x.getRut().equals(rut)).findFirst().orElse(null);
  }

  public static boolean habilitadoPrestamo(Usuario usr) {
    return usr.getPrestamo().equals("0");
  }

  public void validarRun(String cedula) {
    if (cedula.length() != 10) {
      throw new IllegalArgumentException("EL LARGO DE LA CEDULA DEBE SER DE 10");
    }
    if ("-".indexOf(cedula.charAt(8)) == -1) {
      throw new IllegalArgumentException("CEDULA DEBE CONTENER GUION MEDIO (-)");
    }
    if ("1234567890Kk".indexOf(cedula.charAt(9)) == -1) {
      throw new IllegalArgumentException("DIGITO VERIFICADOR DEBE ESTAR ENTRE 1234567890K");
    }
  }

  public void validarGenero(char genero) {
    if (Character.compare(genero, 'M') != 0 && Character.compare(genero, 'F') != 0) {
      throw new IllegalArgumentException("GENERO NO VALIDO");
    }
  }

  public static Usuario crearUsuario(Usuario usuario, List<Usuario> usuarios) {
    usuarios.add(usuario);
    return usuario;
  }

  public static void eliminarUsuario(String rut, List<Usuario> usuarios) {
    Usuario usuario = buscarUsuario(rut, usuarios);
    if (usuario == null) {
      throw new IllegalArgumentException("Usuario no encontrado");
    }
    usuarios.remove(usuario);
  }

  public static Usuario editarUsuario(String rutNuevo, String rutActual, List<Usuario> usuarios) {
    for (Usuario usuario : usuarios) {
      if (usuario.getRut().equals(rutActual)) {
        usuario.setRut(rutNuevo);
        return usuario;
      }
    }
    throw new IllegalArgumentException("Usuario no encontrado");
  }

  public String toCsv() {
    if (this instanceof Docente doc) {
      return """
            %s;%s;%s;%s;%s;%s;
            """
          .formatted(
              this.getNombre(),
              this.getRut(),
              this.getGenero(),
              this.getPrestamo(),
              doc.getProfesion(),
              doc.getGrados());
    } else if (this instanceof Estudiante est) {
      return """
            %s;%s;%s;%s;;;%s
            """
          .formatted(
              this.getNombre(),
              this.getRut(),
              this.getGenero(),
              this.getPrestamo(),
              est.getCarrera());
    }
    return null;
  }
}
