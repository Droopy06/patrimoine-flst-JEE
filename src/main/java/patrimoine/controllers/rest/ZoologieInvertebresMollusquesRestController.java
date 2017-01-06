package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.ZoologieInvertebresInsectes;
import patrimoine.models.ZoologieInvertebresMollusques;
import patrimoine.services.daoServices.ZoologieInvertebresInsectesService;
import patrimoine.services.daoServices.ZoologieInvertebresMollusquesService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class ZoologieInvertebresMollusquesRestController {

    private ZoologieInvertebresMollusquesService zoologieInvertebresMollusquesService;

    @Autowired
    public ZoologieInvertebresMollusquesRestController(ZoologieInvertebresMollusquesService zoologieInvertebresMollusquesService) {
        this.zoologieInvertebresMollusquesService = zoologieInvertebresMollusquesService;
    }

    @RequestMapping(value = "/zoologieinvertebresmollusques",method = RequestMethod.GET)
    public List<ZoologieInvertebresMollusques> getAllZoologieInvertebresMollusques(){
        return zoologieInvertebresMollusquesService.findAll();
    }

    @RequestMapping(value = "/zoologieinvertebresmollusques/{id}",method = RequestMethod.GET)
    public ZoologieInvertebresMollusques getZoologieInvertebresMollusquesById(@PathVariable("id") String id){
        return zoologieInvertebresMollusquesService.findOne(id);
    }
}
