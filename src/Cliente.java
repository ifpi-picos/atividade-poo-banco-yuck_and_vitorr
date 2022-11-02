public class Cliente {

    private String nome;
    private String cpf;
    private String dataDeNascimento;
    private String endereco;

    public Cliente(String nome, String cpf, String dataDeNascimento, String endereço ){

        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereço;

    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getEndereço() {
        return endereco;
    }
    
    
}
