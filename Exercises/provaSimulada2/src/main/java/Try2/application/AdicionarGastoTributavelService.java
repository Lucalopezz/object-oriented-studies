package Try2.application;

import Try2.domain.*;

public class AdicionarGastoTributavelService {
    private final DeclaracaoRepository repository;
    public AdicionarGastoTributavelService(DeclaracaoRepository repository) {
        this.repository = repository;
    }
    public void adcionarGastoTributavel(long id, String descricao, String cnpj,
                                        double valor, TipoGasto tipoGasto, String adicional) {
        if (id <= 0)
            throw new IllegalArgumentException("O id deve ser positivo.");

        if (descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("A descrição não pode ser nula ou vazia.");

        if (cnpj == null || cnpj.isBlank())
            throw new IllegalArgumentException("O CNPJ não pode ser nulo ou vazio.");

        if (valor <= 0)
            throw new IllegalArgumentException("O valor deve ser positivo.");

        if (tipoGasto == null)
            throw new IllegalArgumentException("O tipo de gasto deve ser informado.");

        if (adicional == null || adicional.isBlank())
            throw new IllegalArgumentException("O campo adicional não pode ser nulo ou vazio.");


        final DeclaracaoCompleta declaracao = (DeclaracaoCompleta) repository.buscarPorId(1).orElseThrow(IllegalArgumentException::new);

        Gasto gasto = switch (tipoGasto) {
            case SAUDE -> new GastoSaude(id, descricao, cnpj, valor, adicional);
            case EDUCACAO -> new GastoEducacao(id, descricao, cnpj, valor, adicional);
        };

        declaracao.addGasto(gasto);
        repository.atualizar(declaracao);


    }
}
