package br.com.joaovitor.meuprojeto.files.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class WriterResponseFile {
    public static void escrevendoRespostas(List<String> respostas) {
        File fileDiretorio = new File("petsCadastrados");
        File file = new File(fileDiretorio, geradorNomeDinamico(respostas.getFirst()));
        if (!fileDiretorio.exists()){
            boolean isDiretorioExist = fileDiretorio.mkdir();
            if (isDiretorioExist){
                System.out.println("Diretório petsCadastrados foi criado com sucesso!");
            }else {
                System.err.println("Erro: Diretório não foi criado!!!");
            }
        }
        try {
            boolean isFileCreated = file.createNewFile();
            System.out.println(isFileCreated);
        } catch (IOException e) {
            System.err.println("Erro:" + e.getMessage());
        }

        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            FileWriteTest01.escreverPulandoLinha(respostas, bw);
            bw.flush();
        } catch (IOException e) {
            System.err.println("Erro:" + e.getMessage());
        }
    }

    public static String geradorNomeDinamico(String nomeCompleto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String localDateTimeBR = LocalDateTime.now().format(formatter);
        String nomeCompletoFormatado = nomeCompleto.replace(" ", "");
        String localDateTimeBRFormatado = localDateTimeBR.replace(":", "-");
        return localDateTimeBRFormatado + nomeCompletoFormatado + ".txt";
    }
}

