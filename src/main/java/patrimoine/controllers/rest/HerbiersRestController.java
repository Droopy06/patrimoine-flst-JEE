package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.Herbiers;
import patrimoine.models.Pedagogique;
import patrimoine.services.daoServices.HerbiersService;
import patrimoine.services.daoServices.PedagogiqueService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class HerbiersRestController {

    private HerbiersService herbiersService;

    @Autowired
    public HerbiersRestController(HerbiersService herbiersService) {
        this.herbiersService = herbiersService;
    }

    @RequestMapping(value = "/herbiers",method = RequestMethod.GET)
    public List<Herbiers> getAllHerbiers(){
        return herbiersService.findAll();
    }

    @RequestMapping(value = "/herbiers/{id}",method = RequestMethod.GET)
    public Herbiers getHerbiersById(@PathVariable("id") String id){
        return herbiersService.findOne(id);
    }
}
