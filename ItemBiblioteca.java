public abstract class ItemBiblioteca {
  protected String titulo;
  protected String isbn;

  public ItemBiblioteca(String titulo, String isbn) {
    this.titulo = titulo;
    this.isbn = isbn;
  }

  // Getters
  public String getTitulo() {
    return titulo;
  }

  public String getIsbn() {
    return isbn;
  }

  // Setters
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}
