public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private String conservacao;

    public Livro(String titulo, String autor, String isbn, int anoPublicacao, String conservacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.conservacao = conservacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getConservacao() {
        return conservacao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Ano de Publicação: " + anoPublicacao + ", Conservação: " + conservacao;
    }
}
