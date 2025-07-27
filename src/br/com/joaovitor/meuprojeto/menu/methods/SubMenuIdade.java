package br.com.joaovitor.meuprojeto.menu.methods;

import br.com.joaovitor.meuprojeto.utils.VerifyRegex;

import java.util.Scanner;

public class SubMenuIdade {
    public static String perguntaIdade(Scanner scanner) {
        while (true) {
            System.out.println("Digite a idade:");
            String idadeInput = scanner.nextLine();

            VerifyRegex.verificaSeEstaVazio(idadeInput);

            try {
                Double idade = Double.parseDouble(idadeInput);
                if (idade <= 20) {
                    while (true) {
                        System.out.println("A idade sera em meses ou anos?");
                        String inputIdade = scanner.nextLine().toLowerCase().trim();
                        if (inputIdade.equals("meses")) {
                            idade /= 12.0;
                            return String.valueOf(idade);
                        } else if (inputIdade.equals("anos")) {
                            return String.valueOf(idade);
                        } else {
                            System.out.println("Selecione uma opção válida.");
                            continue;
                        }
                    }
                } else {
                    System.out.println("Idade fora do intervalo permitido (0 a 20 anos");
                }
            } catch (NumberFormatException e) {
                System.err.println("Erro:" + e.getMessage() + "Digite um valor válido");
            }
        }
    }
}