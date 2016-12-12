package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.PedagogiqueMapper;
import patrimoine.models.Pedagogique;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class PedagogiqueServiceImpl implements PedagogiqueService {

    @Autowired
    PedagogiqueMapper pedagogiqueMapper;

    @Override
    public List<Pedagogique> findAll() {
        return pedagogiqueMapper.findAll();
    }

    @Override
    public Pedagogique findOne(String id) {
        return pedagogiqueMapper.findOne(id);
    }

    @Override
    public Pedagogique save(Pedagogique pedagogique) {
        return pedagogiqueMapper.save(pedagogique);
    }

    @Override
    public void delete(Pedagogique pedagogique) {
        pedagogiqueMapper.delete(pedagogique);
    }
}
