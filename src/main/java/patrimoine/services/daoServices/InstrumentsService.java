package patrimoine.services.daoServices;

import patrimoine.models.Instruments;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 12/12/2016.
 */
public interface InstrumentsService {
    List<Instruments> findAll();
    Instruments findOne(String id);
    Instruments save(Instruments instruments);
    void delete(Instruments instruments);
}
