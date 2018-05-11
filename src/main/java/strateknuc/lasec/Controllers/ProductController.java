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

    //this finds and creates beans
    //AUTHOR: AP
    @Autowired
    private ProductRepositoryInterface repositoryInterface = new ProductRepository();

    //AUTHOR: AP
    //create.html GET REQUEST
    //this is called when the create.html file gets refreshed
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model)
    {
        model.addAttribute("productModel", new ProductModel());
        return "/create";
    }

    //AUTHOR: AP
    //create.html POST REQUEST
    //this is called when a form="action" method="POST" is called
    //i.e when a button gets pressed and sends data further
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute ProductModel productModel)
    {
        repositoryInterface.createProduct(productModel);
        //redirect is used to switch pages
        return "redirect:/status";
    }

    //AUTHOR: AP
    //index.html GET REQUEST
    //this is called when index is refreshed
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index()
    {
        return "/index";
    }

    //AUTHOR: AP
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String returnCreateProduct()
    {
        repositoryInterface.getReturnSuccesfully();
        return "status";
    }

}
