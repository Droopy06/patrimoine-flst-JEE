package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.Pedagogique;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */
public interface PedagogiqueMapper extends MongoRepository<Pedagogique, String > {
    List<Pedagogique> findAll();
    Pedagogique findOne(String id);
    Pedagogique save(Pedagogique pedagogique);
    void delete(Pedagogique pedagogique);
}
