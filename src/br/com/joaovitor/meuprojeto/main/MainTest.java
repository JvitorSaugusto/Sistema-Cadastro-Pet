package br.com.joaovitor.meuprojeto.main;

import br.com.joaovitor.meuprojeto.files.test.FileReadingTest01;
import br.com.joaovitor.meuprojeto.files.test.FileWriteTest01;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {
    public static void main(String[] args) {
        FileWriteTest01.writing();
        FileReadingTest01.Reading();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao menu, escolha uma das opções abaixo:");
        System.out.println("1.Cadastrar um novo pet\n2.Alterar os dados do pet cadastrado\n3.Deletar um pet cadastrado\n" +
                "4.Listar todos os pets cadastrados\n5.Listar pets por algum critério (idade, nome, raça)\n6.Sair");

        int opcaoMenuParse = -1;

        while (opcaoMenuParse != 6) {
            String opcaoMenu = scanner.next();

            try {
                opcaoMenuParse = Integer.parseInt(opcaoMenu);

                if (opcaoMenuParse == 1) {
                    System.out.println("Digitou 1");
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