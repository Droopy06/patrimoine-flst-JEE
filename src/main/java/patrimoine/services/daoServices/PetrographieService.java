package patrimoine.services.daoServices;

import patrimoine.models.Petrographie;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface PetrographieService {
    List<Petrographie> findAll();
    Petrographie findOne(String id);
    Petrographie save(Petrographie petrographie);
    void delete(Petrographie petrographie);
}
