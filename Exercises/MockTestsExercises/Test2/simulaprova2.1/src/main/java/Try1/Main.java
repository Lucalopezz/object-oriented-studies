package Try1;

import Try1.dao.ContribuinteDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner scanner;
    private final ContribuinteDAO contribuinteDAO;
    private final SimuladorIRService simulador;
    private long sequencialDespesa;

    public Main() {
        this.scanner = new Scanner(System.in);
        this.contribuinteDAO = new ContribuinteDAO();
        this.simulador = new SimuladorIRService(contribuinteDAO);
        this.sequencialDespesa = 1L;
    }

    public static void main(String[] args) {
        new Main().executar();
    }

    private void executar() {
        int opcao;
        do {
            imprimirMenu();
            opcao = lerInt("Opcao: ");
            try {
                processar(opcao);
            } catch (RegraNegocioException e) {
                System.out.println("Erro de regra: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private void processar(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarContribuinte();
            case 2 -> editarContribuinte();
            case 3 -> removerContribuinte();
            case 4 -> listarContribuintes();
            case 5 -> adicionarDespesa();
            case 6 -> removerDespesa();
            case 7 -> simularImposto();
            case 0 -> System.out.println("Encerrando...");
            default -> System.out.println("Opcao invalida.");
        }
    }

    private void imprimirMenu() {
        System.out.println("\n===== MENU IRPF =====");
        System.out.println("1 - Cadastrar contribuinte");
        System.out.println("2 - Editar contribuinte");
        System.out.println("3 - Remover contribuinte");
        System.out.println("4 - Listar contribuintes");
        System.out.println("5 - Adicionar despesa dedutivel");
        System.out.println("6 - Remover despesa dedutivel");
        System.out.println("7 - Simular imposto");
        System.out.println("0 - Sair");
    }

    private void cadastrarContribuinte() {
        String cpf = lerTexto("CPF: ");
        String nome = lerTexto("Nome: ");
        double renda = lerDouble("Renda tributavel anual: ");
        double impostoPago = lerDouble("Imposto ja pago na fonte: ");

        Contribuinte contribuinte = new Contribuinte(cpf, nome, renda, impostoPago);
        contribuinteDAO.salvar(contribuinte);
        System.out.println("Contribuinte cadastrado com sucesso.");
    }

    private void editarContribuinte() {
        String cpf = lerTexto("CPF do contribuinte: ");
        Contribuinte contribuinte = contribuinteDAO.buscarPorId(cpf)
                .orElseThrow(() -> new RegraNegocioException("Contribuinte nao encontrado."));

        String nome = lerTexto("Novo nome: ");
        double renda = lerDouble("Nova renda tributavel anual: ");
        double impostoPago = lerDouble("Novo imposto pago na fonte: ");

        contribuinte.setNome(nome);
        contribuinte.setRendaTributavelAnual(renda);
        contribuinte.setImpostoPagoFonte(impostoPago);
        contribuinteDAO.salvar(contribuinte);
        System.out.println("Contribuinte atualizado.");
    }

    private void removerContribuinte() {
        String cpf = lerTexto("CPF do contribuinte: ");
        boolean removido = contribuinteDAO.removerPorId(cpf);
        System.out.println(removido ? "Contribuinte removido." : "Contribuinte nao encontrado.");
    }

    private void listarContribuintes() {
        List<Contribuinte> lista = contribuinteDAO.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum contribuinte cadastrado.");
            return;
        }
        lista.forEach(System.out::println);
    }

    private void adicionarDespesa() {
        String cpf = lerTexto("CPF do contribuinte: ");
        Contribuinte contribuinte = contribuinteDAO.buscarPorId(cpf)
                .orElseThrow(() -> new RegraNegocioException("Contribuinte nao encontrado."));

        TipoDespesa tipo = lerTipoDespesa();
        double valor = lerDouble("Valor da despesa: ");

        DespesaDedutivel despesa = new DespesaDedutivel(sequencialDespesa++, tipo, valor);
        contribuinte.adicionarDespesa(despesa);
        contribuinteDAO.salvar(contribuinte);
        System.out.println("Despesa adicionada.");
    }

    private void removerDespesa() {
        String cpf = lerTexto("CPF do contribuinte: ");
        Contribuinte contribuinte = contribuinteDAO.buscarPorId(cpf)
                .orElseThrow(() -> new RegraNegocioException("Contribuinte nao encontrado."));

        long idDespesa = lerLong("Id da despesa: ");
        boolean removido = contribuinte.removerDespesaPorId(idDespesa);
        contribuinteDAO.salvar(contribuinte);
        System.out.println(removido ? "Despesa removida." : "Despesa nao encontrada.");
    }

    private void simularImposto() {
        String cpf = lerTexto("CPF do contribuinte: ");
        ResultadoSimulacao resultado = simulador.simularPorCpf(cpf);

        System.out.println("\n=== Resultado da Simulacao ===");
        System.out.println("CPF: " + resultado.cpfContribuinte());
        System.out.println("Nome: " + resultado.nomeContribuinte());
        System.out.println("Renda tributavel anual: " + resultado.rendaTributavelAnual());
        System.out.println("Imposto pago na fonte: " + resultado.impostoPagoFonte());
        System.out.println("Valor a pagar (Simplificada): " + resultado.impostoSimplificado());
        System.out.println("Valor a pagar (Completa): " + resultado.impostoCompleto());
    }

    private TipoDespesa lerTipoDespesa() {
        String entrada = lerTexto("Tipo da despesa (SAUDE/EDUCACAO): ");
        try {
            return TipoDespesa.valueOf(entrada.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RegraNegocioException("Tipo de despesa invalido. Use SAUDE ou EDUCACAO.");
        }
    }

    private String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    private double lerDouble(String mensagem) {
        System.out.print(mensagem);
        String texto = scanner.nextLine().replace(',', '.').trim();
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new RegraNegocioException("Numero decimal invalido: " + texto);
        }
    }

    private int lerInt(String mensagem) {
        System.out.print(mensagem);
        String texto = scanner.nextLine().trim();
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            throw new RegraNegocioException("Numero inteiro invalido: " + texto);
        }
    }

    private long lerLong(String mensagem) {
        System.out.print(mensagem);
        String texto = scanner.nextLine().trim();
        try {
            return Long.parseLong(texto);
        } catch (NumberFormatException e) {
            throw new RegraNegocioException("Numero inteiro longo invalido: " + texto);
        }
    }
}

