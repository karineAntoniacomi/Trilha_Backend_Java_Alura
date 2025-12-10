public class Condicional {
    public static void main(String[] args) {

        int anoDeLancamento = 2022;
        boolean incluidoNoPlano = true;
        double notaDoFilme = 8.1;
        String tpoPlano = "plus";

        if (anoDeLancamento >= 22022) {
            System.out.println("Lançamento que os clientes estao curtindo!");
        } else {
            System.out.println("Filme retrõ que vale a pena asssistir!");
        }

        // Condicionais: || = OU - && = E - NOT
        if (incluidoNoPlano && tpoPlano.equals("plus")) {
            System.out.println("Filme liberado");
        } else {
            System.out.println("Deve pagar a locação");
        }
    }
}

