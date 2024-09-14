public class Pessoa {
    protected String nome;
    protected String cpf;
    protected int idade;

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome + ", CPF: " + cpf + ", Idade: " + idade);
    }
}
