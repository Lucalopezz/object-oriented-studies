package Try1;

public abstract class DeclaracaoIR {
    protected static final double LIMITE_ISENCAO = 22_847.88;

    public final double calcularImpostoAPagar(Contribuinte contribuinte) {
        if (contribuinte == null) {
            throw new RegraNegocioException("Contribuinte eh obrigatorio para calculo.");
        }

        double impostoBruto = calcularImpostoBruto(contribuinte.getRendaTributavelAnual());
        double deducoes = calcularDeducoes(contribuinte);
        double imposto = impostoBruto - contribuinte.getImpostoPagoFonte() - deducoes;
        return Math.max(0.0, arredondar2Casas(imposto));
    }

    protected abstract double calcularImpostoBruto(double rendaTributavelAnual);

    // Hook method: subclasses may override when they support extra deductions.
    protected double calcularDeducoes(Contribuinte contribuinte) {
        return 0.0;
    }

    public abstract String getTipo();

    protected double arredondar2Casas(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}

