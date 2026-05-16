import Try3.application.declaracao.AdicionaDeclaracaoService;
import Try3.application.declaracao.EditaDeclaracaoService;
import Try3.application.declaracao.ListaDeclaracoesService;
import Try3.application.declaracao.RemoveDeclaracaoService;
import Try3.application.gasto.AdiconaGastoService;
import Try3.application.gasto.ListaGastoDeclaracaoService;
import Try3.model.Declaracao;
import Try3.persistence.Declaracaorepository;
import Try3.persistence.GenericDAO;

void main(){
    Declaracaorepository repo = new Declaracaorepository();
    AdicionaDeclaracaoService adicionaService = new AdicionaDeclaracaoService(repo);
    EditaDeclaracaoService editaService = new EditaDeclaracaoService(repo);
    RemoveDeclaracaoService removeService = new RemoveDeclaracaoService(repo);
    ListaDeclaracoesService listaService = new ListaDeclaracoesService(repo);

    AdiconaGastoService adicionaGastoService = new AdiconaGastoService(repo);

    adicionaService.adicionarDeclaracao(1000, 200);
    adicionaService.adicionarDeclaracao(2000, 400);

    adicionaGastoService.adiconaGasto(1L, "Hospital", 500, "1232", "Saude", "Posto", 1L);


    System.out.println(listaService.listaDeclaracoes());

    ListaGastoDeclaracaoService listaGastoService = new ListaGastoDeclaracaoService(repo);
    System.out.println(listaGastoService.getGastoDeclaracao(2L));


}