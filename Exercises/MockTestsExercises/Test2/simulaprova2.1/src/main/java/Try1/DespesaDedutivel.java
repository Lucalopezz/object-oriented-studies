package Try1;

import java.util.Objects;

public class DespesaDedutivel implements Entidade<Long> {
    private final Long id;
    private final TipoDespesa tipo;
    private double valor;

    public DespesaDedutivel(Long id, TipoDespesa tipo, double valor) {
        if (id == null) {
            throw new RegraNegocioException("Id da despesa eh obrigatorio.");
        }
        if (tipo == null) {
            throw new RegraNegocioException("Tipo da despesa eh obrigatorio.");
        }
        validarValor(valor);
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public Long getId() {
        return id;
    }

    public TipoDespesa getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        validarValor(valor);
        this.valor = valor;
    }

    private void validarValor(double valor) {
        if (valor < 0) {
            throw new RegraNegocioException("Valor da despesa nao pode ser negativo.");
        }
    }

    @Override
    public String toString() {
        return "DespesaDedutivel{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", valor=" + valor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DespesaDedutivel that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

