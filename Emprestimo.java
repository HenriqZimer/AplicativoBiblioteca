import java.time.LocalDate;

public class Emprestimo {
  private Usuario usuario;
  private Livro livro;
  private LocalDate dataEmprestimo;
  private LocalDate dataDevolucao;
  private boolean devolvido;

  public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
    this.usuario = usuario;
    this.livro = livro;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucao = dataDevolucao;
    this.devolvido = false;
  }

  // Getters e setters
  public Usuario getUsuario() {
    return usuario;
  }

  public Livro getLivro() {
    return livro;
  }

  public LocalDate getDataEmprestimo() {
    return dataEmprestimo;
  }

  public LocalDate getDataDevolucao() {
    return dataDevolucao;
  }

  public boolean isDevolvido() {
    return devolvido;
  }

  public void setDevolvido(boolean devolvido) {
    this.devolvido = devolvido;
  }
}
