package br.com.joaovitor.meuprojeto.files.test;

import br.com.joaovitor.meuprojeto.utils.WriteInFiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CriarPerguntaExtra {
    public static void writingExtra(Scanner scanner) {
        System.out.println("Digite aqui sua nova pergunta: ");
        String novaPergunta = scanner.nextLine();
        BoxDePerguntas.guardaPergunta(novaPergunta);


        File file = new File("formulario.txt");
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            WriteInFiles.escreverPulandoLinha(BoxDePerguntas.getListaDePerguntas(), bw);
            bw.flush();
            System.out.println("Nova pergunta salva com sucesso!!");
        } catch (IOException e) {
            System.err.println("Erro:" + e.getMessage());
        }
    }
}
