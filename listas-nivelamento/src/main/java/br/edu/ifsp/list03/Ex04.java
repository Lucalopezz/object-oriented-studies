package br.edu.ifsp.list03;

import java.util.Arrays;

/*
Dada duas Strings A e B, faça um programa que imprima “Sim” se A e B são anagramas e “Nao”, caso contrário.
Um anagrama é a transposição de letras de palavra ou frase para formar outra palavra ou frase diferente.
Por exemplo, as palavras “roma” e “amor” são anagramas. Considere como entrada apenas palavras com letras minúsculas.
 */
public class Ex04 {
    public static void main(String[] args) {
        //Leia o ‘input’
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
    }

    String compute(String wordA, String wordB) {
        if (wordA == null || wordA.isEmpty() || wordB == null || wordB.isEmpty()) return "Sim";
        if (wordA.length() != wordB.length()) return "Nao";
        String a = wordA.toLowerCase().trim();
        String b = wordB.toLowerCase().trim();

        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        Arrays.sort(ca);
        Arrays.sort(cb);

        return Arrays.equals(ca, cb) ? "Sim" : "Nao";
    }
}
