package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.Administrator;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface AdministratorMapper extends MongoRepository<Administrator, String > {
    List<Administrator> findAll();
    Administrator findOne(String email);
    Administrator save(Administrator administrator);
    void delete(Administrator administrator);
}
