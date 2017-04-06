package patrimoine.services;

import patrimoine.models.Contact;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/01/16.
 */
public interface ContactService {
    List<Contact> findAllData();
    List<Contact> findAllDataOrderByNameAsc();
    Contact save(Contact contact);
    void delete(Contact contact);
}
