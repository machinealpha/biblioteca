package org.appLibreria.logica;

import org.appLibreria.dominio.Docente;
import org.appLibreria.dominio.Estudiante;
import org.appLibreria.dominio.Libro;
import org.appLibreria.dominio.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ArchivoImpl {

  private static final String COMMA_DELIMITER = ";";
  private static final String ENCABEZADO_LIBRO=
          "ISBN;titulo;autor;cantidad_biblioteca;cantidad_disponible;imagen";

  public static List<Libro> leerLibro(String nombreArchivo) {
    List<Libro> libros = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
      // se remueve el titulo
      scanner.nextLine();
      while (scanner.hasNextLine()) {
        getRecordFromLineLibro(scanner.nextLine(), libros);
      }
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("El archivo no existe.");
    }
    return libros;
  }

  public static List<Usuario> leerUsuario(String nombreArchivo) {
    List<Usuario> usuarios = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
      // se remueve el titulo
      scanner.nextLine();
      while (scanner.hasNextLine()) {
        getRecordFromLineUsuario(scanner.nextLine(), usuarios);
      }
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("El archivo no existe.");
    }
    return usuarios;
  }

  private static List<Usuario> getRecordFromLineUsuario(String line, List<Usuario> usuarios) {
    String[] split = line.split(COMMA_DELIMITER);
    if (Objects.nonNull(split[4]) && !split[4].isBlank()) {
      usuarios.add(
          new Docente(
              split[0], split[1], String.split[2], Integer.parseInt(split[3]), split[4], split[5]));
    } else {
      usuarios.add(
          new Estudiante(split[0], split[1], split[2], split[6], Integer.parseInt(split[3])));
    }
    return usuarios;
  }

  private static List<Libro> getRecordFromLineLibro(String line, List<Libro> libros) {
    String[] split = line.split(COMMA_DELIMITER);
    libros.add(
        new Libro(
            split[0],
            split[1],
            split[2],
            Integer.parseInt(split[3]),
            Integer.parseInt(split[4]),
            split[5]));

    return libros;
  }

  public static void guardarLibros(List<Libro> libros, String libroFilename){
    try(FileWriter fileWriter = new FileWriter(libroFilename)){
      fileWriter.write(ENCABEZADO_LIBRO+ "\n");
      for (Libro libro : libros) {
        fileWriter.write(libro.toCsv());
      }
      fileWriter.flush();
    } catch (IOException e) {
      System.err.println(e);
      throw new RuntimeException(e);
    }
  }
}
