package patrimoine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import patrimoine.classes.Case;
import patrimoine.classes.Table;
import patrimoine.services.PatrimoineService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 05/01/16.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest/patrimone")
public class PatrimoineRest {

    private final PatrimoineService patrimoineService;

    @Autowired
    public PatrimoineRest(PatrimoineService patrimoineService) {
        this.patrimoineService = patrimoineService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(List<List<String>> maListe) {
        patrimoineService.saveCollection(maListe);
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public List<Table> listData(){
        return patrimoineService.findAllData();
    }*/

    @RequestMapping(value = "/getcase",method = RequestMethod.POST)
    public Case getCaseByLineAndColumn(@Valid @ModelAttribute Case myCase){
        return patrimoineService.rechercheCase(myCase.getLigne(),myCase.getColumn());
    }

    @RequestMapping(value = "/getline",method = RequestMethod.POST)
    public List<Case> getCaseByLine(@Valid @ModelAttribute Case myCase){
        return patrimoineService.rechercherLigne(myCase.getLigne());
    }
}