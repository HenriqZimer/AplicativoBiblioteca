import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeEmprestimos {
  private List<Emprestimo> emprestimos = new ArrayList<>();
  private Scanner scanner;
  private GerenciadorDeUsuarios gerenciadorDeUsuarios;
  private GerenciadorDeLivros gerenciadorDeLivros;

  // Construtor modificado para receber os gerenciadores como parâmetros
  public GerenciadorDeEmprestimos(Scanner scanner, GerenciadorDeUsuarios gerenciadorDeUsuarios,
      GerenciadorDeLivros gerenciadorDeLivros) {
    this.scanner = scanner;
    this.gerenciadorDeUsuarios = gerenciadorDeUsuarios;
    this.gerenciadorDeLivros = gerenciadorDeLivros;
  }

  public void menuGerenciamento() {
    int escolha;
    do {
      System.out.println("\n--- Gerenciamento de Empréstimos ---");
      System.out.println("1. Realizar Empréstimo");
      System.out.println("2. Listar Empréstimos");
      System.out.println("3. Registrar Devolução");
      System.out.println("4. Voltar ao Menu Principal");
      System.out.print("Escolha uma opção: ");
      escolha = scanner.nextInt();

      switch (escolha) {
        case 1:
          realizarEmprestimo();
          break;
        case 2:
          listarEmprestimos();
          break;
        case 3:
          registrarDevolucao();
          break;
        case 4:
          break;
        default:
          System.out.println("Opção inválida! Por favor, tente novamente.");
      }
    } while (escolha != 4);
  }

  private void realizarEmprestimo() {
    scanner.nextLine(); // Consume newline left-over
    System.out.print("Digite o CPF do usuário para o empréstimo: ");
    String cpf = scanner.nextLine();
    Usuario usuario = gerenciadorDeUsuarios.buscarUsuarioPorCpf(cpf);

    if (usuario == null) {
      System.out.println("Usuário não encontrado!");
      return;
    }

    System.out.print("Digite o ISBN do livro a ser emprestado: ");
    String isbn = scanner.nextLine();
    Livro livro = gerenciadorDeLivros.buscarLivroPorIsbn(isbn);

    if (livro == null) {
      System.out.println("Livro não encontrado!");
      return;
    }

    LocalDate hoje = LocalDate.now();
    LocalDate dataDevolucao = hoje.plusWeeks(2); // Define o prazo de devolução como 2 semanas

    Emprestimo novoEmprestimo = new Emprestimo(usuario, livro, hoje, dataDevolucao);
    emprestimos.add(novoEmprestimo);
    System.out.println("Empréstimo realizado com sucesso!");
  }

  private void listarEmprestimos() {
    if (emprestimos.isEmpty()) {
      System.out.println("Nenhum empréstimo registrado.");
    } else {
      for (Emprestimo emprestimo : emprestimos) {
        System.out.println(emprestimo);
      }
    }
  }

  private void registrarDevolucao() {
    scanner.nextLine(); // Consume newline left-over
    System.out.print("Digite o ISBN do livro a ser devolvido: ");
    String isbn = scanner.nextLine();
    Emprestimo emprestimoEncontrado = emprestimos.stream()
        .filter(e -> e.getLivro().getIsbn().equals(isbn) && !e.isDevolvido())
        .findFirst()
        .orElse(null);

    if (emprestimoEncontrado != null) {
      emprestimoEncontrado.setDevolvido(true);
      System.out.println("Devolução registrada com sucesso!");
    } else {
      System.out.println("Empréstimo não encontrado ou livro já devolvido!");
    }
  }

}
