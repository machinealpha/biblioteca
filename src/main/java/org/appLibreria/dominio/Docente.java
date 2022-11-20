package org.appLibreria.dominio;

public class Docente extends Usuario{
    private String profesion;
    private String grados;

    public Docente(String nombre, String rut, char genero, String prestamo, String profesion, String grados) {
        super(nombre, rut, genero, prestamo);
        this.profesion = profesion;
        this.grados = grados;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getGrados() {
        return grados;
    }

    public void setGrados(String grados) {
        this.grados = grados;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "profesion='" + profesion + '\'' +
                ", grados='" + grados + '\'' +
                '}';
    }
}
