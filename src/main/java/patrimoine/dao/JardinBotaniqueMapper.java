package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.JardinBotanique;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface JardinBotaniqueMapper extends MongoRepository<JardinBotanique, String > {
    List<JardinBotanique> findAll();
    JardinBotanique findOne(String id);
    JardinBotanique save(JardinBotanique jardinBotanique);
    void delete(JardinBotanique jardinBotanique);
}
