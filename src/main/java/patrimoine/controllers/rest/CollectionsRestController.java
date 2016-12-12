package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.Collection;
import patrimoine.models.Pedagogique;
import patrimoine.services.CollectionService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ISEN on 09/12/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class CollectionsRestController {

    @Autowired
    CollectionService collectionService;

    @RequestMapping(value = "/collections",method = RequestMethod.GET)
    public List<Collection> getAllCollections(){
        return collectionService.findAllData();
    }

    @RequestMapping(value = "/collections/save",method = RequestMethod.GET)
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
}
