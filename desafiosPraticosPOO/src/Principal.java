public class Principal {
    public static void main(String[] args) {

        // Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.saudacao();

        // Calculadora
        System.out.println();
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.dobrarNumero(15);
        System.out.println(resultado);

        // Música
        System.out.println();
        Musica minhaMusica = new Musica();

        minhaMusica.titulo = "A Celebration the Death of the Man";
        minhaMusica.artista = "Agalloch";
        minhaMusica.anoLancamento = 2016;

        minhaMusica.exibeFichaTecnica();

        minhaMusica.avaliar(5.0);
        minhaMusica.avaliar(3.5);
        minhaMusica.avaliar(4.0);

        double mediaAvaliacoes = minhaMusica.retornaMedia();
        System.out.printf("Média das Avaliações: %.2f%n", mediaAvaliacoes);

        // Carro
        System.out.println();
        Carro meuCarro = new Carro();
        meuCarro.modelo = "Ford Ka";
        meuCarro.ano = 2012;
        meuCarro.cor = "Vermelho";

        // Exibir ficha técnica
        meuCarro.exibeFichaTecnica();

        // Calcular idade do carro
        System.out.println("Idade do carro: " + meuCarro.calculaIdade() + " anos");

        // Aluno
        System.out.println();
        Aluno meuAluno = new Aluno();
        meuAluno.nome = "João de Lima";
        meuAluno.idade = 24;

        meuAluno.exibeInformacoes();
    }
}
