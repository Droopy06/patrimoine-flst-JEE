package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.helper.template.model.Template;
import patrimoine.models.Instruments;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface InstrumentsMapper extends MongoRepository<Instruments, String > {
    List<Instruments> findAll();
    Instruments findOne(String id);
    Instruments save(Instruments instruments);
    void delete(Instruments instruments);
}
