package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.ZoologieInvertebresInsectes;
import patrimoine.services.daoServices.ZoologieInvertebresInsectesService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class ZoologieInvertebresInsectesRestController {

    private ZoologieInvertebresInsectesService zoologieInvertebresInsectesService;

    @Autowired
    public ZoologieInvertebresInsectesRestController(ZoologieInvertebresInsectesService zoologieInvertebresInsectesService) {
        this.zoologieInvertebresInsectesService = zoologieInvertebresInsectesService;
    }

    @RequestMapping(value = "/zoologieinvertebresinsectes",method = RequestMethod.GET)
    public List<ZoologieInvertebresInsectes> getAllZoologieInvertebresInsectes(){
        return zoologieInvertebresInsectesService.findAll();
    }

    @RequestMapping(value = "/zoologieinvertebresinsectes/{id}",method = RequestMethod.GET)
    public ZoologieInvertebresInsectes getZoologieInvertebresInsectesById(@PathVariable("id") String id){
        return zoologieInvertebresInsectesService.findOne(id);
    }
}
