package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.MaterielPedagogiqueMapper;
import patrimoine.models.MaterielPedagogique;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class MaterielPedagogiqueServiceImpl implements MaterielPedagogiqueService {

    @Autowired
    private MaterielPedagogiqueMapper materielPedagogiqueMapper;

    @Override
    public List<MaterielPedagogique> findAll() {
        return materielPedagogiqueMapper.findAll();
    }

    @Override
    public MaterielPedagogique findOne(String id) {
        return materielPedagogiqueMapper.findOne(id);
    }

    @Override
    public MaterielPedagogique save(MaterielPedagogique materielPedagogique) {
        return materielPedagogiqueMapper.save(materielPedagogique);
    }

    @Override
    public void delete(MaterielPedagogique materielPedagogique) {
        materielPedagogiqueMapper.delete(materielPedagogique);
    }
}
