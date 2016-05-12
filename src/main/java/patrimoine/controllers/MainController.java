package patrimoine.controllers;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import patrimoine.models.Case;
import patrimoine.models.Collection;
import patrimoine.services.CollectionService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    CollectionService collectionService;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public ModelAndView list() {
        //collectionService.initializeData();
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("case", new Case());
        model.put("case2", new Case());
        //return "patrimoine/index";
        return new ModelAndView("patrimoine/Home",model);
    }
    @RequestMapping(value = { "/search/line" }, method = RequestMethod.POST)
    public void searchByLine(@Valid @ModelAttribute Case myCase, BindingResult results) {
        /*HashMap<String, Object> model = new HashMap<String, Object>();
        if(results.hasErrors()){
            return new ModelAndView("redirect:/",model);
        }else{

            try {
                model.put("search", collectionService.rechercherLigne(myCase.getLigne()));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return new ModelAndView("patrimoine/searchLine",model);
        }*/
    }
    @RequestMapping(value = { "/search/case" }, method = RequestMethod.POST)
    public ModelAndView searchByCase(@Valid @ModelAttribute Case myCase, BindingResult results) {
        HashMap<String, Object> model = new HashMap<String, Object>();
        if(results.hasErrors()){
            return new ModelAndView("redirect:/",model);
        }else{
            try {
                model.put("search", collectionService.rechercheCase(myCase.getLigne(),myCase.getColumn()));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return new ModelAndView("patrimoine/searchCase",model);
        }
    }
}
