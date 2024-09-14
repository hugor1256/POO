import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SistemaBiblioteca {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1. Listar livros emprestados");
            System.out.println("2. Cadastrar empréstimo");
            System.out.println("3. Cadastrar novo livro");
            System.out.println("4. Listar acervo de livros");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    if (biblioteca.getEmprestimos().isEmpty()) {
                        System.out.println("Não há livros emprestados no momento.");
                    } else {
                        biblioteca.listarLivrosEmprestados();
                    }
                    break;

                case 2:
                    String cpfCliente;
                    while (true) {
                        System.out.print("CPF do cliente (somente números): ");
                        cpfCliente = scanner.nextLine();
                        if (cpfCliente.matches("\\d{11}")) {
                            cpfCliente = cpfCliente.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
                            break;
                        } else {
                            System.out.println("CPF inválido. Por favor, insira um CPF válido com 11 dígitos.");
                        }
                    }

                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    Usuario usuario = new Usuario(nomeCliente, cpfCliente, 0);

                    System.out.print("Nome do livro: ");
                    String nomeLivro = scanner.nextLine();
                    System.out.print("Autor do livro: ");
                    String autorLivro = scanner.nextLine();
                    System.out.print("ISBN do livro: ");
                    String isbnLivro = scanner.nextLine();

                    int anoPublicacao;
                    while (true) {
                        System.out.print("Ano de publicação: ");
                        String ano = scanner.nextLine();
                        if (ano.matches("\\d{4}")) {
                            anoPublicacao = Integer.parseInt(ano);
                            break;
                        } else {
                            System.out.println("Ano de publicação inválido. Por favor, insira um ano com 4 dígitos.");
                        }
                    }

                    System.out.print("Conservação do livro: ");
                    String conservacaoLivro = scanner.nextLine();

                    Livro livro = new Livro(nomeLivro, autorLivro, isbnLivro, anoPublicacao, conservacaoLivro);

                    LocalDate dataEmprestimo;
                    while (true) {
                        try {
                            System.out.print("Data de empréstimo: ");
                            String dataEmprestimoStr = scanner.nextLine();
                            dataEmprestimo = LocalDate.parse(dataEmprestimoStr.replace("/", "-"), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Data de empréstimo inválida. Por favor, insira no formato dd-mm-aaaa.");
                        }
                    }

                    LocalDate dataDevolucao;
                    while (true) {
                        try {
                            System.out.print("Data de devolução: ");
                            String dataDevolucaoStr = scanner.nextLine();
                            dataDevolucao = LocalDate.parse(dataDevolucaoStr.replace("/", "-"), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Data de devolução inválida. Por favor, insira no formato dd-mm-aaaa.");
                        }
                    }

                    Emprestimo emprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
                    biblioteca.adicionarEmprestimo(emprestimo);
                    emprestimo.realizarEmprestimo();
                    break;

                case 3:
                    System.out.print("Nome do livro: ");
                    String nomeNovoLivro = scanner.nextLine();
                    System.out.print("Autor do livro: ");
                    String autorNovoLivro = scanner.nextLine();
                    System.out.print("ISBN do livro: ");
                    String isbnNovoLivro = scanner.nextLine();

                    int anoNovoLivro;
                    while (true) {
                        System.out.print("Ano de publicação : ");
                        String ano = scanner.nextLine();
                        if (ano.matches("\\d{4}")) {
                            anoNovoLivro = Integer.parseInt(ano);
                            break;
                        } else {
                            System.out.println("Ano de publicação inválido. Por favor, insira um ano com 4 dígitos.");
                        }
                    }

                    System.out.print("Conservação do livro: ");
                    String conservacaoNovoLivro = scanner.nextLine();

                    Livro novoLivro = new Livro(nomeNovoLivro, autorNovoLivro, isbnNovoLivro, anoNovoLivro, conservacaoNovoLivro);
                    biblioteca.adicionarLivro(novoLivro);
                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 4:
                    if (biblioteca.getAcervo().isEmpty()) {
                        System.out.println("O acervo da biblioteca está vazio.");
                    } else {
                        biblioteca.listarAcervo();
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}
