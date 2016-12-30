package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.ZoologieVertebresReptileMapper;
import patrimoine.models.ZoologieVertebresReptile;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class ZoologieVertebresReptileServiceImpl implements ZoologieVertebresReptileService{

    @Autowired
    private ZoologieVertebresReptileMapper zoologieVertebresReptileMapper;

    @Override
    public List<ZoologieVertebresReptile> findAll() {
        return zoologieVertebresReptileMapper.findAll();
    }

    @Override
    public ZoologieVertebresReptile findOne(String id) {
        return zoologieVertebresReptileMapper.findOne(id);
    }

    @Override
    public ZoologieVertebresReptile save(ZoologieVertebresReptile zoologieVertebresReptile) {
        return zoologieVertebresReptileMapper.save(zoologieVertebresReptile);
    }

    @Override
    public void delete(ZoologieVertebresReptile zoologieVertebresReptile) {
        zoologieVertebresReptileMapper.delete(zoologieVertebresReptile);
    }
}
