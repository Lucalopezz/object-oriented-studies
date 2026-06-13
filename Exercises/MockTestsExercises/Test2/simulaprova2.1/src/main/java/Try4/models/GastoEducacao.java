package Try4.models;

public final class GastoEducacao extends Gasto {
    public static final double MAX_GASTO_EDUCACAO = 2_000.0;
    private final String nomeInstituicao;

    public GastoEducacao(long id, String descricao, double valor, String cnpj,  String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }
    @Override
    public String toString() {
        return String.format("""
                %s
                
                Gato de Educação:
                Nome da instituição: %s
                """, super.toString(), nomeInstituicao);
    }
}
