package patrimoine.services;

import patrimoine.models.Collection;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/01/16.
 */
public interface CollectionService {
    List<Collection> findAllData();
    List<Collection> findAllDataOrderByNameAsc();
    Collection save(Collection collection);
    void delete(Collection collection);
}
