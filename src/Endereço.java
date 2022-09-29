public class Endereço {
    private String nomeRua;
    private String nomeBairro;
    private int numeroRua;
    private String nomeEstado;
    private String nomeCidade;

    public Endereço(String nomeRua, String nomeBairro, int numeroRua, String nomeEstado, String nomeCidade){

        this.nomeRua = nomeRua;
        this.nomeBairro = nomeBairro;
        this.numeroRua = numeroRua;
        this.nomeEstado = nomeEstado;
        this.nomeCidade = nomeCidade;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public int getNumeroRua() {
        return numeroRua;
    }

    public void setNumeroRua(int numeroRua) {
        this.numeroRua = numeroRua;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }


}
