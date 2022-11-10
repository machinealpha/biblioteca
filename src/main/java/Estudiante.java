public class Estudiante extends Usuario
{private String carrera;

    public Estudiante(String nombre, String rut, String genero, String carrera, int prestamo, String carrera1) {
        super(nombre, rut, genero, carrera, prestamo);
        this.carrera = carrera1;
    }
}
