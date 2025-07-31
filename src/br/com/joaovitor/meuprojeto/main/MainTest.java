package br.com.joaovitor.meuprojeto.main;

import br.com.joaovitor.meuprojeto.files.test.FileReadingTest01;
import br.com.joaovitor.meuprojeto.files.test.FileWriteTest01;
import br.com.joaovitor.meuprojeto.files.test.WriterResponseFile;
import br.com.joaovitor.meuprojeto.menu.methods.*;
import br.com.joaovitor.meuprojeto.pets.domain.PetBox;

import java.util.*;

public class MainTest {
    public static void main(String[] args) {
        FileWriteTest01.writing();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem vindo ao menu, escolha uma das opções abaixo: \n");
            System.out.println("1.Cadastrar um novo pet\n2.Listar pets por algum critério (idade, nome, raça)\n" +
                    "3.Alterar os dados do pet cadastrado\n4.Deletar um pet cadastrado\n5.Sair\n");

            String opcaoMenu = scanner.next();
            scanner.nextLine();
            String resposta = "";

            try {
                int opcaoMenuParse = Integer.parseInt(opcaoMenu);
                if (opcaoMenuParse == 1) {
                    Map<String, String> mapDeRespostas = new HashMap<>();
                    List<String> chaveMap = new ArrayList<>();
                    List<String> perguntas = FileReadingTest01.Reading();

                    for (int i = 0; i < perguntas.size(); i++) {
                        System.out.println(perguntas.get(i));
                        if (i == 0) {
                            resposta = SubMenuNome.perguntarNome(scanner);
                        }else if (i == 1) {
                            resposta = SubMenuTipo.perguntarTipo(scanner);
                        }else if (i == 2) {
                            resposta = SubMenuSexo.perguntarSexo(scanner);
                        } else if (i == 3) {
                            resposta = SubMenuEndereco.perguntarEndereco(scanner);
                        } else if (i == 4) {
                            resposta = SubMenuIdade.perguntaIdade(scanner);
                        } else if (i == 5) {
                            resposta = SubMenuPeso.perguntaPeso(scanner);
                        } else if (i == 6){
                            resposta = SubMenuRaca.perguntarRaca(scanner);
                        }

                        chaveMap.add(Integer.toString(i));
                        mapDeRespostas.put(chaveMap.get(i), resposta);
                    }

                    List<String> respostas = new ArrayList<>(mapDeRespostas.values());
                    System.out.println("Adicionando pets na lista \n");
                    PetBox.guardaPet(respostas);
                    System.out.println("Salvando respostas...\n");
                    WriterResponseFile.escrevendoRespostas(respostas);

                } else if (opcaoMenuParse == 2) {
                    SubMenu02.listarPetsPorCriterio(scanner);
                } else if (opcaoMenuParse == 3) {
                    SubMenu03.alterarPet(scanner);
                } else if (opcaoMenuParse == 5) {
                    System.err.println("Saindo do sistema!");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }
}