package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.helper.template.model.Template;
import patrimoine.models.Typotheque;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface TypothequeMapper extends MongoRepository<Typotheque, String > {
    List<Typotheque> findAll();
    Typotheque findOne(String id);
    Typotheque save(Typotheque typotheque);
    void delete(Typotheque typotheque);
}
