package strateknuc.lasec.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import strateknuc.lasec.Models.ProductModel;

@Controller
public class ProductController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model)
    {
        model.addAttribute("productModel", new ProductModel());
        return "/create";
    }

}
