package Try3.application.declaracao;

import Try3.model.DeclaracaoCompleta;
import Try3.model.DeclaracaoSimplificada;
import Try3.model.Gasto;
import Try3.persistence.Declaracaorepository;

import java.util.Objects;

import static Try3.model.Declaracao.IDCOUNT;

public class AdicionaDeclaracaoService {
    private final Declaracaorepository repo;

    public AdicionaDeclaracaoService(Declaracaorepository repo) {
        this.repo = repo;
    }
    public void adicionarDeclaracao(double ganhoTributavel, double valorPago) {
        if (ganhoTributavel < 0 || valorPago < 0) throw new IllegalArgumentException();

        DeclaracaoSimplificada declaracaoSimplificada = new DeclaracaoSimplificada(IDCOUNT++, ganhoTributavel, valorPago);
        DeclaracaoCompleta declaracaoCompleta = new DeclaracaoCompleta(IDCOUNT++, ganhoTributavel, valorPago);
        repo.salvar(declaracaoSimplificada);
        repo.salvar(declaracaoCompleta);
    }
}
