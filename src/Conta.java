import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected StatusConta status;
    protected List<String> historico;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.status = StatusConta.ATIVA;
        this.historico = new ArrayList<>();
    }

    protected void verificarStatus() {
        if (status != StatusConta.ATIVA) throw new IllegalStateException("Conta não está ativa.");
    }

    @Override
    public void sacar(double valor) {
        verificarStatus();
        if (valor <= 0) throw new IllegalArgumentException("Valor inválido para saque.");
        if (saldo < valor) throw new IllegalArgumentException("Saldo insuficiente.");
        saldo -= valor;
        registrarOperacao(TipoOperacao.SAQUE, valor);
    }

    @Override
    public void depositar(double valor) {
        verificarStatus();
        if (valor <= 0) throw new IllegalArgumentException("Valor inválido para depósito.");
        saldo += valor;
        registrarOperacao(TipoOperacao.DEPOSITO, valor);
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        verificarStatus();
        if (this == contaDestino) throw new IllegalArgumentException("Não é possível transferir para a mesma conta.");
        this.sacar(valor);
        contaDestino.depositar(valor);
        registrarOperacao(TipoOperacao.TRANSFERENCIA, valor);
    }

    protected void registrarOperacao(TipoOperacao tipo, double valor) {
        historico.add(tipo + " de R$" + String.format("%.2f", valor));
    }

    @Override
    public void bloquear() {
        this.status = StatusConta.BLOQUEADA;
        historico.add("Conta bloqueada");
    }

    @Override
    public void encerrar() {
        this.status = StatusConta.ENCERRADA;
        historico.add("Conta encerrada");
    }

    public List<String> getHistorico() {
        return historico;
    }

    public int getAgencia() { return agencia; }
    public int getNumero() { return numero; }
    public double getSaldo() { return saldo; }
    public StatusConta getStatus() { return status; }

    protected void imprimirInfosComuns() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Agência: " + agencia);
        System.out.println("Número: " + numero);
        System.out.println("Saldo: R$ " + String.format("%.2f", saldo));
        System.out.println("Status: " + status);
    }
}
