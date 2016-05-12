package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.Collection;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */
public interface CollectionMapper extends MongoRepository<Collection, String > {
    List<Collection> findAll();
    Collection save(Collection collection);
    void delete(Collection collection);
   /* Table getListById(int id);
    void saveCollection(Table myTable);*/
}
