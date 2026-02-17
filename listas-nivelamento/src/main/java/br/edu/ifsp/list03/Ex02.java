package br.edu.ifsp.list03;

/*
Faça um programa que, dada uma String, encontra a primeira e a última substrings de tamanho K de acordo com a ordem
alfabética. Por exemplo, para a String “welcometojava” e K = 3; A substring “ava” é a primeira substring de tamanho
3 e “wel” é a última, considerando a ordem alfabética (saída: "ava wel"). Para dados de entrada inválidos, o programa
deverá imprimir uma String vazia.
 */
public class Ex02 {
    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
    }

    String compute(String word, int number) {
        if (word.length() < number || number <= 0) {
            return null;
        }
        String maior = word.substring(0, number);
        String menor = maior;
        for (int i = 0; i <= word.length() - number; i++) {
            String sub = word.substring(i, i + number);


            if (sub.compareTo(menor) < 0) {
                menor = sub;
            }

            if (sub.compareTo(maior) > 0) {
                maior = sub;
            }
        }

        return menor + " " + maior;
    }
}
