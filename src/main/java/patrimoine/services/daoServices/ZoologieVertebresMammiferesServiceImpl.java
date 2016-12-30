package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.ZoologieVertebresMammiferesMapper;
import patrimoine.models.ZoologieVertebresMammiferes;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class ZoologieVertebresMammiferesServiceImpl implements ZoologieVertebresMammiferesService{

    @Autowired
    private ZoologieVertebresMammiferesMapper zoologieVertebresMammiferesMapper;
    @Override
    public List<ZoologieVertebresMammiferes> findAll() {
        return zoologieVertebresMammiferesMapper.findAll();
    }

    @Override
    public ZoologieVertebresMammiferes findOne(String id) {
        return zoologieVertebresMammiferesMapper.findOne(id);
    }

    @Override
    public ZoologieVertebresMammiferes save(ZoologieVertebresMammiferes zoologieVertebresMammiferes) {
        return zoologieVertebresMammiferesMapper.save(zoologieVertebresMammiferes);
    }

    @Override
    public void delete(ZoologieVertebresMammiferes zoologieVertebresMammiferes) {
        zoologieVertebresMammiferesMapper.delete(zoologieVertebresMammiferes);
    }
}
