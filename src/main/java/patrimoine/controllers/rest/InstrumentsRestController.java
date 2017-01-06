package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.Herbiers;
import patrimoine.models.Instruments;
import patrimoine.services.daoServices.HerbiersService;
import patrimoine.services.daoServices.InstrumentsService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class InstrumentsRestController {

    private InstrumentsService instrumentsService;

    @Autowired
    public InstrumentsRestController(InstrumentsService instrumentsService) {
        this.instrumentsService = instrumentsService;
    }

    @RequestMapping(value = "/instruments",method = RequestMethod.GET)
    public List<Instruments> getAllInstruments(){
        return instrumentsService.findAll();
    }

    @RequestMapping(value = "/instruments/{id}",method = RequestMethod.GET)
    public Instruments getInstrumentsById(@PathVariable("id") String id){
        return instrumentsService.findOne(id);
    }
}
