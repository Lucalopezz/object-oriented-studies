package Try4.models;

public final class GastoSaude extends Gasto {
    private final String registroConselho;
    public static final double MAX_GASTO_SAUDE = 1_500.0;

    public GastoSaude(long id, String descricao, double valor, String cnpj, String registroConselho) {
        super(id, descricao, valor, cnpj);
        this.registroConselho = registroConselho;
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                
                Gato de saúde:
                Registro do Conselho: %s
                """, super.toString(), registroConselho);
    }
}
