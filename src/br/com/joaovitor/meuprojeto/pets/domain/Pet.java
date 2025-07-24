package br.com.joaovitor.meuprojeto.pets.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pet {
    String nome;
    TipoPet tipoPet;
    SexoPet sexoPet;
    //endereço
    int idade;
    double peso;
    String raca;


    public Pet() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
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
}
