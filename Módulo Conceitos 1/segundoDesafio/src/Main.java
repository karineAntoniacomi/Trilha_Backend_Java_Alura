//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        double temperaturaEmCelsius = 25;
        double temperaturaEmFahrenheit = (temperaturaEmCelsius * 1.8) + 32;

        String mensagem = String.format("A temperatura de %f Celsius é equivalente a %f em Fahrenheit.", temperaturaEmCelsius, temperaturaEmFahrenheit);
        System.out.println(mensagem);

        int temperaturaFahrenheitInt = (int) temperaturaEmFahrenheit;

        String resultado = """
            A temperatura em Fahrenheit inteira é: %d
            """.formatted(temperaturaFahrenheitInt);

        System.out.println(resultado);
    }
}