package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.ZoologieInvertebresAutres;
import patrimoine.services.daoServices.ZoologieInvertebresAutresService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class ZoologieInvertebresAutresRestController {

    private ZoologieInvertebresAutresService zoologieInvertebresAutresService;

    @Autowired
    public ZoologieInvertebresAutresRestController(ZoologieInvertebresAutresService zoologieInvertebresAutresService) {
        this.zoologieInvertebresAutresService = zoologieInvertebresAutresService;
    }

    @RequestMapping(value = "/zoologieinvertebresautres",method = RequestMethod.GET)
    public List<ZoologieInvertebresAutres> getAllZoologieInvertebresAutres(){
        return zoologieInvertebresAutresService.findAll();
    }

    @RequestMapping(value = "/zoologieinvertebresautres/{id}",method = RequestMethod.GET)
    public ZoologieInvertebresAutres getZoologieInvertebresAutresById(@PathVariable("id") String id){
        return zoologieInvertebresAutresService.findOne(id);
    }
}
