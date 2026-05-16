package Try3.model;

public final class DeclaracaoSimplificada extends Declaracao {
    public DeclaracaoSimplificada(long id, double ganhoTributavel, double valorPago) {
        super(id, ganhoTributavel, valorPago);
    }

    @Override
    public double getValorImposto() {
        return getGanhoTributavel() > 22_847.88 ? getGanhoTributavel() * 0.2 : 0;
    }
}
