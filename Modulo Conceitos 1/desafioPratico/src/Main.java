//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /* Crie um programa que realize a média de duas notas decimais
         e exiba o resultado. */
        double nota1 = 36.5;
        int nota2 = (int) 68.8;

        /* Declare uma variável do tipo double e uma variável do tipo int.
         Faça o casting da variável double para int e imprima o resultado. */
        double media = (nota1 + nota2) / 2;

        // System.out.println("A Média das duas notas decimais é: " + media);
        System.out.printf("%nA Média das duas notas decimais é: %.2f %n", media);

        /* Declare uma variável do tipo char (letra) e uma variável do tipo String
        (palavra). Atribua valores a essas variáveis e concatene-as em uma mensagem. */
        char letra = 'P';
        String palavra = "Pipa";

        String mensagem = """
                %nA letra é %c de %s
                """.formatted(letra, palavra);
        System.out.println(mensagem);

        /* Declare uma variável do tipo double precoProduto e uma variável do
        tipo int (quantidade). Calcule o valor total multiplicando o preço do
        produto pela quantidade e apresente o resultado em uma mensagem. */
        double precoProduto = 5.60;
        int quantidade = 3;
        double resultado = precoProduto * quantidade;
        System.out.printf("O preço do produto é: %.2f %n", resultado);

    /* Declare uma variável do tipo double valorEmDolares. Atribua um valor em dólares a essa variável. Considere que o valor de 1 dólar é equivalente a 4.94 reais. Realize a conversão do valor em dólares para reais e imprima o resultado formatado. */
    double valorEmDolares = 4.94;
    double valorEmReais = 6;
    double valorConvertidoEmReais = valorEmDolares * valorEmReais;

        String conversor = """
                %n----- Convesor de moedas -----
                $%.2f Dólares --> R$%.2f Reais
                """.formatted(valorEmDolares, valorConvertidoEmReais);
        System.out.println(conversor);

    /* Declare uma variável do tipo double precoOriginal. Atribua um valor em reais a essa variável, representando o preço original de um produto. Em seguida, declare uma variável do tipo double percentualDesconto e atribua um valor percentual de desconto ao produto (por exemplo, 10 para 10%). Calcule o valor do desconto em reais, aplique-o ao preço original e imprima o novo preço com desconto. */
    double precoOriginal = 20.0;
    double percentualDesconto = 5;
    double valorDesconto = precoOriginal * (percentualDesconto / 100);

    System.out.println("Preço original: R$" + precoOriginal);
    System.out.println("Desconto: R$" + valorDesconto);
    System.out.printf("Preço com desconto: %.2f", precoOriginal - valorDesconto);

    }
}