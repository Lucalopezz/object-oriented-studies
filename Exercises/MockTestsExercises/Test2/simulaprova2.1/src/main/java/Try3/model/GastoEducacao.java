package Try3.model;

public final class GastoEducacao extends Gasto {
    private String nomeInstituicao;
    public static final double DEDUCAO_MAX_EDUCACAO = 2000;
    public GastoEducacao(long id, String descricao, double valor, String cnpj, String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }
    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    @Override
    public String toString() {
        return String.format("%s, nome da instituição= %s", super.toString(), nomeInstituicao);
    }
}
