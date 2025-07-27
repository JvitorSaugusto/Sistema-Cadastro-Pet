package br.com.joaovitor.meuprojeto.menu.methods;

import br.com.joaovitor.meuprojeto.utils.VerifyRegex;

import java.util.Scanner;

public class SubMenuNome {
    public static String perguntarNome(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Digite o nome e sobrenome do seu Pet");
                System.out.println("Nome: ");
                String nome = scanner.nextLine().toUpperCase().trim();
                boolean nomeVerificado = VerifyRegex.verificaSeContemApenasLetras(nome);

                if (nomeVerificado && !nome.isEmpty()) {
                    System.out.println("Sobrenome: ");
                    String sobrenome = scanner.nextLine().toUpperCase().trim();
                    nomeVerificado = VerifyRegex.verificaSeContemApenasLetras(sobrenome);
                    if (nomeVerificado && !sobrenome.isEmpty()) {
                        return nome + " " + sobrenome;
                    }
                } else {
                    throw new RuntimeException("Erro: O sistema só aceita nomes completos!!!");
                }
                throw new RuntimeException("Erro: O sistema só aceita nomes completos!!!");
            } catch (RuntimeException e){
                System.err.println("Error message: "+ e.getMessage() + "\nO sistema só aceita nomes completos!!!");
            }
        }
    }
}
