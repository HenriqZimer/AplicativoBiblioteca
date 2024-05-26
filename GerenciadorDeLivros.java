
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeLivros {
    private List<Livro> livros = new ArrayList<>();
    private Scanner scanner;

    public GerenciadorDeLivros(Scanner scanner) {
        this.scanner = scanner;
    }

    public void menuGerenciamento() {
        int escolha;
        do {
            System.out.println("\n--- Gerenciamento de Livros ---");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Remover Livro");
            System.out.println("3. Editar Livro");
            System.out.println("4. Listar Livros");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    removerLivro();
                    break;
                case 3:
                    editarLivro();
                    break;
                case 4:
                    listarLivros();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, tente novamente.");
            }
        } while (escolha != 5);
    }

    private void adicionarLivro() {
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Digite o ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Digite a categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Digite o número de cópias: ");
        int copias = scanner.nextInt();
        Livro novoLivro = new Livro(titulo, isbn, autor, categoria, copias); // Verifique a ordem dos argumentos
        livros.add(novoLivro);
        System.out.println("Livro adicionado com sucesso!");
    }

    private void removerLivro() {
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Digite o ISBN do livro que deseja remover: ");
        String isbn = scanner.nextLine();
        Livro livroParaRemover = livros.stream()
                .filter(livro -> livro.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);

        if (livroParaRemover != null) {
            livros.remove(livroParaRemover);
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    private void editarLivro() {
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Digite o ISBN do livro que deseja editar: ");
        String isbn = scanner.nextLine();
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                System.out.print("Novo título do livro (atual: " + livro.getTitulo() + "): ");
                livro.setTitulo(scanner.nextLine());
                System.out.print("Novo autor do livro (atual: " + livro.getAutor() + "): ");
                livro.setAutor(scanner.nextLine());
                System.out.print("Nova categoria (atual: " + livro.getCategoria() + "): ");
                livro.setCategoria(scanner.nextLine());
                System.out.print("Novo número de cópias (atual: " + livro.getCopias() + "): ");
                livro.setCopias(scanner.nextInt());
                System.out.println("Livro atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }

    private void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public Livro buscarLivroPorIsbn(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null; // Retorna null se não encontrar o livro
    }
}
