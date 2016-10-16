package udesc.br.cadastropessoas.dados;

import java.util.ArrayList;
import java.util.List;

import udesc.br.cadastropessoas.modelo.Pessoa;

/**
 * Created by 9584013 on 22/09/2016.
 */
public class BaseDados {
    private static List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public static void addPessoa(Pessoa p) {
        pessoas.add(p);
    }

    public static void addPessoa(String nome, String profissao, char sexo, int idade) {
        Pessoa p = new Pessoa(nome, profissao, sexo, idade);
        pessoas.add(p);
    }

    public static List<Pessoa> consultaPessoas() {
        return pessoas;
    }

    public static Pessoa consultaPessoaPosicao(int posicao) {
        return pessoas.get(posicao);
    }
}
