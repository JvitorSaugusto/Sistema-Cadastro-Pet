package br.com.joaovitor.meuprojeto.pets.domain;

import java.util.ArrayList;
import java.util.List;

public class PetBox {
    private static final List<Pet> listaDePets = new ArrayList<>();

    public static void guardaPet(List<String> atributos){
        listaDePets.add(PetRegister.petRegister(atributos));
    }

    public static void guardaPetAtualizado(Pet pet){
        listaDePets.add(pet);
    }

    public static void removerPetDaBox(Pet pet){
        listaDePets.remove(pet);
    }

    public static List<Pet> getListaDePets(){
        return listaDePets;
    }
}
