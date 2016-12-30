package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.ZoologieInvertebresAutres;
import patrimoine.models.ZoologieVertebresAutres;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface ZoologieVertebresAutresMapper extends MongoRepository<ZoologieVertebresAutres, String > {
    List<ZoologieVertebresAutres> findAll();
    ZoologieVertebresAutres findOne(String id);
    ZoologieVertebresAutres save(ZoologieVertebresAutres zoologieVertebresAutres);
    void delete(ZoologieVertebresAutres zoologieVertebresAutres);
}
