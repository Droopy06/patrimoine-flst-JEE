package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.Evenement;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 11/04/2016.
 */
public interface EvenementMapper extends MongoRepository<Evenement, String > {
    List<Evenement> findAll();
}
