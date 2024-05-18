package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opc = -1;
        while (opc != 0) {
            System.out.println("Opções:");
            System.out.println("1 - Adicionar um livro novo ao acervo");
            System.out.println("2 - Listar todos os livros do acervo");
            System.out.println("3 - Pesquisar um livro no acervo pelo título");
            System.out.println("4 - Remover um livro do acervo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    adicionaLivro(sc, biblioteca);
                    break;
                case 2:
                    listarLivros(biblioteca);
                    break;
                case 3:
                    pesquisarLivro(sc, biblioteca);
                    break;
                case 4:
                    removerLivro(sc, biblioteca);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    public static void adicionaLivro(Scanner sc, Biblioteca biblioteca) {
        System.out.print("Digite o título do livro: ");
        String titulo = sc.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = sc.nextLine();
        System.out.print("Digite o ano de publicação do livro: ");
        int anoPublicacao = sc.nextInt();
        System.out.print("Digite o número de páginas do livro: ");
        int numeroPagina = sc.nextInt();
        sc.nextLine();



        if (titulo.isEmpty()) {
            System.out.println("Não é permitido cadastrar um livro sem Título");
        } else if (autor.isEmpty()) {
            System.out.println("Não é permitido cadastrar um livro sem Autor");
        } else if (biblioteca.acervo.isEmpty()) {
            System.out.println(biblioteca.adicionarLivro(new Livro(titulo, autor, anoPublicacao, numeroPagina)));
        } else if (biblioteca.BuscaLivroPeloTitulo(titulo) != null) {
            System.out.println("Livro com título já existente");
        } else {
            System.out.println(biblioteca.adicionarLivro(new Livro(titulo, autor, anoPublicacao, numeroPagina)));
        }
    }

    public static void listarLivros(Biblioteca biblioteca) {
        List<Livro> livros = biblioteca.ListarTodosLivros();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro na biblioteca");
            return;
        }
        livros.forEach(livro -> System.out.println(livro));
    }

    public static void pesquisarLivro(Scanner sc, Biblioteca biblioteca) {
        System.out.print("Digite o título do livro a ser pesquisado: ");
        String titulo = sc.nextLine();
        var livro =  biblioteca.BuscaLivroPeloTitulo(titulo) != null ? biblioteca.BuscaLivroPeloTitulo(titulo) : "Nenhum livro encontrado com esse titulo";

        System.out.println(livro);
    }

    public static void removerLivro(Scanner sc, Biblioteca biblioteca) {
        System.out.print("Digite o título do livro a ser removido: ");
        String titulo = sc.nextLine();

        System.out.println(biblioteca.removerLivro(titulo));
    }
}