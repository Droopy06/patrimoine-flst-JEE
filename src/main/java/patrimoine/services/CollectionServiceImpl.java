package patrimoine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.models.Collection;
import patrimoine.dao.CollectionMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/01/16.
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionMapper collectionMapper;

    @Override
    public List<Collection> findAllData() {
        return collectionMapper.findAll();
    }

    @Override
    public Collection save(Collection collection) {
        return collectionMapper.save(collection);
    }

    @Override
    public void delete(Collection collection) {
        collectionMapper.delete(collection);
    }

}
