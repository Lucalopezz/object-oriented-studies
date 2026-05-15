import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Partido {
    private final Integer numero;
    private final String nome;
    private final Map<String, Candidato> candidatosDeputadoEstadual = new LinkedHashMap<>();
    private final Map<String, Candidato> candidatosDeputadoFederal = new LinkedHashMap<>();
    private final Map<String, Candidato> candidatosSenador = new LinkedHashMap<>();
    private Candidato presidente;
    private Candidato governador;


    public Partido(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }


    public void addCandidato(Candidato candidato){
        if(candidato == null) throw new IllegalArgumentException("Candidato não pode ser nulo");
        switch (candidato.cargo) {
            case DEPUTADO_ESTADUAL -> candidatosDeputadoEstadual.put(candidato.getNomeUrna(), candidato);
            case DEPUTADO_FEDERAL -> candidatosDeputadoFederal.put(candidato.getNomeUrna(), candidato);
            case SENADOR -> candidatosSenador.put(candidato.getNomeUrna(), candidato);
            case PRESIDENTE -> presidente = candidato;
            case GOVERNADOR -> governador = candidato;
        }
    }

    public Candidato getCandidato(Cargo cargo, int numCandidato){
        return switch (cargo) {
            case DEPUTADO_ESTADUAL -> candidatosDeputadoEstadual.get(String.valueOf(numCandidato));
            case DEPUTADO_FEDERAL -> candidatosDeputadoFederal.get(String.valueOf(numCandidato));
            case SENADOR -> candidatosSenador.get(String.valueOf(numCandidato));
            case PRESIDENTE -> presidente;
            case GOVERNADOR -> governador;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return Objects.equals(numero, partido.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }

    @Override
    public String toString() {
        return numero.toString() + "     " + nome;
    }

    public String getCandidatoParaUrna(){
        StringBuilder sb = new StringBuilder();

        sb.append(presidente).append("\n");
        sb.append(governador).append("\n");

        candidatosDeputadoEstadual.values()
                .forEach(c -> sb.append(c).append("\n"));

        candidatosDeputadoFederal.values()
                .forEach(c -> sb.append(c).append("\n"));

        candidatosSenador.values()
                .forEach(c -> sb.append(c).append("\n"));

        return sb.toString();

    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public Map<String, Candidato> getCandidatosDeputadoEstadual() {
        return candidatosDeputadoEstadual;
    }

    public Map<String, Candidato> getCandidatosDeputadoFederal() {
        return candidatosDeputadoFederal;
    }

    public Map<String, Candidato> getCandidatosSenador() {
        return candidatosSenador;
    }

    public Candidato getPresidente() {
        return presidente;
    }

    public Candidato getGovernador() {
        return governador;
    }
}
