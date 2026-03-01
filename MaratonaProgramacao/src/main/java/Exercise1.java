import java.util.Scanner;

public class Exercise1 {
//    Figurinhas da Copa
//
//    Em ano de Copa do Mundo de Futebol, o álbum de figurinhas oficial é sempre um grande sucesso entre crianças e também entre adultos.
//    Para quem não conhece, o álbum contém espaços numerados de 1 a NN para colar as figurinhas; cada figurinha,
//    também numerada de 1 a NN, é uma pequena foto de um jogador de uma das seleções que jogará a Copa do Mundo.
//    O objetivo é colar todas as figurinhas nos respectivos espaços no álbum, de modo a completar o álbum (ou seja, não deixar nenhum espaço sem a correspondente figurinha).
//
//    Algumas figurinhas são carimbadas (efetivamente têm um carimbo impresso sobre a fotografia do jogador) e são mais raras, mais difíceis de conseguir.
//
//    As figurinhas são vendidas em envelopes fechados, de forma que o comprador não sabe quais figurinhas está comprando,
//    e pode ocorrer de comprar uma figurinha que ele já tenha colado no álbum. Para ajudar os usuários, a empresa responsável pela venda do álbum
//    e das figurinhas quer criar um aplicativo que permita gerenciar facilmente as figurinhas que faltam para completar o álbum.
//
//    Dados o número total de espaços e figurinhas do álbum (NN), a lista das figurinhas carimbadas e uma lista das figurinhas
//    já compradas (que pode conter figurinhas repetidas), sua tarefa é determinar quantas figurinhas carimbadas faltam para completar o álbum.
//    Entrada
//
//    A primeira linha contém três números inteiros NN, CC e MM indicando respectivamente o número de figurinhas (e espaços) do álbum, o número de figurinhas carimbadas do álbum e o número de figurinhas já compradas. A segunda linha contém CC números inteiros distintos XiXi​ indicando as figurinhas carimbadas do álbum. A terceira linha contém MM números inteiros YiYi​ indicando as figurinhas já compradas.
//            Saída
//
//    Seu programa deve produzir um inteiro representando o número de figurinhas carimbadas que falta para completar o álbum.


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, c, m;


        n = sc.nextInt();
        c = sc.nextInt();
        m = sc.nextInt();

        int[] listC = new int[c];
        int[] listM = new int[m];

        // Preenchendo as listas de carimbadas e compradas
        for (int i = 0; i < c; i++) {
            int in;
            in = sc.nextInt();
            listC[i] = in;
        }
        for (int i = 0; i < m; i++) {
            int in;
            in = sc.nextInt();
            listM[i] = in;
        }

        int count = 0;
        // Verificando quantas carimbadas já foram compradas, e marcando as carimbadas que já foram compradas com -1
        for (int i = 0; i < listC.length; i++) {

            for (int k : listM) {
                if (listC[i] == k) {

                    count++;
                    listC[i] = -1;
                }

            }
        }
        System.out.println(c - count);

    }
}