package patrimoine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import patrimoine.helper.database.CustomSortCollection;
import patrimoine.models.Collection;
import patrimoine.dao.CollectionMapper;
import sun.net.www.MimeTable;

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
        List<Collection> collection = null;
        collection = collectionMapper.findAll();
        java.util.Collections.sort(collection,new CustomSortCollection());
        return collection;
    }

    @Override
    public List<Collection> findAllDataOrderByNameAsc() {

        return collectionMapper.findAll(new Sort(Sort.Direction.DESC, "name"));
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
