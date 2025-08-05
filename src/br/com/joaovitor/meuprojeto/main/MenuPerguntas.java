package br.com.joaovitor.meuprojeto.main;

import br.com.joaovitor.meuprojeto.files.test.AlterarPerguntas;
import br.com.joaovitor.meuprojeto.files.test.CriarPerguntaExtra;
import br.com.joaovitor.meuprojeto.files.test.DeletarPerguntas;

import java.util.*;

public class MenuPerguntas {
    public static void mostrarMenuPerguntas(Scanner scanner){

        while (true) {
            System.out.println("Bem vindo ao menu, escolha uma das opções abaixo: \n");
            System.out.println("1.Cadastrar uma nova pergunta\n2.Alterar uma pergunta existente\n" +
                    "3.Deletar uma pergunta existente\n4.Voltar ao menu principal\n");

            String opcaoMenu = scanner.next();
            scanner.nextLine();

            try {
                int opcaoMenuParse = Integer.parseInt(opcaoMenu);
                if (opcaoMenuParse == 1) {
                    CriarPerguntaExtra.writingExtra(scanner);
                } else if (opcaoMenuParse == 2) {
                    AlterarPerguntas.readingExtras(scanner);
                } else if (opcaoMenuParse == 3) {
                    DeletarPerguntas.deleteExtra(scanner);
                } else if (opcaoMenuParse == 4) {
                    System.out.println("Voltando ao menu principal");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }
}
