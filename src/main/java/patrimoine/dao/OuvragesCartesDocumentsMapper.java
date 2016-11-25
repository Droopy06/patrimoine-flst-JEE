package patrimoine.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import patrimoine.helper.template.model.Template;
import patrimoine.models.OuvragesCartesDocuments;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
public interface OuvragesCartesDocumentsMapper extends MongoRepository<OuvragesCartesDocuments, String > {
    List<OuvragesCartesDocuments> findAll();
    OuvragesCartesDocuments findOne(String id);
    OuvragesCartesDocuments save(OuvragesCartesDocuments ouvragesCartesDocuments);
    void delete(OuvragesCartesDocuments ouvragesCartesDocuments);
}
