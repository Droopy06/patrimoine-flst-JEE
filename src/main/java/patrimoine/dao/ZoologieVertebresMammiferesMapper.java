package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.ZoologieVertebresAutres;
import patrimoine.models.ZoologieVertebresMammiferes;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface ZoologieVertebresMammiferesMapper extends MongoRepository<ZoologieVertebresMammiferes, String > {
    List<ZoologieVertebresMammiferes> findAll();
    ZoologieVertebresMammiferes findOne(String id);
    ZoologieVertebresMammiferes save(ZoologieVertebresMammiferes zoologieVertebresMammiferes);
    void delete(ZoologieVertebresMammiferes zoologieVertebresMammiferes);
}
