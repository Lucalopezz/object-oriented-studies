package Try2.application;

import Try2.domain.Declaracao;

public class CriaRelatorioDeclaracoesService {
    private final DeclaracaoRepository repository;

    public CriaRelatorioDeclaracoesService(DeclaracaoRepository repository) {
        this.repository = repository;
    }

    public String criaRelatorio() {

        Declaracao completa = repository.buscarPorId(1).orElseThrow(IllegalArgumentException::new);
        Declaracao simplificada = repository.buscarPorId(1).orElseThrow(IllegalArgumentException::new);

        return simplificada + "\n\n" + completa;
    }
}
