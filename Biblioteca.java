import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> acervo;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        acervo.add(livro);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void listarAcervo() {
        System.out.println("Acervo da Biblioteca:");
        for (Livro livro : acervo) {
            System.out.println(livro);
        }
    }

    public void listarLivrosEmprestados() {
        System.out.println("Livros Emprestados:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }

    public List<Livro> getAcervo() {
        return acervo;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
