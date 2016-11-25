package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.helper.template.model.Template;
import patrimoine.models.MaterielPedagogique;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface MaterielPedagogiqueMapper extends MongoRepository<MaterielPedagogique, String > {
    List<MaterielPedagogique> findAll();
    MaterielPedagogique findOne(String id);
    MaterielPedagogique save(MaterielPedagogique materielPedagogique);
    void delete(MaterielPedagogique materielPedagogique);
}
