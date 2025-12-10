/* Crie uma classe Carro com atributos modelo, ano, cor e métodos para exibir a ficha técnica e calcular a idade do carro. */
public class Carro {
    String modelo;
    int ano;
    String cor;

    void exibeFichaTecnica() {
        System.out.println("----- Carro -----");
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Cor: " + cor);
    }

    int calculaIdade() {
        return 2023 - ano;
    }
}
