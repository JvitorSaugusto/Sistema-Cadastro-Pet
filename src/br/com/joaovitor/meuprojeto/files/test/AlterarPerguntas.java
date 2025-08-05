package br.com.joaovitor.meuprojeto.files.test;

import br.com.joaovitor.meuprojeto.utils.WriteInFiles;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class AlterarPerguntas {
    public static void readingExtras(Scanner scanner) {
        File file = new File("formulario.txt");
        List<String> todasAsperguntas = BoxDePerguntas.getListaDePerguntas();
        List<String> todasAsperguntasNumeradas;
        String confirmarSaida;

        while (true) {
            todasAsperguntasNumeradas = BoxDePerguntas.getListaDePerguntasNumeradas();
            System.out.println("Perguntas do formulário: \n");
            for (String pergunta : todasAsperguntasNumeradas){
                System.out.println(pergunta);
            }

            if (!todasAsperguntas.isEmpty()) {
                System.out.println("Digite o numero da pergunta que sera alterada: ");
                System.err.println("Atenção as perguntas de 1 - 7 NÃO podem ser alteradas!!!");
                int indicePergunta = scanner.nextInt();
                scanner.nextLine();
                int indicePerguntaCorrigido = indicePergunta - 1;

                if (indicePergunta >= 0 && indicePergunta <= 7){
                    System.err.println("Escolha perguntas válidas!!!");
                    continue;
                }

                String perguntaEscolhida = todasAsperguntas.get(indicePerguntaCorrigido);
                System.out.println("Pergunta que será alterada: " + perguntaEscolhida);

                System.out.println("Digite a nova pergunta:");
                String novaPergunta = scanner.nextLine();
                todasAsperguntas.set(indicePerguntaCorrigido, novaPergunta);

                try (FileWriter fw = new FileWriter(file);
                     BufferedWriter bw = new BufferedWriter(fw)) {
                    WriteInFiles.escreverPulandoLinha(todasAsperguntas, bw);
                    bw.flush();
                    System.out.println("Pergunta alterada com sucesso!!!");
                } catch (IOException e) {
                    System.err.println("Erro:" + e.getMessage());
                }
            } else {
                System.err.println("Nenhuma pergunta encontrada, deseja buscar novamente? (Y/N)");
                confirmarSaida = scanner.next().trim().toUpperCase();
                if (confirmarSaida.equals("Y")){
                    continue;
                } else if (confirmarSaida.equals("N")) {
                    System.out.println("Saindo do menu");
                    break;
                }
            }
            break;
        }
    }
}