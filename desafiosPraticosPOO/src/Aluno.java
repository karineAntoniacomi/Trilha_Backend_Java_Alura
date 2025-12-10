/* Crie uma classe Aluno com atributos nome, idade, e um métod para exibir informações. Crie uma instância da classe Aluno, atribua valores aos seus atributos e utilize o métod para exibir as informações. */
public class Aluno {
    String nome;
    int idade;

    void exibeInformacoes() {
        System.out.println("----- Aluno -----");
        System.out.println("Nome do aluno: " + nome);
        System.out.println("Idade do aluno: " + idade);
    }
}
