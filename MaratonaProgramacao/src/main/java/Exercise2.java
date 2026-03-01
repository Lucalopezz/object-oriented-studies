import java.util.Scanner;

public class Exercise2 {
    //    Em chats, é muito comum entre jovens e adolescentes utilizar sequências de letras, que parecem muitas vezes aleatórias, para representar risadas. Alguns exemplos comuns são:
//
//    huaauhahhuahau
//            hehehehe
//    ahahahaha
//            jaisjjkasjksjjskjakijs
//    huehuehue
//
//    Cláudia é uma jovem programadora que ficou intrigada pela sonoridade das “risadas digitais”.
//    Algumas delas ela nem mesmo consegue pronunciar! Mas ela percebeu que algumas delas parecem transmitir melhor o sentimento da risada que outras.
//    A primeira coisa que ela percebeu é que as consoantes não interferem no quanto as risadas digitais influenciam na transmissão do sentimento.
//    A segunda coisa que ela percebeu é que as risadas digitais mais engraçadas são aquelas em que as sequências de vogais são iguais quando lidas
//    na ordem natural (da esquerda para a direita) ou na ordem inversa (da direita para a esquerda), ignorando as consoantes.
//    Por exemplo, “hahaha” e “huaauhahhuahau” estão entre as risadas mais engraçadas, enquanto “riajkjdhhihhjak” e “huehuehue” não estão entre as mais engraçadas.
//    Cláudia está muito atarefada com a análise estatística das risadas digitais e pediu sua ajuda para escrever um programa que determine,
//    para uma risada digital, se ela é das mais engraçadas ou não.
//            Entrada
//
//    A entrada é composta por uma linha, contendo uma sequência de no máximo 50 caracteres, formada apenas por letras minúsculas sem acentuação.
//    As vogais são as letras ‘a’,‘e’,‘i’,‘o’,‘u’. A sequência contém pelo menos uma vogal.
//            Saída
//
//    Seu programa deve produzir uma linha contendo um caractere, “S” caso a risada seja das mais engraçadas, ou “N” caso contrário.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        char[] letras = in.toCharArray();
        String vogais = "";

        // Extrai as vogais da sequência de caracteres
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == 'a' || letras[i] == 'e' || letras[i] == 'i'
                    || letras[i] == 'o' || letras[i] == 'u') {
                vogais += letras[i];
            }
        }

        char[] v = vogais.toCharArray();
        boolean ver = true;

        // Verifica se as vogais formam uma sequência palíndroma
        for (int i = 0; i < v.length / 2; i++) {
            if (v[i] != v[v.length - 1 - i]) {
                ver = false;
                break;
            }
        }

        if (ver) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }
    }
}
