package patrimoine.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.models.Collection;
import patrimoine.models.Contact;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */
public interface ContactMapper extends MongoRepository<Contact, String > {
    List<Contact> findAll();
    List<Contact> findAll(Sort sort);
    Contact save(Contact contact);
    void delete(Contact contact);
}
