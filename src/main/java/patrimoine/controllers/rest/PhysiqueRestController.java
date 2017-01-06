package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.Physique;
import patrimoine.services.daoServices.PhysiqueService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class PhysiqueRestController {

    private PhysiqueService physiqueService;

    @Autowired
    public PhysiqueRestController(PhysiqueService physiqueService) {
        this.physiqueService = physiqueService;
    }

    @RequestMapping(value = "/physique",method = RequestMethod.GET)
    public List<Physique> getAllPhysique(){
        return physiqueService.findAll();
    }

    @RequestMapping(value = "/physique/{id}",method = RequestMethod.GET)
    public Physique getPhysiqueById(@PathVariable("id") String id){
        return physiqueService.findOne(id);
    }
}
