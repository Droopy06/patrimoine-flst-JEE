package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.helper.template.model.Template;
import patrimoine.models.Herbiers;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface HerbiersMapper extends MongoRepository<Herbiers, String > {
    List<Herbiers> findAll();
    Herbiers findOne(String id);
    Herbiers save(Herbiers herbiers);
    void delete(Herbiers herbiers);
}
