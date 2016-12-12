package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.HerbiersMapper;
import patrimoine.models.Herbiers;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class HerbiersServiceImpl implements HerbiersService{

    @Autowired
    private HerbiersMapper herbiersMapper;

    @Override
    public List<Herbiers> findAll() {
        return herbiersMapper.findAll();
    }

    @Override
    public Herbiers findOne(String id) {
        return herbiersMapper.findOne(id);
    }

    @Override
    public Herbiers save(Herbiers herbiers) {
        return herbiersMapper.save(herbiers);
    }

    @Override
    public void delete(Herbiers herbiers) {
        herbiersMapper.delete(herbiers);
    }
}
