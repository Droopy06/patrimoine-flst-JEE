package patrimoine.services.daoServices;

import patrimoine.models.Physique;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface PhysiqueService {
    List<Physique> findAll();
    Physique findOne(String id);
    Physique save(Physique physique);
    void delete(Physique Physique);
}
