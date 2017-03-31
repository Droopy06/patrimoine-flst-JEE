package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.Evenement;
import patrimoine.services.EvenementService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class EvenementRestController {

    private EvenementService evenementService;

    @Autowired
    public EvenementRestController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @RequestMapping(value = "/evenements",method = RequestMethod.GET)
    public List<Evenement> getAllEvenements(){
        return evenementService.findAll();
    }

    @RequestMapping(value = "/evenement/{id}",method = RequestMethod.GET)
    public Evenement getEvenementById(@PathVariable("id") String id){
        List<String> evenements = new ArrayList<>();
        evenements.add(id);
        List<Evenement> evenement = evenementService.findOneByTitle(evenements);
        return evenement.get(0);
    }

   /* @RequestMapping(value = "/evenement/{titre}",method = RequestMethod.GET)
    public Evenement getEvenementByName(@PathVariable("titre") String titre){
        return evenementService.findOne(id);
    } */

}
