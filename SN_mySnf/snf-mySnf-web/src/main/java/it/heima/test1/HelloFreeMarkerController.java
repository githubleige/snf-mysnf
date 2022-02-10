package it.heima.test1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloFreeMarkerController {

    @RequestMapping("/helloFreeMarker.jsp")
    public String helloFreeMarker(Model model) {
        model.addAttribute("name","ITDragon博客");
        return "hello";
    }

    @RequestMapping("/helloFreeMarker")
    public String helloFreeMarker1(Model model) {
        model.addAttribute("name","ITDragon博客");
        return "hello";
    }

}
