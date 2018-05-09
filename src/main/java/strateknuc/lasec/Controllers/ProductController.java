package strateknuc.lasec.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import strateknuc.lasec.Interfaces.ProductRepositoryInterface;
import strateknuc.lasec.Models.ProductModel;
import strateknuc.lasec.Models.Repositories.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepositoryInterface repositoryInterface = new ProductRepository();

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model)
    {
        model.addAttribute("productModel", new ProductModel());
        return "/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute ProductModel productModel)
    {
        repositoryInterface.createProduct(productModel);
        System.out.println(productModel.toString());
        return "redirect:/index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index()
    {
        return "/index";
    }

}
