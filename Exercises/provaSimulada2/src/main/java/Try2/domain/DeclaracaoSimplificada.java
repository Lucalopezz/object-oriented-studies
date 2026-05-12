package Try2.domain;

public final class DeclaracaoSimplificada extends Declaracao {
    public DeclaracaoSimplificada(long id, double ganhoTributavel, double valorPago) {
        super(id, ganhoTributavel, valorPago);
    }

    @Override
    public double getValorImposto() {
        if (getGanhoTributavel() <= 22_847.00) return 0;
        return (getGanhoTributavel() - 22_847.00) * 0.2;
    }

    @Override
    public String toString() {
        return "+++++ DeclaracaoSimplificada +++++ \n" + super.toString();
    }
}
