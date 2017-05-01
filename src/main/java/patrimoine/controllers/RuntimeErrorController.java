package patrimoine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LAMOOT Alexandre on 01/05/2017.
 */
@Controller
public class RuntimeErrorController {

    @RequestMapping("/403.html")
    public String render403() {
        // Add model attributes
        return "patrimoine/public/error/403";
    }

    @RequestMapping("/404.html")
    public String render404() {
        // Add model attributes
        return "patrimoine/public/error/404";
    }

    @RequestMapping("/500.html")
    public String render500() {
        // Add model attributes
        return "patrimoine/public/error/500";
    }
}
