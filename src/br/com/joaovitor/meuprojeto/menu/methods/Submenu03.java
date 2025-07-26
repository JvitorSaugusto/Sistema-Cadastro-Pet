package br.com.joaovitor.meuprojeto.menu.methods;

import br.com.joaovitor.meuprojeto.pets.domain.Pet;
import br.com.joaovitor.meuprojeto.utils.VerifyRegex;

import java.util.Scanner;

public class Submenu03 {
    public static String perguntarEndereco(Scanner scanner) {
        while (true) {
            System.out.println("Qual o Número da casa?");
            String numero = scanner.nextLine();
            boolean numeroValidado = VerifyRegex.verificaSeContemApenasDigitos(numero);
            if (numero.trim().isEmpty()) {
                return Pet.NAO_INFORMADO;
            } else if (!numeroValidado) {
                System.out.println("Digite apenas numeros ou não digite nada.");
                continue;
            }
            System.out.println("Qual a Cidade?");
            String cidade = scanner.nextLine();
            System.out.println("Qual a Rua?");
            String rua = scanner.nextLine();
            return numero + "," + rua + "," + cidade;
        }
    }
}
