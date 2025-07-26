package br.com.joaovitor.meuprojeto.menu.methods;

import java.util.Scanner;

public class Submenu01 {
    public static String perguntarTipo(Scanner scanner){
        while (true) {
            System.out.println("Digite a opção do tipo de Pet: (1) CACHORRO\n(2) GATO\n(3) PASSARO\n(4) REPTIL");
            int escolhaMenu = scanner.nextInt();

            if (escolhaMenu == 1){
                return "CACHORRO";
            } else if (escolhaMenu == 2) {
                return "GATO";
            } else if (escolhaMenu == 3) {
                return "PASSARO";
            } else if (escolhaMenu == 4){
                return "REPTIL";
            } else {
                System.out.println("Digite uma opção válida");
            }
        }
    }
}
