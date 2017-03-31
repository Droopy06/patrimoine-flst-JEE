package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import patrimoine.helper.database.CustomSortCollection;
import patrimoine.models.Collection;
import patrimoine.models.Evenement;
import patrimoine.models.Pedagogique;
import patrimoine.services.CollectionService;

import javax.validation.Valid;
import java.util.ArrayList;
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
        List<Collection> collections = null;
        collections = collectionService.findAllData();
         return collections;
    }

    @RequestMapping(value = "/collections/order",method = RequestMethod.GET)
    public List<Collection> getAllCollectionsOrder(){
        return collectionService.findAllDataOrderByNameAsc();
    }

    @RequestMapping(value = "/collections/save",method = RequestMethod.POST)
    public Collection saveCollection(@RequestBody Collection collection,
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
