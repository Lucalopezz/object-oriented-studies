package br.edu.ifsp.list03;

/*
Implemente um programa que gere senhas provisórias a partir do nome do usuário, seguindo o mesmo
padrão dos exemplos a seguir:

EXEMPLO 1 Entrada: Java | Saída: J*Ja*Jav*Jav*Ja* J
EXEMPLO 2 Entrada: POOS3 | Saída: P*PO*POO*POOS*POOS*POO*PO*P
EXEMPLO 3 Entrada: KO | Saída: K*K
EXEMPLO 4 Entrada: O | Saída: Invalido
EXEMPLO 5 Entrada: | Saída: Invalido
*/
public class Ex01 {
    static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
    }

    String compute(String input) {

        if (input == null || input.length() <= 1) {
            return "Invalido";
        }
        StringBuilder output = new StringBuilder();

        // for de incremento
        // começa em 1 para clonar a 1 letra e vai ate < para parar antes do ultimo
        for (int i = 1; i < input.length(); i++) {
//            output.append(input.substring(0, i)).append("*"); -> o append faz o papel do substring
            output.append(input, 0, i).append("*");
        }

        //for de decremento
        for (int i = input.length() - 1; i >= 1; i--) {
//            output.append(input.substring(0, i));
            output.append(input, 0, i);
            if (i > 1) {
                output.append("*");
            }

        }


        return output.toString();
    }
}
