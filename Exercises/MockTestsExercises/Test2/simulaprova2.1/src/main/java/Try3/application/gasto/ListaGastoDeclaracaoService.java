package Try3.application.gasto;

import Try3.model.Declaracao;
import Try3.model.DeclaracaoCompleta;
import Try3.model.DeclaracaoSimplificada;
import Try3.model.Gasto;
import Try3.persistence.Declaracaorepository;

import java.util.List;

public class ListaGastoDeclaracaoService {
    private final Declaracaorepository repo;

    public ListaGastoDeclaracaoService(Declaracaorepository repo) {
        this.repo = repo;
    }

    public String getGastoDeclaracao(Long idDeclaracao) {
        Declaracao declaracao = repo.getEntidade(idDeclaracao).orElseThrow(() -> new IllegalArgumentException("Declaração não encontrada para o id: " + idDeclaracao));

        if (declaracao instanceof DeclaracaoCompleta completa){
            return completa.toString();
        }
        if (declaracao instanceof DeclaracaoSimplificada simples){
            return simples.toString();
        }
        return null;
    }
}
