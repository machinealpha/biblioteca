package org.appLibreria;

import org.appLibreria.dominio.Libro;
import org.appLibreria.dominio.Usuario;
import org.appLibreria.logica.ArchivoImpl;

import java.util.List;

public class Main {

    public static final String LIBRO_FILENAME = "libros.csv";
    public static final String USUARIO_FILENAME = "usuarios.csv";
    public static void main(String[] args) {
        List<Libro> libros = ArchivoImpl.leerLibro(LIBRO_FILENAME);
        List<Usuario> usuarios = ArchivoImpl.leerUsuario(USUARIO_FILENAME);
    System.out.println(libros.size());
        System.out.println(usuarios.size());
    }
}