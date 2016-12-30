package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.ZoologieInvertebresInsectes;
import patrimoine.models.ZoologieInvertebresMollusques;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface ZoologieInvertebresMollusquesMapper extends MongoRepository<ZoologieInvertebresMollusques, String > {
    List<ZoologieInvertebresMollusques> findAll();
    ZoologieInvertebresMollusques findOne(String id);
    ZoologieInvertebresMollusques save(ZoologieInvertebresMollusques zoologieInvertebresMollusques);
    void delete(ZoologieInvertebresMollusques ZoologieInvertebresMollusques);
}
