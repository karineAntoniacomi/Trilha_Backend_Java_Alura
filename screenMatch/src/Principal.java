import br.com.alura.screenMatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenMatch.calculos.FiltroRecomendacao;
import br.com.alura.screenMatch.modelos.Episodio;
import br.com.alura.screenMatch.modelos.Filme;
import br.com.alura.screenMatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {

        Filme favorito = new Filme();
        favorito.setNome("O Senhor dos Anéis");
        favorito.setAnoDeLancamento(2002);
        favorito.setDuracaoEmMinutos(210);
        favorito.setIncluidoNoPlano(true);
        System.out.println("Duração para assistir " + favorito.getNome() + ": " + favorito.getDuracaoEmMinutos());
        favorito.exibeFichaTecnica();
        favorito.exibeFichaTecnica();
        favorito.avalia(8);
        favorito.avalia(5);
        favorito.avalia(10);
        System.out.println("Total de avaliações: " + favorito.getTotalDeAvaliacoes());
        System.out.println(favorito.calculaMedia());

        Filme outro = new Filme();
        outro.setNome("Wicked");
        outro.setAnoDeLancamento(2025);
        outro.setDuracaoEmMinutos(180);
        System.out.println("Duração para assistir " + outro.getNome() + ": " + outro.getDuracaoEmMinutos());
        outro.exibeFichaTecnica();
        outro.exibeFichaTecnica();
        outro.avalia(8);
        outro.avalia(5);
        outro.avalia(10);
        System.out.println("Total de avaliações: " + outro.getTotalDeAvaliacoes());
        System.out.println(outro.calculaMedia());

        Serie serie = new Serie();
        serie.setNome("Vikings");
        serie.setAnoDeLancamento(2014);
        serie.setIncluidoNoPlano(true);
        serie.setAtiva(true);
        serie.exibeFichaTecnica();
        serie.setTemporadas(6);
        serie.setEpisodiosPorTemporada(22);
        serie.setMinutosPorEpisodio(45);
        System.out.println("Duração para maratonar " + serie.getNome() + ": " + serie.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(favorito);
        calculadora.inclui(outro);
        calculadora.inclui(serie);
        System.out.println("Tempo total: " + calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(favorito);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(serie);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);
    }
}