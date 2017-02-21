package udesc.br.cadastropessoas.modelo;

/**
 * Created by 9584013 on 22/09/2016.
 */
public class Pessoa {

    private String nome;
    private String profissao;
    private char sexo;
    private int idade;

    public Pessoa() {}

    public Pessoa(String nome, String profissao, char sexo, int idade) {
        this.nome = nome;
        this.profissao = profissao;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String dadosCompletos() {
        return "Nome: " + nome +
                "\nProfissão: " + profissao +
                "\nSexo: " + sexo +
                "\nIdade: " + idade;
    }

    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
