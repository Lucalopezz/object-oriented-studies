package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.model.State;

import java.time.LocalDate;
import java.util.List;

public class FilterBulletinService {
    public List<Bulletin> filter(List<Bulletin> bulletins, String city, State state, LocalDate begin, LocalDate end){
        return bulletins.stream()
                .filter(b -> city == null || city.isBlank() || b.getCity().toUpperCase().contains(city.toUpperCase()))
                .filter(b -> state == null || b.getState() == state)
                .filter(b -> begin == null || !b.getDate().isBefore(begin))
                .filter(b -> end == null || !b.getDate().isAfter(end))
                .toList();
    }
}
