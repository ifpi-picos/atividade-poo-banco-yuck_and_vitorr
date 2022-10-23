public class Cliente {

    private String nome;
    private String cpf;
    private int dataDeNascimento;
    private String endereco;

    public Cliente(String nome, String cpf, int dataDeNascimento, String endereço ){

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

    public int getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getEndereço() {
        return endereco;
    }
    
    
}
