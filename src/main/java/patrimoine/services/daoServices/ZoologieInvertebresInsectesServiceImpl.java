package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.ZoologieInvertebresInsectesMapper;
import patrimoine.models.ZoologieInvertebresInsectes;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class ZoologieInvertebresInsectesServiceImpl implements ZoologieInvertebresInsectesService{

    @Autowired
    private ZoologieInvertebresInsectesMapper zoologieInvertebresInsectesMapper;

    @Override
    public List<ZoologieInvertebresInsectes> findAll() {
        return zoologieInvertebresInsectesMapper.findAll();
    }

    @Override
    public ZoologieInvertebresInsectes findOne(String id) {
        return zoologieInvertebresInsectesMapper.findOne(id);
    }

    @Override
    public ZoologieInvertebresInsectes save(ZoologieInvertebresInsectes zoologieInvertebresInsectes) {
        return zoologieInvertebresInsectesMapper.save(zoologieInvertebresInsectes);
    }

    @Override
    public void delete(ZoologieInvertebresInsectes zoologieInvertebresInsectes) {
        zoologieInvertebresInsectesMapper.delete(zoologieInvertebresInsectes);
    }
}
