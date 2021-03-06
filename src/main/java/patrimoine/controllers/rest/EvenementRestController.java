package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.helper.database.CustomSortEvenements;
import patrimoine.models.Evenement;
import patrimoine.services.EvenementService;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Evenement> evenements = evenementService.findAll();
        Collections.reverse(evenements);
        return evenements;
    }

    @RequestMapping(value = "/evenement/{id}",method = RequestMethod.GET)
    public Evenement getEvenementById(@PathVariable("id") String id){
        List<String> evenements = new ArrayList<>();
        evenements.add(id);
        List<Evenement> evenement = evenementService.findOneByTitle(evenements);
        return evenement.get(0);
    }

    @RequestMapping(value = "/evenement/position/{number}",method = RequestMethod.GET)
    public Evenement getEvenementByPostion(@PathVariable("number") String number){
        List<Integer> evenements = new ArrayList<>();
        Integer position = Integer.parseInt(number);
        evenements.add(position);
        List<Evenement> evenement = evenementService.findOneByPosition(evenements);
        return evenement.get(0);
    }

    @RequestMapping(value = "/evenement/position/home",method = RequestMethod.GET)
    public List<Evenement> getEvenementForHome(){
        List<Evenement> evenements = evenementService.findEvenementsForHome();
        Collections.sort(evenements,new CustomSortEvenements());
        return evenements;
    }

   /* @RequestMapping(value = "/evenement/{titre}",method = RequestMethod.GET)
    public Evenement getEvenementByName(@PathVariable("titre") String titre){
        return evenementService.findOne(id);
    } */

}
