package br.com.joaovitor.meuprojeto.menu.methods;

import br.com.joaovitor.meuprojeto.pets.domain.Pet;
import br.com.joaovitor.meuprojeto.pets.domain.PetBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubMenu02 {
    public static List<Pet> listarPetsPorCriterio(Scanner scanner) {
        List<Pet> listaFiltrada01 = new ArrayList<>();
        List<Pet> listaFiltrada02 = new ArrayList<>();
        String confirmacaoSaida;
        while (true) {
            System.out.println("Escolha de 1 a 2 critérios abaixo: ");
            System.out.println("""
                    . Nome ou sobrenome
                    . Tipo
                    . Sexo
                    . Idade
                    . Peso
                    . Raça
                    . Endereço
                    """);

            System.out.println("Digite o primeiro critério: ");
            String criterio01 = scanner.nextLine();
            System.out.println("Digite o segundo critério: ");
            String criterio02 = scanner.nextLine();

            if (!criterio01.isEmpty() && !criterio02.isEmpty()) {
                for (Pet pet : PetBox.getListaDePets()) {
                    String atributosPet = pet.getTodosAtributos();
                    Pattern pattern = Pattern.compile(criterio01);
                    Matcher matcher = pattern.matcher(atributosPet);
                    if (matcher.find()) {
                        listaFiltrada01.add(pet);
                    }
                }
                for (Pet pet : listaFiltrada01) {
                    String atributosPet = pet.getTodosAtributos();
                    Pattern pattern = Pattern.compile(criterio02);
                    Matcher matcher = pattern.matcher(atributosPet);
                    if (matcher.find()) {
                        listaFiltrada02.add(pet);
                    }
                }
            } else if (!criterio01.isEmpty()) {
                for (Pet pet : PetBox.getListaDePets()) {
                    String atributosPet = pet.getTodosAtributos();
                    Pattern pattern = Pattern.compile(criterio01);
                    Matcher matcher = pattern.matcher(atributosPet);
                    if (matcher.find()) {
                        listaFiltrada02.add(pet);
                    }
                }
            } else {
                System.err.println("ERRO: Digite um critério válido!!!");
                continue;
            }

            if (!listaFiltrada02.isEmpty()) {
                System.out.println("\n--- Pets Encontrados ---");
                for (int i = 0; i < listaFiltrada02.size(); i++) {
                    System.out.println((i + 1) + ". " + listaFiltrada02.get(i).getTodosAtributos() + "\n");
                }
                break;
            } else {
                System.err.println("Nenhum pet encontrado, deseja buscar novamente? (Y/N)");
                confirmacaoSaida = scanner.nextLine().trim().toUpperCase();
            }

            // acho que da pra virar um metodo interno dessa classe aqui
            if (confirmacaoSaida.equals("Y")){
                System.out.println("Saindo do SubMenu");
                return new ArrayList<>();
            } else if (confirmacaoSaida.equals("N")) {
                continue;
            } else {
                System.out.println("Digite apenas opções válidas!");
                continue;
            }
        }
        return listaFiltrada02;
    }
}