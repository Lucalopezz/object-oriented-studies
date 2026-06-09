package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.model.State;
import br.ifsp.infection.persistence.GenericDAO;

import java.time.LocalDate;
import java.util.List;


public class FilterBulletinService {
    private final GenericDAO<Integer, Bulletin> repo;

    public FilterBulletinService(GenericDAO<Integer, Bulletin> repo) {
        this.repo = repo;
    }

    List<Bulletin> filter(List<Bulletin> bulletins, String city, String state, LocalDate begin, LocalDate end) {
        return bulletins.stream()
                .filter(b -> city == null || city.isBlank()
                        || b.getCity().equalsIgnoreCase(city))
                .filter(b -> state == null || state.isBlank()
                        || b.getState().toString().equalsIgnoreCase(state))
                .filter(b -> (begin == null || !b.getDate().isBefore(begin))
                        && (end == null || !b.getDate().isAfter(end)))
                .toList();
    }
}

