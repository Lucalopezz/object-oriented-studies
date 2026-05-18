package Try4.models;

import java.util.ArrayList;
import java.util.List;

import static Try4.models.GastoEducacao.MAX_GASTO_EDUCACAO;
import static Try4.models.GastoSaude.MAX_GASTO_SAUDE;

public final class DeclaracaoCompleta extends Declaracao {
    private List<Gasto> gastos = new ArrayList<>();

    public DeclaracaoCompleta(String id, double ganhotributavel, double valorPago) {
        super(id, ganhotributavel, valorPago);
    }

    //    7,5% <R$22.847,88- R$33.919,92>; 15% < R$33.919,93 - R$ 45.012,72>; 22,5% <R$45.012,73 - R$55.976,16> e 27,5%
//    <acima de R$55.976,16>.
    @Override
    public double getValorImposto() {
        double valorImposto = 0;
        double ganhoTributavelAtual = getGanhotributavel();
        if (ganhoTributavelAtual > 55_976.16) {
            valorImposto += (ganhoTributavelAtual - 55_976.16) * 0.275;
            ganhoTributavelAtual = 55_976.16;
        }
        if (ganhoTributavelAtual > 45_012.73) {
            valorImposto += (ganhoTributavelAtual - 45_012.73) * 0.225;
            ganhoTributavelAtual = 45_012.73;
        }
        if (ganhoTributavelAtual > 33_919.93) {
            valorImposto += (ganhoTributavelAtual - 33_919.93) * 0.15;
            ganhoTributavelAtual = 33_919.93;
        }
        if (ganhoTributavelAtual > 22_847.88) {
            valorImposto += (ganhoTributavelAtual - 22_847.88) * 0.075;
        }
        return valorImposto;
    }

    @Override
    public double getDespesaDedutivel() {
        double gastoEducacao = gastos.stream()
                .filter(gasto -> gasto instanceof GastoEducacao)
                .mapToDouble(Gasto::getValor)
                .sum();
        double gastoSaude = gastos.stream()
                .filter(gasto -> gasto instanceof GastoSaude)
                .mapToDouble(Gasto::getValor)
                .sum();

        return Math.min(gastoEducacao, MAX_GASTO_EDUCACAO) + Math.min(gastoSaude, MAX_GASTO_SAUDE);
    }

    public void addGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto) {
        gastos.remove(gasto);
    }
}
