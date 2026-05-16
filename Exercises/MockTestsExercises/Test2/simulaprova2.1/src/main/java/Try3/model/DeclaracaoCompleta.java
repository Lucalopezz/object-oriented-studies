package Try3.model;

import java.util.ArrayList;
import java.util.List;

import static Try3.model.GastoSaude.DEDUCAO_MAX_SAUDE;

public final class DeclaracaoCompleta extends Declaracao {
    private List<Gasto> gastos;

    public DeclaracaoCompleta(long id, double ganhoTributavel, double valorPago) {
        super(id, ganhoTributavel, valorPago);
        gastos = new ArrayList<>();
    }

    @Override
    public double getValorImposto() {
        double valorImposto = 0;
        double ganhoTributavel = getGanhoTributavel();
        if (ganhoTributavel > 55_976.16) {
            valorImposto = ganhoTributavel * 0.275;
            ganhoTributavel = 55_976.16;
        }
        if (ganhoTributavel > 45_012.73) {
            valorImposto = ganhoTributavel * 0.225;
            ganhoTributavel = 45_012.73;
        }
        if (ganhoTributavel > 33_919.93) {
            valorImposto = ganhoTributavel * 0.15;
            ganhoTributavel = 33_919.93;
        }
        if (ganhoTributavel > 22_847.88) {
            valorImposto = ganhoTributavel * 0.075;
        }
        return valorImposto;
    }

    @Override
    public double getDespesasDedutiveis() {
        double totalSaude = gastos.stream()
                // transforma em educação
                .filter(gasto -> gasto instanceof GastoSaude)
                // pega o valor do gasto
                .mapToDouble(Gasto::getValor)
                // soma
                .sum();

        double totalEducacao = gastos.stream()
                .filter(gasto -> gasto instanceof GastoEducacao)
                .mapToDouble(Gasto::getValor)
                .sum();

        return Math.min(DEDUCAO_MAX_SAUDE, totalSaude) + Math.min(DEDUCAO_MAX_SAUDE, totalEducacao);
    }

    public void addGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto) {
        gastos.remove(gasto);
    }
}
