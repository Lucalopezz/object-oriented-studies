package br.ifsp.infection.persistence;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.model.State;

import java.time.LocalDate;

public record BulletinDto(int id,
                          String city,
                          String state,
                          int infected,
                          int deaths,
                          double icuRatio,
                          String date) {

    public Bulletin toEntity(){
        return new Bulletin(id, city, State.fromName(state), infected, deaths, icuRatio, LocalDate.parse(date));
    }
}
