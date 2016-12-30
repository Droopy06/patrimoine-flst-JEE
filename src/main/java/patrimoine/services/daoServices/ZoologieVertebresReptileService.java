package patrimoine.services.daoServices;

import patrimoine.models.ZoologieVertebresReptile;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface ZoologieVertebresReptileService {
    List<ZoologieVertebresReptile> findAll();
    ZoologieVertebresReptile findOne(String id);
    ZoologieVertebresReptile save(ZoologieVertebresReptile zoologieVertebresReptile);
    void delete(ZoologieVertebresReptile zoologieVertebresReptile);
}
