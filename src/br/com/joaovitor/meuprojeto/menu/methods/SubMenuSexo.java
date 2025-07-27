package br.com.joaovitor.meuprojeto.menu.methods;

import java.util.Scanner;

public class SubMenuSexo {
    public static String perguntarSexo(Scanner scanner) {
        while (true) {
            System.out.println("Digite: MACHO ou FEMEA");
            String resposta = scanner.nextLine().trim().toUpperCase();

            if (resposta.equals("MACHO") || resposta.equals("FEMEA")) {
                return resposta;
            } else {
                System.out.println("ERRO: Valor invalido");
            }
        }
    }
}