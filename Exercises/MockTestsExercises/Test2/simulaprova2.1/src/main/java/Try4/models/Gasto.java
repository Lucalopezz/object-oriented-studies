package Try4.models;

import Try4.persistence.Entidade;

import java.util.Objects;

public sealed class Gasto implements Entidade<Long> permits GastoSaude, GastoEducacao{
    public static double idCount = 1;
    private final long id;
    private final String descricao;
    private final double valor;
    private final String cnpj;

    public Gasto(long id, String descricao, double valor, String cnpj) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.cnpj = cnpj;
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
        return String.format("""
                Gasto %d:
                Descricao: %s
                Valor: %.2f
                CNPJ: %s
                """, id, descricao, valor, cnpj);
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getCnpj() {
        return cnpj;
    }
}
