package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.helper.template.model.Template;
import patrimoine.models.MineralogieCristallographie;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface MineralogieCristallographieMapper extends MongoRepository<MineralogieCristallographie, String > {
    List<MineralogieCristallographie> findAll();
    MineralogieCristallographie findOne(String id);
    MineralogieCristallographie save(MineralogieCristallographie mineralogieCristallographie);
    void delete(MineralogieCristallographie MineralogieCristallographie);
}
