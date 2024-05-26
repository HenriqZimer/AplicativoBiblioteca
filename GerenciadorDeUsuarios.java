import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeUsuarios {
  private List<Usuario> usuarios = new ArrayList<>();
  private Scanner scanner;

  public GerenciadorDeUsuarios(Scanner scanner) {
    this.scanner = scanner;
  }

  public void menuGerenciamento() {
    int escolha;
    do {
      System.out.println("\n--- Gerenciamento de Usuários ---");
      System.out.println("1. Adicionar Usuário");
      System.out.println("2. Remover Usuário");
      System.out.println("3. Editar Usuário");
      System.out.println("4. Listar Usuários");
      System.out.println("5. Voltar ao Menu Principal");
      System.out.print("Escolha uma opção: ");
      escolha = scanner.nextInt();

      switch (escolha) {
        case 1:
          adicionarUsuario();
          break;
        case 2:
          removerUsuario();
          break;
        case 3:
          editarUsuario();
          break;
        case 4:
          listarUsuarios();
          break;
        case 5:
          break;
        default:
          System.out.println("Opção inválida! Por favor, tente novamente.");
      }
    } while (escolha != 5);
  }

  private void adicionarUsuario() {
    scanner.nextLine(); // Consume newline left-over
    System.out.print("Digite o nome do usuário: ");
    String nome = scanner.nextLine();
    System.out.print("Digite o CPF do usuário: ");
    String cpf = scanner.nextLine();
    System.out.print("Digite o endereço do usuário: ");
    String endereco = scanner.nextLine();
    System.out.print("Digite o telefone do usuário: ");
    String telefone = scanner.nextLine();
    System.out.print("Digite o tipo de usuário (ex. estudante, professor): ");
    String tipo = scanner.nextLine();
    Usuario novoUsuario = new Usuario(nome, cpf, endereco, telefone, tipo);
    usuarios.add(novoUsuario);
    System.out.println("Usuário adicionado com sucesso!");
  }

  private void removerUsuario() {
    scanner.nextLine(); // Consume newline left-over
    System.out.print("Digite o CPF do usuário que deseja remover: ");
    String cpf = scanner.nextLine();
    Usuario usuarioParaRemover = usuarios.stream()
        .filter(usuario -> usuario.getCpf().equals(cpf))
        .findFirst()
        .orElse(null);

    if (usuarioParaRemover != null) {
      usuarios.remove(usuarioParaRemover);
      System.out.println("Usuário removido com sucesso!");
    } else {
      System.out.println("Usuário não encontrado!");
    }
  }

  private void editarUsuario() {
    scanner.nextLine(); // Consume newline left-over
    System.out.print("Digite o CPF do usuário que deseja editar: ");
    String cpf = scanner.nextLine();
    Usuario usuarioEncontrado = usuarios.stream()
        .filter(usuario -> usuario.getCpf().equals(cpf))
        .findFirst()
        .orElse(null);

    if (usuarioEncontrado != null) {
      System.out.print("Novo nome do usuário (atual: " + usuarioEncontrado.getNome() + "): ");
      usuarioEncontrado.setNome(scanner.nextLine());
      System.out.print("Novo endereço (atual: " + usuarioEncontrado.getEndereco() + "): ");
      usuarioEncontrado.setEndereco(scanner.nextLine());
      System.out.print("Novo telefone (atual: " + usuarioEncontrado.getTelefone() + "): ");
      usuarioEncontrado.setTelefone(scanner.nextLine());
      System.out.print("Novo tipo de usuário (atual: " + usuarioEncontrado.getTipo() + "): ");
      usuarioEncontrado.setTipo(scanner.nextLine());
      System.out.println("Usuário atualizado com sucesso!");
    } else {
      System.out.println("Usuário não encontrado!");
    }
  }

  private void listarUsuarios() {
    if (usuarios.isEmpty()) {
      System.out.println("Nenhum usuário cadastrado.");
    } else {
      for (Usuario usuario : usuarios) {
        System.out.println(usuario);
      }
    }
  }

  public Usuario buscarUsuarioPorCpf(String cpf) {
    for (Usuario usuario : usuarios) {
      if (usuario.getCpf().equals(cpf)) {
        return usuario;
      }
    }
    return null; // Retorna null se não encontrar o usuário
  }

}
