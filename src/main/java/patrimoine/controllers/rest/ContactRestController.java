package patrimoine.controllers.rest;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.helper.DatabaseHelper;
import patrimoine.helper.MailHelper;
import patrimoine.models.Contact;
import patrimoine.services.ContactService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ISEN on 09/12/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class ContactRestController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/contacts",method = RequestMethod.GET)
    public List<Contact> getAllContact(){
        List<Contact> contacts = null;
        contacts = contactService.findAllData();
         return contacts;
    }

    @RequestMapping(value = "/contact/save",method = RequestMethod.POST)
    public Contact saveContact(@RequestBody Contact contact,
                               BindingResult bindingResult) throws Exception {
        Mongo mongo = DatabaseHelper.getInstance();
        DB db = mongo.getDB("patrimoine-flst");
        DBCollection collection = db.getCollection("contact");
        Map<String, Object> documentMapDetail = new HashMap<String, Object>();
        documentMapDetail.put("name", contact.getName());
        documentMapDetail.put("lastName", contact.getLastName());
        documentMapDetail.put("mail", contact.getMail());
        documentMapDetail.put("subject", contact.getSubject());
        documentMapDetail.put("message", contact.getMessage());
        documentMapDetail.put("category", contact.getCategory());
        collection.insert(new BasicDBObject(documentMapDetail));
        MailHelper.envoyerMailSMTP("smtp.gmail.com",465,false,contact);
        return contact;
    }
}

