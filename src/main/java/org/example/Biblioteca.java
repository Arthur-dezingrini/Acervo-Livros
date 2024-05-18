package org.example;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    List<Livro> acervo = new ArrayList<Livro>();

    public String adicionarLivro(Livro livro) {
        try{
            acervo.add(livro);
            return "Livro adicionado com sucesso!";
        } catch (Exception e) {
            return "Erro ao adicionar livro! erro: " + e.getMessage();
        }
    }

    public String removerLivro (String titulo) {
        try {
            Livro livroRemover = BuscaLivroPeloTitulo(titulo);
            acervo.remove(livroRemover);
            return "Livro removido com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover livro! erro: " + e.getMessage();
        }
    }

    public Livro BuscaLivroPeloTitulo (String titulo) {
        Livro livroEncontrado = acervo.stream().filter(livro -> titulo.equals(livro.getTitulo())).findFirst().get();
        return livroEncontrado;
    }

    public List<Livro> ListarTodosLivros () {
        return acervo;
    }
}
