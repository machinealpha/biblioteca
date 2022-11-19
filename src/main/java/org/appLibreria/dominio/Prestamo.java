/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.appLibreria.dominio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author Usuario
 */
public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private GregorianCalendar fecha;
    private Devolucion devolucion;
    private int diasPrestamo;
    private int idPrestamo;


    public Prestamo(Usuario usuario, Libro libro, int diasPrestamo, int idPrestamo){
        setUsuario(usuario);
        setLibro(libro);
    
   
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
    public GregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(GregorianCalendar fecha) {
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
    
   
    
    //1)composición
    public void asignarDevolucion() {
        // POR AHORA SE GENERA VACIÓ PARA QUE USTED LO COMPLETE
        Devolucion devolucion = new Devolucion();
        // ASINGO LA DEVOLUCIÓN RESPETANDO LA RELACIÓN DE COMPOSICIÓN
        // DEBIDO A QUE DEVOLUCIÓN SE INSTANCIÓ DENTRO DEL OBJETO Y NO POR FUERA
        setDevolucion(devolucion);
        // TENGO QUE HABILITAR AL USUARIO
        libro.setISBN("0");
        // TENGO QUE AUMENTAR EL STOCK DISPONBILE Y DISMINUIR EL STOCK ASIGNADO
        libro.setCantidadDisponiblePrestamo(libro.getCantidadDisponiblePrestamo()+1);
        // TENGO QUE COBRAR MULTA SI ES QUE CORRESPONDE
    }

    //2)
    public static Prestamo ingresarPrestamo(int ISBN, String RUN, ArrayList<Libro> libros, ArrayList<Usuario> usuarios, int diasPrestamo, int idPrestamo) {
        // ASIGNO UNA VARIABLE CON VALOR A LO QUE RETORNE EL MÉTODO BUSCARLIBRO
        Libro libro = buscarLibro(ISBN, libros);
        
        // SI EL LIBRO ES NULO, ES PORQUE NO LO HE ENCONTRADO
        if (libro == null) {
            throw new IllegalArgumentException("El libro a buscar no existe.");
        }
        
        // ASIGNO UNA VARIABLE CON VALOR A LO QUE RETORNE EL MÉTODO BUSCARUSUARIO
        Usuario usuario = buscarUsuario(RUN, usuarios);
        
        // SI EL USUARIO ES NULO, ES PORQUE NO LO HE ENCONTRADO
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario a buscar no existe.");
        }
        
        // EN ESTE PUNTO, YA SABEMOS QUE EL USUARIO Y EL LIBRO YA EXISTEN
        // AHORA DEBEMOS REALIZAR LAS VALIDACIONES
        
        // AQUÍ VALIDAMOS QUE EL LIBRO TENGA COMO MÍNIMO UN EJEMPLAR //
        if (libros.size()<=0){
            throw new IllegalArgumentException("No existen ejemplares del libro.");
            
        }
        // AQUÍ VALIDAMOS QUE EL USUARIO DEBA ESTAR HABILTIADO PARA EL PRÉSTAMO //
        
        // UNAS VEZ GENERADA TODAS LAS VALIDACIONES
        
        // GENERAMOS UNA INSTANCIA DE PRÉSTAMO
        Prestamo prestamo = new Prestamo(usuario, libro, diasPrestamo, idPrestamo);
        // ---------------- LO QUE SE DEBE HACER A CONTINUACIÓN SE PUEDE REALIZAR DENTRO DE ÉSTE MÉTODO Ó ----------------
        // ----------------------------- DENTRO DE LA INSTANCIACIÓN DEL OBJETO -------------------------------------------
        // REDUCIMOS LA CANTIDAD DISPONIBLE DEL LIBRE Y AUMENTAMOS LA CANTIDAD EN USO
        libro.setCantidadDisponiblePrestamo(libro.getCantidadDisponiblePrestamo()-1);
        // DEJAMOS AL USUARIO NO DISPONIBLE PARA EL NUEVO PRÉSTAMO
        // 
        
        // CAMBIO EL ISBN DEL USUARIO
        libro.setISBN(libro.getISBN());
        
        // RETORNAMOS EL PRÉSTAMO VALIDADO
        return prestamo;
    }
    
    //3)
    public static void ingresarDevolucion(int ISBN, String RUN, ArrayList<Prestamo> prestamos) {
        // EN BASE A LA GUÍA, DEBEMOS VALIDAR QUE EXISTA EL LIBRO Y EL USUARIO
        
        // LUEGO DEBEMOS VALIDAR QUE EL USUARIO A BUSCAR Y EL ISBN EXISTAN
        

        // ASIGNO UNA VARIABLE CON VALOR A LO QUE RETORNE EL MÉTODO BUSCAR PRESTAMO
        Prestamo prestamo = buscarPrestamo(ISBN, RUN, prestamos);
        // SI EL PRÉTAMO ES NULO, ES PORQUE NO LO HE ENCONTRADO
        if (prestamo == null) {
            throw new IllegalArgumentException("El prestamo a buscar no existe.");
        }
        
        // UNA VEZ GENERADAS TODAS LAS VALIDACIONES, EJECUTAMOS EL MÉTODO ASIGNAR DEVOLUCIÓN
        prestamo.asignarDevolucion();
    }    
      
    //4)
    public static Libro buscarLibro(int ISBN, ArrayList<Libro> libros) {
        // BUSCO EL LIBRO EN EL ARREGLO DE LIBROS
        for (int i = 0; i < libros.size(); i++) {
            // VOY OBTENIENDO CADA LIBRO EN EL ARREGLO DE LIBROS
            Libro libro = libros.get(i);
            
            // PREGUNTO SI EL ISBN DEL LIBRO ES IGUAL AL LIBRO QUE BUSCO
            if (libro.getISBN().equals(ISBN)) {
                // SI LO ENCUENTRO, LO RETORNO
                return libro;
            }
        }
        
        // SI NO LO ENCUENTRO, RETORNO UN NULL
        return null;
    }    

    //5)
    public static Usuario buscarUsuario(String RUN, ArrayList<Usuario> usuarios) {
        // BUSCO EL LIBRO EN EL ARREGLO DE USUARIOS
        for (int i = 0; i < usuarios.size(); i++) {
            // VOY OBTENIENDO CADA USUARIO EN EL ARREGLO DE USUARIOS
            Usuario usuario = usuarios.get(i);
            
            // PREGUNTO SI EL RUT DEL USUARIO ES IGUAL AL RUN QUE BUSCO
            if (usuario.getRut().equals(RUN)) {
                // SI LO ENCUENTRO, LO RETORNO
                return usuario;
            }
        }
        
        // SI NO LO ENCUENTRO, RETORNO UN NULL
        return null;
    }

    //6)
    public static Prestamo buscarPrestamo(int ISBN, String RUN, ArrayList<Prestamo> prestamos) {
        // BUSCO EL PRESTAMO EN EL ARREGLO DE PRESTAMOS
        for (int i = 0; i < prestamos.size(); i++) {
            // VOY OBTENIENDO CADA PRESTAMO EN EL ARREGLO DE PRESTAMO
            Prestamo prestamo = prestamos.get(i);
            
            // PREGUNTO SI EL RUT DEL USUARIO ES IGUAL AL RUN QUE BUSCO Y EL ISBN DEL LIBRO ES IGUAL AL ISBN A BUSCAR
            // FALTA VALIDAR QUE EL PRÉSTAMO ESTÉ ACTUALMENTE ACTIVO Y NO ENCUENTRE UN PRÉSTAMO YA DEVUELVO
            if (prestamo.getUsuario().getRut().equals(RUN) && prestamo.getLibro().getISBN().equals(ISBN)) {
                // SI LO ENCUENTRO, LO RETORNO
                return prestamo;
            }
        }
        
        // SI NO LO ENCUENTRO, RETORNO UN NULL
        return null;
    }    
    
}



