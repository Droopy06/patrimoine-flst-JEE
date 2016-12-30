package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.ZoologieVertebresMammiferes;
import patrimoine.models.ZoologieVertebresOiseaux;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface ZoologieVertebresOiseauxMapper extends MongoRepository<ZoologieVertebresOiseaux, String > {
    List<ZoologieVertebresOiseaux> findAll();
    ZoologieVertebresOiseaux findOne(String id);
    ZoologieVertebresOiseaux save(ZoologieVertebresOiseaux zoologieVertebresOiseaux);
    void delete(ZoologieVertebresOiseaux zoologieVertebresOiseaux);
}
