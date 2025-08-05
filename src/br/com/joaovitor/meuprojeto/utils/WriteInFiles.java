package br.com.joaovitor.meuprojeto.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class WriteInFiles {
    public static void escreverPulandoLinha(List<String> listaDePerguntas, BufferedWriter bw) throws IOException {
        for (int i = 0; i < listaDePerguntas.size(); i++) {
            bw.write((i + 1) + "- " + listaDePerguntas.get(i));
            bw.newLine();
        }
    }
}
