package org.appLibreria;

import org.appLibreria.dominio.Docente;
import org.appLibreria.dominio.Libro;
import org.appLibreria.dominio.Prestamo;
import org.appLibreria.dominio.Usuario;
import org.appLibreria.logica.ArchivoImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {

  public static final String LIBRO_FILENAME = "libros.csv";
  public static final String USUARIO_FILENAME = "usuarios.csv";

  public static void main(String[] args) {
    List<Libro> libros = ArchivoImpl.leerLibro(LIBRO_FILENAME);
    List<Usuario> usuarios = ArchivoImpl.leerUsuario(USUARIO_FILENAME);
    Libro libro = new Libro("123456ffg", "test", "yo", 5, 5, "img");
    Libro.crearLibro(libro, libros);
    Usuario usuario = new Docente("Mario", "19126702-0", 'M', "0", "profesor", "master");
    Usuario.crearUsuario(usuario,usuarios);
    Prestamo prestamo = Prestamo.ingresarPrestamo("123456ffg", "19126702-0", libros, usuarios);
    LocalDate fechaDevolucionReal = LocalDate.of(2022,12,11);
    Prestamo.ingresarDevolucio("123456ffg","19126702-0",prestamo,fechaDevolucionReal,libros,usuarios);

    ArchivoImpl.guardarLibros(libros, LIBRO_FILENAME);
    ArchivoImpl.guardarUsuarios(usuarios, USUARIO_FILENAME);
  }
}
