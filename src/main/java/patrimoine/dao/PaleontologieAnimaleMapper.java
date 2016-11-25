package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.helper.template.model.Template;
import patrimoine.models.PaleontologieAnimale;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface PaleontologieAnimaleMapper extends MongoRepository<PaleontologieAnimale, String > {
    List<PaleontologieAnimale> findAll();
    PaleontologieAnimale findOne(String id);
    PaleontologieAnimale save(PaleontologieAnimale paleontologieAnimale);
    void delete(PaleontologieAnimale paleontologieAnimale);
}
