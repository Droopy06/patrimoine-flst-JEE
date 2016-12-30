package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.PaleontologieAnimaleMapper;
import patrimoine.models.PaleontologieAnimale;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class PaleontologieAnimaleServiceImpl implements PaleontologieAnimaleService{

    @Autowired
    PaleontologieAnimaleMapper paleontologieAnimaleMapper;

    @Override
    public List<PaleontologieAnimale> findAll() {
        return paleontologieAnimaleMapper.findAll();
    }

    @Override
    public PaleontologieAnimale findOne(String id) {
        return paleontologieAnimaleMapper.findOne(id);
    }

    @Override
    public PaleontologieAnimale save(PaleontologieAnimale paleontologieAnimale) {
        return paleontologieAnimaleMapper.save(paleontologieAnimale);
    }

    @Override
    public void delete(PaleontologieAnimale paleontologieAnimale) {
        paleontologieAnimaleMapper.delete(paleontologieAnimale);
    }
}
