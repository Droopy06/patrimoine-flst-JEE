package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.InstrumentsMapper;
import patrimoine.models.Instruments;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 12/12/2016.
 */
@Service
public class InstrumentsServiceImpl implements InstrumentsService{

    @Autowired
    private InstrumentsMapper instrumentsMapper;

    @Override
    public List<Instruments> findAll() {
        return instrumentsMapper.findAll();
    }

    @Override
    public Instruments findOne(String id) {
        return instrumentsMapper.findOne(id);
    }

    @Override
    public Instruments save(Instruments instruments) {
        return instrumentsMapper.save(instruments);
    }

    @Override
    public void delete(Instruments instruments) {
        instrumentsMapper.delete(instruments);
    }
}
