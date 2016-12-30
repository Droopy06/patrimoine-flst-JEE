package patrimoine.services.daoServices;

import patrimoine.models.OuvragesCartesDocuments;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
public interface OuvragesCartesDocumentsService {
    List<OuvragesCartesDocuments> findAll();
    OuvragesCartesDocuments findOne(String id);
    OuvragesCartesDocuments save(OuvragesCartesDocuments ouvragesCartesDocuments);
    void delete(OuvragesCartesDocuments ouvragesCartesDocuments);
}
