import java.util.Objects;

public class Candidato {
    private final String nomeUrna;
    private final String nomeCompleto;
    private final int numero;
    private long votos;
    Cargo cargo;

    public Candidato(String nomeUrna, String nomeCompleto, int numero, Cargo cargo) {
        this.nomeUrna = nomeUrna;
        this.nomeCompleto = nomeCompleto;
        this.numero = numero;
        this.cargo = cargo;
        this.votos = 0;
    }

    public void receberVoto() {
        votos++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato = (Candidato) o;
        return Objects.equals(nomeUrna, candidato.nomeUrna);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nomeUrna);
    }

    @Override
    public String toString() {
        return String.format("%s     %s      %d", nomeUrna, cargo, numero);
    }

    public String getNomeUrna() {
        return nomeUrna;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public int getNumero() {
        return numero;
    }

    public long getVotos() {
        return votos;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
