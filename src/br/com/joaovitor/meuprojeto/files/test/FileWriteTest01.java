package br.com.joaovitor.meuprojeto.files.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriteTest01 {
    public static void writing() {
        List<String> perguntas = List.of(new String[]{"1 - Qual o nome e sobrenome do pet?", "2 - Qual o tipo do pet (Cachorro/Gato)?",
                "3 - Qual o sexo do animal?", "4 - Qual endereço e bairro que ele foi encontrado?",
                "5 - Qual a idade aproximada do pet?", "6 - Qual o peso aproximado do pet?", "7 - Qual a raça do pet?"});

        File file = new File("formulario.txt");
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            escreverPulandoLinha(perguntas, bw);
            bw.flush();
        } catch (IOException e) {
            System.err.println("Erro:" + e.getMessage());
        }
    }

    public static void escreverPulandoLinha(List <String> arr, BufferedWriter bw) throws IOException {
        for (String pergunta : arr) {
            bw.write(pergunta);
            bw.newLine();
        }
    }
}
