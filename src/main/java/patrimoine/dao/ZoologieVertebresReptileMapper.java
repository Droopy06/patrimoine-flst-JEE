package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.ZoologieVertebresPrimates;
import patrimoine.models.ZoologieVertebresReptile;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface ZoologieVertebresReptileMapper extends MongoRepository<ZoologieVertebresReptile, String > {
    List<ZoologieVertebresReptile> findAll();
    ZoologieVertebresReptile findOne(String id);
    ZoologieVertebresReptile save(ZoologieVertebresReptile zoologieVertebresReptile);
    void delete(ZoologieVertebresReptile zoologieVertebresReptile);
}
