import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nome = "Maria Santos";
        String tipoConta = "Corrente";
        double saldo = 3500.05;
        int opcao = 0;

        System.out.println("\n------------------------------");
        System.out.println("Nome do clinete: " + nome);
        System.out.println("Tipo da conta: " + tipoConta);
        System.out.println("Saldo atual: " + saldo);
        System.out.println("------------------------------\n");

        String menu = """
                Digite sua opção:
                1. Consultar Saldo
                2. Tranferir Valor
                3. Receber Valor
                4. Sair
                """;

        while (opcao != 4) {
            System.out.println(menu);
            opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.println("O saldo atualizado é: " + saldo);
            } else if (opcao == 2) {
                System.out.println("Qual o valor da tranferência? ");
                double valorTransf = sc.nextDouble();
                if (valorTransf > saldo) {
                    System.out.println("Não há saldo suficiente para realizar a tranferência.");
                } else {
                    saldo -= valorTransf;
                    System.out.println("O saldo atualizado é: " + saldo);
                }
            } else if (opcao == 3) {
                System.out.println("Valor recebido: ");
                double valorRecebido = sc.nextDouble();
                saldo += valorRecebido;
                System.out.println("O saldo atualizado é: " + saldo);
            } else if (opcao == 4) {
                System.out.println("Opção inválida");
            }
        }
        sc.close();
    }
}