package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.ZoologieVertebresPoissons;
import patrimoine.services.daoServices.ZoologieVertebresPoissonsService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class ZoologieVertebresPoissonsRestController {

    private ZoologieVertebresPoissonsService zoologieVertebresPoissonsService;

    @Autowired
    public ZoologieVertebresPoissonsRestController(ZoologieVertebresPoissonsService zoologieVertebresPoissonsService) {
        this.zoologieVertebresPoissonsService = zoologieVertebresPoissonsService;
    }

    @RequestMapping(value = "/zoologievertebrespoissons",method = RequestMethod.GET)
    public List<ZoologieVertebresPoissons> getAllZoologieVertebresPoissons(){
        return zoologieVertebresPoissonsService.findAll();
    }

    @RequestMapping(value = "/zoologievertebrespoissons/{id}",method = RequestMethod.GET)
    public ZoologieVertebresPoissons getZoologieVertebresPoissonsById(@PathVariable("id") String id){
        return zoologieVertebresPoissonsService.findOne(id);
    }
}
