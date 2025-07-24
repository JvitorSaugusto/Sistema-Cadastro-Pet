package br.com.joaovitor.meuprojeto.pets.domain;

import br.com.joaovitor.meuprojeto.main.MainTest;

import java.util.List;

public class PetRegister {
    public Pet petRegister(List<String> listaRespostas){
        Pet pet = new Pet();
        pet.setNome(listaRespostas.get(0));
        pet.setTipoPet(TipoPet.valueOf(listaRespostas.get(1)));
        pet.setSexoPet(SexoPet.valueOf(listaRespostas.get(2)));
        return pet;
    }
}
