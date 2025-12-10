import java.util.Scanner;

public class Atividade4 {
    public static void main(String[] args) {
        /* Crie um programa que solicite ao usuário um número e exiba a tabuada desse número de 1 a 10. */
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int numero = sc.nextInt();

        System.out.println("Tabuada do " + numero + ":");
        for (int i = 0; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
        sc.close();
    }
}
