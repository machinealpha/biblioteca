public class Docente extends Usuario
{private String profesion;
    private String grados;

    public Docente(String nombre, String rut, String genero, String profesion, String grados) {
        super(nombre, rut, genero);
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
}
