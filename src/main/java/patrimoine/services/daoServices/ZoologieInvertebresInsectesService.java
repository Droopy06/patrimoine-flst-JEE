package patrimoine.services.daoServices;

import patrimoine.models.ZoologieInvertebresInsectes;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface ZoologieInvertebresInsectesService {
    List<ZoologieInvertebresInsectes> findAll();
    ZoologieInvertebresInsectes findOne(String id);
    ZoologieInvertebresInsectes save(ZoologieInvertebresInsectes zoologieInvertebresInsectes);
    void delete(ZoologieInvertebresInsectes zoologieInvertebresInsectes);
}
