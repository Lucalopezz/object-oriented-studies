package Try2.domain;

public final class GastoEducacao extends Gasto {
    public static final double MAX_GASTO_EDUCACAO = 2_000.0;
    private String nomeInstituicao;


    public GastoEducacao(long id, String cnpj, String descricao, double valor, String nomeInstituicao) {
        super(id, cnpj, descricao, valor);
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Nome da Instituição: %s\n", nomeInstituicao);
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }
}
