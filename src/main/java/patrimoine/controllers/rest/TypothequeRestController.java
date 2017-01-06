package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.Typotheque;
import patrimoine.services.daoServices.TypothequeService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class TypothequeRestController {

    private TypothequeService typothequeService;

    @Autowired
    public TypothequeRestController(TypothequeService typothequeService) {
        this.typothequeService = typothequeService;
    }

    @RequestMapping(value = "/typotheque",method = RequestMethod.GET)
    public List<Typotheque> getAllTypotheque(){
        return typothequeService.findAll();
    }

    @RequestMapping(value = "/typotheque/{id}",method = RequestMethod.GET)
    public Typotheque getTypothequeById(@PathVariable("id") String id){
        return typothequeService.findOne(id);
    }
}
