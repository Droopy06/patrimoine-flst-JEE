package patrimoine.services.daoServices;

import patrimoine.models.Typotheque;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface TypothequeService {
    List<Typotheque> findAll();
    Typotheque findOne(String id);
    Typotheque save(Typotheque typotheque);
    void delete(Typotheque typotheque);
}
