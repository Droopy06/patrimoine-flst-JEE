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
import patrimoine.classes.Case;
import patrimoine.services.PatrimoineService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class Patrimoine {
    @Autowired
    PatrimoineService patrimoineService;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public ModelAndView list() {
        if(patrimoineService.findAllData().size() == 0){
            List<List<String>> collection = new ArrayList<List<String>>();
            ArrayList<String> l=new ArrayList<>();
            l.add("nom");
            l.add("age");
            l.add("localité");
            collection.add(0, l);
            ArrayList<String> l1=new ArrayList<>();
            l1.add("loup");
            l1.add("5");
            l1.add("France");
            collection.add(1,l1);
            ArrayList<String> l2=new ArrayList<>();
            l2.add("chat");
            l2.add("10");
            l2.add("Angleterre");
            collection.add(2,l2);
            ArrayList<String> l3=new ArrayList<>();
            l3.add("");
            l3.add("15");
            l3.add("");
            collection.add(3, l3);
            patrimoineService.saveCollection(collection);
        }
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("case", new Case());
        model.put("case2", new Case());
        //return "patrimoine/index";
        return new ModelAndView("patrimoine/index",model);
    }
    @RequestMapping(value = { "/search/line" }, method = RequestMethod.POST)
    public ModelAndView searchByLine(@Valid @ModelAttribute Case myCase, BindingResult results) {
        HashMap<String, Object> model = new HashMap<String, Object>();
        if(results.hasErrors()){
            return new ModelAndView("redirect:/",model);
        }else{

            try {
                model.put("search", patrimoineService.rechercherLigne(myCase.getLigne()));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return new ModelAndView("patrimoine/searchLine",model);
        }
    }
    @RequestMapping(value = { "/search/case" }, method = RequestMethod.POST)
    public ModelAndView searchByCase(@Valid @ModelAttribute Case myCase, BindingResult results) {
        HashMap<String, Object> model = new HashMap<String, Object>();
        if(results.hasErrors()){
            return new ModelAndView("redirect:/",model);
        }else{
            try {
                model.put("search", patrimoineService.rechercheCase(myCase.getLigne(),myCase.getColumn()));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return new ModelAndView("patrimoine/searchCase",model);
        }
    }
}
