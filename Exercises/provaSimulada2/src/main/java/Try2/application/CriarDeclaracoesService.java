package Try2.application;

import Try2.domain.DeclaracaoCompleta;
import Try2.domain.DeclaracaoSimplificada;

public class CriarDeclaracoesService {
    private final DeclaracaoRepository repository;

    public CriarDeclaracoesService(DeclaracaoRepository repository) {
        this.repository = repository;
    }


    public void criarDeclaracoes(double rendaTributavel, double valorPago) {
        if (rendaTributavel < 0 || valorPago < 0)
            throw new IllegalArgumentException("Renda tributável e valor pago devem ser não negativos.");

        final DeclaracaoCompleta declaracaoCompleta = new DeclaracaoCompleta(1, rendaTributavel, valorPago);
        final DeclaracaoSimplificada declaracaoSimplificada = new DeclaracaoSimplificada(2, rendaTributavel, valorPago);

        repository.salvar(declaracaoCompleta);
        repository.salvar(declaracaoSimplificada);
    }
}
