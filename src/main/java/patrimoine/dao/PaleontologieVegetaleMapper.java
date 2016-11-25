package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.PaleontologieAnimale;
import patrimoine.models.PaleontologieVegetale;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface PaleontologieVegetaleMapper extends MongoRepository<PaleontologieVegetale, String > {
    List<PaleontologieVegetale> findAll();
    PaleontologieVegetale findOne(String id);
    PaleontologieVegetale save(PaleontologieVegetale paleontologieVegetale);
    void delete(PaleontologieVegetale paleontologieVegetale);
}
