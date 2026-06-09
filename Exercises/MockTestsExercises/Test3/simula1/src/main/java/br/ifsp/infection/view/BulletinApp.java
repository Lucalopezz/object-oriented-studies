package br.ifsp.infection.view;



import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.persistence.SqliteBulletinDao;
import br.ifsp.infection.service.*;

public class BulletinApp{
   static void main(){
      SqliteBulletinDao repo = new SqliteBulletinDao();
      var registerService = new RegisterBulletinService(repo);
      var updateService = new UpdateBulletinService(repo);
      var removeService = new RemoveBulletinService(repo);
      var filterService = new FilterBulletinService(repo);
      var statisctService = new StatisticsService();

      registerService.register(new Bulletin(1, "SP", ));
      updateService.update();


   }
}
