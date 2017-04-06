package patrimoine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.ContactMapper;
import patrimoine.models.Contact;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 01/04/2017.
 */
@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public List<Contact> findAllData() {
        return contactMapper.findAll();
    }

    @Override
    public List<Contact> findAllDataOrderByNameAsc() {
        return null;
    }

    @Override
    public Contact save(Contact contact) {
        return contactMapper.save(contact);
    }

    @Override
    public void delete(Contact contact) {
        contactMapper.delete(contact);
    }
}
