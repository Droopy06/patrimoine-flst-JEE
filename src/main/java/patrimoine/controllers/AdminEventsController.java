package patrimoine.controllers;

import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import patrimoine.helper.Helper;
import patrimoine.models.Evenement;
import patrimoine.services.EvenementService;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Olive on 03/03/2017.
 */
@Controller
public class AdminEventsController {

    private final EvenementService evenementService;

    @Autowired
    public AdminEventsController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @RequestMapping(value = {"/admin/evenement"}, method = RequestMethod.GET)
    public ModelAndView viewEvenement(HttpSession httpSession) throws IOException, BiffException {
        if (Helper.isConnect(httpSession)) {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("evenement", new Evenement());
            return new ModelAndView("patrimoine/Admin_Events", model);
        }
        return new ModelAndView("redirect:/admin");
    }

}

