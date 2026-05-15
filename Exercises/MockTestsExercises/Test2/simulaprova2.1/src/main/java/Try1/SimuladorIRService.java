package Try1;

import Try1.dao.ContribuinteDAO;

public class SimuladorIRService {
    private final ContribuinteDAO contribuinteDAO;
    private final DeclaracaoIR declaracaoSimplificada;
    private final DeclaracaoIR declaracaoCompleta;

    public SimuladorIRService(ContribuinteDAO contribuinteDAO) {
        this.contribuinteDAO = contribuinteDAO;
        this.declaracaoSimplificada = new DeclaracaoSimplificada();
        this.declaracaoCompleta = new DeclaracaoCompleta();
    }

    public ResultadoSimulacao simularPorCpf(String cpf) {
        Contribuinte contribuinte = contribuinteDAO.buscarPorId(cpf)
                .orElseThrow(() -> new RegraNegocioException("Contribuinte nao encontrado para CPF: " + cpf));

        double simplificado = declaracaoSimplificada.calcularImpostoAPagar(contribuinte);
        double completo = declaracaoCompleta.calcularImpostoAPagar(contribuinte);

        return new ResultadoSimulacao(
                contribuinte.getCpf(),
                contribuinte.getNome(),
                contribuinte.getRendaTributavelAnual(),
                contribuinte.getImpostoPagoFonte(),
                simplificado,
                completo
        );
    }
}

