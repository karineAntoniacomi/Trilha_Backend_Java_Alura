import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Crie um programa que simula um jogo de adivinhação, que deve gerar um número aleatório entre 0 e 100 e pedir para que
         o usuário tente adivinhar o número, em até 5 tentativas. A cada tentativa, o programa deve informar se o número
          digitado pelo usuário é maior ou menor do que o número gerado.
        Dicas:
        Para gerar um número aleatório em Java: new Random().nextInt(100);
        Utilize o Scanner para obter os dados do usuário;
        Utilize uma variável para contar as tentativas;
        Utilize um loop para controlar as tentativas;
        Utilize a instrução break; para interromper o loop.*/

        Scanner sc = new Scanner(System.in);

        int numeroAleatorio = new Random().nextInt(100);
        int numero = 0;
        int tentativa = 0;

        System.out.println("\n--- Jogo de Adivinhação ---");
        System.out.println("Tente adivinhar o número (de 1 a 100): ");

        while (tentativa < 5) {
            numero = sc.nextInt();

            if (numero > numeroAleatorio) {
                System.out.println("O número é menor.");
            } else if (numero < numeroAleatorio) {
                System.out.println("O número é maior.");
            } else {
                System.out.println("Acertou!");
                break;
            }
            tentativa++;
        }
        if (tentativa == 5 && numero != numeroAleatorio) {
            System.out.println("\nAs 5 tentativas foram excediadas e você não acertou. O número aleatório correto era: " + numeroAleatorio);
        }
    }
}