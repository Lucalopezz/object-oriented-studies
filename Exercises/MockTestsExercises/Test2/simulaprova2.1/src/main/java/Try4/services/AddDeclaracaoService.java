package Try4.services;

import Try4.models.Declaracao;
import Try4.models.DeclaracaoCompleta;
import Try4.models.DeclaracaoSimplificada;
import Try4.models.Gasto;
import Try4.persistence.DeclaracaoRepository;
import Try4.persistence.GastoRepository;
import Try4.persistence.GenericDAO;

import java.util.UUID;

public class AddDeclaracaoService {
    private final GenericDAO<String, Declaracao> declaracaoRepository;

    public AddDeclaracaoService(GenericDAO declaracaoRepository) {
        this.declaracaoRepository = declaracaoRepository;
    }

    public void add(double ganhotributavel, double valorPago) {
        if (ganhotributavel <= 0 || valorPago <= 0) throw new IllegalArgumentException();
        DeclaracaoSimplificada declaracaoSimplificada = new DeclaracaoSimplificada(UUID.randomUUID().toString(), ganhotributavel, valorPago);
        declaracaoRepository.save(declaracaoSimplificada);

        DeclaracaoCompleta declaracaoCompleta = new DeclaracaoCompleta(UUID.randomUUID().toString(), ganhotributavel, valorPago);
        declaracaoRepository.save(declaracaoCompleta);

    }
}
