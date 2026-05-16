package Try3.model;

import java.util.Objects;

public abstract sealed class Declaracao permits DeclaracaoCompleta, DeclaracaoSimplificada {
    private double ganhoTributavel;
    private double valorPago;

    public Declaracao(double ganhoTributavel, double valorPago) {
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
    }

    public double getValorAPagar(){
        return getValorImposto() - valorPago - getDespesasDedutiveis();
    }

    public double getDespesasDedutiveis(){
        return 0;
    }

    public abstract double getValorImposto();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return Double.compare(ganhoTributavel, that.ganhoTributavel) == 0 && Double.compare(valorPago, that.valorPago) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ganhoTributavel, valorPago);
    }

    @Override
    public String toString() {
        return String.format("%.2f", ganhoTributavel) + " - " + valorPago;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public void setGanhoTributavel(double ganhoTributavel) {
        this.ganhoTributavel = ganhoTributavel;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
