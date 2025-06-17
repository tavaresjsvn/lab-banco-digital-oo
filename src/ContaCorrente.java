
public class ContaCorrente extends Conta {
	 public ContaCorrente(Cliente cliente) {
	        super(cliente);
	    }

	    @Override
	    public void transferir(double valor, IConta contaDestino) {
	        System.out.println("Transferência via Conta Corrente iniciada...");
	        super.transferir(valor, contaDestino);
	        System.out.println("Transferência concluída com sucesso.");
	    }

	    @Override
	    public void imprimirExtrato() {
	        System.out.println("=== Extrato Conta Corrente ===");
	        super.imprimirInfosComuns();
	        super.getHistorico().forEach(System.out::println);
	    }
}
	
