public class Usuario extends Pessoa {
  private String tipo; // Exemplo: Estudante, Professor, etc.

  public Usuario(String nome, String cpf, String endereco, String telefone, String tipo) {
    super(nome, cpf, endereco, telefone); // Chamada ao construtor da superclasse
    this.tipo = tipo;
  }

  // Getter e setter para 'tipo'
  public String getTipo() {
    return tipo;
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
