
public class Cliente {

	private String nome;
	private String cpf;
    private String email;
    
    public Cliente(String nome, String cpf, String email) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome inválido.");
        if (cpf == null || cpf.trim().isEmpty()) throw new IllegalArgumentException("CPF inválido.");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("Email inválido.");
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
    

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEmail(String email) { this.email = email; }

}
