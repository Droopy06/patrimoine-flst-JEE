package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.ZoologieInvertebresMollusquesMapper;
import patrimoine.models.ZoologieInvertebresMollusques;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class ZoologieInvertebresMollusquesServiceImpl implements ZoologieInvertebresMollusquesService{

    @Autowired
    private ZoologieInvertebresMollusquesMapper zoologieInvertebresMollusquesMapper;

    @Override
    public List<ZoologieInvertebresMollusques> findAll() {
        return zoologieInvertebresMollusquesMapper.findAll();
    }

    @Override
    public ZoologieInvertebresMollusques findOne(String id) {
        return zoologieInvertebresMollusquesMapper.findOne(id);
    }

    @Override
    public ZoologieInvertebresMollusques save(ZoologieInvertebresMollusques zoologieInvertebresMollusques) {
        return zoologieInvertebresMollusquesMapper.save(zoologieInvertebresMollusques);
    }

    @Override
    public void delete(ZoologieInvertebresMollusques zoologieInvertebresMollusques) {
        zoologieInvertebresMollusquesMapper.delete(zoologieInvertebresMollusques);
    }
}
