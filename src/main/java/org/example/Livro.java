package org.example;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numeroPagina;

    public Livro(String titulo, String autor, int anoPublicacao, int numeroPagina) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numeroPagina = numeroPagina;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    @Override
    public String toString() {
        return "Livro:\n" +
                "Título: " + getTitulo() + "\n" +
                "Autor: " + getAutor() + "\n" +
                "Ano de Publicação: " + getAnoPublicacao() + "\n" +
                "Número de Páginas: " + getNumeroPagina() + "\n";
    }
}



