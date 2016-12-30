package patrimoine.services.daoServices;

import patrimoine.models.MaterielPedagogique;
import patrimoine.models.MineralogieCristallographie;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface MineralogieCristallographiqueService {
    List<MineralogieCristallographie> findAll();
    MineralogieCristallographie findOne(String id);
    MineralogieCristallographie save(MineralogieCristallographie mineralogieCristallographie);
    void delete(MineralogieCristallographie mineralogieCristallographie);
}
