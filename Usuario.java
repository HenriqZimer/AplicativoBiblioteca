public class Usuario {
  private String nome;
  private String cpf;
  private String endereco;
  private String telefone;
  private String tipo; // por exemplo, estudante, professor, etc.

  public Usuario(String nome, String cpf, String endereco, String telefone, String tipo) {
    this.nome = nome;
    this.cpf = cpf;
    this.endereco = endereco;
    this.telefone = telefone;
    this.tipo = tipo;
  }

  // Getters
  public String getNome() {
    return nome;
  }

  public String getCpf() {
    return cpf;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getTipo() {
    return tipo;
  }

  // Setters
  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return "Usuario{" +
        "nome='" + nome + '\'' +
        ", cpf='" + cpf + '\'' +
        ", endereco='" + endereco + '\'' +
        ", telefone='" + telefone + '\'' +
        ", tipo='" + tipo + '\'' +
        '}';
  }
}
