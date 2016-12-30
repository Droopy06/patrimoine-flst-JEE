package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.CollectionDetails;
import patrimoine.models.Herbiers;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface CollectionDetailsMapper extends MongoRepository<CollectionDetails, String > {
    List<CollectionDetails> findAll();
    CollectionDetails findOne(String id);
    CollectionDetails save(CollectionDetails collectionDetails);
    void delete(CollectionDetails collectionDetails);
}
