package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.ZoologieVertebresMammiferes;
import patrimoine.services.daoServices.ZoologieVertebresMammiferesService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class ZoologieVertebresMammiferesRestController {

    private ZoologieVertebresMammiferesService zoologieVertebresMammiferesService;

    @Autowired
    public ZoologieVertebresMammiferesRestController(ZoologieVertebresMammiferesService zoologieVertebresMammiferesService) {
        this.zoologieVertebresMammiferesService = zoologieVertebresMammiferesService;
    }

    @RequestMapping(value = "/zoologievertebresmammiferes",method = RequestMethod.GET)
    public List<ZoologieVertebresMammiferes> getAllZoologieVertebresMammiferes(){
        return zoologieVertebresMammiferesService.findAll();
    }

    @RequestMapping(value = "/zoologievertebresmammiferes/{id}",method = RequestMethod.GET)
    public ZoologieVertebresMammiferes getZoologieVertebresMammiferesById(@PathVariable("id") String id){
        return zoologieVertebresMammiferesService.findOne(id);
    }
}
