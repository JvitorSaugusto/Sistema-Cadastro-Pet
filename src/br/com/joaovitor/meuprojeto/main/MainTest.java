package br.com.joaovitor.meuprojeto.main;

import br.com.joaovitor.meuprojeto.files.test.FileReadingTest01;
import br.com.joaovitor.meuprojeto.files.test.FileWriteTest01;

import java.util.*;

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
            String resposta = "";

            try {
                opcaoMenuParse = Integer.parseInt(opcaoMenu);
                if (opcaoMenuParse == 1) {
                    Map<String, String> map = new HashMap<>();
                    List<String> chaveMap = new ArrayList<>();
                    List<String> perguntas = FileReadingTest01.Reading();
                    List<String> respostas = new ArrayList<>();

                    for (int i = 0; i < perguntas.size(); i++) {
                        System.out.println(perguntas.get(i));
                        if (i == 2) {
                            // dps transformar em um metodo "perguntarSexo"
                            System.out.println("Digite: MACHO ou FEMEA");
                            resposta = scanner.nextLine().trim().toUpperCase();
                            if (!resposta.equals("MACHO") && !resposta.equals("FEMEA")) {
                                System.out.println("ERRO: Valor invalido");
                                i--;
                                continue;
                            }
                        } else if (i == 3) {
                            // dps transformar em um metodo "perguntarEndereço"
                            System.out.println("Qual o Número da casa?");
                            int numero = scanner.nextInt();
                            String numeroConvertido = Integer.toString(numero);
                            // tentar validar se cidade contem apenas letras, validar com regex
                            System.out.println("Qual a Cidade?");
                            String cidade = scanner.nextLine();
                            System.out.println("Qual a Rua?");
                            String rua = scanner.nextLine();
                            resposta = numeroConvertido + "," + rua + "," + cidade;

                        } else if (i == 4) {
                            String idadeInput = scanner.nextLine();
                            if (idadeInput.trim().isEmpty()){
                                resposta = "NÃO INFORMADO";
                            }
                            Double idade = Double.parseDouble(idadeInput);
                            if (idade > 20 || idade < 0.5) {
                                throw new IllegalArgumentException("Argumento ilegal, não pode ser mais que 20");
                            } else if (idade <= 20) {
                                System.out.println("A idade sera em meses ou anos?");
                                String inputIdade = scanner.nextLine().toLowerCase();
                                if (inputIdade.equals("meses")) {
                                    idade /= 12.0;
                                    resposta = String.valueOf(idade);
                                } else if (inputIdade.equals("anos")){
                                    resposta = String.valueOf(idade);
                                } else{
                                    System.out.println("Selecione uma opção válida.");
                                    continue;
                                }
                            }
                            
                        } else if (i == 5) {
                            double peso = scanner.nextInt();
                            if (peso < 1 && peso > 0.5) {

                            } else if (peso > 60 || peso < 0.5) {
                                throw new IllegalArgumentException("Argumento ilegal, não pode ser maior que 60 kg e menos que 0.5 kg");
                            }
                        } else {
                            resposta = scanner.nextLine().trim();
                        }
                        chaveMap.add(Integer.toString(i));
                        map.put(chaveMap.get(i), resposta);
                    }
                    System.out.println("Inserindo respostas na lista");
                    respostas.addAll(map.values());

                } else if (opcaoMenuParse == 2) {
                    System.out.println("...");
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