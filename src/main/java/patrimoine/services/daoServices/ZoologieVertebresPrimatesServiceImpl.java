package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.ZoologieVertebresPrimatesMapper;
import patrimoine.models.ZoologieVertebresPrimates;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class ZoologieVertebresPrimatesServiceImpl implements ZoologieVertebresPrimatesService{

    @Autowired
    private ZoologieVertebresPrimatesMapper zoologieVertebresPrimatesMapper;

    @Override
    public List<ZoologieVertebresPrimates> findAll() {
        return zoologieVertebresPrimatesMapper.findAll();
    }

    @Override
    public ZoologieVertebresPrimates findOne(String id) {
        return zoologieVertebresPrimatesMapper.findOne(id);
    }

    @Override
    public ZoologieVertebresPrimates save(ZoologieVertebresPrimates zoologieVertebresPrimates) {
        return zoologieVertebresPrimatesMapper.save(zoologieVertebresPrimates);
    }

    @Override
    public void delete(ZoologieVertebresPrimates zoologieVertebresPrimates) {
        zoologieVertebresPrimatesMapper.delete(zoologieVertebresPrimates);
    }
}
