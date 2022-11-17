package org.appLibreria.dominio;

import java.util.List;

public class Libro {
  private String ISBN;
  private String titulo;
  private String autor;
  private String imagen;
  private int cantidadTotalBiblioteca;
  private int cantidadDisponiblePrestamo;

  public Libro(
      String ISBN,
      String titulo,
      String autor,
      int cantidadTotalBiblioteca,
      int cantidadDisponiblePrestamo,
      String imagen) {
    this.ISBN = ISBN;
    this.titulo = titulo;
    this.autor = autor;
    this.imagen = imagen;
    this.cantidadTotalBiblioteca = cantidadTotalBiblioteca;
    this.cantidadDisponiblePrestamo = cantidadDisponiblePrestamo;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public int getCantidadTotalBiblioteca() {
    return cantidadTotalBiblioteca;
  }

  public void setCantidadTotalBiblioteca(int cantidadTotalBiblioteca) {
    this.cantidadTotalBiblioteca = cantidadTotalBiblioteca;
  }

  public int getCantidadDisponiblePrestamo() {
    return cantidadDisponiblePrestamo;
  }

  public void setCantidadDisponiblePrestamo(int cantidadDisponiblePrestamo) {
    this.cantidadDisponiblePrestamo = cantidadDisponiblePrestamo;
  }

  @Override
  public String toString() {
    return "Libro{"
        + "ISBN='"
        + ISBN
        + '\''
        + ", titulo='"
        + titulo
        + '\''
        + ", autor='"
        + autor
        + '\''
        + ", imagen='"
        + imagen
        + '\''
        + ", cantidadTotalBiblioteca="
        + cantidadTotalBiblioteca
        + ", cantidadDisponiblePrestamo="
        + cantidadDisponiblePrestamo
        + '}';
  }

  public static Libro crearLibro(Libro libro, List<Libro> libros) {
    if (validarIsbn(libro.getISBN(), libros)) {
      throw new IllegalArgumentException(
          String.format("Libro ya existe con ISBN %s", libro.getISBN()));
    }
    if (validarCantidadLibroBiblioteca(libro.getCantidadTotalBiblioteca())) {
      throw new IllegalArgumentException("La cantidad total de libros debe ser mayor a 0");
    }
    if (validarCantidadLibroDisponible(
        libro.getCantidadDisponiblePrestamo(), libro.getCantidadTotalBiblioteca())) {
      throw new IllegalArgumentException(
          "La cantidad de libros disponibles para prestamo debe ser menor o igual a la cantidad total de libros y mayor a 0");
    }
    libros.add(libro);
    return libro;
  }

  public static boolean validarIsbn(String isbn, List<Libro> libros) {
    return libros.stream().anyMatch(libro -> libro.getISBN().equals(isbn));
  }

  public static boolean validarCantidadLibroBiblioteca(int caLibrosBiblio) {
    return caLibrosBiblio > 0;
  }

  public static boolean validarCantidadLibroDisponible(int caLibrosDisp, int caLibrosBiblio) {
    return caLibrosDisp > 0 && caLibrosDisp <= caLibrosBiblio;
  }
}
