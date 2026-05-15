package Try1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Contribuinte implements Entidade<String> {
    private final String cpf;
    private String nome;
    private double rendaTributavelAnual;
    private double impostoPagoFonte;
    private final List<DespesaDedutivel> despesas;

    public Contribuinte(String cpf, String nome, double rendaTributavelAnual, double impostoPagoFonte) {
        validarCpf(cpf);
        validarNome(nome);
        validarNaoNegativo(rendaTributavelAnual, "Renda tributavel anual");
        validarNaoNegativo(impostoPagoFonte, "Imposto pago na fonte");

        this.cpf = cpf;
        this.nome = nome;
        this.rendaTributavelAnual = rendaTributavelAnual;
        this.impostoPagoFonte = impostoPagoFonte;
        this.despesas = new ArrayList<>();
    }

    @Override
    public String getId() {
        return cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public double getRendaTributavelAnual() {
        return rendaTributavelAnual;
    }

    public void setRendaTributavelAnual(double rendaTributavelAnual) {
        validarNaoNegativo(rendaTributavelAnual, "Renda tributavel anual");
        this.rendaTributavelAnual = rendaTributavelAnual;
    }

    public double getImpostoPagoFonte() {
        return impostoPagoFonte;
    }

    public void setImpostoPagoFonte(double impostoPagoFonte) {
        validarNaoNegativo(impostoPagoFonte, "Imposto pago na fonte");
        this.impostoPagoFonte = impostoPagoFonte;
    }

    public List<DespesaDedutivel> getDespesas() {
        return Collections.unmodifiableList(despesas);
    }

    public void adicionarDespesa(DespesaDedutivel despesa) {
        if (despesa == null) {
            throw new RegraNegocioException("Despesa nao pode ser nula.");
        }
        despesas.add(despesa);
    }

    public boolean removerDespesaPorId(Long idDespesa) {
        return despesas.removeIf(d -> d.getId().equals(idDespesa));
    }

    private void validarCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new RegraNegocioException("CPF eh obrigatorio.");
        }
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new RegraNegocioException("Nome eh obrigatorio.");
        }
    }

    private void validarNaoNegativo(double valor, String campo) {
        if (valor < 0) {
            throw new RegraNegocioException(campo + " nao pode ser negativo.");
        }
    }

    @Override
    public String toString() {
        return "Contribuinte{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", rendaTributavelAnual=" + rendaTributavelAnual +
                ", impostoPagoFonte=" + impostoPagoFonte +
                ", despesas=" + despesas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contribuinte that)) return false;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}

