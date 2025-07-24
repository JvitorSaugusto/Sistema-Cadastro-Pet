package br.com.joaovitor.meuprojeto.menu.methods;

import java.util.Scanner;

public class Submenu05 {
    public static String perguntaPeso(Scanner scanner){
        while (true){
            String pesoInput = scanner.nextLine();
            if (pesoInput.trim().isEmpty()) {
                return "NÃO INFORMADO";
            }
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
