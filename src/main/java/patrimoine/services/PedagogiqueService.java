package patrimoine.services;

import patrimoine.models.Pedagogique;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface PedagogiqueService {
    List<Pedagogique> findAll();
    Pedagogique save(Pedagogique pedagogique);
    void delete(Pedagogique pedagogique);
}
