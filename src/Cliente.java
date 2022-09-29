public class Cliente {

    private String nome;
    private int cpf;
    private int dataDeNascimento;
    private String endereço;

    public Cliente(String nome, int cpf, int dataDeNascimento, String endereço ){

        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.endereço = endereço;

    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public int getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getEndereço() {
        return endereço;
    }
    
    
}
