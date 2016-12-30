package patrimoine.services.daoServices;

import patrimoine.models.ZoologieVertebresMammiferes;
import patrimoine.models.ZoologieVertebresOiseaux;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface ZoologieVertebresOiseauxService {
    List<ZoologieVertebresOiseaux> findAll();
    ZoologieVertebresOiseaux findOne(String id);
    ZoologieVertebresOiseaux save(ZoologieVertebresOiseaux zoologieVertebresOiseaux);
    void delete(ZoologieVertebresOiseaux zoologieVertebresOiseaux);
}
