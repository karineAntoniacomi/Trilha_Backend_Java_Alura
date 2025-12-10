import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Atividade1 {
    public static void main(String[] args) {

        /* Crie um programa que solicite ao usuário digitar um número. Se o número for positivo, exiba "Número positivo", caso contrário, exiba "Número negativo". */
        Scanner sc = new Scanner(System.in);

        int numero = 0;
        System.out.println("Digite um número: ");
        numero = sc.nextInt();

        if (numero > 0) {
            System.out.println("Número positivo");
        } else if (numero < 0) {
            System.out.println("Número negativo");
        } else {
            System.out.println();
        }
        sc.close();
    }
}