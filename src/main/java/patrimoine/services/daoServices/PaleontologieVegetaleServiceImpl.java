package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.PaleontologieVegetaleMapper;
import patrimoine.models.PaleontologieVegetale;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class PaleontologieVegetaleServiceImpl implements PaleontologieVegetaleService{

    @Autowired
    private PaleontologieVegetaleMapper paleontologieVegetaleMapper;

    @Override
    public List<PaleontologieVegetale> findAll() {
        return paleontologieVegetaleMapper.findAll();
    }

    @Override
    public PaleontologieVegetale findOne(String id) {
        return paleontologieVegetaleMapper.findOne(id);
    }

    @Override
    public PaleontologieVegetale save(PaleontologieVegetale paleontologieVegetale) {
        return paleontologieVegetaleMapper.save(paleontologieVegetale);
    }

    @Override
    public void delete(PaleontologieVegetale paleontologieVegetale) {
        paleontologieVegetaleMapper.delete(paleontologieVegetale);
    }
}
