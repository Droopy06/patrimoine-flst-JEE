package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import patrimoine.models.Collection;
import patrimoine.models.CollectionDetails;
import patrimoine.services.CollectionDetailsService;
import patrimoine.services.CollectionService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ISEN on 09/12/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class CollectionsDetailsRestController {

    @Autowired
    CollectionDetailsService collectionDetailsService;

    @RequestMapping(value = "/collectionsdetails",method = RequestMethod.GET)
    public List<CollectionDetails> getAllDetailsCollections(){
        return collectionDetailsService.findAll();
    }

    @RequestMapping(value = "/collectionsdetails/{name}",method = RequestMethod.GET)
    public CollectionDetails getDetailsCollectionsByName(@PathVariable(value = "name") String name){
        return collectionDetailsService.findOne(name);
    }

    @RequestMapping(value = "/collectionsdetails/save",method = RequestMethod.GET)
    public CollectionDetails saveDetailsCollection(@Valid @ModelAttribute CollectionDetails collectionDetails,
                                       BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            try {
                return collectionDetailsService.save(collectionDetails);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return new CollectionDetails();
    }
}
