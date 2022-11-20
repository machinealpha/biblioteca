/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.appLibreria.dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Usuario
 */
public class Prestamo {
  private Usuario usuario;
  private Libro libro;
  private LocalDate fecha;
  private Devolucion devolucion;
  private int diasPrestamo;
  private int idPrestamo;

  public Prestamo(Usuario usuario, Libro libro, int diasPrestamo, int idPrestamo) {
    this.setUsuario(usuario);
    this.setLibro(libro);
    this.setFecha(LocalDate.now());
    this.inicializarDevolucion();
  }

  /**
   * @return the usuario
   */
  public Usuario getUsuario() {
    return usuario;
  }

  /**
   * @param usuario the usuario to set
   */
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  /**
   * @return the libro
   */
  public Libro getLibro() {
    return libro;
  }

  /**
   * @param libro the libro to set
   */
  public void setLibro(Libro libro) {
    this.libro = libro;
  }

  /**
   * @return the fecha
   */
  public LocalDate getFecha() {
    return fecha;
  }

  /**
   * @param fecha the fecha to set
   */
  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  /**
   * @return the devolucion
   */
  public Devolucion getDevolucion() {
    return devolucion;
  }

  /**
   * @param devolucion the devolucion to set
   */
  public void setDevolucion(Devolucion devolucion) {
    this.devolucion = devolucion;
  }

  /**
   * @return the diasPrestamo
   */
  public int getDiasPrestamo() {
    return diasPrestamo;
  }

  /**
   * @param diasPrestamo the diasPrestamo to set
   */
  public void setDiasPrestamo(int diasPrestamo) {
    this.diasPrestamo = diasPrestamo;
  }

  /**
   * @return the idPrestamo
   */
  public int getIdPrestamo() {
    return idPrestamo;
  }

  /**
   * @param idPrestamo the idPrestamo to set
   */
  public void setIdPrestamo(int idPrestamo) {
    this.idPrestamo = idPrestamo;
  }

  private void inicializarDevolucion() {
    Devolucion devolucion = null;
    if (this.getUsuario() instanceof Docente) {
      this.getFecha().plusDays(20L);
      devolucion = new Devolucion(this.getFecha().plusDays(20L));
    } else {
      devolucion = new Devolucion(this.getFecha().plusDays(10L));
    }
    setDevolucion(devolucion);
  }

  // 1)composición
  public static void ingresarDevolucio(
      String isbn,
      String rut,
      Prestamo prestamo,
      LocalDate fchDevolucionReal,
      List<Libro> libros,
      List<Usuario> usuarios) {

    if (!Libro.validarIsbn(isbn, libros)) {
      throw new IllegalArgumentException("El libro a buscar no existe.");
    }
    Libro libro = Libro.obtenerLibro(isbn, libros);
    Usuario usuario = Usuario.validarRun(rut, usuarios);
    if (usuario == null) {
      throw new IllegalArgumentException("Usuario no existe");
    }

    if (!libro.getISBN().equals(usuario.getPrestamo())) {
      throw new IllegalArgumentException("Libro a devolver no esta asociado al usuario");
    }
    usuario.setPrestamo("0");
    libro.sumarDisponibilidad();
    Devolucion devolucion = prestamo.getDevolucion();
    devolucion.retraso(fchDevolucionReal);
    System.out.println("devolucion efectuada correctamente");
  }

  // 2)
  public static Prestamo ingresarPrestamo(
      String ISBN,
      String rut,
      List<Libro> libros,
      List<Usuario> usuarios,
      int diasPrestamo,
      int idPrestamo) {
    // ASIGNO UNA VARIABLE CON VALOR A LO QUE RETORNE EL MÉTODO BUSCARLIBRO
    if (!Libro.validarIsbn(ISBN, libros)) {
      throw new IllegalArgumentException("El libro a buscar no existe.");
    }
    Libro libro = Libro.obtenerLibro(ISBN, libros);
    if (!Libro.validarCantidadLibroDisponible(
        libro.getCantidadDisponiblePrestamo(), libro.getCantidadTotalBiblioteca())) {
      throw new IllegalArgumentException("Libro no disponible para realizar prestamo");
    }

    // ASIGNO UNA VARIABLE CON VALOR A LO QUE RETORNE EL MÉTODO BUSCARUSUARIO
    // SI EL USUARIO ES NULO, ES PORQUE NO LO HE ENCONTRADO
    Usuario usuario = Usuario.validarRun(rut, usuarios);
    if (usuario == null) {
      throw new IllegalArgumentException("Usuario no existe");
    }

    // EN ESTE PUNTO, YA SABEMOS QUE EL USUARIO Y EL LIBRO YA EXISTEN
    // AHORA DEBEMOS REALIZAR LAS VALIDACIONES
    // AQUÍ VALIDAMOS QUE EL USUARIO DEBA ESTAR HABILTIADO PARA EL PRÉSTAMO //
    if (!Usuario.habilitadoPrestamo(usuario)) {
      throw new IllegalArgumentException("Usuario no habilitado para prestamo");
    }

    usuario.setPrestamo(ISBN);
    libro.quitarDisponibilidad();

    // UNAS VEZ GENERADA TODAS LAS VALIDACIONES

    // GENERAMOS UNA INSTANCIA DE PRÉSTAMO
    Prestamo prestamo = new Prestamo(usuario, libro, diasPrestamo, idPrestamo);
    prestamo.tarjetaPrestamo();
    return prestamo;
  }

  public String tarjetaPrestamo() {
    return """
            Usuario: %s %s
            Libro: %s %s
            Fecha inicio: %s
            Devolución: %s
            """
        .formatted(
            this.getUsuario().getRut(),
            this.getUsuario().getNombre(),
            this.getLibro().getISBN(),
            this.getLibro().getTitulo(),
            this.getFecha(),
            this.getDevolucion().getFechaEntrega());
  }
}
