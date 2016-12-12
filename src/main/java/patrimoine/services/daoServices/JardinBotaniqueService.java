package patrimoine.services.daoServices;

import patrimoine.models.Instruments;
import patrimoine.models.JardinBotanique;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 12/12/2016.
 */
public interface JardinBotaniqueService {
    List<JardinBotanique> findAll();
    JardinBotanique findOne(String id);
    JardinBotanique save(JardinBotanique jardinBotanique);
    void delete(JardinBotanique jardinBotanique);
}
