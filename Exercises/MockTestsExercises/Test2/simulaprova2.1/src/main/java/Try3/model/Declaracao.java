package Try3.model;

import Try3.persistence.Entidade;

import java.util.Objects;

public abstract sealed class Declaracao implements Entidade<Long> permits DeclaracaoCompleta, DeclaracaoSimplificada {
    public static long IDCOUNT = 0;
    private final Long id;
    private double ganhoTributavel;
    private double valorPago;

    public Declaracao(long id, double ganhoTributavel, double valorPago) {
        this.id = id;
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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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

    @Override
    public Long getId() {
        return id;
    }
}
