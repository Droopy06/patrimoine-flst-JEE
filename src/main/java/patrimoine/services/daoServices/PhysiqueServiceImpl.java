package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.PhysiqueMapper;
import patrimoine.models.Physique;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class PhysiqueServiceImpl implements PhysiqueService{

    @Autowired
    private PhysiqueMapper physiqueMapper;

    @Override
    public List<Physique> findAll() {
        return physiqueMapper.findAll();
    }

    @Override
    public Physique findOne(String id) {
        return physiqueMapper.findOne(id);
    }

    @Override
    public Physique save(Physique physique) {
        return physiqueMapper.save(physique);
    }

    @Override
    public void delete(Physique Physique) {
        physiqueMapper.delete(Physique);
    }
}
