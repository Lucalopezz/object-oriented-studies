package Try2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Try2.domain.GastoEducacao.*;
import static Try2.domain.GastoSaude.MAX_GASTO_SAUDE;

public final class DeclaracaoCompleta extends Declaracao {
    public final List<Gasto> gastos;

    public DeclaracaoCompleta(long id, double ganhoTributavel, double valorPago) {
        super(id, ganhoTributavel, valorPago);
        gastos = new ArrayList<>();
    }

    @Override
    public double getValorDedutiveis() {
        double totalSaude = gastos.stream()
                .filter(gasto -> gasto instanceof GastoSaude)
                .mapToDouble(Gasto::getValor)
                .sum();
        double totalEducacao = gastos.stream()
                .filter(gasto -> gasto instanceof GastoEducacao)
                .mapToDouble(Gasto::getValor)
                .sum();


        return Math.min(totalSaude, MAX_GASTO_EDUCACAO)
                + Math.min(totalEducacao, MAX_GASTO_SAUDE);
    }
//    7,5% <R$22.847,88- R$33.919,92>; 15% < R$33.919,93 - R$ 45.012,72>; 22,5% <R$45.012,73 - R$55.976,16> e 27,5%
//    <acima de R$55.976,16>
    @Override
    public double getValorImposto() {
        double valorImposto = 0.0;
        double ganhoTributavelAtual = getGanhoTributavel();
        if (ganhoTributavelAtual > 55_976.16) {
            valorImposto += (ganhoTributavelAtual - 55_976.16) * 0.275;
            ganhoTributavelAtual = 55_976.16;
        }
        if (ganhoTributavelAtual > 45_012.72) {
            valorImposto += (ganhoTributavelAtual - 45_012.72) * 0.225;
            ganhoTributavelAtual = 45_012.72;
        }
        if (ganhoTributavelAtual > 33_919.92) {
            valorImposto += (ganhoTributavelAtual - 33_919.92) * 0.15;
            ganhoTributavelAtual = 33_919.92;
        }
        if (ganhoTributavelAtual > 22_847.88) {
            valorImposto += (ganhoTributavelAtual - 22_847.88) * 0.075;
        }
        return valorImposto;
    }

    @Override
    public String toString() {
        return "+++++ DeclaracaoCompleta +++++ \n"
                + super.toString()
                + "\nGastos dedutiveis:\n"
                + gastos.stream()
                .map(Gasto::toString)
                .collect(Collectors.joining("\n"));
    }

    public void addGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto) {
        gastos.remove(gasto);
    }


}
