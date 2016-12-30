package patrimoine.services.daoServices;

import patrimoine.models.ZoologieInvertebresAutres;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface ZoologieInvertebresAutresService {
    List<ZoologieInvertebresAutres> findAll();
    ZoologieInvertebresAutres findOne(String id);
    ZoologieInvertebresAutres save(ZoologieInvertebresAutres zoologieInvertebresAutres);
    void delete(ZoologieInvertebresAutres zoologieInvertebresAutres);
}
