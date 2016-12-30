package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.ZoologieInvertebresAutres;
import patrimoine.models.ZoologieInvertebresInsectes;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface ZoologieInvertebresInsectesMapper extends MongoRepository<ZoologieInvertebresInsectes, String > {
    List<ZoologieInvertebresInsectes> findAll();
    ZoologieInvertebresInsectes findOne(String id);
    ZoologieInvertebresInsectes save(ZoologieInvertebresInsectes zoologieInvertebresInsectes);
    void delete(ZoologieInvertebresInsectes zoologieInvertebresInsectes);
}
