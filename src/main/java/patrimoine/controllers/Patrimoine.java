package patrimoine.controllers;

/**
 * Created by LAMOOT Alexandre on 20/11/15.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import patrimoine.services.PatrimoineService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Patrimoine {
    @Autowired
    PatrimoineService patrimoineService;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String list() {
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
        return "patrimoine/index";
    }
}
