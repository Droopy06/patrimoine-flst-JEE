package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.ZoologieVertebresMammiferes;
import patrimoine.models.ZoologieVertebresOiseaux;
import patrimoine.services.daoServices.ZoologieVertebresMammiferesService;
import patrimoine.services.daoServices.ZoologieVertebresOiseauxService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class ZoologieVertebresOiseauxRestController {

    private ZoologieVertebresOiseauxService zoologieVertebresOiseauxService;

    @Autowired
    public ZoologieVertebresOiseauxRestController(ZoologieVertebresOiseauxService zoologieVertebresOiseauxService) {
        this.zoologieVertebresOiseauxService = zoologieVertebresOiseauxService;
    }

    @RequestMapping(value = "/zoologievertebresoiseaux",method = RequestMethod.GET)
    public List<ZoologieVertebresOiseaux> getAllZoologieVertebresOiseaux(){
        return zoologieVertebresOiseauxService.findAll();
    }

    @RequestMapping(value = "/zoologievertebresoiseaux/{id}",method = RequestMethod.GET)
    public ZoologieVertebresOiseaux getZoologieVertebresOiseauxById(@PathVariable("id") String id){
        return zoologieVertebresOiseauxService.findOne(id);
    }
}
