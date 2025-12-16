public class Principal {
    public static void main(String[] args) {

        // Conta Bancária
        ContaBancaria conta = new ContaBancaria();
        conta.setNumeroConta(2468);
        conta.setSaldo(5000);
        conta.titular = "Maria Aparecida";

        System.out.println();
        System.out.println("--- Conta Bancária ---");
        System.out.println("Número da Conta: " + conta.getNumeroConta());
        System.out.println("Saldo da conta: " + conta.getSaldo());
        System.out.println("Nome do Titular: " + conta.titular);

        conta.setSaldo(1500);
        System.out.println("Novo Saldo: " + conta.getSaldo());

        // Idade Pessoa
        System.out.println();
        System.out.println("--- Idade ---");
        IdadePessoa pessoa1 = new IdadePessoa();
        pessoa1.setNome("Marcia Pereira");
        pessoa1.setIdade(27);

        IdadePessoa pessoa2 = new IdadePessoa();
        pessoa2.setNome("João Silva");
        pessoa2.setIdade(20);

        System.out.println(pessoa1.getNome() + " tem " + pessoa1.getIdade() + " anos de idade.");
        pessoa1.verificarIdade();

        System.out.println(pessoa2.getNome() + " tem " + pessoa2.getIdade() + " anos de idade.");
        pessoa2.verificarIdade();

        // Produto
        System.out.println();
        System.out.println("--- Produto ---");
        Produto produto = new Produto("Arroz", 10.0);

        System.out.println("Nome do Produto: " + produto.getNome());
        System.out.println("Preço do Produto: " + produto.getPreco());

        produto.aplicarDesconto(10);
        System.out.println("Novo Preço após Desconto: " + produto.getPreco());

        // Aluno
        System.out.println();
        System.out.println("--- Aluno ---");
        Aluno aluno1 = new Aluno("Eduarda Ferreira", 9.5, 7.0);
        Aluno aluno2 = new Aluno("Lucas Campos", 3.2, 7.5);

        System.out.println("Aluno 1:");
        System.out.println("Nome: " + aluno1.getNome());
        System.out.println("Nota 1: " + aluno1.getNota1());
        System.out.println("Nota 2: " + aluno1.getNota2());
        System.out.println("Média: " + aluno1.calcularMedia());
        System.out.println();

        System.out.println("Aluno 2:");
        System.out.println("Nome: " + aluno2.getNome());
        System.out.println("Nota 1: " + aluno2.getNota1());
        System.out.println("Nota 2: " + aluno2.getNota2());
        System.out.println("Média: " + aluno2.calcularMedia());

        // Livro
        System.out.println();
        System.out.println("--- Livro ---");
        Livro livro1 = new Livro();
        livro1.setTitulo("O Senhor dos Anéis");
        livro1.setAutor("J.R.R. Tolkien");

        Livro livro2 = new Livro();
        livro2.setTitulo("Design Patterns: Elements of Reusable Object-Oriented");
        livro2.setAutor("Erich Gamma, Richard Helm, Ralph Johnson e John Vlissides");

        livro1.exibirDetalhes();
        livro2.exibirDetalhes();
    }
}