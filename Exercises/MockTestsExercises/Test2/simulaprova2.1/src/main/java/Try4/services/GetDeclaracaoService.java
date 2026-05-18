package Try4.services;

import Try4.persistence.DeclaracaoRepository;

public class GetDeclaracaoService {
    private final DeclaracaoRepository declaracaoRepository;

    public GetDeclaracaoService(DeclaracaoRepository declaracaoRepository) {
        this.declaracaoRepository = declaracaoRepository;
    }

    public String getDeclaracao(String id) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException();

        return declaracaoRepository.get(id).orElseThrow().toString();
    }
}
