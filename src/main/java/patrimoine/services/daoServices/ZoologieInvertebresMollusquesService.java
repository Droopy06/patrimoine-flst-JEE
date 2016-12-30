package patrimoine.services.daoServices;

import patrimoine.models.ZoologieInvertebresInsectes;
import patrimoine.models.ZoologieInvertebresMollusques;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface ZoologieInvertebresMollusquesService {
    List<ZoologieInvertebresMollusques> findAll();
    ZoologieInvertebresMollusques findOne(String id);
    ZoologieInvertebresMollusques save(ZoologieInvertebresMollusques zoologieInvertebresMollusques);
    void delete(ZoologieInvertebresMollusques zoologieInvertebresMollusques);
}
