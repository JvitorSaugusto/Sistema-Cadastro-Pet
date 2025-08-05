package br.com.joaovitor.meuprojeto.main;

import br.com.joaovitor.meuprojeto.files.test.BoxDePerguntas;
import br.com.joaovitor.meuprojeto.files.test.FileWriteTest01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriteTest01.writing();
        BoxDePerguntas.inicializarListaComPerguntasDoArquivo();

        while (true) {
            System.out.println("Bem vindo ao sistema de gerenciamento de pets, escolha uma das opções abaixo: \n");
            System.out.println("""
                    1 - Iniciar o sistema para cadastro de PETS
                    2 - Iniciar o sistema para alterar formulário
                    3 - Sair do sistema
                    """);

            String opcaoMenu = scanner.next();
            scanner.nextLine();

            try {
                int opcaoMenuParse = Integer.parseInt(opcaoMenu);
                if (opcaoMenuParse == 1) {
                    MenuPets.mostrarMenuPets(scanner);
                } else if (opcaoMenuParse == 2) {
                    MenuPerguntas.mostrarMenuPerguntas(scanner);
                } else if (opcaoMenuParse == 3) {
                    System.out.println("Saindo do sistema!");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }
}

