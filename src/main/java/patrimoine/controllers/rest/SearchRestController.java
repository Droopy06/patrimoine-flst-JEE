package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import patrimoine.models.Collection;
import patrimoine.models.Evenement;
import patrimoine.services.CollectionService;
import patrimoine.services.EvenementService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 05/01/16.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest/patrimone")
public class SearchRestController {

    @Autowired
    CollectionService collectionService;
    @Autowired
    EvenementService evenementService;

    @RequestMapping(value = "/collections",method = RequestMethod.GET)
    public List<Collection> getAllCollections(){
        return collectionService.findAllData();
    }

    @RequestMapping(value = "/collection/save",method = RequestMethod.POST)
    public Collection saveCollection(@Valid @ModelAttribute Collection collection,
                                           BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            try {
                return collectionService.save(collection);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return new Collection();
    }

    @RequestMapping(value = "/evenements",method = RequestMethod.GET)
    public List<Evenement> getAllEvenements(){
        return evenementService.findAllData();
    }
}