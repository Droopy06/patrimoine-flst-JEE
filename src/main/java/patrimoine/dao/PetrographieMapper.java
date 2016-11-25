package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.helper.template.model.Template;
import patrimoine.models.Petrographie;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface PetrographieMapper extends MongoRepository<Petrographie, String > {
    List<Petrographie> findAll();
    Petrographie findOne(String id);
    Petrographie save(Petrographie petrographie);
    void delete(Petrographie petrographie);
}
