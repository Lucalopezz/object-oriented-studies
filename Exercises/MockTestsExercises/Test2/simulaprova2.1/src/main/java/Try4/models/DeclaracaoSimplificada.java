package Try4.models;

public final class DeclaracaoSimplificada extends Declaracao {
    public DeclaracaoSimplificada(String id, double ganhotributavel, double valorPago) {
        super(id, ganhotributavel, valorPago);
    }

    @Override
    public double getValorImposto() {
//        20% sobre o valor em ganhos tributáveis que ultrapassar R$22.847,88 no ano anterior, menos o valor
//        total já pago pelo contribuinte ao longo dos meses do ano anterior
        if (getGanhotributavel() <= 22_847.88) return 0;
        return (getGanhotributavel() - 22_847.88) * 0.2;
    }
}
