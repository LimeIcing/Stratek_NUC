package strateknuc.lasec.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    // AUTHOR(S): AP
    // index.html GET REQUEST
    // this is called when index is refreshed
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "/product/index", method = RequestMethod.GET)
    public String productIndex() {
        return "/product/index";
    }

    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String adminIndex()
    {
        return "/admin/index";
    }

    // AUTHOR(S): ECS
    // redirects to /admin/index when the "/index" part isn't present in the URL
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminIndexRedirect() {
        return "/admin/index";
    }
}
