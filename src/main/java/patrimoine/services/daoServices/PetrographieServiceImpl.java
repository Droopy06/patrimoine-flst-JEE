package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.PetrographieMapper;
import patrimoine.models.Petrographie;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class PetrographieServiceImpl implements PetrographieService{

    @Autowired
    private PetrographieMapper petrographieMapper;

    @Override
    public List<Petrographie> findAll() {
        return petrographieMapper.findAll();
    }

    @Override
    public Petrographie findOne(String id) {
        return petrographieMapper.findOne(id);
    }

    @Override
    public Petrographie save(Petrographie petrographie) {
        return petrographieMapper.save(petrographie);
    }

    @Override
    public void delete(Petrographie petrographie) {
        petrographieMapper.delete(petrographie);
    }
}
