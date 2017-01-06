package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.MaterielPedagogique;
import patrimoine.services.daoServices.MaterielPedagogiqueService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class MaterielPedagogiqueRestController {

    private MaterielPedagogiqueService materielPedagogiqueService;

    @Autowired
    public MaterielPedagogiqueRestController(MaterielPedagogiqueService materielPedagogiqueService) {
        this.materielPedagogiqueService = materielPedagogiqueService;
    }

    @RequestMapping(value = "/materielpedagogique",method = RequestMethod.GET)
    public List<MaterielPedagogique> getAllMaterielPedagogique(){
        return materielPedagogiqueService.findAll();
    }

    @RequestMapping(value = "/materielpedagogique/{id}",method = RequestMethod.GET)
    public MaterielPedagogique getMaterielPedagogiqueById(@PathVariable("id") String id){
        return materielPedagogiqueService.findOne(id);
    }
}
