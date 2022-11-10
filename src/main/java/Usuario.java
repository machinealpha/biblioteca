public abstract class Usuario
{private String nombre;
        private String rut;
    private String genero;
    private String carrera;
    private int prestamo;


    public Usuario(String nombre, String rut, String genero, String carrera, int prestamo) {
        this.nombre = nombre;
        this.rut = rut;
        this.genero = genero;
        this.carrera = carrera;
        this.prestamo = prestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(int prestamo) {
        this.prestamo = prestamo;
    }
}
