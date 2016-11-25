package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.Typotheque;
import patrimoine.models.ZoologieInvertebresAutres;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface ZoologieInvertebresAutresMapper extends MongoRepository<ZoologieInvertebresAutres, String > {
    List<ZoologieInvertebresAutres> findAll();
    ZoologieInvertebresAutres findOne(String id);
    ZoologieInvertebresAutres save(ZoologieInvertebresAutres zoologieInvertebresAutres);
    void delete(ZoologieInvertebresAutres ZoologieInvertebresAutres);
}
