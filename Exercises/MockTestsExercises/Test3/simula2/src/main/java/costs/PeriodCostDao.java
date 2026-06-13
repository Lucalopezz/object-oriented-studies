package costs;

import java.util.List;

public interface PeriodCostDao {
    // Lista vazia se não existir nenhum registro
    List<PeriodCostDto> findAll();
}
