package patrimoine.services.daoServices;

import patrimoine.models.ZoologieVertebresPoissons;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface ZoologieVertebresPoissonsService {
    List<ZoologieVertebresPoissons> findAll();
    ZoologieVertebresPoissons findOne(String id);
    ZoologieVertebresPoissons save(ZoologieVertebresPoissons zoologieVertebresPoissons);
    void delete(ZoologieVertebresPoissons zoologieVertebresPoissons);
}
