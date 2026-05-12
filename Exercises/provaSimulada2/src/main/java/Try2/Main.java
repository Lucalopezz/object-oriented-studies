package Try2;

import Try2.application.AdicionarGastoTributavelService;
import Try2.application.CriaRelatorioDeclaracoesService;
import Try2.application.CriarDeclaracoesService;
import Try2.application.TipoGasto;
import Try2.infrastructure.FakeDeclaracaoRepository;

public class Main {
    public static void main(String[] args) {
        final FakeDeclaracaoRepository repository = new FakeDeclaracaoRepository();

        final AdicionarGastoTributavelService adicionarGastoTributavelService = new AdicionarGastoTributavelService(
                repository
        );
        final CriarDeclaracoesService criarDeclaracoesService = new CriarDeclaracoesService(
                repository
        );
        final CriaRelatorioDeclaracoesService criaRelatorioDeclaracoesService = new CriaRelatorioDeclaracoesService(
                repository
        );

        criarDeclaracoesService.criarDeclaracoes(50_000.0, 5_000);

        adicionarGastoTributavelService.adcionarGastoTributavel(1, "Gasto com saúde", "12.345.678/0001-90", 2_000.0, TipoGasto.SAUDE, "Adicional para saúde");
        adicionarGastoTributavelService.adcionarGastoTributavel(2, "Gasto com educação", "98.765.432/0001-10", 3_000.0, TipoGasto.EDUCACAO, "Adicional para educação");


        System.out.println(criaRelatorioDeclaracoesService.criaRelatorio());
    }
}
