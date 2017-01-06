package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.OuvragesCartesDocuments;
import patrimoine.services.daoServices.OuvragesCartesDocumentsService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class OuvragesCartesDocumentsRestController {

    private OuvragesCartesDocumentsService ouvragesCartesDocumentsService;

    @Autowired
    public OuvragesCartesDocumentsRestController(OuvragesCartesDocumentsService ouvragesCartesDocumentsService) {
        this.ouvragesCartesDocumentsService = ouvragesCartesDocumentsService;
    }

    @RequestMapping(value = "/ouvragescartesdocuments",method = RequestMethod.GET)
    public List<OuvragesCartesDocuments> getAllOuvragesCartesDocuments(){
        return ouvragesCartesDocumentsService.findAll();
    }

    @RequestMapping(value = "/ouvragescartesdocuments/{id}",method = RequestMethod.GET)
    public OuvragesCartesDocuments getOuvragesCartesDocumentsById(@PathVariable("id") String id){
        return ouvragesCartesDocumentsService.findOne(id);
    }
}
