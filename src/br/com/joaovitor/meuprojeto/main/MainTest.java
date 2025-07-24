package br.com.joaovitor.meuprojeto.main;

import br.com.joaovitor.meuprojeto.files.test.FileReadingTest01;
import br.com.joaovitor.meuprojeto.files.test.FileWriteTest01;
import br.com.joaovitor.meuprojeto.menu.methods.Submenu02;
import br.com.joaovitor.meuprojeto.menu.methods.Submenu03;
import br.com.joaovitor.meuprojeto.menu.methods.Submenu04;
import br.com.joaovitor.meuprojeto.menu.methods.Submenu05;
import br.com.joaovitor.meuprojeto.pets.domain.PetBox;

import java.util.*;

public class MainTest {
    public static void main(String[] args) {
        FileWriteTest01.writing();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem vindo ao menu, escolha uma das opções abaixo:");
            System.out.println("1.Cadastrar um novo pet\n2.Alterar os dados do pet cadastrado\n3.Deletar um pet cadastrado\n" +
                    "4.Listar todos os pets cadastrados\n5.Listar pets por algum critério (idade, nome, raça)\n6.Sair");

            String opcaoMenu = scanner.next();
            scanner.nextLine();
            String resposta;

            try {
                int opcaoMenuParse = Integer.parseInt(opcaoMenu);
                if (opcaoMenuParse == 1) {
                    Map<String, String> mapDeRespostas = new HashMap<>();
                    List<String> chaveMap = new ArrayList<>();
                    List<String> perguntas = FileReadingTest01.Reading();

                    for (int i = 0; i < perguntas.size(); i++) {
                        System.out.println(perguntas.get(i));
                        if (i == 2) {
                            resposta = Submenu02.perguntarSexo(scanner);
                        } else if (i == 3) {
                            resposta = Submenu03.perguntarEndereco(scanner);
                        } else if (i == 4) {
                            resposta = Submenu04.perguntaIdade(scanner);
                        } else if (i == 5) {
                            resposta = Submenu05.perguntaPeso(scanner);
                        } else {
                            resposta = scanner.nextLine().trim();
                        }
                        chaveMap.add(Integer.toString(i));
                        mapDeRespostas.put(chaveMap.get(i), resposta);
                    }

                    List<String> respostas = new ArrayList<>(mapDeRespostas.values());

                    System.out.println("Adicionando pets na lista");
                    PetBox.guardaPet(respostas);

                } else if (opcaoMenuParse == 2) {
                    System.out.println("...");
                } else if (opcaoMenuParse <= 0) {
                    System.out.println("Digite somente numeros válidos");
                } else if (opcaoMenuParse == 6) {
                    System.err.println("Saindo do sistema!");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }
}