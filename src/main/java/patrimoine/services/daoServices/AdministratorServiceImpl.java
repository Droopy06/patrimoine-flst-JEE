package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.AdministratorMapper;
import patrimoine.models.Administrator;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class AdministratorServiceImpl implements AdministratorService{

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public List<Administrator> findAll() {
        return administratorMapper.findAll();
    }

    @Override
    public Administrator findOne(String email) {
        return administratorMapper.findOne(email);
    }

    @Override
    public Administrator save(Administrator administrator) {
        return administratorMapper.save(administrator);
    }

    @Override
    public void delete(Administrator administrator) {
        administratorMapper.delete(administrator);
    }
}
