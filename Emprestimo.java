import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public void realizarEmprestimo() {
        System.out.println("Empréstimo realizado:");
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Emprestado para: " + usuario.getNome());
        System.out.println("Data de Empréstimo: " + dataEmprestimo);
        System.out.println("Data de Devolução: " + dataDevolucao);
    }

    @Override
    public String toString() {
        return "Livro: " + livro.getTitulo() + ", Emprestado para: " + usuario.getNome() + ", Data de Empréstimo: " + dataEmprestimo + ", Data de Devolução: " + dataDevolucao;
    }
}
