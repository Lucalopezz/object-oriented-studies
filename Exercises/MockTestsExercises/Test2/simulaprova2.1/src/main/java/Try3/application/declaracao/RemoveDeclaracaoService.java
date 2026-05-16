package Try3.application.declaracao;

import Try3.persistence.Declaracaorepository;

public class RemoveDeclaracaoService {
    private final Declaracaorepository repo;

    public RemoveDeclaracaoService(Declaracaorepository repo) {
        this.repo = repo;
    }

    public void removeDeclaracao(Long id) {
        if(id == null) throw new IllegalArgumentException();

        repo.getEntidade(id).orElseThrow();

        repo.removerEntidade(id);
    }
}
