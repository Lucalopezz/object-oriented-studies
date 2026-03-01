import java.util.Scanner;

public class Exercise5 {
//    Um investidor principiante deseja aprender a investir na bolsa de valores. Como ele não tem experiência,
//    selecionou uma única empresa, e acompanhou os valores diários das ações dessa empresa, durante NN dias.
//    Ficou curioso quanto teria ganhado se tivesse investido nesse período em que acompanhou os valores.
//    Na verdade, o investidor é milionário e tem muito dinheiro, suficiente para comprar qualquer quantidade de ações da empresa.
//    Entretanto, como é um investidor cuidadoso, decidiu que nunca teria mais do que uma ação da empresa.
//
//    Como sempre há intermediários, a corretora de valores cobra uma taxa fixa de CC reais a cada compra de uma ação da empresa.
//
//    Você deve calcular qual o lucro máximo que o investidor poderia ter auferido, investindo durante alguns dos NN dias, podendo inclusive decidir não investir.
//    Entrada
//
//    A primeira linha contém dois inteiros, NN e C (1 ≤ N ≤ 2 ∗ 105C (1 ≤ N ≤ 2 ∗ 105 e 0≤ C ≤ 30)0≤ C ≤ 30).
//
//    A segunda linha contém as NN cotações P1, P2,..., PNP1​, P2​,..., PN​ , dos dias 1,2,...,N1,2,...,N,
//    respectivamente. Cada cotação PiPi​ satisfaz as desigualdades 1 ≤ Pi ≤ 10001 ≤ Pi​ ≤ 1000.
//    Saída
//
//    Seu programa deve produzir uma única linha com um inteiro representando o lucro máximo do investidor, em reais.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] valores = new int[n];
        for (int i = 0; i < n; i++) {
            valores[i] = sc.nextInt();
        }

        int lucro = 0;
        // lucroComAcao representa o lucro máximo que o investidor teria se tivesse comprado uma ação no dia i
        int lucroComAcao = -valores[0] - c;

        // Loop para calcular o lucro máximo possível a cada dia, considerando as decisões de comprar ou vender ações
        for (int i = 1; i < n; i++) {
            // novoLucro representa o lucro máximo que o investidor teria se decidisse vender a ação no dia i, ou manter o lucro anterior
            int novoLucro = (lucro > lucroComAcao + valores[i]) ? lucro : lucroComAcao + valores[i];
            // novoLucroComAcao representa o lucro máximo que o investidor teria se decidisse comprar uma ação no dia i, ou manter o lucro anterior com ação
            int novoLucroComAcao = (lucroComAcao > lucro - valores[i] - c) ? lucroComAcao : lucro - valores[i] - c;

            lucro = novoLucro;
            lucroComAcao = novoLucroComAcao;
        }

        System.out.println(lucro);
    }
    }
}
