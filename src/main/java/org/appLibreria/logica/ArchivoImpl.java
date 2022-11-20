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
import java.util.stream.Collectors;

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
  
    //Agrege metodo borrar usuarios
    public static void borrarUsuario(String nombreArchivo, String rut ) throws FileNotFoundException, IOException {
        // carga lista actual usuarios
        List<Usuario> usuarios = ArchivoImpl.leerUsuario(nombreArchivo);
        // filtra lista actual de usuarios respecto a rut y crea lista filtrada
        List<Usuario> usuariosFilter = usuarios.stream().filter(u -> rut.equals(u.getRut())).collect(Collectors.toList());
        if (!usuariosFilter.isEmpty()) {
           System.out.println("el usuario existe");
           FileWriter archivoEscritura = new FileWriter(nombreArchivo);
           archivoEscritura.write("nombre_completo;run;genero;prestamo;profesion;grado;carrera" + "\n");
            for (int i = 0; i < usuarios.size(); i++) {
                // OBRTENEMOS EL FORMATO CSV
                String linea = usuarios.get(i).toCSV();
                System.out.println(linea);
                String [] array = linea.split(";");
                if (array[1].equals(rut)) {
                    System.out.println(array[2] + " borrar");
                } else {
                    // ESCRIBIMOS EN EL ARCHIVO
                    archivoEscritura.write(linea + "\n");
                }
            }
        // CERRAMOS EL ARCHIVO
        archivoEscritura.close();
        }
    }   
}
