package br.com.joaovitor.meuprojeto.files.test;

import java.io.*;
import java.util.Scanner;

public class FileReadingTest01 {
    public static void Reading() {
        File file = new File("formulario.txt");
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while((linha = br.readLine()) != null){
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro:" + e.getMessage());
        }
    }
}
