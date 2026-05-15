package Try1;

public final class DeclaracaoCompleta extends DeclaracaoIR {
    private static final double LIMITE_FAIXA2 = 33_919.92;
    private static final double LIMITE_FAIXA3 = 45_012.72;
    private static final double LIMITE_FAIXA4 = 55_976.16;

    private static final double ALIQUOTA_FAIXA2 = 0.075;
    private static final double ALIQUOTA_FAIXA3 = 0.15;
    private static final double ALIQUOTA_FAIXA4 = 0.225;
    private static final double ALIQUOTA_FAIXA5 = 0.275;

    private static final double LIMITE_DEDUCAO_SAUDE = 1_500.00;
    private static final double LIMITE_DEDUCAO_EDUCACAO = 2_000.00;

    @Override
    protected double calcularImpostoBruto(double rendaTributavelAnual) {
        if (rendaTributavelAnual <= LIMITE_ISENCAO) {
            return 0.0;
        }

        double imposto = 0.0;
        imposto += faixa(rendaTributavelAnual, LIMITE_ISENCAO, LIMITE_FAIXA2) * ALIQUOTA_FAIXA2;
        imposto += faixa(rendaTributavelAnual, LIMITE_FAIXA2, LIMITE_FAIXA3) * ALIQUOTA_FAIXA3;
        imposto += faixa(rendaTributavelAnual, LIMITE_FAIXA3, LIMITE_FAIXA4) * ALIQUOTA_FAIXA4;
        imposto += faixa(rendaTributavelAnual, LIMITE_FAIXA4, Double.MAX_VALUE) * ALIQUOTA_FAIXA5;
        return imposto;
    }

    @Override
    protected double calcularDeducoes(Contribuinte contribuinte) {
        double totalSaude = contribuinte.getDespesas().stream()
                .filter(d -> d.getTipo() == TipoDespesa.SAUDE)
                .mapToDouble(DespesaDedutivel::getValor)
                .sum();

        double totalEducacao = contribuinte.getDespesas().stream()
                .filter(d -> d.getTipo() == TipoDespesa.EDUCACAO)
                .mapToDouble(DespesaDedutivel::getValor)
                .sum();

        return Math.min(totalSaude, LIMITE_DEDUCAO_SAUDE)
                + Math.min(totalEducacao, LIMITE_DEDUCAO_EDUCACAO);
    }

    @Override
    public String getTipo() {
        return "COMPLETA";
    }

    private double faixa(double renda, double inicio, double fim) {
        if (renda <= inicio) {
            return 0.0;
        }
        return Math.min(renda, fim) - inicio;
    }
}

