package patrimoine.services.daoServices;

import patrimoine.models.ZoologieVertebresMammiferes;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface ZoologieVertebresMammiferesService {
    List<ZoologieVertebresMammiferes> findAll();
    ZoologieVertebresMammiferes findOne(String id);
    ZoologieVertebresMammiferes save(ZoologieVertebresMammiferes zoologieVertebresMammiferes);
    void delete(ZoologieVertebresMammiferes zoologieVertebresMammiferes);
}
