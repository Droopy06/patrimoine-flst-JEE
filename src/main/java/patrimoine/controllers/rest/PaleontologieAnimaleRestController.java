package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.PaleontologieAnimale;
import patrimoine.services.daoServices.PaleontologieAnimaleService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class PaleontologieAnimaleRestController {

    private PaleontologieAnimaleService paleontologieAnimaleService;

    @Autowired
    public PaleontologieAnimaleRestController(PaleontologieAnimaleService paleontologieAnimaleService) {
        this.paleontologieAnimaleService = paleontologieAnimaleService;
    }

    @RequestMapping(value = "/paleontologieanimale",method = RequestMethod.GET)
    public List<PaleontologieAnimale> getAllPaleontologieAnimale(){
        return paleontologieAnimaleService.findAll();
    }

    @RequestMapping(value = "/paleontologieanimale/{id}",method = RequestMethod.GET)
    public PaleontologieAnimale getPaleontologieAnimaleById(@PathVariable("id") String id){
        return paleontologieAnimaleService.findOne(id);
    }
}
