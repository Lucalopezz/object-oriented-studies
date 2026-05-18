package Try4.models;

import Try4.persistence.Entidade;

import java.util.Objects;

public abstract sealed class Declaracao implements Entidade<String> permits DeclaracaoSimplificada, DeclaracaoCompleta {
    private final String id;
    private final double ganhotributavel;
    private final double valorPago;

    public Declaracao(String id, double ganhotributavel, double valorPago) {
        this.id = id;
        this.ganhotributavel = ganhotributavel;
        this.valorPago = valorPago;
    }

    public double getvalorAPagar() {
        return getValorImposto() - valorPago - getDespesaDedutivel();
    }

    public double getDespesaDedutivel() {
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
        return String.format("""
                Declaração %s:
                ganhotributavel: %.2f
                valorPago: %.2f
                """, id, ganhotributavel, valorPago);
    }

    public double getGanhotributavel() {
        return ganhotributavel;
    }

    public double getValorPago() {
        return valorPago;
    }
}
