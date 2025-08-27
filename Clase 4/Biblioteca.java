public class Biblioteca{
    private String Titulo;
    private String Autor;
    private int Precio;
    private Double id;

    public Biblioteca(String titulo, String autor, int precio, Double id) {
        Titulo = titulo;
        Autor = autor;
        Precio = precio;
        this.id = id;
        
    }
    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
    public String getAutor() {
        return Autor;
    }
    public void setAutor(String autor) {
        Autor = autor;
    }
    public int getPrecio() {
        return Precio;
    }
    public void setPrecio(int precio) {
        Precio = precio;
    }
    public Double getId() {
        return id;
    }
    public void setId(Double id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Biblioteca [Titulo=" + Titulo + ", Autor=" + Autor + ", Precio=" + Precio + ", id=" + id + "]";
    }

}