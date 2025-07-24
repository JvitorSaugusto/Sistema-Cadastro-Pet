package br.com.joaovitor.meuprojeto.menu.methods;

import java.util.Scanner;

public class Submenu03 {
    public static String perguntarEndereco(Scanner scanner){
        System.out.println("Qual o Número da casa?");
        int numero = scanner.nextInt();
        scanner.nextLine();
        String numeroConvertido = Integer.toString(numero);
        System.out.println("Qual a Cidade?");
        String cidade = scanner.nextLine();
        System.out.println("Qual a Rua?");
        String rua = scanner.nextLine();
        return numeroConvertido + "," + rua + "," + cidade;

    }
}
