package patrimoine.services;

import patrimoine.models.CollectionDetails;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 24/11/2016.
 */
public interface CollectionDetailsService {
    List<CollectionDetails> findAll();
    CollectionDetails findOne(String id);
    CollectionDetails save(CollectionDetails collectionDetails);
    void delete(CollectionDetails collectionDetails);
}
