public class Main {

    public static void main(String[] args) {

        System.out.println("Esse é o Screen Match");
        System.out.println("Filme: Top Gun Maverick");

        int anoDeLancamento = 2022;
        System.out.println("Ano de Lançamento: " + anoDeLancamento);

        boolean incluidoNoPlano = true;
        double notaDoFilme = 8.1;

        // Média das 3 notas do filme
        double media = (9.8 + 6.3 + 8.0) / 3;
        System.out.println(media);
        String sinopse;
        // String representada por Text Block com 3 aspas duplas para delimitar o texto
        sinopse = """
                Filme Top Gun
                Filme de aventura com galã dos anos 80
                Muito bom!
                """ + anoDeLancamento;
        System.out.println(sinopse);

        int classificacao;
        classificacao = (int) (media / 2); // Casting Explícito
        System.out.println(classificacao);


    }
}