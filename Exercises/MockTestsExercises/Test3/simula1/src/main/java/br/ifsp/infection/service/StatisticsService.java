package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;

import java.util.List;

public class StatisticsService {




    public StatisticData createStatisticData(List<Bulletin> bulletins) {

        final int deaths = bulletins.stream().mapToInt(Bulletin::getDeaths).sum();
        final int infected = bulletins.stream().mapToInt(Bulletin::getInfected).sum();
        final double icu = bulletins.stream().mapToDouble(Bulletin::getIcuRatio).average().orElse(0.0);

        return new StatisticData(deaths, infected, icu);

    }
}
