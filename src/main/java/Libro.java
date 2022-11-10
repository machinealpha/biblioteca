public class Libro
{
    private String ISBN;
    private String titulo;
    private String autor;
    private String imagen;
    private int cantidadTotalBiblioteca;
    private int cantidadDisponiblePrestamo;


    public Libro(String ISBN, String titulo, String autor, String imagen, int cantidadTotalBiblioteca, int cantidadDisponiblePrestamo) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.imagen = imagen;
        this.cantidadTotalBiblioteca = cantidadTotalBiblioteca;
        this.cantidadDisponiblePrestamo = cantidadDisponiblePrestamo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCantidadTotalBiblioteca() {
        return cantidadTotalBiblioteca;
    }

    public void setCantidadTotalBiblioteca(int cantidadTotalBiblioteca) {
        this.cantidadTotalBiblioteca = cantidadTotalBiblioteca;
    }

    public int getCantidadDisponiblePrestamo() {
        return cantidadDisponiblePrestamo;
    }

    public void setCantidadDisponiblePrestamo(int cantidadDisponiblePrestamo) {
        this.cantidadDisponiblePrestamo = cantidadDisponiblePrestamo;
    }
}
