package patrimoine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import patrimoine.classes.Table;
import patrimoine.services.PatrimoineService;

import javax.validation.Valid;

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
    public void create(@RequestBody @Valid Table myTable) {
        //patrimoineService.saveCollection(myTable.getmListCase());
    }

}
