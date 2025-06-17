public class Main {
    public static void main(String[] args) {
        Cliente maria = new Cliente("Maria Silva", "123.456.789-00", "maria@email.com");
        Conta cc = new ContaCorrente(maria);
        Conta poupanca = new ContaPoupanca(maria);

        cc.depositar(1000);
        cc.transferir(300, poupanca);

        Banco banco = new Banco("Banco DIO");
        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        banco.listarContas();

        // Exemplo de bloqueio e operação inválida
        cc.bloquear();
        try {
            cc.sacar(100);
        } catch (Exception e) {
            System.out.println("Erro ao sacar: " + e.getMessage());
        }
    }
}
