package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.JardinBotaniqueMapper;
import patrimoine.models.JardinBotanique;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 12/12/2016.
 */
@Service
public class JardinBotaniqueServiceImpl implements JardinBotaniqueService{

    @Autowired
    private JardinBotaniqueMapper jardinBotaniqueMapper;

    @Override
    public List<JardinBotanique> findAll() {
        return jardinBotaniqueMapper.findAll();
    }

    @Override
    public JardinBotanique findOne(String id) {
        return jardinBotaniqueMapper.findOne(id);
    }

    @Override
    public JardinBotanique save(JardinBotanique jardinBotanique) {
        return jardinBotaniqueMapper.save(jardinBotanique);
    }

    @Override
    public void delete(JardinBotanique jardinBotanique) {
        jardinBotaniqueMapper.delete(jardinBotanique);
    }
}
