package patrimoine.services;

import patrimoine.models.Evenement;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 11/04/2016.
 */
public interface EvenementService {
    List<Evenement> findAll();
    Evenement findOne(String id);
    List<Evenement> findOneByTitle(List<String> title);
    List<Evenement> findOneByPosition(List<Integer> postion);
    Evenement save(Evenement evenement);
    void delete(Evenement evenement);

}
