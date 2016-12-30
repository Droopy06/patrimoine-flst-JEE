package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.ZoologieVertebresAutresMapper;
import patrimoine.models.ZoologieVertebresAutres;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class ZoologieVertebresAutresServiceImpl implements ZoologieVertebresAutresService{

    @Autowired
    private ZoologieVertebresAutresMapper zoologieVertebresAutresMapper;

    @Override
    public List<ZoologieVertebresAutres> findAll() {
        return zoologieVertebresAutresMapper.findAll();
    }

    @Override
    public ZoologieVertebresAutres findOne(String id) {
        return zoologieVertebresAutresMapper.findOne(id);
    }

    @Override
    public ZoologieVertebresAutres save(ZoologieVertebresAutres zoologieVertebresAutres) {
        return zoologieVertebresAutresMapper.save(zoologieVertebresAutres);
    }

    @Override
    public void delete(ZoologieVertebresAutres zoologieVertebresAutres) {
        zoologieVertebresAutresMapper.delete(zoologieVertebresAutres);
    }
}
