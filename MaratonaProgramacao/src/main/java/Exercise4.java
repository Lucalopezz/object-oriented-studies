import java.util.Scanner;

public class Exercise4 {
    //    Um novo robô de limpeza para um grande salão retangular está sendo desenvolvido.
//    O robô vai percorrer o caminho definido por uma linha marcada no chão, que é coberto com ladrilhos quadrados, brancos e pretos: ladrilhos pretos indicam o caminho que o robô deve percorrer.
//    Ao movimentar-se, o robô pode andar apenas em linha reta, para a frente. Parado, o robô pode girar para as quatro direções (Norte, Sul, Leste e Oeste).
//
//    Dados um mapa indicando a cor de cada ladrilho no chão e a posição inicial do robô, você deve escrever um programa que determine a posição final do robô.
//            Entrada
//
//    A primeira linha contém dois inteiros LL e CC indicando as dimensões do salão (número de linhas e número de colunas), medidas em ladrilhos.
//    A segunda linha contém dois inteiros AA e BB indicando respectivamente a linha e a coluna da posição inicial do robô (as linhas são numeradas de 1 a LL,
//    de cima para baixo; as colunas são numeradas de 1 a CC, da esquerda para a direita). Cada uma das LL linhas seguintes contém CC inteiros, zeros ou uns.
//    Nessa representação, o valor ‘1’ indica que o ladrilho correspondente é preto. O ladrilho da linha AA e coluna BB sempre é preto.
//    O caminho do robô é definido unicamente: em nenhum momento o robô necessita fazer uma escolha sobre em qual direção ir
//    (em outras palavras, todo ladrilho preto tem no máximo dois vizinhos pretos e o ladrilho inicial tem um vizinho preto).
//    Saída
//
//    Seu programa deve imprimir apenas uma linha, contendo dois números inteiros, respectivamente a linha e a coluna da posição final do robô.
//            Restrições
//
//    1≤L,C≤10001≤L,C≤1000
//            1≤A≤L1≤A≤L
//    1≤B≤C1≤B≤C
//    A posição final é diferente da posição inicial.
    public static void main(String[] args) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int C = sc.nextInt();
        int A = sc.nextInt() - 1;
        int B = sc.nextInt() - 1;

        int[][] matriz = new int[L][C];

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < C; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }
        // Variáveis para acompanhar a posição atual e a posição anterior do robô
        int atualX = A;
        int atualY = B;

        int anteriorX = -1;
        int anteriorY = -1;

        // Loop para percorrer o caminho do robô até encontrar a posição final
        while (true) {
            int proxX = -1;
            int proxY = -1;
            // Verifica os quatro vizinhos do ladrilho atual para encontrar o próximo ladrilho preto
            for (int i = 0; i < 4; i++) {
                int nx = atualX + dx[i];
                int ny = atualY + dy[i];

                if (nx >= 0 && nx < L && ny >= 0 && ny < C) {
                    if (matriz[nx][ny] == 1) {
                        if (nx != anteriorX || ny != anteriorY) {
                            proxX = nx;
                            proxY = ny;
                        }
                    }
                }
            }

            if (proxX == -1) {
                break;
            }

            anteriorX = atualX;
            anteriorY = atualY;
            atualX = proxX;
            atualY = proxY;
        }

        System.out.println((atualX + 1) + " " + (atualY + 1));
    }
}

