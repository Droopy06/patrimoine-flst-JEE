package patrimoine.services.daoServices;

import patrimoine.models.PaleontologieAnimale;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface PaleontologieAnimaleService {
    List<PaleontologieAnimale> findAll();
    PaleontologieAnimale findOne(String id);
    PaleontologieAnimale save(PaleontologieAnimale paleontologieAnimale);
    void delete(PaleontologieAnimale paleontologieAnimale);
}
