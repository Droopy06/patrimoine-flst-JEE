package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.Petrographie;
import patrimoine.services.daoServices.PetrographieService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class PetrographieRestController {

    private PetrographieService petrographieService;

    @Autowired
    public PetrographieRestController(PetrographieService petrographieService) {
        this.petrographieService = petrographieService;
    }

    @RequestMapping(value = "/petrographie",method = RequestMethod.GET)
    public List<Petrographie> getAllPaleontologieVegetale(){
        return petrographieService.findAll();
    }

    @RequestMapping(value = "/petrographie/{id}",method = RequestMethod.GET)
    public Petrographie getPaleontologieVegetaleById(@PathVariable("id") String id){
        return petrographieService.findOne(id);
    }
}
