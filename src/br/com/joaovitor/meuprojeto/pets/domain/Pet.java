package br.com.joaovitor.meuprojeto.pets.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pet {
    String nome;
    TipoPet tipoPet;
    SexoPet sexoPet;
    String endereco;
    int idade;
    double peso;
    String raca;


    public Pet() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        // isso aqui pode virar um metodo para verificar se contém somente letras
        String regex = "[a-zA-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nome);
        Boolean matcherCheck = matcher.find();

        if (matcherCheck){
            this.nome = nome;
        } else {
            throw new RuntimeException();
        }
    }

    public void setTipoPet(TipoPet tipoPet) {
        this.tipoPet = tipoPet;
    }

    public void setSexoPet(SexoPet sexoPet) {
        this.sexoPet = sexoPet;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
