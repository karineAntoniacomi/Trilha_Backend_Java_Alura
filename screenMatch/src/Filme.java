public class Filme {

    // Atributos da Classe
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double somaAvaliacoes;
    int totalDeAvaliacoes;
    int duracaoEmMinutos;

    // Comportamentos da Classe
    void exibeFichaTecnica() {
        System.out.println("Nome do Filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    void avalia(double nota) {
        somaAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    double retornaMedia() {
        return somaAvaliacoes / totalDeAvaliacoes;
    }
}
