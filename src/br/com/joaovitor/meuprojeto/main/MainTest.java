package br.com.joaovitor.meuprojeto.main;

import br.com.joaovitor.meuprojeto.files.test.FileReadingTest01;
import br.com.joaovitor.meuprojeto.files.test.FileWriteTest01;
import br.com.joaovitor.meuprojeto.pets.domain.Pet;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {
    public static void main(String[] args) {
        FileWriteTest01.writing();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao menu, escolha uma das opções abaixo:");
        System.out.println("1.Cadastrar um novo pet\n2.Alterar os dados do pet cadastrado\n3.Deletar um pet cadastrado\n" +
                "4.Listar todos os pets cadastrados\n5.Listar pets por algum critério (idade, nome, raça)\n6.Sair");

        int opcaoMenuParse = -1;

        while (opcaoMenuParse != 6) {
            String opcaoMenu = scanner.next();
            scanner.nextLine();

            try {
                opcaoMenuParse = Integer.parseInt(opcaoMenu);
                if (opcaoMenuParse == 1) {
                    Map<String, String> map = new HashMap<>();
                    //verificar pra deixar isso com tamanho dinamico
                    List<String> chaveRespostas = new ArrayList<>(Arrays.asList("nome", "tipo", "sexo", "endereco", "idade", "peso", "raca"));
                    List<String> perguntas = FileReadingTest01.Reading();

                    for (int i = 0; i < perguntas.size(); i++) {
                        System.out.println(perguntas.get(i));
                        String resposta = scanner.nextLine();
                        if (i == 2){
                            if (!resposta.equals("MACHO") && !resposta.equals("FEMEA")) {
                                System.out.println("ERRO: Valor invalido");
                                //verificar essa parte pro loop voltar na pergunta
                                break;
                            }
                        }
                        map.put(chaveRespostas.get(i), resposta);
                    }
                        for (String valor: map.values()){
                            System.out.println(valor);
                        }

                } else if (opcaoMenuParse == 2) {
                    System.out.println("Digitou 2");
                } else if (opcaoMenuParse <= 0) {
                    System.out.println("Digite somente numeros válidos");
                } else if (opcaoMenuParse == 6) {
                    break;
                }


            } catch (NumberFormatException e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }
}