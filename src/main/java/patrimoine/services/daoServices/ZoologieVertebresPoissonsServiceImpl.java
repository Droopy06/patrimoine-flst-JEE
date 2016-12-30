package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.ZoologieVertebresPoissonsMapper;
import patrimoine.models.ZoologieVertebresPoissons;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class ZoologieVertebresPoissonsServiceImpl implements ZoologieVertebresPoissonsService{

    @Autowired
    private ZoologieVertebresPoissonsMapper zoologieVertebresPoissonsMapper;

    @Override
    public List<ZoologieVertebresPoissons> findAll() {
        return zoologieVertebresPoissonsMapper.findAll();
    }

    @Override
    public ZoologieVertebresPoissons findOne(String id) {
        return zoologieVertebresPoissonsMapper.findOne(id);
    }

    @Override
    public ZoologieVertebresPoissons save(ZoologieVertebresPoissons zoologieVertebresPoissons) {
        return zoologieVertebresPoissonsMapper.save(zoologieVertebresPoissons);
    }

    @Override
    public void delete(ZoologieVertebresPoissons zoologieVertebresPoissons) {
        zoologieVertebresPoissonsMapper.delete(zoologieVertebresPoissons);
    }
}
