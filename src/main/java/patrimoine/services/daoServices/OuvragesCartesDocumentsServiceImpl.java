package patrimoine.services.daoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrimoine.dao.OuvragesCartesDocumentsMapper;
import patrimoine.models.OuvragesCartesDocuments;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@Service
public class OuvragesCartesDocumentsServiceImpl implements OuvragesCartesDocumentsService {

    @Autowired
    private OuvragesCartesDocumentsMapper ouvragesCartesDocumentsMapper;


    @Override
    public List<OuvragesCartesDocuments> findAll() {
        return ouvragesCartesDocumentsMapper.findAll();
    }

    @Override
    public OuvragesCartesDocuments findOne(String id) {
        return ouvragesCartesDocumentsMapper.findOne(id);
    }

    @Override
    public OuvragesCartesDocuments save(OuvragesCartesDocuments ouvragesCartesDocuments) {
        return ouvragesCartesDocumentsMapper.save(ouvragesCartesDocuments);
    }

    @Override
    public void delete(OuvragesCartesDocuments ouvragesCartesDocuments) {
        ouvragesCartesDocumentsMapper.delete(ouvragesCartesDocuments);
    }
}
