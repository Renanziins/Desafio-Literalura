package br.com.literalura.controller;

import br.com.literalura.model.Livro;
import br.com.literalura.service.LivroService;

import java.util.List;
import java.util.Scanner;

public class CatalogoController {

    private final LivroService livroService = new LivroService();
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        boolean executando = true;

        while (executando) {
            System.out.println("\n----- Catálogo de Livros -----");
            System.out.println("1 - Listar todos os livros");
            System.out.println("2 - Buscar livros por autor");
            System.out.println("3 - Filtrar livros por ano (ano de nascimento do autor)");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> listarLivros();
                case 2 -> buscarPorAutor();
                case 3 -> filtrarPorAno();
                case 4 -> {
                    executando = false;
                    System.out.println("Programa finalizado.");
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void listarLivros() {
        List<Livro> livros = livroService.buscarLivros().getResults();
        livros.forEach(l -> System.out.println(
                l.getTitle() + " - " +
                        (l.getAuthors() != null && !l.getAuthors().isEmpty() ? l.getAuthors().get(0).getName() : "Autor desconhecido")));
    }

    private void buscarPorAutor() {
        System.out.print("Informe o nome do autor: ");
        String autor = scanner.nextLine();
        List<Livro> livros = livroService.buscarLivros().getResults();
        livros.stream()
                .filter(l -> l.getAuthors() != null && l.getAuthors().stream()
                        .anyMatch(a -> a.getName().toLowerCase().contains(autor.toLowerCase())))
                .forEach(l -> System.out.println(l.getTitle()));
    }

    private void filtrarPorAno() {
        System.out.print("Informe o ano de nascimento do autor: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        List<Livro> livros = livroService.buscarLivros().getResults();
        livros.stream()
                .filter(l -> l.getAuthors() != null && l.getAuthors().stream()
                        .anyMatch(a -> a.getBirth_year() != null && a.getBirth_year() == ano))
                .forEach(l -> System.out.println(l.getTitle() + " - " + l.getAuthors().get(0).getName()));
    }
}
