import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listarContas() {
        for (Conta conta : contas) {
            conta.imprimirExtrato();
            System.out.println("--------------------------");
        }
    }

    public Conta buscarContaPorCpf(String cpf) {
        return contas.stream()
            .filter(c -> c.cliente.getCpf().equals(cpf))
            .findFirst()
            .orElse(null);
    }
}