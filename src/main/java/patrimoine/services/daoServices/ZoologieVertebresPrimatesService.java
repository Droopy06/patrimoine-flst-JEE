package patrimoine.services.daoServices;

import patrimoine.models.ZoologieVertebresPrimates;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface ZoologieVertebresPrimatesService {
    List<ZoologieVertebresPrimates> findAll();
    ZoologieVertebresPrimates findOne(String id);
    ZoologieVertebresPrimates save(ZoologieVertebresPrimates zoologieVertebresPrimates);
    void delete(ZoologieVertebresPrimates zoologieVertebresPrimates);
}
