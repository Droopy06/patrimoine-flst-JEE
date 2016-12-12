package patrimoine.services.daoServices;

import patrimoine.models.Herbiers;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface HerbiersService {
    List<Herbiers> findAll();
    Herbiers findOne(String id);
    Herbiers save(Herbiers herbiers);
    void delete(Herbiers herbiers);
}
