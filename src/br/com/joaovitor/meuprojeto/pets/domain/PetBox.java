package br.com.joaovitor.meuprojeto.pets.domain;

import java.util.ArrayList;
import java.util.List;

public class PetBox {
    private static final List<Pet> listaDePets = new ArrayList<>();

    public static void guardaPet(List<String> atributos){
        listaDePets.add(PetRegister.petRegister(atributos));
    }

    public static List<Pet> getListaDePets(){
        return listaDePets;
    }
}
