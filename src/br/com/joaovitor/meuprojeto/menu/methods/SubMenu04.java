package br.com.joaovitor.meuprojeto.menu.methods;

import br.com.joaovitor.meuprojeto.pets.domain.Pet;
import br.com.joaovitor.meuprojeto.pets.domain.PetBox;

import java.util.List;
import java.util.Scanner;


public class SubMenu04 {
    public static void deletarPet(Scanner scanner) {
        System.out.println("SubMenu - Deletar Pet");
        List<Pet> listaPetsEncontrados = SubMenu02.listarPetsPorCriterio(scanner);
        int contador = 0;
        while (true) {
            contador++;
            if (listaPetsEncontrados.isEmpty()){
                System.out.println("Não existem pets para deletar!\n");
                System.out.println("Saindo do SubMenu - Deletar Pet");
                break;
            } else if (contador >= 2){
                System.out.println("\n--- Pets Encontrados ---");
                for (int i = 0; i < listaPetsEncontrados.size(); i++) {
                    System.out.println((i + 1) + ". " + listaPetsEncontrados.get(i).getTodosAtributos() + "\n");
                }
            }
            System.out.println("Digite qual pet acima vai ser deletado: \n");

            int escolhaPetUsuario = scanner.nextInt();
            scanner.nextLine();

            if (escolhaPetUsuario > 0 && escolhaPetUsuario <= listaPetsEncontrados.size()) {
                int escolhaPetUsuarioCorrigido = escolhaPetUsuario - 1;
                Pet pet = listaPetsEncontrados.get(escolhaPetUsuarioCorrigido);
                System.out.println("Tem certeza que deseja deletar o pet " + pet.getNome() + " ?");
                System.out.println("Y/N");
                String confirmaDeletar = scanner.nextLine().trim().toUpperCase();
                if (confirmaDeletar.equals("Y")){
                    PetBox.removerPetDaBox(pet);
                    listaPetsEncontrados.remove(escolhaPetUsuarioCorrigido);
                    System.out.println("Pet removido do sistema");
                    break;
                } else if (confirmaDeletar.equals("N")) {
                    continue;
                } else {
                    System.out.println("Digite somente opções válidas");
                    continue;
                }
            } else {
                System.err.println("Erro: Digite apenas animais válidos!!!");
            }

            System.out.println("Deseja sair do SubMenu - Deletar Pet? (Y/N)");
            String confirmarSaida = scanner.nextLine().trim().toUpperCase();
            if (confirmarSaida.equals("Y")){
                System.out.println("Saindo do SubMenu");
                break;
            }else if (confirmarSaida.equals("N")){
                continue;
            }
        }
    }
}
