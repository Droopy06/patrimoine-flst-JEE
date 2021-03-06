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
import patrimoine.services.CollectionService;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
public class MainController {
    @Autowired
    CollectionService collectionService;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public ModelAndView list() {
        //collectionService.initializeData();
        HashMap<String, Object> model = new HashMap<String, Object>();
        //return "patrimoine/index";
        return new ModelAndView("patrimoine/Home",model);
    }
}
