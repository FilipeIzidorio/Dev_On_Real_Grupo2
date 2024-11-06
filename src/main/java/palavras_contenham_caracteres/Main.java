package palavras_contenham_caracteres;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> encontrarIndices(String[] palavras, char x) {

        // Lista para armazenar os índices das palavras que contêm o caractere x
        List<Integer> indices = new ArrayList<>();

        // Itera sobre o array de palavras
        for (int i = 0; i < palavras.length; i++) {
            // Verifica se o caractere x está na palavra
            if (palavras[i].indexOf(x) != -1) {
                indices.add(i);
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        String[] palavras = {"leet", "code"};
        char x = 't';

        List<Integer> resultado = encontrarIndices(palavras, x);
        System.out.println(resultado); // Saída esperada: [0]
    }
}
