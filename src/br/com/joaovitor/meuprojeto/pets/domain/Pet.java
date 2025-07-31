package br.com.joaovitor.meuprojeto.pets.domain;

public class Pet {
    private String nome;
    private TipoPet tipoPet;
    private SexoPet sexoPet;
    private String endereco;
    private double idade;
    private double peso;
    private String raca;
    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    @Override
    public String toString() {
        return "Pet{" +
                "nome='" + nome + '\'' +
                ", tipoPet=" + tipoPet +
                ", sexoPet=" + sexoPet +
                ", endereco='" + endereco + '\'' +
                ", idade=" + idade + " anos" +
                ", peso=" + peso + " kg" +
                ", raca='" + raca + '\'' +
                '}';
    }

    public Pet() {
    }

    public String getTodosAtributos(){
        return (nome + " - " + tipoPet + " - " + sexoPet + " - " + endereco + " - " + idade + " anos" + " - " + peso + " kg"+ " - " + raca).toLowerCase();
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoPet(TipoPet tipoPet) {
        this.tipoPet = tipoPet;
    }

    public void setSexoPet(SexoPet sexoPet) {
        this.sexoPet = sexoPet;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoPet getTipoPet() {
        return tipoPet;
    }

    public SexoPet getSexoPet() {
        return sexoPet;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }
}
