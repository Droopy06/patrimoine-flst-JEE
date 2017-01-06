package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.PaleontologieAnimale;
import patrimoine.models.PaleontologieVegetale;
import patrimoine.services.daoServices.PaleontologieAnimaleService;
import patrimoine.services.daoServices.PaleontologieVegetaleService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class PaleontologieVegetaleRestController {

    private PaleontologieVegetaleService paleontologieVegetaleService;

    @Autowired
    public PaleontologieVegetaleRestController(PaleontologieVegetaleService paleontologieVegetaleService) {
        this.paleontologieVegetaleService = paleontologieVegetaleService;
    }

    @RequestMapping(value = "/paleontologievegetale",method = RequestMethod.GET)
    public List<PaleontologieVegetale> getAllPaleontologieVegetale(){
        return paleontologieVegetaleService.findAll();
    }

    @RequestMapping(value = "/paleontologievegetale/{id}",method = RequestMethod.GET)
    public PaleontologieVegetale getPaleontologieVegetaleById(@PathVariable("id") String id){
        return paleontologieVegetaleService.findOne(id);
    }
}
