package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.ZoologieVertebresOiseaux;
import patrimoine.models.ZoologieVertebresPoissons;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface ZoologieVertebresPoissonsMapper extends MongoRepository<ZoologieVertebresPoissons, String > {
    List<ZoologieVertebresPoissons> findAll();
    ZoologieVertebresPoissons findOne(String id);
    ZoologieVertebresPoissons save(ZoologieVertebresPoissons zoologieVertebresPoissons);
    void delete(ZoologieVertebresPoissons zoologieVertebresPoissons);
}
