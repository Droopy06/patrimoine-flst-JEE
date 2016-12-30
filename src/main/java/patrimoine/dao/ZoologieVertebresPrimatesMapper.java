package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.ZoologieVertebresPoissons;
import patrimoine.models.ZoologieVertebresPrimates;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface ZoologieVertebresPrimatesMapper extends MongoRepository<ZoologieVertebresPrimates, String > {
    List<ZoologieVertebresPrimates> findAll();
    ZoologieVertebresPrimates findOne(String id);
    ZoologieVertebresPrimates save(ZoologieVertebresPrimates zoologieVertebresPrimates);
    void delete(ZoologieVertebresPrimates ZoologieVertebresPrimates);
}
