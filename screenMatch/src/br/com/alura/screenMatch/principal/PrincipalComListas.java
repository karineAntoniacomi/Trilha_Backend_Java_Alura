package br.com.alura.screenMatch.principal;

import br.com.alura.screenMatch.modelos.Filme;
import br.com.alura.screenMatch.modelos.Serie;
import br.com.alura.screenMatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {

        Filme favorito = new Filme("O Senhor dos Anéis", 2002);
        favorito.avalia(9);

        Filme outro = new Filme("Wicked", 2025);
        outro.avalia(6);

        var filmeDaKarine = new Filme("Um filme qualquer", 2013);
        filmeDaKarine.avalia(10);

        Serie serie = new Serie("Vikings", 2014);

        // Título é o tipo mais genérico, permitindo criar listas de Filmes ou de Séries
        //List<Titulo> lista = new LinkedList<>();
        List<Titulo> lista = new ArrayList<>();
        lista.add(filmeDaKarine);
        lista.add(outro);
        lista.add(favorito);
        lista.add(serie);

        // foreach forma compacta com expressão lambda
        lista.forEach(item -> System.out.println("(forEach novo) " + item));

        // Method Reference - forma reduzida da expressão lambda
        lista.forEach(System.out::println);

        // laço foreach tradicional
        for (Titulo item : lista) {
            System.out.println(item.getNome());
            // instanceof = verifica se um objeto é de um determinado tipo
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: (forEach antigo) " + filme.getClassificacao());
            }
        }

        // Objeto referencia (ponteiro) - não cria objeto novo, mas se refere ao mesmo objeto, alterações na referencia refletem no obj original
        Filme ref = filmeDaKarine;

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo Silveira");
        buscaPorArtista.add("Maria");

        System.out.println(buscaPorArtista);

        // Ordenando a Lista com Collections Comparable - ordem alfabética
        Collections.sort(buscaPorArtista);
        System.out.println("Ordenando por artista com Comparable: ");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de Títulos ordenados: ");
        Collections.sort(lista);
        System.out.println(lista);

        // Comparator
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano com Comparator: ");
        System.out.println(lista);
    }
}
