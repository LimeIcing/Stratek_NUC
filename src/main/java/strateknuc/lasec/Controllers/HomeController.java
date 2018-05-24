package strateknuc.lasec.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for the most basic of mapping. Contains no initialized repositories as a result.
 * @author ECS, AP
 */
@Controller
public class HomeController {

    /**
     * GET request for index.html.
     * This is the mapping for the front page.
     * @return mapping for index.html.
     */
    // AUTHOR(S): AP
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    /**
     * GET request for admin/index.html.
     * This is the mapping for the admin's front page.
     * @return mapping for the version of index.html specific to admin use.
     */
    // AUTHOR(S):
    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String adminIndex() {
        return "/admin/index";
    }

    /**
     * Redirects to /admin/index when the "/index" part isn't present in the URL
     * @return mapping for the version of index.html specific to admin use.
     */
    // AUTHOR(S): ECS
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminIndexRedirect() {
        return "/admin/index";
    }
}