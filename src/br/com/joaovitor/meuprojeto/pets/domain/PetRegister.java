package br.com.joaovitor.meuprojeto.pets.domain;

import java.util.List;

public class PetRegister {
    public static Pet petRegister(List<String> listaRespostas){
        Pet pet = new Pet();
        pet.setNome(listaRespostas.get(0));
        pet.setTipoPet(TipoPet.valueOf(listaRespostas.get(1)));
        pet.setSexoPet(SexoPet.valueOf(listaRespostas.get(2)));
        pet.setEndereco(listaRespostas.get(3));
        pet.setIdade(Double. parseDouble(listaRespostas.get(4)));
        pet.setPeso(Double.parseDouble(listaRespostas.get(5)));
        pet.setRaca(listaRespostas.get(6));
        return pet;
    }
}
