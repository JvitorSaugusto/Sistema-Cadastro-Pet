package br.com.joaovitor.meuprojeto.files.test;


import java.util.ArrayList;
import java.util.List;


public class BoxDePerguntas {
    static List<String> listaDePerguntas = new ArrayList<>();
    static List<String> listaDePerguntasComNumero = new ArrayList<>();

    public static void inicializarListaComPerguntasDoArquivo() {
        listaDePerguntas.clear();
        List <String> listaDePerguntasBruta = FileReadingTest01.Reading();
        for (String linhaBruta : listaDePerguntasBruta){
            String perguntaLimpa = linhaBruta.replaceAll("^\\d+\\s*-\\s*", "").trim();
            listaDePerguntas.add(perguntaLimpa);
        }
    }

    public static void guardaPergunta(String pergunta){
        listaDePerguntas.add(pergunta);
    }

    public static void deletarPergunta(int i){
        listaDePerguntas.remove(i);
    }

    public static List<String> getListaDePerguntas(){
        return listaDePerguntas;
    }

    public static List<String> getListaDePerguntasNumeradas(){
        listaDePerguntasComNumero.clear();
        for (int i = 0; i < listaDePerguntas.size(); i++) {
        String perguntaComNumero = (i + 1) + "- " + listaDePerguntas.get(i);
        listaDePerguntasComNumero.add(perguntaComNumero);
    }
        return listaDePerguntasComNumero;
    }
}
