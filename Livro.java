public class Livro extends ItemBiblioteca {
    private String autor;
    private String categoria;
    private int copias;

    public Livro(String titulo, String isbn, String autor, String categoria, int copias) {
        super(titulo, isbn); // Primeiro chama o construtor da classe base
        this.autor = autor;
        this.categoria = categoria;
        this.copias = copias;
    }

    // Getters e setters
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "título='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", categoria='" + categoria + '\'' +
                ", cópias=" + copias +
                '}';
    }
}
