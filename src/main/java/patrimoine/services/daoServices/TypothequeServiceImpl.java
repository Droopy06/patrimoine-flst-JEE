package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.TypothequeMapper;
import patrimoine.models.Typotheque;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class TypothequeServiceImpl implements TypothequeService{

    @Autowired
    private TypothequeMapper typothequeMapper;

    @Override
    public List<Typotheque> findAll() {
        return typothequeMapper.findAll();
    }

    @Override
    public Typotheque findOne(String id) {
        return typothequeMapper.findOne(id);
    }

    @Override
    public Typotheque save(Typotheque typotheque) {
        return typothequeMapper.save(typotheque);
    }

    @Override
    public void delete(Typotheque typotheque) {
        typothequeMapper.delete(typotheque);
    }
}
