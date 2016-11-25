package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.Petrographie;
import patrimoine.models.Physique;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface PhysiqueMapper extends MongoRepository<Physique, String > {
    List<Physique> findAll();
    Physique findOne(String id);
    Physique save(Physique physique);
    void delete(Physique physique);
}
