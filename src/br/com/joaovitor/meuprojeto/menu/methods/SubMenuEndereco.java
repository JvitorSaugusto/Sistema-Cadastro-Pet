package br.com.joaovitor.meuprojeto.menu.methods;

import br.com.joaovitor.meuprojeto.pets.domain.Pet;
import br.com.joaovitor.meuprojeto.utils.VerifyRegex;

import java.util.Scanner;

public class SubMenuEndereco {
    public static String perguntarEndereco(Scanner scanner) {
        String numero;
        String cidade;
        String rua;

        while (true){
            System.out.println("Qual o Número da casa?");
            numero = scanner.nextLine();

            boolean numeroValidado = VerifyRegex.verificaSeContemApenasDigitos(numero);
            if (numero.trim().isEmpty()) {
                numero = Pet.NAO_INFORMADO;
                break;
            } else if (!numeroValidado) {
                System.out.println("Digite apenas numeros ou não digite nada.");
                continue;
            }else {
                break;
            }
        }

        while (true) {
            System.out.println("Qual a Cidade?");
            cidade = scanner.nextLine();
            if (cidade.trim().isEmpty()){
                System.out.println("O campo cidade é obrigatório!!!");
                continue;
            }

            System.out.println("Qual a Rua?");
            rua = scanner.nextLine();
            if (rua.trim().isEmpty()){
                System.out.println("O campo rua é obrigatório!!!");
                continue;
            }else {
                break;
            }
        }
        return numero + "," + rua + "," + cidade;
    }
}
