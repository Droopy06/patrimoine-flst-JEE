package patrimoine.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import patrimoine.models.JardinBotanique;
import patrimoine.services.daoServices.JardinBotaniqueService;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 04/11/2016.
 */
@RestController
@RequestMapping("/rest/patrimoine")
public class JardinBotaniqueRestController {

    private JardinBotaniqueService jardinBotaniqueService;

    @Autowired
    public JardinBotaniqueRestController(JardinBotaniqueService jardinBotaniqueService) {
        this.jardinBotaniqueService = jardinBotaniqueService;
    }

    @RequestMapping(value = "/jardinbotnique",method = RequestMethod.GET)
    public List<JardinBotanique> getAllJardinBotanique(){
        return jardinBotaniqueService.findAll();
    }

    @RequestMapping(value = "/jardinbotnique/{id}",method = RequestMethod.GET)
    public JardinBotanique getJardinBotanique(@PathVariable("id") String id){
        return jardinBotaniqueService.findOne(id);
    }
}
