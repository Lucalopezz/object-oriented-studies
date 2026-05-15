package Try2.domain;

import Try2.infrastructure.persistence.Entidade;

import java.util.Objects;

public abstract sealed class Gasto implements Entidade<Long> permits GastoEducacao, GastoSaude {
    private final long id;
    private String cnpj;
    private String descricao;
    private double valor;

    public Gasto(long id, String cnpj, String descricao, double valor) {
        this.id = id;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Gasto gasto = (Gasto) o;
        return id == gasto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nCNPJ: %s\nDescrição: %s\nValor: %.2f\n", id, cnpj, descricao, valor);
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
