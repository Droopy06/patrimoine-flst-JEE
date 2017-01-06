package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.ZoologieVertebresAutres;
import patrimoine.services.daoServices.ZoologieVertebresAutresService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class ZoologieVertebresAutresRestController {

    private ZoologieVertebresAutresService zoologieVertebresAutresService;

    @Autowired
    public ZoologieVertebresAutresRestController(ZoologieVertebresAutresService zoologieVertebresAutresService) {
        this.zoologieVertebresAutresService = zoologieVertebresAutresService;
    }

    @RequestMapping(value = "/zoologievertebresautres",method = RequestMethod.GET)
    public List<ZoologieVertebresAutres> getAllZoologieVertebresAutres(){
        return zoologieVertebresAutresService.findAll();
    }

    @RequestMapping(value = "/zoologievertebresautres/{id}",method = RequestMethod.GET)
    public ZoologieVertebresAutres getZoologieVertebresAutresById(@PathVariable("id") String id){
        return zoologieVertebresAutresService.findOne(id);
    }
}
