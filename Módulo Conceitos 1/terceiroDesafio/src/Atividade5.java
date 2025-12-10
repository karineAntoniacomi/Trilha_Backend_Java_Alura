import java.util.Scanner;

public class Atividade5 {
    public static void main(String[] args) {

        /* Crie um programa que solicite ao usuário a entrada de um número inteiro. Verifique se o número é par ou ímpar e exiba uma mensagem correspondente. */
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = sc.nextInt();

        if (numero % 2 == 0) {
            System.out.println("O número é par.");
        } else {
            System.out.println("O número é ímpar.");
        }
        sc.close();
    }
}
