package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.MineralogieCristallographieMapper;
import patrimoine.models.MineralogieCristallographie;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class MineralogieCristallographieServiceImpl implements MineralogieCristallographieService {

    @Autowired
    private MineralogieCristallographieMapper mineralogieCristallographieMapper;

    @Override
    public List<MineralogieCristallographie> findAll() {
        return mineralogieCristallographieMapper.findAll();
    }

    @Override
    public MineralogieCristallographie findOne(String id) {
        return mineralogieCristallographieMapper.findOne(id);
    }

    @Override
    public MineralogieCristallographie save(MineralogieCristallographie mineralogieCristallographie) {
        return mineralogieCristallographieMapper.save(mineralogieCristallographie);
    }

    @Override
    public void delete(MineralogieCristallographie mineralogieCristallographie) {
        mineralogieCristallographieMapper.delete(mineralogieCristallographie);
    }
}
