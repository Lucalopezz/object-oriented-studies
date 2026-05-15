package Try1;

public final class DeclaracaoSimplificada extends DeclaracaoIR {
    private static final double ALIQUOTA_SIMPLES = 0.20;

    @Override
    protected double calcularImpostoBruto(double rendaTributavelAnual) {
        if (rendaTributavelAnual <= LIMITE_ISENCAO) {
            return 0.0;
        }
        return (rendaTributavelAnual - LIMITE_ISENCAO) * ALIQUOTA_SIMPLES;
    }

    @Override
    public String getTipo() {
        return "SIMPLIFICADA";
    }
}

