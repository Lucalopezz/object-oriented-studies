package Try3.application.declaracao;


import Try3.model.Declaracao;
import Try3.persistence.Declaracaorepository;

import java.util.List;

public class ListaDeclaracoesService {
    private final Declaracaorepository repo;

    public ListaDeclaracoesService(Declaracaorepository repo) {
        this.repo = repo;
    }

    public List<Declaracao> listaDeclaracoes() {
        return repo.getEntidades();
    }
}
