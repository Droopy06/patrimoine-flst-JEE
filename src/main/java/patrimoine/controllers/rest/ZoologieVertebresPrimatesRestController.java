package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.ZoologieVertebresPrimates;
import patrimoine.services.daoServices.ZoologieVertebresPrimatesService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class ZoologieVertebresPrimatesRestController {

    private ZoologieVertebresPrimatesService zoologieVertebresPrimatesService;

    @Autowired
    public ZoologieVertebresPrimatesRestController(ZoologieVertebresPrimatesService zoologieVertebresPrimatesService) {
        this.zoologieVertebresPrimatesService = zoologieVertebresPrimatesService;
    }

    @RequestMapping(value = "/zoologievertebresprimates",method = RequestMethod.GET)
    public List<ZoologieVertebresPrimates> getAllZoologieVertebresPrimates(){
        return zoologieVertebresPrimatesService.findAll();
    }

    @RequestMapping(value = "/zoologievertebresprimates/{id}",method = RequestMethod.GET)
    public ZoologieVertebresPrimates getZoologieVertebresPrimatesById(@PathVariable("id") String id){
        return zoologieVertebresPrimatesService.findOne(id);
    }
}
