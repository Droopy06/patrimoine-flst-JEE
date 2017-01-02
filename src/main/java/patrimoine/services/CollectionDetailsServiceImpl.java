package patrimoine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.CollectionDetailsMapper;
import patrimoine.models.CollectionDetails;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 24/11/2016.
 */
@Service
public class CollectionDetailsServiceImpl implements CollectionDetailsService{

    @Autowired
    private CollectionDetailsMapper collectionDetailsMapper;

    @Override
    public List<CollectionDetails> findAll() {
        return collectionDetailsMapper.findAll();
    }

    @Override
    public CollectionDetails findOne(String id) {
        CollectionDetails collectionDetails = collectionDetailsMapper.findOne(id);
        return (collectionDetails == null) ? new CollectionDetails() : collectionDetails;
    }

    @Override
    public CollectionDetails save(CollectionDetails collectionDetails) {
        return collectionDetailsMapper.save(collectionDetails);
    }

    @Override
    public void delete(CollectionDetails collectionDetails) {
        collectionDetailsMapper.delete(collectionDetails);
    }
}
