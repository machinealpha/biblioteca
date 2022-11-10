public class Estudiante extends Usuario
{private String carrera;

    public Estudiante(String nombre, String rut, String genero, String carrera) {
        super(nombre, rut, genero);
        this.carrera = carrera;
    }
}
