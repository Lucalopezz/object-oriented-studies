package Try3.application.declaracao;

import Try3.model.Declaracao;
import Try3.persistence.Declaracaorepository;

import java.util.Optional;

public class EditaDeclaracaoService {
    private final Declaracaorepository repo;

    public EditaDeclaracaoService(Declaracaorepository repo) {
        this.repo = repo;
    }

    public void editaDeclaracao(Declaracao declaracao) {
        if (declaracao == null) throw new IllegalArgumentException();

        repo.getEntidade(declaracao.getId()).orElseThrow();

        repo.atualizar(declaracao);
    }
}
