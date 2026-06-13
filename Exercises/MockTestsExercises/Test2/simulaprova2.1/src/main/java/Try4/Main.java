package Try4;

import Try4.persistence.DeclaracaoRepository;
import Try4.services.AddDeclaracaoService;
import Try4.services.AddGastoToDeclaracao;
import Try4.services.GetDeclaracaoService;

import java.util.Scanner;

public class Main {
    void main() {
        DeclaracaoRepository declaracaoRepository = new DeclaracaoRepository();
        AddDeclaracaoService addDeclaracaoService = new AddDeclaracaoService(declaracaoRepository);
        AddGastoToDeclaracao addGastoToDeclaracao = new AddGastoToDeclaracao(declaracaoRepository);
        GetDeclaracaoService getDeclaracaoService = new GetDeclaracaoService(declaracaoRepository);

        addDeclaracaoService.add(1000, 233);
    }
}
