package Try2.domain;

import Try2.infrastructure.persistence.Entidade;

import java.util.Objects;

public abstract sealed class Declaracao implements Entidade<Long> permits DeclaracaoCompleta, DeclaracaoSimplificada {
    private final long id;
    private double ganhoTributavel;
    private double valorPago;

    public Declaracao(long id, double ganhoTributavel, double valorPago) {
        this.id = id;
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
    }

    public final double getValorAPagar() {
        return getValorImposto() - valorPago - getValorDedutiveis();
    }
    public abstract double getValorImposto();
    public double getValorDedutiveis(){
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Declaração ID: %d\nGanho Tributável: R$%.2f\nValor Pago: R$%.2f\nValor a Pagar: R$%.2f",
                id, ganhoTributavel, valorPago, getValorAPagar());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setGanhoTributavel(double ganhoTributavel) {
        this.ganhoTributavel = ganhoTributavel;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
