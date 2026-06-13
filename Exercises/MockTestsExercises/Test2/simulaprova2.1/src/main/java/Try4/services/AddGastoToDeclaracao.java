package Try4.services;

import Try4.models.*;
import Try4.persistence.DeclaracaoRepository;

import static Try4.models.Gasto.idCount;

public class AddGastoToDeclaracao {
    private final DeclaracaoRepository declaracaoRepository;

    public AddGastoToDeclaracao(DeclaracaoRepository declaracaoRepository) {
        this.declaracaoRepository = declaracaoRepository;
    }

    public void addGastoDeclaracao(String idDeclaracao, String descricao, double valor, String cnpj, String tipo, String extra) {
        if (idDeclaracao == null || idDeclaracao.isEmpty()) throw new IllegalArgumentException();
        if (descricao == null || descricao.isEmpty()) throw new IllegalArgumentException();
        if (valor <= 0) throw new IllegalArgumentException();
        if (cnpj == null || cnpj.isEmpty()) throw new IllegalArgumentException();
        if (tipo == null || tipo.isEmpty()) throw new IllegalArgumentException();

        Declaracao declaracao = declaracaoRepository.get(idDeclaracao).orElseThrow();
        Gasto gasto;
        if(tipo.equalsIgnoreCase("Educação")){
            gasto = new GastoEducacao(idCount++, descricao, valor, cnpj, extra);
        }else {
            gasto = new GastoSaude(idCount++, descricao, valor, cnpj, extra);
        }
        if (!(declaracao instanceof DeclaracaoCompleta declaracaoCompleta)) return;

        declaracaoCompleta.addGasto(gasto);


        declaracaoRepository.update(declaracaoCompleta);
    }
}
