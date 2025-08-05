package br.com.joaovitor.meuprojeto.files.test;

import br.com.joaovitor.meuprojeto.utils.WriteInFiles;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DeletarPerguntas {
    public static void deleteExtra(Scanner scanner) {
        List<String> todasAsperguntasNumeradas = BoxDePerguntas.getListaDePerguntasNumeradas();
        List<String> todasAsperguntas = BoxDePerguntas.getListaDePerguntas();
        File file = new File("formulario.txt");

        while (true) {
            todasAsperguntasNumeradas = BoxDePerguntas.getListaDePerguntasNumeradas();
            System.out.println("Perguntas do formulário: \n");
            for (String pergunta : todasAsperguntasNumeradas) {
                System.out.println(pergunta);
            }

            if (!todasAsperguntas.isEmpty()) {
                System.out.println("Digite o numero da pergunta que sera deletada: ");
                System.err.println("Atenção as perguntas de 1 - 7 NÃO podem ser deletadas!!!");
                int indicePergunta = scanner.nextInt();
                scanner.nextLine();

                if (indicePergunta >= 0 && indicePergunta <= 7) {
                    System.err.println("Escolha perguntas válidas!!!");
                    continue;
                }
                int indicePerguntaCorrigido = indicePergunta - 1;

                String perguntaEscolhida = todasAsperguntas.get(indicePerguntaCorrigido);

                System.out.println("Tem certeza que deseja deletar a pergunta " + perguntaEscolhida + " ?");
                System.out.println("Y/N");
                String confirmarDeletar = scanner.next().trim().toUpperCase();

                if (confirmarDeletar.equals("Y")){
                    BoxDePerguntas.deletarPergunta(indicePerguntaCorrigido);
                } else if (confirmarDeletar.equals("N")) {
                    continue;
                }

                try (FileWriter fw = new FileWriter(file);
                     BufferedWriter bw = new BufferedWriter(fw)) {
                    WriteInFiles.escreverPulandoLinha(BoxDePerguntas.getListaDePerguntas(), bw);
                    bw.flush();
                } catch (IOException e) {
                    System.err.println("Erro:" + e.getMessage());
                }
            }
        }
    }
}