package patrimoine.services.daoServices;

import patrimoine.models.PaleontologieVegetale;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface PaleontologieVegetaleService {
    List<PaleontologieVegetale> findAll();
    PaleontologieVegetale findOne(String id);
    PaleontologieVegetale save(PaleontologieVegetale paleontologieVegetale);
    void delete(PaleontologieVegetale paleontologieVegetale);
}
