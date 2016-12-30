package patrimoine.services.daoServices;

import patrimoine.models.ZoologieInvertebresAutres;
import patrimoine.models.ZoologieVertebresAutres;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface ZoologieVertebresAutresService {
    List<ZoologieVertebresAutres> findAll();
    ZoologieVertebresAutres findOne(String id);
    ZoologieVertebresAutres save(ZoologieVertebresAutres zoologieVertebresAutres);
    void delete(ZoologieVertebresAutres zoologieVertebresAutres);
}
