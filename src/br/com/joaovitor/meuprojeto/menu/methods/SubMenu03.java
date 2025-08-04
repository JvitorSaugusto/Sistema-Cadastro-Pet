package br.com.joaovitor.meuprojeto.menu.methods;

import br.com.joaovitor.meuprojeto.pets.domain.Pet;
import br.com.joaovitor.meuprojeto.pets.domain.PetBox;

import java.util.List;
import java.util.Scanner;

public class SubMenu03 {
    public static void alterarPet(Scanner scanner) {
        System.out.println("SubMenu - Alterar dados de um Pet");
        int contador = 0;
        List<Pet> listaPetsEncontrados = SubMenu02.listarPetsPorCriterio(scanner);
        while (true) {
            contador++;
            if (contador >= 2){
                System.out.println("\n--- Pets Encontrados ---");
                for (int i = 0; i < listaPetsEncontrados.size(); i++) {
                    System.out.println((i + 1) + ". " + listaPetsEncontrados.get(i).getTodosAtributos() + "\n");
                }
            }
            System.out.println("Selecione um dos pets acima: ");
            int escolhaPetUsuario = scanner.nextInt();
            scanner.nextLine();
            Pet pet;
            if (escolhaPetUsuario > 0 && escolhaPetUsuario <= listaPetsEncontrados.size()) {
                int escolhaPetUsuarioCorrigido = escolhaPetUsuario - 1;
                pet = listaPetsEncontrados.get(escolhaPetUsuarioCorrigido);
                System.out.println("Digite qual atributo vai ser alterado: \n");
                System.out.println("""
                        1. Nome ou sobrenome
                        2. Idade
                        3. Peso
                        4. Raça 
                        5. Endereço
                        6. Voltar
                        """);
                String opcaoMenu = scanner.nextLine();

                if (opcaoMenu.equals("1")) {
                    String nomeCompletoNovo = SubMenuNome.perguntarNome(scanner);
                    pet.setNome(nomeCompletoNovo);
                    System.out.println("Nome alterado com sucesso!\n");
                } else if (opcaoMenu.equals("2")) {
                    String idadeNova = SubMenuIdade.perguntaIdade(scanner);
                    pet.setIdade(Double.parseDouble(idadeNova));
                    System.out.println("Idade alterado com sucesso!\n");
                } else if (opcaoMenu.equals("3")) {
                    String pesoNovo = SubMenuPeso.perguntaPeso(scanner);
                    pet.setPeso(Double.parseDouble(pesoNovo));
                    System.out.println("Peso alterado com sucesso!\n");
                } else if (opcaoMenu.equals("4")) {
                    String racaNova = SubMenuRaca.perguntarRaca(scanner);
                    pet.setRaca(racaNova);
                    System.out.println("Raça alterada com sucesso!\n");
                } else if (opcaoMenu.equals("5")) {
                    String enderecoNovo = SubMenuEndereco.perguntarEndereco(scanner);
                    pet.setEndereco(enderecoNovo);
                    System.out.println("Endereço alterado com sucesso!\n");
                } else if (opcaoMenu.equals("6")) {
                    System.out.println("Saindo do SubMenu Alterar Pets");
                    break;
                } else {
                    System.err.println("Erro: Digite apenas atributos válidos!!!");
                    continue;
                }
            } else {
                System.err.println("Erro: Digite apenas animais válidos!!!");
                continue;
            }
            System.out.println("Dados alterados:");
            System.out.println(pet.getTodosAtributos());
            PetBox.guardaPetAtualizado(pet);
            System.out.println("Pet alterado salvo com sucesso!!!");


            System.out.println("Deseja sair do SubMenu - Alterar Pet? (Y/N)");
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
