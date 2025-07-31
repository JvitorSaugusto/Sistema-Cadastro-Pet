package br.com.joaovitor.meuprojeto.menu.methods;

import br.com.joaovitor.meuprojeto.pets.domain.Pet;

import java.util.List;
import java.util.Scanner;

public class SubMenu03 {
    public static void alterarPet(Scanner scanner){
        List<Pet> listaPetsEncontrados= SubMenu02.listarPetsPorCriterio(scanner);
        int escolhaPetUsuario = scanner.nextInt();
        scanner.nextLine();

        if (escolhaPetUsuario > 0){
            int escolhaPetUsuarioCorrigido = escolhaPetUsuario - 1;
            Pet pet = listaPetsEncontrados.get(escolhaPetUsuarioCorrigido);
            System.out.println("Digite qual atributo vai ser alterado: \n");
            System.out.println("""
                1. Nome ou sobrenome
                2. Idade
                3. Peso
                4. Raça
                5. Endereço
                """);
            String opcaoMenu = scanner.nextLine();

            if (opcaoMenu.equals("1")){
                String nomeCompletoNovo = SubMenuNome.perguntarNome(scanner);
                pet.setNome(nomeCompletoNovo);
            } else if (opcaoMenu.equals("2")) {
                String idadeNova = SubMenuIdade.perguntaIdade(scanner);
                pet.setIdade(Double.parseDouble(idadeNova));
            } else if (opcaoMenu.equals("3")) {
                String pesoNovo = SubMenuPeso.perguntaPeso(scanner);
                pet.setPeso(Double.parseDouble(pesoNovo));
            } else if (opcaoMenu.equals("4")) {
                String racaNova = SubMenuRaca.perguntarRaca(scanner);
                pet.setRaca(racaNova);
            } else if (opcaoMenu.equals("5")) {
                String enderecoNovo = SubMenuEndereco.perguntarEndereco(scanner);
                pet.setEndereco(enderecoNovo);
            } else {
                System.err.println("Erro: Digite apenas opções válidas!!!");
            }
        }

    }
}
