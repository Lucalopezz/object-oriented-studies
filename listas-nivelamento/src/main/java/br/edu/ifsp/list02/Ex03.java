package br.edu.ifsp.list02;

/*
    Leia um conjunto de cinco números inteiros não repetidos em uma única linha e os armazene em um vetor de 10 posições.
    A partir daí, leia um número por vez. Se o número ainda não estiver no conjunto, faça a inclusão após o último número.
    Caso ele esteja no conjunto, remova o número e libere espaço no array. A cada iteração imprima o vetor. O programa
    acaba quando o array ficar totalmente cheio ou vazio. Veja o exemplo na imagem anexa.

    Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".
 */
public class Ex03 {
    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
    }

    String compute(int[] firstFive, int[] otherInts) {
        if (firstFive == null || firstFive.length != 5 || otherInts == null) {
            return "Erro";
        }
        if (temRepetido(firstFive)) return "Erro";

        int[] vetor = new int[10];
        int tamanho = 5;

        System.arraycopy(firstFive, 0, vetor, 0, 5);
//        for (int i = 0; i < 5; i++) {
//            vetor[i] = firstFive[i];
//        }
        String resultado = "";
        resultado += vetorParaString(vetor, tamanho) + "\n";

        for (int num : otherInts) {
            int pos = encontrar(vetor, num, tamanho);
            if (pos == -1) {
                if (tamanho < 10) {
                    vetor[tamanho] = num;
                    tamanho++;
                    resultado += vetorParaString(vetor, tamanho) + "\n";
                } else {
                    break;
                }
            } else {
                remove(vetor, pos, tamanho);
                tamanho--;
                resultado += vetorParaString(vetor, tamanho) + "\n";
                if (tamanho == 0) break;
            }

        }
        return resultado.trim();


    }

    private boolean temRepetido(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private int encontrar(int[] array, int busca, int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i] == busca) {
                return i;
            }
        }
        return -1;
    }

    private void remove(int[] array, int pos, int tamanho) {
        for (int i = pos; i < tamanho; i++) {
            array[i] = array[i + 1];
        }
        array[tamanho - 1] = 0;
    }

    private String vetorParaString(int[] vetor, int tamanho) {
        String s = "";
        for (int i = 0; i < tamanho; i++) {
            s += vetor[i];
            if (i < tamanho - 1) {
                s += " ";
            }
        }
        return s;
    }
}
