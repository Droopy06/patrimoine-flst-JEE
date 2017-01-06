package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.ZoologieVertebresReptile;
import patrimoine.services.daoServices.ZoologieVertebresReptileService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class ZoologieVertebresReptileRestController {

    private ZoologieVertebresReptileService zoologieVertebresReptileService;

    @Autowired
    public ZoologieVertebresReptileRestController(ZoologieVertebresReptileService zoologieVertebresReptileService) {
        this.zoologieVertebresReptileService = zoologieVertebresReptileService;
    }

    @RequestMapping(value = "/zoologievertebresreptile",method = RequestMethod.GET)
    public List<ZoologieVertebresReptile> getAllZoologieVertebresReptile(){
        return zoologieVertebresReptileService.findAll();
    }

    @RequestMapping(value = "/zoologievertebresreptile/{id}",method = RequestMethod.GET)
    public ZoologieVertebresReptile getZoologieVertebresReptileById(@PathVariable("id") String id){
        return zoologieVertebresReptileService.findOne(id);
    }
}
