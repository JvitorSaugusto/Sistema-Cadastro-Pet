package br.com.joaovitor.meuprojeto.files.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileReadingTest01 {
    public static List <String> Reading() {
        File file = new File("formulario.txt");
        List <String> perguntas = new ArrayList<>();

        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while((linha = br.readLine()) != null){
                perguntas.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro:" + e.getMessage());
        }
        return perguntas;
    }
}
