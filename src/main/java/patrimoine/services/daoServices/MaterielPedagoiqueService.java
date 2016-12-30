package patrimoine.services.daoServices;

import patrimoine.models.MaterielPedagogique;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface MaterielPedagoiqueService {
    List<MaterielPedagogique> findAll();
    MaterielPedagogique findOne(String id);
    MaterielPedagogique save(MaterielPedagogique materielPedagogique);
    void delete(MaterielPedagogique materielPedagogique);
}
