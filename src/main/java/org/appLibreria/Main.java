package org.appLibreria;

import org.appLibreria.logica.ArchivoImpl;

public class Main {

    public static final String LIBRO_FILENAME = "libros.csv";
    public static final String USUARIO_FILENAME = "usuarios.csv";
    public static void main(String[] args) {
        ArchivoImpl.leerLibro(LIBRO_FILENAME);
        ArchivoImpl.leerUsuario(USUARIO_FILENAME);
    }
}