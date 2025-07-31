package br.com.joaovitor.meuprojeto.menu.methods;

import br.com.joaovitor.meuprojeto.utils.VerifyRegex;

import java.util.Scanner;

public class SubMenuRaca {
    public static String perguntarRaca(Scanner scanner){
        while (true){
            System.out.println("Digite a raça do seu pet");
            String raca = scanner.nextLine();
            raca = VerifyRegex.verificaSeEstaVazio(raca);
            boolean racaVerificada = VerifyRegex.verificaSeContemApenasLetras(raca);
            if (racaVerificada){
                return raca;
            }else {
                System.err.println("ERRO: Digite uma raça válida");
            }
        }
    }
}
