public class Principal {
    public static void main(String[] args) {

        Filme filme = new Filme();
        filme.nome = "Senhor dos Anéis";
        filme.anoDeLancamento = 2000;
        filme.duracaoEmMinutos = 280;

        filme.exibeFichaTecnica();
        filme.avalia(8);
        filme.avalia(5);
        filme.avalia(10);

        System.out.println(filme.somaAvaliacoes);
        System.out.println(filme.totalDeAvaliacoes);
        System.out.println(filme.retornaMedia());
    }
}
