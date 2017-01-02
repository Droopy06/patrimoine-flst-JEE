package patrimoine.services.daoServices;

import patrimoine.models.Administrator;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface AdministratorService {
    List<Administrator> findAll();
    Administrator findOne(String email);
    Administrator save(Administrator administrator);
    void delete(Administrator administrator);
}
