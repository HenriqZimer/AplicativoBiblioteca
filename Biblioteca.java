import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeLivros gerenciadorDeLivros = new GerenciadorDeLivros(scanner);
        GerenciadorDeUsuarios gerenciadorDeUsuarios = new GerenciadorDeUsuarios(scanner);
        GerenciadorDeEmprestimos gerenciadorDeEmprestimos = new GerenciadorDeEmprestimos(scanner, gerenciadorDeUsuarios,
                gerenciadorDeLivros);

        int opcao;
        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Gerenciar Livros");
            System.out.println("2. Gerenciar Usuários");
            System.out.println("3. Gerenciar Empréstimos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerenciadorDeLivros.menuGerenciamento();
                    break;
                case 2:
                    gerenciadorDeUsuarios.menuGerenciamento();
                    break;
                case 3:
                    gerenciadorDeEmprestimos.menuGerenciamento();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
