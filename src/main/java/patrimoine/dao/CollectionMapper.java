package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import patrimoine.models.Collection;
import patrimoine.models.Table;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */
public interface CollectionMapper extends MongoRepository<Collection, String > {
    List<Collection> findAll();
   /* Table getListById(int id);
    void saveCollection(Table myTable);*/
}
