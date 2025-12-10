import java.util.Scanner;

public class Atividade2 {
    public static void main(String[] args) {

        /* Peça ao usuário para inserir dois números inteiros. Compare os números e imprima uma mensagem indicando se são iguais, diferentes, o primeiro é maior ou o segundo é maior. */
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite dois números inteiros: ");
        int numInt1 = sc.nextInt();
        int numInt2 = sc.nextInt();

        if (numInt1 == numInt2) {
            System.out.println("Os números são iguais.");
        } else if (numInt1 > numInt2) {
            System.out.println("O primeiro número é maior.");
        } else {
            System.out.println("O segundo número é maior.");
        }
        sc.close();
    }
}
