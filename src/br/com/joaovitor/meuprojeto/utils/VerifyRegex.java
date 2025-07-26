package br.com.joaovitor.meuprojeto.utils;

import br.com.joaovitor.meuprojeto.pets.domain.Pet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyRegex {
    public static Boolean verificaSeContemApenasLetras(String str){
        String regex = "[a-zA-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        return matcher.find();
    }

    public static Boolean verificaSeContemApenasDigitos(String str){
        String regex = "^\\d+(\\.\\d+)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        return matcher.find();
    }

    public static String verificaSeEstaVazio(String input){
        if (input.trim().isEmpty()) {
            System.out.println("Campo não informado. Usando padrão 'NÃO INFORMADO'.");
            return Pet.NAO_INFORMADO;
        } else {
            return input;
        }

    }
}