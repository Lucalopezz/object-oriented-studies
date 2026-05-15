import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UrnaImp implements Urna {
    private int[] nulos;
    private int[] brancos;

    private Map<Integer, Partido> partidos = new LinkedHashMap<>();

    public UrnaImp() {
        this.nulos = new int[Cargo.values().length];
        this.brancos = new int[Cargo.values().length];
        carregar();
    }

    @Override
    public void carregar() {
        List<String> linhas = carregarCandidatos();

        for (String linha : linhas) {
            String[] split = linha.split(";");

            String nomeUrna = split[0];
            String nomeCompleto = split[1];
            String numeroUrna = split[2];
            int numeroPartido = Integer.parseInt(numeroUrna.substring(0,2));
            String cargo = split[3];
            String nomePartido = split[4];


            partidos.putIfAbsent(numeroPartido, new Partido(numeroPartido, nomePartido));
            Partido partidoCompleto = partidos.get(numeroPartido);

            Candidato candidato = new Candidato(nomeUrna, nomeCompleto, Integer.parseInt(numeroUrna), Cargo.valueOf(cargo));
            partidoCompleto.addCandidato(candidato);
        }
        imprimirPartidos();
        imprimirCandidatos();

    }

    private void imprimirPartidos(){
        System.out.println("\n--------------------------PARTIDOS--------------------------");
        System.out.printf("%-6s %s%n", "Número", "Nome");
        partidos.values().forEach(System.out::println);
    }

    private void imprimirCandidatos(){
        System.out.println("---------------------- CANDIDATOS A DEPUTADO ESTADUAL ---------------------\n");
        System.out.println("Nome         Cargo          Número          Partido");
        partidos.values().stream().map(Partido::getCandidatoParaUrna).forEach(System.out::println);
    }



    @Override
    public void votar() {

    }

    @Override
    public void imprimir() {

    }

    private List<String> carregarCandidatos() {
        return List.of(
                // Deputados Federais (4 dígitos)
                "SANTINHO;JOSÉ SANTOS;1001;DEPUTADO_FEDERAL;REPUBLICANOS",
                "MARIANA SOL;MARIANA OLIVEIRA;1002;DEPUTADO_FEDERAL;REPUBLICANOS",
                "DR. PAULO;PAULO HENRIQUE;1101;DEPUTADO_FEDERAL;PP",
                "VERA LÚCIA;VERA LÚCIA MATOS;1102;DEPUTADO_FEDERAL;PP",
                "CABELEIREIRO;CARLOS CABRAL;1201;DEPUTADO_FEDERAL;PDT",
                "ZEZINHO DO POVO;JOSÉ REZENDE;1301;DEPUTADO_FEDERAL;PT",

                // Deputados Estaduais (5 dígitos)
                "JORGE CUTIGI;JORGE CUTIGI SILVA;10114;DEPUTADO_ESTADUAL;REPUBLICANOS",
                "LUCAS BUENO;LUCAS BUENO FARIA;10115;DEPUTADO_ESTADUAL;REPUBLICANOS",
                "PROFESSORA ANA;ANA PAULA LIMA;11001;DEPUTADO_ESTADUAL;PP",
                "BOMBEIRO JOÃO;JOÃO DA SILVA;12001;DEPUTADO_ESTADUAL;PDT",
                "MÉDICA ROSA;ROSANGELA FERREIRA;13001;DEPUTADO_ESTADUAL;PT",

                // Senadores (3 dígitos)
                "FABINHO;FÁBIO COSTA;101;SENADOR;REPUBLICANOS",
                "CARLÃO;CARLOS MENDES;110;SENADOR;PP",
                "DOUTORA MARTA;MARTA VIEIRA;120;SENADOR;PDT",
                "BETO SENADOR;ROBERTO ALVES;130;SENADOR;PT",

                // Governadores (2 dígitos)
                "RICARDÃO;RICARDO SOUZA;10;GOVERNADOR;REPUBLICANOS",
                "ZÉ GOVERNADOR;JOSÉ GOVERNANTE;11;GOVERNADOR;PP",
                "ALINE GOV;ALINE CASTRO;12;GOVERNADOR;PDT",
                "LULA GOV;LUIZ INÁCIO;13;GOVERNADOR;PT",

                // Presidentes (2 dígitos)
                "FERNANDINHO;FERNANDO ALVES;10;PRESIDENTE;REPUBLICANOS",
                "SILVIO PRES;SILVIO MARQUES;11;PRESIDENTE;PP",
                "MARINA PRES;MARINA SILVA;12;PRESIDENTE;PDT",
                "PETRUS;PEDRO AUGUSTO;13;PRESIDENTE;PT"
        );
    }
}
