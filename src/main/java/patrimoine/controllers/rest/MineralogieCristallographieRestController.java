package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.MineralogieCristallographie;
import patrimoine.services.daoServices.MineralogieCristallographieService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class MineralogieCristallographieRestController {

    private MineralogieCristallographieService mineralogieCristallographieService;

    @Autowired
    public MineralogieCristallographieRestController(MineralogieCristallographieService mineralogieCristallographieService) {
        this.mineralogieCristallographieService = mineralogieCristallographieService;
    }

    @RequestMapping(value = "/mineralogiecristallographie",method = RequestMethod.GET)
    public List<MineralogieCristallographie> getAllMineralogieCristallographie(){
        return mineralogieCristallographieService.findAll();
    }

    @RequestMapping(value = "/mineralogiecristallographie/{id}",method = RequestMethod.GET)
    public MineralogieCristallographie getMineralogieCristallographieById(@PathVariable("id") String id){
        return mineralogieCristallographieService.findOne(id);
    }
}
