package eu.kg.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String home() {
        return "redirect:/book";
    }

    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public String privateHome() {
        return "privatePage";
    }
}
