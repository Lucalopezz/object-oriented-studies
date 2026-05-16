package Try3.application.gasto;


import Try3.model.*;
import Try3.persistence.Declaracaorepository;
import Try3.persistence.GastoRepository;

public class AdiconaGastoService {
    private final Declaracaorepository repo;


    public AdiconaGastoService(Declaracaorepository repo) {
        this.repo = repo;
    }

    public void adiconaGasto(Long id, String descricao, double valor, String cnpj, String tipo, String adicional, Long idDeclaracao) {
        if (id <= 0)
            throw new IllegalArgumentException("O id deve ser positivo.");

        if (descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("A descrição não pode ser nula ou vazia.");

        if (cnpj == null || cnpj.isBlank())
            throw new IllegalArgumentException("O CNPJ não pode ser nulo ou vazio.");

        if (valor <= 0)
            throw new IllegalArgumentException("O valor deve ser positivo.");

        if (tipo == null)
            throw new IllegalArgumentException("O tipo de gasto deve ser informado.");

        if (adicional == null || adicional.isBlank())
            throw new IllegalArgumentException("O campo adicional não pode ser nulo ou vazio.");

        DeclaracaoCompleta declaracao = (DeclaracaoCompleta) repo.getEntidade(id).orElseThrow();

        Gasto gasto = switch (tipo) {
            case "Educacao" -> new GastoEducacao(id, descricao, valor, cnpj, adicional);
            case "Saude" -> new GastoSaude(id, descricao, valor, cnpj, adicional);
            default -> throw new IllegalArgumentException("Tipo de gasto inválido: " + tipo);
        };
        declaracao.addGasto(gasto);
        repo.atualizar(declaracao);

    }
}
