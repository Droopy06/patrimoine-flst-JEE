package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.ZoologieInvertebresAutresMapper;
import patrimoine.models.ZoologieInvertebresAutres;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class ZoologieInvertebresAutresServiceImpl implements ZoologieInvertebresAutresService{

    @Autowired
    private ZoologieInvertebresAutresMapper zoologieInvertebresAutresMapper;

    @Override
    public List<ZoologieInvertebresAutres> findAll() {
        return zoologieInvertebresAutresMapper.findAll();
    }

    @Override
    public ZoologieInvertebresAutres findOne(String id) {
        return zoologieInvertebresAutresMapper.findOne(id);
    }

    @Override
    public ZoologieInvertebresAutres save(ZoologieInvertebresAutres zoologieInvertebresAutres) {
        return zoologieInvertebresAutresMapper.save(zoologieInvertebresAutres);
    }

    @Override
    public void delete(ZoologieInvertebresAutres zoologieInvertebresAutres) {
        zoologieInvertebresAutresMapper.delete(zoologieInvertebresAutres);
    }
}
