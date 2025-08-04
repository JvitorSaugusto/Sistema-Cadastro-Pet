package br.com.joaovitor.meuprojeto.menu.methods;

import br.com.joaovitor.meuprojeto.utils.VerifyRegex;

import java.util.Scanner;

public class SubMenuPeso {
    public static String perguntaPeso(Scanner scanner){
        while (true){
            System.out.println("Digite o peso do seu pet:");
            String pesoInput = scanner.nextLine();
            VerifyRegex.verificaSeEstaVazio(pesoInput);
            try {
                double peso = Double.parseDouble(pesoInput);

                if (peso > 60 || peso < 0.5) {
                    System.out.println("Digite um peso valido (entre 0.5 kg a 60 kg)");
                } else {
                    return String.valueOf(peso);
                }
            } catch (IllegalArgumentException e){
                System.err.println("Erro:" + e.getMessage());
            }

        }
    }
}
