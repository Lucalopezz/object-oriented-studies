package br.ifsp.infection.view;



import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.model.State;
import br.ifsp.infection.persistence.BulletinDto;
import br.ifsp.infection.persistence.SqliteBulletinDao;
import br.ifsp.infection.service.*;

import java.time.LocalDate;
import java.util.List;


public class BulletinApp{
   static void main(){
      SqliteBulletinDao repo = new SqliteBulletinDao();
      var registerBulletinService = new RegisterBulletinService(repo);
      var updateBulletinService = new UpdateBulletinService(repo);
      var removeBulletinService = new RemoveBulletinService(repo);
      var filterBulletinService = new FilterBulletinService();
      var statisticsService = new StatisticsService();

      registerBulletinService.register(new Bulletin(0, "Sanca", State.SP, 10, 20, 2.5, LocalDate.now()));
      updateBulletinService.update(new Bulletin(9, "Sancarlos", State.RJ, 11, 21, 3.5, LocalDate.now().plusDays(1)));
      // removeBulletinService.remove(12);

      final List<Bulletin> all = repo.findAll().stream().map(BulletinDto::toEntity).toList();
      all.forEach(System.out::println);

      System.out.println("Filtered: ");
      filterBulletinService.filter(all, "San", State.SP, null, LocalDate.now()).forEach(System.out::println);

      System.out.println("Statistics");
      System.out.println(statisticsService.createStatistics(all));


   }
}
