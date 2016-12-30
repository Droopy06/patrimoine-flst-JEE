package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.ZoologieVertebresOiseauxMapper;
import patrimoine.models.ZoologieVertebresOiseaux;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class ZoologieVertebresOiseauxServiceImpl implements ZoologieVertebresOiseauxService{

    @Autowired
    private ZoologieVertebresOiseauxMapper zoologieVertebresOiseauxMapper;

    @Override
    public List<ZoologieVertebresOiseaux> findAll() {
        return zoologieVertebresOiseauxMapper.findAll();
    }

    @Override
    public ZoologieVertebresOiseaux findOne(String id) {
        return zoologieVertebresOiseauxMapper.findOne(id);
    }

    @Override
    public ZoologieVertebresOiseaux save(ZoologieVertebresOiseaux zoologieVertebresOiseaux) {
        return zoologieVertebresOiseauxMapper.save(zoologieVertebresOiseaux);
    }

    @Override
    public void delete(ZoologieVertebresOiseaux zoologieVertebresOiseaux) {
        zoologieVertebresOiseauxMapper.delete(zoologieVertebresOiseaux);
    }
}
